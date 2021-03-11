package S3;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class S2_window {
    public static void main(String[] args) {
        new WindowFrame();
    }

}
class WindowFrame extends Frame{
    public WindowFrame() {
        setBounds(100,100,200,200);
        setBackground(Color.blue);
        setVisible(true);
//        addWindowListener(new MyWindowListener());
        this.addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        setVisible(false);
                    }
                }
        );
    }
}
