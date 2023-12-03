package com.io.xmlparsing.stax;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;

public class StaxParser {
  private static final String XML_TO_PARSE = "D:\\prog\\VBA\\Projects\\Addresses\\AS_HOUSES_PARAMS_20221208_92c0d98c-d50c-4804-be71-b1748ff7f2db.XML";
  private static final String DELIMITER = ",";
  private static final String DESTINATION_CSV = "D:\\prog\\VBA\\Projects\\Addresses\\indices.csv";

  public static void main(String[] args) {
    var destPath = Paths.get(DESTINATION_CSV);
    try (StaxStreamProcessor processor = new StaxStreamProcessor(
        Files.newInputStream(Paths.get(XML_TO_PARSE)))) {
      XMLStreamReader reader = processor.getReader();
      String header = String.format("%s,%s,%s\n", "OBJECTID", "POSTAL_CODE", "ENDDATE");
      Files.writeString(destPath, header);
      while (processor.scanWithConditionUntil(XMLEvent.START_ELEMENT, "PARAM", "TYPEID=5")) {
        String data = String.format("%s%s%s%s%s\n", processor.getAttribute("OBJECTID"),
            DELIMITER,
            processor.getAttribute("VALUE"),
            DELIMITER,
            processor.getAttribute("ENDDATE"));
        Files.writeString(destPath, data, APPEND);
      }
    } catch (XMLStreamException e) {
      System.err.println("Processing error!");
      throw new RuntimeException(e);
    } catch (IOException e) {
      System.err.println("File not found!");
      throw new RuntimeException(e);
    } catch (Exception e) {
      System.err.println(e.getMessage());
      throw new RuntimeException(e);
    }
  }
}
