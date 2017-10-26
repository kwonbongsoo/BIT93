package step08;

public class Practice {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    Point p = new Point(list);
    
    p = list.add(p, 1);
    p = list.add(p, 2);
    p = list.add(p, 3);
    p = list.add(p, 4);
    System.out.println(p.end.value);
    list.print();
    list.delete(3, p);
    list.print();
    
  }
}
