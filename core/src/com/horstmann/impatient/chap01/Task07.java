package com.horstmann.impatient.chap01;

import java.util.Scanner;

/**
 * Напишите программу, вводящую 2 числа в пределах от 0 до 65535, сохраняющую их в переменных типа short
 * и вычисляющую их сумму, разность, произведение, частное и остаток без знака,
 * не преобразуя эти величины в тип int
 */
public class Task07 {
  public static void main(String[] args) {
    System.out.println("Введите 2 числа в диапазоне от 0 до 65535: ");
    var scanner = new Scanner(System.in);
    var firstString = scanner.nextLine();
    var secondString = scanner.nextLine();

    short first = (short) Integer.parseUnsignedInt(firstString);
    short second = (short) Integer.parseUnsignedInt(secondString);

    short sum = (short) (first + second);
    short dif = (short) (first - second);

    short product = (short) (Short.toUnsignedInt(first) * Short.toUnsignedInt(second));
    short quotient = (short) (Short.toUnsignedInt(first) / Short.toUnsignedInt(second));
    short remainder = (short) (Short.toUnsignedInt(first) % Short.toUnsignedInt(second));

    System.out.println("Первое число, приведенное к short: " + first);
    System.out.println("Второе число, приведенное к short: " + second);
    System.out.println("Сумма чисел, без приведения к беззнаковому целому: " + sum);
    System.out.println("Сумма чисел, приведенная к беззнаковому целому: " + Short.toUnsignedInt(sum));
    System.out.println("Разность чисел, без приведения к беззнаковому целому: " + dif);
    System.out.println("Разность чисел: " + Short.toUnsignedInt(dif));
    System.out.println("Произведение чисел, без приведения к беззнаковому целому: " + product);
    System.out.println("Произведение чисел: " + Short.toUnsignedInt(product));
    System.out.println("Частное чисел, без приведения к беззнаковому целому: " + quotient);
    System.out.println("Частное чисел: " + Short.toUnsignedInt(quotient));
    System.out.println("Остаток от деления чисел, без приведения к беззнаковому целому: " + remainder);
    System.out.println("Остаток от деления чисел: " + Short.toUnsignedInt(remainder));
  }
}
