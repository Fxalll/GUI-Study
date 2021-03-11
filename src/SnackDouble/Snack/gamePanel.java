package SnackDouble.Snack;

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
    int length1;
    int[] snakeX1 = new int[600];
    int[] snakeY1 = new int[500];

    public gamePanel() {
        init();
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }

    String fx;
    String fx1;
    int foodx;
    int foody;
    int score;
    int score1;
    int time;
    int sp;
    int sp1;
    boolean addsp;
    boolean addsp1;
    String win;
    String speed;
    Random random = new Random();
    boolean isStart = false;
    boolean isFail = false;
    Timer timer = new Timer(100, this);


    public void init() {
        timer.setDelay(100);
        length = 3;
        length1 = 3;
        sp = 25;
        sp1 = 25;
        win = null;
        addsp = false;
        addsp1 = false;
        addsp1 = false;
        score = 0;
        score1 = 0;
        speed = "慢速";
        snakeX[0] = 100;
        snakeY[0] = 100;
        snakeX[1] = 75;
        snakeY[1] = 100;
        snakeX[2] = 50;
        snakeY[2] = 100;
        snakeX1[0] = 450;
        snakeY1[0] = 500;
        snakeX1[1] = 475;
        snakeY1[1] = 500;
        snakeX1[2] = 500;
        snakeY1[2] = 500;
        fx = "R";
        fx1 = "L";
        foodx = 25 + 25 * random.nextInt(34);
        foody = 75 + 25 * random.nextInt(24);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.white);
        Data.header.paintIcon(this, g, 25, 11);
        g.fillRect(25, 75, 850, 600);
        Data.food.paintIcon(this, g, foodx, foody);

        g.setColor(Color.white);
        g.setFont(new Font("黑体", Font.BOLD, 14));
        g.drawString("p1 长度 " + length, 650, 32);
        g.drawString("p2 长度 " + length1, 650, 52);
        g.drawString("p1 分数 " + score, 750, 32);
        g.drawString("p2 分数 " + score1, 750, 52);
        g.drawString("速度： " + speed + "(" + timer.getDelay() + ")", 50, 42);


        if (fx.equals("R")) {
            Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (fx.equals("L")) {
            Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (fx.equals("U")) {
            Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (fx.equals("D")) {
            Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        if (fx1.equals("R")) {
            Data.right1.paintIcon(this, g, snakeX1[0], snakeY1[0]);
        } else if (fx1.equals("L")) {
            Data.left1.paintIcon(this, g, snakeX1[0], snakeY1[0]);
        } else if (fx1.equals("U")) {
            Data.up1.paintIcon(this, g, snakeX1[0], snakeY1[0]);
        } else if (fx1.equals("D")) {
            Data.down1.paintIcon(this, g, snakeX1[0], snakeY1[0]);
        }


        for (int i = 1; i < length; i++) {
            Data.body.paintIcon(this, g, snakeX[i], snakeY[i]);

        }
        for (int i = 1; i < length1; i++) {
            Data.body1.paintIcon(this, g, snakeX1[i], snakeY1[i]);

        }
        if (isStart == false) {
            g.setColor(Color.white);
            g.setFont(new Font("黑体", Font.BOLD, 40));
            g.drawString("按下空格开始游戏", 300, 300);
        }
        if (isFail) {
            g.setColor(Color.red);
            g.setFont(new Font("黑体", Font.BOLD, 40));
            if (win == "p1"){
                g.drawString("玩家1获胜！按下空格重新开始", 200, 300);
                win = null;
            }else if (win == "p2"){
                g.drawString("玩家2获胜！按下空格重新开始", 200, 300);
                win = null;
            }else {
                g.drawString("游戏失败！按下空格重新开始", 200, 300);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {
            if (isFail) {
                isFail = false;
                init();
            } else {
                isStart = !isStart;
            }
            repaint();
        }
        if (fx != "D" && keyCode == KeyEvent.VK_UP) {
            fx = "U";
        } else if (fx != "U" && keyCode == KeyEvent.VK_DOWN) {
            fx = "D";
        } else if (fx != "R" && keyCode == KeyEvent.VK_LEFT) {
            fx = "L";
        } else if (fx != "L" && keyCode == KeyEvent.VK_RIGHT) {
            fx = "R";
        }
        if (fx1 != "D" && keyCode == KeyEvent.VK_W) {
            fx1 = "U";
        } else if (fx1 != "U" && keyCode == KeyEvent.VK_S) {
            fx1 = "D";
        } else if (fx1 != "R" && keyCode == KeyEvent.VK_A) {
            fx1 = "L";
        } else if (fx1 != "L" && keyCode == KeyEvent.VK_D) {
            fx1 = "R";
        }
        if (keyCode == KeyEvent.VK_F){
            addsp1 = !addsp1;
//        } else {
//            addsp1 = false;
        }
        if (keyCode == KeyEvent.VK_SHIFT){
            addsp = !addsp;
//        } else {
//            addsp = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isStart && isFail == false) {
            if (snakeX[0] == foodx && snakeY[0] == foody) {
                score = score + length * 15;
                if (timer.getDelay() >= 60) {
                    timer.setDelay(timer.getDelay() - length / 5);
                }
                time = 101 - timer.getDelay();
                if (time > 10 && time < 20) {
                    speed = "中速";
                } else if (time > 20 && time < 40) {
                    speed = "快速";
                } else if (time > 40 && time < 50) {
                    speed = "超快！";
                } else if (time == 50) {
                    speed = "满速！！";
                }

                length++;
                for (int i = length; i>=0;i--){
                    for (int k = length1; k>=0;k--){
                        do {
                            foodx = 25 + 25 * random.nextInt(34);
                            foody = 75 + 25 * random.nextInt(24);
                        }while ((foodx == snakeX[i] && foody == snakeY[i]) || (foodx == snakeX1[k] && foody == snakeY1[k]));
                    }

                }
            }
            for (int i = length - 1; i > 0; i--) {
                snakeX[i] = snakeX[i - 1];
                snakeY[i] = snakeY[i - 1];
            }
            if (addsp){
                sp = 50;
            }else {
                sp = 25;
            }

            if (fx.equals("R")) {
                snakeX[0] = snakeX[0] + sp;
                if (snakeX[0] > 850) {
                    snakeX[0] = 25;
                }
            } else if (fx.equals("L")) {
                snakeX[0] = snakeX[0] - sp;
                if (snakeX[0] < 25) {
                    snakeX[0] = 850;
                }
            } else if (fx.equals("U")) {
                snakeY[0] = snakeY[0] - sp;
                if (snakeY[0] < 75) {
                    snakeY[0] = 650;
                }
            } else if (fx.equals("D")) {
                snakeY[0] = snakeY[0] + sp;
                if (snakeY[0] > 650) {
                    snakeY[0] = 75;
                }
            }
            for (int i = length1; i >= 0; i--) {
                if (snakeX[0] == snakeX1[i] && snakeY[0] == snakeY1[i]) {
                    win = "p2";
                    isFail = true;
                }
            }
            for (int k = length; k > 0; k--) {
                if (snakeX[0] == snakeX[k] && snakeY[0] == snakeY[k]) {
                    win = "p2";
                    isFail = true;
                }
            }

//            from this place start double mode


            if (snakeX1[0] == foodx && snakeY1[0] == foody) {
                score1 = score1 + length1 * 15;
                if (timer.getDelay() >= 60) {
                    timer.setDelay(timer.getDelay() - length1 / 5);
                }
                time = 101 - timer.getDelay();
                if (time > 10 && time < 20) {
                    speed = "中速";
                } else if (time > 20 && time < 40) {
                    speed = "快速";
                } else if (time > 40 && time < 50) {
                    speed = "超快！";
                } else if (time == 50) {
                    speed = "满速！！";
                }

                length1++;
                for (int i = length; i>=0;i--){
                    for (int k = length1; k>=0;k--){
                        do {
                            foodx = 25 + 25 * random.nextInt(34);
                            foody = 75 + 25 * random.nextInt(24);
                        }while ((foodx == snakeX[i] && foody == snakeY[i]) || (foodx == snakeX1[k] && foody == snakeY1[k]));
                    }

                }


            }
            for (int i = length1 - 1; i > 0; i--) {
                snakeX1[i] = snakeX1[i - 1];
                snakeY1[i] = snakeY1[i - 1];
            }
            if (addsp1){
                sp1 = 50;
            }else {
                sp1 = 25;
            }
            if (fx1.equals("R")) {
                snakeX1[0] = snakeX1[0] + sp1;
                if (snakeX1[0] > 850) {
                    snakeX1[0] = 25;
                }
            } else if (fx1.equals("L")) {
                snakeX1[0] = snakeX1[0] - sp1;
                if (snakeX1[0] < 25) {
                    snakeX1[0] = 850;
                }
            } else if (fx1.equals("U")) {
                snakeY1[0] = snakeY1[0] - sp1;
                if (snakeY1[0] < 75) {
                    snakeY1[0] = 650;
                }
            } else if (fx1.equals("D")) {
                snakeY1[0] = snakeY1[0] + sp1;
                if (snakeY1[0] > 650) {
                    snakeY1[0] = 75;
                }
            }
            for (int i = length1; i > 0; i--) {
                if (snakeX1[0] == snakeX1[i] && snakeY1[0] == snakeY1[i]) {
                    win = "p1";
                    isFail = true;
                }
            }
            for (int k = length; k >= 0; k--) {
                if (snakeX1[0] == snakeX[k] && snakeY1[0] == snakeY[k]) {
                    win = "p1";
                    isFail = true;
                }
            }


                repaint();
            }


            timer.start();

    }
}
