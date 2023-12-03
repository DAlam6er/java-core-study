package com.awtfont;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// класс предназначен для создания окна формы
public class MyFrame extends Frame implements TBBListener {
  // Ссылка на панель с текстовой меткой и кнопкой
  public TextPanel pnlText;
  // Ссылка на панель с элементами управления
  public ToolsPanel pnlTools;
  // Ссылка на главное меню программы
  public MyMenuBar menu;
  // Ссылка на панель инструментов
  public MyToolBar toolBar;
  // Текстовый массив с названиями файлов изображений для кнопок toolBar
  public String[] imgFiles = {
      "/pic/toolbar/bold.gif",
      "/pic/toolbar/italic.gif",
      "/pic/toolbar/normal.gif",
      "/pic/toolbar/toolbar.gif"
  };
  // Название для диалогового окна справки о программе
  public String title = "О программе";
  // Текст для диалогового окна справки о программе
  public String dText = "Демонстрация работы со шрифтами";

  MyFrame() {
    super("Выбираем шрифт");
    setBounds(350, 150, 600, 400);
    setResizable(false);
    // Цвет фона окна
    setBackground(new Color(240, 240, 240));
    // Создаем менеджер компоновки
    setLayout(new BorderLayout());
    // Реакция на щелчок системной пиктограммы закрытия окна
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        dispose();
      }
    });
    // Создаем панель меню
    menu = new MyMenuBar(this);
    // Добавляем панель меню в окно формы
    setMenuBar(menu);
    // Создаем массив для записи изображений
    Image[] img = new Image[imgFiles.length];
    // Создаем массив кнопок для панели инструментов
    ToolBarButton[] btnTB = new ToolBarButton[img.length];
    // Заполняем массивы
    for (int i = 0; i < img.length; i++) {
      // Создаем изображение на основе файла
      img[i] = getToolkit().getImage(imgFiles[i]);
      // Создаем кнопку для панели инструментов
      btnTB[i] = new ToolBarButton(
          img[i], 24, 24, this, "Пиктограмма " + i);
    }
    // Создаем панель инструментов
    toolBar = new MyToolBar(btnTB, this);
    // Панель инструментов добавляется в окно
    add(toolBar, BorderLayout.NORTH);
    // Создаем панель с элементами управления
    pnlTools = new ToolsPanel(
        getWidth() - 5,
        2 * getHeight() / 3 - toolBar.getHeight(), this);
    // Добавляем панель с элементами управления в окно формы
    add(pnlTools, BorderLayout.CENTER);
    // Создаем панель с текстовой меткой и кнопкой завершения работы
    pnlText = new TextPanel(getWidth() - 5, getHeight() / 4);
    // Добавляем панель с текстом и кнопкой в окно формы
    add(pnlText, BorderLayout.SOUTH);
    // Применяем для текстовой панели настройки шрифта
    pnlText.setTextAndFont(pnlTools.getMainFont());
    // Отображаем окно формы на экране
    setVisible(true);
  }

  // Метод вызывается для обработки щелчка кнопки на панели инструментов
  @Override
  public void makeAction(MouseEvent mouseEvent) {
    // Определяем название "кнопки", на которой произошел щелчок
    String name = ((ToolBarButton) mouseEvent.getSource()).getName();

    if ("Пиктограмма 0".equals(name)) {
      setBoldStyle();
    } else if ("Пиктограмма 1".equals(name)) {
      setItalicStyle();
    } else if ("Пиктограмма 2".equals(name)) {
      setNormalStyle();
    } else {
      new MyDialog(this, title, dText);
    }
  }

  private void setBoldStyle() {
    // Опция жирного стиля установлена, опция курсивного стиля нет.
    pnlTools.bold.setState(true);
    pnlTools.italic.setState(false);
    // Опционный пункт меню выбора жирного стиля установлен,
    // а курсивного стиля - не установлен
    ((CheckboxMenuItem) menu.mFont.getItem(0)).setState(true);
    ((CheckboxMenuItem) menu.mFont.getItem(1)).setState(false);
    // Применяем новые настройки шрифта
    pnlText.setTextAndFont(pnlTools.getMainFont());
  }

  private void setItalicStyle() {
    // Опция курсивного стиля установлена, опция жирного стиля нет.
    pnlTools.bold.setState(false);
    pnlTools.italic.setState(true);

    ((CheckboxMenuItem) menu.mFont.getItem(0)).setState(false);
    ((CheckboxMenuItem) menu.mFont.getItem(1)).setState(true);

    pnlText.setTextAndFont(pnlTools.getMainFont());
  }

  private void setNormalStyle() {
    // Опция жирного стиля не установлена, опция курсивного стиля не установлена.
    pnlTools.bold.setState(false);
    pnlTools.italic.setState(false);

    ((CheckboxMenuItem) menu.mFont.getItem(0)).setState(false);
    ((CheckboxMenuItem) menu.mFont.getItem(1)).setState(false);

    pnlText.setTextAndFont(pnlTools.getMainFont());
  }
}
