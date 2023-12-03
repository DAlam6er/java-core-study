package com.horstmann.impatient.chap02;

/**
 * Реализуйте класс Car, моделирующий передвижение автомобиля на бензиновом топливе
 * по оси X. Предоставьте методы для передвижения автомобиля на заданное количество
 * километров, заполнения топливного бака заданным количеством литров бензина,
 * вычисления расстояния, пройденного от начала координат, а также уровня топлива в баке.
 * Укажите КПД топлива (в км/л) в качестве параметра конструктора данного класса.
 * Должен ли этот класс быть неизменяемым и почему?
 */
public class Task9 {
  public static void main(String[] args) {
    Car car = new Car(58, 10.0);
    car.move(30);
    car.move(40);
    car.move(200);
    System.out.println("В топливном баке осталось " + car.getFuel() + " л бензина.");
    car.move(300);
    car.move(20);
    System.out.println("В топливном баке осталось " + car.getFuel() + " л бензина.");
    car.fillFuel(50);
    System.out.println("В топливном баке осталось " + car.getFuel() + " л бензина.");
    car.move(400);
    System.out.println("В топливном баке осталось " + car.getFuel() + " л бензина.");
    car.fillFuel(55);
    System.out.println("Автомобиль всего проехал " + car.getDistTraveled() + " км.");
  }

  private static class Car {
    private static final double MAX_FUEL = 58.0;
    final double efficiency;
    double distTraveled;
    double fuel;

    public Car(double fuel, double efficiency) {
      this(efficiency);
      this.fuel = fuel;
    }

    public Car(double efficiency) {
      this.efficiency = efficiency;
    }

    public void move(double dist) {
      distTraveled += dist;
      double fuelLeft = this.fuel - dist / efficiency;
      if (fuelLeft < 0) {
        System.out.println("Топлива не хватит, чтобы проехать ещё " + dist + " км!");
        double distLeft = this.fuel * efficiency;
        System.out.println("Топлива осталось на " + distLeft + " км.");
      } else {
        this.fuel = this.fuel - dist / efficiency;
        System.out.println("Автомобиль проехал " + dist + " км.");
      }
      if (this.fuel == 0) {
        System.out.println("Топливо закончилось. Автомобиль больше никуда не поедет.");
      }
    }

    public void fillFuel(double fuel) {
      if (this.fuel + fuel <= MAX_FUEL) {
        this.fuel += fuel;
      } else {
        System.out.println("Топливный бак вмещает максимум " + MAX_FUEL + " л.");
        System.out.println("Автомобиль будет заправлен на " + (MAX_FUEL - this.fuel) + " л.");
        this.fuel = MAX_FUEL;
      }
    }

    public double getDistTraveled() {
      return distTraveled;
    }

    public double getFuel() {
      return fuel;
    }
  }
}
