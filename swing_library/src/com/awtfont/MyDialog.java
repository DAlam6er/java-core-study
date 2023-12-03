package com.awtfont;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Реализация модального диалогового окна со справкой о программе
public class MyDialog extends Dialog {
  MyDialog(Frame frame, String title, String txt) {
    super(frame, title, true);
    // Размеры родительского окна
    int width = frame.getWidth();
    int height = frame.getHeight();

    setBounds(
        frame.getX() + width / 4, frame.getY() + height / 2,
        width / 2, 150);
    // Окно будет постоянных размеров
    setResizable(false);
    // Отключаем менеджер компоновки
    setLayout(null);

    // Создаем объект текстовой метки
    Label label = new Label(txt, Label.CENTER);
    // Положение и размеры метки
    label.setBounds(
        5, 5,
        getWidth() - 10, 3 * getHeight() / 4 - 10);
    // Добавляем метку в диалоговое окно
    add(label);

    // Создаем объект кнопки
    Button btn = new Button("OK");
    btn.setBounds(
        getWidth() / 3, 3 * getHeight() / 4 - 5,
        getWidth() / 3, 30);
    btn.addActionListener(e -> dispose());
    add(btn);

    // Регистрация обработчика для щелчка системной пиктограммы окна
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        dispose();
      }
    });
    // Отображаем окно на экране
    setVisible(true);
  }
}
