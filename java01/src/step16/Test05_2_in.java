/* 데이터 프로세싱 스트림 클래스 = ObjectInputStream 도입 후
 * => 직렬화(Serialize)를 통해 출력된 데이터의 경우, 
 *      역직렬화(Deserialize)를 통해 객체로 복원시킬 수 있다.
 *      
 */

package step16;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test05_2_in {

  public static void main(String[] args) throws Exception{
    // 1) FileInputStream 객체 생성
    FileInputStream in0 = new FileInputStream("temp/test05_2.data");
    ObjectInputStream in = new ObjectInputStream(in0);
    Student2 s = (Student2)in.readObject();
    
    
    
    in.close();
    in0.close();
    System.out.println(s);
  }
}

