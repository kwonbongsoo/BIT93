/* 역할: memb 테이블의 값을 보관할 때 사용할 클래스
 * => 복합 데이터를 다룰 때, 이렇게 클래스를 정의하여 사용한다.
 * => 이런 복합 데이터를 보관하는 용도로 사용하는 클래스를
 *    "도메인(domain)" 클래스 또는 "DTO(Data Transfer Object)"라 부른다.
 */
package assign.manager;

import step03.Member;

public class Manager {
  Member member;
  int no;
  String name;
  String posi;
  String fax;
  String path;
  public void addMember(Member m) {
    this.member = m;
  }
  @Override
  public String toString() {
    return "Manager [no=" + no + ", 직급=" + posi + ", 팩스=" + fax + ", path=" + path + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getPosi() {
    return posi;
  }

  public void setPosi(String posi) {
    this.posi = posi;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  public String getName() {
    return this.name;
  }
  
  
  
}
