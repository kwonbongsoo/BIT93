package chat;
import java.net.MalformedURLException;
import java.net.URL;


public class URLTest {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.daum.net/index.html");
			System.out.println("��������:"+url.getProtocol());
			System.out.println("ȣ��Ʈ:"+url.getHost());
			System.out.println("��Ʈ:"+url.getPort());
			System.out.println("�⺻ ��Ʈ:"+url.getDefaultPort());
			System.out.println("���:"+url.getPath());
			System.out.println("����:"+url.getFile());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
