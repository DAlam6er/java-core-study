package com.nio.dmdev;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Task6_2 {
  public static void main(String[] args) throws IOException {
    // if the size of the array changes, you only need to change it in one place: here
    int arraySize = 50;
    // put your ACTUAL path here (in your case it could be just "dono&ID.txt")
    String pathToFile = "C:\\prog\\Java\\study-core\\core\\resources\\dono&ID.txt";

    int[] idNumbers = new int[arraySize];
    double[] donations = new double[arraySize];
    int dcount = countLinesInFile(pathToFile);

    readFile(pathToFile, idNumbers, donations);
    printData(idNumbers, donations, dcount);

    sortById(idNumbers, donations, dcount);
    System.out.println("\nAfter sorting(ID):");
    printData(idNumbers, donations, dcount);

    sortByDonations(idNumbers, donations, dcount);
    System.out.println("\nAfter sorting(Donations):");
    printData(idNumbers, donations, dcount);

    System.out.printf("\nNumber of Sets of Donors: %d\n", dcount);
    System.out.printf(Locale.US, "The highest donation is $%.2f, and the donor ID is %d.\n",
        donations[0], idNumbers[0]);

    double median;
    if (dcount % 2 == 0) {
      median = (donations[dcount / 2] + donations[dcount / 2 + 1]) / 2;
    } else {
      median = (donations[dcount / 2]);
    }
    System.out.printf(Locale.US, "The median of donations is $%.2f.\n", median);
  }

  /**
   * Counts the number of lines that the file contains at the specified path
   *
   * @param path the path to the file we are reading
   * @return number of lines in the file
   * @throws IOException if the file was not found at the specified path
   */
  public static int countLinesInFile(String path) throws IOException {
    File file = new File(path); // File file1 = new File("dono&ID.txt")
    Scanner scanner = new Scanner(file);
    int count = 0;

    while (scanner.hasNextLine()) {
      count++;
      scanner.nextLine();
    }
    return count;
  }

  /**
   * Reads a file from the given path, writes data to the given arrays
   *
   * @param path      the path to the file we are reading
   * @param idNumbers array containing donor IDs
   * @param donations array containing donation amounts
   * @throws IOException if the file was not found at the specified path
   */
  public static void readFile(String path, int[] idNumbers, double[] donations) throws IOException {
    File file = new File(path);
    // there is no need to specify the locale, unless you are in Russia :-))))))
    // use just Scanner lineScanner = new Scanner(file);
    Scanner lineScanner = new Scanner(file).useLocale(Locale.US);
    int i = 0;

    while (lineScanner.hasNextLine()) {
      idNumbers[i] = lineScanner.nextInt();
      donations[i] = lineScanner.nextDouble();
      i++;
    }

  }

  /**
   * Formatted output of the contents of two arrays
   *
   * @param idNumbers array containing donor IDs
   * @param donations array containing donation amounts
   * @param dcount    number of payloads in arrays
   */
  public static void printData(int[] idNumbers, double[] donations, int dcount) {
    System.out.printf("%-16s %16s", "ID NUMBER", "Donation\n");
    for (int i = 0; i < dcount; i++) {
      System.out.printf(Locale.US, idNumbers[i] + "%29.2f\n", donations[i]);
    }
  }

  /**
   * Sorts an array of ids and its associated array of donations in ascending order of ids
   *
   * @param idNumbers array containing donor IDs
   * @param donations array containing donation amounts
   * @param dcount    number of payloads in arrays
   */
  public static void sortById(int[] idNumbers, double[] donations, int dcount) {
    int tempID; // it's better to declare outside a loop nested in another loop, it's more efficient
    double tempDonations; // it's better to declare outside a loop nested in another loop, it's more efficient
    boolean swapped; // to optimize sorting: check if there was at least one permutation in the inner loop
    for (int i = 0; i < dcount - 1; i++) {
      swapped = false;
      for (int j = i + 1; j < dcount; j++) {
        if (idNumbers[i] > idNumbers[j]) {
          tempID = idNumbers[j];
          idNumbers[j] = idNumbers[i];
          idNumbers[i] = tempID;
          swapped = true; // sign that there was at least one permutation

          tempDonations = donations[j];
          donations[j] = donations[i];
          donations[i] = tempDonations;
        }
      }
            /*
            if there was not a single permutation in the inner loop,
            then everything is already sorted, do not waste time on unnecessary enumeration
             */
      if (!swapped) break;
    }
  }

  /**
   * Sorts an array of donations and its associated array of ids in descending order of donations
   *
   * @param idNumbers array containing donor IDs
   * @param donations array containing donation amounts
   * @param dcount    number of payloads in arrays
   */
  public static void sortByDonations(int[] idNumbers, double[] donations, int dcount) {
    double tempD;
    int tempID;
    boolean swapped;
    do {
      swapped = false;
      for (int i = 0; i < dcount - 1; i++) {
        if (donations[i] < donations[i + 1]) {
          tempD = donations[i];
          donations[i] = donations[i + 1];
          donations[i + 1] = tempD;

          tempID = idNumbers[i];
          idNumbers[i] = idNumbers[i + 1];
          idNumbers[i + 1] = tempID;
          swapped = true;
        }
      }
    } while (swapped);
  }
}