package step10.ex01;

public class Student {
  String name;
  int age;
  
  void print() {
    System.out.printf("이름: %s \n",Student.this.name);
    System.out.printf("나이: %d \n",Student.this.age);
  }
}
