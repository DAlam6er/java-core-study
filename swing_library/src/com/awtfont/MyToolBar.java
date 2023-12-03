package com.awtfont;

import java.awt.*;

// класс для реализации панели инструментов для приложения
public class MyToolBar extends Panel {
  public MyFrame frame;

  // аргументы - массив кнопок и ссылка на окно формы
  MyToolBar(ToolBarButton[] btnTB, MyFrame frame) {
    super();
    this.frame = frame;
    // цвет фона для панели инструментов
    setBackground(new Color(240, 240, 240));
    // размеры панели инструментов
    setSize(frame.getWidth(), btnTB[0].getHeight() + 8);
    // отключаем менеджер компоновки для панели инструментов
    setLayout(null);
    // размещаем на панели инструментов первую кнопку
    add(btnTB[0]).setLocation(16, 4);
    // размещаем на панели инструментов все прочие кнопки
    for (int i = 1; i < btnTB.length; i++) {
      add(btnTB[i])
          .setLocation(
              4 + btnTB[i - 1].getX() + btnTB[i - 1].getWidth(), 4);
    }
  }

  // метод для рисования панели инструментов
  @Override
  public void paint(Graphics grObj) {
    // задаём цвет
    grObj.setColor(new Color(200, 200, 200));
    // рисуем линии по краям панели инструментов
    grObj.drawLine(
        0, getHeight() - 1,
        getWidth(), getHeight() - 1);
    grObj.drawLine(0, 0, getWidth(), 0);
    // задаём новый цвет
    grObj.setColor(new Color(160, 160, 160));
    // рисуем линии по краям панели инструментов
    grObj.drawLine(
        0, getHeight() - 2,
        getWidth() - 1, getHeight() - 2);
    grObj.drawLine(0, 1, getWidth(), 1);
    // длина штриха для декоративного элемента панели инструментов
    int height = getHeight() / 15;
    // рисуем декоративный элемент панели (штрихи вдоль левой границы)
    for (int i = 1; i <= 6; i++) {
      grObj.drawLine(
          5, 2 * height * i, 5, (2 * i + 1) * height);
      grObj.drawLine(
          4, 2 * height * i, 4, (2 * i + 1) * height);
    }
  }
}
