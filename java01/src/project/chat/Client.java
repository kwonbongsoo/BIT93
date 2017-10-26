package project.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;




public class Client implements Runnable{
  
  Socket socket;
  public static ArrayList<Client>list;
  public Client(Socket socket) {
    this.socket = socket;
    System.out.println("연결됨");
  }
  public void setList(ArrayList<Client>list) {
    Client.list = list;
  }
  
  @Override
  public void run() {
    try (
        Socket socket = this.socket;
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());
        ) {
      while (true) {
        String json = in.readLine();
        if (json == null)
          return;
        System.out.println(json);
        
        
       
       out.print(list);
       out.flush();
      }
//      System.out.println("=> 클라이언트와 연결 끊김");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
