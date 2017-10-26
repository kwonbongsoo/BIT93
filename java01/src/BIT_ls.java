import java.io.File;
import java.io.IOException;

public class BIT_ls {
  public static void  displayDirectory(File dir, int level) {
    File[] files = dir.listFiles();
       for (File file : files) {
         for (int i = 0; i < level; i++) System.out.print("  ");
           System.out.printf("d : %s %s - %d\n", 
               file.isDirectory() ? ">" : " ",
               file.getName(),
               file.length()
               );
           if (file.isDirectory()) {
             displayDirectory(file, level+1);
           }
       }
     }
  public static void main(String[] args) throws IOException {
    if (args.length < 1) {
      System.out.println("[사용법]");
      System.out.println(">java -cp bin BIT_ls");
      System.out.println(">java -cp bin BIT_ls");
      return;
    } else if (args[0].equals("BIT_ls") == true) {
      File f = new File("./");
      displayDirectory(f, 0);
    } else {
      System.out.println("잘못입력하셨습니다");
    }
  }
}
