package jxc.sys.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jxc.sys.entity.UnmarketInfo;

public interface UnmarketService {
	List<UnmarketInfo>findUnmarketObjects(String startTime, String endTime);
}
