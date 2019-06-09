<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <%
        String str=new String(request.getParameter("name").getBytes("iso8859_1"),"gb2312");
     %>
  </head>
  
  <body>
       <form action="<%=path%>/HkServlet?method=upCO" method="post">
           <table width='100%' cellspacing='1' cellpadding='3' bgcolor='#CCCCCC' class="tablewidth">
				<tr>
				    <td align=center>
				         航空公司名称：
				        <input type=text size=30 name=name value="<%=str %>"> 
				        <input type="hidden" name="id" value="<%=request.getParameter("id") %>">
				        <input type=submit value="提交">
				    </td>
				</tr>
		   </table>
       </form>
  </body>
</html>
