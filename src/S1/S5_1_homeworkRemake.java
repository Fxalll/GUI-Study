package S1;

import java.awt.*;

public class S5_1_homeworkRemake {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setLayout(new GridLayout(2,1));
        Panel panel01 = new Panel(new BorderLayout());
        Panel panel02 = new Panel(new GridLayout(2,1));
        Panel panel03 = new Panel(new BorderLayout());
        Panel panel04 = new Panel(new GridLayout(2,2));

        panel01.add(new Button("1"),BorderLayout.WEST);
        panel01.add(new Button("2"),BorderLayout.EAST);
        panel02.add(new Button("3"));
        panel02.add(new Button("4"));
        panel01.add(panel02,BorderLayout.CENTER);

        panel03.add(new Button("5"),BorderLayout.WEST);
        panel03.add(new Button("6"),BorderLayout.EAST);
        for (int i=7;i<=10;i++){
            panel04.add(new Button(""+i));
        }
        panel03.add(panel04,BorderLayout.CENTER);

        frame.add(panel01);
        frame.add(panel03);

        frame.setSize(400,300);
        frame.setLocation(300,400);
        frame.setVisible(true);



    }
}
