package com.streamapi.javabasecourse.mailbox;

public class MailMessage extends SimpleSendable<String> {
  public MailMessage(String from, String to, String content) {
    super(from, to, content);
  }
}
