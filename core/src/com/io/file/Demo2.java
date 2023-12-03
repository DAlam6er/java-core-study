package com.io.file;

import java.io.File;
import java.io.IOException;

public class Demo2 {
  public static void main(String[] args) {
    // РАБОТА С ФАЙЛАМИ
    //      ПРОВЕРКА СУЩЕСТВОВАНИЯ
    // Существование объекта File не привязано к существованию файла на диске
    // Конструктор File ничего на диске не создает
    // т.о. путь может указывать на несуществующий файл или директорию
    File java = new File("/usr/bin/java");
    java.exists();      // true
    java.isFile();      // true
    java.isDirectory(); // false
    //      ПРОСМОТР СВОЙСТВ ФАЙЛА
    java.length();      // 1536L (если файл не существует ИЛИ пустой - 0L)
    java.lastModified();// 1231914805000L (в мс с 1 января 1970 г)
    long timeNow = System.currentTimeMillis();
    java.setLastModified(timeNow);  // return true (если изменение прошло успешно)

    // РАБОТА С ДИРЕКТОРИЯМИ
    //      ПРОВЕРКА СУЩЕСТВОВАНИЯ
    File usrbin = new File("/usr/bin");
    usrbin.exists();
    usrbin.isFile();
    usrbin.isDirectory();   // true
    //      СОДЕРЖИМОЕ ДИРЕКТОРИИ
    // только на 1 уровень (null если она не существует)
    usrbin.list();        // String[]
    usrbin.listFiles();     // File[]

    // ФИЛЬТРАЦИЯ ФАЙЛОВ
    // java.io.FileFilter
    //      boolean accept(File pathname);
    // java.io.FilenameFilter
    //      boolean accept(File dir, String name);
    // Фильтр, реализующий FileFilter или FilenameFilter:
    //      f -> f.getName().endsWith(".java")
    File[] javaSourceFiles = usrbin.listFiles(f -> f.getName().endsWith(".java"));

    // СОЗДАНИЕ ФАЙЛА
    // используется редко, чаще всего не просто создаем файл. а пишем в него
    // гарантируется атомарность операции
    File file = new File("~/.aliases");
    try {
      boolean success = file.createNewFile();
    } catch (IOException e) {
      // handle error
    }

    // СОЗДАНИЕ ДИРЕКТОРИИ
    File dir = new File("a/b/c/d");
    boolean success = dir.mkdir();      // максимум 1 директория
    boolean success2 = dir.mkdirs();    // создает все уровни вложенности

    // УДАЛЕНИЕ ФАЙЛА ИЛИ ДИРЕКТОРИИ (ОНА ОБЯЗАНА БЫТЬ ПУСТОЙ)
    boolean success3 = file.delete();

    // ПЕРЕИМЕНОВАНИЕ/ПЕРЕМЕЩЕНИЕ (платформозависимое перемещение!)
    // targetFile - имя нового файла
    File targetFile = new File("~/.config/.aliases");
    boolean success4 = file.renameTo(targetFile);

    // МЕТОДА КОПИРОВАНИЯ ИЗ КОРОБКИ НЕТ!!!
  }
}
