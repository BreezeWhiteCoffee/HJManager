package jxc.sys.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;


import jxc.sys.entity.SysUser;
import jxc.sys.vo.SysUserRoleResult;

public interface SysEmployeeService {
	
	
	//查找所有用户信息
	PageInfo findObjects(String employeename,Integer pageCurrent);
	 
	PageInfo FindPageObjectsByStoreId(Integer storeId,Integer pageCurrent);
			
	
}
