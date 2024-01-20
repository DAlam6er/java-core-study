package com.horstmann.impatient.chap02.task06;

/**
 * Повторите предыдущее упражнение, но на этот раз сделайте методы
 * translate() и scale() модифицирующими
 */
public class Task06 {
  public static void main(String[] args) {
    Point p = new Point(3, 4).translate(1, 3).scale(0.5);
    System.out.println(p);
  }

  /**
   * объект <code>класса Point</code>
   * представляет описание точки на плоскости
   *
   * @author Anton Pashkin
   * @version 1.0
   */
  private static class Point {
    double x;
    double y;

    /**
     * Полный конструктор для задания конкретной точки на плоскости
     *
     * @param x координата x создаваемой точки
     * @param y координата y создаваемой точки
     */
    public Point(double x, double y) {
      this.x = x;
      this.y = y;
    }

    /**
     * Конструктор умолчаний для задания точки на плоскости в начале координат
     */
    public Point() {
      this.x = 0;
      this.y = 0;
    }

    /**
     * Возвращает координату x данной точки на плоскости
     *
     * @return координата x
     */
    public double getX() {
      return x;
    }

    /**
     * Возвращает координату y данной точки на плоскости
     *
     * @return координата y
     */
    public double getY() {
      return y;
    }

    /**
     * Возвращает изменившуюся точку на плоскости после сдвига координат на указанное значение
     * по обеим осям
     *
     * @param deltaX сдвиг исходной точки по оси X
     * @param deltaY сдвиг исходной точки по оси Y
     * @return изменившаяся точка на плоскости
     */
    public Point translate(double deltaX, double deltaY) {
      this.x = this.x + deltaX;
      this.y = this.y + deltaY;
      return this;
    }

    /**
     * Возвращает изменившуюся точку на плоскости после изменения масштаба
     *
     * @param coeff коэффициент масштабирования точки
     * @return изменившаяся точка на плоскости
     */
    public Point scale(double coeff) {
      this.x = this.x * coeff;
      this.y = this.y * coeff;
      return this;
    }

    /**
     * Возвращает строковое представление точки с координатами
     *
     * @return строковое представление точки
     */
    @Override
    public String toString() {
      return "Point{" + "x=" + x + ", y=" + y + '}';
    }
  }
}


