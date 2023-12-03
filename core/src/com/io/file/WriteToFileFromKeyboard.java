package com.io.file;

import java.io.*;

// FROM specialist.sedykh
public class WriteToFileFromKeyboard {
  public static void main(String[] args) {
        /*
            Запись в файл с клавиатуры с использованием BufferedOutputStream
         */
        /*
        try (BufferedReader br =
                 new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos =
            new BufferedOutputStream(new FileOutputStream(br.readLine()))
        )
        {
            while (true) {
                String line = br.readLine() + System.lineSeparator();
                byte[] buffer = line.getBytes();
                bos.write(buffer, 0, buffer.length);
                if (("exit" + System.lineSeparator()).equals(line)) break;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         */

        /*
            Запись в файл с клавиатуры с использованием BufferedWriter
         */
    try (BufferedReader br =
             new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw =
             new BufferedWriter(new FileWriter(br.readLine()))
    ) {
      while (true) {
        String line = br.readLine() + System.lineSeparator();
        if (("exit" + System.lineSeparator()).equals(line)) break;
        bw.write(line);
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    // Чтобы дописать строки к существующему файлу,
    // нужно создать объект FileWriter другим конструктором,
    // передав ему true в качестве второго аргумента:
    // BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));

    // Чтобы можно было записывать в файл символы в другой кодировке,
    // следует создать следующую конструкцию:
    // BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
    //      new FileOutputStream("file.txt"), "8859_5"));
  }
}
