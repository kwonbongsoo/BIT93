package step10.ex01;

public class BitStudent extends Student{
  String school;
  
  void print() {
    super.print();
    System.out.printf("학교: %s \n", this.school);
    
  }
}
