import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;


public class ChatClient extends JFrame implements ActionListener,Runnable{
	private JTextArea area; //결과 찍히는것
	private JTextField field; //글자 입력...
	private JButton sendB; //전송 버튼..
	private BufferedReader br; //서버로 부터 읽어오기
	private PrintWriter pw;
	private Socket socket;
	private Thread t;
	
	public ChatClient() throws IOException{
		makeJframe();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				pw.println("quit");
				pw.flush();
				try {
					br.close();
					pw.close();
					socket.close();
					System.exit(0);
				} catch (IOException e1) {
					System.out.println("서버와의 연결이 끊어졌습니다.");
					System.exit(0);
				}
			}
		});
		field.addActionListener(this);
		sendB.addActionListener(this);
	}
	public void execute(){
		String serverIP = JOptionPane.showInputDialog(this,"서버 IP를 입력하세요","192.168.33.161");
		
		if(serverIP == null || serverIP.length()== 0){
			System.out.println("서버 IP를 입력하세요");
			System.exit(0);
		}
		String nickName = JOptionPane.showInputDialog(this,"닉네임을 입력하세요","닉네임",JOptionPane.QUESTION_MESSAGE);
		
		if(nickName == null || nickName.length()==0)
			nickName = "Guest";
		try {
			socket = new Socket(serverIP,9200);
		} catch (UnknownHostException e) {
			System.out.println("서버를 찾을수 없습니다.");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("서버에 접속할 수 없습니다.");
			System.exit(0);
		}
		try {
			//서버로부터 입력
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//서버로 전송
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			System.out.println("서버와의 연결이 끊어졌습니다.");
			System.exit(0);
		}
		//pw.write(nickName+"\n");
		pw.println(nickName);
		pw.flush();
		
		t = new Thread(this);
		t.start();
	}
	public void run(){
		String line = null;
		while(true){
			try {
				line = br.readLine();
				
				if(line == null||line.toLowerCase().equals("quit")){//소문자로 전송.
					br.close();
					pw.close();
					socket.close();
					System.exit(0);
				}
				area.append(line+"\n");//append는 엔터값전까지만 읽기때문
				int pos = area.getText().length();
				area.setCaretPosition(pos);
				//settext는 덮어쓰기때문에 다 지워짐..
			} catch (IOException e) {
				System.out.println("서버와의 연결이 끊어졌습니다");
				System.exit(0);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String line = field.getText();
		field.setText("");
		
		pw.println(line); //서버로보냄
		pw.flush(); //버퍼를 비움..
	}
	private void makeJframe(){
		area = new JTextArea();
		area.setEditable(false); //area 입력 못하게 막음...(채팅창입력안되게)
		JScrollPane scroll = new JScrollPane(area);//스크롤바에 area를 붙임....
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//항상 스크롤바 보이게 해주세요(세로만);
		field = new JTextField();
		sendB = new JButton("보내기");
		JPanel panel = new JPanel(new BorderLayout());
		
		panel.add("Center",field);
		panel.add("East",sendB);
		this.getContentPane().add("Center", scroll);
		this.add("South",panel);
		
		setTitle("채팅프로그램");
		setSize(300,300);
		setVisible(true);
		
	}
	public static void main(String[] args) throws IOException{
		ChatClient client = new ChatClient();
		client.execute();
	}
}
