package jxc.sys.service.impl;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import jxc.common.exception.ServiceException;
import jxc.common.vo.Node;
import jxc.sys.dao.SysStoreDao;
import jxc.sys.entity.Product;
import jxc.sys.entity.SysUser;
import jxc.sys.service.SysStoreService;



@Service
@Transactional(rollbackFor=RuntimeException.class)

public class SysStoreServiceImpl implements SysStoreService {
	@Autowired
	private SysStoreDao sysStoreDao;
	
	
	
	@Override
	@RequiresPermissions("sys:manager")
	public List<Node> findZTreeNodes() {
		List<Node> findZTreeNodes = sysStoreDao.findZTreeNodes();
		return findZTreeNodes;
	}



	@Override
	@RequiresPermissions("sys:manager")
	public PageInfo findObjects(String storeName, Integer pageCurrent) {
		  //1、对传入参数合法性进行检验
				if (pageCurrent==null||pageCurrent<1){
					throw new IllegalArgumentException("页码值不正确");
				} 
				//2.查询总记录数，并进行验证
				 int rowCounts = sysStoreDao.getRowCounts(storeName);
				  if (rowCounts<=0){
				  throw new ServiceException("无此用户信息"); 
				     }
				//3.查询当前页的角色信息   
				  int pageSize=5;
				  PageHelper.startPage(pageCurrent, pageSize);
				  List<Node> list=
						  sysStoreDao.findObjects(storeName);

				  //4、封装用户信息
				  PageInfo<Product> pageInfo = new PageInfo(list);
				return pageInfo;
		
	}



	@Override
	public PageInfo FindPageObjectsByStoreId(Integer storeId, Integer pageCurrent) {
		 //1、对传入参数合法性进行检验
		if (pageCurrent==null||pageCurrent<1){
			throw new IllegalArgumentException("页码值不正确");
		} 
		//2.查询总记录数，并进行验证
		   int rowCounts = sysStoreDao.getRowCountsByStoreId(storeId);
		  if (rowCounts<=0){
		  throw new ServiceException("没有此门店的员工信息，请重新输入"); 
		     }
		//3.查询当前页的角色信息   
		  int pageSize=5;
		  PageHelper.startPage(pageCurrent, pageSize);
		  List<SysUser> list=
				  sysStoreDao.FindPageObjectsByStoreId(storeId);
		  //4、封装用户信息
		  PageInfo<Product> pageInfo = new PageInfo(list);
		return pageInfo;
	}



	


	
}
	
	

	
