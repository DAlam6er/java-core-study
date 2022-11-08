package com.generics.headfirst.examples;

abstract class Animal
{
    void eat()
    {
        System.out.println("Животное ест.");
    }
}

class Dog extends Animal
{
    void bark() { }
}

class Cat extends Animal
{
    void meow() { }
}
