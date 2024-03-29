package com.midiplayers.headfirst;

import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;

public class MidiPlayback {
  public static void main(String[] args) {
    try {
      Sequencer sequencer = MidiSystem.getSequencer();
      if (sequencer == null) {
        System.err.println("Sequencer device not supported");
        return;
      }
      sequencer.open();
      // Create sequence, the File must contain MIDI file data.
      Sequence sequence = MidiSystem.getSequence(new File(args[0]));
      sequencer.setSequence(sequence);
      sequencer.start();
    } catch (
        MidiUnavailableException |
        InvalidMidiDataException |
        IOException ex) {
      ex.printStackTrace();
    }
  }
}
