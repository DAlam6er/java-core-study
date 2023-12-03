package com.io.xmlparsing.stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;

public class StaxStreamProcessor implements AutoCloseable {
  private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();

  private final XMLStreamReader reader;

  public StaxStreamProcessor(InputStream is) throws XMLStreamException {
    // будем работать со StAX через низкоуровневое API, возвращающее примитивы
    // расходует меньше памяти
    reader = FACTORY.createXMLStreamReader(is);
  }

  public XMLStreamReader getReader() {
    return reader;
  }

  public boolean scanAllUntil(int stopEvent, String value) throws XMLStreamException {
    while (reader.hasNext()) {      // while not end of XML
      int event = reader.next();
      if (event == stopEvent && value.equals(reader.getLocalName())) {
        return true;
      }
    }
    return false;
  }

  public boolean scanWithConditionUntil(int stopEvent, String value, String condition)
      throws XMLStreamException {
    var splitted = condition.split("=");
    while (reader.hasNext()) {
      int event = reader.next();

      if (event == stopEvent &&
          value.equals(reader.getLocalName()) &&
          isExistAttribute(splitted[0]) &&
          splitted[1].equals(getAttribute(splitted[0]))) {
        return true;
      }
    }
    return false;
  }

  public boolean isExistAttribute(String name) {
    return getAttributeIndex(name) != -1;
  }

  public String getAttribute(String name) {
    return reader.getAttributeValue(null, name);
  }

  public int getAttributeIndex(String name) {
    for (int i = 0; i < reader.getAttributeCount(); i++) {
      if (name.equals(reader.getAttributeLocalName(i))) {
        return i;
      }
    }
    return -1;
  }

  // метод сканирует XML либо до конца тега родителя, либо до заданного элемента
  public boolean startElement(String element, String parent) throws XMLStreamException {
    while (reader.hasNext()) {
      int event = reader.next();
      if (parent != null && event == XMLEvent.END_ELEMENT &&
          parent.equals(reader.getLocalName())) {
        return false;
      }
      if (event == XMLEvent.START_ELEMENT &&
          element.equals(reader.getLocalName())) {
        return true;
      }
    }
    return false;
  }

  public String getText() throws XMLStreamException {
    return reader.getElementText();
  }

  @Override
  public void close() throws Exception {
    if (reader != null) {
      try {
        reader.close();
      } catch (XMLStreamException ex) {
        ex.printStackTrace();
      }
    }
  }
}
