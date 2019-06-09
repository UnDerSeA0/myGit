// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MemberManageServlet.java

package com.action;

import com.bean.MemberManageBean;
import com.bean.SystemBean;
import com.util.Filter;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class MemberManageServlet extends HttpServlet
{

	public MemberManageServlet()
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
		String sysdir = (new SystemBean()).getDir();
		HttpSession session = request.getSession();
		try
		{
			String username2 = (String)session.getAttribute("user");
			if (username2 == null)
			{
				request.getRequestDispatcher("error.jsp").forward(request, response);
			} else
			{
				String method = Filter.escapeHTMLTags(request.getParameter("method").trim());
				MemberManageBean mmBean = new MemberManageBean();
				if (method.equals("DELMEMBER") || method.equals("DELCO") || method.equals("DELTODAY") || method.equals("DELALLCLOSE") || method.equals("DELALLUSE"))
				{
					String check[] = request.getParameterValues("checkit");
					if (check == null)
					{
						if (method.equals("DELMEMBER"))
						{
							request.setAttribute("message", "请选择要删除的记录！");
							request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/member/person.jsp").toString()).forward(request, response);
						} else
						if (method.equals("DELCO"))
						{
							request.setAttribute("message", "请选择要删除的记录！");
							request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/member/co.jsp").toString()).forward(request, response);
						} else
						if (method.equals("DELTODAY"))
						{
							request.setAttribute("message", "请选择要删除的记录！");
							request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/member/today.jsp").toString()).forward(request, response);
						} else
						if (method.equals("DELALLCLOSE"))
						{
							request.setAttribute("message", "请选择要删除的记录！");
							request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/member/close.jsp").toString()).forward(request, response);
						} else
						if (method.equals("DELALLUSE"))
						{
							request.setAttribute("message", "请选择要删除的记录！");
							request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/member/using.jsp").toString()).forward(request, response);
						}
					} else
					{
						int id[] = new int[check.length];
						for (int i = 0; i < check.length; i++)
						{
							int s = Integer.parseInt(check[i]);
							id[i] = s;
						}

						int flag = mmBean.delMember(id);
						if (flag == 1)
						{
							if (method.equals("DELMEMBER"))
								request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/member/person.jsp").toString()).forward(request, response);
							else
							if (method.equals("DELCO"))
								request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/member/co.jsp").toString()).forward(request, response);
							else
							if (method.equals("DELTODAY"))
								request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/member/today.jsp").toString()).forward(request, response);
							else
							if (method.equals("DELALLCLOSE"))
								request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/member/close.jsp").toString()).forward(request, response);
							else
							if (method.equals("DELALLUSE"))
								request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/member/using.jsp").toString()).forward(request, response);
						} else
						if (method.equals("DELMEMBER"))
						{
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/member/person.jsp").toString()).forward(request, response);
						} else
						if (method.equals("DELCO"))
						{
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/member/co.jsp").toString()).forward(request, response);
						} else
						if (method.equals("DELTODAY"))
						{
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/member/today.jsp").toString()).forward(request, response);
						} else
						if (method.equals("DELALLCLOSE"))
						{
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/member/close.jsp").toString()).forward(request, response);
						} else
						if (method.equals("DELALLUSE"))
						{
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/member/using.jsp").toString()).forward(request, response);
						}
					}
				} else
				{
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			}
		}
		catch (Exception e)
		{
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	public void init()
		throws ServletException
	{
	}
}
