package step08;

public class LinkedList {
  LinkedList next;
  int value;
  public static LinkedList TMP;
  public static int SIZE = 0;
  
  LinkedList() {
    this.next = null;
  }
  
  public Point add(Point p, int value) {
    TMP = this;
    while(TMP.next != null)
      TMP = TMP.next;
    TMP.next = new LinkedList();
    p.end = TMP.next;
    TMP = TMP.next;
    TMP.value = value;
    SIZE++;
    TMP = null;
    return p;
  }
  
  public int size() {
    return SIZE;
  }
  
  public void print() {
    TMP = this;
    while(TMP.next != null) {
      System.out.println(TMP.value);
      TMP = TMP.next;
    }
    System.out.println(TMP.value);
    TMP = null;
  }
  public void delete(int value, Point p) {
    LinkedList delete = this;
    LinkedList prev = null;
    while(delete.value != value) {
      delete= delete.next;
      if (delete.next.value == value)
        prev = delete;
    }
    TMP = delete.next;
    prev.next = TMP;
    TMP = null;
  }
}
