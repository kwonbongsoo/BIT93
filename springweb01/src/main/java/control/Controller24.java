/* Spring WebMVC : JSON 콘텐츠로 응답하기
 * => Ajax 파일 업로드
 */
package control;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/* 야 프론트 컨트롤러야 
 * ServletRequest에 옮겨주는 것을 알고 있다. 고맙다! JSP에서 잘 쓰고 있다.
 * 그런데, 혹시 Model에 저장된 값 중에 이름이 "member2"인 것이 있다면,
 * 그 객체는 ServletRequest 뿐만 아니라 세션에도 보관해주렴
 * 
 */
@RestController
@RequestMapping("/control/controller24/")
public class Controller24 {

  // 1) RestController
  @RequestMapping(path="upload1")
  public Object upload1(String name, int age, MultipartFile file1, MultipartFile file2) throws Exception{
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("filename", "test..ok");
    resultMap.put("filesize", 12345);
    return resultMap;
  }



}
