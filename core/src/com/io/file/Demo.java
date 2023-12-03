package com.io.file;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Demo {
  public static void main(String[] args) {
    // ПОЛНЫЙ ПУТЬ К ФАЙЛУ
    //      on Windows:
    File javaExecutable = new File("C:\\jdk1.8\\bin\\java.exe");
    File netWorkFolder = new File("\\\\server\\share");

    //      on Unix:
    File lsExecutable = new File("/usr/bin/ls");

    //      Сборка пути
    String sourceDirName = "src";
    String mainFileName = "GuessNumberGame.java";
    String mainFilePath = sourceDirName + File.separator + mainFileName;
    // или
    //String mainFilePath = sourceDirName + File.separatorChar + mainFileName;
    // Будет подставлен разделитель в зависимости от ОС
    File mainFile = new File(sourceDirName, mainFileName);

    // АБСОЛЮТНЫЕ И ОТНОСИТЕЛЬНЫЕ ПУТИ
    File absoluteFile = new File("/usr/bin/java");
    absoluteFile.isAbsolute(); // true
    absoluteFile.getAbsolutePath(); // /usr/bin/java

    File relativeFile = new File("readme.txt");
    relativeFile.isAbsolute();  // false
    relativeFile.getAbsolutePath(); // /home/stepic/readme.txt
    relativeFile.getAbsoluteFile(); // return File

    // РАЗБОР ПУТИ
    File file = new File("/usr/bin/java");
    String path = file.getPath();       // /usr/bin/java
    String name = file.getName();       // java
    String parent = file.getParent();   // /usr/bin
    File parentFile = file.getParentFile();

    // ФАЙЛ ИЛИ ПАПКА
    File spec = new File("folder");
    boolean isDir = spec.isDirectory();
    if (isDir) {
      System.out.println("папка");
    } else {
      System.out.println("файл или не существует");

    }

    // КАНОНИЧЕСКИЕ ПУТИ
    // Задача: сравнить, указывают ли 2 экземпляра класса File
    // на один и тот же файл на диске
    // symlink - символьная ссылка
    // В каноническом пути разрешаются(приводятся) точки и символические ссылки
    // Приведя два пути к каноническому виду, их можно сравнивать как строки
    boolean result;
    File file1 = new File("./prj/../symlink.txt");
    File file2 = new File("symlink.txt");

    try {
      String canonicalPath1 = file1.getCanonicalPath();
      file1 = file1.getCanonicalFile();
      file2 = file2.getCanonicalFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (file1.equals(file2)) {
      System.out.println("Файлы одинаковые");
    }

    // ИЗВЛЕЧЕНИЕ ПУТИ К РОДИТЕЛЬСКОЙ ПАПКЕ
    File f = new File("file.txt");
    String parentPath = f.getParent();      // return null, т.к. путь относительный
    File parentFolder = f.getParentFile();  // return null, т.к. путь относительный

    f = new File("C:\\java\\file.txt)");
    parentPath = f.getParent();             // return "c:\java"
    parentFolder = f.getParentFile();       // return  c:\java

    // аргументом может быть путь к папке
    parentPath = parentFolder.getParent();          // return "c:\"
    parentFolder = parentFolder.getParentFile();    // return  c:\

    // аргументом может быть путь к корневой папке
    parentPath = parentFolder.getParent();          // return null
    parentFolder = parentFolder.getParentFile();    // return null

    // ПРЕОБРАЗОВАНИЕ ПУТЕЙ В URL И ОБРАТНО
    f = new File("file.txt");
    URL url = null;
    try {
      url = f.toURI().toURL();
    } catch (MalformedURLException ignored) {
    }

    f = (url != null) ? new File(url.getFile()) : null;
  }
}
