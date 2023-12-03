package com.serialization.dmdev;

import java.io.*;
import java.nio.file.Path;

public class SerializationDemo {
  public static void main(String[] args) {
    Path path = Path.of("resources", "student.out");
    try {
      writeObject(path);
    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      readObject(path);
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static void writeObject(Path path) throws IOException {
    try (ObjectOutputStream objectOutputStream =
             new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
      Person sergey = new Person(26, "Sergey", Sex.MALE);
      objectOutputStream.writeObject(sergey);
    }
  }

  private static void readObject(Path path) throws IOException, ClassNotFoundException {
    try (ObjectInputStream objectInputStream = new ObjectInputStream(
        new FileInputStream(path.toFile()))) {
      Object object = objectInputStream.readObject();
      System.out.println(object);
    }
  }
}
