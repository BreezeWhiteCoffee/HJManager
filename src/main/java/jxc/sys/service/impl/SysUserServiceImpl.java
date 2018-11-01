package jxc.sys.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import jxc.common.exception.ServiceException;
import jxc.sys.dao.SysRoleDao;
import jxc.sys.dao.SysStoreDao;
import jxc.sys.dao.SysUserDao;
import jxc.sys.dao.SysUserRoleDao;
import jxc.sys.entity.Product;
import jxc.sys.entity.SysUser;
import jxc.sys.service.SysUserService;
import jxc.sys.vo.SysUserRoleResult;

@Service
@Transactional(rollbackFor=RuntimeException.class)
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;
	
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	
	@Autowired
	private SysStoreDao sysStoreDao;
	

	@Override
	public  PageInfo findObjects(String username, Integer pageCurrent) {
	     //1、对传入参数合法性进行检验
		if (pageCurrent==null||pageCurrent<1){
			throw new IllegalArgumentException("页码值不正确");
		} 
		//2.查询总记录数，并进行验证
		 int rowCounts = sysUserDao.getRowCounts(username);
		  if (rowCounts<=0){
		  throw new ServiceException("无此用户信息"); 
		     }
		//3.查询当前页的角色信息   
		  int pageSize=5;
		  PageHelper.startPage(pageCurrent, pageSize);
		  List<SysUser> list=
					sysUserDao.findObjects(username);
		      for (SysUser sysUser : list) {
				 System.out.println(sysUser);
			}
		  //4、封装用户信息
		  PageInfo<Product> pageInfo = new PageInfo(list);
		return pageInfo;
	}

	//保存新建用户信息
	@Override
	@RequiresPermissions("sys:manager")
	public int saveObject(SysUser sysUser, Integer roleId) {
		int count = sysUserDao.getRowCounts(sysUser.getUsername());
		     //1、参数合法性验证
				if(sysUser==null)
					throw new IllegalArgumentException("保存对象不能为空");
				if(StringUtils.isEmpty(sysUser.getUsername()))
					throw new IllegalArgumentException("用户名不能为空");
				if(StringUtils.isEmpty(sysUser.getPassword()))
					throw new IllegalArgumentException("密码不能为空");
				if(StringUtils.isEmpty(sysUser.getStoreId()))
					throw new IllegalArgumentException("门店id不能为空");
			        if (count>=1)
			        	throw new IllegalArgumentException("此用户名已被注册");	
			       
				//...
				//2.保存用户自身信息
				//2.1产生随机字符串作为一个盐值
				String salt=UUID.randomUUID().toString();
				sysUser.setSalt(salt);
				//2.2对密码进行加密(借助shiro中api)
				//DigestUtils.md5DigestAsHex(bytes)//spring中自带API
				SimpleHash sHash=new SimpleHash(//Shiro中API
						"md5",//algorithmName为加密算法
						sysUser.getPassword(), //source 密码
						salt);//salt 盐值
				sysUser.setPassword(sHash.toHex());
				//2.3持久化用户自身信息
				int rows=sysUserDao.insertObject(sysUser);
				//3.保存用户和角色的关系数据
				sysUserRoleDao.insertObjects(sysUser.getId(),
						roleId);
				//4.返回结果
				return rows;
	}

	@Override
	@RequiresPermissions("sys:manager")
	public SysUserRoleResult doFindObjectById(Integer userId) {
		//查找对应id的用户信息
		SysUser user = sysUserDao.doFindObjectById(userId);
		//查找对应id用户的角色信息
		int roleId = sysUserRoleDao.findRoleIdByUserId(userId); 
		//查找对应id用户所在门店的信息
		String storeInfo = sysStoreDao.doFindStoreInfoByStoreId(user.getStoreId());
		//封装所有用户信息
		SysUserRoleResult sysUserRoleResult =
				new SysUserRoleResult(user,roleId,storeInfo);
		
		return sysUserRoleResult;
	}

	 //更新指定用户信息
	@Override
	@RequiresPermissions("sys:manager")
	public int doUpdateObject(SysUser sysUser, Integer roleId) {
		  //1、参数合法性验证
		if(sysUser==null)
			throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(sysUser.getUsername()))
			throw new IllegalArgumentException("用户名不能为空");
		if(StringUtils.isEmpty(sysUser.getStoreId()))
			throw new IllegalArgumentException("门店id不能为空");

		int row = sysUserDao.updateObject(sysUser);
		int userId=sysUser.getId();
		int roleRow = sysUserRoleDao.updateUserRole(userId, roleId);
		return row;
	}

	@Override
	@RequiresPermissions("sys:manager")
	public int doDeleteObjects(Integer userId) {
		//1.参数合法性校验
    	if(userId==null||userId<1)
    	throw new IllegalArgumentException("id值无效");
		int row = sysUserDao.doDeleteObjects(userId);
		if (row<1){
			throw new ServiceException("此角色可能已经不存在");
		}
		sysUserRoleDao.doDeleteRoleByUserId(userId);
		return row;
	}

	@Override
	@RequiresPermissions("sys:manager")
	public PageInfo FindPageObjectsByStoreId(Integer storeId, Integer pageCurrent) {
		 //1、对传入参数合法性进行检验
		if (pageCurrent==null||pageCurrent<1){
			throw new IllegalArgumentException("页码值不正确");
		} 
		//2.查询总记录数，并进行验证
		 int rowCounts = sysUserDao.getRowCountsByStoreId(storeId);
		  if (rowCounts<=0){
		  throw new ServiceException("没有此门店的员工信息，请重新输入"); 
		     }
		//3.查询当前页的角色信息   
		  int pageSize=5;
		  PageHelper.startPage(pageCurrent, pageSize);
		  List<SysUser> list=
					sysUserDao.FindPageObjectsByStoreId(storeId);;
		  //4、封装用户信息
					 PageInfo<Product> pageInfo = new PageInfo(list);
		return pageInfo;
	}

	@Override
	public PageInfo findObjectsByStoreId(Integer storeId) {
		//2.查询总记录数，并进行验证
		 int rowCounts = sysUserDao.getRowCountsByStoreId(storeId);
		 System.out.println(storeId);
		  if (rowCounts<=0){
		  throw new ServiceException("无此门店员工信息"); 
		     }
		//3.查询当前页的角色信息   
		  List<SysUser> list=
					sysUserDao.FindPageObjectsByStoreId(storeId);
		  for (SysUser sysUser : list) {
			  System.out.println(sysUser);
		}
		  //4、封装用户信息
		  PageInfo<Product> pageInfo = new PageInfo(list);
		return pageInfo;
	}

	

	
	
	

}
