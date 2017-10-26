package step16;

public class Student {
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;
  boolean working;
  
  public Student(String name, int kor, int eng, int math, boolean working) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.sum = kor + eng + math;
    this.aver = sum/3;
    this.working = working;
  }
  public Student() {}

  @Override
  public String toString() {
    return "Student [name=" + name +  ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
        + sum + ", aver=" + aver + ", working=" + working + "]";
  }
  
  
}
