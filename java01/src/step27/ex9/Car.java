/* @Autowired 사용: required 속성
 */
package step27.ex9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Car {
  String model;
  int cc;
  //@Autowired 에는 required 속성이 있따 기본이 true이다.
  @Autowired(required=false) Engine engine;
  
  public Car() {
    System.out.println("Car()");
    this.model = "기본 자동차";
    this.cc = 900;
  }
  
  public Car(String model, int cc) {
    System.out.println("Car(String, int)");
    this.model = model;
    this.cc = cc;
  }
  public Car(String model, int cc, Engine engine) {
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
