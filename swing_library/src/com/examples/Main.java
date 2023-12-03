package com.examples;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.beans.EventHandler;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Stream;

public class Main {
  final static JFrame jFrame = getFrame();
  final static JPanel jPanel = new JPanel();

  public static void main(String[] args) {
    //drawSomeElements();
    //addPanelWithTestButton();
    //addPaneWithTestButtonWithEventHandler();
    //showLookAndFeelInfo();
    //addPaneWithStylishButtons();
    //addPaneWithTestButtonAndKeyStroke();
    //changeBackgroundOnMouseClick();
    //drawMouseCoordinates();
    //addSomeTextFields();
    //addSomeChooseComponents();
    //addSlider();
    //addMenuBar();
    //addPopupMenu();
    //addToolBar();
    //addFocus();
    //addDialogWindows();
    //addCustomDialog();
    //addPickColorDialog();
    //addFileDialog();
    //addBorderGridLayout();
    //addGridBagLayout();
    addCustomLayout();
    jFrame.setVisible(true);
  }

  static void addCustomLayout() {
    jFrame.add(jPanel);
    jPanel.setLayout(new CustomLayout());
    jPanel.add(new JButton("submit1"));
    jPanel.add(new JButton("submit2"));
    jPanel.add(new JButton("submit3"));
  }

  static void addGridBagLayout() {
    GridBagLayout gridBagLayout = new GridBagLayout();
    jPanel.setLayout(gridBagLayout);

    GridBagConstraints constraints1 = new GridBagConstraints();
    constraints1.weightx = 0;
    constraints1.weighty = 0;
    constraints1.gridx = 0;
    constraints1.gridy = 0;
    constraints1.gridheight = 2;
    constraints1.gridwidth = 2;
    jPanel.add(new JTextArea(4, 20), constraints1);

    GridBagConstraints constraints2 = new GridBagConstraints();
    constraints2.weightx = 0;
    constraints2.weighty = 0;
    constraints2.gridx = 2;
    constraints2.gridy = 0;
    constraints2.gridheight = 1;
    constraints2.gridwidth = 2;
    jPanel.add(new JButton("Кнопка с длинным именем"), constraints2);

    GridBagConstraints constraints3 = new GridBagConstraints();
    constraints3.weightx = 0;
    constraints3.weighty = 0;
    constraints3.gridx = 2;
    constraints3.gridy = 1;
    constraints3.gridheight = 1;
    constraints3.gridwidth = 1;
    jPanel.add(new JButton("Button1"), constraints3);

    GridBagConstraints constraints4 = new GridBagConstraints();
    constraints4.weightx = 0;
    constraints4.weighty = 0;
    constraints4.gridx = 3;
    constraints4.gridy = 1;
    constraints4.gridheight = 1;
    constraints4.gridwidth = 1;
    jPanel.add(new JButton("Button2"), constraints4);

    jFrame.add(jPanel);
  }

  static void addBorderGridLayout() {
    jPanel.setLayout(new GridLayout(2, 2));
    jPanel.add(new JButton("one"));
    jPanel.add(new JButton("two"));
    jPanel.add(new JButton("three"));
    jPanel.add(new JButton("four"));

    jFrame.add(jPanel);
  }

  static void addFileDialog() {
    jFrame.add(jPanel);
    JButton jbtnOpenDialog = new JButton("open file");
    JButton jbtnSaveDialog = new JButton("save file");

    jbtnOpenDialog.addActionListener(e -> {
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setCurrentDirectory(new File("."));
      File startFile = new File("./results.txt");
      String startSize =
          String.format("%.2f Kb", startFile.length() / 1024d);

      fileChooser.setSelectedFile(startFile);
      fileChooser.setMultiSelectionEnabled(true);
      fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
      fileChooser.setFileFilter(new FileFilter() {
        @Override
        public boolean accept(File f) {
          return f.getName().endsWith("txt");
        }

        @Override
        public String getDescription() {
          return "*.txt files only";
        }
      });

      TextField textField = new TextField(startSize, 5);
      textField.setEditable(false);
      JPanel jtextPanel = new JPanel();
      jtextPanel.add(textField);

      fileChooser.addPropertyChangeListener(new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
          if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(
              evt.getPropertyName())) {
            JFileChooser chooser = (JFileChooser) evt.getSource();
                        /*
                        File oldFile = (File) evt.getOldValue();
                        File newFile = (File) evt.getNewValue();
                        System.out.println("Was selected: " + oldFile);
                        System.out.println("Selected now: " + newFile);
                         */

            if (chooser.getSelectedFile() != null) {
              textField.setText(String.format("%.2f Kb",
                  chooser.getSelectedFile().length() / 1024d));
            }
          } else if (JFileChooser.SELECTED_FILES_CHANGED_PROPERTY
              .equals(evt.getPropertyName())) {
            JFileChooser chooser = (JFileChooser) evt.getSource();

            if (chooser.getSelectedFile() != null) {
              textField.setText(String.format("%.2f Kb",
                  Stream.of(chooser.getSelectedFiles())
                      .map(file -> file.length() / 1024d)
                      .reduce(0d, Double::sum)));
            }
          }
        }
      });

