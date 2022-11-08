package com.specialist.sedykh.publisher_subscriber.file_monitor.client;

import com.specialist.sedykh.publisher_subscriber.file_monitor.FSMonitor;

public class FSClient implements FSMonitor
{

    @Override
    public void event(String fName, int kind)
    {
        switch (kind) {
            case FSMonitor.CREATE ->
                System.out.println("Client: File created: " + fName);
            case FSMonitor.REMOVE ->
                System.out.println("Client: File removed: " + fName);
            default ->
                System.out.println("Client: Unknown event!");
        }
    }
}
