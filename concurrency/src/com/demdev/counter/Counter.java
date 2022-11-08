package com.demdev.counter;

/**
 * 1. Создать класс Counter с одним полем:
 * private int count;
 *
 * Добавить методы:
 * - getCount() - для получение поля count
 * - increment() - для увеличения значения поля на единицу
 * - decrement() - для уменьшения значения поля на единицу
 */
public class Counter
{
    private int count;
    private static String description;

    public void increment()
    {
        // более гибкий подход
        synchronized (this) {
            count++;
        }
    }

    public static void init()
    {
        synchronized (Counter.class) {
            if (description == null) {
                description = "Test description";
            }
        }
    }

    // сразу видно, что метод синхронизированный, автодокументированный
    public synchronized void decrement()
    {
        count--;
    }

    public int getCount()
    {
        return count;
    }
}
