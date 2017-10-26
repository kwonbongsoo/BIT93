package step16;

import java.io.Serializable;

// 이 클래스의 인스턴스 값을 직렬화하는 것을 허용하자!
public class Student2 implements Serializable{
  /**
   * 객체의 인스턴스 값을 직렬화하여 저장할 때, 저장되는 데이터의 버전 번호이다.
   * 활용?
   * => 읽는 쪽에서 버전 번호를 활용하여 데이터 호환 여부를 손쉽게 검사할 수 있다.
   * 데이터의 버전을 저장하는 것은 일상적인 일이다.
   * 예를 들면, 워드나 HWP, PPT 엑셀 데이터를 파일에 저장할 때도
   * 어떤 버전에서 작성했는지 파일에 기록된다.
   * 그래서 그 파일을 읽을 때 사용자가 실행하는 프로그램에서 읽을 수 있는지 여부를 확인할때 사용한다
   * 
   */
  private static final long serialVersionUID = 1L;
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;
  boolean working;
  
  public Student2(String name, int kor, int eng, int math, boolean working) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.sum = kor + eng + math;
    this.aver = sum/3;
    this.working = working;
  }
  public Student2() {}

  @Override
  public String toString() {
    return "Student [name=" + name +  ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
        + sum + ", aver=" + aver + ", working=" + working + "]";
  }
  
  
}
