package chat;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;


public class ChatServer {
	private ServerSocket net;
	private ArrayList<ChatHandler> list;
	
	public ChatServer(){
		try {
			net = new ServerSocket(9200);//��Ʈ��ȣ �Է�..
			System.out.println("서버가 실행중입니다");
		} catch (IOException e) {
			System.out.println("������ ������ ���� �ʾҽ��ϴ�.");
		}
		list = new ArrayList<ChatHandler>();
		while(true){
			try {
				Socket socket = net.accept();
				ChatHandler han = new ChatHandler(socket,list);
				han.start();
				
				list.add(han);
				
			} catch (IOException e) {
				System.out.println("�������� ������ ���� �����ϴ�.");
			}
		}
	}
	public static void main(String[] args) {
		new ChatServer();
	}
}
