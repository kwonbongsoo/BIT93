
package step08;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Test08_2 {
  
  public static void main(String[] args) throws Exception {
   Properties props = new Properties();
    

   props.load(new FileReader("test.properties"));
   System.out.println(props.getProperty("key1"));
   System.out.println(props.getProperty("key2"));
   System.out.println(props.getProperty("key3"));
   System.out.println(props.getProperty("key4"));
   
   System.out.println("---------------------------------------------");
   
   System.out.println(props.get("key1"));
   System.out.println(props.get("key2"));
   System.out.println(props.get("key3"));
   System.out.println(props.get("key4"));
  }
}







