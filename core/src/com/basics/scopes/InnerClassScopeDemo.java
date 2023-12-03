package com.basics.scopes;

public class InnerClassScopeDemo {
  private int var1 = 10;
  private String var2 = "Меркурий";

  public static void main(String[] args) {
    InnerClassScopeDemo demo = new InnerClassScopeDemo();
    InnerClassScopeDemo.Inner inner = demo.new Inner();
    inner.testVisibilty();
    System.out.println("--------------------");
    System.out.println("var3 = " + inner.var3);
    System.out.println("var4 = " + inner.var4);
  }

  private class Inner {
    private int var3 = 99;
    private String var4 = "Венера";

    private void testVisibilty() {
      System.out.println("var1 = " + var1);
      System.out.println("var2 = " + var2);
    }
  }
}
