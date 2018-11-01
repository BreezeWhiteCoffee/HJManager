package jxc.sys.service;

import java.util.List;
import java.util.Map;

import jxc.sys.entity.StrategInfo;

public interface StrategyService {
	//List<StrategInfo>findSalesByArticeNumber(String articleNumber ,String param);
	List<StrategInfo>findSalesObjects(String articleNumber);
	List<StrategInfo>findSalesObjectDatas();
}
