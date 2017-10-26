import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class NotePad extends JFrame implements ActionListener{
	private JMenuBar menu;
	private JMenu fileM, editM, viewM;
	private JMenuItem newM, openM, saveM, exitM;
	private JMenuItem copyM, pasteM, cutM;
	private JTextArea area;
	
	public NotePad() {
		menu = new JMenuBar();
		
		fileM = new JMenu("����");
		editM = new JMenu("����");
		viewM = new JMenu("����");
		
		newM = new JMenuItem("���θ����");
		openM = new JMenuItem("����");
		saveM = new JMenuItem("����");
		exitM = new JMenuItem("������");
		copyM = new JMenuItem("����");
		pasteM = new JMenuItem("�ٿ��ֱ�");
		cutM = new JMenuItem("�߶󳻱�");
		
		area = new JTextArea();
		JScrollPane scroll = new JScrollPane(area);
		
		fileM.add(newM);
		fileM.add(openM);
		fileM.add(saveM);
		fileM.add(exitM);
		
		editM.add(copyM);
		editM.add(pasteM);
		editM.add(cutM);
		
		menu.add(fileM);
		menu.add(editM);
		menu.add(viewM);
		
		this.add(scroll);
		this.setJMenuBar(menu);
		setTitle("���� �޸���");
		setBounds(500,70,700,500);
		setVisible(true);
		setResizable(false);
		
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				
				int result = JOptionPane.showConfirmDialog(NotePad.this, 
						"������ �����Ͻðڽ��ϱ�?", 
						"����",JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				
				if(result == JOptionPane.OK_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.CANCEL_OPTION) {
					NotePad.this.setDefaultCloseOperation(
							DO_NOTHING_ON_CLOSE);
				}
				
				
			}
		});
		exitM.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		int result = JOptionPane.showConfirmDialog(this, 
				"������ �����Ͻðڽ��ϱ�?", 
				"����",JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.WARNING_MESSAGE);
		if(result == JOptionPane.OK_OPTION)
			System.exit(0);
	}

	public static void main(String[] args) {
		new NotePad();
	}

}
