package com.io.file;

import java.io.*;

/*
    Чтение файла, путь к которому вводится в консоли с клавиатуры
*/
// FROM specialist.sedykh
public class PrintFileWithSpecifiedPath {
  public static void main(String[] args) {
    try (BufferedReader br =
             new BufferedReader(new InputStreamReader(System.in));
         BufferedInputStream bis =
             new BufferedInputStream(new FileInputStream(br.readLine()))
    ) {
      StringBuilder sb = new StringBuilder();
      while (bis.available() > 0) {
        sb.append((char) bis.read());
      }
      System.out.println(sb);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
