package jxc.sys.dao;
/**
 * 库存管理接口
 */
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import jxc.sys.entity.Product;

public interface ProductDao {
	//分页查询
	List<Product> findAll(@Param("articlenumber")String articlenumber);
	//删除信息
	int deleteObjectById(@Param("id") Integer id);
	//修改信息
	int UpdateObject(Product Product);
	//根据ID查询信息
	Product findObjectById(@Param("id") Integer id);
	//增加记录
	int insertObject(Product Product);
	//下订单修改库存
	int doOrder(@Param("articlenumber")String articlenumber,
			    @Param("amount")Integer amount);
}
