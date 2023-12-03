package com.awtfont;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

// класс для панели с элементами управления (настройки параметров)
public class ToolsPanel extends Panel implements ItemListener {
  // Ссылка на основное окно, в которое добавляется панель
  public MyFrame frame;
  // Ссылки на элементы управления
  //      Переключатели для выбора типа шрифта
  public Checkbox dialog;
  public Checkbox serif;
  public Checkbox sansserif;
  public Checkbox monospaced;
  //      Опции для выбора стиля шрифта
  public Checkbox bold;
  public Checkbox italic;
  //      Список для выбора размера шрифта
  public List size;

  // аргументы конструктора - размеры панели и ссылка на окно формы, в которое добавляется панель
  ToolsPanel(int width, int height, MyFrame frame) {
    super();
    this.frame = frame;
    setLayout(null);
    setSize(width, height);
    // задаём шрифт для панели
    setFont(new Font(Font.DIALOG, Font.BOLD, 15));

    // внутренняя панель с группой переключателей для выбора типа шрифта
    Panel pType = new Panel();
    pType.setBounds(5, 0, width / 3 - 10, height);
    pType.setLayout(new GridLayout(6, 1));
    pType.add(new Label("Выбираем тип шрифта:"));

    // Создаем объект для группы переключателей
    CheckboxGroup checkboxGroup = new CheckboxGroup();
    // создаем переключатель и добавляем его в группу
    dialog = new Checkbox(" Шрифт Dialog", checkboxGroup, true);
    // для переключателя регистрируется обработчик события изменения состояния
    dialog.addItemListener(this);
    // переключатель добавляется на внутреннюю панель
    pType.add(dialog);

    serif = new Checkbox(" Шрифт Serif", checkboxGroup, false);
    serif.addItemListener(this);
    pType.add(serif);

    sansserif = new Checkbox(" Шрифт SansSerif", checkboxGroup, false);
    sansserif.addItemListener(this);
    pType.add(sansserif);

    monospaced = new Checkbox(" Шрифт Monospaced", checkboxGroup, false);
    monospaced.addItemListener(this);
    pType.add(monospaced);

    // внутренняя панель с опциями для выбора стиля шрифта
    Panel pStyle = new Panel();
    pStyle.setLayout(new GridLayout(6, 1));
    pStyle.setBounds(width / 3 + 5, 0, width / 3 - 10, height);
    Label lblStyle = new Label("Задаём стиль шрифта:");
    pStyle.add(lblStyle);

    // Опция для выбора/отмены жирного стиля
    bold = new Checkbox(" Жирный стиль", false);
    bold.addItemListener(this);
    pStyle.add(bold);

    italic = new Checkbox(" Курсивный стиль", false);
    italic.addItemListener(this);
    pStyle.add(italic);

    Panel pSize = new Panel();
    pSize.setLayout(null);
    pSize.setBounds(
        2 * width / 3 + 5, 0, width / 3 - 10, height);
    Label lblSize = new Label("Размер шрифта:");
    lblSize.setBounds(
        5, lblStyle.getY(), width / 3 - 20, height / 6);
    pSize.add(lblSize);

    // создаём список
    size = new List();
    for (int i = 12; i <= 24; i++) {
      size.add(" " + i + " ");
    }
    // в списке выбираем первый пункт
    size.select(0);
    size.setBounds(
        lblSize.getX(), height / 6 + 10,
        width / 3 - 20, 2 * height / 3 - 5);
    size.addItemListener(this);
    pSize.add(size);

    // На панель добавляется первая (с переключателями) внутренняя панель
    add(pType);
    // На панель добавляется вторая (с опциями) внутренняя панель
    add(pStyle);
    // На панель добавляется третья (со списком) внутренняя панель
    add(pSize);
  }

  // метод для обработки событий изменения состояния элементов управления
  // (переключателей, опций и списка) на панели
  @Override
  public void itemStateChanged(ItemEvent e) {
    // определяем состояния опционного пункта меню для выбора жирного стиля
    ((CheckboxMenuItem) frame.menu.mFont.getItem(0))
        .setState(bold.getState());
    ((CheckboxMenuItem) frame.menu.mFont.getItem(1))
        .setState(italic.getState());
    // применяем новые настройки для образца текста
    frame.pnlText.setTextAndFont(getMainFont());
  }

  // Метод для вычисления шрифта на основе настроек
  public Font getMainFont() {
    String type;
    int style;
    int size;

    // вычисляем тип шрифта
    if (dialog.getState()) {
      type = Font.DIALOG;
    } else if (serif.getState()) {
      type = Font.SERIF;
    } else if (sansserif.getState()) {
      type = Font.SANS_SERIF;
    } else {
      type = Font.MONOSPACED;
    }
    // определим стиль шрифта
    //      начальное значение
    style = Font.PLAIN;
    if (bold.getState()) {
      style |= Font.BOLD;
    }
    if (italic.getState()) {
      style |= Font.ITALIC;
    }
    // определим размер шрифта
    size = this.size.getSelectedIndex() + 12;

    // создаем объект шрифта
    return new Font(type, style, size);
  }
}
