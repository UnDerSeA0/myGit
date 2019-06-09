// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CheckCode.java

package com.util;

import java.util.Random;

public class CheckCode
{

	public CheckCode()
	{
	}

	public String getCheckCode()
	{
		Random random = new Random();
		String sRand = "";
		for (int i = 0; i < 4; i++)
		{
			String rand = String.valueOf(random.nextInt(10));
			sRand = (new StringBuilder(String.valueOf(sRand))).append(rand).toString();
		}

		return sRand;
	}
}
