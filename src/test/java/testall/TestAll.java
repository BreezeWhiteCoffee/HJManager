package testall;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageInfo;

import jxc.sys.dao.OrderDao;
import jxc.sys.dao.ProductDao;
import jxc.sys.entity.Order;
import jxc.sys.entity.Product;
import jxc.sys.service.ProductService;
import jxc.sys.service.impl.ProductServiceImpl;

public class TestAll {
	@Test
	public void Testaaa(){
		ClassPathXmlApplicationContext cpac = new ClassPathXmlApplicationContext("spring-configs.xml");
		OrderDao bean = cpac.getBean("orderDao",OrderDao.class);
		Order findAmountById = bean.findAmountById(11);
		System.out.println(findAmountById);
	}
}
