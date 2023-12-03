package com.serialization.headfirst;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Box implements Serializable {
  private int width;
  private int height;

  public static void main(String[] args) {
    Box myBox = new Box();
    myBox.setWidth(50);
    myBox.setHeight(20);

    try (FileOutputStream fs = new FileOutputStream("foo.ser");
         ObjectOutputStream os = new ObjectOutputStream(fs)) {
      os.writeObject(myBox);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public void setHeight(int height) {
    this.height = height;
  }
}