      fileChooser.add(jtextPanel, BorderLayout.WEST);
      int resOfOpen = fileChooser.showOpenDialog(jPanel);

      File file = fileChooser.getSelectedFile();
      if (resOfOpen == JFileChooser.APPROVE_OPTION) {
        System.out.println(file.getName() + " was selected");
      } else if (resOfOpen == JFileChooser.CANCEL_OPTION) {
        System.out.println("User cancelled file opening");
      }
    });
    jbtnSaveDialog.addActionListener(e -> {
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.showSaveDialog(jPanel);
    });

    jPanel.add(jbtnOpenDialog);
    jPanel.add(jbtnSaveDialog);
  }

  static void addPickColorDialog() {
    jFrame.add(jPanel);

    JButton jButton = new JButton("pick color");
    jPanel.add(jButton);
    jButton.addActionListener(e -> {
      Color color = JColorChooser.showDialog(jPanel, "title", Color.blue);
      jPanel.setBackground(color);
    });
  }

  static void addCustomDialog() {
    jFrame.add(jPanel);
    JButton jButton = new JButton("show dialog");
    jButton.addActionListener(e -> {
      CustomDialog customDialog = new CustomDialog();
      customDialog.setVisible(true);
    });
    jPanel.add(jButton);
  }

  static void addDialogWindows() {
    jFrame.add(jPanel);
    JButton jbtnMessageDialog = new JButton("Show message dialog");
    JButton jbtnConfirmDialog = new JButton("Show confirm dialog");
    JButton jbtnOptionDialog = new JButton("Show option dialog");
    JButton jbtnInputDialog = new JButton("Show input dialog");

    jbtnMessageDialog.addActionListener(
        e -> JOptionPane.showMessageDialog(
            jPanel, "This is my dialog",
            "title", JOptionPane.INFORMATION_MESSAGE));

    final int[] answer = new int[1];
    jbtnConfirmDialog.addActionListener(
        e -> {
          answer[0] = JOptionPane.showConfirmDialog(
              jPanel, "some message",
              "title", JOptionPane.YES_NO_OPTION);
          System.out.println(answer[0]);
        });

    jbtnOptionDialog.addActionListener(
        e -> JOptionPane.showOptionDialog(
            jPanel, "message", "title",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, new Object[]{"one", "two", "three"},
            "two"));

    jbtnInputDialog.addActionListener(e ->
        JOptionPane.showInputDialog(jPanel, "some message"));

    jPanel.add(jbtnMessageDialog);
    jPanel.add(jbtnConfirmDialog);
    jPanel.add(jbtnOptionDialog);
    jPanel.add(jbtnInputDialog);
  }

  static void addFocus() {
    jFrame.add(jPanel);

    jPanel.add(new JButton("submit1"));
    jPanel.add(new JButton("submit2")).setFocusable(false);
    jPanel.add(new JButton("submit3")).requestFocusInWindow();
  }

  static void addToolBar() {
    jFrame.add(jPanel);

    JToolBar jToolBar = new JToolBar("title");
    JButton btnOne = new JButton("one");
    btnOne.setToolTipText("first button");

    jToolBar.add(btnOne);
    jToolBar.addSeparator();
    jToolBar.add(new JButton("two"));
    jToolBar.add(new JButton("three"));

    jPanel.add(jToolBar);
  }

  static void addPopupMenu() {
    jFrame.add(jPanel);

    JPopupMenu jPopupMenu = new JPopupMenu();
    jPopupMenu.add(new JMenuItem("Cut", 't'));
    jPopupMenu.add(new JMenuItem("Copy", 'C'));
    jPopupMenu.add(new JMenuItem("Insert", 'I'));
    jPopupMenu.add(new JMenuItem("Delete", 'D'));
    jPopupMenu.add(new JMenuItem("Clear", 'l'));

    jPanel.setComponentPopupMenu(jPopupMenu);
  }

  static void addMenuBar() {
    JMenuBar jMenuBar = new JMenuBar();
    JMenu file = new JMenu("File");
    file.setMnemonic('F');
    JMenu edit = new JMenu("Edit");
    edit.setMnemonic('E');
    jMenuBar.add(file);
    jMenuBar.add(edit);

    JMenuItem mnuOpen = new JMenuItem("Open", new ImageIcon(
        "../swing/img/открыть-файл-под-курсором-24x24.png"));
    mnuOpen.setMnemonic('O');
    mnuOpen.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));

    JMenuItem mnuSave = new JMenuItem("Save", new ImageIcon(
        "../swing/img/сохранить-24x24.png"));
    mnuSave.setMnemonic('S');
    mnuSave.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
    mnuSave.setEnabled(false);

    JMenuItem mnuExit = new JMenuItem("Exit", 'x');
    mnuExit.addActionListener(e -> jFrame.dispose());
    mnuExit.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));

    file.add(mnuOpen);
    file.add(mnuSave);
    file.addSeparator();
    file.add(mnuExit);

    JMenu options = new JMenu("Options");
    options.add("one");
    options.add("two");

    ButtonGroup buttonGroup = new ButtonGroup();
    JRadioButtonMenuItem radioButtonMenuItem1 =
        new JRadioButtonMenuItem("Radio1");
    JRadioButtonMenuItem radioButtonMenuItem2 =
        new JRadioButtonMenuItem("Radio2");
    buttonGroup.add(radioButtonMenuItem1);
    buttonGroup.add(radioButtonMenuItem2);

    edit.add(new JMenuItem("Cut", 't'));
    edit.add(new JMenuItem("Copy", 'C'));
    edit.add(options);
    edit.add(new JCheckBoxMenuItem("checkBox"));
    edit.add(radioButtonMenuItem1);
    edit.add(radioButtonMenuItem2);

    jFrame.setJMenuBar(jMenuBar);
  }

  static void addSlider() {
    jFrame.add(jPanel);
    // элемент множественного выбора
    JSlider jSlider =
        new JSlider(JSlider.HORIZONTAL, 0, 100, 20);
    jSlider.setMinorTickSpacing(10);
    jSlider.setMajorTickSpacing(20);
    jSlider.setPaintTicks(true);
    jSlider.setSnapToTicks(true);
    jSlider.setPaintLabels(true);
    jPanel.add(jSlider);
  }

  static void addSomeChooseComponents() {
    jFrame.add(jPanel);
    JCheckBox jCheckBox = new JCheckBox("check box №1");
    JRadioButton jRadioButton1 = new JRadioButton("yes");
    JRadioButton jRadioButton2 = new JRadioButton("no");
    jRadioButton2.setSelected(true);
    JRadioButton jRadioButton3 = new JRadioButton("cancel");
    ButtonGroup buttonGroup = new ButtonGroup();
    buttonGroup.add(jRadioButton1);
    buttonGroup.add(jRadioButton2);
    buttonGroup.add(jRadioButton3);

    JPanel radioPanel = new JPanel();
    radioPanel.add(jRadioButton1);
    radioPanel.add(jRadioButton2);
    radioPanel.add(jRadioButton3);

    JComboBox<String> comboBox = new JComboBox<>();
    comboBox.addItem("Oracle");
    comboBox.addItem("MSSQL");
    comboBox.addItem("PostgreSQL");
    comboBox.addItem("MySQL");
    comboBox.addItem("Derby");

    Border border = BorderFactory.createEtchedBorder();
    Border titled =
        BorderFactory.createTitledBorder(border, "destiny choice");
    jPanel.setBorder(border);
    radioPanel.setBorder(titled);

    jPanel.add(jCheckBox);
    jPanel.add(radioPanel);
    jPanel.add(comboBox);
  }

  static void addSomeTextFields() {
    jFrame.add(jPanel);
    // 20 - это число столбцов. Определяет предпочитаемую ширину поля ввода
    JTextField jTextField = new JTextField("default value", 20);
    System.out.println(jTextField.getText());

    JLabel jLabel = new JLabel("Some label");
    System.out.println(jLabel.getText());

    JPasswordField jPasswordField = new JPasswordField(20);

    JTextArea jTextArea = new JTextArea(5, 20);
    jTextArea.setLineWrap(true);
    jTextArea.setWrapStyleWord(true);
    // Создаем объект JScrollPane и присваиваем ему текстовую область,
    // которую он будет прокручивать
    JScrollPane jScrollPane = new JScrollPane(jTextArea);

    jPanel.add(jLabel);
    jPanel.add(jTextField);
    jPanel.add(jPasswordField);
    // Важно! Добавляем на панель область прокрутки, а не саму текстовую область
    jPanel.add(jScrollPane);
    //jPanel.revalidate();
  }

  static void changeBackgroundOnMouseClick() {
    jFrame.add(jPanel);
    jPanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        jPanel.setBackground(Color.blue);
      }
    });
  }

  static void drawMouseCoordinates() {
    JComponent jComponent = new ComponentWithMouseCoords();
    jFrame.add(jComponent);
    jFrame.addMouseMotionListener(new MouseAdapter() {
      @Override
      public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
        ComponentWithMouseCoords.xCoord = e.getX();
        ComponentWithMouseCoords.yCoord = e.getY();
        jComponent.repaint();
      }
    });
  }

  static void addPaneWithTestButtonAndKeyStroke() {
    //JPanel jPanel = new JPanel();
    jFrame.add(jPanel);
    AbstractAction myAction = new MyAction();
    JButton jButton = new JButton(myAction);
    jButton.setText("submit");
    jPanel.add(jButton);

    KeyStroke keyStroke = KeyStroke.getKeyStroke("ctrl B");
    InputMap inputMap = jPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    // An input map binds keystrokes to action names
    // Technically, you don't need to use action names in the maps;
    // you can use any object as the "key" into the maps.
    // By convention, however, you use a string that names an action.
    inputMap.put(keyStroke, "changeColor");
    ActionMap actionMap = jPanel.getActionMap();
    // an action map specifies the action corresponding to each action name
    actionMap.put("changeColor", myAction);
  }

  static void addPaneWithStylishButtons() {
    //JPanel jPanel = new JPanel();
    jFrame.add(jPanel);

    JButton jButton1 = new JButton("Metal");
    JButton jButton2 = new JButton("Nimbus");
    JButton jButton3 = new JButton("CDE/Motif");
    JButton jButton4 = new JButton("Windows");
    JButton jButton5 = new JButton("Windows Classic");

    jPanel.add(jButton1);
    jPanel.add(jButton2);
    jPanel.add(jButton3);
    jPanel.add(jButton4);
    jPanel.add(jButton5);

    jButton1.addActionListener(e -> {
      try {
        UIManager.setLookAndFeel(
            "javax.swing.plaf.metal.MetalLookAndFeel");
        jFrame.repaint();
      } catch (ClassNotFoundException | InstantiationException |
               IllegalAccessException |
               UnsupportedLookAndFeelException ex) {
        System.out.println(ex.getMessage());
      }
    });
    jButton2.addActionListener(e -> {
      try {
        UIManager.setLookAndFeel(
            "javax.swing.plaf.nimbus.NimbusLookAndFeel");
        jFrame.repaint();
      } catch (ClassNotFoundException | InstantiationException |
               IllegalAccessException |
               UnsupportedLookAndFeelException ex) {
        System.out.println(ex.getMessage());
      }
    });
    jButton3.addActionListener(e -> {
      try {
        UIManager.setLookAndFeel(
            "com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        jFrame.repaint();
      } catch (ClassNotFoundException | InstantiationException |
               IllegalAccessException |
               UnsupportedLookAndFeelException ex) {
        System.out.println(ex.getMessage());
      }
    });
    jButton4.addActionListener(e -> {
      try {
        UIManager.setLookAndFeel(
            "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        jFrame.repaint();
      } catch (ClassNotFoundException | InstantiationException |
               IllegalAccessException |
               UnsupportedLookAndFeelException ex) {
        System.out.println(ex.getMessage());
      }
    });
    jButton5.addActionListener(e -> {
      try {
        UIManager.setLookAndFeel(
            "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        jFrame.repaint();
      } catch (ClassNotFoundException | InstantiationException |
               IllegalAccessException |
               UnsupportedLookAndFeelException ex) {
        System.out.println(ex.getMessage());
      }
    });
  }

  static void showLookAndFeelInfo() {
    UIManager.LookAndFeelInfo[] lookAndFeelInfos = UIManager.getInstalledLookAndFeels();
    for (UIManager.LookAndFeelInfo lookAndFeelInfo : lookAndFeelInfos) {
      System.out.println(lookAndFeelInfo.getName());
      System.out.println(lookAndFeelInfo.getClassName());
    }
  }

  static void addPaneWithTestButtonWithEventHandler() {
    //JPanel jPanel = new JPanel();
    jFrame.add(jPanel);

    JButton jButton = new JButton("submit");
    jPanel.add(jButton);
        /*
        jButton.addActionListener(
            e -> jFrame.setTitle(((JButton)e.getSource()).getText()));
         */
    jButton.addActionListener(
        EventHandler.create(
            ActionListener.class, jFrame, "title", "source.text"));
  }

  static void addPanelWithTestButton() {
    //JPanel jPanel = new JPanel();
    jFrame.add(jPanel);

    JButton jButton = new JButton("submit");
    jPanel.add(jButton);
    // сложности с передачей jPanel (если она не вынесена в поле) в отдельный класс
    //jButton.addActionListener(new MyListener(jPanel));
    // Проще использовать анонимный класс в виде лямбды
    jButton.addActionListener(e -> jPanel.setBackground(Color.blue));
  }

  static void drawSomeElements() {
    jFrame.add(new ComponentWithDrawings());
  }

  static JFrame getFrame() {
    JFrame jFrame = new JFrame();

    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(
            dimension.width/2 - 250,
            dimension.height/2 - 150, 500,300);
         */
    jFrame.setSize(800, 700);
    jFrame.setLocationRelativeTo(null);
    jFrame.setTitle("Test swing app");
    //jFrame.setVisible(true);
        /*
        jFrame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                super.windowClosing(e);
                // my code here
            }
        });
         */
    return jFrame;
  }

  static class CustomLayout implements LayoutManager {
    @Override
    public void addLayoutComponent(String name, Component comp) {

    }

    @Override
    public void removeLayoutComponent(Component comp) {

    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
      return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
      return null;
    }

    @Override
    public void layoutContainer(Container parent) {
      for (int i = 0; i < parent.getComponentCount(); i++) {
        Component component = parent.getComponent(i);
        component.setBounds(i * 100, i * 40, 100, 40);
      }
    }
  }

  static class CustomDialog extends JDialog {
    public CustomDialog() {
      super(jFrame, "Title", true);
      add(new JTextField(), BorderLayout.NORTH);
      add(new JButton("submit"), BorderLayout.SOUTH);
      setSize(300, 200);
      setLocationRelativeTo(null);
    }
  }

  static class ComponentWithMouseCoords extends JComponent {
    public static int xCoord;
    public static int yCoord;

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawString(
          "Coordinates x: " + xCoord + " y: " + yCoord, 50, 50);
    }
  }

  static class MyListener implements ActionListener {
    final JPanel jPanel;

    MyListener(JPanel jPanel) {
      this.jPanel = jPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      jPanel.setBackground(Color.blue);
    }
  }

  static class MyAction extends AbstractAction {
    MyAction() {
      // The key used for storing a short String description
      // for the action, used for tooltip text.
      putValue(AbstractAction.SHORT_DESCRIPTION,
          "Change background color");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      jPanel.setBackground(Color.blue);
    }
  }

  static class ComponentWithDrawings extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      // Список существующих шрифтов в системе
            /*
            String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();
            for (String font : fonts) {
                System.out.println(font);
            }
             */
      Font font = new Font("Bitstream Charter", Font.BOLD, 20);
      g2.setFont(font);
      g2.drawString("hello world", 20, 20);

      Line2D line1 = new Line2D.Float(70, 250, 110, 330);
      g2.setPaint(Color.green);
      g2.draw(line1);

      Point2D p1 = new Point2D.Double(70, 70);
      Point2D p2 = new Point2D.Double(170, 170);
      Line2D line2 = new Line2D.Double(p1, p2);
      g2.setPaint(Color.black);
      g2.draw(line2);

      Ellipse2D ellipse1 = new Ellipse2D.Float(70, 250, 40, 80);
      g2.draw(ellipse1);

      Ellipse2D ellipse2 = new Ellipse2D.Float();
      ellipse2.setFrameFromDiagonal(p1, p2);
      g2.setPaint(Color.red);
      g2.fill(ellipse2);

      //Rectangle2D rect1 = new Rectangle2D.Float(100, 100, 80, 80);
      Rectangle2D rect1 = new Rectangle2D.Float();
      rect1.setFrameFromDiagonal(p1, p2);
      g2.draw(rect1);

      try {
        URL url = new URL(
            "https://cdn-icons-png.flaticon.com/512/226/226777.png");
        Image image1 = new ImageIcon(url).getImage();
        g2.drawImage(image1, 220, 50, null);
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }

      Image image2 = new ImageIcon("../swing/img/tomcat.png").getImage();
      g2.drawImage(image2, 300, 50, null);
    }
  }
}