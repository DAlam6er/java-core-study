package com.games.headfirst.seabattle.v2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameHelper_v2 {
  public static final int MAX_ATTEMPTS = 200;
  static final int HORIZONTAL_INCREMENT = 1;
  private static final String ALPHABET = "abcdefg";
  private static final int GRID_LENGTH = 7;
  static final int VERTICAL_INCREMENT = GRID_LENGTH;
  private static final int GRID_SIZE = 49;
  private final int[] grid = new int[GRID_SIZE];
  private final Random random = new Random();
  private int dotComCount = 0;

  public String getUserInput(String prompt) {
    System.out.println(prompt + ": ");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine().toLowerCase();
  }

  public ArrayList<String> placeDotCom(int dotComSize) {
    // holds index to grid [0 - 48]
    int[] dotComCoords = new int[dotComSize];
    // current attempts counter
    int attempts = 0;
    // flag = found a good location?
    boolean success = false;

    // nth dotCom to place
    dotComCount++;
    // alternate (чередуем) vertical and horizontal alignment
    int increment = getIncrement();

    // main search loop
    while (!success & attempts++ < MAX_ATTEMPTS) {
      // get random starting position
      int location = random.nextInt(GRID_SIZE);

      // create array of proposed coords
      for (int i = 0; i < dotComCoords.length; i++) {
        // put current location in array
        dotComCoords[i] = location;
        // calculate the next location
        location += increment;
      }
      //System.out.println("Trying: " + Arrays.toString(dotComCoords));

      // dotCom fits on the grid?
      if (dotComFits(dotComCoords, increment)) {
        // and location aren't taken?
        success = coordsAvailable(dotComCoords);
      }
    }
    // coords passed checks, save
    savePositionToGrid(dotComCoords);
    ArrayList<String> alphaCells = convertCoordsToAlphaFormat(dotComCoords);
    //System.out.println("Placed at: " + alphaCells);
    return alphaCells;
  }

  private int getIncrement() {
    if (dotComCount % 2 == 0) {
      // place horizontally
      return HORIZONTAL_INCREMENT;
    } else {
      return VERTICAL_INCREMENT;
    }
  }

  private boolean dotComFits(int[] dotComCoords, int increment) {
    int finalLocation = dotComCoords[dotComCoords.length - 1];
    if (increment == HORIZONTAL_INCREMENT) {
      // check end in on same row as start
      return calcRowFromIndex(dotComCoords[0]) == calcRowFromIndex(finalLocation);
    } else {
      // check end isn't off the bottom
      return finalLocation < GRID_SIZE;
    }
  }

  private boolean coordsAvailable(int[] dotComCoords) {
    for (int dotComCoord : dotComCoords) {
      if (grid[dotComCoord] != 0) {
        //System.out.println("position: " + dotComCoord + " already taken.");
        return false;
      }
    }
    // there were no clashes
    return true;
  }

  private void savePositionToGrid(int[] dotComCoords) {
    for (int index : dotComCoords) {
      // mark grid position as "used"
      grid[index] = 1;
    }
  }

  private ArrayList<String> convertCoordsToAlphaFormat(int[] dotComCoords) {
    ArrayList<String> alphaCells = new ArrayList<>();
    for (int index : dotComCoords) {
      // turn it into a "f6" style
      String alphaCoords = getAlphaCoordsFromIndex(index);
      alphaCells.add(alphaCoords);
    }
    // return the "f6" - style coords
    return alphaCells;
  }

  private int calcRowFromIndex(int index) {
    return index / GRID_LENGTH;
  }

  private String getAlphaCoordsFromIndex(int index) {
    int row = calcRowFromIndex(index);
    int column = index % GRID_LENGTH;
    // convert column value to letter (begin_index, end_index)
    String letter = ALPHABET.substring(column, column + 1);
    return letter + row;
  }
}
