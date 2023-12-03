package com.io.file;

import java.io.File;

// FROM java on examples
public class RecursiveDelete {
  public static void deleteDir(String dirPath) {
    File walkDir = new File(dirPath);       // удаляемая директория
    String[] dirList = walkDir.list();      // список элементов в директории

    for (int i = 0; i < dirList.length; i++) {
      File f = new File(dirList[i]);
      if (f.isDirectory()) {
        deleteDir(f.getPath());
      }
      // текущий элемент - файл или уже пустая папка
      f.delete();
    }
    walkDir.delete();
  }
}
