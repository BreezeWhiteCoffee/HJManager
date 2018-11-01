package jxc.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import jxc.common.vo.JsonResult;
import jxc.sys.entity.Product;
import jxc.sys.service.RepertoryService;

@RequestMapping("/stock/")
@Controller
public class RepertoryController {
	@Autowired
	RepertoryService repertoryService;
	
	//删除记录
	@RequestMapping("doDeleteObjectById")
	@ResponseBody
	public String doDeleteObjectById(Integer id){
		int rows = repertoryService.deleteObjectById(id);
		return "Delete Success";
		
	}
		
		
		
	//修改记录
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public String doUpdateObject(Product product){
		
		int rows = repertoryService.UpdateObject(product);
		
		return "Update Success";
		
	}
	
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id){
		System.out.println(id);
		Product  product= repertoryService.findObjectById(id);
		return new JsonResult(product) ;
		
	}
	//添加记录
	@RequestMapping("doInsertObjects")
	@ResponseBody
	public String doInsertObject(Product product){
		repertoryService.insertObject(product);
		return "Add Success";
		
	}
	
	@RequestMapping("doStockListUI")
	public String doStockListUI(){
	   
	    return "sys/stock_list";
	}
	//分页查找
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult dofindPageObjects(String  articlenumber,Integer pageCurrent){
		PageInfo<List<Product>> pageInfo = repertoryService.findPageObjects(articlenumber,pageCurrent);
		return new JsonResult(pageInfo);	
	}
}
