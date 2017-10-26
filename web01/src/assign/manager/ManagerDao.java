/* 역할:
 * => memb 테이블의 데이터를 다루는 메서드를 모아둔 클래스이다.
 * => 출력하는 역할은 호출자에게 맡긴다.
 * => DAO의 역할은 결과를 리턴하면 된다.
 * => 커넥션은 DBConnectionPool로부터 얻어서 사용하고,
 *      사용한 후에는 반납한다.
 */
package assign.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import step03.Member;

public class ManagerDao {
  step03.DBConnectionPool conPool;
  
  public ManagerDao(step03.DBConnectionPool conPool) 
      throws Exception {
    this.conPool = conPool;
  }
  
  public List<Manager> selectList(int pageNo, int pageSize) throws Exception {
    //사용할 커넥션을 DBConnectionPool로부터 빌린다.
    Connection con = conPool.getConnection();
    try ( 
      PreparedStatement stmt = con.prepareStatement("select mr.posi, mr.fax, mr.path, m.mno , m.name from mgr mr inner join memb m on mr.mrno=m.mno limit ?, ?"); 
        ) { 
      
      stmt.setInt(1, (pageNo - 1) * pageSize);
      stmt.setInt(2, pageSize);
      
      ArrayList<Manager> list = new ArrayList<>();
      try (ResultSet rs = stmt.executeQuery(/*"select mr.posi, mr.fax, mr.path, m.mno , m.name from mgr mr inner join memb m on mr.mrno=m.mno limit 0, 30"*/); ) {
        
      
        Manager mgr = null;
        while (rs.next()) { 
          mgr = new Manager();
          mgr.setName(rs.getString("name"));
          mgr.setNo(rs.getInt("mno"));
          mgr.setPosi(rs.getString("posi"));
          mgr.setFax(rs.getString("fax"));
          mgr.setPath(rs.getString("path"));
          
          list.add(mgr);
        }
       }
      return list; 
    } finally {
      conPool.returnConnection(con);
    }
  }
  public List<Manager> selectList() throws Exception {
    int pageSize = 100;
    int pageNo = 1;
    //사용할 커넥션을 DBConnectionPool로부터 빌린다.
    Connection con = conPool.getConnection();
    try ( 
      PreparedStatement stmt = con.prepareStatement("select mr.posi, mr.fax, mr.path, m.mno , m.name from mgr mr inner join memb m on mr.mrno=m.mno limit ?, ?"); 
        ) { 
      
      stmt.setInt(1, (pageNo - 1) * pageSize);
      stmt.setInt(2, pageSize);
      
      ArrayList<Manager> list = new ArrayList<>();
      try (ResultSet rs = stmt.executeQuery(); ) {
        
      
        Manager mgr = null;
        while (rs.next()) { 
          mgr = new Manager();
          mgr.setName(rs.getString("name"));
          mgr.setNo(rs.getInt("mno"));
          mgr.setPosi(rs.getString("posi"));
          mgr.setFax(rs.getString("fax"));
          mgr.setPath(rs.getString("path"));
          
          list.add(mgr);
        }
       }
      return list; 
    } finally {
      conPool.returnConnection(con);
    }
  }
  
  public Manager selectOne(int no) throws Exception {
    //사용할 커넥션을 DBConnectionPool로부터 빌린다.
    Connection con = conPool.getConnection();
    try ( 
      PreparedStatement stmt = con.prepareStatement("select m.mno, m.name, m.tel, m.pwd, m.email, mr.posi, mr.fax, mr.path from mgr mr inner join memb m  on mr.mrno=m.mno where mr.mrno=?"); ) { 
      
      stmt.setInt(1, no);
      
      try (ResultSet rs = stmt.executeQuery(); ) {
       
      
        Manager mgr = null;
        if (!rs.next())  
          return null;
        
        mgr = new Manager();
        mgr.setNo(rs.getInt("mno"));
        mgr.member =new Member();
        mgr.member.setNo(rs.getInt("mno"));
        mgr.member.setName(rs.getString("name"));
        mgr.member.setEmail(rs.getString("email"));
        mgr.member.setTel(rs.getString("tel"));
        mgr.member.setPassword(rs.getString("pwd"));
        mgr.setName(rs.getString("name"));
        mgr.setPosi(rs.getString("posi"));
        mgr.setFax(rs.getString("fax"));
        mgr.setPath(rs.getString("path"));
        
        return mgr;

       }
    } finally {
      conPool.returnConnection(con);
    }
  }
  
  public int insert(Manager mgr, int no) throws Exception {
    Connection con = conPool.getConnection();
    try (
      PreparedStatement stmt = con.prepareStatement(
          "insert into mgr(mrno, posi,fax,path) values(?,?,?,?)");
        ) {
      stmt.setInt(1, no);
      stmt.setString(2, mgr.getPosi());
      stmt.setString(3, mgr.getFax());
      stmt.setString(4, mgr.getPath());
      
      return stmt.executeUpdate();
    }finally {
      conPool.returnConnection(con);
    }
  }
  
  public int delete(int no) throws Exception {
    Connection con = conPool.getConnection();
    try (
      PreparedStatement stmt = con.prepareStatement(
          "delete from mgr where mrno=?");) {
      
      stmt.setInt(1, no);
      return stmt.executeUpdate();
    }finally {
      conPool.returnConnection(con);
    }
  }
  
  public int update(Manager manager) throws Exception {
    Connection con = conPool.getConnection();
    try (
      PreparedStatement stmt = con.prepareStatement(
          "update mgr set posi=?, fax=?, path=? where mrno=?");) {
      
      stmt.setString(1, manager.getPosi());
      stmt.setString(2, manager.getFax());
      stmt.setString(3, manager.getPath());
      stmt.setInt(4, manager.getNo());
      return stmt.executeUpdate();
    } finally {
      conPool.returnConnection(con);
    }
  }

}
