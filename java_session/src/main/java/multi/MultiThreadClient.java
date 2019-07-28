package multi;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class MultiThreadClient  {
    private static class SendToMessage implements Runnable{
        private  Socket client ;
        public SendToMessage(Socket client){
            this.client = client;
        }
        @Override
        public void run() {
            Scanner in = new Scanner(System.in);
            PrintStream out = null;
            try {
            out = new PrintStream(client.getOutputStream(),true,"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true){
                System.out.println("请输入消息: ");
                String sendMessage = null;
                if (in.hasNextLine()){
                     sendMessage = in.nextLine();
                     if (sendMessage.length()<3){
                         continue;
                     }
                    out.println(sendMessage);
                    if (sendMessage.contains("byebye")){
                        System.out.println("你下线了");
                        break;
                    }
                }
            }
            in.close();
            out.close();
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static class ReadFromMessage implements Runnable{
        private Socket client;
        public ReadFromMessage(Socket client){
            this.client = client;
        }
        @Override
        public void run() {
            Scanner in = null;
            try {
                 in = new Scanner(client.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true){
                if (in.hasNextLine()){
                    String strFromSever = in.nextLine();
                    if (client.isClosed()){
                        break;
                    }
                    System.out.println("服务器发来消息: "+strFromSever);
                }
            }
            in.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Socket client = new Socket("127.0.0.1",12001);
        System.out.println("连接服务器成功");
        Thread thread1 = new Thread(new SendToMessage(client));
        Thread thread2 = new Thread(new ReadFromMessage(client));
        thread1.start();
        thread2.start();

    }
}
