<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312"%>
<jsp:useBean id="hk" scope="page" class="com.bean.HkBean"></jsp:useBean>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String dir=sn.getDir();
%>
<HTML><HEAD>
<LINK href="<%=basePath %><%=dir%>/images/Admin_Style.css" type=text/css rel=stylesheet>
<LINK href="<%=basePath %><%=dir%>/images/style.css" type=text/css rel=stylesheet>
<STYLE type=text/css>
BODY {
	MARGIN-LEFT: 0px; BACKGROUND-COLOR: #ffffff
}
.STYLE1 {color: #ECE9D8}
</STYLE>
</HEAD>
<%
String message = (String)request.getAttribute("message");
	if(message == null){
		message = "";
	}
	if (!message.trim().equals("")){
		out.println("<script language='javascript'>");
		out.println("alert('"+message+"');");
		out.println("</script>");
	}
	request.removeAttribute("message");
%>
<%
	String username=(String)session.getAttribute("user");
	if(username==null){
		response.sendRedirect(path+"/error.jsp");
	}
	else{
%>
<BODY>
<table width='100%' cellspacing='1' cellpadding='3' bgcolor='#CCCCCC' class="tablewidth">
<TBODY>
     <tr class="head"> 
      <td width="5%" align="center">序号</td>
      <td  align="center">航空公司名称</td>
      <td  align="center">操作</td>
    </tr>
    <%
			List pagelist3=hk.getCO();
				if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);			
			%> 
	<tr  class="trA" onMouseOver="this.className='trB'" onMouseOut="this.className='trA'"> 
      <td width='5%' align="center" style="border-bottom:1px dotted #ccc;"><%=i+1 %></td>
      <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;"><%=pagelist2.get(1).toString() %></td>
      <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;">
          <a href="<%=basePath %>HkServlet?method=delCO&id=<%=pagelist2.get(0).toString()%>">删除</a>
          <a href="<%=path %>/admin/co/upCO.jsp?id=<%=pagelist2.get(0).toString()%>&name=<%=pagelist2.get(1).toString()%>">修改</a>
      </td>
    </tr>
	
<%
	}}
%>  

  </TBODY>
</TABLE>
<form action="<%=basePath %>HkServlet?method=addCO" method=post name=form1 onsubmit="return checkco()">
<table width='100%' cellspacing='1' cellpadding='3' bgcolor='#CCCCCC' class="tablewidth">
<tr><td align=center>航空公司名称：<input type=text size=30 name=name> <input type=submit value="提交"></td></tr>
</table>
</form>
<script type="text/javascript">
function checkco()
{
	if(document.form1.name.value=="")
	{
		alert("请输入航空公司名称！");
		return false;
	}
}
</script>
</BODY>
<%} %>
</HTML>
