package com.logging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadExternalInput {
  String cmd;
  Process proc;
  InputStream input;
  BufferedReader in;

  public ReadExternalInput(String cmd) {
    this.cmd = cmd;
    try {
      proc = Runtime.getRuntime().exec(cmd);
      input = proc.getInputStream();
      in = new BufferedReader(new InputStreamReader(input));
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  public static void main(String[] args) {
    String cmd;
    ReadExternalInput rei;
    if (args.length > 0) {
      cmd = args[0];
    } else {
      cmd = "ping localhost";
    }

    rei = new ReadExternalInput(cmd);
    String line;
    StringBuilder sb = new StringBuilder();
    while ((line = rei.readLine()) != null) {
      sb.append(line).append("\n");
    }
    System.out.println("java>" + sb);
    rei.close();
  }

  public String readLine() {
    String line = null;
    try {
      line = in.readLine();
      while (("\r".equals(line)) | ("".equals(line))) {
        line = in.readLine();
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
    return line;
  }

  public void close() {
    try {
      in.close();
      input.close();
      proc.destroy();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    } finally {
      in = null;
      input = null;
      proc = null;
    }
  }
}
