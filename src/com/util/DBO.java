// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   DBO.java

package com.util;

import java.io.PrintStream;
import java.sql.*;
import javax.activation.DataSource;

public class DBO
{

	private Connection conn;
	private Statement stmt;
	private DataSource ds;

	public DBO()
	{
	}

	public void open()
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jsphksp1", "sa", "123");
			stmt = conn.createStatement();
			System.out.println("�����ݿ�����");
		}
		catch (Exception ex)
		{
			System.err.println((new StringBuilder("�����ݿ�ʱ����: ")).append(ex.getMessage()).toString());
		}
	}

	public void close()
	{
		try
		{
			conn.close();
			System.out.println("�ͷ�����");
		}
		catch (SQLException ex)
		{
			System.err.println((new StringBuilder("�������ӳس���: ")).append(ex.getMessage()).toString());
		}
	}

	public ResultSet executeQuery(String sql)
		throws SQLException
	{
		ResultSet rs = null;
		rs = stmt.executeQuery(sql);
		System.out.println("ִ�в�ѯ");
		return rs;
	}

	public int executeUpdate(String sql)
		throws SQLException
	{
		int ret = 0;
		ret = stmt.executeUpdate(sql);
		System.out.println("ִ����ɾ��");
		return ret;
	}

	public void addBatch(String sql)
		throws SQLException
	{
		stmt.addBatch(sql);
	}

	public int[] executeBatch()
		throws SQLException
	{
		boolean isAuto = conn.getAutoCommit();
		conn.setAutoCommit(false);
		int updateCounts[] = stmt.executeBatch();
		return updateCounts;
	}

	public boolean getAutoCommit()
		throws SQLException
	{
		return conn.getAutoCommit();
	}

	public void setAutoCommit(boolean auto)
		throws SQLException
	{
		conn.setAutoCommit(auto);
	}

	public void commit()
		throws SQLException
	{
		conn.commit();
	}

	public void rollBack()
		throws SQLException
	{
		conn.rollback();
	}
}