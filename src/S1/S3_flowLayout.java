package S1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class S3_flowLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();

        Button button01 = new Button("button01");
        Button button02 = new Button("button02");
        Button button03 = new Button("button03");

        frame.setLayout(new FlowLayout(FlowLayout.CENTER)); //流式布局
        frame.setSize(200,200);

        frame.add(button01);
        frame.add(button02);
        frame.add(button03);

        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }
}
