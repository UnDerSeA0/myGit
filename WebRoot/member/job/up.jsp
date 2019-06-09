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
<script type="text/javascript">
function ss()
{
	if(document.form1.price.value==""||document.form1.cprice.value==""||document.form1.mprice.value=="")
	{
		alert("请输入预定票数！");
		return false;
	}
	if(isNaN(document.form1.price.value)||isNaN(document.form1.cprice.value)||isNaN(document.form1.mprice.value))
	{
		alert("预定票数只能为数字！");
		return false;
	}
}
</script>
<%
	String member=(String)session.getAttribute("member");
	if(member==null){
		response.sendRedirect(path+"/error.jsp");
	}
	else{
	String id=request.getParameter("id");
	List ylist=hk.getYUDING(id);
	List list=hk.getHB(ylist.get(1).toString().trim());
%>
<BODY>
<form action="<%=basePath %>HkServlet?method=upYUDING" method=post name=form1 onsubmit="return ss()">
       <TABLE class=dragTable  cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY> 
        <TR>
          <TD class=head colspan="2">
			<SPAN class=TAG>机票预定</SPAN> 
			<SPAN class=more style="FLOAT: right"></SPAN> 
		  </TD>
		</TR>             
        <TR>
          <TD width=50% align=right>飞行航线</TD>
          <TD align=left><%=list.get(2).toString() %></TD>
        </TR>
         <TR>
          <TD width=50% align=right>起飞时间</TD>
          <TD align=left><%=list.get(3).toString().substring(0,10) %> <%=list.get(4).toString() %>:<%=list.get(5).toString() %></TD>
        </TR>
         <TR>
          <TD width=50% align=right>抵达时间</TD>
          <TD align=left><%=list.get(6).toString().substring(0,10) %> <%=list.get(7).toString() %>:<%=list.get(8).toString() %></TD>
        </TR>
         <TR>
          <TD width=50% align=right>成人机票<input type=hidden name=id value=<%=id %>></TD>
          <TD align=left><input type=text name=price size=10 value=<%=ylist.get(3) %>> 张</TD>
        </TR>
        <TR>
          <TD width=50% align=right>儿童机票</TD>
          <TD align=left><input type=text name=cprice size=10 value=<%=ylist.get(4) %>> 张</TD>
        </TR>
        <TR>
          <TD width=50% align=right>会员机票</TD>
          <TD align=left><input type=text name=mprice size=10 value=<%=ylist.get(5) %>> 张</TD>
        </TR>
        <TR>
          <TD colspan=2 align=center><input type=submit value="预定"></TD>
        </TR>
        </TBODY>
	  </TABLE>
</form>

</BODY>
<%} %>
</HTML>
