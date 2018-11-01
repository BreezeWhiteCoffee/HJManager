package jxc.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jxc.sys.entity.SysEmployee;
import jxc.sys.entity.SysUser;

public interface SysEmployeeDao {
	
	/**
	 * 查找用户表中所有用户信息
	 * @param employeename
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<SysEmployee> findObjects(@Param("employeename") String employeename);
	
	List<SysEmployee> FindPageObjectsByStoreId(@Param("storeId") Integer storeId);
	
     int getRowCounts(@Param("employeename")String employeename);
     
     int getRowCountsByStoreId(@Param("storeId")Integer storeId);
     
    
}
