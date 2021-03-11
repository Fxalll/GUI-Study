package S3;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class S3_keyboard {
    public static void main(String[] args) {
    new keyFrame();
    }
}

class keyFrame extends Frame{
    public keyFrame(){
         setBounds(1,2,300,400);
         setVisible(true);

         this.addKeyListener(new KeyAdapter() {
             @Override
             public void keyPressed(KeyEvent e) {
                  int keyCode = e.getKeyCode();
                  if (keyCode == KeyEvent.VK_UP){
                      System.out.println("up");
                  }
             }
         });
    }

}
