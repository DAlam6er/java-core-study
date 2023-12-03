package com.horstmann.impatient.chap03.task04;

/**
 * Реализуйте статический метод of() из интерфейса IntSequence, возвращающий последовательность
 * из передаваемых ему аргументов. Например, в результате вызова метода
 * IntSequence.of(3, 1, 4, 1, 5, 9) возвращается последовательность из шести значений.
 * В качестве дополнительного задания организуйте возврат экземпляра анонимного внутреннего класса.
 */
public class Task04 {
  public static void main(String[] args) {
    IntSequence intSequence = IntSequence.of(3, 1, 4, 1, 5, 9);
    System.out.println(intSequence);
  }
}
