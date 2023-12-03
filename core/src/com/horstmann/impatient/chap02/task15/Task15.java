package com.horstmann.impatient.chap02.task15;

/**
 * Реализуйте полностью класс Invoice. Предоставьте метод, выводящий счет-фактуру,
 * и демонстрационную версию программы, составляющей и выводящей образец счета-фактуры
 */
public class Task15 {
  public static void main(String[] args) {
    Invoice invoice = new Invoice();
    invoice.addItem("Nec LCD display", 2, 100);
    invoice.addItem("PC", 1, 300);
    invoice.print();
  }
}
