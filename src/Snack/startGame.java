package Snack;


import javax.swing.*;

public class startGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("game");
        frame.setBounds(10,10,900,720);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new gamePanel());
        frame.setVisible(true);
    }
}
