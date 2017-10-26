package step27.ex3;

public class CarFactory {
  public static Car createCar(String name) {
    switch (name) {
    case "tico" : return createTico();
    case "sonata" : return createSonata();
    default : return null;
    }
  }
  
  private static Car createTico() {
Engine e1 = new Engine(16, 8);
    
    Tire[] tireList = {
      new Tire("비트타이어", 13),
      new Tire("비트타이어", 13),
      new Tire("비트타이어", 13),
      new Tire("비트타이어", 13)
    };
    
    Car c1 = new Car();
    c1.setModel("티코");
    c1.setCc(800);
    c1.setEngine(e1);
    c1.setTires(tireList);
    return c1;
  }
  private static Car createSonata() {
 Engine e1 = new Engine(16, 8);
    
    Tire[] tireList = {
      new Tire("비트타이어", 13),
      new Tire("비트타이어", 13),
      new Tire("비트타이어", 13),
      new Tire("비트타이어", 13)
    };
    
    Car c2 = new Car();
    c2.setModel("소나타");
    c2.setCc(1998);
    c2.setEngine(e1);
    c2.setTires(tireList);
    return c2;
  }
}
