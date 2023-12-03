package com.io.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

// FROM java on examples
public class RandomAccessFileDemo {
  public static void main(String[] args) {
    File file = new File("file.txt");
    try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {

      // чтение первого символа файла
      char ch = raf.readChar();

      // переход к концу файла
      raf.seek(file.length());

      // запись в конец файла
      raf.writeChars("The End");
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }
}
