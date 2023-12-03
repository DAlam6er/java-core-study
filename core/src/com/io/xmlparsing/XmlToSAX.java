package com.io.xmlparsing;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;

// Работа парсера модели SAX (Simple API for XML) основана на событиях:
//  - появление тега, открывающего или закрывающего узел;
//  - появление текста в теле узла
// Результатом разбора документа является не дерево в памяти (см. DOM),
// а отдельный его узел - удобнее для последовательной обработки XML-файла,
// т.к. менее затратно для ОЗУ
public class XmlToSAX extends DefaultHandler {
  private static Writer writer;

  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Usage: java XmlToSAX <src_file> <dest_file>");
      return;
    }

    File srcFile = new File(args[0]);
    File destFile = new File(args[1]);
    try {
      writer = new PrintWriter(new FileWriter(destFile, true));
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }

    // получение экземпляра фабрики классов
    SAXParserFactory factory = SAXParserFactory.newInstance();
    try {
      // получение парсера из фабрики классов
      SAXParser parser = factory.newSAXParser();
      // грамматический анализ входного файла
      parser.parse(srcFile, new XmlToSAX());
      writer.close();
    } catch (ParserConfigurationException | IOException |
             SAXException e) {
      System.err.println(e.getMessage());
    }
  }

  // реализация методов-обработчиков событий, объявленных в классе DefaultHandler
  // метод вызывается в начале чтения документа
  @Override
  public void startDocument() {
    try {
      writer.write("Начало документа");
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  // метод вызывается в конце чтения документа
  @Override
  public void endDocument() {
    try {
      writer.write("\n");
      writer.write("Конец документа");
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  // метод вызывается в начале обработки элемента (т.е. при появлении открывающего тега)
  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) {
    try {
      writer.write("\n");
      writer.write("   Начало " + qName);
      StringBuilder sb = new StringBuilder();
      // вывод атрибутов (при наличии)
      if (attributes.getLength() > 0) {
        for (int i = 0; i < attributes.getLength(); i++) {
          sb.append("      .").append(attributes.getQName(i))
              .append("=").append(attributes.getValue(i));
          writer.write(sb.toString());
        }
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  // метод вызывается в конце обработки элемента (т.е. при появлении закрывающего тега)
  @Override
  public void endElement(String uri, String localName, String qName) {
    try {
      writer.write(" Конец " + qName);
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  // метод вызывается при чтении текстового содержимого элемента
  @Override
  public void characters(char[] data, int start, int length) {
    StringBuilder sb = new StringBuilder(length);
    sb.append(data, start, length);
    try {
      if (sb.toString().trim().length() > 0) {
        writer.write(" " + sb);
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }
}
