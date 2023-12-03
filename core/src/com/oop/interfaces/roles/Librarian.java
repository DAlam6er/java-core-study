package com.oop.interfaces.roles;

import java.util.ArrayList;

public interface Librarian {
  void order(ArrayList<Book> books, Supplier supplier);
}
