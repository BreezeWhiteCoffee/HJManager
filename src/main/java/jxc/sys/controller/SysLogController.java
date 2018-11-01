package jxc.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import jxc.common.vo.JsonResult;
import jxc.sys.entity.SysLog;
import jxc.sys.service.SysLogService;


@RequestMapping("/log/")
@Controller
public class SysLogController {
    @Autowired
	private SysLogService sysLogService;
   
    @RequestMapping("doLogListUI")
    public String doLogListUI(){
    	//return "jsp/SysLog-AJAX";
    	//return "jsp/SysLog-Jquery-AJAX";
    	return "sys/log_list";
    }
    
    @RequestMapping("doFindPageSysLogs")
	public ModelAndView doFindPageSysLogs(
			          String username,
			          Integer pageCurrent){
    	//模拟耗时操作
    	try{Thread.sleep(5000);}catch(Exception e){}
    	PageInfo<SysLog> pageObject=
    	sysLogService.findPageObjects(
				username,
				pageCurrent);
    	ModelAndView mv=new ModelAndView();
    	mv.addObject("pageObject", pageObject);
    	mv.setViewName("jsp/SysLog");
	    return mv;
	}
    
    @RequestMapping("doDeleteObjects")
    @ResponseBody
    public JsonResult doDeleteObjects(
    		Integer... ids){
    	sysLogService.deleteObjects(ids);
    	return new JsonResult("delete ok");
    };

    @RequestMapping("doFindPageObjects")
    @ResponseBody
	public JsonResult doFindPageObjects(
			          String username,
			          Integer pageCurrent){
	    //模拟耗时操作
	    //try{Thread.sleep(5000);}catch(Exception e){}
    	PageInfo<SysLog> pageObject=
    	sysLogService.findPageObjects(
				username,
				pageCurrent);
	    return  new JsonResult(pageObject);
	}//底层会通过jackson将对象转换为json格式的字符串
    
}




