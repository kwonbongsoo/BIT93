package project.chat;

import java.net.ServerSocket;
import java.util.ArrayList;

public class ChatServer{
  ArrayList<Client>list;
  
  public void listen(int port) throws Exception {
    ServerSocket serverSocket = new ServerSocket(port);
    System.out.println("서버 실행 중...");
    this.list = new ArrayList<>();
    Client client = null;
    while (true) {
      new Thread(client = new Client(serverSocket.accept())).start();
      list.add(client);
    }
  }
  public static void main(String[] args) throws Exception {
    ChatServer server = new ChatServer();
    server.listen(8888);
  }
}
