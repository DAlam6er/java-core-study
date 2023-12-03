package com.enums.dmdev;

import java.util.Arrays;

public class EnumRunner {
  public static void main(String[] args) {
    ProcessorType pr = ProcessorType.BIT_32;
    System.out.println(pr);
    System.out.println(pr.toString());
    System.out.println(pr.name());
    System.out.println(ProcessorType.valueOf("BIT_32"));
    // throws java.lang.IllegalArgumentException
    //System.out.println(ProcessorType.valueOf("BIT_325"));
    System.out.println(Arrays.toString(ProcessorType.values()));
    System.out.println(ProcessorType.BIT_32.ordinal());
    System.out.println(ProcessorType.BIT_64.getName());
    System.out.println(pr.getName());
    System.out.println(pr.getDescription());
    System.out.println(ProcessorType.BIT_64.getDescription());
  }
}
