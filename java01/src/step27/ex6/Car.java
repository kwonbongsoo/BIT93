/* @Autowired 사용: 셋터 메서드에 붙이기
 * => Spring IoC 컨테이너가 Car 객체를 만들 때,
 *      @Autowired가 좋은 셋터 메서드를 호출하여 
 *      의존 객체를 주입 해야 한다는것을 의미한다.
 */
package step27.ex6;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {
  String model;
  int cc;
  Engine engine;
  
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

  public Engine getEngine() {
    return engine;
  }
  @Autowired
  public void setEngine(Engine engine) {
    System.out.println("setEngine");
    this.engine = engine;
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
