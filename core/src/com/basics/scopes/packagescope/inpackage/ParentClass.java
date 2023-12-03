package com.basics.scopes.packagescope.inpackage;

public class ParentClass {
  public boolean publicField = true;       // visible everywhere
  protected boolean protectedField = true; // visible in SubClass (both in package or out)
  boolean defaultField = true;             // visible in package
  private boolean privateField = true;     // visible ONLY in ParentClass

  protected void protectedMethod() {
  }

  private void privateMethod() {
  }

  public void publicMethod() {
  }
}
