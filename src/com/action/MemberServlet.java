// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MemberServlet.java

package com.action;

import com.bean.MemberBean;
import com.bean.SystemBean;
import com.util.Filter;
import com.util.MD5;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class MemberServlet extends HttpServlet
{

	public MemberServlet()
	{
	}

	public void destroy()
	{
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		response.setContentType("text/html;charset=gb2312");
		request.setCharacterEncoding("gb2312");
		HttpSession session = request.getSession();
		MemberBean memberBean = new MemberBean();
		String method = Filter.escapeHTMLTags(request.getParameter("method").trim());
		if (method.equals("reg2"))
		{
			String username = Filter.escapeHTMLTags(request.getParameter("username").trim());
			String password = Filter.escapeHTMLTags(request.getParameter("password").trim());
			String reg_type = Filter.escapeHTMLTags(request.getParameter("reg_type").trim());
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.setAttribute("reg_type", reg_type);
			if (username.trim().equals("admin"))
			{
				request.setAttribute("username", username);
				request.setAttribute("message", "非法的用户名，请重新选择！");
				request.getRequestDispatcher("reg2.jsp").forward(request, response);
			} else
			{
				int flag = memberBean.checkRegName(username);
				if (flag == 1)
				{
					if (reg_type.equals("person"))
						request.getRequestDispatcher("personreg.jsp").forward(request, response);
					else
					if (reg_type.equals("co"))
						request.getRequestDispatcher("coreg.jsp").forward(request, response);
					else
						request.getRequestDispatcher("index.jsp").forward(request, response);
				} else
				if (flag == 5)
				{
					request.setAttribute("username", username);
					request.setAttribute("message", "对不起，该用户名已存在，请重新选择！");
					request.getRequestDispatcher("reg2.jsp").forward(request, response);
				} else
				{
					request.setAttribute("message", "系统维护中，请稍后再试！");
					request.getRequestDispatcher("reg2.jsp").forward(request, response);
				}
			}
		} else
		if (method.equals("checksame"))
		{
			String username = Filter.escapeHTMLTags(request.getParameter("username").trim());
			if (username.trim().equals("admin"))
			{
				request.setAttribute("username", username);
				request.setAttribute("message", "非法的用户名，请重新选择！");
				request.getRequestDispatcher("reg2.jsp").forward(request, response);
			} else
			{
				int flag = memberBean.checkRegName(username);
				if (flag == 1)
				{
					request.setAttribute("username", username);
					request.setAttribute("message", "恭喜您，这个名字可以使用！");
					request.getRequestDispatcher("reg2.jsp").forward(request, response);
				} else
				if (flag == 5)
				{
					request.setAttribute("username", username);
					request.setAttribute("message", "对不起，该用户名已存在，请重新选择！");
					request.getRequestDispatcher("reg2.jsp").forward(request, response);
				} else
				{
					request.setAttribute("message", "系统维护中，请稍后再试！");
					request.getRequestDispatcher("reg2.jsp").forward(request, response);
				}
			}
		} else
		if (method.equals("Editpwd"))
		{
			String member = (String)session.getAttribute("member");
			String type = (String)session.getAttribute("type");
			if (member == null || type == null)
			{
				response.sendRedirect("error.jsp");
			} else
			{
				String oldpwd = MD5.MD5(request.getParameter("oldpwd").trim());
				String newpwd = MD5.MD5(request.getParameter("newpwd").trim());
				int flag = memberBean.editPassword(member, oldpwd, newpwd);
				switch (flag)
				{
				case 1: // '\001'
					request.setAttribute("message", "密码修改成功！");
					request.getRequestDispatcher("member/info/editpwd.jsp").forward(request, response);
					break;

				case 3: // '\003'
					request.setAttribute("message", "原始密码错误，请确认权限！");
					request.getRequestDispatcher("member/info/editpwd.jsp").forward(request, response);
					break;

				case 4: // '\004'
					request.setAttribute("message", "系统维护中，请稍后再试！");
					request.getRequestDispatcher("member/info/editpwd.jsp").forward(request, response);
					break;
				}
			}
		} else
		if (method.equals("PREG"))
		{
			String username = Filter.escapeHTMLTags(request.getParameter("username").trim());
			String password = Filter.escapeHTMLTags(request.getParameter("password").trim());
			String type = "person";
			String realname = Filter.escapeHTMLTags(request.getParameter("realname").trim());
			String sex = Filter.escapeHTMLTags(request.getParameter("sex").trim());
			String sheng = Filter.escapeHTMLTags(request.getParameter("sheng").trim());
			String city = Filter.escapeHTMLTags(request.getParameter("city").trim());
			String bir = Filter.escapeHTMLTags(request.getParameter("bir").trim());
			String telphone = Filter.escapeHTMLTags(request.getParameter("telphone").trim());
			String email = Filter.escapeHTMLTags(request.getParameter("email").trim());
			String question = Filter.escapeHTMLTags(request.getParameter("question").trim());
			String answer = Filter.escapeHTMLTags(request.getParameter("answer").trim());
			String lastip = request.getRemoteAddr();
			int off = 1;
			int flag = memberBean.personReg(username, password, type, realname, sex, bir, sheng, city, telphone, email, question, answer, lastip, off);
			if (flag == 1)
			{
				List siteList = (new SystemBean()).getSiteInfo();
				String sitename = siteList.get(0).toString();
				request.setAttribute("message", (new StringBuilder("注册成功！恭喜您成为")).append(sitename).append("的注册会员，登陆后您可以发布业务信息！").toString());
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else
			{
				request.setAttribute("message", "系统维护中，请稍后再试！");
				request.getRequestDispatcher("personreg.jsp").forward(request, response);
			}
		} else
		if (method.equals("UPREGINFO"))
		{
			String member = (String)session.getAttribute("member");
			String type = (String)session.getAttribute("type");
			if (member == null || type == null)
			{
				response.sendRedirect("error.jsp");
			} else
			{
				String realname = Filter.escapeHTMLTags(request.getParameter("realname").trim());
				String sex = Filter.escapeHTMLTags(request.getParameter("sex").trim());
				String sheng = Filter.escapeHTMLTags(request.getParameter("sheng").trim());
				String city = Filter.escapeHTMLTags(request.getParameter("city").trim());
				String bir = Filter.escapeHTMLTags(request.getParameter("bir").trim());
				String telphone = Filter.escapeHTMLTags(request.getParameter("telphone").trim());
				String email = Filter.escapeHTMLTags(request.getParameter("email").trim());
				String question = Filter.escapeHTMLTags(request.getParameter("question").trim());
				String answer = Filter.escapeHTMLTags(request.getParameter("answer").trim());
				int flag = memberBean.uppersonReg(member, realname, sex, bir, sheng, city, telphone, email, question, answer);
				if (flag == 1)
				{
					request.setAttribute("message", "操作成功！");
					request.getRequestDispatcher("member/info/info.jsp").forward(request, response);
				} else
				{
					request.setAttribute("message", "系统维护中，请稍后再试！");
					request.getRequestDispatcher("member/info/info.jsp").forward(request, response);
				}
			}
		} else
		if (method.equals("COREG"))
		{
			String username = Filter.escapeHTMLTags(request.getParameter("username").trim());
			String password = Filter.escapeHTMLTags(request.getParameter("password").trim());
			String type = "co";
			String coname = Filter.escapeHTMLTags(request.getParameter("coname").trim());
			String address = Filter.escapeHTMLTags(request.getParameter("address").trim());
			String postnum = Filter.escapeHTMLTags(request.getParameter("postnum").trim());
			String tel = Filter.escapeHTMLTags(request.getParameter("telphone").trim());
			String email = Filter.escapeHTMLTags(request.getParameter("email").trim());
			String question = Filter.escapeHTMLTags(request.getParameter("question").trim());
			String answer = Filter.escapeHTMLTags(request.getParameter("answer").trim());
			String intro = Filter.escapeHTMLTags(request.getParameter("intro").trim());
			if (intro.equals(""))
				intro = "无";
			String lastip = request.getRemoteAddr();
			int flag = memberBean.coReg(username, password, type, coname, address, postnum, tel, email, question, answer, intro, lastip, 1);
			if (flag == 1)
			{
				List siteList = (new SystemBean()).getSiteInfo();
				String sitename = siteList.get(0).toString();
				request.setAttribute("message", (new StringBuilder("注册成功！恭喜您成为")).append(sitename).append("的企业会员，登陆后您可以发布业务信息！").toString());
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else
			{
				request.setAttribute("message", "系统维护中，请稍后再试！");
				request.getRequestDispatcher("coreg.jsp").forward(request, response);
			}
		} else
		if (method.equals("UPCOREGINFO"))
		{
			String member = (String)session.getAttribute("member");
			String type = (String)session.getAttribute("type");
			if (member == null || type == null)
			{
				response.sendRedirect("error.jsp");
			} else
			{
				String coname = Filter.escapeHTMLTags(request.getParameter("coname").trim());
				String address = Filter.escapeHTMLTags(request.getParameter("address").trim());
				String postnum = Filter.escapeHTMLTags(request.getParameter("postnum").trim());
				String tel = Filter.escapeHTMLTags(request.getParameter("telphone").trim());
				String email = Filter.escapeHTMLTags(request.getParameter("email").trim());
				String question = Filter.escapeHTMLTags(request.getParameter("question").trim());
				String answer = Filter.escapeHTMLTags(request.getParameter("answer").trim());
				String intro = Filter.escapeHTMLTags(request.getParameter("intro").trim());
				int flag = memberBean.upCoReg(member, coname, address, postnum, tel, email, question, answer, intro);
				if (flag == 1)
				{
					request.setAttribute("message", "操作成功！");
					request.getRequestDispatcher("member/info/coinfo.jsp").forward(request, response);
				} else
				{
					request.setAttribute("message", "系统维护中，请稍后再试！");
					request.getRequestDispatcher("member/info/coinfo.jsp").forward(request, response);
				}
			}
		} else
		if (method.equals("lostpwd"))
		{
			String username = request.getParameter("username");
			String question = request.getParameter("question");
			String answer = request.getParameter("answer");
			String reg_type = request.getParameter("reg_type");
			String info = memberBean.returnPwd(username, question, answer, reg_type);
			if (info.trim().equals("error"))
			{
				request.setAttribute("message", "信息错误！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else
			{
				request.setAttribute("message", (new StringBuilder("您的新密码为")).append(info).append("，请登录后修改！").toString());
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} else
		{
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	public void init()
		throws ServletException
	{
	}
}
