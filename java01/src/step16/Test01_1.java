/* File 다루기 - File 클래스 사용법 */

package step16;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class Test01_1 {

  public static void main(String[] args) throws IOException{
    File f = new File("./build.gradle"); //현재 폴더 정보를 가져온다.
    //계산된 경로를 리턴하는게 아니다.
    System.out.printf("f.getAbsolutePath() = %s\n",f.getAbsolutePath());
    // 이클립스에 자바 프로그램을 실행할 때
    // 현재 위치는 프로젝트 폴더이다.
    
    // getCanonicalPath()
    // => .. 이나 . 명령을 처리하여 최종 경로를 리턴한다.
    // => 문제는.. 잘못 사용하여 존재하지 않는 디렉토리 경로가 나왔을 때,
    //      예외를 던진다.
    // => 그래서 이 메서드를 호출할 때는 예외를 던졌을 때 받을 수 있도록
    //      예외처리 문장을 작성해야 한다.
    System.out.printf("f.getCanonicalPath() = %s\n",f.getCanonicalPath());
    // getFreeSpace()
    // => File의 경로가 가리키는 디스크의 여유 공간을 바이트 단위로 리턴한다.
    System.out.printf("f.getTotalSpace() = %s\n",f.getTotalSpace());
    System.out.printf("f.getFreeSpace() = %s\n",f.getFreeSpace());
    
    System.out.printf("f.getUsableSpace() = %s\n",f.getUsableSpace());
    //getName()
    // => 디렉토리명 또는 파일명
    // => .. 이나 . 을 계산하기 전
    System.out.printf("f.getName() = %s\n",f.getName());
    // getPath()
    // => File 클레스에서 지정한 경로
    System.out.printf("f.getPath() = %s\n",f.getPath());
    // exists()
    // 해당 경로의 디렉토리 또는 파일의 존재 여부를 리턴한다.
    
    System.out.printf("f.exists() = %b\n", f.exists());
    
    // isDirectory()
    // => File 객체가 가리키는 경로가 디렉토리인지 여부를 리턴한다.
    System.out.printf("f.isDirectory() = %b\n", f.isDirectory());
    
    System.out.printf("f.isFile() = %b\n", f.isFile());
    
    // length 파일의 크기를 바이트 단위로 리턴한다.
    System.out.printf("f.length() = %d\n", f.length());
    
    // 파일이 마지막으로 변경된게 언제냐 
    // lastModified()
    System.out.printf("f.lastModified() = %s\n", f.lastModified());
    
    Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(f.lastModified());
    System.out.printf("%d-%d-%d  %s %d:%d:%d\n",
        cal.get(Calendar.YEAR),
        cal.get(Calendar.MONTH )+1,
        cal.get(Calendar.DAY_OF_MONTH),
        (cal.get(Calendar.AM_PM) == Calendar.AM) ? "AM" : "PM",
        cal.get(Calendar.HOUR),
        cal.get(Calendar.MINUTE),
        cal.get(Calendar.SECOND)
        );
  }
}
