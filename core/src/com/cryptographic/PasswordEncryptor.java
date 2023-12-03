package com.cryptographic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class PasswordEncryptor {
  public static void main(String[] args) {
    String password = "Корова";
    String encrypted = new String(encrypt(password));
    String encoded = encryptAndEncode(password);
    System.out.println(Arrays.toString(password.getBytes()));
    System.out.println("Encrypted password: " + encrypted);
    System.out.println("Encoded   password: " + encoded);
  }

  /**
   * @param password string to be encrypted
   * @return encrypted string, using SHA-1 algorithm
   */
  public static byte[] encrypt(String password) {
    return encrypt(password, "SHA-1");
  }

  public static String encryptAndEncode(String password) {
    return encryptAndEncode(password, "SHA-1");
  }

  public static byte[] encrypt(String password, String algorithm) {
    try {
      // Получаем экземпляр MessageDigest, передавая ему название используемого алгоритма
      MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
      // Передаем пароль, на его основе будет сгенерирован хеш-ключ
      messageDigest.update(password.getBytes());
      // Получаем хеш-ключ в виде массива байтов
      return messageDigest.digest();
    } catch (NoSuchAlgorithmException e) {
      System.err.println(e.getMessage());
    }
    return null;
  }

  // Преобразование результата кодировки по алгоритму Base64
  // устранение непечатаемых символов
  public static String encryptAndEncode(String password, String algorithm) {
    return Base64.getEncoder().encodeToString(encrypt(password, algorithm));
  }
}
