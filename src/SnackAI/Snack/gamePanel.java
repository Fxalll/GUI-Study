package SnackAI.Snack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeoutException;

public class gamePanel extends JPanel implements ActionListener{
    int length;
    int[] snakeX = new int[600*500];
    int[] snakeY = new int[500*600];

    public gamePanel(){
        init();
        this.setFocusable(true);
//        this.addKeyListener(this);
        timer.start();
    }
    int fx;
    int foodx;
    int foody;
    int score;
    int time;
    String speed;
    Random random = new Random();
    boolean isFail = false;
    boolean isClose = false;
    Timer timer = new Timer(100,this);



    public void init(){
        timer.setDelay(20);
        length = 3;
        score = 0;
        speed = "慢速";
        snakeX[0] = 100; snakeY[0] = 100;
        snakeX[1] = 75; snakeY[1] = 100;
        snakeX[2] = 50; snakeY[2] = 100;
        fx = 2;
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

        if (fx == 2) {
            SnackDoubleAI.Snack.Snack.Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (fx == 0) {
            SnackDoubleAI.Snack.Snack.Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (fx == 1) {
            SnackDoubleAI.Snack.Snack.Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (fx == 3) {
            SnackDoubleAI.Snack.Snack.Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
        }

        for (int i=1;i<length;i++){
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }
        if (isFail){
            g.setColor(Color.red);
            g.setFont(new Font("黑体",Font.BOLD,40));
//            g.drawString("游戏失败",400,300);
            isFail = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (isFail == false){
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


            if (fx == 2) {
                snakeX[0] = snakeX[0] + 25;
                if (snakeX[0] > 850) {
                    snakeX[0] = 25;
                }
            } else if (fx == 0) {
                snakeX[0] = snakeX[0] - 25;
                if (snakeX[0] < 25) {
                    snakeX[0] = 850;
                }
            } else if (fx == 1) {
                snakeY[0] = snakeY[0] - 25;
                if (snakeY[0] < 75) {
                    snakeY[0] = 650;
                }
            } else if (fx == 3) {
                snakeY[0] = snakeY[0] + 25;
                if (snakeY[0] > 650) {
                    snakeY[0] = 75;
                }
            }

            for (int i = length; i > 0; i--) {
                if (snakeX[0]-snakeX[i]==25 && snakeY[0]-snakeY[i]== 0 && fx == 0){
                    isClose = true;
                    for (int k = length; k > 0; k--) {
                        if (snakeX[0] - snakeX[k] == 0 && snakeY[0] - snakeY[k] == 25 && fx == 0) {
                            fx = (fx - 1) % 4;
                        } else if (snakeX[0] - snakeX[k] != 0 && snakeY[0] - snakeY[k] != 25 && fx == 0){
                            fx = (fx + 1) % 4;
                        }
                    }
                }
                if (snakeX[0]-snakeX[i]==-25 && snakeY[0]-snakeY[i]== 0 && fx == 2){
                    isClose = true;
                    for (int k = length; k > 0; k--) {
                        if (snakeX[0] - snakeX[k] == 0 && snakeY[0] - snakeY[k] == -25 && fx == 2) {
                            fx = (fx - 1) % 4;
                        } else if (snakeX[0] - snakeX[k] != 0 && snakeY[0] - snakeY[k] != -25 && fx == 2){
                            fx = (fx + 1) % 4;
                        }
                    }
                }
                if (snakeX[0]-snakeX[i]==0 && snakeY[0]-snakeY[i]== 25 && fx == 1){
                    isClose = true;
                    for (int k = length; k > 0; k--) {
                        if (snakeX[0] - snakeX[k] == -25 && snakeY[0] - snakeY[k] == 0 && fx == 1) {
                            fx = (fx - 1) % 4;
                        } else if (snakeX[0] - snakeX[k] != -25 && snakeY[0] - snakeY[k] != 0 && fx == 1){
                            fx = (fx + 1) % 4;
                        }
                    }
                }
                if (snakeX[0]-snakeX[i]==0 && snakeY[0]-snakeY[i]== -25 && fx == 3){
                    isClose = true;
                    for (int k = length; k > 0; k--) {
                        if (snakeX[0] - snakeX[k] == 25 && snakeY[0] - snakeY[k] == 0 && fx == 3) {
                            fx = (fx - 1) % 4;
                        } else if (snakeX[0] - snakeX[k] != 25 && snakeY[0] - snakeY[k] != 0 && fx == 3){
                            fx = (fx + 1) % 4;
                        }
                    }
                }

                if (    snakeX[0]-snakeX[i] >=50 && snakeY[0]-snakeY[i]== 0 && fx == 0||
                        snakeX[0]-snakeX[i] <=-50 && snakeY[0]-snakeY[i]== 0 && fx == 2||
                        snakeX[0]-snakeX[i]==0 && snakeY[0]-snakeY[i]>=50 && fx == 1||
                        snakeX[0]-snakeX[i]==0 && snakeY[0]-snakeY[i]<=-50 && fx == 3){
                    isClose = false;
                }
            }


            if (!isClose){
                if (snakeX[0] < foodx){
                    if (fx == 0){
                        if (snakeY[0] < foody){
                            fx = 3;
                        }else if(snakeY[0] > foody){
                            fx = 1;
                        }
                    }else {
                        fx = 2;
                    }

                }else if(snakeX[0] > foodx){
                    if (fx == 2){
                        if (snakeY[0] < foody){
                            fx = 3;
                        }else if(snakeY[0] > foody){
                            fx = 1;
                        }
                    }else {
                        fx = 0;
                    }
                }
                if (snakeY[0] < foody){
                    if (fx == 1){
                        if (snakeX[0] < foodx){
                            fx = 2;
                        }else if(snakeX[0] > foodx){
                            fx = 0;
                        }
                    }else {
                        fx = 3;
                    }
                }else if(snakeY[0] > foody){
                    if (fx == 3){
                        if (snakeX[0] < foodx){
                            fx = 2;
                        }else if(snakeX[0] > foodx){
                            fx = 0;
                        }
                    }else {
                        fx = 1;
                    }
                }
            }







            repaint();
        }
        timer.start();
    }
}
