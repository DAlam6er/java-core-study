package com.specialist.sedykh.publisher_subscriber.file_monitor;

public interface FSMonitor
{
    int CREATE = 1; // именованная константа
    int REMOVE = 2;

    void event(String fName, int kind );
}
