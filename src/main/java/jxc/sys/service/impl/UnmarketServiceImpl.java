package jxc.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jxc.sys.dao.UnmarketDao;
import jxc.sys.entity.UnmarketInfo;
import jxc.sys.service.UnmarketService;
@Service
public class UnmarketServiceImpl implements UnmarketService {
	@Autowired
	UnmarketDao unmarketDao;
	@Override
	public List<UnmarketInfo> findUnmarketObjects(String startTime, String endTime) {
		if(startTime==null||endTime==null)throw new RuntimeException("请输入查询时间！");
		List<UnmarketInfo> uo = unmarketDao.findUnmarketObjects(startTime, endTime);
		return uo;
	}

}
