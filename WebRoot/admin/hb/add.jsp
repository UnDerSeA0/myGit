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
<SCRIPT language=JavaScript src="<%=basePath %>admin/images/calendar.js"></SCRIPT>
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
function checkhb()
{
	if(document.form1.splane.value==""||document.form1.stime.value==""||document.form1.etime.value==""
	||document.form1.price.value==""||document.form1.num.value==""
	||document.form1.cprice.value==""||document.form1.mprice.value==""||document.form1.dz.value=="")
	{
		alert("������Ŀ������д��");
		return false;
	}
	if(isNaN(document.form1.price.value)||isNaN(document.form1.cprice.value)
	||isNaN(document.form1.mprice.value)||isNaN(document.form1.dz.value)||isNaN(document.form1.num.value)){
		alert("����Ʊ�ۡ���ͯƱ�ۡ���ԱƱ�ۡ�����ֻ��Ϊ���֣�");
		return false;
	}
}
</script>
<%
	String username=(String)session.getAttribute("user");
	if(username==null){
		response.sendRedirect(path+"/error.jsp");
	}
	else{
	String method=request.getParameter("method");
	String id=request.getParameter("id");
	List list=new ArrayList();String type="";
	String splace="";String stime="";String etime="";String co="";String price="";String cprice="";
	String mprice="";String dz="";String sh="";String sm="";String eh="";String em="";String num="";
	if(method.equals("upHB")){
		list=hk.getHB(id);
		type=list.get(1).toString();splace =list.get(2).toString();stime=list.get(3).toString();
		sh=list.get(4).toString();sm=list.get(5).toString();
		etime=list.get(6).toString();eh=list.get(7).toString();em=list.get(8).toString();co=list.get(9).toString();price=list.get(10).toString();
		cprice=list.get(11).toString();mprice=list.get(12).toString();dz=list.get(13).toString();num=list.get(14).toString();
	}
%>
<BODY>
<form action="<%=basePath %>HkServlet" method=post name=form1 onsubmit="return checkhb()">
<table width='100%' cellspacing='1' cellpadding='3' bgcolor='#CCCCCC' class="tablewidth">
<tr>
<td width=40% align=right>�������ͣ�</td>
<td align=left><select name=type>
<%if(method.equals("upHB")){ %><option value=<%=type %>><%=type %></option><%} %>
<option value=���ں���>���ں���</option>
<option value=���ʺ���>���ʺ���</option>
</td>
</tr>
<tr>
<td width=40% align=right>���к��ߣ�<input type=hidden name=id value=<%=id %>><input type=hidden name=method value=<%=method %>></td>
<td align=left><input type=text size=30 name=splace value=<%=splace %>></td>
</tr>

<tr>
<td width=40% align=right>���ʱ�䣺</td>
<td align=left>
<INPUT class=inputb maxLength=24 size=10 name=stime value="<%=stime %>" readonly onclick="SelectDate(this,'yyyy-MM-dd')"  this.Txt_Date.Attributes["onclick"] = "SelectDate(this,'yyyy-MM-dd')";>  
<select name=sh>
<%if(method.equals("upHB")){ %><option value=<%=sh %>><%=sh %></option><%} %>
<%for(int i=1;i<25;i++){ %>
<option value=<%=i %>><%=i %></option>
<%} %>
</select> ʱ 
<select name=sm>
<%if(method.equals("upHB")){ %><option value=<%=sm %>><%=sm %></option><%} %>
<%for(int i=1;i<61;i++){ %>
<option value=<%=i %>><%=i %></option>
<%} %>
</select> ��
</td>
</tr>
<tr>
<td width=40% align=right>����ʱ�䣺</td>
<td align=left>
<INPUT class=inputb maxLength=24 size=10 name=etime value="<%=etime %>" readonly onclick="SelectDate(this,'yyyy-MM-dd')"  this.Txt_Date.Attributes["onclick"] = "SelectDate(this,'yyyy-MM-dd')";>  
<select name=eh>
<%if(method.equals("upHB")){ %><option value=<%=eh %>><%=eh %></option><%} %>
<%for(int i=1;i<25;i++){ %>
<option value=<%=i %>><%=i %></option>
<%} %>
</select> ʱ 
<select name=em>
<%if(method.equals("upHB")){ %><option value=<%=em %>><%=em %></option><%} %>
<%for(int i=1;i<61;i++){ %>
<option value=<%=i %>><%=i %></option>
<%} %>
</select> ��
</td>
</tr>
<tr>
<td width=40% align=right>���չ�˾��</td>
<td align=left><select name=co>
<%if(method.equals("upHB")){ %><option value=<%=co %>><%=co %></option><%} %>
<%List colist=hk.getCO(); if(!colist.isEmpty()){for(int i=0;i<colist.size();i++){List list2 =(ArrayList)colist.get(i);%>
<option value=<%=list2.get(1).toString() %>><%=list2.get(1).toString() %></option>
<%}} %>
</select></td>
</tr>
<tr>
<td width=40% align=right>����Ʊ�ۣ�</td>
<td align=left><input type=text size=15 name=price value=<%=price %>> Ԫ</td>
</tr>
<tr>
<td width=40% align=right>��ͯƱ�ۣ�</td>
<td align=left><input type=text size=15 name=cprice value=<%=cprice %>> Ԫ</td>
</tr>
<tr>
<td width=40% align=right>��Ա�۸�</td>
<td align=left><input type=text size=15 name=mprice value=<%=mprice %>> Ԫ</td>
</tr>
<tr>
<td width=40% align=right>�������ʣ�</td>
<td align=left><input type=text size=15 name=dz value=<%=dz %>> �粻��������д1</td>
</tr>
<tr>
<td width=40% align=right>Ʊ����</td>
<td align=left><input type=text size=15 name=num value=<%=num %>> </td>
</tr>
<tr>
<td align=center colspan=2><input type=submit value=�ύ></td>
</tr>
</table>
</form>

</BODY>
<%} %>
</HTML>
