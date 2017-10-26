package fun;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ImageMove extends Frame implements ActionListener{
	private Button first,left,right,high,low;
	private int x=100,y=100;
	public void init(){
		first=new Button("first");
		left=new Button("left");
		right=new Button("right");
		high=new Button("high");
		low=new Button("low");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			};
		});
		Panel p1 = new Panel();
		
		p1.add(first);
		p1.add(left);
		p1.add(right);
		p1.add(high);
		p1.add(low);
		
		first.addActionListener(this);
		low.addActionListener(this);
		high.addActionListener(this);
		left.addActionListener(this);
		right.addActionListener(this);
		
		
		add("North",p1);
		setBounds(0,0,300,400);
		setVisible(true);
		
	}
	public void paint(Graphics g){
		Image img = Toolkit.getDefaultToolkit().getImage(""+"C:/workspace/java01/sj.jpg");
		g.drawImage(img,x,y,100,100,this);
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand()=="first"){
			x=100;
			y=100;
		}else if(e.getActionCommand()=="left"){
			x-=10;
		}else if(e.getActionCommand()=="right"){
			x+=10;
		}else if(e.getActionCommand()=="high"){
			y-=10;
		}else if(e.getActionCommand()=="low"){
			y+=10;
		}
		if(x<0)
			x=300;
		else if(y<0)
			y=400;
		else if(x>300)
			x=0;
		else if(y>400)
			y=0;
		repaint();
	}
	public static void main(String[] args) {
		new ImageMove().init();
	}
}
