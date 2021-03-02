import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Класс наследуется, чтобы удобнее было добавлять действия для кнопок
public class GroupWindow implements ActionListener {
    private JFrame mainWindow; // Главное окно для приложения
    private JPanel mainPanel; // Панель, на которую будут добавляться все элементы
    private GridLayout mainLayout; // Раскладка для окна. Определяет как будут располагаться элементы на панели
    private Font mainFont; // Шрифт для ввода


    // Элементы из группы 1
    private JTextField groupOneTextField; // Текстовое поле
    private JComboBox<String> groupOneComboBox; // Поле со списком, <String> значит что поля списка будут хранить строку
    private RoundButton groupOneInputButton; // Кнопка для ввода


    // Элементы из группы 2
    private JTextField groupTwoTextField; // Текстовое поле
    private RoundButton groupTwoInputButton; // Кнопка для ввода поле
    private RoundButton groupTwoSwapButton; // Кнопка, чтобы поменять надписи на кнопках


    // Элементы группы 3
    private JTextField groupThreeTextField; // Текстовое поле
    private RoundButton groupThreeInputButton; // Кнопка для ввода
    private JRadioButton groupThreeRadioOne; // Кнопочки эти круглые бля
    private JRadioButton groupThreeRadioTwo;
    private JRadioButton groupThreeRadioThree;


    // Элементы группы 4
    private JTextField groupFourTextField; // Текстовое поле
    private RoundButton groupFourInputButton; // Кнопка для ввода
    private JCheckBox groupFourCheckOne; // Кнопки как из заметок
    private JCheckBox groupFourCheckTwo;
    private JCheckBox groupFourCheckThree;


    // Элементы группы 5
    private JTextField groupFiveTextField; // Текстовое поле
    private RoundButton groupFiveInputButtonOne; // Кнопка для ввода
    private RoundButton groupFiveSwapButtonOne;  // Кнопка для занесения элемента во вторую колонку
    private RoundButton groupFiveSwapButtonTwo; // Кнопка для занесения элемента в первую колонку
    private JTable groupFiveTable; // Таблица


    public GroupWindow(int width, int height) {
        mainWindow = new JFrame(); // Создание окна
        mainPanel = new JPanel(); // Создание панели

        mainLayout = new GridLayout(5, 1); // Новая раскладка, где 5 рядов и одна колонка
        mainLayout.setVgap(50); // Расстояние между рядами

        mainPanel.setLayout(mainLayout); // Добавление раскладки  на главную панель

        mainFont = new Font("Times Roman", Font.PLAIN, 30); // Создание нового шрифта

        mainWindow.setSize(width, height); // Установка размера окна
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Эта хуйня нужна, чтобы окно можно было на крестик закрыть


        // Создание всех групп из задания
        createGroup1();
        createGroup2();
        createGroup3();
        createGroup4();
        createGroup5();

        mainWindow.add(mainPanel); // Добавление главное панели в окно
        mainWindow.setVisible(true); // Отображение окна
    }

    public void createGroup1() {
        var groupOneLayout = new GridLayout(1, 3);  // Раскладка для первой группы, 1 ряд и три колонки для каждого элемента

        var groupOnePanel = new JPanel(); // Новая панель для первой группы элементов
        groupOnePanel.setLayout(groupOneLayout); // Установка раскладки

        groupOneTextField = new JTextField(); // Создание нового текстового поля
        groupOneTextField.setFont(mainFont); // Установка шрифта для текстового поля

        groupOneComboBox = new JComboBox<String>(); // Создание пустого списка
        groupOneComboBox.setFont(mainFont); // Установка поля для списка

        groupOneInputButton = new RoundButton("Занести"); // Создание новой кнопки
        groupOneInputButton.addActionListener(this); // Добавление хуйни, которая смотрит что ты там с этой кнопкой делаешь

        // Добавление всех элементов на панель
        groupOnePanel.add(groupOneTextField);
        groupOnePanel.add(groupOneComboBox);
        groupOnePanel.add(groupOneInputButton);

        // Добавление панели группы на главную панель
        mainPanel.add(groupOnePanel);
    }

