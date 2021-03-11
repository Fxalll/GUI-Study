package S1;

import java.awt.*;

public class S4_1_GridLayout {
    public static void main(String[] args) {
        Frame frame = new Frame("Test");
        Button btn1 = new Button("btn1");
        Button btn2 = new Button("btn2");
        Button btn3 = new Button("btn3");
        Button btn4 = new Button("btn4");
        Button btn5 = new Button("btn5");
        Button btn6 = new Button("btn6");

        frame.setLayout(new GridLayout(3,2));

        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);
        frame.add(btn5);
        frame.add(btn6);

//        frame.setSize(200,200);
        frame.pack();
        frame.setVisible(true);
    }
}
