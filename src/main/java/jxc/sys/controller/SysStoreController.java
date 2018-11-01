package jxc.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import jxc.common.vo.JsonResult;
import jxc.common.vo.Node;
import jxc.sys.service.SysStoreService;



@Controller
@RequestMapping("/store/")
public class SysStoreController {
	
	@Autowired
	private SysStoreService sysStoreService;
	
	//查找所有门店地址信息及门店id
	@RequestMapping("doFindZTreeNodes")
	@ResponseBody
	public JsonResult doFindZTreeNodes(){
		List<Node> findZTreeNodes = sysStoreService.findZTreeNodes();
		return new JsonResult(findZTreeNodes);
	}
	
	    //载入门店管理页面
		@RequestMapping("doStoreListUI")
		public String doStoreListUI(){
			
			return "sys/store_list";
		}
		
		  //查找所有门店地址信息及门店id
		@RequestMapping("doFindPageObjects")
		@ResponseBody
		public JsonResult doFindPageObjects(String storeName,
					               Integer pageCurrent){
			PageInfo findObjects = 
				sysStoreService.findObjects(storeName, pageCurrent);
			return  new JsonResult(findObjects);
			}
		
		//查找id查询门店信息
		@RequestMapping("doFindPageObjectsByStoreId")
		@ResponseBody
		public JsonResult doFindPageObjectsByStoreId(Integer storeId,
					               Integer pageCurrent){
			PageInfo findObjects = 
					sysStoreService.FindPageObjectsByStoreId(storeId, pageCurrent);
			return  new JsonResult(findObjects);
			}
		

}
