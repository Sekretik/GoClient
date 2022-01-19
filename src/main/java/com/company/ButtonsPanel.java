package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class ButtonsPanel extends JPanel {
    public JLabel text1 = new JLabel("Белых захвачено: ");
    public JLabel text2 = new JLabel("Черных захвачено: ");

    public ButtonsPanel(){
        setLayout(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.add(text2,BorderLayout.NORTH);
        add(text1,BorderLayout.NORTH);
        add(p1,BorderLayout.CENTER);
        add(new JButton("Назад"),BorderLayout.SOUTH);
    }

    public void setLabel1Text(String str){
        text1.setText(str);
    }
    public void setLabel2Text(String str){
        text2.setText(str);
    }
}
