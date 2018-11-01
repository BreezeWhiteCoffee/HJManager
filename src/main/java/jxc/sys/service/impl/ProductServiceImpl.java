package jxc.sys.service.impl;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import jxc.common.exception.ServiceException;
import jxc.sys.dao.OrderDao;
import jxc.sys.dao.ProductDao;
import jxc.sys.dao.SysUserDao;
import jxc.sys.entity.Order;
import jxc.sys.entity.Product;
import jxc.sys.entity.SysUser;
import jxc.sys.service.ProductService;
@Service


public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private OrderDao   orderDao;
	@Autowired
	private SysUserDao sysUserDao;
	@Override
	
	public PageInfo findAll(String articlenumber, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1)throw new IllegalArgumentException("页码号错误");
		int pageSize=2;
		PageHelper.startPage(pageCurrent, pageSize);		
		List<Product> list = productDao.findAll(articlenumber);
		PageInfo<Product> pageInfo = new PageInfo<>(list);
		if(pageInfo.getTotal()==0)throw new ServiceException("没有查找到数据");
		return pageInfo;
	}
	@Override
	
	public int doOrder(String articlenumber, Integer amount, Double saleprice, String employeename,
			Integer amountorder) {
		if(amount==null||amount<1)throw new IllegalArgumentException("库存数量不能为空或小于1");
		if(saleprice==null)throw new ServiceException("价格不能为空");
		int row = productDao.doOrder(articlenumber, amount);
		if(row==0)throw new ServiceException("货品不存在");
		double money=saleprice*amountorder;
		SysUser user = sysUserDao.findUserByUserName(employeename);
		Order order = new Order();
		order.setAmount(amountorder);
		order.setArticlenumber(articlenumber);
		order.setEmployeename(employeename);
		order.setMoney(money);
		order.setStoreId(user.getStoreId());
		orderDao.doOrders(order);	
		return row;
	}
	@Override
	
	public int doReturn(Integer id) {
		if(id==null||id<1)throw new IllegalArgumentException("订单号格式不对");
		Order order = orderDao.findAmountById(id);
		Integer orderAmount=order.getAmount();
		String  orderArticlenumber=order.getArticlenumber();
        int row = orderDao.deleteById(id);
		if(row==0)throw new ServiceException("订单不存在");
		List<Product> product = productDao.findAll(orderArticlenumber);
		Integer amount=product.get(0).getAmount()+orderAmount;
		productDao.doOrder(orderArticlenumber, amount);
		return row;
	}

	
}
