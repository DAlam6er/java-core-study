package com.horstmann.impatient.chap02;

/**
 * Реализуйте неизменяемый класс Point, описывающий точку на плоскости.
 * Предоставьте его конструктор, чтобы задать конкретную точку; конструктор без аргументов,
 * чтобы задать точку в начале координат, а также методы getX(), getY(), translate(),
 * scale(). В частности, метод translate() должен перемещать точку на определенное расстояние
 * в направлении координат x и y, а метод scale() - изменять масштаб по обеим координатам на заданный
 * коэффициент. Реализуйте эти методы таким образом, чтобы они возвращали новые точки
 * в качестве результата. Например, в следующей строке кода:
 * Point p = new Point(3, 4).translate(1, 3).scale(0.5);
 * в переменной p должна быть установлена точка с координатами (2, 3.5)
 */
public class Task5 {
  public static void main(String[] args) {
    Point p = new Point(3, 4).translate(1, 3).scale(0.5);
    System.out.println(p);
  }

  /**
   * объект <code>класса Point</code>
   * представляет описание неизменяемой точки на плоскости
   *
   * @author Anton Pashkin
   * @version 1.0
   */
  private static class Point {
    final double x;
    final double y;

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
     * Возвращает новую точку на плоскости на основе заданной после сдвига координат исходной точки
     * на указанное значение по обеим осям
     *
     * @param deltaX сдвиг исходной точки по оси X
     * @param deltaY сдвиг исходной точки по оси Y
     * @return новая точка на плоскости
     */
    public Point translate(double deltaX, double deltaY) {
      return new Point(this.x + deltaX, this.y + deltaY);
    }

    /**
     * Возвращает новую точку на плоскости на основе заданной после изменения масштаба
     * по обеим координатам на указанный коэффициент
     *
     * @param coeff коэффициент масштабирования точки
     * @return новая точка на плоскости
     */
    public Point scale(double coeff) {
      return new Point(this.x * coeff, this.y * coeff);
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
