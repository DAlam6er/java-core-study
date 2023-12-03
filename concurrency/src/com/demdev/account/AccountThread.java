package com.demdev.account;

public class AccountThread extends Thread {
  private final Account accountFrom;
  private final Account accountTo;

  public AccountThread(Account accountFrom, Account accountTo) {
    this.accountFrom = accountFrom;
    this.accountTo = accountTo;
  }


  /**
   * 1 -------- account1 -> account2
   * <p>
   * 2 -------- account2 -> account1
   */
  @Override
  public void run() {
    // Если цикл внутри synchronized-блоков,
    // то один поток захватывает мониторы, а остальные потоки ждут
    // - это убивает многопоточность
        /*
        synchronized (accountFrom) {
            synchronized (accountTo) {
                for (int i = 0; i < 2000; i++) {
                    if (accountFrom.takeOff(10)) {
                        accountTo.add(10);
                    }
                }
            }
        }
         */
    // Будем захватывать мониторы объектов на очередной итерации
    // Получим Deadlock
        /*
        for (int i = 0; i < 2000; i++) {
            synchronized (accountFrom) {
                synchronized (accountTo) {
                    if (accountFrom.takeOff(10)) {
                        accountTo.add(10);
                    }
                }
            }
        }
         */
    // используем концепцию Lock
    for (int i = 0; i < 2000; i++) {
      // блокируем аккаунты
      lockAccounts();
      // в реальной жизни эти методы представляют из себя транзакции,
      // которые могут отказать, поэтому используем try-finally
      try {
        if (accountFrom.takeOff(10)) {
          accountTo.add(10);
        }
      } finally {
        // отпускаем мониторы аккаунтов при любом исходе
        accountFrom.getLock().unlock();
        accountTo.getLock().unlock();
      }
    }
  }


  private void lockAccounts() {
    // Будем пытаться захватить монитор у двух аккаунтов
    // если не получилось захватить монитор у какого-либо аккаунта,
    // то отпускаем захваченный монитор
    // Нельзя ждать освобождения монитора второго аккаунта,
    // если захватили монитор первого!
    // Иначе будет deadLock
    while (true) {
      boolean fromLockResult = accountFrom.getLock().tryLock();
      boolean toLockResult = accountTo.getLock().tryLock();

      if (fromLockResult && toLockResult) {
        break;
      }
      // если хотя бы один из мониторов не был захвачен,
      // то освобождаем захваченный монитор
      // нельзя вызвать unlock у lock, если не захватили его монитор
      if (fromLockResult) {
        accountFrom.getLock().unlock();
      }
      if (toLockResult) {
        accountTo.getLock().unlock();
      }
    }
  }
}
