package chat;

import java.net.InetAddress;
import java.net.UnknownHostException;



public class InetAddressTest {
	public static void main(String[] args) throws UnknownHostException{
		//InetAddress inet = new InetAddressTest();
		//�����ڰ� public �̾ƴ�..
		InetAddress naver = InetAddress.getByName("www.naver.com");//������ IP�ˤ����¹�
		System.out.println("Naver IP:"+naver.getHostAddress());
		
		InetAddress local = InetAddress.getLocalHost(); //�ڱ� ������ �˾Ƴ��¹�
		System.out.println("Local IP:"+local.getHostAddress());
		
		//������ ��� ip��������
		InetAddress[] ar = InetAddress.getAllByName("www.google.com");
		for(InetAddress google:ar)
			System.out.println("Google IP:"+google.getHostAddress());
	}
}
