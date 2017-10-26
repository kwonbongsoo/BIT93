/*  사용자(개발자) 정의 데이터 타입(custom data type) : 값 초기화 시키기
 * => 값 을 초기화 시키는 메서드를 정의한다.
 */
package step02;

public class Test14 {
  static class Student {
    String name;
    byte[] scores;
    short total;
    float aver;
  }
  public static Student createStudent(String name, byte kor, byte eng, byte math) {
    Student s = new Student();
    s.name = name;
    s.scores = new byte[]{kor, eng, math};
    s.total = (short)(kor+eng+math);
    s.aver = s.total / 3f;
    return s;
    
  }
  public static void main(String[] args) {
    
    Student[] arr1 = new Student[3]; 
    
    arr1[0] = createStudent("홍길동", (byte)100, (byte)100, (byte)100);
    arr1[1] = createStudent("임꺽정", (byte)90, (byte)90, (byte)90);
    arr1[2] = createStudent("유관순", (byte)80, (byte)80, (byte)80);
    
    

    
    for (int i = 0; i < arr1.length; i++) {
      System.out.printf("%s %d %d %d %d %f\n",
          arr1[i].name,
          arr1[i].scores[0], arr1[i].scores[1], arr1[i].scores[2],
          arr1[i].total,
          arr1[i].aver);
    }
   
    
    // 자바는 자바스크립트와 다르게, 설계도에 따라 만든 메모리 외에는
    // 임의로 다른 메모리를 추가 할수 없다
    
    // s1.tel = "1111111"; //컴파일 오류
    
  }
}


/*
 * primitive data type
 * => byte, short, int, long, float, double, boolean, char
 * 
 * 사용자 정의 데이터 타입?
 * => 개발자가 자신이 원하는 방식으로 데이터를 묶어서 다루기 위해
 *      새로 정의하는 데이터 타입
 * => 문법
 *      class 데이터타입명 {
 *      데이터타입 변수명;
 *      }
 *      
 * 인스턴스?
 * => class 설계도에 따라 준비한 메모리
 * => 보통 객체(object)라고 부른다.
 * 
 * 레퍼런스?
 * => 배열이든 인스턴스이든 메모리의 주소를 저장하는 변수를 말한다.
 * 
 * class 문법?
 * 1) 사용자 정의 데이터 타입을 만들 때
 * 2) 메서드를 기능이나 역할에 따라 분류할 때 
 * 
 * 필드(field)?
 * => 인스턴스를 구성하는 메모리 항목을 말한다.
 * => field = attribute != property
 * 
 * 프로퍼티(property)?
 * => 인스턴스의 필드를 다루는 getXxx()/setXxx() 메서드를 가리키는 용어다.
 * 
 */
