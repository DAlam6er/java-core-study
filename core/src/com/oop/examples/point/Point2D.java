package com.oop.examples.point;

public class Point2D {
  private static int pointsCounter;

  static {
    System.out.println("Static block!");
  }

  private final int pointID;
  private int x, y;
  private double length;

  public Point2D() // конструктор умолчаний
  {

    this(0, 0); // замыкаем конструктор
  }

  public Point2D(int x, int y) {
    setX(x); // методы, вызываемые из конструктора
    setY(y); // обязаны быть финальными
    pointID = pointsCounter++;
  }

  public static int getPointsCounter() {
    return pointsCounter;
  }

  private void length() // лучше не называть метод так же как поле
  {
    length = Math.sqrt(x * x + y * y);
  }

  public double getLength() {
    return length;
  }

  public int getID() {
    return pointID;
  }

  @Override
  public String toString() {
    //        return "Point2D{" + "x=" + x +", y=" + y + '}';
    StringBuilder sb = new StringBuilder("(");
    sb.append(x);
    sb.append(", ");
    sb.append(y);
    sb.append(")");
    return sb.toString();
  }

  public double distanceTo(Point2D rValue) {
    // можно писать как (x - rValue.x) и (y - rValue.y)
    return Math.sqrt(
        (x - rValue.getX()) * (x - rValue.getX()) +
        (y - rValue.getY()) * (y - rValue.getY())
    );
  }

  public int getX() {
    return x;
  }

  public final void setX(int x) {
    this.x = x;
    length();
  }

  public int getY() {
    return y;
  }

  public final void setY(int y) {
    this.y = y;
    length();
  }

  public Point2D addTo(Point2D rValue) {
    return new Point2D(x + rValue.x, y + rValue.y);
  }
}
