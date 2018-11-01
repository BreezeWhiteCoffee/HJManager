package jxc.sys.dao;


import org.apache.ibatis.annotations.Param;

/**
 * 此DAO负责操作用户和角色的关系表。
 * 思考：
 * 1)用户和角色是什么关系？多对多关系(many2many)
 * 2)多对多的关系在表设计时如何实现？(中间表)
 */

public interface SysUserRoleDao {

	int doDeleteRoleByUserId(@Param("userId")Integer userId);
	
	int insertObjects(
			@Param("userId")Integer userId,
			@Param("roleId")Integer roleId);
	
	int findRoleIdByUserId(
			@Param("userId")Integer userId);
	
	int updateUserRole(
			@Param("userId")Integer userId,
			@Param("roleId")Integer roleId);
}
