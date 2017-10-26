import java.io.File;

public class BIT_del {
  public static void  displayDirectory(File dir, int level) {
    File[] files = dir.listFiles();
       for (File file : files) {
         for (int i = 0; i < level; i++) System.out.print("  ");
           System.out.printf("삭제할 폴더 : %s :%d\n",
            file.getName(),level);
           if (file.isDirectory()) {
             displayDirectory(file, level+1);
           }file.delete();
       }
     }
  public static void main(String[] args) {
    if (args.length < 1 || args.length > 4) {
      System.out.println("[사용법]");
      System.out.println(">java -cp bin BIT_del BIT_del , 삭제할파일명");
      System.out.println(">java -cp bin BIT_del BIT_del , -R , 삭제할파일명");
      return;
    } else if (args[0].equals("BIT_del") == true) { 
      String fileName = "";
      if (!args[1].equals("-R")) {
        fileName = args[1];
        File f = new File(fileName);
        f.delete();
      } else if (args[1].equals("-R")) {
        File f = new File("./tmp1");
        displayDirectory(f, 0);
      }
    }
  }
}
