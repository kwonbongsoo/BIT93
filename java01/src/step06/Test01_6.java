/* 
 */
package step06;

public class Test01_6 {
  
  public static void main(String[] args) {
    Student3 s1 = new Student3("홍길동", 100, 90, 80); 
    Student3 s2 = new Student3("임꺽정", 90, 90, 90);
    Student s3 = new Student();
    Student.init(s3, "유관순", 80, 80, 80);
    Student.compute(s3);
    Student.print(s3);
    //객체 인스턴스 함수의 static 의 차이
    //사용법이 다르다.
    //static 으로 선언하면 this 기능이 내장 되어 있지 않아 파라미터로 객체주소를 넘겨줘야 한다.
  }
}
