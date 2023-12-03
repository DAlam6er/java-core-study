package com.io.xmlparsing;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

/*
    Спецификация DOM представляет файл, размеченный тегами XML,
    в виде документа, состоящего из дерева УЗЛОВ.
    Каждый из узлов может содержать кроме ДОЧЕРНИХ УЗЛОВ,
    ещё и ИМЕНОВАННЫЕ АТРИБУТЫ.
 */
public class XmlToDOM {
  private static File destFile;

  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Usage: java XmlToDOM <src_file> <dest_file>");
      return;
    }

    //private static PrintWriter writer;
    File srcFile = new File(args[0]);
    destFile = new File(args[1]);

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setIgnoringComments(true);

    try {
      // DocumentBuilder - грамматический анализатор (разборщик, парсер)
      // получаем парсер из фабрики
      // DocumentBuilder генерирует DOM-документ
      DocumentBuilder builder = factory.newDocumentBuilder();
      // разбор входного файла
      // у метода parse() есть перегруженные варианты
      // в него можно передать любой поток ввода, созданный на базе InputStream,
      // либо URL в форме строки, либо класс InputSource интерфейса SAX
      Document document = builder.parse(srcFile);
      // получаем доступ к корневому узлу древовидной структуры узлов и атрибутов документа DOM
      Node rootNode = document.getDocumentElement();
      // печать разобранного документа
      convert(rootNode, 0);
    } catch (ParserConfigurationException | IOException |
             SAXException e) {
      System.err.println(e.getMessage());
    }
  }

  // вывод отступа для разделения уровней
  private static void printIndentation(Writer writer, int level)
      throws IOException {
    // отступ равен 3 пробелам * номер уровня
    for (int i = 0; i < level; i++) {
      writer.write("   ");
    }
  }

  // ПЕЧАТЬ СОДЕРЖИМОГО УЗЛА
  private static void convert(Node node, int level)
      throws IOException {
    PrintWriter writer = new PrintWriter(new FileWriter(destFile, true));
    // для каждого последующего уровня выводится пустая строка и отступ
    if (level > 0) {
      writer.write("\n");
      printIndentation(writer, level);
    }

    // ВЫВОД ИМЕНИ УЗЛА
    writer.write(node.getNodeName() + ":");

    // ВЫВОД АТРИБУТОВ УЗЛА (при наличии)
    if (node.hasAttributes()) {
      StringBuilder sb = new StringBuilder();
      NamedNodeMap attributes = node.getAttributes();
      if (attributes.getLength() > 0) {
        // атрибуты - это следующий уровень
        level++;
        for (int i = 0; i < attributes.getLength(); i++) {
          Node attribute = attributes.item(i);
          // вывод после отступа имени и значения атрибута
          printIndentation(writer, level);
          sb.append(".").append(attribute.getNodeName())
              .append("=").append(attribute.getNodeValue());
          writer.write(sb.toString());
          sb.setLength(0);
        }
        // уровень закончился
        level--;
      }
    }

    // ВЫВОД ЗНАЧЕНИЯ УЗЛА, если оно не пустое
    String value = node.getNodeValue();
    value = (value == null) ? "" : value.trim();
    if (value.length() > 0) {
      printIndentation(writer, level);
      writer.write(value);
    }

    // ПЕЧАТЬ ДОЧЕРНИХ УЗЛОВ (при наличии)
    if (node.hasChildNodes()) {
      // дочерние узлы - это следующий уровень
      level++;
      NodeList children = node.getChildNodes();
      writer.flush();
      for (int i = 0; i < children.getLength(); i++) {
        Node child = children.item(i);
        convert(child, level);
      }
    }
    writer.close();
  }
}
