/* Spring WebMVC : 파일 업로드 처리하기
 * => <input type="file">로 보낸 값을 받으려면,
 *      멀티파트 인코딩 값을처리하는 객체를 스프링에 등록해야 한다. 
 */
package control;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/control/controller16/")
public class Controller16 {
  
  
  // ServletContext 객체는 Request Handler의 아규먼트로 받을 수 없다.
  // 대신에 주입시켜 달라고 요청하라
  @Autowired ServletContext servletContext;
  
 // 1) 업로드 파일 받기
  //  =>controller16_ok1_form.html 에서 요청할것
  @RequestMapping(value="ok1")
  @ResponseBody
    public String ok01(String name, int age, MultipartFile file1, MultipartFile file2) throws Exception{
    System.out.println(name);
    System.out.println(age);
    //클라이언트가 파일을 보내지 않아도 multipartfile 객체는 생성되어 넘어온다.
    // 즉파일을 보내지 않았다고 해서 null 값이 넘어오는 것은 아니다.
    // 그럼, 파일을 보냈는지 아닌지 어떻게 아는가? 파일의 크기가 0인지 따져봐라
    System.out.println(file1);
    System.out.println(file2);
    System.out.println("---------------------------------------------");
      return "controller16_ok1";
  }
  
//1) 업로드 파일 저장하기
 //  =>controller16_ok1_form.html 에서 요청할것
 @RequestMapping(value="ok2")
 @ResponseBody
   public String ok02(String name, int age, MultipartFile file1, MultipartFile file2) throws Exception{
   System.out.println(name);
   System.out.println(age);
   System.out.println("---------------------------------------------");
   
   if (!file1.isEmpty()) {
     //파일이 넘어왓다면, 파일을 저장한다.
     System.out.printf("파일명: %s\n", file1.getOriginalFilename());
     System.out.printf("임시파일명: %s\n", file1.getName());
     System.out.printf("파라미터명: %d\n", file1.getSize());
     System.out.printf("파일 형식 :%s\n", file1.getContentType());
   }
   
   if (!file2.isEmpty()) {
     //파일이 넘어왓다면, 파일을 저장한다.
     System.out.printf("파일명: %s\n", file2.getOriginalFilename());
     System.out.printf("파라미터명: %s\n", file2.getName());
     System.out.printf("파일크기: %d\n", file2.getSize());
     System.out.printf("파일 형식 :%s\n", file2.getContentType());
   }
   
     return "controller16_ok2";
 }
 
 
//1) 업로드 파일 저장하기
//  =>controller16_ok1_form.html 에서 요청할것
@RequestMapping(value="ok3")
  public String ok03(
      String name,
      int age, 
      MultipartFile file1,
      MultipartFile file2,
      Model model) throws Exception{
  model.addAttribute("name", name);
  model.addAttribute("age", age);
  
  if (!file1.isEmpty()) { // 파일이 넘어왔다면, 파일을 저장한다.
    String filename = getNewFilename();
    model.addAttribute("file1", filename);
    file1.transferTo(new File(servletContext.getRealPath("/upload/"+filename)));
  }
  
  if (!file2.isEmpty()) { // 파일이 넘어 왔다면, 파일을 저장한다.
    String filename = getNewFilename();
    model.addAttribute("file2", filename);
    file2.transferTo(new File(
        servletContext.getRealPath("/upload/"+filename)));
  }
  
    return "controller16_ok3";
  }
int count = 0;
  synchronized private String getNewFilename() {
    if (count > 100) {
      count = 0;
    }
    return String.format("%d_%d", System.currentTimeMillis(), ++count);
}
}
