package jxc.sys.controller;
/**
 * 这是销售管理模块的控制器
 * @author Administrator
 *
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import jxc.common.vo.JsonResult;
import jxc.sys.entity.Product;
import jxc.sys.service.ProductService;
import jxc.sys.service.impl.ProductServiceImpl;

@Controller
@RequestMapping("/product/")
public class ProductController {
	@Autowired
	private ProductService productService;
	//跳转产品清单的方法
	@RequestMapping("doProductListUI")
	public String doUserListUI(){
		return "sys/product_list";
	}
	//查找所有商品信息或者根据货号查商品的方法
	@RequestMapping("doFindAll")
	@ResponseBody
	public JsonResult doFindAll(String articlenumber,Integer pageCurrent){
		PageInfo<List<Product>> pageInfo = productService.findAll(articlenumber, pageCurrent);
		return new JsonResult(pageInfo);
	}
	//跳转下单页面的方法
	@RequestMapping("doProductEditUI")
	public String doMenuEditUI(){
		return "sys/product_edit";
	}
	//跳转退货页面的方法
	@RequestMapping("doProductEditUI1")
	public String doMenuEditUI1(){
		return "sys/product_edit1";
	}
	@RequestMapping("doOrder")
	@ResponseBody
	public JsonResult doOrder(String articlenumber,Integer amount,Double saleprice,String employeename,Integer amountorder){
		int row = productService.doOrder(articlenumber, amount, saleprice, employeename,amountorder);
		return new JsonResult("下单成功");
	}
	@RequestMapping("doReturn")
	@ResponseBody
	public JsonResult doReturn(Integer id){
		int row = productService.doReturn(id);
		return new JsonResult("退货成功");
	}
}
