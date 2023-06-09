package com.iweb.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ReceiveThread extends Thread {
    Socket socket;

    public ReceiveThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run(){
        try{
            while(true){
               if(socket.isConnected()){
                   InputStream inputStream=socket.getInputStream();
                   DataInputStream dataInputStream=new DataInputStream(inputStream);
                   System.out.println(dataInputStream.readUTF());
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
