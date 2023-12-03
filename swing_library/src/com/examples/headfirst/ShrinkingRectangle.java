package com.examples.headfirst;

import javax.swing.*;
import java.awt.*;

public class ShrinkingRectangle {
  int x = 1;
  int y = 1;

  public static void main(String[] args) {
    ShrinkingRectangle gui = new ShrinkingRectangle();
    gui.go();
  }

  public void go() {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    MyDrawP drawP = new MyDrawP();
    frame.getContentPane().add(drawP);
    frame.setSize(500, 270);
    frame.setVisible(true);
    for (int i = 0; i < 124; i++, x++, y++) {
      x++;
      drawP.repaint();
      try {
        Thread.sleep(50);
      } catch (Exception ignored) {
      }
    }
  }

  class MyDrawP extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
      g.setColor(Color.white);
      g.fillRect(0, 0, 500, 250);
      g.setColor(Color.blue);
      g.fillRect(x, y, 500 - x * 2, 250 - y * 2);
    }
  }
}
