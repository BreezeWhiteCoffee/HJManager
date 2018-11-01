package jxc.common.aspect;

import java.util.HashMap;

import org.apache.catalina.tribes.util.Arrays;
import org.apache.ibatis.cache.decorators.SynchronizedCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jxc.common.util.IPUtils;
import jxc.common.util.ShiroUtils;
import jxc.sys.dao.SysLogDao;
import jxc.sys.dao.SysUserDao;
import jxc.sys.entity.SysLog;
import jxc.sys.entity.SysUser;
/**
 * 日志横切面对象
 * 用来写入日志数据库以及检测删除对象是否有相应权限
 * @Aspect  用于描述此类为一个切面对象
 * @author Administrator
 *
 */
@Aspect
@Service
public class SysLogAspect {
	@Autowired
	private SysLogDao sysLogDao;
	
	@Autowired
	private SysUserDao sysUserDao;
               /**
                * @Around 描述的方法为一个环绕通知
                * 1）环绕通知：目标方法执行之前和执行之后都可以执行
                * 环绕通知内部的bean表达式为一个切入点表达式
                * @pjp  表示一个连接点对象（封装了一个业务方法信息）
                * @return
             * @throws Throwable 
                */
	       @Around("bean(sysUserServiceImpl)")
           public Object aroundMethod (ProceedingJoinPoint joinPoint) throws Throwable {
	         	//执行目标方法(result为目标方法执行的结果)
	    	 long startTime = System.currentTimeMillis();
	    	   synchronized (joinPoint) {
	    		   //检测删除或修改对象的管理者是否有相应的权限
	    		   checkDeletePermission(joinPoint);
	    	   }
	    		  
	    	   Object result = joinPoint.proceed();
	    	 long endTime = System.currentTimeMillis();
	    	 //将日志信息存储到数据库
	    	 saveObject(joinPoint,(endTime-startTime));
	              return result;
	       }
         	 
	       //检测删除或修改对象的管理者是否有相应的权限
	       private void checkDeletePermission(ProceedingJoinPoint joinPoint) {
				Class<? extends Object> serviceClass = joinPoint.getTarget().getClass();//获取环绕通知对应的类
				String methodName = joinPoint.getSignature().getName();//获取调用的方法名
				System.out.println(methodName);
				if (methodName.equals("doDeleteObjects")){
			      System.out.println("in----->deleteObjects");
			      HashMap<String, Integer> map = doFindUserStoreId(joinPoint);
			        int storeId=map.get("storeId");  
			        int logStoreId = map.get("logStoreId");
			        int userId = map.get("userId");
			        int logId = map.get("logId");
			       //检查是否是在一个门店
			        if(!(storeId==logStoreId))
			         throw new IllegalArgumentException("抱歉!您不能删除不属于您门店的雇员信息!"); 
			             
			       //不能删除自己店长的信息
			        if (userId==logId)
			         throw new IllegalArgumentException("抱歉!您不能删除您自己的信息!");    
				   }
				if(methodName.equals("doFindObjectById")){
					 HashMap<String, Integer> map = doFindUserStoreId(joinPoint);
				        int storeId=map.get("storeId");  
				        int logStoreId = map.get("logStoreId");
					 //检查是否是在一个门店否则不能修改信息
				     if(!(storeId==logStoreId))
				      throw new IllegalArgumentException("抱歉!您不能修改或添加不属于您门店的雇员信息!");  
				}
				
				   //不能添加不属于自己门店的员工信息
				if(methodName.equals("saveObject")){
					Object[] args = joinPoint.getArgs();
					SysUser sysUser = (SysUser)args[0];
				        int storeId=sysUser.getStoreId();  
				        
				  String logUserName = ShiroUtils.getPrincipal().getUsername();//登录者的身份信息
				 SysUser logUser = sysUserDao.findUserByUserName(logUserName);
				 Integer logStoreId = logUser.getStoreId();
					 //检查是否是在一个门店否则不能修改信息
				   if(!(storeId==logStoreId))
				  throw new IllegalArgumentException("抱歉!您不能添加不属于您门店的雇员信息!");  
				}
			}
         	 
	       
	   	private HashMap<String, Integer> doFindUserStoreId(ProceedingJoinPoint joinPoint) {
			   Object[] params = joinPoint.getArgs();//获取方法内的参数（要删除的用户userId）
			   HashMap<String,Integer> map = new HashMap<>();
			   //获取被删除的用户门店id
			  
			   Integer userId=(Integer)(params[0]);
			   SysUser user = sysUserDao.doFindObjectById(userId);
			   Integer storeId = user.getStoreId();
				 
			   //获取登录者的门店id
			   String logUserName = ShiroUtils.getPrincipal().getUsername();//登录者的身份信息
			   SysUser logUser = sysUserDao.findUserByUserName(logUserName);
			   Integer logStoreId = logUser.getStoreId();
			   Integer logId = logUser.getId();
          
			 
			   map.put("userId",userId);
			   map.put("storeId",storeId);
			   
			   map.put("logId", logId);
			   map.put("logStoreId", logStoreId);
			   return map;
		}
         
         
          
	    //将日志信息存储到数据库
	   	private void saveObject(ProceedingJoinPoint joinPoint,long totalTime) {
	    //获取日志信息
	   	Class<? extends Object> serviceClass = joinPoint.getTarget().getClass();//获取环绕通知对应的类
	   	String methodName = joinPoint.getSignature().getName();//获取方法名
	   	Object[] params = joinPoint.getArgs();
	 
	      //封装日志信息
          SysLog log = new SysLog();		
          log.setIp(IPUtils.getIpAddr());
        
          log.setMethod(methodName);
          log.setParams(Arrays.toString(params));
          log.setTime(totalTime);
          log.setUsername(ShiroUtils.getPrincipal().getUsername());
          //保存日志信息
         sysLogDao.insertObject(log);
		}
 	   
    
}//基于ocp原则   不修改原有代码情况下   进行扩展 （例如日志处理）

         	
			   
			  

			

		