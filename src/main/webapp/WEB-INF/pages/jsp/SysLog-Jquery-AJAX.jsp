<%@ page language="java" 
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>System Log List Page</h1>
   <h2>time:<%=new java.util.Date()%></h2>
   <div>
   <table border="1" width="100%" cellpadding="2" cellspacing="0">
       <thead>
          <tr>
           <th>id</th>
           <th>username</th>
           <th>method</th>
          </tr>
       </thead>
       <tbody id="tbodyId">
          <tr><td colspan="3">数据加载中...</td></tr>
       </tbody>
   </table>
   </div>
   <script type="text/javascript" 
           src="../bower_components/jquery/dist/jquery.min.js"></script>
   <script type="text/javascript">
        //页面加载完成执行此方法
        $(function(){
        	console.log("page load complete");
        	doGetObjects();
        });
        //页面加载完成以后异步加载日志信息
        function doGetObjects(){
           //1.定义请求参数
           var params="pageCurrent=1";//{"pageCurrent":1}
           //2.定义请求url
           var url="doFindPageObjects.do";
           //3.发起异步请求
           $.ajax({//默认GET请求(底层构建XmlHttpRequest对象)
        	  data:params,
        	  url:url,
        	  success:function(result){//JsonResult
        		//ajax函数底层将服务端返回的json串转换为了json格式的js对象
        		console.log(result);
        		doHandleResponseResult(result); 
        	  }
           });//此函数由jquery提供(是对ajax请求的封装)
        }
        //处理响应结果
        function doHandleResponseResult(result){
        	if(result.state==1){//state是我们自己在JsonResult中定义
        	  doSetTableBodyRows(result.data.records);
        	}else{
        	  alert(result.message);
        	}
        }
        //将当前记录追加到tbody位置
        function doSetTableBodyRows(records){
        	//1.获取tbody对象，清空对象内容
        	var tBody=$("#tbodyId");
        	tBody.empty();//清空内容
        	//2.将记录追加到tbody中
        	//for(var i=0;i<records.length;i++){}
        	for(var i in records){
        	 //2.1创建tr对象(Jquery中的方式)
        	 var tr=$("<tr></tr>");
        	 //2.2创建tds对象
        	 var tds=doCreateTds(records[i]);
        	 //2.3将td追加到tr对象
        	 tr.append(tds);
        	 //2.4将tr追加到tbody对象
        	 tBody.append(tr);
        	}
        }
        function doCreateTds(row){
        	var tds=
        	"<td>"+row.id+"</td>"+
        	"<td>"+row.username+"</td>"+
        	"<td>"+row.method+"</td>";
        	return tds;
        }
   </script>
</body>
</html>





