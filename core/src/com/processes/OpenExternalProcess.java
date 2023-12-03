package com.processes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class OpenExternalProcess {
  public static void main(String[] args) {
    String appName;
    boolean win = System.getProperty("os.name").toLowerCase().startsWith("win");

    if (win) {
      appName = "ping localhost";
    } else {
      appName = "ping google.com";
    }

    try {
      Process proc = Runtime.getRuntime().exec(appName);
      InputStream is = proc.getInputStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(is));
      String line;
      StringBuilder sb = new StringBuilder();
      while ((line = br.readLine()) != null) {
        sb.append(line).append("\n");
      }
      System.out.println("java>" + sb);
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }
}
