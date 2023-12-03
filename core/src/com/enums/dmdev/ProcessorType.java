package com.enums.dmdev;

public enum ProcessorType implements Describable {
  // константы со статическим доступом
  // синглтоны - наследники "абстрактного класса" ProcessorType
  // круглые скобки - обращение к конструктору
  BIT_32("bit-32"),
  BIT_64("bit-64") {
    @Override
    public String getDescription() {
      return "bit-64 special description";
    }
  };

  private final String name;

  ProcessorType(String name) {
    this.name = name;
  }

  @Override
  public String getDescription() {
    return name + " default description";
  }

  //public abstract String getDescription();

  public String getName() {
    return name;
  }
}
