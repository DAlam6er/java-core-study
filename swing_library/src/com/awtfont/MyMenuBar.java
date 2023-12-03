package com.awtfont;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

// класс для реализации панели главного меню приложения
public class MyMenuBar extends MenuBar implements ItemListener, ActionListener {
  // Меню "Файл"
  public Menu mFile;
  // Меню "Шрифт"
  public Menu mFont;
  // Меню "Справка"
  public Menu mHelp;
  public MyFrame frame;

  // в качестве аргумента передаём окно формы
  MyMenuBar(MyFrame frame) {
    super();
    this.frame = frame;

    // создаём меню "Файл"
    mFile = new Menu("Файл");
    // создание пункта "Выход" для меню "Файл"
    MenuItem exit = new MenuItem("Выход");
    exit.addActionListener(e -> this.frame.dispose());
    // добавляем пункт меню "Выход" в меню "Файл"
    mFile.add(exit);
    // добавляем меню "Файл" в главное меню:
    add(mFile);

    // создаём меню "Шрифт"
    mFont = new Menu("Шрифт");
    // опционный пункт меню "Жирный"
    CheckboxMenuItem bold = new CheckboxMenuItem("Жирный", false);
    // регистрация обработчика события изменения состояния
    bold.addActionListener(this);
    // опционный пункт меню "Жирный" добавляется в меню "Шрифт"
    mFont.add(bold);

    CheckboxMenuItem italic = new CheckboxMenuItem("Курсив", false);
    italic.addActionListener(this);
    mFont.add(italic);

    // в меню "Шрифт" добавляется разделитель
    mFont.addSeparator();

    // подменю "Тип шрифта" для меню "шрифт"
    Menu fntType = new Menu("Тип шрифта");
    // пункты меню для подменю "Тип шрифта"
    MenuItem dialog = new MenuItem("Dialog");
    MenuItem serif = new MenuItem("Serif");
    MenuItem sansserif = new MenuItem("SansSerif");
    MenuItem monospaced = new MenuItem("MonoSpaced");
    // регистрируем обработчики для пунктов меню
    dialog.addActionListener(this);
    serif.addActionListener(this);
    sansserif.addActionListener(this);
    monospaced.addActionListener(this);
    // добавляем пункты меню в подменю "Тип шрифта"
    fntType.add(dialog);
    fntType.add(serif);
    fntType.add(sansserif);
    fntType.add(monospaced);
    // подменю "Тип шрифта" добавляется в меню "Шрифт"
    mFont.add(fntType);

    // создаётся подменю "Размер шрифта"
    Menu fntSize = new Menu("Размер");
    // в подменю "Размер шрифта" добавляются пункты
    for (int i = 12; i <= 24; i++) {
      // добавляем пункт и регистрируем обработчик
      fntSize.add(new MenuItem(" " + i + " "))
          .addActionListener(this);
    }
    // в меню "Шрифт" добавляется подменю "Размер шрифта"
    mFont.add(fntSize);
    // меню "Шрифт" добавляется в главное меню
    add(mFont);

    // Создаём меню "Справка"
    mHelp = new Menu("Справка");
    // Пункт меню "О программе"
    MenuItem about = new MenuItem("О программе");
    about.addActionListener(this);
    // Пункт меню "О программе" добавляется в меню "Справка"
    mHelp.add(about);
    // Меню "Справка" добавляется в главное меню
    add(mHelp);
  }

  // Метод для обработки событий выбора неопционных пунктов меню
  @Override
  public void actionPerformed(ActionEvent e) {
    // Определяем команду действия
    String name = e.getActionCommand();
    if ("О программе".equals(name)) {
      new MyDialog(frame, frame.title, frame.dText);
      return;
    }
    if ("Dialog".equals(name)) {
      // пункт меню для выбора шрифта Dialog
      frame.pnlTools.dialog.setState(true);
    } else if ("Serif".equals(name)) {
      // пункт меню для выбора шрифта Serif
      frame.pnlTools.serif.setState(true);
    } else if ("SansSerif".equals(name)) {
      // пункт меню для выбора шрифта SansSerif
      frame.pnlTools.sansserif.setState(true);
    } else if ("Monospaced".equals(name)) {
      // пункт меню для выбора шрифта Monospaced
      frame.pnlTools.monospaced.setState(true);
    } else {
      // пункты меню для выбора размера шрифта
      for (int i = 12; i <= 24; i++) {
        if ((" " + i + " ").equals(name)) {
          frame.pnlTools.size.select(i - 12);
          break;
        }
      }
    }
    // применяем настройки для формирования шрифта и образца текста
    frame.pnlText.setTextAndFont(frame.pnlTools.getMainFont());
  }

  // Метод для обработки событий изменения состояния опционных пунктов меню
  @Override
  public void itemStateChanged(ItemEvent e) {
    // Определяем состояние опции выбора/отмены жирного стиля
    frame.pnlTools.bold
        .setState(((CheckboxMenuItem) mFont.getItem(0)).getState());
    // Определяем состояние опции выбора/отмены курсивного стиля
    frame.pnlTools.italic
        .setState(((CheckboxMenuItem) mFont.getItem(1)).getState());
    // применяем настройки для формирования шрифта и образца текста
    frame.pnlText.setTextAndFont(frame.pnlTools.getMainFont());
  }
}
