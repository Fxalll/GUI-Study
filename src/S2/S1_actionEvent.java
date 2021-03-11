package S2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class S1_actionEvent {
    public static void main(String[] args) {
        Frame frame = new Frame("test");
        Button button1 = new Button("start");
        Button button2 = new Button("stop");
        button2.setActionCommand("button2-stop");
        MyMonitor myMonitor = new MyMonitor();
        button1.addActionListener(myMonitor);
        button2.addActionListener(myMonitor);

        frame.add(button1,BorderLayout.WEST);
        frame.add(button2,BorderLayout.EAST);
        frame.pack();
        frame.setVisible(true);
    }
}

class MyMonitor implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("msg=> "+e.getActionCommand());
        if (e.getActionCommand().equals("start")){
            System.out.println("fuck");
        }
    }
}
