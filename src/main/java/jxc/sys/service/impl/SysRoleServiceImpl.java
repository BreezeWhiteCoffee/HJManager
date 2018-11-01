package jxc.sys.service.impl;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jxc.common.vo.CheckBox;
import jxc.sys.dao.SysRoleDao;
import jxc.sys.dao.SysUserRoleDao;
import jxc.sys.service.SysRoleService;

@Transactional(rollbackFor=RuntimeException.class)
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
	private SysRoleDao sysRoleDao;
  

	@Override
	@RequiresPermissions("sys:manager")
	public List<CheckBox> findObjects() {
		List<CheckBox> findObjects = sysRoleDao.findObjects();
		return findObjects;
	}


	@Override
	@RequiresPermissions("sys:manager")
	public String findPermissionsByRoleId(Integer roleId) {
		String permission = sysRoleDao.findPermissionsByRoleId(roleId);
		return permission;
	}
    
 
 

}









