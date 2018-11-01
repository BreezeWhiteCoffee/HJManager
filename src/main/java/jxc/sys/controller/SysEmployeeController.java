package jxc.sys.controller;



import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import jxc.common.vo.JsonResult;
import jxc.sys.entity.SysUser;
import jxc.sys.service.SysEmployeeService;
import jxc.sys.service.SysUserService;
@RequestMapping("/employee/")
@Controller
public class SysEmployeeController {
	@Autowired
	private SysEmployeeService sysEmployeeService;
	
	@RequestMapping("doEmployeeListUI")
	public String doUserListUI(){
		return "sys/employee_list";
	}
	
		//查找所有用户信息并返回
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String employeename,
				               Integer pageCurrent){
		PageInfo findObjects = 
			sysEmployeeService.findObjects(employeename, pageCurrent);
		return  new JsonResult(findObjects);
		}
	
	@RequestMapping("doFindPageObjectsByStoreId")
	@ResponseBody
	public JsonResult doFindPageObjectsByStoreId(Integer storeId,
				               Integer pageCurrent){
		PageInfo findObjects = 
				sysEmployeeService.FindPageObjectsByStoreId(storeId, pageCurrent);
		return  new JsonResult(findObjects);
		}
	
	
	
}
