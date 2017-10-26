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
		
		fileM = new JMenu("파일");
		editM = new JMenu("편집");
		viewM = new JMenu("보기");
		
		newM = new JMenuItem("새로만들기");
		openM = new JMenuItem("열기");
		saveM = new JMenuItem("저장");
		exitM = new JMenuItem("끝내기");
		copyM = new JMenuItem("복사");
		pasteM = new JMenuItem("붙여넣기");
		cutM = new JMenuItem("잘라내기");
		
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
		setTitle("간단 메모장");
		setBounds(500,70,700,500);
		setVisible(true);
		setResizable(false);
		
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				
				int result = JOptionPane.showConfirmDialog(NotePad.this, 
						"정말로 종료하시겠습니까?", 
						"종료",JOptionPane.OK_CANCEL_OPTION,
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
				"정말로 종료하시겠습니까?", 
				"종료",JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.WARNING_MESSAGE);
		if(result == JOptionPane.OK_OPTION)
			System.exit(0);
	}

	public static void main(String[] args) {
		new NotePad();
	}

}
