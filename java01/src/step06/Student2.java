package step06;


// 클래스 안에 정의된 클래스를 이렇게 별도의 파일로 분리시킬 때는
// static 을 붙이면 안된다.
public class Student2 {

  String name;
  int[] scores = new int[3];
  int total;
  float aver;
  
  // static이 붙지 않은 메서드를 "인스턴스 메서드"라 부른다.
  public  void compute() {
    this.total = this.scores[0] + this.scores[1] + this.scores[2];
    this.aver = this.total / 3f;
  }
  public  void print() {
    System.out.printf("%s, %d, %d, %d, %d, %f\n", this.name, this.scores[0], this.scores[1], this.scores[2], this.total, this.aver);
  }
  public  void init(String name, int kor, int eng, int math) {
    this.name = name;
    this.scores[0] = kor;
    this.scores[1] = eng;
    this.scores[2] = math;
  }
}
