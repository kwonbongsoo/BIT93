package step27.ex4;

import java.beans.PropertyEditorSupport;

// 인터페이스를 직접 구현하는 대신, PropertyEditorSupport를 상속 받는다.
public class CustomEngineEditor extends PropertyEditorSupport{
  // 파라미터로 넘어오는 값은 XML 설정 파일에 지정한 문자열이다.
  // 이문자열을 가지고 java.sql.Date 객체를 만들어 내부에 저장하면 된다.
  
  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    String[] values = text.split(",");
    Engine engine = new Engine(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
    this.setValue(engine);
  }
}
