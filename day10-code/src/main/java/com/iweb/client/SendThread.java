package com.iweb.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread{
    Socket socket;

    public SendThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run(){
        try{
            Scanner sc=new Scanner(System.in);
            while(true){
                String str=sc.nextLine();
                if(socket.isConnected()){
                    OutputStream outputStream =socket.getOutputStream();
                    DataOutputStream dataOutputStream=new DataOutputStream(outputStream);
                    dataOutputStream.writeUTF(str);
                }
            }
        }catch (IOException e){
        }finally {
            try {
                socket.close();
                System.out.println("聊天结束");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
