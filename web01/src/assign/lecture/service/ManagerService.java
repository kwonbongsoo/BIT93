package assign.lecture.service;



import java.util.List;

import assign.lecture.domain.Teacher;
import assign.manager.Manager;
import assign.manager.ManagerDao;



public class ManagerService {
  ManagerDao managerDao;
  
  
  
  public void setManagerDao(ManagerDao managerDao) {
    this.managerDao = managerDao;
  }

  public List<Manager> list() throws Exception{
    return managerDao.selectList();
  }
}
