package jxc.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;



import jxc.sys.entity.SysUser;

public interface SysUserDao {
	
	/**
	 * 查找用户表中所有用户信息
	 * @param username
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<SysUser> findObjects(@Param("username") String username);
	
	List<SysUser> FindPageObjectsByStoreId(@Param("storeId") Integer storeId);
	
     int getRowCounts(@Param("username")String username);
     
     int getRowCountsByStoreId(@Param("storeId")Integer storeId);
     
     int insertObject(SysUser sysUser);
     
     SysUser doFindObjectById(Integer userId);
     
     Integer findRoleIdByUserId(Integer userId);
     
     int  updateObject(SysUser sysUser);
     
     int doDeleteObjects(@Param("userId")Integer userId);
     
     SysUser findUserByUserName(@Param("username")String username);
}
