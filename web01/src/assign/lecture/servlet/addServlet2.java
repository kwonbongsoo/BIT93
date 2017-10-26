/* 회원 관리 만들기 : 회원  조회하기
 * => MemberDao를 이용하여 클라이언트로 부터 받은 번호에 해당하는 회원 정보 찾아
 *      HTML 만들어 출력한다.
 */
package assign.lecture.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import assign.classroom.ClassRoom;
import assign.classroom.ClassRoomDao;
import assign.manager.Manager;
import assign.manager.ManagerDao;
import step03.DBConnectionPool;

@WebServlet(urlPatterns="/assign/lecture/addServlet1")
public class addServlet2 extends GenericServlet{
  private static final long serialVersionUID = 1L;

  public addServlet2() {
   System.out.println("Servlet02()");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    try {
      ManagerDao mdao = (ManagerDao)this.getServletContext().getAttribute("managerDao");
      ArrayList<Manager>mlist = (ArrayList<Manager>) mdao.selectList();
      ClassRoomDao cdao =(ClassRoomDao)this.getServletContext().getAttribute("classroomDao");
      ArrayList<ClassRoom> clist = (ArrayList<ClassRoom>)cdao.selectList();
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css'>");
      out.println("<link rel='stylesheet' href='//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css' />");
      out.println("<link rel='stylesheet' href='//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css' />");

      out.println("<script src='//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js'></script>");

      out.println("  <meta charset='UTF-8'>");
      out.println("  <title>HTML</title>");
      out.println("<style type='text/css'>");
      out.println(" .dateContainer  {");
      out.println(" top: 0;");
      out.println(" right: -15px;");
      out.println(" }");
      out.println("</style>");

      out.println("</head>");
      out.println("<div class='container'>");
      out.println("<h1>강의 정보</h1>");
      out.println("<form action='Servlet03' method='POST' class='form-horizontal' id='eventForm'>");
      out.println(" <div class='form-group'>");
      out.println("   <label for='exampleInputEmail1'>강의명</label>");
      out.println("   <div>");
      out.println("    <input type='email' class='form-control' id='exampleInputEmail1' name='titl' placeholder='강의명'>");
      out.println("  </div>");
      out.println(" </div>");
      out.println(" <div>");
      out.println(" <label>설명</label>");
      out.println(" <div>");
      out.println("   <textarea class='form-control' name='dscp'");
      out.println("     placeholder='강의에 대한 상세 설명'");
      out.println("         rows='4'></textarea>");
      out.println("   </div>");
      out.println("  </div>");
      out.println(" <div class='form-group'>");
      out.println(" <label class='col-xs-3 control-label'>Start date</label>");
      out.println(" <div class='col-xs-5 dateContainer'>");
      out.println("    <div class='input-group input-append date' id='startDatePicker'>");
      out.println("       <input type='text' class='form-control' name='startDate' />");
      out.println("        <span class='input-group-addon add-on'><span class='glyphicon glyphicon-calendar'></span></span>");
      out.println("    </div>");
      out.println("  </div>");
      out.println(" </div>");

      out.println(" <div class='form-group'>");
      out.println(" <label class='col-xs-3 control-label'>End date</label>");
      out.println("  <div class='col-xs-5 dateContainer'>");
      out.println("    <div class='input-group input-append date' id='endDatePicker'>");
      out.println("       <input type='text' class='form-control' name='endDate' />");
      out.println("       <span class='input-group-addon add-on'><span class='glyphicon glyphicon-calendar'></span></span>");
      out.println("    </div>");
      out.println(" </div>");
      out.println("  </div>");
      out.println("  <div >");
      out.println("   <label >수강인원</label>");
      out.println("   <div>");
      out.println("     <input type='number' id='fi-qty' name='qty' placeholder='최대 수강 인원'>");
      out.println("   </div>");
      out.println(" </div>");
      out.println(" <div >");
      out.println("   <label >강의시간</label>");
      out.println("   <div >");
      out.println("     <input type='number' id='fi-thrs' name='thrs' placeholder='총 강의 시간'>");
      out.println("   </div>");
      out.println("  </div>");
      out.println("  <div >");
      out.println("    <label >수업료</label>");
      out.println("    <div >");
      out.println("     <input type='number' id='fi-pric' name='pric' placeholder='수업료'>");
      out.println("   </div>");
      out.println(" </div>");
      out.println(" <div >");
      out.println("   <label >강의실</label>");
      out.println("   <div >");
      out.println("     <select id='fi-crmno'>");
      out.println("       <option value='0'>강의실을 선택하세요!</option>");
      for ( ClassRoom c : clist) {
        if (c.getName().equals(req.getParameter("name"))) {
          out.print("<option value='"+c.getName()+"' selected>");
        }else {
          out.print("<option value='"+c.getName()+"'>");
        }
        out.print(c.getName()+"</option>");
      }
      out.println("     </select>");
      out.println("   </div>");
      out.println(" </div>");
      out.println("  <div >");
      out.println("   <label >매니저</label>");
      out.println("   <div >");
      out.println("     <select  id='fi-mrno'>");
      out.println("       <option value='0'>매니저를 선택하세요!</option>");
      for ( Manager m : mlist) {
        if (m.getName().equals(req.getParameter("name"))) {
          out.print("<option value='"+m.getName()+"' selected>");
        }else {
          out.print("<option value='"+m.getName()+"'>");
        }
        out.print(m.getName()+"</option>");
      }
      out.println("    </select>");
      out.println("   </div>");
      out.println(" </div>");
      out.println("   <div >");
      out.println("   <div >");
      out.println("          <button>등록</button>");
      out.println("  </div>");
      out.println("  </div>");
      out.println("</form>");
      out.println(" </div>");
      out.println(" </form>");
      
      out.println("<script src=' http://code.jquery.com/jquery-latest.min.js'></script>");
      out.println("<script src='//code.jquery.com/jquery.min.js'></script>");
      out.println("<script src='//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js'></script>");
      
      out.println("<script>");
      out.println("$(document).ready(function() {");
      out.println("    $('#startDatePicker')");
      out.println("        .datepicker({");
      out.println("            format: 'mm/dd/yyyy'");
      out.println("        })");
      out.println("      .on('changeDate', function(e) {");
                  // Revalidate the start date field
      out.println("           $('#eventForm').formValidation('revalidateField', 'startDate');");
      out.println("       });");

      out.println("    $('#endDatePicker')");
      out.println("      .datepicker({");
      out.println("          format: 'mm/dd/yyyy'");
      out.println("       })");
      out.println("       .on('changeDate', function(e) {");
      out.println("            $('#eventForm').formValidation('revalidateField', 'endDate');");
      out.println("        });");

      out.println("   $('#eventForm')");
      out.println("         .formValidation({");
      out.println("            framework: 'bootstrap',");
      out.println("           icon: {");
      out.println("                valid: 'glyphicon glyphicon-ok',");
      out.println("                invalid: 'glyphicon glyphicon-remove',");
      out.println("               validating: 'glyphicon glyphicon-refresh'");
      out.println("            },");
      out.println("           fields: {");
      out.println("               name: {");
      out.println("                   validators: {");
      out.println("                       notEmpty: {");
      out.println("                           message: 'The name is required'");
      out.println("                       }");
      out.println("                   }");
      out.println("               },");
      out.println("               startDate: {");
      out.println("                   validators: {");
      out.println("                      notEmpty: {");
      out.println("                           message: 'The start date is required'");
      out.println("                       },");
      out.println("                  date: {");
      out.println("                            format: 'MM/DD/YYYY',");
      out.println("                            max: 'endDate',");
      out.println("                            message: 'The start date is not a valid'");
      out.println("                        }");
      out.println("                    }");
      out.println("               },");
      out.println("                endDate: {");
      out.println("                    validators: {");
      out.println("                        notEmpty: {");
      out.println("                           message: 'The end date is required'");
      out.println("                        },");
      out.println("                       date: {");
      out.println("                            format: 'MM/DD/YYYY',");
      out.println("                             min: 'startDate',");
      out.println("                            message: 'The end date is not a valid'");
      out.println("                        }");
      out.println("                    }");
      out.println("                }");
      out.println("            }");
      out.println("        })");
      out.println("        .on('success.field.fv', function(e, data) {");
      out.println("           if (data.field === 'startDate' && !data.fv.isValidField('endDate')) {");
                      // We need to revalidate the end date
      out.println("               data.fv.revalidateField('endDate');");
      out.println("            }");

      out.println("           if (data.field === 'endDate' && !data.fv.isValidField('startDate')) {");
                      // We need to revalidate the start date
      out.println("               data.fv.revalidateField('startDate');");
      out.println("           }");
      out.println("        });");
      out.println("});");
      out.println(" </script>");
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    

  }
}
