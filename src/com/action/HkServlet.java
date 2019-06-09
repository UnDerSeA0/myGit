// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   HkServlet.java

package com.action;

import com.bean.HkBean;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class HkServlet extends HttpServlet
{

	public HkServlet()
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
		String method = request.getParameter("method");
		System.out.println(method);
		
		HkBean hk = new HkBean();
		if (method.equals("addCO"))
		{
			String name = request.getParameter("name");
			int flag = hk.addCO(name);
			if (flag == 1)
			{
				request.setAttribute("message", "操作成功！");
				request.getRequestDispatcher("admin/co/index.jsp").forward(request, response);
			} else
			{
				request.setAttribute("message", "操作失败！");
				request.getRequestDispatcher("admin/co/index.jsp").forward(request, response);
			}
		} else
		if (method.equals("delCO"))
		{
			String id = request.getParameter("id");
			int flag = hk.delCO(id);
			if (flag == 1)
			{
				request.setAttribute("message", "操作成功！");
				request.getRequestDispatcher("admin/co/index.jsp").forward(request, response);
			} else
			{
				request.setAttribute("message", "操作失败！");
				request.getRequestDispatcher("admin/co/index.jsp").forward(request, response);
			}
		} else
		if (method.equals("upCO"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			int flag = hk.upCO(name,id);
			if (flag == 1)
			{
				request.setAttribute("message", "操作成功！");
				request.getRequestDispatcher("admin/co/index.jsp").forward(request, response);
			} else
			{
				request.setAttribute("message", "操作失败！");
				request.getRequestDispatcher("admin/co/index.jsp").forward(request, response);
			}
		} else
		if (method.equals("addHB"))
		{
			String type = request.getParameter("type");
			String splace = request.getParameter("splace");
			String stime = request.getParameter("stime");
			String sh = request.getParameter("sh");
			String sm = request.getParameter("sm");
			String eh = request.getParameter("eh");
			String em = request.getParameter("em");
			String etime = request.getParameter("etime");
			String toudeng = request.getParameter("toudeng");
			String co = request.getParameter("co");
			String price = request.getParameter("price");
			String cprice = request.getParameter("cprice");
			String mprice = request.getParameter("mprice");
			String num = request.getParameter("num");
			String dz = request.getParameter("dz");
			int flag = hk.addHB(type, splace, stime, sh, sm, etime, eh, em, co, price, cprice, mprice, dz, num);
			if (flag == 1)
			{
				request.setAttribute("message", "操作成功！");
				request.getRequestDispatcher("admin/hb/index.jsp").forward(request, response);
			} else
			{
				request.setAttribute("message", "操作失败！");
				request.getRequestDispatcher("admin/hb/index.jsp").forward(request, response);
			}
		} else
		if (method.equals("upHB"))
		{
			String id = request.getParameter("id");
			String type = request.getParameter("type");
			String splace = request.getParameter("splace");
			String sh = request.getParameter("sh");
			String sm = request.getParameter("sm");
			String eh = request.getParameter("eh");
			String em = request.getParameter("em");
			String stime = request.getParameter("stime");
			String etime = request.getParameter("etime");
			String co = request.getParameter("co");
			String price = request.getParameter("price");
			String cprice = request.getParameter("cprice");
			String mprice = request.getParameter("mprice");
			String num = request.getParameter("num");
			String dz = request.getParameter("dz");
			int flag = hk.upHB(id, type, splace, stime, sh, sm, etime, eh, em, co, price, cprice, mprice, dz, num);
			if (flag == 1)
			{
				request.setAttribute("message", "操作成功！");
				request.getRequestDispatcher("admin/hb/index.jsp").forward(request, response);
			} else
			{
				request.setAttribute("message", "操作失败！");
				request.getRequestDispatcher("admin/hb/index.jsp").forward(request, response);
			}
		} else
		if (method.equals("delHB"))
		{
			String id = request.getParameter("id");
			int flag = hk.delHB(id);
			if (flag == 1)
			{
				request.setAttribute("message", "操作成功！");
				request.getRequestDispatcher("admin/hb/index.jsp").forward(request, response);
			} else
			{
				request.setAttribute("message", "操作失败！");
				request.getRequestDispatcher("admin/hb/index.jsp").forward(request, response);
			}
		} else
		if (method.equals("YUDING"))
		{
			String pid = request.getParameter("id");
			String member = (String)session.getAttribute("member");
			String price = request.getParameter("price");
			String cprice = request.getParameter("cprice");
			String mprice = request.getParameter("mprice");
			int j = hk.getSUM(pid);
			int m = hk.getSUMPRICE(pid);
			int n = hk.getSUMMPRICE(pid);
			int o = hk.getSUMPRICE(pid);
			if (j - m - n - o < Integer.parseInt(price) + Integer.parseInt(cprice) + Integer.parseInt(mprice))
			{
				request.setAttribute("message", (new StringBuilder("剩余票数")).append(j - m - n - o).append("张，少于预定票数，预定失败！").toString());
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else
			{
				int flag = hk.addYUDING(pid, member, price, cprice, mprice);
				if (flag == 1)
				{
					request.setAttribute("message", "操作成功！");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				} else
				{
					request.setAttribute("message", "操作失败！");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}
		} else
		if (method.equals("upYUDING"))
		{
			String id = request.getParameter("id");
			String price = request.getParameter("price");
			String cprice = request.getParameter("cprice");
			String mprice = request.getParameter("mprice");
			int flag = hk.upYUDING(id, price, cprice, mprice);
			if (flag == 1)
			{
				request.setAttribute("message", "操作成功！");
				request.getRequestDispatcher("member/job/index.jsp").forward(request, response);
			} else
			{
				request.setAttribute("message", "操作失败！");
				request.getRequestDispatcher("member/job/index.jsp").forward(request, response);
			}
		} else
		if (method.equals("delYUDING"))
		{
			String id = request.getParameter("id");
			int flag = hk.delYUDING(id);
			if (flag == 1)
			{
				request.setAttribute("message", "操作成功！");
				request.getRequestDispatcher("member/job/index.jsp").forward(request, response);
			} else
			{
				request.setAttribute("message", "操作失败！");
				request.getRequestDispatcher("member/job/index.jsp").forward(request, response);
			}
		} else
		if (method.equals("ADMINdelYUDING"))
		{
			String id = request.getParameter("id");
			int flag = hk.delYUDING(id);
			if (flag == 1)
			{
				request.setAttribute("message", "操作成功！");
				request.getRequestDispatcher("admin/dd/wei.jsp").forward(request, response);
			} else
			{
				request.setAttribute("message", "操作失败！");
				request.getRequestDispatcher("admin/dd/index.jsp").forward(request, response);
			}
		} else
		if (method.equals("SENDYUDING"))
		{
			String id = request.getParameter("id");
			int flag = hk.sendYUDING(id);
			if (flag == 1)
			{
				request.setAttribute("message", "操作成功！");
				request.getRequestDispatcher("admin/dd/over.jsp").forward(request, response);
			} else
			{
				request.setAttribute("message", "操作失败！");
				request.getRequestDispatcher("admin/dd/over.jsp").forward(request, response);
			}
		}
	}

	public void init()
		throws ServletException
	{
	}
}
