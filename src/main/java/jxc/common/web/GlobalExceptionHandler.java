package jxc.common.web;
import java.util.logging.Logger;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import jxc.common.vo.JsonResult;


/**全局异常处理类*/
@ControllerAdvice
public class GlobalExceptionHandler {
	//JDK中的自带的日志API
	private Logger log=Logger.getLogger(GlobalExceptionHandler.class.getName());
	
	@ExceptionHandler(ShiroException.class)
    @ResponseBody
	public JsonResult doHandleShiroException(
			ShiroException e){
		JsonResult result= new JsonResult();
		result.setState(0);
		if(e instanceof IncorrectCredentialsException){
			result.setMessage("密码不正确");
		}else if(e instanceof UnknownAccountException){
			result.setMessage("此账户不存在");
		}else if(e instanceof LockedAccountException){
			result.setMessage("账户被禁用了");
		}else if(e instanceof AuthorizationException){
			result.setMessage("没有此权限");
		}else{
			e.printStackTrace();
		}
		return result;
	}
	
	@ExceptionHandler(RuntimeException.class)
    @ResponseBody
	public JsonResult doHandleRuntimeException(
			RuntimeException e){
    	e.printStackTrace();//也可以写日志
		log.info(e.getMessage());
		return new JsonResult(e);//封装异常信息
	}
}


