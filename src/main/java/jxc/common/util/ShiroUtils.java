package jxc.common.util;

import org.apache.shiro.SecurityUtils;

import jxc.sys.entity.SysUser;



public class ShiroUtils {

	 public static SysUser getPrincipal(){
		 return (SysUser)SecurityUtils
		.getSubject().getPrincipal();
	 }
}
