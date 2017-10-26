package chat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;


public class ChatHandler extends Thread{
	private Socket socket;
	private ArrayList<ChatHandler> list;
	private BufferedReader br;//Ŭ���̾�Ʈ���� ���޹ޱ�
	private PrintWriter pw;//Ŭ���̾�Ʈ�� ����
	
	public ChatHandler(Socket socket,ArrayList<ChatHandler> list)throws IOException{
		this.socket = socket;
		this.list = list;
		
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));//Ŭ���̾�Ʈ�κ��� �о����
		pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));//"" �� ����
		
	}
	public void run(){
		String nickName = null;
		try {
			nickName = br.readLine();
			
			broadcast(nickName+"님께서 입장하셨습니다.");
			
		} catch (IOException e) {
			System.out.println("�г����� ã�� ���߽��ϴ�.");
		}//����Ϸ�..
		String line = null;
		while(true){
			try {
				line = br.readLine();
				
				if(line == null || line.toLowerCase().equals("quit")) break;
				
				//��� Ŭ���̾�Ʈ���� �޼��� ������
				//[�г���]: �ȳ�~
				broadcast("["+nickName+"]:"+line);
			} catch (IOException e) {
				System.out.println("�޼����� ���� ���߽��ϴ�.");
			}
		}
		list.remove(this);
		broadcast(nickName+"님께서 나가셨습니다.");
		try {
			br.close();
			pw.close();
			socket.close();
		} catch (IOException e) {
			System.out.println("���� ���� �ʾҽ��ϴ�.");
		}
	}
	public void broadcast(String msg){
		for(int i=0;i<list.size();i++){
			ChatHandler han = list.get(i);
			han.pw.println(msg);
			han.pw.flush();
		}
	}
}
