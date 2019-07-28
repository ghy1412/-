package com.bit;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SingThreadClient {
    public static void main(String[] args) throws Exception{
        //127.0.0.1
        //1.先与服务器建立连接
        Socket client = new Socket("127.0.0.1", 12000);
        System.out.println("与服务器建立连接成功");
        PrintStream out = new PrintStream(client.getOutputStream());
        out.println("Hi ,I am client");
        Scanner in = new Scanner(client.getInputStream());
        if (in.hasNextLine()){
            String str = in.nextLine();
            System.out.println("服务器发来的消息为"+str);
        }
        out.close();
        in.close();
        client.close();
    }
}
