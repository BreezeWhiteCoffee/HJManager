# HJmanage项目简介
华京进销存管理系统是基于服装行业分门店管理业务的一个脚手架系统。使用SSM和shrio框架，尝试了模态框、Apache POI、highcharts、pagehelper、AOP切面编程等技术，并应用了AdminLTE前端框架
# 应用技术简介
权限管理
1、记住密码功能 下次同一用户登录时，密码框文本自动输入  
 底层实现思想：前端判断记住密码复选框是否选中，是则在cookie中记录，下次文本框同一用户名时，输出 cookie信息，记住密码框未选中则删除cookie内用户名相关信息；
核心代码：
//如果框选记住密码  则保存在cookie信息中
	  if ($(".checkbox input[type='checkbox']").prop("checked")){
		  console.log("记住密码");
		 setCookie(username,password,7);  //保存帐号到cookie，有效期7天
	  }else{
		  delCookie(username);//如果不勾选记住选项   删除cookie信息
	  }
2、页面上根据用户登录信息 动态展示用户的用户名和用户角色信息、门店信息、用户创建时间，并根据角色id隐藏权限不够的功能模块
底层实现思想：在登录时利用cookie存储用户名，跳转页面后取出cookie中用户名，应调用后端方法找到用户名对应的门店信息和角色信息、创建时间，并在html标签内写入内容。
核心代码：
//取出已经登录的用户名
    	var token=("loginUserName");
    	if (document.cookie.match(token)!==null){
       	 var cookie=document.cookie;
       	   console.log(cookie);
           var loginUserName=decodeURI(cookie.match(token+"=([^;]+)")[1]);
             console.log(loginUserName);
            $(".loginUserName").html("").html(loginUserName);
            
          //根据已经登录的用户名 获取相应的角色名和创建时间和门店信息
            var url="user/doFindPageObjects.do";
      	   var pageCurrent=1;
      	   var params={"pageCurrent":pageCurrent}
      	     params.username=loginUserName;
      	     console.log(params);
      	   $.post(url,params,function(result){
      		   console.log(result);  
          var role= ((result.data.list[0]).sysRole.name);
          var roleId=((result.data.list[0]).sysRole.roleId);
     	 var createTime= new Date((result.data.list[0]).createTime).toLocaleString();
         var storeId=(result.data.list[0]).storeId;
            if (roleId==1){
            	$("#load-strategy-id").css("display","none");
            	$("#load-unmarked-id").css("display","none");
            	$("#load-stock-id").css("display","none");
            	$("#load-log-id").css("display","none");
            	$("#load-store-id").css("display","none");	
            	$("#load-user-id").css("display","none");	
            }
 3、用户信息模块中当前用户只能修改、添加、删除同一门店内的店员信息
底层实现思想：利用aop对用户信息的业务层实现类进行环绕，当用户想调用修改信息命令时，aop内可以对用户门店ID（通过shiro框架获取登录的用户名找到门店ID）和方法内请求参数的门店ID进行比较，如果不一致则抛出异常不允许修改
核心代码：
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
PageHelper
使用PageHelper对查询到的数据进行封装，从而实现分页功能
Apache POI
利用POI中的HSSFWorkbook类和HSSFSheet类创建excel文件，并创建工具类实现数据的导入,使用FileOutputStream保存到服务器，使用response.getOutputStream下载到用户电脑
highcharts
纯javascript编写的图表库，可便捷生成18种类型图表，并可综合显示
# 剩下的技术自己研究吧，希望能帮到大家

