/* File 다루기 - 바이트 스트림 클래스 - ByteArrayOutputStream
 * => 바이트 배열 메모리를 출력하는 클래스이다.
 */

package step16;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Test03_2 {

  public static void main(String[] args) throws IOException{
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    
    byte b = 0x11;
    out.write(b);
    
    short s = 0x2233;
    out.write(s >> 8);
    out.write(s);
    
    int i = 0x44556677;
    out.write(i >> 24);
    out.write(i >> 16);
    out.write(i >> 8);
    out.write(i);
    
    String str = "ABC가각간";
    byte[] bytes = str.getBytes("UTF-8");
    
    // 문자열의 바이트를 출력하기 전에 그 바이트의 크기 값을 먼저 출력한다. 
    int len = bytes.length;
    out.write(len >> 8);
    out.write(len);
    
    // 문자열의 바이트를 출력한다.
    out.write(bytes);
    
    byte[] buf = out.toByteArray();
    
    
    /* 스트리밍 방식이 아니라 일반 방식으로 데이터를 읽는다.
    for (byte b : buf) {
      System.out.printf("%x", b);
    }
    */
    // 스트리밍 API를 사용해서 바이트 배열에서 값을 읽어보자!
    
    ByteArrayInputStream in = new ByteArrayInputStream(buf);
    byte b2;
    b2 = (byte)in.read();
    
    short s2;
    //read는 제일뒤 1바이트 부터 출력하기 때문에  비트이동을 먼저 이동한후 저장하는게 올바른 방법이다.
    s2 = (short)(in.read() << 8);
    s2 |= (short)(in.read());
    
    int i2;
    i2 = (in.read() << 24);
    i2 |= (in.read() << 16);
    i2 |= (in.read() << 8);
    i2 |= (in.read());
    
    // 문자열 바이트를 읽기 전에 몇 바이트를 읽어야 하는지 그 크기를 먼저 읽는다.
    int len2;
    
    len2 = (in.read() << 8);
    len2 |= (in.read());
    
    // 문자열 배열의 크기 만큼 바이트 배열을 만든다.
    byte[] buf2 = new byte[len2];
    
    // 문자열 배열을 읽어 바이트 배열에 저장한다.
    in.read(buf2);
    
    // 바이트 배열에 들어 있는 값을 가지고 문자열 객체를 생성한다.
    // => 이때 그 바이트 배열이 어떤 문자집합으로 인코딩 되었는지 알려준다.
    String str2 = new String(buf2, "UTF-8");
    
    System.out.printf("%x, %x, %x, %s\n", b2, s2, i2, str2);
    out.close();
  }
}

