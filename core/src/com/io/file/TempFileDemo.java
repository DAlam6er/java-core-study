package com.io.file;

import java.io.File;
import java.io.IOException;

// FROM java on examples
public class TempFileDemo {
  // метод создаёт файл в общей для всех программ папке для временных файлов
  // windows: %USERPROFILE%\AppData\Local\Temp
  // unix: /tmp или /var/tmp
  // есть перегруженный метод с тремя параметрами, третий параметр - отвечает за папку
  public static File createTempFile(String prefix, String suffix) {
    File file = null;
    try {
      file = File.createTempFile(prefix, suffix);
      // файл будет удален при выходе из программы
      // метод следует использовать с осторожностью
      file.deleteOnExit();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
    return file;
  }
}
