package ThirdPracticePackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormWindow extends JFrame {
    private final String NUMBER_OF_TRIES = "Введите количество попыток : ";
    private final String ENTER_VALUE = "Введите значения d: ";

    private final String CLEAR_DATA = "Стереть данные";
    private final String COUNT_SIZE = "Подсчитать площадь";
    private static final String DRAW = "Нарисовать фигуру";

    private JLabel label1 = new JLabel(ENTER_VALUE);
    private JLabel label2 = new JLabel(NUMBER_OF_TRIES);
    private static JLabel resultLabel = new JLabel("");

    private JTextField  numberOfTries = new JTextField(10);

    private JButton clearBtn = new JButton(CLEAR_DATA);
    private JButton drawBtn = new JButton(DRAW);
    private JButton countBtn = new JButton(COUNT_SIZE);

    private double radius ,c, resultS;
    private String b;
    private SomeActions action = new SomeActions();

    public FormWindow(String name) {
        super(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        addElements();
        addCustomListeners();
    }

    private void addCustomListeners() {
        clearBtn.addActionListener(action);
        countBtn.addActionListener(action);
        drawBtn.addActionListener(action);
    }

    private void addElements() {
        add(label2);
        add(numberOfTries);
        add(clearBtn);
        add(countBtn);
        add(resultLabel);
        add(drawBtn);
    }

    private class SomeActions implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                if ((actionEvent.getSource()) == countBtn) {
                    int number = Integer.parseInt(numberOfTries.getText());
                    if (number < 1) {
                        throw new Exception();
                    }
                    CountForm form = new CountForm("Form", number);
                    form.setVisible(true);
                }
                if ((actionEvent.getSource()) == clearBtn) {
                    numberOfTries.setText("");
                }
                if((actionEvent.getSource()) == drawBtn) {
                    new Draw().setVisible(true);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Введите корректные значения!");
            }
        }
    }

    public static void showResults() {
        resultLabel.setText("Последний результат: " + Storage.getInstance().getLast());
    }
}