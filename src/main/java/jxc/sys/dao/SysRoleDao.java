package jxc.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jxc.common.vo.CheckBox;



public interface SysRoleDao {

	   List<CheckBox> findObjects();
	  
	   String findPermissionsByRoleId(@Param("roleId")Integer roleId);
}





