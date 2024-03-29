package com.midiplayers.headfirst;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicPlayer3 {
  static JFrame f = new JFrame("Мой первый музыкальный клип");
  static MyDrawPanel ml;

  public static void main(String[] args) {
    MiniMusicPlayer3 mini = new MiniMusicPlayer3();
    mini.go();
  }

  public void go() {
    setUpGui();
    try {
      Sequencer sequencer = MidiSystem.getSequencer();
      sequencer.open();
      sequencer.addControllerEventListener(ml, new int[]{127});
      Sequence seq = new Sequence(Sequence.PPQ, 4);
      Track track = seq.createTrack();

      int r;
      for (int i = 0; i < 60; i += 4) {
        r = (int) ((Math.random() * 50) + 1);
        track.add(makeEvent(144, 1, r, 100, i));
        track.add(makeEvent(176, 1, 127, 0, i));
        track.add(makeEvent(128, 1, r, 100, i + 2));
      }

      sequencer.setSequence(seq);
      sequencer.start();
      sequencer.setTempoInBPM(120);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void setUpGui() {
    ml = new MyDrawPanel();
    f.setContentPane(ml);
    f.setBounds(30, 30, 300, 300);
    f.setVisible(true);
  }

  public MidiEvent makeEvent(
      int comd, int chan, int one, int two, int tick) {
    MidiEvent event = null;
    try {
      ShortMessage a = new ShortMessage();
      a.setMessage(comd, chan, one, two);
      event = new MidiEvent(a, tick);
    } catch (Exception ignored) {
    }
    return event;
  }

  // Панель для рисования - это слушатель
  static class MyDrawPanel extends JPanel implements ControllerEventListener {
    boolean msg = false;

    @Override
    public void controlChange(ShortMessage event) {
      // было получено событие
      msg = true;
      repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
      // Используем флаг, т.к. другие объекты могут запускать repaint()
      // а мы хотим рисовать только тогда,
      // когда произойдёт событие ControllerEvent
      if (msg) {
        int red = (int) (Math.random() * 250);
        int green = (int) (Math.random() * 250);
        int blue = (int) (Math.random() * 250);

        g.setColor(new Color(red, green, blue));

        int height = (int) ((Math.random() * 120) + 10);
        int width = (int) ((Math.random() * 120) + 10);

        int x = (int) ((Math.random() * 40) + 10);
        int y = (int) ((Math.random() * 40) + 10);

        g.fillRect(x, y, width, height);
        msg = false;
      }
    }
  }
}
