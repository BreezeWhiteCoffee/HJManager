package jxc.sys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import jxc.sys.entity.Product;

public interface RepertoryService {
	PageInfo<List<Product>> findPageObjects(String  articlenumber,
			Integer pageCurrent);
	
	int deleteObjectById(Integer id);
	
	int UpdateObject(Product product);
	
	int insertObject(Product product);
	
	Product findObjectById(Integer id);
}
