/* 
 *            
 */
package step08;

public class Test03_3 {
  
  static class Student1 {
    String name;
    int age;

  }
  static class Student2 {
    String name;
    int age;
    
    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof Student2)) return false;
      
      // ㄴ파라미터로 넘어온 값이 Student2 인스턴스의 주소가 맞다면,
      // 검사하기 쉽게 일단 Student2 타입으로 형변환 한다.
      Student2 other = (Student2)obj;
      if (!this.name.equals(other.name)) return false;
      if (this.age != other.age) return false;
      
      return true;
    }
  }
  public static void main(String[] args) {
    
   Student1 s1 = new Student1();
   
   s1.name = "홍길동";
   s1.age = 20;
   
   Student1 s2 = new Student1();
   s2.name = "홍길동";
   s2.age = 20;
   
   
    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2)); //Object의 equals()는 주소를 비교한다.
                                                // 결국 == 의 연산 결과와 같다.
    
    
    Student2 s3 = new Student2();
    
    s3.name = "홍길동";
    s3.age = 20;
    
    Student2 s4 = new Student2();
    s4.name = "홍길동";
    s4.age = 20;
    

    
     System.out.println(s3 == s4);
     System.out.println(s3.equals(s4));
   
   
  }
}
