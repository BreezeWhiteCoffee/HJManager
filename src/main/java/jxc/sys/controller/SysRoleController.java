package jxc.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jxc.common.vo.JsonResult;
import jxc.sys.service.SysRoleService;
import jxc.sys.service.impl.SysRoleServiceImpl;

@Controller
@RequestMapping("/role/")
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService;

	//查找所有角色信息
	@RequestMapping("doFindRoles")
	@ResponseBody
	public JsonResult doFindObjects(){
	 return new JsonResult(sysRoleService.findObjects());
	}

	
}




