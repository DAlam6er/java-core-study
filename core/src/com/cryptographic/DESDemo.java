package com.cryptographic;

import javax.crypto.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class DESDemo {
  Cipher ecipher;
  Cipher dcipher;

  public DESDemo(SecretKey key)
      throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
    ecipher = Cipher.getInstance("DES");
    dcipher = Cipher.getInstance("DES");

    ecipher.init(Cipher.ENCRYPT_MODE, key);
    dcipher.init(Cipher.DECRYPT_MODE, key);
  }

  public static void main(String[] args) {
    try {
      // Создаём ключ шифрования
      SecretKey key =
          KeyGenerator.getInstance("DES").generateKey();

      // Передаём созданный ключ шифрования в конструктор
      DESDemo encrypter = new DESDemo(key);
      String encrypted = encrypter.encrypt("Проверка");
      String decrypted = encrypter.decrypt(encrypted);

      System.out.println("Расшифровано: " + decrypted);
    } catch (NoSuchAlgorithmException |
             NoSuchPaddingException |
             InvalidKeyException |
             IllegalBlockSizeException |
             BadPaddingException e) {
      System.err.println(e.getMessage());
    }
  }

  public String encrypt(String str)
      throws IllegalBlockSizeException, BadPaddingException {
    byte[] utf8 = str.getBytes(StandardCharsets.UTF_8);
    byte[] enc = ecipher.doFinal(utf8);
    return Base64.getEncoder().encodeToString(enc);
  }

  public String decrypt(String str)
      throws IllegalBlockSizeException, BadPaddingException {
    byte[] dec = Base64.getDecoder().decode(str);
    byte[] utf8 = dcipher.doFinal(dec);
    return new String(utf8, StandardCharsets.UTF_8);
  }
}
