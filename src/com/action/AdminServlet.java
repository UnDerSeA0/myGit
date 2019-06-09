// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   AdminServlet.java

package com.action;

import com.bean.AdminBean;
import com.bean.SystemBean;
import com.util.MD5;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class AdminServlet extends HttpServlet
{

	public AdminServlet()
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
		try
		{
			String method = request.getParameter("method").trim();
			AdminBean loginbean = new AdminBean();
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(1200);
			SystemBean systembean = new SystemBean();
			String sysdir = systembean.getDir();
			if (method.equals("one"))
			{
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				if (username == null || username.trim().equals(""))
				{
					request.setAttribute("message", "请正确输入用户名！");
					request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/login.jsp").toString()).forward(request, response);
				} else
				if (password == null || password.trim().equals(""))
				{
					request.setAttribute("message", "请输入密码！");
					request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/login.jsp").toString()).forward(request, response);
				} else
				{
					String md5password = MD5.MD5(password);
					String agent = request.getHeader("user-agent");
					StringTokenizer st = new StringTokenizer(agent, ";");
					String useros = st.nextToken();
					String loginip = request.getRemoteAddr();
					int flag = loginbean.adminLogin(username, md5password, password, useros, loginip);
					switch (flag)
					{
					case 1: // '\001'
						java.util.List list = loginbean.getAdminInfo(username);
						session.setAttribute("user", username);
						session.setAttribute("list", list);
						request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/").toString()).forward(request, response);
						break;

					case 2: // '\002'
						request.setAttribute("message", "用户名错误！请确认管理权限！");
						request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/login.jsp").toString()).forward(request, response);
						break;

					case 3: // '\003'
						request.setAttribute("message", "密码错误，请确认管理权限！");
						request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/login.jsp").toString()).forward(request, response);
						break;
					}
				}
			} else
			if (method.equals("editpwd"))
			{
				String username2 = (String)session.getAttribute("user");
				if (username2 == null)
				{
					request.getRequestDispatcher("error.jsp").forward(request, response);
				} else
				{
					String oldpwd = MD5.MD5(request.getParameter("oldpwd").trim());
					String newpwd = MD5.MD5(request.getParameter("newpwd").trim());
					String username = (String)session.getAttribute("user");
					int flag = loginbean.editPassword(username, oldpwd, newpwd);
					switch (flag)
					{
					case 1: // '\001'
						request.setAttribute("message", "密码修改成功！");
						request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/system/editpwd.jsp").toString()).forward(request, response);
						break;

					case 3: // '\003'
						request.setAttribute("message", "原始密码错误，请确认权限！");
						request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/system/editpwd.jsp").toString()).forward(request, response);
						break;

					case 4: // '\004'
						request.setAttribute("message", "系统维护中，请稍后再试！");
						request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/system/editpwd.jsp").toString()).forward(request, response);
						break;
					}
				}
			} else
			if (method.equals("exit"))
			{
				String username2 = (String)session.getAttribute("user");
				if (username2 == null)
				{
					request.getRequestDispatcher("error.jsp").forward(request, response);
				} else
				{
					session.removeAttribute("user");
					session.removeAttribute("list");
					System.gc();
					request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/login.jsp").toString()).forward(request, response);
				}
			} else
			if (method.equals("manager"))
			{
				String username2 = (String)session.getAttribute("user");
				if (username2 == null)
				{
					request.getRequestDispatcher("error.jsp").forward(request, response);
				} else
				{
					String ra = request.getParameter("ra").trim();
					if (ra.equals("add"))
					{
						String username = request.getParameter("username").trim();
						String password = MD5.MD5(request.getParameter("password").trim());
						String isuse = request.getParameter("isuse").trim();
						if (isuse.equals("在用"))
							isuse = "1";
						else
							isuse = "2";
						int flag = loginbean.addManager(username, password, "2", isuse);
						if (flag == 1)
						{
							request.setAttribute("message", "增加管理员成功！");
							request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/system/user.jsp").toString()).forward(request, response);
						} else
						if (flag == 5)
						{
							request.setAttribute("username", username);
							request.setAttribute("message", "该用户名已经存在！");
							request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/system/user.jsp").toString()).forward(request, response);
						} else
						{
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/system/user.jsp").toString()).forward(request, response);
						}
					} else
					if (ra.equals("update"))
					{
						String username = request.getParameter("username").trim();
						String password = request.getParameter("password").trim();
						String isuse = request.getParameter("isuse").trim();
						if (!password.equals(""))
							password = MD5.MD5(password);
						if (isuse.equals("在用"))
							isuse = "1";
						else
							isuse = "2";
						int flag = loginbean.updateManager(username, password, "2", isuse);
						if (flag == 1)
						{
							request.setAttribute("message", "修改管理员信息成功！");
							request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/system/user.jsp").toString()).forward(request, response);
						} else
						{
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/system/user.jsp").toString()).forward(request, response);
						}
					}
				}
			} else
			if (method.equals("delm"))
			{
				String username2 = (String)session.getAttribute("user");
				if (username2 == null)
				{
					request.getRequestDispatcher("error.jsp").forward(request, response);
				} else
				{
					int id = Integer.parseInt(request.getParameter("id").trim());
					if (id == 1)
					{
						request.setAttribute("message", "不能删除原始帐号！");
						request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/system/user.jsp").toString()).forward(request, response);
					} else
					{
						int flag = loginbean.delManager(id);
						if (flag == 1)
						{
							request.setAttribute("message", "删除成功！");
							request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/system/user.jsp").toString()).forward(request, response);
						} else
						{
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/system/user.jsp").toString()).forward(request, response);
						}
					}
				}
			} else
			if (method.equals("dellog"))
			{
				String username2 = (String)session.getAttribute("user");
				if (username2 == null)
				{
					request.getRequestDispatcher("error.jsp").forward(request, response);
				} else
				{
					String check[] = request.getParameterValues("checkit");
					if (check == null)
					{
						request.setAttribute("message", "请选择要删除的记录！");
						request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/system/log.jsp").toString()).forward(request, response);
					} else
					{
						int id[] = new int[check.length];
						for (int i = 0; i < check.length; i++)
						{
							int s = Integer.parseInt(check[i]);
							id[i] = s;
						}

						int flag = loginbean.delLog(id);
						if (flag == 1)
						{
							request.setAttribute("message", "删除记录成功！");
							request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/system/log.jsp").toString()).forward(request, response);
						} else
						{
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher((new StringBuilder(String.valueOf(sysdir))).append("/system/log.jsp").toString()).forward(request, response);
						}
					}
				}
			} else
			{
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	public void init()
		throws ServletException
	{
	}
}
