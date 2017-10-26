/* 상수 값 다루기 : enum 문법 적용 후
 * 
 */
package step15;

public class Test03 {
  public static void main(String[] args) {
   
   
   SchoolLevel[] values = SchoolLevel.values();
   for (SchoolLevel value : values) {
     System.out.printf("name() = %s\n",value.name());
     System.out.printf("toString() = %s\n",value.toString());
     System.out.printf("ordinal() = %s\n",value.ordinal());
     System.out.println("----------------------------------");
     
     System.out.println(SchoolLevel2.BACHELOR);
     
   }
  }
}
