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
<!--//屏蔽出错代码
function killErr(){
	return true;
}
window.onerror=killErr;
//-->
</SCRIPT>
<SCRIPT language=JavaScript>
<!--//处理大分类一行两个小分类
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
	List idlist=hk.getID();
	hk.outTime(idlist);
%>
<BODY text=#000000 bgColor=#ffffff leftMargin=0 topMargin=0>
<SCRIPT language=JavaScript>
<!--//目的是为了做风格方便
document.write('<div class="wrap">');
//-->
</SCRIPT>
<script type="text/javascript">
function ss()
{
	if(document.form1.stime.value==""||document.form1.etime.value=="")
	{
		alert("请选择起飞时间和抵达时间！");
		return false;
	}
}
</script>
<form action="<%=basePath %>sinfo.jsp" method=post name=form1 onsubmit="return ss()">
       <TABLE class=dragTable  cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY> 
        <TR>
          <TD class=head colspan="2">
			<SPAN class=TAG>航班信息查询</SPAN> 
			<SPAN class=more style="FLOAT: right"></SPAN> 
		  </TD>
		</TR>             
        <TR>
          <TD width=40% align=right>飞行航线</TD>
          <TD align=left><select name=splace>
          <%List hblist=hk.getALLSPLACE(); for(int i=0;i<hblist.size();i++){%>
          <option value="<%=hblist.get(i).toString() %>"><%=hblist.get(i).toString() %></option>
          <%} %> 
          </select></TD>
        </TR>
         <TR>
          <TD width=40% align=right>起飞时间</TD>
          <TD align=left><INPUT class=inputb maxLength=24 size=30 name=stime readonly onclick="SelectDate(this,'yyyy-MM-dd')"  this.Txt_Date.Attributes["onclick"] = "SelectDate(this,'yyyy-MM-dd')";>  
</TD>
        </TR>
         <TR>
          <TD width=40% align=right>抵达时间</TD>
          <TD align=left><INPUT class=inputb maxLength=24 size=30 name=etime readonly onclick="SelectDate(this,'yyyy-MM-dd')"  this.Txt_Date.Attributes["onclick"] = "SelectDate(this,'yyyy-MM-dd')";>  
</TD>
        </TR>
         <TR>
          <TD width=40% align=right>票价类别</TD>
          <TD align=left><select name=passtype>
          <option value=price>成人票价</option>
          <option value=cprice>儿童票价</option>
          <option value=mprice>会员票价</option>
          </select></TD>
        </TR>
        <TR>
          <TD colspan=2 align=center><input type=submit value="查询航班信息"></TD>
        </TR>
        </TBODY>
	  </TABLE>
</form>
<TABLE class=dragTable cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
  <TBODY>
  <TR>
    <TD>
	</TD>
   </TR>
  </TBODY>
</TABLE>

<SCRIPT language=JavaScript>
<!--//目的是为了做风格方便
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