package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            new MainWindow(9,new ClientMain());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
