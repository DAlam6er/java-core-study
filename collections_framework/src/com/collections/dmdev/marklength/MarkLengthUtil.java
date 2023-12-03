package com.collections.dmdev.marklength;

import java.util.List;
import java.util.ListIterator;

public final class MarkLengthUtil {
  private static final String TARGET_VALUE = "****";
  private static final int TARGET_LENGTH = 4;

  private MarkLengthUtil() {
  }

  /**
   * У наследников интерфейса List есть более мощный итератор - ListIterator,
   * который наследуется от обычного интерфейса Iterator,
   * но предоставляет еще больше функциональности,
   * которую можно использовать для свох нужд, например, методы set, add и другие.
   */
  public static void markLength4(List<String> list) {
    ListIterator<String> listIterator = list.listIterator();
    while (listIterator.hasNext()) {
      // Возвращает следующий элемент в списке и продвигает позицию курсора.
      String nextValue = listIterator.next();
      if (nextValue.length() == TARGET_LENGTH) {
                /*
                Заменяет последний элемент, возвращенный next или previous,
                указанным элементом (необязательная операция).

                Этот вызов может быть сделан только в том случае, если
                ни remove(), ни add() не были вызваны
                после последнего вызова next() или previous().
                 */
        listIterator.set(TARGET_VALUE);
                /*
                Вставляет указанный элемент в список (необязательная операция).

                Элемент вставляется непосредственно ПЕРЕД элементом,
                который будет возвращен вызовом next(), если таковой имеется,
                и ПОСЛЕ элемента, который будет возвращен вызовом previous(), если таковой имеется.
                (Если список не содержит элементов, новый элемент становится
                единственным элементом в списке.)

                Новый элемент вставляется ПЕРЕД неявным курсором:
                последующий вызов next() не будет затронут,
                а последующий вызов previous() вернет новый элемент.
                (Этот вызов увеличивает на единицу значение,
                возвращаемое вызовом nextIndex() или previousIndex().)
                 */
        listIterator.add(nextValue);
      }
    }
  }
}
