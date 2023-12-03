package com.awtfont;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;

// на основе этого класса реализуются кнопки для панели инструментов
public class ToolBarButton extends Canvas {
  // Ссылка на изображение для кнопки
  private final Image img;
  private final Color base;
  private final Color light;
  // Ссылка на обработчик - объект класса, реализующего TBBListener
  private final TBBListener hnd;
  // Поле определяет состояние кнопки
  // При нажатии на кнопку, notClicked становится false
  private boolean notClicked;
  // Переменные для фона, основного и вспомогательного цветов
  private Color backgrnd;

  // аргументы - ссылка на изображение для кнопки, размеры кнопки,
  // ссылка на обработчик события щелчка на кнопке, название для кнопки
  ToolBarButton(Image img, int width, int height, TBBListener handler, String name) {
    super();
    setName(name);
    // определяем состояние кнопки (она не нажата)
    notClicked = true;
    // Задаём ссылку на обработчик
    this.hnd = handler;
    // Задаём основной и вспомогательный цвет
    base = new Color(240, 240, 240);
    light = new Color(250, 250, 250);
    backgrnd = base;
    // Масштабируем изображение для кнопки панели инструментов
    this.img = img.getScaledInstance(
        width - 8, height - 8, Image.SCALE_DEFAULT);
    // Задаём размеры кнопки
    setSize(width, height);
    // Для кнопки регистрируется обработчик
    addMouseListener(new MouseAdapter() {
      // Реакция на щелчок кнопки
      @Override
      public void mouseClicked(MouseEvent e) {
        // Если ссылка на обработчик не пустая,
        // из объекта обработчика вызывается метод makeAction()
        if (hnd != null) {
          hnd.makeAction(e);
        }
      }

      // Действия при нажатии на кнопке (нажата клавиша мыши)
      @Override
      public void mousePressed(MouseEvent e) {
        // Меняется состояние кнопки
        notClicked = false;
        repaint();
      }

      // Действия при отпускании кнопки (клавиша мыши отпущена после нажатия)
      @Override
      public void mouseReleased(MouseEvent e) {
        try {
          TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException ignored) {
        }
        notClicked = true;
        repaint();
      }

      // Действия при наведении курсора мыши на кнопку
      @Override
      public void mouseEntered(MouseEvent e) {
        // Меняем цвет фона
        backgrnd = light;
        // Перерисовка компонента
        repaint();
      }

      // Действия при выходе курсора мыши из области компонента
      @Override
      public void mouseExited(MouseEvent e) {
        backgrnd = base;
        repaint();
      }
    });
  }

  // Метод для рисования компонента
  @Override
  public void paint(Graphics grObj) {
    // Отображается пиктограмма для кнопки
    grObj.drawImage(img, 4, 4, this);
    // Задаётся цвет фона компонента
    setBackground(backgrnd);
    // Отображается граница кнопки
    drawBorder(grObj);
  }

  // Метод для рисования границ кнопки
  private void drawBorder(Graphics grObj) {
    // проверяется состояние кнопки
    if (notClicked) {
      grObj.setColor(base.darker());
      grObj.drawLine(
          0, getHeight() - 1,
          getWidth() - 1, getHeight() - 1);
      grObj.drawLine(
          getWidth() - 1, 0,
          getHeight() - 1, getWidth() - 1);
      grObj.setColor(base.darker().darker());
      grObj.drawLine(
          0, getHeight() - 2,
          getWidth() - 2, getHeight() - 2);
      grObj.drawLine(
          getWidth() - 2, 0,
          getHeight() - 2, getWidth() - 2);
      grObj.setColor(base.brighter());
      grObj.drawLine(
          0, 0,
          getWidth() - 1, 0);
      grObj.drawLine(
          0, 0,
          0, getHeight() - 1);
    } else {
      // если кнопка нажата
      grObj.setColor(base.darker().darker());
      grObj.drawLine(
          0, 0,
          getWidth() - 1, 0);
      grObj.drawLine(
          0, 0,
          0, getHeight() - 1);
      grObj.setColor(base.darker());
      grObj.drawLine(
          1, 1,
          getWidth() - 1, 1);
      grObj.drawLine(
          1, 1,
          1, getHeight() - 1);
    }
  }
}
