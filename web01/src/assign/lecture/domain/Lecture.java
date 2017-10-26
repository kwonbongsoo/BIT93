/* 역할: memb 테이블의 값을 보관할 때 사용할 클래스
 * => 복합 데이터를 다룰 때, 이렇게 클래스를 정의하여 사용한다.
 * => 이런 복합 데이터를 보관하는 용도로 사용하는 클래스를
 *    "도메인(domain)" 클래스 또는 "DTO(Data Transfer Object)"라 부른다.
 */
package assign.lecture.domain;

public class Lecture {
  int lno;
  int crmno;
  int mrno;
  int qty;
  int pric;
  int thrs;
  String titl;
  String dscp;
  String sdt;
  String edt;
  public int getLno() {
    return lno;
  }
  public void setLno(int lno) {
    this.lno = lno;
  }
  public int getCrmno() {
    return crmno;
  }
  public void setCrmno(int crmno) {
    this.crmno = crmno;
  }
  public int getMrno() {
    return mrno;
  }
  public void setMrno(int mrno) {
    this.mrno = mrno;
  }
  public int getQty() {
    return qty;
  }
  public void setQty(int qty) {
    this.qty = qty;
  }
  public int getPric() {
    return pric;
  }
  public void setPric(int pric) {
    this.pric = pric;
  }
  public int getThrs() {
    return thrs;
  }
  public void setThrs(int thrs) {
    this.thrs = thrs;
  }
  public String getTitl() {
    return titl;
  }
  public void setTitl(String titl) {
    this.titl = titl;
  }
  public String getDscp() {
    return dscp;
  }
  public void setDscp(String dscp) {
    this.dscp = dscp;
  }
  public String getSdt() {
    return sdt;
  }
  public void setSdt(String sdt) {
    this.sdt = sdt;
  }
  public String getEdt() {
    return edt;
  }
  public void setEdt(String edt) {
    this.edt = edt;
  }
  
  
  
  
}
