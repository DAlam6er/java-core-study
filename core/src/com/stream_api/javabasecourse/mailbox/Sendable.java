package com.stream_api.javabasecourse.mailbox;

public interface Sendable<T>
{
    String getFrom();
    String getTo();
    T getContent();
}
