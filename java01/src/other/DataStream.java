import java.io.*;

import org.omg.CORBA.portable.OutputStream;

public class DataStream {
	public static void main(String[] args) {
		try{
			DataOutputStream dos = new DataOutputStream(
				new FileOutputStream("result.txt"));
			dos.writeUTF("유재석");
			dos.writeInt(42);
			dos.writeDouble(178.7);
			
			dos.close();
			
			DataInputStream dis = new DataInputStream(
					new FileInputStream("result.txt"));
			String name = dis.readUTF();
			int age = dis.readInt();
			double height = dis.readDouble();
			
			System.out.println("이름:"+name);
			System.out.println("나이:"+age);
			System.out.println("키"+height);
			
			dis.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
