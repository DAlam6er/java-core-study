package com.horstmann.impatient.chap03.task05;

/**
 * Реализуйте статический метод constant() из интерфейса IntSequence,
 * возвращающий бесконечную последовательность констант. Например,
 * в результате вызова IntSequence.constant(1) возвращается бесконечная последовательность
 * 1 1 1 1 1 ... В качестве дополнительного задания сделайте то же самое с помощью
 * лямбда-выражения.
 */
public class Task05 {
  public static void main(String[] args) {
    IntSequence intSeq = IntSequence.constant(1);
  }
}
