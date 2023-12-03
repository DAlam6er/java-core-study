package com.cryptographic;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.Scanner;

public final class PasswordComparer {
  public static final int MAX_FAILED_COUNT = 3;
  private String encrPass;
  private int failedCount = 0;

  private PasswordComparer() {
  }

  public PasswordComparer(String encrPass) {
    this(encrPass, false);
  }

  public PasswordComparer(String encrPass, boolean decode) {
    if (decode) {
      this.encrPass = new String(Base64.getDecoder().decode(encrPass));
    } else {
      this.encrPass = encrPass;
    }
  }

  public static void main(String[] args) {
    new PasswordComparer().createNewPassword();
  }

  // For testing purpose only
  private void createNewPassword() {
    System.out.print("Введите новый пароль: ");
    Scanner scanner = new Scanner(System.in);
    String userPassword = scanner.nextLine();
    String encrPassword = new String(PasswordEncryptor.encrypt(userPassword));

    PasswordComparer pasComp = new PasswordComparer(encrPassword);

    while (true) {
      try {
        System.out.print("Введите пароль повторно: ");
        userPassword = scanner.nextLine();
        if (pasComp.isEqual(userPassword)) {
          System.out.println("Пароль сохранён.");
          break;
        } else {
          System.out.println("Введённые пароли отличаются.");
        }
      } catch (IllegalAccessException e) {
        System.err.println(e.getMessage());
        break;
      }
    }
  }

  public synchronized boolean isEqual(String attempt) throws IllegalAccessException {
    boolean success;
    String encrAttempt = new String(PasswordEncryptor.encrypt(attempt));

    if (getFailedCount() >= MAX_FAILED_COUNT) {
      throw new IllegalAccessException("Достигнуто максимальное число неудачных попыток ввода пароля.");
    }

    success = MessageDigest.isEqual(encrPass.getBytes(), encrAttempt.getBytes());

    if (success) {
      resetFailedCount();
    } else {
      incrementFailedCount();
    }
    return success;
  }

  public int getFailedCount() {
    return failedCount;
  }

  private synchronized void resetFailedCount() {
    failedCount = 0;
  }

  private synchronized void incrementFailedCount() {
    failedCount++;
  }
}
