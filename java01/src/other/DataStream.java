import java.io.*;

import org.omg.CORBA.portable.OutputStream;

public class DataStream {
	public static void main(String[] args) {
		try{
			DataOutputStream dos = new DataOutputStream(
				new FileOutputStream("result.txt"));
			dos.writeUTF("���缮");
			dos.writeInt(42);
			dos.writeDouble(178.7);
			
			dos.close();
			
			DataInputStream dis = new DataInputStream(
					new FileInputStream("result.txt"));
			String name = dis.readUTF();
			int age = dis.readInt();
			double height = dis.readDouble();
			
			System.out.println("�̸�:"+name);
			System.out.println("����:"+age);
			System.out.println("Ű"+height);
			
			dis.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
