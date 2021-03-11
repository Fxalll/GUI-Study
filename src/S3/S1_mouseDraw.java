package S3;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

public class S1_mouseDraw {
    public static void main(String[] args) {
        new MyFrame("画图");
    }
}

class MyFrame extends Frame{
    ArrayList points;
    public MyFrame(String title){
        super(title);
        setBounds(200,200,400,300);
        points = new ArrayList();
        setVisible(true);
        this.addMouseListener(new MyMouseListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g){
        Iterator iterator = points.iterator();
        while (iterator.hasNext()){
            Point point = (Point) iterator.next();
            g.setColor(Color.red);
            g.fillOval(point.x,point.y,10,10);
        }
    }

    public void addPaint(Point point){
        points.add(point);
    }

    private class MyMouseListener extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e){
            MyFrame frame = (MyFrame) e.getSource();
            frame.addPaint(new Point(e.getX(),e.getY()));
            frame.repaint();
        }
    }
}
