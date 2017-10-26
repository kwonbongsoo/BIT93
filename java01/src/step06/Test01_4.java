/* 
 */
package step06;


public class Test01_4 {
  
  public static void main(String[] args) {
    Student s1 = new Student(); 
    s1.init(s1, "홍길동", 100, 100, 100);
    Student.compute(s1);
    Student.print(s1);
    
    Student s2 = new Student();
    Student.init(s2, "임꺽정", 90, 90, 90);
    Student.compute(s2);
    Student.print(s2);
    
    Student s3 = new Student();
    Student.init(s3, "유관순", 80, 80, 80);
    Student.compute(s3);
    Student.print(s3);
    
  }
    

}
