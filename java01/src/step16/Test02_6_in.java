/* File I/O : 바이트 스트림 클래스 - FileInputStream IV
 * =>  FileInputStream을 상속받아 다양한 타입의 데이터를 읽을 수 있는 기능 추가
 *       이클래스를 사용하여 데이터를 읽어보자
 */
package step16;

import java.io.FileInputStream;

public class Test02_6_in {

  public static void main(String[] args) throws Exception {
    
    MyDataInputStream in2 = new MyDataInputStream("test02_6.data");
    DataInputStream in = new DataInputStream(in2);
    
    byte b = in.readByte();
    short s = in.readShort();
    int i = in.readInt();
    
    
    String str = in.readUTF();
    System.out.printf("%x, %x, %x, %s\n", b, s, i, str);
    
    in.close();
  }
}









