<%@ page language="java" import="java.util.*" contentType="text/html;charset=gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String dir=sn.getDir();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>系统管理</TITLE>
<META http-equiv=Content-Language content=zh-cn>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="<%=basePath %><%=dir %>/images/Admin_Style.css" rel=stylesheet>
<META content="MSHTML 6.00.2900.3243" name=GENERATOR>
</HEAD>
<SCRIPT language="JavaScript" type="text/JavaScript">
<!--
var array = new Array();//数字顺延
array[0]=1;array[1]=2;array[2]=3;array[3]=4;array[4]=5;array[5]=6;array[6]=7;
function expand(id_value){
  var tmp;
  eval("tmp=document.getElementById('id_"+id_value+"').style.display");
  if(tmp==''){
    eval("document.getElementById('id_"+id_value+"').style.display='none'");
  }else{
   for(i=0;i<array.length;i++){
      eval("document.getElementById('id_"+array[i]+"').style.display='none'");
  }
    eval("document.getElementById('id_"+id_value+"').style.display=''");
  }  
 }
//-->
</SCRIPT>
<%
	String username=(String)session.getAttribute("user");
	if(username==null){
		response.sendRedirect(path+"/error.jsp");
	}
	else{
	List list=(List)session.getAttribute("list");
	String QX=list.get(4).toString();
	String temp[]=QX.split("/");
%>
<BODY  oncontextmenu="return false;" onselectstart="return false;" leftMargin=0 background=<%=basePath %><%=dir %>/images/MainBg.gif topMargin=0 scroll=no marginheight="0" marginwidth="0">

<DIV style="OVERFLOW: auto; WIDTH: 100%; HEIGHT: 96%" align=center>
<TABLE  bgColor=#eef8fe cellSpacing=0 cellPadding=0 width="90%" align=center border=0>
  <TBODY> 
  <TR ParentID="SystemLastArticle" AllParentID="SystemLastArticle">
    <TD height=40 background="<%=basePath %><%=dir %>/images/linkbg1.gif" >&nbsp;<IMG src="<%=basePath %><%=dir %>/images/menu.gif" align=absMiddle><a href="<%=basePath %><%=dir %>/system/user.jsp" target="MainFrame">管理员管理</a>
    </TD>
  </TR>
  <TR ParentID="SystemLastArticle" AllParentID="SystemLastArticle">
    <TD height=40 background="<%=basePath %><%=dir %>/images/linkbg1.gif" >&nbsp;<IMG src="<%=basePath %><%=dir %>/images/menu.gif" align=absMiddle><a href="<%=basePath %><%=dir %>/hb/index.jsp" target="MainFrame">航班信息管理</a>
    </TD>
  </TR>
  <TR ParentID="SystemLastArticle" AllParentID="SystemLastArticle">
    <TD height=40 background="<%=basePath %><%=dir %>/images/linkbg1.gif" >&nbsp;<IMG src="<%=basePath %><%=dir %>/images/menu.gif" align=absMiddle><a href="<%=basePath %><%=dir %>/hb/add.jsp?method=addHB" target="MainFrame">增加航班信息</a>
    </TD>
  </TR>
  <TR ParentID="SystemLastArticle" AllParentID="SystemLastArticle">
    <TD height=40 background="<%=basePath %><%=dir %>/images/linkbg1.gif" >&nbsp;<IMG src="<%=basePath %><%=dir %>/images/menu.gif" align=absMiddle><a href="<%=basePath %><%=dir %>/dd/wei.jsp" target="MainFrame">未处理订单</a>
    </TD>
  </TR>
  <TR ParentID="SystemLastArticle" AllParentID="SystemLastArticle">
    <TD height=40 background="<%=basePath %><%=dir %>/images/linkbg1.gif" >&nbsp;<IMG src="<%=basePath %><%=dir %>/images/menu.gif" align=absMiddle><a href="<%=basePath %><%=dir %>/dd/over.jsp" target="MainFrame">已处理订单</a>
    </TD>
  </TR>
  <TR ParentID="SystemLastArticle" AllParentID="SystemLastArticle">
    <TD height=40 background="<%=basePath %><%=dir %>/images/linkbg1.gif" >&nbsp;<IMG src="<%=basePath %><%=dir %>/images/menu.gif" align=absMiddle><a href="<%=basePath %><%=dir %>/member/person.jsp" target="MainFrame">注册用户管理</a>
    </TD>
  </TR>
  <TR ParentID="SystemLastArticle" AllParentID="SystemLastArticle">
    <TD height=40 background="<%=basePath %><%=dir %>/images/linkbg1.gif" >&nbsp;<IMG src="<%=basePath %><%=dir %>/images/menu.gif" align=absMiddle><a href="<%=basePath %><%=dir %>/co/index.jsp" target="MainFrame">航空公司管理</a>
    </TD>
  </TR>
  </TBODY>
</TABLE>
</DIV>
</BODY>
<%} %>
</HTML>
