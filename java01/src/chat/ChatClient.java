import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;


public class ChatClient extends JFrame implements ActionListener,Runnable{
	private JTextArea area; //��� �����°�
	private JTextField field; //���� �Է�...
	private JButton sendB; //���� ��ư..
	private BufferedReader br; //������ ���� �о����
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
					System.out.println("�������� ������ ���������ϴ�.");
					System.exit(0);
				}
			}
		});
		field.addActionListener(this);
		sendB.addActionListener(this);
	}
	public void execute(){
		String serverIP = JOptionPane.showInputDialog(this,"���� IP�� �Է��ϼ���","192.168.33.161");
		
		if(serverIP == null || serverIP.length()== 0){
			System.out.println("���� IP�� �Է��ϼ���");
			System.exit(0);
		}
		String nickName = JOptionPane.showInputDialog(this,"�г����� �Է��ϼ���","�г���",JOptionPane.QUESTION_MESSAGE);
		
		if(nickName == null || nickName.length()==0)
			nickName = "Guest";
		try {
			socket = new Socket(serverIP,9200);
		} catch (UnknownHostException e) {
			System.out.println("������ ã���� �����ϴ�.");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("������ ������ �� �����ϴ�.");
			System.exit(0);
		}
		try {
			//�����κ��� �Է�
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//������ ����
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			System.out.println("�������� ������ ���������ϴ�.");
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
				
				if(line == null||line.toLowerCase().equals("quit")){//�ҹ��ڷ� ����.
					br.close();
					pw.close();
					socket.close();
					System.exit(0);
				}
				area.append(line+"\n");//append�� ���Ͱ��������� �б⶧��
				int pos = area.getText().length();
				area.setCaretPosition(pos);
				//settext�� ����⶧���� �� ������..
			} catch (IOException e) {
				System.out.println("�������� ������ ���������ϴ�");
				System.exit(0);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String line = field.getText();
		field.setText("");
		
		pw.println(line); //�����κ���
		pw.flush(); //���۸� ���..
	}
	private void makeJframe(){
		area = new JTextArea();
		area.setEditable(false); //area �Է� ���ϰ� ����...(ä��â�Է¾ȵǰ�)
		JScrollPane scroll = new JScrollPane(area);//��ũ�ѹٿ� area�� ����....
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//�׻� ��ũ�ѹ� ���̰� ���ּ���(���θ�);
		field = new JTextField();
		sendB = new JButton("������");
		JPanel panel = new JPanel(new BorderLayout());
		
		panel.add("Center",field);
		panel.add("East",sendB);
		this.getContentPane().add("Center", scroll);
		this.add("South",panel);
		
		setTitle("ä�����α׷�");
		setSize(300,300);
		setVisible(true);
		
	}
	public static void main(String[] args) throws IOException{
		ChatClient client = new ChatClient();
		client.execute();
	}
}
