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
	String member=(String)session.getAttribute("member");
	if(member==null){
		response.sendRedirect(path+"/error.jsp");
	}
	else{
%>
<BODY>
<table width='100%' cellspacing='1' cellpadding='3' bgcolor='#CCCCCC' class="tablewidth">
<TBODY>
     <tr class="head"> 
      <td width="5%" align="center">���</td>
      <td  align="center">����</td>
      <td  align="center">����</td>
      <td  align="center">���ʱ��</td>
      <td  align="center">����ʱ��</td>
      <td  align="center">���չ�˾</td>
      <td  align="center">����Ʊ��</td>
      <td  align="center">����Ʊ</td>
      <td  align="center">��ͯƱ��</td>
      <td  align="center">��ͯƱ</td>
      <td  align="center">��Ա�۸�</td>
      <td  align="center">��ԱƱ</td>
      <td  align="center">����</td>
      <td  align="center">�ܽ��</td>
      <td  align="center">״̬</td>
      <td  align="center">Ԥ��ʱ��</td>
      <td  align="center">ɾ��</td>
    </tr>
    <%
			List pagelist3=hk.getALLYUDING(member);
				if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);			
			%> 
	<tr  class="trA" onMouseOver="this.className='trB'" onMouseOut="this.className='trA'"> 
      <td width='5%' align="center" style="border-bottom:1px dotted #ccc;"><%=i+1 %></td>
      <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;"><%=pagelist2.get(1).toString() %></td>
      <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;"><%=pagelist2.get(2).toString() %></td>
      <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;"><%=pagelist2.get(3).toString().substring(0,10)+" "+pagelist2.get(4).toString()+":"+pagelist2.get(5).toString() %></td>
      <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;"><%=pagelist2.get(6).toString().substring(0,10)+" "+pagelist2.get(7).toString()+":"+pagelist2.get(8).toString() %></td>
      <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;"><%=pagelist2.get(9).toString() %></td>
      <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;"><%=pagelist2.get(10).toString() %></td>
      <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;"><%=pagelist2.get(18).toString() %></td>
      <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;"><%=pagelist2.get(11).toString() %></td>
      <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;"><%=pagelist2.get(19).toString() %></td>
      <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;"><%=pagelist2.get(12).toString() %></td>
      <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;"><%=pagelist2.get(20).toString() %></td>
      <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;"><%=pagelist2.get(13).toString() %></td>
      <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;">
      <%=((Float.parseFloat(pagelist2.get(10).toString())*Float.parseFloat(pagelist2.get(18).toString()))+Float.parseFloat(pagelist2.get(11).toString())*Float.parseFloat(pagelist2.get(19).toString())+Float.parseFloat(pagelist2.get(12).toString())*Float.parseFloat(pagelist2.get(20).toString()))*Float.parseFloat(pagelist2.get(13).toString()) %>
      </td> 
      <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;"><%=pagelist2.get(20).toString() %></td>   
      <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;"><%=pagelist2.get(21).toString() %></td>
      <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;">
      
      <%if(pagelist2.get(21).toString().trim().equals("�ѷ�Ʊ")){%>ɾ��<%}else {%>
      <a href="<%=basePath %>HkServlet?method=delYUDING&id=<%=pagelist2.get(15).toString()%>">ɾ��</a><%} %></td>
    </tr>
	
<%
	}}
%>  
  </TBODY>
</TABLE>

</BODY>
<%} %>
</HTML>
