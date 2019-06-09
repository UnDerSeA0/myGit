package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.util.*;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/iframe/head.jsp");
    _jspx_dependants.add("/iframe/foot.jsp");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=gb2312");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      com.bean.SystemBean sys = null;
      synchronized (_jspx_page_context) {
        sys = (com.bean.SystemBean) _jspx_page_context.getAttribute("sys", PageContext.PAGE_SCOPE);
        if (sys == null){
          sys = new com.bean.SystemBean();
          _jspx_page_context.setAttribute("sys", sys, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      com.bean.HkBean hk = null;
      synchronized (_jspx_page_context) {
        hk = (com.bean.HkBean) _jspx_page_context.getAttribute("hk", PageContext.PAGE_SCOPE);
        if (hk == null){
          hk = new com.bean.HkBean();
          _jspx_page_context.setAttribute("hk", hk, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List sysList=sys.getSiteInfo();

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd\">\r\n");
      out.write("<HTML xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<HEAD>\r\n");
      out.write("<TITLE>");
      out.print(sysList.get(0).toString() );
      out.write("</TITLE>\r\n");
      out.write("<META http-equiv=Content-Language content=zh-cn>\r\n");
      out.write("<META http-equiv=Content-Type content=\"text/html; charset=gb2312\">\r\n");
      out.write("<META name=\"keywords\" content=\"");
      out.print(sysList.get(2).toString() );
      out.write("\" />\r\n");
      out.write("<META name=\"description\" content=\"");
      out.print(sysList.get(3).toString() );
      out.write("\" />\r\n");
      out.write("\r\n");
      out.write("<META content=\"MSHTML 6.00.2900.3243\" name=GENERATOR>\r\n");
      out.write("<LINK href=\"");
      out.print(basePath );
      out.write("images/css.css\" type=text/css rel=stylesheet>\r\n");
      out.write("<LINK href=\"");
      out.print(basePath );
      out.write("images/default.css\" type=text/css rel=stylesheet>\r\n");
      out.write("\r\n");
      out.write("<SCRIPT language=JavaScript src=\"");
      out.print(basePath );
      out.write("images/Common.js\"></SCRIPT>\r\n");
      out.write("<SCRIPT language=JavaScript src=\"");
      out.print(basePath );
      out.write("images/index.js\"></SCRIPT>\r\n");
      out.write("<SCRIPT language=JavaScript src=\"");
      out.print(basePath );
      out.write("images/calendar.js\"></SCRIPT>\r\n");
      out.write("\r\n");
      out.write("<SCRIPT language=JavaScript>\r\n");
      out.write("<!--//屏蔽出错代码\r\n");
      out.write("function killErr(){\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("window.onerror=killErr;\r\n");
      out.write("//-->\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("<SCRIPT language=JavaScript>\r\n");
      out.write("<!--//处理大分类一行两个小分类\r\n");
      out.write("function autoTable(div){\r\n");
      out.write("\tfs=document.getElementById(div).getElementsByTagName(\"TABLE\");\r\n");
      out.write("\tfor(var i=0;i<fs.length;i++){\r\n");
      out.write("\t\tfs[i].style.width='49.5%';\r\n");
      out.write("\t\tif(i%2==1){\r\n");
      out.write("\t\t\tif (document.all) {\r\n");
      out.write("\t\t\t\tfs[i].style.styleFloat=\"right\";\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tfs[i].style.cssFloat=\"right;\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tif (document.all) {\r\n");
      out.write("\t\t\t\tfs[i].style.styleFloat=\"left\";\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tfs[i].style.cssFloat=\"left;\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("//-->\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("<SCRIPT language=JavaScript src=\"images/inc.js\"></SCRIPT>\r\n");
      out.write("<SCRIPT language=JavaScript src=\"images/default.js\"></SCRIPT>\r\n");
      out.write("<SCRIPT language=JavaScript src=\"images/swfobject.js\"></SCRIPT>\r\n");
      out.write("</HEAD>\r\n");
      out.write("<BODY text=#000000 bgColor=#ffffff leftMargin=0 topMargin=0>\r\n");
      out.write("<SCRIPT language=JavaScript>\r\n");
      out.write("<!--//目的是为了做风格方便\r\n");
      out.write("document.write('<div class=\"wrap\">');\r\n");
      out.write("//-->\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("\r\n");
      out.write("<TABLE id=header cellSpacing=0 cellPadding=0 width=\"100%\" align=center border=0>\r\n");
      out.write("<TBODY>\r\n");
      out.write("  <TR>\r\n");
      out.write("    <TD>\r\n");
      out.write("      \r\n");
      out.write("      <DIV class=ad id=banner>\r\n");
      out.write("      <img src=\"");
      out.print(basePath );
      out.write("images/banner.gif\" border=0 width=\"950\" height=\"200\">\r\n");
      out.write("\t  </DIV>\r\n");
      out.write("\t</TD>\r\n");
      out.write("  </TR>\r\n");
      out.write(" </TBODY>\r\n");
      out.write("</TABLE>\r\n");
      out.write("<TABLE id=guide cellSpacing=0 cellPadding=0 width=\"100%\" align=center border=0>\r\n");
      out.write("<TBODY>\r\n");
      out.write("  <TR>\r\n");
      out.write("    <TD align=middle>\r\n");
      out.write("\t<!--****************主菜单开始****************-->\r\n");
      out.write("\t\r\n");
      out.write("\t<A href=\"index.jsp\" target=\"\">首   页</A> |\r\n");
      out.write("\t<A href=\"guonei.jsp\" target=\"\">国内航班</A> |\r\n");
      out.write("\t<A href=\"guoji.jsp\" target=\"\">国际航班</A> |\r\n");
      out.write("\t<A href=\"member/index.jsp\" target=\"\">会员中心</A> |\r\n");
      out.write("\t<A href=\"admin/login.jsp\" target=\"\">管理登录</A> |\r\n");
      out.write("\t\r\n");
      out.write("\t<!--****************主菜单结束****************-->\r\n");
      out.write("\t</TD>\r\n");
      out.write("  </TR>\r\n");
      out.write("</TBODY>\r\n");
      out.write("</TABLE>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd\">\r\n");
      out.write("<HTML xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<HEAD>\r\n");
      out.write("<LINK href=\"images/default.css\" type=text/css rel=stylesheet>\r\n");
      out.write("<LINK href=\"images/css.css\" type=text/css rel=stylesheet>\r\n");
      out.write("<META http-equiv=Content-Type content=\"text/html; charset=gb2312\">\r\n");
      out.write("<STYLE type=text/css>\r\n");
      out.write(".ycbt {\r\n");
      out.write("\tBORDER-RIGHT: #fff 1px solid; BORDER-TOP: #fff 1px solid; PADDING-LEFT: 1.8em; BACKGROUND-COLOR: #EAF2EF; BORDER-LEFT: #fff 1px solid; PADDING-TOP: 7px; BORDER-BOTTOM: #fff 1px solid; HEIGHT: 20px\r\n");
      out.write("}\r\n");
      out.write(".xsbt {\r\n");
      out.write("\tBORDER-RIGHT: #fff 1px solid; BORDER-TOP: #fff 1px solid; PADDING-LEFT: 1.8em; BACKGROUND-IMAGE: url(images/head1.gif); BORDER-LEFT: #fff 1px solid; PADDING-TOP: 7px; BORDER-BOTTOM: #fff 1px solid; HEIGHT: 20px\r\n");
      out.write("}\r\n");
      out.write(".xsnr {\r\n");
      out.write("\tDISPLAY: block\r\n");
      out.write("}\r\n");
      out.write(".ycnr {\r\n");
      out.write("\tDISPLAY: none\r\n");
      out.write("}\r\n");
      out.write("</STYLE>\r\n");
      out.write("<SCRIPT type=text/javascript>\r\n");
      out.write("function tb_xs(t,m,n){\r\n");
      out.write("for(var i=1;i<=m;i++){\r\n");
      out.write("if (i != n){\r\n");
      out.write("document.getElementById(\"tb\"+t+ \"_bt\" + i).className= \"ycbt\";\r\n");
      out.write("document.getElementById(\"tb\"+t+ \"_nr\" + i).className= \"ycnr\";}\r\n");
      out.write("else{\r\n");
      out.write("document.getElementById(\"tb\"+t+ \"_bt\" + i).className= \"xsbt\";\r\n");
      out.write("document.getElementById(\"tb\"+t+ \"_nr\" + i).className= \"xsnr\";}}}\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("<SCRIPT language=JavaScript>\r\n");
      out.write("<!--//屏蔽出错代码\r\n");
      out.write("function killErr(){\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("window.onerror=killErr;\r\n");
      out.write("//-->\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("<SCRIPT language=JavaScript>\r\n");
      out.write("<!--//处理大分类一行两个小分类\r\n");
      out.write("function autoTable(div){\r\n");
      out.write("\tfs=document.getElementById(div).getElementsByTagName(\"TABLE\");\r\n");
      out.write("\tfor(var i=0;i<fs.length;i++){\r\n");
      out.write("\t\tfs[i].style.width='49.5%';\r\n");
      out.write("\t\tif(i%2==1){\r\n");
      out.write("\t\t\tif (document.all) {\r\n");
      out.write("\t\t\t\tfs[i].style.styleFloat=\"right\";\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tfs[i].style.cssFloat=\"right;\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tif (document.all) {\r\n");
      out.write("\t\t\t\tfs[i].style.styleFloat=\"left\";\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tfs[i].style.cssFloat=\"left;\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("//-->\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("<SCRIPT language=JavaScript src=\"images/inc.js\"></SCRIPT>\r\n");
      out.write("<SCRIPT language=JavaScript src=\"images/default.js\"></SCRIPT>\r\n");
      out.write("<SCRIPT language=JavaScript src=\"images/swfobject.js\"></SCRIPT>\r\n");
      out.write("<META content=\"MSHTML 6.00.2900.3268\" name=GENERATOR>\r\n");
      out.write("</HEAD>\r\n");

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

      out.write("\r\n");
      out.write("<BODY text=#000000 bgColor=#ffffff leftMargin=0 topMargin=0>\r\n");
      out.write("<SCRIPT language=JavaScript>\r\n");
      out.write("<!--//目的是为了做风格方便\r\n");
      out.write("document.write('<div class=\"wrap\">');\r\n");
      out.write("//-->\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function ss()\r\n");
      out.write("{\r\n");
      out.write("\tif(document.form1.stime.value==\"\"||document.form1.etime.value==\"\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\talert(\"请选择起飞时间和抵达时间！\");\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<form action=\"");
      out.print(basePath );
      out.write("sinfo.jsp\" method=post name=form1 onsubmit=\"return ss()\">\r\n");
      out.write("       <TABLE class=dragTable  cellSpacing=0 cellPadding=0 width=\"100%\" border=0>\r\n");
      out.write("        <TBODY> \r\n");
      out.write("        <TR>\r\n");
      out.write("          <TD class=head colspan=\"2\">\r\n");
      out.write("\t\t\t<SPAN class=TAG>航班信息查询</SPAN> \r\n");
      out.write("\t\t\t<SPAN class=more style=\"FLOAT: right\"></SPAN> \r\n");
      out.write("\t\t  </TD>\r\n");
      out.write("\t\t</TR>             \r\n");
      out.write("        <TR>\r\n");
      out.write("          <TD width=40% align=right>飞行航线</TD>\r\n");
      out.write("          <TD align=left><select name=splace>\r\n");
      out.write("          ");
List hblist=hk.getALLSPLACE(); for(int i=0;i<hblist.size();i++){
      out.write("\r\n");
      out.write("          <option value=\"");
      out.print(hblist.get(i).toString() );
      out.write('"');
      out.write('>');
      out.print(hblist.get(i).toString() );
      out.write("</option>\r\n");
      out.write("          ");
} 
      out.write(" \r\n");
      out.write("          </select></TD>\r\n");
      out.write("        </TR>\r\n");
      out.write("         <TR>\r\n");
      out.write("          <TD width=40% align=right>起飞时间</TD>\r\n");
      out.write("          <TD align=left><INPUT class=inputb maxLength=24 size=30 name=stime readonly onclick=\"SelectDate(this,'yyyy-MM-dd')\"  this.Txt_Date.Attributes[\"onclick\"] = \"SelectDate(this,'yyyy-MM-dd')\";>  \r\n");
      out.write("</TD>\r\n");
      out.write("        </TR>\r\n");
      out.write("         <TR>\r\n");
      out.write("          <TD width=40% align=right>抵达时间</TD>\r\n");
      out.write("          <TD align=left><INPUT class=inputb maxLength=24 size=30 name=etime readonly onclick=\"SelectDate(this,'yyyy-MM-dd')\"  this.Txt_Date.Attributes[\"onclick\"] = \"SelectDate(this,'yyyy-MM-dd')\";>  \r\n");
      out.write("</TD>\r\n");
      out.write("        </TR>\r\n");
      out.write("         <TR>\r\n");
      out.write("          <TD width=40% align=right>票价类别</TD>\r\n");
      out.write("          <TD align=left><select name=passtype>\r\n");
      out.write("          <option value=price>成人票价</option>\r\n");
      out.write("          <option value=cprice>儿童票价</option>\r\n");
      out.write("          <option value=mprice>会员票价</option>\r\n");
      out.write("          </select></TD>\r\n");
      out.write("        </TR>\r\n");
      out.write("        <TR>\r\n");
      out.write("          <TD colspan=2 align=center><input type=submit value=\"查询航班信息\"></TD>\r\n");
      out.write("        </TR>\r\n");
      out.write("        </TBODY>\r\n");
      out.write("\t  </TABLE>\r\n");
      out.write("</form>\r\n");
      out.write("<TABLE class=dragTable cellSpacing=0 cellPadding=0 width=\"100%\" align=center border=0>\r\n");
      out.write("  <TBODY>\r\n");
      out.write("  <TR>\r\n");
      out.write("    <TD>\r\n");
      out.write("\t</TD>\r\n");
      out.write("   </TR>\r\n");
      out.write("  </TBODY>\r\n");
      out.write("</TABLE>\r\n");
      out.write("\r\n");
      out.write("<SCRIPT language=JavaScript>\r\n");
      out.write("<!--//目的是为了做风格方便\r\n");
      out.write("document.write('</div>');\r\n");
      out.write("//-->\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("<SCRIPT language=JavaScript>\r\n");
      out.write("<!--\r\n");
      out.write("clickEdit.init();\r\n");
      out.write("//-->\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("</BODY>\r\n");
      out.write("</HTML>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("建议使用IE或以上版本浏览");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
