package jxc.sys.service;


import com.github.pagehelper.PageInfo;

import jxc.sys.entity.SysLog;

public interface SysLogService {
	
	 /**
	  * 执行删除操作
	  * @param ids 日志记录的id
	  * @return
	  */
	 int deleteObjects(Integer...ids);
	
     /**
      * 依据条件分页查询日志信息
      * @param username 用户名
      * @param pageCurrent 当前页码
      * @return 对查询结果的封装
      */
	 PageInfo<SysLog> findPageObjects(
			 String username,
			 Integer pageCurrent);
}





