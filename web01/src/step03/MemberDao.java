/* 역할:
 * => memb 테이블의 데이터를 다루는 메서드를 모아둔 클래스이다.
 * => 출력하는 역할은 호출자에게 맡긴다.
 * => DAO의 역할은 결과를 리턴하면 된다.
 * => 커넥션은 DBConnectionPool로부터 얻어서 사용하고,
 *      사용한 후에는 반납한다.
 */
package step03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MemberDao {
  DBConnectionPool conPool;
  
  public MemberDao(DBConnectionPool conPool) 
      throws Exception {
    this.conPool = conPool;
  }
  
  public List<Member> selectList(int pageNo, int pageSize) throws Exception {
    //사용할 커넥션을 DBConnectionPool로부터 빌린다.
    Connection con = conPool.getConnection();
    try ( 
      PreparedStatement stmt = con.prepareStatement("select mno, name, tel, email from memb order by name asc limit ?, ?"); ) { 
      
      stmt.setInt(1, (pageNo - 1) * pageSize);
      stmt.setInt(2, pageSize);
      
      ArrayList<Member> list = new ArrayList<Member>() {
      };
      try (ResultSet rs = stmt.executeQuery(); ) {
       
      
        Member member = null;
        while (rs.next()) { 
          member = new Member();
          member.setNo(rs.getInt("mno"));
          member.setName(rs.getString("name"));
          member.setTel(rs.getString("tel"));
          member.setEmail(rs.getString("email"));
          
          list.add(member);
        }
       }
      return list; 
    } finally {
      conPool.returnConnection(con);
    }
  }
  
  public Member selectOne(int no) throws Exception {
    //사용할 커넥션을 DBConnectionPool로부터 빌린다.
    Connection con = conPool.getConnection();
    try ( 
      PreparedStatement stmt = con.prepareStatement("select mno, name, tel, email from memb where mno=?"); ) { 
      
      stmt.setInt(1, no);
      
      try (ResultSet rs = stmt.executeQuery(); ) {
       
      
        Member member = null;
        if (!rs.next())  
          return null;
        
        member = new Member();
        member.setNo(rs.getInt("mno"));
        member.setName(rs.getString("name"));
        member.setTel(rs.getString("tel"));
        member.setEmail(rs.getString("email"));
        
        return member;

       }
    } finally {
      conPool.returnConnection(con);
    }
  }
  
  public int insert(Member member) throws Exception {
    Connection con = conPool.getConnection();

    try (
      PreparedStatement stmt = con.prepareStatement(
          "insert into memb(name,tel,email,pwd) values(?,?,?,password(?))",new String[] {"mno"});) {
      stmt.setString(1, member.getName());
      stmt.setString(2, member.getTel());
      stmt.setString(3, member.getEmail());
      stmt.setString(4, member.getPassword());
      
     
        if (stmt.executeUpdate() > 0) {
          try ( 
              ResultSet rs = stmt.getGeneratedKeys();)
          {
          if (rs.next()) {
            return rs.getInt(1);
          }else {
            
            throw new SQLException("만드는데 실패했습니다. 얻은아이디가 없습니다.");
          }
        }
      }
      return 0;
    }finally {
      conPool.returnConnection(con);
    }
  }
  
  public int delete(int no) throws Exception {
    Connection con = conPool.getConnection();
    try (
      PreparedStatement stmt = con.prepareStatement(
          "delete from memb where mno=?");) {
      
      stmt.setInt(1, no);
      return stmt.executeUpdate();
    }finally {
      conPool.returnConnection(con);
    }
  }
  
  public int update(Member member) throws Exception {
    Connection con = conPool.getConnection();
    try (
      PreparedStatement stmt = con.prepareStatement(
          "update memb set name=?, tel=?, email=?, pwd=password(?) where mno=?");) {
      
      stmt.setString(1, member.getName());
      stmt.setString(2, member.getTel());
      stmt.setString(3, member.getEmail());
      stmt.setString(4, member.getPassword());
      stmt.setInt(5, member.getNo());
      return stmt.executeUpdate();
    } finally {
      conPool.returnConnection(con);
    }
  }
  
  public Member selectOneByEmailPassword (String email, String password) throws Exception {
    //사용할 커넥션을 DBConnectionPool로부터 빌린다.
    Connection con = conPool.getConnection();
    try ( 
      PreparedStatement stmt = con.prepareStatement("select mno, name, tel, email from memb where email=? and pwd= password(?)"); ) { 
      
      stmt.setString(1, email);
      stmt.setString(2, password);
      
      
      try (ResultSet rs = stmt.executeQuery(); ) {
       
      
        Member member = null;
        if (!rs.next())  
          return null;
        
        member = new Member();
        member.setNo(rs.getInt("mno"));
        member.setName(rs.getString("name"));
        member.setTel(rs.getString("tel"));
        member.setEmail(rs.getString("email"));
        
        return member;

       }
    } finally {
      conPool.returnConnection(con);
    }
    }

}
