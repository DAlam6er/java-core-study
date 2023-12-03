package com.io.xmlparsing;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XSLTTransform {
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Usage: java XSLTTransform <src_file.xsl> <src_file.xml>");
      return;
    }
    // XSL (XML StyleSheet Language) file
    File xslFile = new File(args[0]);
    // XML (eXtensible Markup Language) file
    File xmlFile = new File(args[1]);

    // создание входных и выходного потока
    StreamSource xslSource = new StreamSource(xslFile);
    StreamSource xmlSource = new StreamSource(xmlFile);
    StreamResult outResult = new StreamResult(System.out);

    try {
      TransformerFactory factory = TransformerFactory.newInstance();
      Transformer transformer = factory.newTransformer(xslSource);

      // трансформация XML-документа
      transformer.transform(xmlSource, outResult);
    } catch (TransformerException e) {
      System.err.println(e.getMessage());
    }
  }
}