    public void createGroup2() {
        var groupTwoLayout = new GridLayout(1, 3);

        var groupTwoPanel = new JPanel();
        groupTwoPanel.setLayout(groupTwoLayout);

        groupTwoTextField = new JTextField();
        groupTwoTextField.setFont(mainFont);

        groupTwoInputButton = new RoundButton("Отобразить");
        groupTwoSwapButton = new RoundButton("Поменять");

        groupTwoInputButton.addActionListener(this);
        groupTwoSwapButton.addActionListener(this);

        groupTwoPanel.add(groupTwoTextField);
        groupTwoPanel.add(groupTwoInputButton);
        groupTwoPanel.add(groupTwoSwapButton);

        mainPanel.add(groupTwoPanel);
    }

    public void createGroup3() {
        var groupThreeLayout = new GridLayout(1, 5);

        var groupThreePanel = new JPanel();
        groupThreePanel.setLayout(groupThreeLayout);

        groupThreeTextField = new JTextField();
        groupThreeTextField.setFont(mainFont);

        groupThreeInputButton = new RoundButton("Пометить");
        groupThreeInputButton.addActionListener(this);

        groupThreeRadioOne = new JRadioButton("Кнопка 1");
        groupThreeRadioTwo = new JRadioButton("Кнопка 2");
        groupThreeRadioThree = new JRadioButton("Кнопка 3");

        groupThreePanel.add(groupThreeTextField);
        groupThreePanel.add(groupThreeInputButton);
        groupThreePanel.add(groupThreeRadioOne);
        groupThreePanel.add(groupThreeRadioTwo);
        groupThreePanel.add(groupThreeRadioThree);

        mainPanel.add(groupThreePanel);
    }

    public void createGroup4() {
        var groupFourLayout = new GridLayout(1, 5);

        var groupFourPanel = new JPanel();
        groupFourPanel.setLayout(groupFourLayout);

        groupFourTextField = new JTextField();
        groupFourTextField.setFont(mainFont);

        groupFourInputButton = new RoundButton("Пометить");
        groupFourInputButton.addActionListener(this);

        groupFourCheckOne = new JCheckBox("Кнопка 1");
        groupFourCheckTwo = new JCheckBox("Кнопка 2");
        groupFourCheckThree = new JCheckBox("Кнопка 3");

        groupFourPanel.add(groupFourTextField);
        groupFourPanel.add(groupFourInputButton);
        groupFourPanel.add(groupFourCheckOne);
        groupFourPanel.add(groupFourCheckTwo);
        groupFourPanel.add(groupFourCheckThree);

        mainPanel.add(groupFourPanel);
    }

