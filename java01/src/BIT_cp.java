import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BIT_cp {
  public static void copy(String fileName, String copyName) throws Exception{
    FileInputStream in0 = new FileInputStream(fileName);
    BufferedInputStream in = new BufferedInputStream(in0);
    FileOutputStream out0 = new FileOutputStream(copyName);
    BufferedOutputStream out = new BufferedOutputStream(out0);
    int len = 0;
    while((len = in.read()) != -1) {
      out.write((char)len);
      }
    in.close();
    in0.close();
    out.close();
    out0.close();
  }
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("[사용법]");
      System.out.println(">java -cp bin BIT_cp BIT_cp 복사할 파일명, 목적파일명");
      return;
    } else if (args[0].equals("BIT_cp") == true) {
      String fileName = "";
      String copyName = "";
      fileName = args[1];
      copyName = args[2];
      try {
        copy(fileName, copyName);
      } catch (Exception e) {
        e.printStackTrace();
      }
      
    } else {
      System.out.println("잘못입력하셨습니다");
    }
  }
}
