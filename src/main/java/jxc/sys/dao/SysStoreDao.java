package jxc.sys.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import jxc.common.vo.Node;
import jxc.sys.entity.SysUser;

public interface SysStoreDao {
	
	List<Node> findZTreeNodes();
	
	//根据门店id查找门店地址信息
	String doFindStoreInfoByStoreId(@Param("storeId")Integer storeId);
	
	//查找所有门店信息
	List<Node> findObjects(@Param("storeName")String storeName);

	int getRowCounts(@Param("storeName")String storeName);

	List<SysUser> FindPageObjectsByStoreId(@Param("storeId")Integer storeId);

	int getRowCountsByStoreId(@Param("storeId")Integer storeId);
}
