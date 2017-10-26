import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class ByteStream {
	public static void main(String[] args) throws IOException{
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("data.txt"));
		int data;
		while(true){
			data = bis.read();
			if(data == -1) break;
			System.out.print((char)data);
		}
		bis.close();
	}
}
