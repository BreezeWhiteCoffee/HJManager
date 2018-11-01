package jxc.sys.controller;
/**
 * 页面跳转的控制器
 * @author Administrator
 *
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {
	//跳转首页的控制器
	@RequestMapping("doIndexUI")
	public String doIndexUI(){
		return "starter";//starter.html
	}
	//跳转page页的控制器
	@RequestMapping("doPageUI")
	public String doPageUI(){
		return "common/page";
	}
	@RequestMapping("doLoginUI")
	public String doLoginUI(){
	   return "login";
	}
}
