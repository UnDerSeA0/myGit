package com.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.util.Constant;
import com.util.DBO;



public class HkBean {

	private List list;
	private ResultSet rs;
	private String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
	
	//////////////////////////////////////////////////////////////航空公司
	public int addCO(String name){
		String sql="insert into co(name) values('"+name+"')";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	public int delCO(String id){
		String sql="delete from co where id='"+id+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	
	public int upCO(String name,int id){
		String sql="update co set name='"+name+"'"+" where id="+id;
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	public List getCO(){
		String sql="select * from co order by id desc";
		DBO dbo = new DBO();
		dbo.open();
		list =new ArrayList();
		try{
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	///////////////////////////////////////////////////////////////////////航班
	//国际国内type 航线splace  起飞时间stime 降落时间etime 
	//航空公司co 成人票价price 儿童价格cprice 会员价mprice 打折dz
	public int addHB(String type,String splace,String stime,String sh,String sm,String etime,String eh,String em,String co,String price,String cprice,String mprice,String dz,String num){
		String sql = "insert into plane(type,splace,stime,sh,sm,etime,eh,em,co,price,cprice,mprice,dz,num)" +
				"values('"+type+"','"+splace+"','"+stime+"','"+sh+"','"+sm+"','"+etime+"','"+eh+"','"+em+"','"+co+"','"+price+"','"+cprice+"','"+mprice+"','"+dz+"','"+num+"')";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	//修改
	public int upHB(String id,String type,String splace,String stime,String sh,String sm,String etime,String eh,String em,String co,String price,String cprice,String mprice,String dz,String num){
		String sql = "update plane set type='"+type+"',splace='"+splace+"',stime='"+stime+"',sh='"+sh+"',sm='"+sm+"',etime='"+etime+"',eh='"+eh+"',em='"+em+"'," +
				"co='"+co+"',price='"+price+"',cprice='"+cprice+"',mprice='"+mprice+"',dz='"+dz+"',num='"+num+"' where id='"+id+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	public int delHB(String id){
		String sql="delete from plane where id='"+id+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	public List getALLHB(){
		String sql="select * from plane order by id desc";
		DBO dbo = new DBO();
		dbo.open();
		list =new ArrayList();
		try{
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
				list2.add(rs.getString(6));
				list2.add(rs.getString(7));
				list2.add(rs.getString(8));
				list2.add(rs.getString(9));
				list2.add(rs.getString(10));
				list2.add(rs.getString(11));
				list2.add(rs.getString(12));
				list2.add(rs.getString(13));
				list2.add(rs.getString(14));
				list2.add(rs.getString(15));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	public List getALLHB(String str){
		String sql="select * from plane where type='"+str+"' order by id desc";
		DBO dbo = new DBO();
		dbo.open();
		list =new ArrayList();
		try{
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
				list2.add(rs.getString(6));
				list2.add(rs.getString(7));
				list2.add(rs.getString(8));
				list2.add(rs.getString(9));
				list2.add(rs.getString(10));
				list2.add(rs.getString(11));
				list2.add(rs.getString(12));
				list2.add(rs.getString(13));
				list2.add(rs.getString(14));
				list2.add(rs.getString(15));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	public List getSHB(String sql){
		//String sql="select * from plane where type='"+str+"' order by id desc";
		DBO dbo = new DBO();
		dbo.open();
		list =new ArrayList();
		try{
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
				list2.add(rs.getString(6));
				list2.add(rs.getString(7));
				list2.add(rs.getString(8));
				list2.add(rs.getString(9));
				list2.add(rs.getString(10));
				list2.add(rs.getString(11));
				list2.add(rs.getString(12));
				list2.add(rs.getString(13));
				list2.add(rs.getString(14));
				list2.add(rs.getString(15));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	public List getALLSPLACE(){
		String sql="select splace from plane order by id desc";
		DBO dbo = new DBO();
		dbo.open();
		list =new ArrayList();
		try{
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				list.add(rs.getString(1));
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	public List getHB(String id){
		String sql="select * from plane where id='"+id+"'";
		DBO dbo = new DBO();
		dbo.open();
		list =new ArrayList();
		try{
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getString(4));
				list.add(rs.getString(5));
				list.add(rs.getString(6));
				list.add(rs.getString(7));
				list.add(rs.getString(8));
				list.add(rs.getString(9));
				list.add(rs.getString(10));
				list.add(rs.getString(11));
				list.add(rs.getString(12));
				list.add(rs.getString(13));
				list.add(rs.getString(14));
				list.add(rs.getString(15));
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	//////////////////////////////////////////////yuding
	public int addYUDING(String pid,String member,String price,String cprice,String mprice){
		String sql="insert into yuding(pid,member,price,cprice,mprice,flag,addtime)" +
				"values('"+pid+"','"+member+"','"+price+"','"+cprice+"','"+mprice+"','预定中','"+date+"')";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	public int upYUDING(String id,String price,String cprice,String mprice){
		String sql="update yuding set price='"+price+"',cprice='"+cprice+"',mprice='"+mprice+"' where id='"+id+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	public int delYUDING(String id){
		String sql="delete from yuding where id='"+id+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	public int sendYUDING(String id){
		String sql="update yuding set flag='已发票' where id='"+id+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	public int getSUMPRICE(String pid){
		String sql="select sum(price) from yuding where pid='"+pid+"' and flag !='超时取消'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			rs=dbo.executeQuery(sql);
			rs.next();
			return rs.getInt(1);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dbo.close();
		}
	}
	public int getSUM(String pid){
		String sql="select num from plane where id='"+pid+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			rs=dbo.executeQuery(sql);
			rs.next();
			return rs.getInt(1);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dbo.close();
		}
	}
	public int getSUMCPRICE(String pid){
		String sql="select sum(cprice) from yuding where pid='"+pid+"' and flag !='超时取消'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			rs=dbo.executeQuery(sql);
			rs.next();
			return rs.getInt(1);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dbo.close();
		}
	}
	public int getSUMMPRICE(String pid){
		String sql="select sum(mprice) from yuding where pid='"+pid+"' and flag !='超时取消'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			rs=dbo.executeQuery(sql);
			rs.next();
			return rs.getInt(1);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dbo.close();
		}
	}
	public List getYUDING(String id){
		String sql="select * from yuding where id='"+id+"'";
		DBO dbo = new DBO();
		dbo.open();
		list =new ArrayList();
		try{
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getString(4));
				list.add(rs.getString(5));
				list.add(rs.getString(6));
				list.add(rs.getString(7));
				list.add(rs.getString(8));
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	public List getALLYUDINGTYPE(String flag){
		String sql="select plane.*,yuding.* from plane,yuding where plane.id=yuding.pid and yuding.flag='"+flag+"' order by yuding.id desc";
		DBO dbo = new DBO();
		dbo.open();
		list =new ArrayList();
		try{
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
				list2.add(rs.getString(6));
				list2.add(rs.getString(7));
				list2.add(rs.getString(8));
				list2.add(rs.getString(9));
				list2.add(rs.getString(10));
				list2.add(rs.getString(11));
				list2.add(rs.getString(12));
				list2.add(rs.getString(13));
				list2.add(rs.getString(14));
				list2.add(rs.getString(15));
				list2.add(rs.getString(16));
				list2.add(rs.getString(17));
				list2.add(rs.getString(18));
				list2.add(rs.getString(19));
				list2.add(rs.getString(20));
				list2.add(rs.getString(21));
				list2.add(rs.getString(22));
				list2.add(rs.getString(23));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	public List getALLYUDING(String member){
		String sql="select plane.*,yuding.* from plane,yuding where plane.id=yuding.pid and yuding.member='"+member+"' order by yuding.id desc";
		DBO dbo = new DBO();
		dbo.open();
		list =new ArrayList();
		try{
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
				list2.add(rs.getString(6));
				list2.add(rs.getString(7));
				list2.add(rs.getString(8));
				list2.add(rs.getString(9));
				list2.add(rs.getString(10));
				list2.add(rs.getString(11));
				list2.add(rs.getString(12));
				list2.add(rs.getString(13));
				list2.add(rs.getString(14));
				list2.add(rs.getString(15));
				list2.add(rs.getString(16));
				list2.add(rs.getString(17));
				list2.add(rs.getString(18));
				list2.add(rs.getString(19));
				list2.add(rs.getString(20));
				list2.add(rs.getString(21));
				list2.add(rs.getString(22));
				list2.add(rs.getString(23));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	public List getID(){
		String sql="select id from plane where stime<'"+date+"' ";
		DBO dbo=new DBO();
		list=new ArrayList();
		dbo.open();
		try{
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				list.add(rs.getString(1));
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	public void outTime(List list){
		DBO dbo=new DBO();
		dbo.open();
		try{
			for(int i=0;i<list.size();i++){
				String str="update yuding set flag='超时取消' where pid='"+list.get(i).toString()+"' and flag !='已发票'";
				System.out.println(str);
				dbo.executeUpdate(str);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbo.close();
		}
	}
}
