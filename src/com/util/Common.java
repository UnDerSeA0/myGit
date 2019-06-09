// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Common.java

package com.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class Common
{

	public Common()
	{
	}

	public static String turn(String str)
	{
		for (; str.indexOf("\n") != -1; str = (new StringBuilder(String.valueOf(str.substring(0, str.indexOf("\n"))))).append("<br>").append(str.substring(str.indexOf("\n") + 1)).toString());
		for (; str.indexOf(" ") != -1; str = (new StringBuilder(String.valueOf(str.substring(0, str.indexOf(" "))))).append("&nbsp;").append(str.substring(str.indexOf(" ") + 1)).toString());
		return str;
	}

	public static String getDate(int num)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(1, num);
		return df.format(c.getTime());
	}

	public static String SQLStr(String str)
	{
		if (str != null && str.length() > 1 && str.substring(0, 1).equals("?"))
			str = str.substring(1);
		if (str == null || str.equals("") || str.equals(" "))
			str = "&nbsp;";
		return str;
	}

	public static String PageStr(String str)
	{
		if (str == null || str.trim().equals("") || str.equals(" ") || str.equals("null"))
			str = "";
		str = str.trim();
		return str;
	}

	public static String formatRZ(String oldDate)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date Date = new Date(oldDate);
		return df.format(Date);
	}

	public static String toChineseAndTrim(String str)
	{
		if (str == null)
			str = "";
		try
		{
			byte b[] = str.getBytes("iso-8859-1");
			str = new String(b);
			str = str.trim();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return str;
	}
}
