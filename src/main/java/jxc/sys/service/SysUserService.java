package jxc.sys.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;

import jxc.sys.entity.SysUser;
import jxc.sys.vo.SysUserRoleResult;

public interface SysUserService {
	
	//删除指定id的用户信息
	int doDeleteObjects(Integer userId);
	
	//查找所有用户信息
	PageInfo findObjects(String username,Integer pageCurrent);
	 
	PageInfo FindPageObjectsByStoreId(Integer storeId,Integer pageCurrent);
			
	//保存新建用户信息		
	 int saveObject(SysUser sysUser,Integer roleId);
	 
	 //修改用户信息前 查找用户已有信息
	 SysUserRoleResult doFindObjectById(Integer userId);
	 
	 //修改指定用户信息
	 int doUpdateObject(SysUser sysUser,
			 			Integer roleId);


	PageInfo findObjectsByStoreId(Integer storeId);
}
