package jxc.sys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import jxc.sys.entity.Product;

/**
 * 销售管理系统的业务接口
 * @author Administrator
 *
 */
public interface ProductService {
	//查询所有商品信息或者根据货号查商品
	PageInfo<List<Product>> findAll(String articlenumber,Integer pageCurrent);
	//下订单
	int doOrder(String articlenumber,Integer amount,Double saleprice,String employeename,Integer amountorder);
	//退货
	int doReturn(Integer id);
}
