package jxc.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jxc.common.vo.JsonResult;
import jxc.sys.entity.UnmarketInfo;
import jxc.sys.service.UnmarketService;

@Controller
@RequestMapping("/unmarket/")
public class UnmarketController {
	@Autowired
	UnmarketService unmarketService;
	
	@RequestMapping("doUnmarketListUI")
	public String doStrategyListUI(){
		return "sys/unmarket_list";	
	}
	
	@RequestMapping("doFindUnmarketObjects")
	@ResponseBody
	public JsonResult doFindUnmarketObjects(String startTime, String endTime) {
		List<UnmarketInfo> uo = unmarketService.findUnmarketObjects(startTime, endTime);
		JsonResult result =new JsonResult();
		result.setData(uo);
		System.out.println(uo);
		System.out.println(11111);
		return result;
	}
}
