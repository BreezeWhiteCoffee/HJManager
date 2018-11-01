package jxc.sys.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jxc.common.util.ExcelUtil;
import jxc.sys.entity.StrategInfo;
import jxc.sys.service.StrategyService;
@RequestMapping("/excel/")
@Controller

public class ExcelController {
	@Autowired
	StrategyService strategyService;


	@RequestMapping("saleInfoExport")
	@ResponseBody
	public String doSaleInfoExport(){

		
		//1获取数据
		List<Map<String, String>> result = new ArrayList<>();
		List<StrategInfo> res = strategyService.findSalesObjectDatas();
		int i =1;
		for (StrategInfo info : res) {
			Map<String, String> rmap =new LinkedHashMap<>();
			rmap.put("序号",""+i);
			if(info.getArticleNumber()==null){
				rmap.put("货号","无数据");
			}else{
				rmap.put("货号",info.getArticleNumber());
			}
			if(info.getNum()==null){
				rmap.put("销量","无数据");
			}else{
				rmap.put("销量",info.getNum().toString());
			}
			if(info.getBuyPrice()==null){
				rmap.put("进货价","无数据");
			}else{
				rmap.put("进货价",info.getBuyPrice().toString());
			}
			if(info.getSalePrice()==null){
				rmap.put("定价","无数据");
			}else{
				rmap.put("定价",info.getSalePrice().toString());
			}
			if(info.getSaleMoney()==null){
				rmap.put("销售额","无数据");
			}else{
				rmap.put("销售额",info.getSaleMoney().toString());
			}
			if(info.getProfit()==null){
				rmap.put("利润","无数据");
			}else{
				rmap.put("利润",info.getProfit().toString());
			}
			i++;
			result.add(rmap);
			
		}
		Date d = new Date();
		DateFormat fm1 = new SimpleDateFormat("yyyyMMddHHmmss");
		String time1 = fm1.format(d);
		DateFormat fm2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time2 = fm2.format(d);
		//设置excel表属性
		
		
		String fileName = "销售信息表("+time1+").xls";       // 定义文件名
		String headString = "销售信息表(创建时间"+time2+")";         // 定义表格标题
		String sheetName = "工作表一";           // 定义工作表表名
		String filePath = "F:\\test\\";        // 文件本地保存路径
		String[] thead = {"序号","货号", "销量","进货价","定价", "销售额","利润"};// 定义表头内容
		int[] sheetWidth = {2500,3500,3000,4000,2500,5000,5000}; // 定义每一列宽度

		HSSFWorkbook wb = new HSSFWorkbook();           // 创建Excel文档对象
		HSSFSheet sheet = wb.createSheet(sheetName);    // 创建工作表
	
		// 创建表格标题
		ExcelUtil.createHeadTittle(wb, sheet, headString, result.get(0).size() - 1);
		
		// （result.get(0).size() - 1）为表格占用列数，从0开始
		//创建表头
		ExcelUtil.createThead(wb, sheet, thead, sheetWidth);
		// ③填入数据
		ExcelUtil.createTable(wb, sheet, result);
		
		try {
			FileOutputStream fos = new FileOutputStream(new File(filePath+fileName));
			// filePath,fileName是如上定义的文件保存路径及文件名
			wb.write(fos);
			
			fos.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//wb.close();


         return "Export Success!";
            
}
}
