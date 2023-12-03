package com.basics.scopes.packagescope.inpackage;

public class SomeClass {
  public static void main(String[] args) {
    ParentClass parentClass = new ParentClass();
    //System.out.println(subClass.privateField); // NOK
    System.out.println(parentClass.defaultField); // OK
    System.out.println(parentClass.protectedField); // OK
    System.out.println(parentClass.publicField); // OK
  }
}
