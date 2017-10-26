package BitNet.Commons;

public class AckPacket {

	//닉네임이 올바로 들어왔다는 응답 패킷
	public static final int ACK_NICKNAME_Y = 200;
	
	//메세지에 대한 응답 패킷
	public static final int ACK_MESSAGE = 201;
	
	//귓속말에 대한 응답 패킷
	public static final int ACK_W = 202;
	
	//파일 업로드 준비 응답 패킷
	public static final int ACK_FILE_UPLOAD = 203;
	
	
	
	
	//================에러 패킷=================//
	//잘못된 닉네임이 들어왔다는 응답 패킷
	public static final int ACK_NICKNAME_N = 300;
	
	
	
}