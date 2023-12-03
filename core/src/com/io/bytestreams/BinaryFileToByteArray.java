package com.io.bytestreams;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

// FROM java on examples
public class BinaryFileToByteArray {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(readBinaryFile("D:\\test.txt")));
  }

  public static byte[] readBinaryFile(String filePath) {
    File file = new File(filePath);
    byte[] bytes = null;
    try (InputStream is = new FileInputStream(file)) {
      long length = file.length();
      // нельзя создать байтовый массив с количеством элементов,
      // большим чем Integer.MAX_VALUE
      // Если размер файла в байтах больше этого значения, - его нельзя прочитать
      if (length > Integer.MAX_VALUE) {
        throw new IOException("File " + file.getName() + " is too big");
      }

      bytes = new byte[(int) length];

      int offset = 0;
      int numRead = 0;
      while ((offset < bytes.length) && (numRead >= 0)) {
        numRead = is.read(bytes, offset, bytes.length - offset);
        offset += numRead;
      }

      // Проверка, пройден ли файл до конца
      if (offset < bytes.length) {
        throw new IOException("Couldn't read whole file " + file.getName());
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
    return bytes;
  }
}
