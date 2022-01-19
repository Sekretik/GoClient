package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);
            new MainWindow(9,new ClientMain());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
