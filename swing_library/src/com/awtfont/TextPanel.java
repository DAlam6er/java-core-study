package com.awtfont;

import java.awt.*;

// предназначен для реализации панели, содержащей текстовую метку
// и кнопку для завершения работы приложения
public class TextPanel extends Panel {
  // текстовая метка
  private final Label text;

  TextPanel(int width, int height) {
    super();
    setSize(width, height);
    setLayout(null);
    text = new Label();
    // задаем выравнивание текста метки - по центру
    text.setAlignment(Label.CENTER);
    // задаем положение на панели и размеры метки
    text.setBounds(5, 5, width - 10, 2 * height / 3 - 10);
    text.setBackground(Color.WHITE);
    // добавляем метку на панель
    add(text);

    // Создаем кнопку
    Button btn = new Button("Закрыть");
    // Шрифт для кнопки
    btn.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
    btn.setBounds(width / 3, 2 * height / 3, width / 3, height / 3 - 5);
    btn.addActionListener(e -> {
      Container container = getParent();
      if (container instanceof Frame) {
        ((Frame) container).dispose();
      }
    });
    // добавляем кнопку на панель
    add(btn);
  }

  // метод для вычисления по объекту шрифта
  // текста метки и применения шрифта
  public void setTextAndFont(Font font) {
    String style = " - ";
    if (font.getStyle() == Font.PLAIN) {
      style += "обычный, ";
    } else if (font.getStyle() == Font.BOLD) {
      style += "жирный, ";
    } else if (font.getStyle() == Font.ITALIC) {
      style += "курсив, ";
    } else {
      style += "жирный курсив, ";
    }
    // текстовое содержимое метки
    // начальное значение - тип шрифта
    String txt = font.getFamily();
    txt += style;
    txt += "размер " + font.getSize() + ".";

    text.setText(txt);
    text.setFont(font);
  }
}
