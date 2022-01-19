package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientMain implements Runnable{
    public GamePanel panel;
    Socket socket = new Socket();
    DataOutputStream outputStream;
    DataInputStream inputStream;
    Thread t;

    public ClientMain() throws IOException {
        Scanner s = new Scanner(System.in,"utf-8");
        SocketAddress serverAddress = new InetSocketAddress(s.nextLine(), 6000);
        socket.connect(serverAddress);

        outputStream = new DataOutputStream(socket.getOutputStream());
        inputStream = new DataInputStream(socket.getInputStream());

        t = new Thread(this);
        t.start();
    }

    public void sendMessage(String str){
        try {
            outputStream.writeUTF(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                JSONParser parser = new JSONParser();
                JSONObject stonesJSON = (JSONObject) parser.parse(inputStream.readUTF());
                JSONArray array = (JSONArray) stonesJSON.get("stones");
                ArrayList<Stone> stones = new ArrayList<>();
                for (int i = 0; i < array.size();i++){
                    JSONObject stone = (JSONObject) parser.parse(array.get(i).toString());
                    int x = Integer.parseInt(stone.get("x").toString());
                    int y = Integer.parseInt(stone.get("y").toString());
                    StoneColor team = null;
                    String teamStr = stone.get("team").toString();
                    if(teamStr.equals("black")) {
                        team = StoneColor.BLACK;
                    }
                    else if (teamStr.equals("white")) {
                        team = StoneColor.WHITE;
                    }
                    else if (teamStr.equals("void")) {
                        team = StoneColor.VOID;
                    }
                    stones.add(new Stone(x,y,team));
                }
                panel.bPanel.setLabel1Text("Белых захвачено: " + stonesJSON.get("deadWhite"));
                panel.bPanel.setLabel2Text("Черных захвачено: " + stonesJSON.get("deadBlack"));
                panel.setArray(stones);
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendStone(int x, int y) {
        JSONObject json = new JSONObject();
        json.put("cmd","setStone");
        JSONObject stone = new JSONObject();
        stone.put("x",x);
        stone.put("y",y);
        json.put("body",stone);
        sendMessage(json.toJSONString());
    }
}
