package jxc.sys.service;
import java.util.List;

import com.github.pagehelper.PageInfo;

import jxc.common.vo.Node;


public interface SysStoreService {
	
	List<Node> findZTreeNodes();

	PageInfo findObjects(String storeName, Integer pageCurrent);

	PageInfo FindPageObjectsByStoreId(Integer storeId, Integer pageCurrent);

	
	
}
