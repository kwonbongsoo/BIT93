/* @Autowired 사용: @Qualifier
 */
package step27.ex10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class Car {
  String model;
  int cc;
  // 애노테이션은 한 줄로 길게 붙일 수 있다. 그러나 보기가 불편하므로 여러 줄로 표현하라
  
  
  //@Autowired @Qualifier(value="e2") Engine engine;
  @Autowired
  @Qualifier(value="e1")
  // xml에서 생성한 두개의 엔진중에서 뭐를 셋팅해야할지몰라 에러가 뜨는데 qualifier로 하나를 설정해줘야 이렇게 에러가 뜨지 않는다.
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
