package bitcamp.java93.control.json;
/* 회원 관리 만들기 : 회원 목록 출력하기2
 * => 포워드 적용: 오류 처리 부분
 * => 인클루딩 적용: 웹페이지의 꼬리말 출력 부분
 */


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bitcamp.java93.domain.Teacher;
import bitcamp.java93.service.TeacherService;

@RestController
@RequestMapping("/teacher/")
public class TeacherControl {
  @Autowired ServletContext servletContext;
  @Autowired TeacherService teacherService;
  
  @RequestMapping("list")
  public JsonResult list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="100") int pageSize
      ) throws Exception {
      HashMap<String, Object> valueMap = new HashMap<String, Object>();
      valueMap.put("list", teacherService.list(pageNo, pageSize));
      valueMap.put("totalCount", teacherService.getSize());
      return new JsonResult(JsonResult.SUCCESS, valueMap);
  }
  
  @RequestMapping("detail")
  public JsonResult detail(int no, Model model) throws Exception{
      Teacher teacher = teacherService.get(no);
      
      if (teacher == null) {
        return new JsonResult(JsonResult.FAIL, no+"번 강사가 없습니다");
      }
      model.addAttribute("teacher", teacher);
      return new JsonResult(JsonResult.SUCCESS, teacher);
  }
  
  @RequestMapping("delete")
  public JsonResult delete(int no) throws Exception {
      teacherService.remove(no);
      return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  
  
  @RequestMapping("update")
  public JsonResult update(
      Teacher teacher
      ) throws Exception {
      
      

      teacherService.update(teacher);
      
     return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  
  @RequestMapping("add")
  public JsonResult add(
      Teacher teacher
      ) throws Exception{
      teacherService.add(teacher);
      return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  
  private List<String> processMultipartFiles(MultipartFile[] files) throws Exception{
    ArrayList<String> photoList = new ArrayList<>();
    for (MultipartFile file : files) {
      
      if (file.isEmpty())
        continue;
      String filename = getNewFilename();
      file.transferTo(new File(servletContext.getRealPath("/teacher/photo/" + filename)));
      photoList.add(filename);
      
    }
    
    return photoList;
  }
  
  int count =0 ;
  synchronized private String getNewFilename() {
    if (count > 100) {
      count = 0;
    }
    return String.format("%d_%d", System.currentTimeMillis(), ++count);
}
  
}
