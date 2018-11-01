package jxc.sys.dao;

import org.apache.ibatis.annotations.Param;

import jxc.sys.entity.Order;

/**
 * 这个类是订单数据层接口
 * @author Administrator
 *
 */
public interface OrderDao {
	//新建订单的方法
	int doOrders(Order order);
	//根据id删除订单的方法
	int deleteById(@Param("id")Integer id);
	//根据id查询订单中成交数量的方法
	Order findAmountById(@Param("id")Integer id);
}
