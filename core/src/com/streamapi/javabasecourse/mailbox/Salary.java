package com.streamapi.javabasecourse.mailbox;

public class Salary extends SimpleSendable<Integer> {
  public Salary(String from, String to, Integer content) {
    super(from, to, content);
  }
}
