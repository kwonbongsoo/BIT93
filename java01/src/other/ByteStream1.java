import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class ByteStream1 {

	public static void main(String[] args) {
		try{
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream("data.txt"));
			File file = new File("data.txt");
			
			int size = (int)file.length();
			
			byte[] b = new byte[size];
			bis.read(b,0, size);
			
//			for(int i=0;i<b.length;i++)
//				System.out.print((char)b[i]);
			
			System.out.println(new String(b));//�̷��Ե� ����Ҽ� �ִ�.
			
			bis.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
