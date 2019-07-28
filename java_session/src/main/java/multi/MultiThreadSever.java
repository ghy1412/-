package multi;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadSever {
    private static  Map<String, Socket> map = new ConcurrentHashMap<>();
    public static class ExecuteClient implements Runnable{
        private Socket client ;
        public ExecuteClient(Socket client) {
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
              String msgClient = null;
              if (in.hasNextLine()){
                  msgClient = in.nextLine();
                  if (msgClient.startsWith("R")){
                      //注册流程
                      String str = msgClient.split(":")[1];
                      try {
                          registerClient(str,client);
                      } catch (IOException e) {
                          e.printStackTrace();
                      }
                      continue;
                  }
                  if (msgClient.startsWith("G")){
                      //群聊流程
                      String s = msgClient.split("-")[1];
                      groupChat(s,client);
                      continue;
                  }
                  if (msgClient.startsWith("P")) {
                      //私聊流程 P:灰太狼-沙比
                      String tagName = msgClient.split(":")[1].split("-")[0];
                      String str = msgClient.split("-")[1];
                      privateChat(tagName,str);
                      continue;
                  }
                  if (msgClient.contains("byebye")){
                      //退出流程
                      String userName = null;
                      for (String keyName : map.keySet()) {
                          if (map.get(keyName).equals(client)){
                              userName = keyName;
                              break;
                          }
                      }
                      System.out.println("用户"+userName+"下线了");
                      Set<Map.Entry<String,Socket>> entries = map.entrySet();
                      for (Map.Entry<String,Socket> entry:entries) {
                          Socket value = entry.getValue();
                          PrintStream out = null ;
                          try {
                              out = new PrintStream(value.getOutputStream(),true,"UTF-8");
                              out.println("用户"+userName+"下线了");
                          } catch (IOException e) {
                              e.printStackTrace();
                          }

                      }
                      map.remove(userName);
                      continue;
                  }
              }
          }
        }

        private static void privateChat(String name,String msg){
            Socket client = map.get(name);
            String username = null;
            for (String keyname : map.keySet()){
                if (map.get(keyname).equals(client)){
                    username = keyname;
                }
            }
            PrintStream out = null;
            try {
                out = new PrintStream(client.getOutputStream(), true, "UTF-8");
                out.println("用户"+username+"发来消息: "+msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private static void groupChat(String str,Socket client){
            Set<Map.Entry<String, Socket>> entries = map.entrySet();
            String username = null;
            for (String keyname : map.keySet()){
                if (map.get(keyname).equals(client)){
                    username = keyname;
                }
            }
            for (Map.Entry<String,Socket> entry:entries) {
                Socket value = entry.getValue();
                PrintStream out = null ;
                try {
                    out = new PrintStream(value.getOutputStream(),true,"UTF-8");
                    out.println("群聊消息>"+username+"发来消息: "+str);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
        private static void registerClient(String name,Socket socket ) throws IOException {
            System.out.println("用户名为: "+name);
            System.out.println("用户"+name+"上线了");
            map.put(name,socket);
            PrintStream out = new PrintStream(socket.getOutputStream());
            out.println("你当前是第"+map.size()+"位用户");
            out.println("注册成功");

        }
    }
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket= new ServerSocket(12001);
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            System.out.println("等待客户端连接.....");
            Socket client = serverSocket.accept();
            System.out.println("连接客户端成功!!!,端口号为: "+client.getPort());
            executorService.submit(new ExecuteClient(client));
        }
    }
}
