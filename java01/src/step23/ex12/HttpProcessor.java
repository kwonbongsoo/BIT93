package step23.ex12;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Map;

public class HttpProcessor extends Thread{
    Socket socket;
    Map<String, Command> servletMap;
    // url과 url을 처리할 객체를 맵에 보관한다.
    public HttpProcessor(Socket socket, Map<String, Command> servletMap) {
      this.socket = socket;
      this.servletMap = servletMap;
      
    }
    public void run () {
      try (
          Socket socket = this.socket;
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          PrintStream out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));) 
      {
        String line = null;
        boolean requestLine = true;
        String url = null;
        while (true) {
          line = in.readLine();
          if (line.isEmpty())
            break;
          if (requestLine){
            requestLine = false;
            url = extractUrl(line);
          }
        }
        
        Command servlet = servletMap.get(url);
        
        if (servlet != null) { // 있따면
          servlet.service(out); // 그 커멘드 객체(서블릿)을 호출한다
        } else {// 없다면
          servletMap.get("error").service(out); // 오류를 처리하는 커맨드 객체를 호출한다.
        }
        
        out.flush(); // 마무리로 버퍼에 쌓여있는 출력물을 클라이언트로 보낸다.
        
        
        
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    } //run
    private  String extractUrl(String requestLine) {
      return requestLine.substring(requestLine.indexOf(" ") + 1, requestLine.lastIndexOf(" "));
    }
  }
