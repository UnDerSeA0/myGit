<%@ page language="java" import="java.util.*" contentType="text/html;charset=gb2312" %>
<%@ include file="iframe/head.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<LINK href="images/default.css" type=text/css rel=stylesheet>
<LINK href="images/css.css" type=text/css rel=stylesheet>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<STYLE type=text/css>
.ycbt {
	BORDER-RIGHT: #fff 1px solid; BORDER-TOP: #fff 1px solid; PADDING-LEFT: 1.8em; BACKGROUND-COLOR: #EAF2EF; BORDER-LEFT: #fff 1px solid; PADDING-TOP: 7px; BORDER-BOTTOM: #fff 1px solid; HEIGHT: 20px
}
.xsbt {
	BORDER-RIGHT: #fff 1px solid; BORDER-TOP: #fff 1px solid; PADDING-LEFT: 1.8em; BACKGROUND-IMAGE: url(images/head1.gif); BORDER-LEFT: #fff 1px solid; PADDING-TOP: 7px; BORDER-BOTTOM: #fff 1px solid; HEIGHT: 20px
}
.xsnr {
	DISPLAY: block
}
.ycnr {
	DISPLAY: none
}
</STYLE>
<SCRIPT type=text/javascript>
function tb_xs(t,m,n){
for(var i=1;i<=m;i++){
if (i != n){
document.getElementById("tb"+t+ "_bt" + i).className= "ycbt";
document.getElementById("tb"+t+ "_nr" + i).className= "ycnr";}
else{
document.getElementById("tb"+t+ "_bt" + i).className= "xsbt";
document.getElementById("tb"+t+ "_nr" + i).className= "xsnr";}}}
</SCRIPT>
<SCRIPT language=JavaScript>
<!--//���γ������
function killErr(){
	return true;
}
window.onerror=killErr;
//-->
</SCRIPT>
<SCRIPT language=JavaScript>
<!--//��������һ������С����
function autoTable(div){
	fs=document.getElementById(div).getElementsByTagName("TABLE");
	for(var i=0;i<fs.length;i++){
		fs[i].style.width='49.5%';
		if(i%2==1){
			if (document.all) {
				fs[i].style.styleFloat="right";
			}else{
				fs[i].style.cssFloat="right;";
			}
		}else{
			if (document.all) {
				fs[i].style.styleFloat="left";
			}else{
				fs[i].style.cssFloat="left;";
			}
		}
	}
}
//-->
</SCRIPT>
<SCRIPT language=JavaScript src="images/inc.js"></SCRIPT>
<SCRIPT language=JavaScript src="images/default.js"></SCRIPT>
<SCRIPT language=JavaScript src="images/swfobject.js"></SCRIPT>
<META content="MSHTML 6.00.2900.3268" name=GENERATOR>
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
	String member=(String)session.getAttribute("member");
	if(member==null){
	response.sendRedirect("login.jsp");
	}else{
	String id=request.getParameter("id");
	List list=hk.getHB(id);
%>
<BODY text=#000000 bgColor=#ffffff leftMargin=0 topMargin=0>
<SCRIPT language=JavaScript>
<!--//Ŀ����Ϊ������񷽱�
document.write('<div class="wrap">');
//-->
</SCRIPT>
<script type="text/javascript">
function ss()
{
	if(document.form1.price.value==""||document.form1.cprice.value==""||document.form1.mprice.value=="")
	{
		alert("������Ԥ��Ʊ����");
		return false;
	}
	if(isNaN(document.form1.price.value)||isNaN(document.form1.cprice.value)||isNaN(document.form1.mprice.value))
	{
		alert("Ԥ��Ʊ��ֻ��Ϊ���֣�");
		return false;
	}
}
</script>
<form action="<%=basePath %>HkServlet?method=YUDING" method=post name=form1 onsubmit="return ss()">
       <TABLE class=dragTable  cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY> 
        <TR>
          <TD class=head colspan="2">
			<SPAN class=TAG>��ƱԤ��</SPAN> 
			<SPAN class=more style="FLOAT: right"></SPAN> 
		  </TD>
		</TR>             
        <TR>
          <TD width=50% align=right>���к���</TD>
          <TD align=left><%=list.get(2).toString() %></TD>
        </TR>
         <TR>
          <TD width=50% align=right>���ʱ��</TD>
          <TD align=left><%=list.get(3).toString().substring(0,10) %> <%=list.get(4).toString() %>:<%=list.get(5).toString() %></TD>
        </TR>
         <TR>
          <TD width=50% align=right>�ִ�ʱ��</TD>
          <TD align=left><%=list.get(6).toString().substring(0,10) %> <%=list.get(7).toString() %>:<%=list.get(8).toString() %></TD>
        </TR>
         <TR>
          <TD width=50% align=right>���˻�Ʊ<input type=hidden name=id value=<%=id %>></TD>
          <TD align=left><input type=text name=price size=10> ��</TD>
        </TR>
        <TR>
          <TD width=50% align=right>��ͯ��Ʊ</TD>
          <TD align=left><input type=text name=cprice size=10> ��</TD>
        </TR>
        <TR>
          <TD width=50% align=right>��Ա��Ʊ</TD>
          <TD align=left><input type=text name=mprice size=10> ��</TD>
        </TR>
        <TR>
          <TD colspan=2 align=center><input type=submit value="Ԥ��"></TD>
        </TR>
        </TBODY>
	  </TABLE>
</form>
<TABLE class=dragTable cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
  <TBODY>
  <TR>
    <TD>
      <img src="images/ad2.jpg" width="948" height="90" border="0">
	</TD>
   </TR>
  </TBODY>
</TABLE>
<%} %>
<SCRIPT language=JavaScript>
<!--//Ŀ����Ϊ������񷽱�
document.write('</div>');
//-->
</SCRIPT>
<SCRIPT language=JavaScript>
<!--
clickEdit.init();
//-->
</SCRIPT>
</BODY>
</HTML>

<%@ include file="iframe/foot.jsp"%>