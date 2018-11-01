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
   <script type="text/javascript">
      //页面加载完成执行匿名函数
      window.onload=function(){
    	  doGetObjects();
    	  //console.log("hello ajax");
      }//dom事件
      
      function doGetObjects(){
       //1.创建ajax请求对象(是实现ajax应用的一个入口对象)
       var xhr=new XMLHttpRequest();
       console.log(xhr);
       //2.设置ajax对象的状态监听(响应是否结束)
       xhr.onreadystatechange=function(){
    	   //基于请求响应状态处理结果
    	   //4表示服务端响应结束
    	   //200表示服务端响应OK(正确)
    	   if(xhr.readyState==4&&xhr.status==200){
    		   //responseText为服务端响应的文本
    		  //console.log(xhr.responseText);//string
    		  doHandleResponseResult(xhr.responseText);
    	   }
       }
       //3.发送请求
        //doSendGetRequest(xhr);
        doSendPostRequest(xhr);
      }
      //发送GET请求
      function doSendGetRequest(xhr){
    	  //3.1.建立与服务端的连接
          var url="doFindPageObjects.do?pageCurrent=1"
          xhr.open("GET",url,true);//true表示异步(底层会启动工作线程)
          //3.2.发送请求
          xhr.send(null);//get请求此位置不传数据
      }
      //发送POST请求
      function doSendPostRequest(xhr){
    	  //3.1.建立与服务端的连接
          var url="doFindPageObjects.do"
          xhr.open("POST",url,true);//true表示异步(底层会启动工作线程)
          xhr.setRequestHeader("Content-Type",
          "application/x-www-form-urlencoded");
          //3.2.发送请求
          xhr.send("pageCurrent=1");//post请求此位置传数据
      }
      //处理响应结果
      function doHandleResponseResult(resultStr){
    	  //1.将json格式的字符串转换json格式的JavaScript object
    	  var result=JSON.parse(resultStr);//JsonResult
    	  //console.log(result);
    	  //2.处理数据
    	  if(result.state==1){
    		//将记录显示到tbody中(result.data-->PageObject)
    		doSetTableBodyRows(result.data.records);//List<SysLog>
    	  }else{
    		alert(result.message);  
    	  }
      }
      //在tbody中显示记录信息
      function doSetTableBodyRows(records){
    	  //1.获取tbody对象，并清空内容
    	  var tBody=document.getElementById("tbodyId");
    	  tBody.innerHTML="";
    	  //2.将records数据追加tbody中
    	  for(var i=0;i<records.length;i++){//一条记录一个tr对象
    		  //1.构建tr对象
    		  var tr=document.createElement("tr");
    		  //2.构建多个td对象,并追加到tr中
    		  doCreateTds(tr,records[i]);
    		  //3.将tr追加到tbody中
    		  tBody.appendChild(tr);
    	  }
      }
      //创建当前的td对象
      function doCreateTds(tr,row){
    	  var td=document.createElement("td");
		  td.innerText=row.id;
		  tr.appendChild(td);
		  
		  td=document.createElement("td");
		  td.innerText=row.username;
		  tr.appendChild(td);
		  
		  td=document.createElement("td");
		  td.innerText=row.method;
		  tr.appendChild(td);
      }
   </script>
</body>
</html>





