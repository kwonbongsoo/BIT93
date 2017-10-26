/* 배열 변수와 레퍼런스
 */
package step02;

public class Test11 {
  public static void main(String[] args) {
    String[] names = {"홍길동", "임꺽정", "유관순"};
    byte[][] scores = {{100, 100, 100},{90, 90, 90}, {80, 80, 80}};
    short[] totals = {300, 270, 240};
    float[] aver = {100f, 90f, 80.0f};
    String str = "";
    for (int i = 0; i<3; i++) {
      str += "이름: ";
      str += names[i] + " ";
      for (int j = 0; j <scores.length; j++){
       if(j == 1) {
         str += "국어: ";
       }else if (j == 2) {
         str += "수학: ";
       } else {
         str += "영어: ";
       }
       str += scores[i][j]+ " ";
      }
      str += "총점";
      str += totals[i]+ " ";
      str += "평균:";
      str += aver[i];
      System.out.println(str);
      str = "";
    }
    
  }
}