    public void createGroup5() {
        var groupFiveLayout = new GridLayout(1, 5);

        var groupFivePanel = new JPanel();
        groupFivePanel.setLayout(groupFiveLayout);

        groupFiveTextField = new JTextField();
        groupFiveTextField.setFont(mainFont);

        groupFiveInputButtonOne = new RoundButton("Занести");
        groupFiveSwapButtonOne = new RoundButton("Перенести");
        groupFiveSwapButtonTwo = new RoundButton("Перенести");

        groupFiveInputButtonOne.addActionListener(this);
        groupFiveSwapButtonOne.addActionListener(this);
        groupFiveSwapButtonTwo.addActionListener(this);

        groupFiveTable = new JTable(10 , 2);

        groupFivePanel.add(groupFiveTextField);
        groupFivePanel.add(groupFiveInputButtonOne);
        groupFivePanel.add(groupFiveSwapButtonOne);
        groupFivePanel.add(groupFiveSwapButtonTwo);
        groupFivePanel.add(groupFiveTable);

        mainPanel.add(groupFivePanel);
    }


    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == groupOneInputButton) {
            String inputText = groupOneTextField.getText(); // Сохраняет текст, который был введен в текстовое поле

            // Проверяет есть ли введенный текст в списке
            var comboBoxModel = (DefaultComboBoxModel<String>) groupOneComboBox.getModel();
            if(comboBoxModel.getIndexOf(inputText) == -1) {
                groupOneComboBox.addItem(inputText);
            }
            // Если такой текст уже есть выводит окно с ошибкой
            else {
                JOptionPane.showMessageDialog(null, "Элемент уже присутствует");
            }
        }
        else if (actionEvent.getSource() == groupTwoInputButton) {
            String inputText = groupTwoTextField.getText();

            // Проверяет, что введена не пустая строка и отображает введенный текст на второй кнопке
            if (!inputText.equals("")) {
                groupTwoSwapButton.setText(inputText);
            }
        }
        else if (actionEvent.getSource() == groupTwoSwapButton) {
            String inputButtonText = groupTwoInputButton.getText();
            String swapButtonText = groupTwoSwapButton.getText();

            // Меняет текст из кнопок местами
            groupTwoSwapButton.setText(inputButtonText);
            groupTwoInputButton.setText(swapButtonText);
        }
        else if (actionEvent.getSource() == groupThreeInputButton) {
            String radioButtonName = groupThreeTextField.getText();

            // Проверяется, есть ли кнопка с таким именем, если есть то активирует ее и деактивирует все другие кнопки
            if (radioButtonName.equals(groupThreeRadioOne.getText())) {
                groupThreeRadioOne.setSelected(true); // true - активирует кнопку, false - деактивирует
                groupThreeRadioTwo.setSelected(false);
                groupThreeRadioThree.setSelected(false);
            }
            else if (radioButtonName.equals(groupThreeRadioTwo.getText())) {
                groupThreeRadioOne.setSelected(false);
                groupThreeRadioTwo.setSelected(true);
                groupThreeRadioThree.setSelected(false);
            }
            else if (radioButtonName.equals(groupThreeRadioThree.getText())) {
                groupThreeRadioOne.setSelected(false);
                groupThreeRadioTwo.setSelected(false);
                groupThreeRadioThree.setSelected(true);
            }
            // Если кнопки с таким именем нет, выводит окно с ошибкой
            else {
                JOptionPane.showMessageDialog(null, "Введенной кнопки не существует");
            }
        }
        else if (actionEvent.getSource() == groupFourInputButton) {
            String checkBoxName = groupFourTextField.getText();

            // Почти то же самое, что в ифе выше, только с другим типом кнопки
            if (groupFourCheckOne.getText().equals(checkBoxName)) {
                // Если кнопка активирована, деактивирует ее и наоборот
                boolean isCheck = groupFourCheckOne.isSelected();
                groupFourCheckOne.setSelected(!isCheck);
            }
            else if (groupFourCheckTwo.getText().equals(checkBoxName)) {
                boolean isCheck = groupFourCheckTwo.isSelected();
                groupFourCheckTwo.setSelected(!isCheck);
            }
            else if (groupFourCheckThree.getText().equals(checkBoxName)) {
                boolean isCheck = groupFourCheckThree.isSelected();
                groupFourCheckThree.setSelected(!isCheck);
            }
            else {
                JOptionPane.showMessageDialog(null, "Введенной кнопки не существует");
            }
        }
        else if (actionEvent.getSource() == groupFiveInputButtonOne) {
            // Берет введенную строку и добавляет ее в таблицу в первую колонку выделенного ряда
            String inputString = groupFiveTextField.getText();
            int selectedRow = groupFiveTable.getSelectedRow(); // Берет номер выделенного ряда

            // Проверяет выделена ли строка и, если она пустая, добавляет ее в первую колонку таблицы
            if (selectedRow != -1 && groupFiveTable.getValueAt(selectedRow, 1) == null) {
                groupFiveTable.setValueAt(inputString, selectedRow, 0);
            }
        }
        else if (actionEvent.getSource() == groupFiveSwapButtonOne) {
            int selectedRow = groupFiveTable.getSelectedRow();
            if (selectedRow == -1) return; // Проверяет, что выделена какая то строка

            var selectedText = groupFiveTable.getValueAt(selectedRow, 0); // Берет значение из первой колонки выделенной строки
            // Если значение не нулевое, переносит значение из первой колонки во вторую
            if (selectedText != null) {
                groupFiveTable.setValueAt(null, selectedRow, 0);
                groupFiveTable.setValueAt(selectedText, selectedRow, 1);
            }
        }
        else if (actionEvent.getSource() == groupFiveSwapButtonTwo) {
            // Делает примерно то же самое, только мпереносит значение из второй колонки в первую
            int selectedRow = groupFiveTable.getSelectedRow();
            if (selectedRow == -1) return;

            var selectedText = groupFiveTable.getValueAt(selectedRow, 1);

            if (selectedText != null) {
                groupFiveTable.setValueAt(null, selectedRow, 1);
                groupFiveTable.setValueAt(selectedText, selectedRow, 0);
            }
        }
    }


    public static void main(String[] args) {
        // размер окна 800 x 800
        var width = 800;
        var height = 800;

        var testWindow = new GroupWindow(width, height);
    }
}
