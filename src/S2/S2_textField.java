package S2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class S2_textField {
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
    }
}
class MyFrame extends Frame {
    public MyFrame(){
        TextField textField = new TextField();
        add(textField);

        MyActionListener2 myActionListener2 = new MyActionListener2();
        textField.addActionListener(myActionListener2);
        textField.setEchoChar('*');

        setVisible(true);
        setSize(400,100);
    }
}
class MyActionListener2 implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        TextField field = (TextField) e.getSource();
        System.out.println(field.getText());
        field.setText("");
    }
}
