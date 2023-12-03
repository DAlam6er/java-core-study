package com.collections.javarush.list;

import java.util.ArrayList;
import java.util.List;

/*
Почувствуй себя деканом
*/

public class ListRemoveDemo {
  public List<String> students;

  public ListRemoveDemo() {
    students = new ArrayList<>();
    students.add("Сергей Фрединский");
    students.add("Виталий Правдивый");
    students.add("Максим Козыменко");
    students.add("Наталия Андрющенко");
    students.add("Ира Величенко");
    students.add("Николай Соболев");
    students.add("Снежана Слободенюк");
  }

  public static void main(String[] args) {
    ListRemoveDemo universityGroup = new ListRemoveDemo();
    universityGroup.exclude("Виталий Правдивый");
    universityGroup.students.forEach(System.out::println);
  }

  public void exclude(String excludedStudent) {
    // НЕВЕРНОЕ РЕШЕНИЕ!
    // Нельзя одновременно обходить элементы коллекции с помощью цикла
    // for-each и изменять ту же самую коллекцию.
        /*
        for (String student : students) {
            if (student.equals(excludedStudent)) {
                students.remove(student);
            }
        }
         */
    //students.removeIf(excludedStudent::equals);
    //students.removeIf(x -> excludedStudent.equals(x));
    students.remove(excludedStudent);
  }
}
