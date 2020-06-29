package ThirdPracticePackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class CountForm extends JFrame {

    private final String ENTER_VALUE = "Введите радиус";
    private final String NEXT = "Дальше";
    private final String STEP = "Вы на номере: ";

    private int size;
    private int i = 0;

    private Storage storage = Storage.getInstance();

    private JLabel label1 = new JLabel(ENTER_VALUE);
    private JLabel labelStep = new JLabel(STEP + 0);
    private JTextField valueField = new JTextField(10);
    private JButton nextButton = new JButton(NEXT);

    private SomeActions someActions = new SomeActions();

    public CountForm(String name, int size) {
        super(name);
        this.size = size;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(400, 200);
        setResizable(true);
        setLocationRelativeTo(null);
        addElements();
        addCustomListeners();
    }

    private void addElements() {
        add(label1);
        add(labelStep);
        add(nextButton);
        add(valueField);
    }

    private void addCustomListeners() {
        nextButton.addActionListener(someActions);
    }

    private class SomeActions implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                if(actionEvent.getSource() == nextButton) {
                    if(i < size) {
                        labelStep.setText(STEP + ++i);
                        double diameter = Double.parseDouble(valueField.getText());
                        valueField.setText("");
                        double result = Math.PI * 0.25 * diameter * diameter;
                        storage.add(result);
                    } else {
                        FormWindow.showResults();
                        setVisible(false);
                        dispose();
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Введите корректные значения!");
            }
        }
    }


}
