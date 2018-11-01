package jxc.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import jxc.common.exception.ServiceException;
import jxc.sys.dao.ProductDao;
import jxc.sys.entity.Product;
import jxc.sys.service.RepertoryService;
@Service
public class RepertoryServiceImpl implements RepertoryService {

	@Autowired
	ProductDao productDao;
	@Override
	public PageInfo findPageObjects(String  articlenumber,
			Integer pageCurrent) {
		System.out.println(articlenumber);
		//1.参数有效性验证(只验证pageCurrent)
		if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("页码值不正确");
		//2.查询总记录数并进行验证
		//3.查询当前页日志数据
		int pageSize=5;
		PageHelper.startPage(pageCurrent, pageSize);
		List<Product> list = productDao.findAll(articlenumber);
		for (Product product : list) {
			System.out.println(product);
		}
		//4.对查询结果进行封装
		PageInfo<Product> pageInfo = new PageInfo(list);
		if(pageInfo.getTotal()==0)throw new ServiceException("没有查找到数据");
		return pageInfo;
	}
	
	//添加记录
	@Override
	public int insertObject(Product product) {
		Integer rows = productDao.insertObject(product);
		
		if(rows==null||rows<1){
			throw new RuntimeException("添加失败");
		}
		return rows;
	}
	//通过ID查找
	@Override
	public Product findObjectById(Integer id) {
		
		return productDao.findObjectById(id);
	}
	//修改记录
	@Override
	public int UpdateObject(Product product) {
		int rows = productDao.UpdateObject(product);
		return rows;
	}
	//删除记录
	@Override
	public int deleteObjectById(Integer id) {
		int rows = productDao.deleteObjectById(id);
		return rows;
	}

}
