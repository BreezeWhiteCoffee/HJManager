package jxc.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jxc.sys.entity.UnmarketInfo;

public interface UnmarketDao {
	List<UnmarketInfo>findUnmarketObjects(@Param("startTime")String startTime,@Param("endTime")String endTime);
}
