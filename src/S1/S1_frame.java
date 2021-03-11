package S1;

import java.awt.*;

public class S1_frame {
    public static void main(String[] args) {
        Frame frame = new Frame("myFirstGUI");
        frame.setVisible(true);
        frame.setSize(400,400);
        frame.setBackground(new Color(213, 213, 213));
        frame.setLocation(200,200);
        frame.setResizable(true);

    }
}
