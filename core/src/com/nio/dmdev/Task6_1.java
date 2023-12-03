package com.nio.dmdev;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Task6_1 {
  private final static int MAX_SIZE = 50;
  private final static String DELIMITER = " ";
  private static final int[] idNumbers = new int[MAX_SIZE];
  private static final double[] donations = new double[MAX_SIZE];
  private static String header;

  public static void main(String[] args) {
    Path path = Path.of("core", "resources", "data.csv");
    int donCount = readFromFile(path);
    printToSystemOutput(donCount);
  }

  /**
   * @param path path to file with records
   * @return number of records read
   */
  private static int readFromFile(Path path) {
    int donCount = 0;
    try (Scanner scanner = new Scanner(path)) {
      if (scanner.hasNext()) {
        header = scanner.nextLine();
      }
      String[] line;
      while (scanner.hasNext() && donCount < MAX_SIZE) {
        line = scanner.nextLine().split(DELIMITER);
        idNumbers[donCount] = Integer.parseInt(line[0]);
        donations[donCount] = Double.parseDouble(line[1]);
        donCount++;
      }
    } catch (IOException ex) {
      System.out.println("File data.csv was not found");
      return 0;
    } catch (NumberFormatException ex) {
      System.out.println("File contains invalid data");
      return 0;
    }
    return donCount;
  }

  /**
   * @param donCount number of actual donations
   *                 Formatted output of the read file to the console
   */
  private static void printToSystemOutput(int donCount) {
    System.out.println(header);
    for (int i = 0; i < donCount; i++) {
      System.out.printf("%d %.3f\n", idNumbers[i], donations[i]);
    }
  }
}
