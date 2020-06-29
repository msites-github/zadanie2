package ThirdPracticePackage;

import javax.swing.*;
import java.awt.*;

public class Draw extends JFrame {
    Draw() {
        super("Main window");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        setVisible(true);
    }
    public void paint(Graphics g){
        g.drawOval(45,45,250,250);
    }

}