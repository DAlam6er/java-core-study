package com.io.file;

import java.io.*;

// FROM java on examples
public class Grep extends FilterInputStream {
  String substring;
  BufferedReader br;

  public Grep(InputStream is, String substring) {
    super(is);
    this.br = new BufferedReader(new InputStreamReader(in));
    this.substring = substring;
  }

  public static void main(String[] args) {
    if ((args.length == 0) || (args.length > 2)) {
      System.out.println("Usage: java Grep <pattern> <file_name>");
      return;
    }
    try (FileInputStream fis = new FileInputStream(args[1])) {
      Grep grep = new Grep(fis, args[0]);

      String line;
      for (; ; ) {
        line = grep.readline();
        if (line == null) break;
        System.out.println("found: " + line);
      }
      grep.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public final String readline() throws IOException {
    String line;
    do {
      line = br.readLine();
    } while ((line != null) && (!line.contains(substring)));
    return line;
  }
}
