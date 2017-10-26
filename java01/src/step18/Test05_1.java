/* 파일 전송 프로그램 - 클라이언트 프로그램
 */
package step18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Test05_1 {
  public static void main(String[] args) throws Exception{
    if (args.length < 1) {
      System.out.println("[사용법] > java -cp bin step18.Test05_1 URL");
      return;
    }
    
    // URL에서 host 주소, 포트 번호를 분리하고 자원경로를 분리한다.
    // 예) http://www.google.com:88/test.html
    // -> host: www.google.com
    // -> port: 88
    // -> path: /test.html
    String url = args[0].replace("http://", "");
    
    
    String host = null;
    // url에 콜론(:)이 있다면 포트 번호가 있다면 것이다.
    int port = 80;
    int colonIndex = url.indexOf(":");
    int firstSlashIndex = url.indexOf("/");
    String path = url.substring(firstSlashIndex);
    if (url.indexOf(":") >= 0) {
      host = url.substring(0, colonIndex);
      port = Integer.parseInt(url.substring(colonIndex + 1, firstSlashIndex));
    } else {
      host = url.substring(0, firstSlashIndex);
    }

    
    
    try (

    
    
    Socket socket = new Socket(host,port);
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintStream out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));) {
      // [http 서버에게 요청 데이터를 보낸다.]
      // 1) request line - 예) GET /test/ok/index.html HTTP/1.1 CRLF
      out.printf("GET %s HTTP/1.1\n", path);
         
      // 2) header(general + request + entity) - 예) Host: www.daum.net
      // => 최소 Host 헤더 데이터를 보내야 한다.
      out.printf("HOST: %s\n", host);

     // 3) 요청 데이터의 끝을 의미하는 줄 바꿈 코드를 보낸다.
      out.println();
      out.flush();
      
      // [HTTP 서버가 응답한 데이터를 읽는다.]
      String str;
      while (true) {
        str = in.readLine();
        System.out.println(str);
        if (str.length() == 0) {
          break;
        }
      }
      int ch;
      while ((ch = in.read()) != -1) {
        System.out.print((char)ch);
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
