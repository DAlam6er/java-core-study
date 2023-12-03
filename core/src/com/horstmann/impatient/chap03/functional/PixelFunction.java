package com.horstmann.impatient.chap03.functional;

import java.awt.*;

@FunctionalInterface
public interface PixelFunction {
  Color apply(int x, int y);
}
