package S1;

import java.awt.*;

public class S1_1_moreFrame {
    public static void main(String[] args) {
        MyFrame frame01 = new MyFrame(100,100,200,200,Color.blue);
        MyFrame frame02 = new MyFrame(100,100,200,200,Color.black);
    }

}

class MyFrame extends Frame{
    static int id = 0;

    public MyFrame (int x, int y, int w, int h, Color color){
        super("Myframe" + (++id));
        setBackground(color);
        setBounds(x,y,w,h);
        setVisible(true);
    }
}
