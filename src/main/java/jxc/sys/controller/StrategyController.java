package jxc.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jxc.common.vo.JsonResult;
import jxc.sys.entity.Product;
import jxc.sys.entity.StrategInfo;
import jxc.sys.service.StrategyService;

@Controller
@RequestMapping("/strategy/")
public class StrategyController {
	@Autowired
	StrategyService strategyService;
	
	@RequestMapping("doStrategyListUI")
	public String doStrategyListUI(){
		return "sys/strategy_list";	
	}
	
	
	@RequestMapping("doFindSalesObjects")
	@ResponseBody
	public JsonResult doFindSalesObjects(String articleNumber){
		List<StrategInfo> so = strategyService.findSalesObjects(articleNumber);
		JsonResult result = new JsonResult();
		result.setData(so);
		return result ;
		
	}
}
