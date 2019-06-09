// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LoginServlet.java

package com.action;

import com.bean.MemberBean;
import com.util.Filter;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet
{

	public LoginServlet()
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
		if (method.equals("HEADUSERLOGIN"))
		{
			String reg_user = Filter.escapeHTMLTags(request.getParameter("reg_user").trim());
			String reg_pwd = Filter.escapeHTMLTags(request.getParameter("reg_pwd").trim());
			String reg_type = Filter.escapeHTMLTags(request.getParameter("reg_type").trim());
			String lastip = request.getRemoteAddr();
			int flag = memberBean.memberLogin(reg_user, reg_pwd, reg_type);
			if (flag == 1)
			{
				String info = memberBean.getLastTimeIP(reg_user);
				int flag2 = memberBean.upmemberLogin(reg_user, lastip);
				if (flag2 == 1)
				{
					session.setAttribute("member", reg_user);
					session.setAttribute("type", reg_type);
					session.setAttribute("info", info);
					request.getRequestDispatcher("login1.jsp").forward(request, response);
				} else
				{
					session.setAttribute("member", reg_user);
					session.setAttribute("type", reg_type);
					session.setAttribute("info", info);
					session.setAttribute("message", "登陆成功，登陆信息更新失败！");
					request.getRequestDispatcher("login1.jsp").forward(request, response);
				}
			} else
			if (flag == 2)
			{
				request.setAttribute("reg_user", reg_user);
				request.setAttribute("message", "该用户名不存在或者已被管理员冻结！");
				request.getRequestDispatcher("login1.jsp").forward(request, response);
			} else
			if (flag == 3)
			{
				request.setAttribute("reg_user", reg_user);
				request.setAttribute("message", "密码错误！");
				request.getRequestDispatcher("login1.jsp").forward(request, response);
			}
		} else
		if (method.equals("PAGEUSERLOGIN"))
		{
			String username = Filter.escapeHTMLTags(request.getParameter("username").trim());
			String password = Filter.escapeHTMLTags(request.getParameter("password").trim());
			String reg_type = Filter.escapeHTMLTags(request.getParameter("reg_type").trim());
			String lastip = request.getRemoteAddr();
			int flag = memberBean.memberLogin(username, password, reg_type);
			if (flag == 1)
			{
				String info = memberBean.getLastTimeIP(username);
				int flag2 = memberBean.upmemberLogin(username, lastip);
				if (flag2 == 1)
				{
					session.setAttribute("member", username);
					session.setAttribute("type", reg_type);
					session.setAttribute("info", info);
					request.getRequestDispatcher("member/index.jsp").forward(request, response);
				} else
				{
					session.setAttribute("member", username);
					session.setAttribute("type", reg_type);
					session.setAttribute("info", info);
					session.setAttribute("message", "登陆成功，登陆信息更新失败！");
					request.getRequestDispatcher("member/index.jsp").forward(request, response);
				}
			} else
			if (flag == 2)
			{
				request.setAttribute("reg_user", username);
				request.setAttribute("message", "该用户名不存在！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else
			if (flag == 3)
			{
				request.setAttribute("reg_user", username);
				request.setAttribute("message", "密码错误！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} else
		if (method.equals("logout"))
		{
			session.removeAttribute("member");
			session.removeAttribute("type");
			request.getRequestDispatcher("login1.jsp").forward(request, response);
		} else
		if (method.equals("pagelogout") || method.equals("memberexit"))
		{
			session.removeAttribute("member");
			session.removeAttribute("type");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else
		{
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	public void init()
		throws ServletException
	{
	}
}
