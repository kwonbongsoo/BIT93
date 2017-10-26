package step22.ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DBConnectionPool {
  String url;
  String username;
  String password;
  
  // 반납한 커넥션을 보관해두는 컬렉션이다.
  // 커넥션을 요구할 때 마다 이 컬렉션에서 꺼내서 준다.
  ArrayList<Connection> conList = new ArrayList<>();
  
  public DBConnectionPool(String driver, String url, String username, String password) 
    throws Exception {
    Class.forName(driver);
    
    this.url = url;
    this.username = username;
    this.password = password;
    
  }
  // DB 커넥션 객체를 임대
  public Connection getConnection() throws Exception{
    if (conList.size() > 0) {
      return conList.remove(0);
    }
    return DriverManager.getConnection(this.url, this.username, this.password);
  }
  // DB 커넥션 객체를 반납
  public void returnConnection(Connection con) {
    conList.add(con);
  }
}
