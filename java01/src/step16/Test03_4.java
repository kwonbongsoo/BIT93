/* File 다루기 - 바이트 스트림 클래스 - ByteArrayOutputStream
 * => 바이트 배열 메모리를 출력하는 클래스이다.
 */

package step16;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Test03_4 {

  public static void main(String[] args) throws IOException{
    ByteArrayOutputStream out0 = new ByteArrayOutputStream();
    DataOutputStream out = new DataOutputStream(out0);
    byte b = 0x11;
    out.writeByte(b);
    
    short s = 0x2233;
    out.writeShort(s);
    
    int i = 0x44556677;
    out.writeInt(i);
    
    String str = "ABC가각간";
    out.writeUTF(str);
    
    byte[] buf = out0.toByteArray();
    
    
    /* 스트리밍 방식이 아니라 일반 방식으로 데이터를 읽는다.
    for (byte b : buf) {
      System.out.printf("%x", b);
    }
    */
    // 스트리밍 API를 사용해서 바이트 배열에서 값을 읽어보자!
    
    ByteArrayInputStream in0 = new ByteArrayInputStream(buf);
    DataInputStream in = new DataInputStream(in0);
    byte b2;
    b2 = in.readByte();
    
    short s2 = in.readShort();
        
    int i2 = in.readInt();
    
   
    String str2 = in.readUTF();
    System.out.printf("%x, %x, %x, %s\n", b2, s2, i2, str2);
    out.close();
  }
}

