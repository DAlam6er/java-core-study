package com.io.charstreams;

import java.io.Console;

public class ReadPasswordFromConsole {
  public static void main(String[] args) {
    Console terminal = System.console();
    String userName = terminal.readLine("User name: ");
    char[] passwd = terminal.readPassword("Password: ");
  }
}