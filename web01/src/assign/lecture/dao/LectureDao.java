/* 역할:
 * => memb 테이블의 데이터를 다루는 메서드를 모아둔 클래스이다.
 * => 출력하는 역할은 호출자에게 맡긴다.
 * => DAO의 역할은 결과를 리턴하면 된다.
 * => 커넥션은 DBConnectionPool로부터 얻어서 사용하고,
 *      사용한 후에는 반납한다.
 */
package assign.lecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import assign.lecture.domain.Lecture;
import step03.DBConnectionPool;

public class LectureDao {
  DBConnectionPool conPool;
  
  public LectureDao(DBConnectionPool conPool) 
      throws Exception {
    this.conPool = conPool;
  }
  
  public List<Lecture> selectList(int pageNo, int pageSize) throws Exception {
    //사용할 커넥션을 DBConnectionPool로부터 빌린다.
    Connection con = conPool.getConnection();
    try ( 
      PreparedStatement stmt = con.prepareStatement("select lno, titl, date_format(sdt, '%Y-%m-%d') sdt2, date_format(edt, '%Y-%m-%d') edt2, thrs, pric from lect order by titl asc limit ?, ?"); ) { 
      
      stmt.setInt(1, (pageNo - 1) * pageSize);
      stmt.setInt(2, pageSize);
      
      ArrayList<Lecture> list = new ArrayList<>();
      try (ResultSet rs = stmt.executeQuery(); ) {
       
      
        Lecture lect = null;
        while (rs.next()) { 
          lect = new Lecture();
          lect.setLno(rs.getInt("lno"));
          lect.setTitl(rs.getString("titl"));
          lect.setSdt(rs.getString("sdt2"));
          lect.setEdt(rs.getString("edt2"));
          lect.setThrs(rs.getInt("thrs"));
          lect.setPric(rs.getInt("pric"));
          
          list.add(lect);
        }
       }
      return list; 
    } finally {
      conPool.returnConnection(con);
    }
  }
  
  public Lecture selectOne(int no) throws Exception {
    //사용할 커넥션을 DBConnectionPool로부터 빌린다.
    Connection con = conPool.getConnection();
    try ( 
      PreparedStatement stmt = con.prepareStatement("select lno, titl, dscp, date_format(sdt,'%Y-%m-%d') sdt2, date_format(edt,'%Y-%m-%d') edt2, qty, pric, thrs, crmno, mrno  from lect where lno=?"); ) { 
      
      stmt.setInt(1, no);
      
      try (ResultSet rs = stmt.executeQuery(); ) {
       
      
        Lecture lect = null;
        if (!rs.next())  
          return null;
        
        lect = new Lecture();
        lect.setLno(rs.getInt("lno"));
        lect.setTitl(rs.getString("titl"));
        lect.setDscp(rs.getString("dscp"));
        lect.setSdt(rs.getString("sdt2"));
        lect.setEdt(rs.getString("edt2"));
        lect.setQty(rs.getInt("qty"));
        lect.setPric(rs.getInt("pric"));
        lect.setThrs(rs.getInt("thrs"));
        lect.setCrmno(rs.getInt("crmno"));
        lect.setMrno(rs.getInt("mrno"));
        
        return lect;

       }
    } finally {
      conPool.returnConnection(con);
    }
  }
//  
  public int insert(Lecture lecture) throws Exception {
    Connection con = conPool.getConnection();

    try (
      PreparedStatement stmt = con.prepareStatement(
          "insert into lect(titl,dscp,sdt,edt,qty,pric,thrs,mrno,crmno) values(?,?,?,?,?,?,?,?,?)");) {
      stmt.setString(1, lecture.getTitl());
      stmt.setString(2, lecture.getDscp());
      stmt.setString(3, lecture.getSdt());
      stmt.setString(4, lecture.getEdt());
      stmt.setInt(5, lecture.getQty());
      stmt.setInt(6, lecture.getPric());
      stmt.setInt(7, lecture.getThrs());
      stmt.setInt(8, lecture.getMrno());
      stmt.setInt(9, lecture.getCrmno());
      
     
        return stmt.executeUpdate() ;
        
      }finally {
      conPool.returnConnection(con);
    }
  }
  
  public int delete(int no) throws Exception {
    Connection con = conPool.getConnection();
    try (
      PreparedStatement stmt = con.prepareStatement(
          "delete from lect where lno=?");) {
      
      stmt.setInt(1, no);
      return stmt.executeUpdate();
    }finally {
      conPool.returnConnection(con);
    }
  }
  
  public int update(Lecture lecture) throws Exception {
    Connection con = conPool.getConnection();
    try (
      PreparedStatement stmt = con.prepareStatement(
          "update lect set crmno=?, mrno=?, titl=?, dscp=?, sdt=?, edt=?, qty=?, pric=?, thrs=? where lno=?");) {
      System.out.println(lecture.getCrmno());
      stmt.setInt(1, lecture.getCrmno());
      stmt.setInt(2, lecture.getMrno());
      stmt.setString(3, lecture.getTitl());
      stmt.setString(4, lecture.getDscp());
      stmt.setString(5, lecture.getSdt());
      stmt.setString(6, lecture.getEdt());
      stmt.setInt(7, lecture.getQty());
      stmt.setInt(8, lecture.getPric());
      stmt.setInt(9, lecture.getThrs());
      stmt.setInt(10, lecture.getLno());
      return stmt.executeUpdate();
    } finally {
      conPool.returnConnection(con);
    }
  }

}
