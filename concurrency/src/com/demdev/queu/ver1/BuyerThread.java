package com.demdev.queu.ver1;

import java.util.Queue;

public class BuyerThread implements Runnable {
  private final Queue<Cashbox> cashboxes;

  public BuyerThread(Queue<Cashbox> cashboxes) {
    this.cashboxes = cashboxes;
  }

  @Override
  public void run() {
    try {
      // Блок synchronized нужен для того, чтобы в каждый момент времени,
      // только 1 поток мог проверить есть ли доступные кассы в cashboxes
      synchronized (cashboxes) {
        // while ВНУТРИ synchronized, а не наоборот,
        // т.к. нелогично выходить из блока (в строке cashboxes.wait()),
        // чтобы сразу же его захватить и попробовать обслужиться
        while (true) {
          // Опасная точка, два потока могут увидеть, что есть свободная касса
          // попытаются удалить одновременно, и один из потоков не получит кассу
          // будет выброшено java.util.NoSuchElementException
          if (!cashboxes.isEmpty()) {
            Cashbox cashbox = cashboxes.remove();   // выброс исключения
            System.out.println(Thread.currentThread().getName() +
                               " обслуживается в кассе " + cashbox);

            // не освобождает захваченный монитор
            // это плохо, т.к. захватываем монитор всех касс, а используем лишь одну
            //Thread.sleep(5L);

            // wait вызывается у объекта, монитор которого был захвачен
            // ОСВОБОЖДАЕМ МОНИТОР cashboxes, другие потоки могут захватить монитор
            cashboxes.wait(5L);

            System.out.println(Thread.currentThread().getName() +
                               " освобождаю кассу " + cashbox);
            cashboxes.add(cashbox);
            // notifyAll() не может быть вызыван,
            // пока мы не захватили монитор объекта cashboxes
            cashboxes.notifyAll();
            break;
          } else {
            System.out.println(Thread.currentThread().getName() +
                               " ожидает свободную кассу");
            //Thread.sleep(5L);
            // время не указываем, т.к. покупатель не знает, как долго ему придется ждать
            // cashboxes.wait(0L);
            cashboxes.wait();
            // если в этой точке какой-то из потоков пробудился от notifyAll()
            // ему не нужно выходить из блока synchronized
            // для того, чтобы вновь проверить условие if {}
          }
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
