package jxc.sys.service.impl;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import jxc.common.exception.ServiceException;
import jxc.sys.dao.SysEmployeeDao;
import jxc.sys.entity.Product;
import jxc.sys.entity.SysEmployee;
import jxc.sys.service.SysEmployeeService;


@Service
@Transactional(rollbackFor=RuntimeException.class)
public class SysEmployeeServiceImpl implements SysEmployeeService {

	@Autowired
	private SysEmployeeDao sysEmployeeDao;



	@Override

	public  PageInfo findObjects(String employeename, Integer pageCurrent) {
		//1、对传入参数合法性进行检验
		if (pageCurrent==null||pageCurrent<1){
			throw new IllegalArgumentException("页码值不正确");
		} 
		//2.查询总记录数，并进行验证
		int rowCounts = sysEmployeeDao.getRowCounts(employeename);
		if (rowCounts<=0){
			throw new ServiceException("无此用户信息"); 
		}
		//3.查询当前页的角色信息   
		int pageSize=5;
		PageHelper.startPage(pageCurrent, pageSize);
		List<SysEmployee> list=
				sysEmployeeDao.findObjects(employeename);
		for (SysEmployee sysEmployee : list) {
			
			System.out.println(sysEmployee);
		}
		//4、封装用户信息
		
		PageInfo<Product> pageInfo = new PageInfo(list);
		if(pageInfo.getTotal()==0)throw new ServiceException("没有查找到数据");
		return pageInfo;
	}


	@Override
	
	public PageInfo FindPageObjectsByStoreId(Integer storeId, Integer pageCurrent) {
		//1、对传入参数合法性进行检验
		if (pageCurrent==null||pageCurrent<1){
			throw new IllegalArgumentException("页码值不正确");
		} 
		//2.查询总记录数，并进行验证
		int rowCounts = sysEmployeeDao.getRowCountsByStoreId(storeId);
		if (rowCounts<=0){
			throw new ServiceException("没有此门店的员工信息，请重新输入"); 
		}
		//3.查询当前页的角色信息   
		int pageSize=5;
		PageHelper.startPage(pageCurrent, pageSize);
		List<SysEmployee> list=
				sysEmployeeDao.FindPageObjectsByStoreId(storeId);
		//4、封装用户信息
		PageInfo<Product> pageInfo = new PageInfo(list);
		if(pageInfo.getTotal()==0)throw new ServiceException("没有查找到数据");
		return pageInfo;
	}



}
