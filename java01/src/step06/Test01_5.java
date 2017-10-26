/* 
 */
package step06;


public class Test01_5 {
  
  public static void main(String[] args) {
    Student2 s1 = new Student2(); 
    s1.init( "홍길동", 100, 100, 100);
    s1.compute();
    s1.print();
    
    Student2 s2 = new Student2();
    s2.init("임꺽정", 90, 90, 90);
    s2.compute();
    s2.print();
    
    Student s3 = new Student();
    Student.init(s3, "유관순", 80, 80, 80);
    Student.compute(s3);
    Student.print(s3);
    //객체 인스턴스 함수의 static 의 차이
    //사용법이 다르다.
    //static 으로 선언하면 this 기능이 내장 되어 있지 않아 파라미터로 객체주소를 넘겨줘야 한다.
  }
    

}
