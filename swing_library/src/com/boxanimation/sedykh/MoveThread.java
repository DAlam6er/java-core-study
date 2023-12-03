package com.boxanimation.sedykh;

// Класс для анимации кубика
public class MoveThread implements Runnable {
  private final Thread self;
  private final JFrameBox frame;
  private int delay;

  public MoveThread(int delay, JFrameBox frame) {
    this.delay = delay;
    this.frame = frame;
    self = new Thread(this, "BoxMoveThread");
  }

  public int getDelay() {
    return delay;
  }

  public void setDelay(int delay) {
    this.delay = delay;
  }

  public void start() {
    self.start();
  }

  public void stop() {
    self.interrupt();
  }

  @Override
  public void run() {
    try {
      while (true) {
        frame.moveBox();
        Thread.sleep(delay);
      }
    } catch (InterruptedException ignored) {
    }
  }
}
