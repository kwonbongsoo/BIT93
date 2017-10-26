package BitNet.Commons;

public class ReqPacket {
	
	//클라이언트가 서버에게 닉네임을 받을 수 있도록 요청
	public static final int REQ_NICKNAME = 100;
	
	//클라이언트가 서버에게 메세지를 전송 하겠다고 요청
	public static final int REQ_MESSAGE = 101;
	
	//귓속말 요청 패킷
	public static final int REQ_W = 102;
	
	//업로드 요청 패킷
	public static final int REQ_FILE_UPLOAD = 103;
}