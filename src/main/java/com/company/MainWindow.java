package com.company;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private int sizeBtwLine = 50;

    public MainWindow(int lines, ClientMain client){
        setFocusable(true);
        setTitle("GoGame");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(sizeBtwLine * lines + 250,sizeBtwLine * lines + sizeBtwLine/2+13);
        setLocation(500,100);
        ButtonsPanel buttons = new ButtonsPanel();
        add(new GamePanel(lines,sizeBtwLine,client,buttons),BorderLayout.CENTER);
        add(buttons,BorderLayout.EAST);
        setResizable(false);
        setVisible(true);
    }
}
