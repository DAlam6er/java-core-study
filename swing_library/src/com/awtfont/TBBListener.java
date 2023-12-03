package com.awtfont;

import java.awt.event.MouseEvent;

// интерфейс обработки события щелчка на кнопке панели инструментов
public interface TBBListener {
  void makeAction(MouseEvent mouseEvent);
}
