package jxc.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jxc.sys.dao.StrategyDao;

import jxc.sys.entity.StrategInfo;
import jxc.sys.service.StrategyService;
@Service
public class StrategyServiceImpl implements StrategyService {
	@Autowired
	StrategyDao strategyDao;
	//根据货号查询到销售数据

	@Override
	public List<StrategInfo> findSalesObjects(String articleNumber) {
		if(articleNumber==null)throw new RuntimeException("请输入用户名");
		List<StrategInfo> so = strategyDao.findSalesObjects(articleNumber);
		
		
		return so;
	}

	@Override
	public List<StrategInfo>findSalesObjectDatas() {
		List<StrategInfo> sod = strategyDao.findSalesObjectsDatas();
		
		return sod;
	}

	

}
