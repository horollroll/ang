package kr.ac.itschool.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.ac.itschool.custom.CustomDateFormat;
import kr.ac.itschool.dao.MemberDao;
import kr.ac.itschool.dbpool.DBConnectionManager;
import kr.ac.itschool.entities.Member;

public class MemberDaoService implements MemberDao {
DBConnectionManager db = DBConnectionManager.getInstance();
Connection cn = null;
PreparedStatement ps = null;
ResultSet rs = null;


	public boolean insertRow(Member data){
	boolean insert =false;
	StringBuilder sb = new StringBuilder();
	String Inputdate = CustomDateFormat.mydateFormat();
	sb.append("insert into member(id,name,phone1,phone2,phone3,post,addr1,addr2,cardno,job,picture,password,inputdate)");
	sb.append("Values('"+data.getId()+"','"+data.getName()+"','"+data.getPhone1()+"',");
	sb.append("'"+data.getPhone2()+"','"+data.getPhone3()+"','"+data.getPost()+"',");
	sb.append("'"+data.getAddr1()+"','"+data.getAddr2()+"','"+data.getCardno()+"',");
	sb.append("'"+data.getJob()+"','"+data.getPicture()+"',");
	sb.append(" '"+data.getPassword()+"','"+Inputdate+"')");
	String sql = sb.toString();
	try {
		cn = db.getConnection();
		ps = cn.prepareStatement(sql);
		ps.execute();
		insert = true;
		cn.close();
		ps.close();
	} catch (Exception e) {
		System.out.println("error:"+e.getMessage());
	}
	return insert;
	}

	@Override
	public ArrayList<Member> selectAll() {
		ArrayList<Member> list = new ArrayList<Member>();
		Member data = null;
		String sql = "Select * from member";
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				data = new Member();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
				data.setName(rs.getString("name"));
				data.setPhone1(rs.getString("phone1"));
				data.setPhone2(rs.getString("phone2"));
				data.setPhone3(rs.getString("phone3"));
				data.setPost(rs.getString("post"));
				data.setAddr1(rs.getString("addr1"));
				data.setAddr2(rs.getString("addr2"));
				data.setCardno(rs.getString("cardno"));
				data.setJob(rs.getString("job"));
				data.setPicture(rs.getString("picture"));
				data.setInputdate(rs.getString("inputdate"));
				list.add(data);
			}
		}
	 catch (Exception e) {
		 System.out.println("error :"+e.getMessage());
	 }
	return list;	
	}
	@Override
	public boolean findId(String id) {
		String sql = "Select id from member where id='"+id+"'";
		boolean findid=false;
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				findid=true;
			}	
			cn.close();
			ps.close();
			rs.close();
		}
	 catch (Exception e) {
		System.out.println("error :"+e.getMessage());
	}
		return findid;
	}

	@Override
	public ArrayList<Member> selectFind(String find) {
		ArrayList<Member> list = new ArrayList<Member>();
		Member data = null;
		String sql = "Select * from member where id like '%"+find+"%' OR name like '%"+find+"%'";
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				data = new Member();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
				data.setName(rs.getString("name"));
				data.setPhone1(rs.getString("phone1"));
				data.setPhone2(rs.getString("phone2"));
				data.setPhone3(rs.getString("phone3"));
				data.setPost(rs.getString("post"));
				data.setAddr1(rs.getString("addr1"));
				data.setAddr2(rs.getString("addr2"));
				data.setCardno(rs.getString("cardno"));
				data.setJob(rs.getString("job"));
				data.setPicture(rs.getString("picture"));
				data.setInputdate(rs.getString("inputdate"));
				list.add(data);
			}
		}
	 catch (Exception e) {
		 System.out.println("error :"+e.getMessage());
	 }
		return list;
	
	}

	@Override
	public Member selectOnerow(String id) {
		String sql = "select * from member where id = '"+id+"' ";
		Member data =null;
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				data = new Member();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
				data.setName(rs.getString("name"));
				data.setPhone1(rs.getString("phone1"));
				data.setPhone2(rs.getString("phone2"));
				data.setPhone3(rs.getString("phone3"));
				data.setPost(rs.getString("post"));
				data.setAddr1(rs.getString("addr1"));
				data.setAddr2(rs.getString("addr2"));
				data.setCardno(rs.getString("cardno"));
				data.setJob(rs.getString("job"));
				data.setPicture(rs.getString("picture"));
				data.setInputdate(rs.getString("inputdate"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
}


