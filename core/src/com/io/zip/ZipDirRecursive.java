package com.io.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// Класс, отвечающий за архивацию папки со всеми её файлами и поддиректориями
public class ZipDirRecursive {
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Usage: java ZipDirRecursive <directory_name> <archive_name>");
      return;
    }

    String zippedDir = args[0];
    String zipFile = args[1];

    System.out.println("Начало архивации директории: " + zippedDir);
    try {
      ZipDirRecursive.exec(zippedDir, zipFile);
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  // метод открывает поток вывода в архив и передаёт его экземпляр методу walkingDir()
  public static void exec(String zippedDir, String zipFile) throws IOException {
    // поток для архивации потока вывода "на лету"
    // в качестве аргумента объект этого класса получает
    // экземпляр стандартного выходного потока в файл
    ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));
    walkingDir(zos, zippedDir);
    zos.close();
  }

  // метод рекурсивно перебирает дерево директорий,
  // начиная с директории, полученной в параметре zippedDir
  // и копирует в архив все обычные файлы
  private static void walkingDir(ZipOutputStream zos, String zippedDir) {
    File zipDir = new File(zippedDir);
    String[] dirList = zipDir.list();

    for (int i = 0; i < dirList.length; i++) {
      File file = new File(dirList[i]);
      if (file.isDirectory()) {
        String filePath = file.getPath();
        walkingDir(zos, filePath);
      } else {
        try {
          byte[] readBuffer = new byte[2048];
          int bytesRead;
          String fullPath = zippedDir + File.separator + file.getPath();

          System.out.println("\tархивируется " + fullPath);
          FileInputStream fis = new FileInputStream(fullPath);
          // ZipEntry представляет собой элемент архива
          ZipEntry ze = new ZipEntry(fullPath);
          // Связываем поток ввода из файла с потоком вывода в архив
          zos.putNextEntry(ze);
          // Последовательно читаем содержимое файла в байтовый массив-буфер
          // и записываем содержимое буфера в поток вывода
          while ((bytesRead = fis.read(readBuffer)) != -1) {
            zos.write(readBuffer, 0, bytesRead);
          }
          fis.close();
        } catch (IOException e) {
          System.err.println(e.getMessage());
        }
      }
    }
  }
}
