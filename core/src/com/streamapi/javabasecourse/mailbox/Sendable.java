package com.streamapi.javabasecourse.mailbox;

public interface Sendable<T> {
  String getFrom();

  String getTo();

  T getContent();
}
