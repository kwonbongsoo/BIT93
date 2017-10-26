/* @Resource 사용: @Autowired + @Qualifier */
package step27.ex13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Car2 {
  String model;
  int cc;
//  @Resource(name="delta")
  //방법1
  @Autowired
  @Qualifier("delta")
  //방법2
  Engine engine;
  public Car2() {
    System.out.println("Car()");
    this.model = "기본 자동차";
    this.cc = 900;
  }
  
  public Car2(String model, int cc) {
    System.out.println("Car(String, int)");
    this.model = model;
    this.cc = cc;
  }
  public Car2(String model, int cc, Engine engine) {
    System.out.println("Car(String, int, engine)");
    this.model = model;
    this.cc = cc;
    this.engine = engine;
  }

  @Override
  public String toString() {
    return "Car [model=" + model + ", cc=" + cc + ", engine=" + engine + "]";
  }

  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    System.out.println("setModel");
    this.model = model;
  }
  public int getCc() {
    return cc;
  }
  public void setCc(int cc) {
    System.out.println("setCc");
    this.cc = cc;
  }
}
