package S2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class S3_simpleCal {
    public static void main(String[] args) {
        new Caculator();
    }
}
class Caculator extends Frame{
    TextField num1,num2,num3;
    public Caculator(){
        num1 = new TextField(10);
        num2 = new TextField(10);
        num3 = new TextField(20);
        Button button = new Button("=");
        Label label = new Label("+");

        button.addActionListener(new MyCaculator());

        setLayout(new FlowLayout());
        add(num1);
        add(label);
        add(num2);
        add(button);
        add(num3);

        pack();
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }
    class MyCaculator implements ActionListener {

        //    Caculator caculator = null;
//    public MyCaculator(Caculator caculator){
//        this.caculator = caculator;
//    }
        @Override
        public void actionPerformed(ActionEvent e) {
            int n1 = Integer.parseInt(num1.getText());
            int n2 = Integer.parseInt(num2.getText());

            num3.setText(""+(n1+n2));
            num1.setText("");
            num2.setText("");
        }
    }
}
