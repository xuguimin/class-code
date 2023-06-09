package com.iweb.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try{
            System.out.println("请输入你要访问的聊天室的ip地址");
            Scanner sc=new Scanner(System.in);
            String ip=sc.nextLine();
            Socket socket=new Socket(ip,8888);
            new SendThread(socket).start();
            new ReceiveThread(socket).start();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
//maven jar包管理