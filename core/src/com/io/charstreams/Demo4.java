package com.io.charstreams;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Demo4 {
  // public final class System
  //      public static final InputStream in = null;  // поток байт
  //      Если программе на вход подается текстовая информация,
  //      то удобно обернуть InputStream в InputStreamReader + BufferedReader:
  //          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  //      или сразу в Scanner:
  //          Scanner scanner = new Scanner(System.in)

  // в PrintStream можно выводить
  //      двоичные данные при помощи метода write
  //      текстовые данные при помощи методов print, println, printf
  //      public static final PrintStream out = null;
  //      public static final PrintStream err = null;

  // Перенаправления вывода в файл:
  public static void main(String[] args) throws FileNotFoundException {
    PrintStream sysOut =
        new PrintStream(new FileOutputStream("Debug.log"));
    PrintStream errOut =
        new PrintStream(new FileOutputStream("Error.log"));
    System.setOut(sysOut);
    System.setErr(errOut);
  }

}
