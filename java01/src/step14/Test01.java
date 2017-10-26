package step14;

public class Test01 {

  public static void main(String[] args) {
    Bucket b= new Bucket();
    
    String str = new String("Hello");
    System.out.println(str.length());
    
    b.setValue(str);
    String str2 = (String)b.getValue();
    System.out.println(str2.length());
  }

}
