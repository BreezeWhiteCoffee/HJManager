package jxc.sys.controller;



import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import jxc.common.vo.JsonResult;
import jxc.sys.entity.SysUser;
import jxc.sys.service.SysUserService;
@RequestMapping("/user/")
@Controller
public class SysUserController {
	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("doUserListUI")
	public String doUserListUI(){
		return "sys/user_list";
	}
	
	@RequestMapping("doUserEditUI")
	public String doUserEditUI(){
		return "sys/user_edit";
	}
		//查找所有用户信息并返回
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String username,
				               Integer pageCurrent){
		PageInfo findObjects = 
			sysUserService.findObjects(username, pageCurrent);
		return  new JsonResult(findObjects);
		}
	
	//查找所有用户信息并返回
	@RequestMapping("doFindObjectsByStoreId")
	@ResponseBody
	public JsonResult doFindObjectsByStoreId(Integer storeId){
		PageInfo findObjects = 
			sysUserService.findObjectsByStoreId(storeId);
		return  new JsonResult(findObjects);
		}
	
	@RequestMapping("doFindPageObjectsByStoreId")
	@ResponseBody
	public JsonResult doFindPageObjectsByStoreId(Integer storeId,
				               Integer pageCurrent){
		PageInfo findObjects = 
			sysUserService.FindPageObjectsByStoreId(storeId, pageCurrent);
		return  new JsonResult(findObjects);
		}
	//保存新建用户信息
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysUser sysUser,
				               Integer roleId){
		sysUserService.saveObject(sysUser,roleId);
		return new JsonResult("save ok");
		}
	
	//查找指定用户信息
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer userId){
				      
	return new JsonResult(sysUserService.doFindObjectById(userId));
	}
		
	//修改指定用户信息
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysUser sysUser,
										Integer roleId){
		sysUserService.doUpdateObject(sysUser, roleId);    
	return new JsonResult("update ok");
	}
	
	//删除指定用户信息
	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer userId){
		sysUserService.doDeleteObjects(userId);
	return new JsonResult("delete ok");
	}
	
	//登录信息验证
	@RequestMapping("doLogin")
	@ResponseBody
	public JsonResult doLogin(String username,String password){
		//1.封装用户身份和凭证
		UsernamePasswordToken token=
		new UsernamePasswordToken(username,password);
	    //2.执行登录认证操作
		Subject subject=
	    SecurityUtils.getSubject();
		subject.login(token);//认证失败此位置会抛出异常
		//如上信息提交给谁?SecurityManager
		//SecurityManager调用认证管理器完成认证操作
		return new JsonResult("login ok");
	}
}
