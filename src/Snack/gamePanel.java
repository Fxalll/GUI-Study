package Snack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class gamePanel extends JPanel implements KeyListener, ActionListener {
    int length;
    int[] snakeX = new int[600];
    int[] snakeY = new int[500];

    public gamePanel(){
        init();
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }
    String fx;
    int foodx;
    int foody;
    int score;
    int time;
    String speed;
    Random random = new Random();
    boolean isStart = false;
    boolean isFail = false;
    Timer timer = new Timer(100,this);



    public void init(){
        timer.setDelay(100);
        length = 3;
        score = 0;
        speed = "慢速";
        snakeX[0] = 100; snakeY[0] = 100;
        snakeX[1] = 75; snakeY[1] = 100;
        snakeX[2] = 50; snakeY[2] = 100;
        fx = "R";
        for (int k = length; k>=0;k--){
            do {
                foodx = 25 + 25 * random.nextInt(34);
                foody = 75 + 25 * random.nextInt(24);
            }while (foodx == snakeX[k] && foody == snakeY[k]);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.white);
        Data.header.paintIcon(this,g,25,11);
        g.fillRect(25,75,850,600);
        Data.food.paintIcon(this,g,foodx,foody);

        g.setColor(Color.white);
        g.setFont(new Font("黑体",Font.BOLD,18));
        g.drawString("长度 " + length,700,32);
        g.drawString("分数 " + score,700,52);
        g.drawString("速度： " + speed,50,42);



        if (fx.equals("R")){
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if (fx.equals("L")){
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if (fx.equals("U")){
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if (fx.equals("D")){
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);
        }


        for (int i=1;i<length;i++){
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }
        if (isStart == false){
            g.setColor(Color.white);
            g.setFont(new Font("黑体",Font.BOLD,40));
            g.drawString("按下空格开始游戏",300,300);
        }
        if (isFail){
            g.setColor(Color.red);
            g.setFont(new Font("黑体",Font.BOLD,40));
            g.drawString("游戏失败，按下空格重新开始",200,300);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE){
            if (isFail){
                isFail = false;
                init();
            }else{
                isStart = !isStart;
            }
            repaint();
        }
        if (fx != "D" && keyCode == KeyEvent.VK_UP){
            fx = "U";
        }else if (fx != "U" && keyCode == KeyEvent.VK_DOWN){
            fx = "D";
        }else if (fx != "R" && keyCode == KeyEvent.VK_LEFT){
            fx = "L";
        }else if (fx != "L" && keyCode == KeyEvent.VK_RIGHT){
            fx = "R";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isStart && isFail == false){
            if (snakeX[0] == foodx && snakeY[0] == foody){
                score = score + length*15;
                if (timer.getDelay() >=50 ){
                    timer.setDelay(timer.getDelay() - length/5);
                }
                time = 101 - timer.getDelay();
                if (time > 10 && time < 20){
                    speed = "中速";
                }else if (time > 20 && time < 40){
                    speed = "快速";
                }else if (time > 40 && time < 50){
                    speed = "超快！";
                }else if (time == 50){
                    speed = "满速！！";
                }

                length++;
                for (int k = length; k>=0;k--){
                    do {
                        foodx = 25 + 25 * random.nextInt(34);
                        foody = 75 + 25 * random.nextInt(24);
                    }while (foodx == snakeX[k] && foody == snakeY[k]);
                }
            }
            for (int i = length-1; i > 0; i--){
                snakeX[i] = snakeX[i-1];
                snakeY[i] = snakeY[i-1];
            }

            if (fx.equals("R")){
                snakeX[0] = snakeX[0] + 25;
                if (snakeX[0] > 850){
                    snakeX[0] = 25;
                }
            }else if (fx.equals("L")){
                snakeX[0] = snakeX[0] - 25;
                if (snakeX[0] < 25){
                    snakeX[0] = 850;
                }
            }else if (fx.equals("U")){
                snakeY[0] = snakeY[0] - 25;
                if (snakeY[0] < 75){
                    snakeY[0] = 650;
                }
            }else if (fx.equals("D")){
                snakeY[0] = snakeY[0] + 25;
                if (snakeY[0] > 650){
                    snakeY[0] = 75;
                }
            }
            for (int i = length;i > 0;i--){
                if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]){
                    isFail = true;
                }
            }
            repaint();
        }
        timer.start();
    }
}
