package jxc.sys.service;
import java.util.List;

import jxc.common.vo.CheckBox;



public interface SysRoleService {
	
   List<CheckBox> findObjects();
      
    String findPermissionsByRoleId(Integer roleId);
    
}






