package com.company;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MousePosition implements MouseListener {

    ClientMain client;

    public MousePosition(ClientMain client){
        this.client = client;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        client.sendStone(x,y);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
