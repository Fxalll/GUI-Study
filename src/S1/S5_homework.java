package S1;

import java.awt.*;

public class S5_homework {
    public static void main(String[] args) {
        Frame frame = new Frame("test");

        Button button01 = new Button("Button01");
        Button button02 = new Button("Button02");
        Button button03 = new Button("Button03");
        Button button04 = new Button("Button04");
        Button button05 = new Button("Button05");
        Button button06 = new Button("Button06");
        Button button07 = new Button("Button07");
        Button button08 = new Button("Button08");
        Button button09 = new Button("Button09");
        Button button10 = new Button("Button10");

        frame.setLayout(new GridLayout(2,1));
        Panel panel01 = new Panel(new BorderLayout());
        Panel panel02 = new Panel(new GridLayout(2,1));
        Panel panel03 = new Panel(new BorderLayout());
        Panel panel04 = new Panel(new GridLayout(2,2));

        panel01.add(button01,BorderLayout.EAST);
        panel01.add(button02,BorderLayout.WEST);
        panel02.add(button03);
        panel02.add(button04);
        panel01.add(panel02,BorderLayout.CENTER);

        panel03.add(button05,BorderLayout.EAST);
        panel03.add(button06,BorderLayout.WEST);
        panel04.add(button07);
        panel04.add(button08);
        panel04.add(button09);
        panel04.add(button10);
        panel03.add(panel04,BorderLayout.CENTER);

        frame.add(panel01);
        frame.add(panel03);

        frame.setSize(300,400);
        frame.setLocation(400,300);
        frame.setVisible(true);
    }
}
