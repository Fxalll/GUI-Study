package S1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class S2_Panel_and_exit {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Panel panel = new Panel();
        frame.setLayout(null);

        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(40,100,20));

        panel.setBounds(50,50,300,300);
        panel.setBackground(new Color(1,1,1));

        frame.add(panel);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
