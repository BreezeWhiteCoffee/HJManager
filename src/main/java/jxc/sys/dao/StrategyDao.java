package jxc.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import jxc.sys.entity.StrategInfo;

public interface StrategyDao {
	// List<StrategInfo>findSalesByArticeNumber(@Param("articleNumber") String articleNumber);
	List<StrategInfo>findSalesObjects(@Param("articleNumber") String articleNumber);
	List<StrategInfo>findSalesObjectsDatas();
}
