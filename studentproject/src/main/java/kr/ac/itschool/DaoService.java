package kr.ac.itschool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class DaoService implements MemberDao{
	DBConnectionManager db = new DBConnectionManager();
	Connection cn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Member member = new Member();
	@Override
	public void gohome(JFrame mainframe, JFrame serveframe) {
		mainframe.setVisible(true);
		serveframe.setVisible(false);
		return;
	}

	@Override
	public boolean insertbutton(Member member) {
		StringBuffer sb = new StringBuffer();
		sb.append("insert into student (code,name,idcard,postno,addr1,addr2,professor,dept,age) values('"+member.getCode()+"',");
		sb.append("'"+member.getName()+"','"+member.getIdcard()+"','"+member.getPostno()+"','"+member.getAddr1()+"',");
		sb.append("'"+member.getAddr2()+"','"+member.getProfessor()+"','"+member.getDept()+"','"+member.getAge()+"')");
		String sql = sb.toString();
		boolean insertchk = false;
		try {
			cn= db.getConnection();
			ps = cn.prepareStatement(sql);
		  	ps.execute();
		  	insertchk = true;
		  	cn.close();
		  	ps.close();
		  	rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return insertchk;
	}

	@Override
	public ArrayList<Member> searchbutton() {
		ArrayList<Member> list = new ArrayList<Member>();
		String sql = "select * from student";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				member = new Member();
				member.setCode(rs.getString("code"));
				member.setDept(rs.getString("dept"));
				member.setName(rs.getString("name"));
				member.setProfessor(rs.getString("dept"));
				list.add(member);
			}
			cn.close();
		  	ps.close();
		  	rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	@Override
	public ArrayList<Member> search(JTextField stusearchfield) {
		ArrayList<Member> list = new ArrayList<Member>();
		String sql = "select * from student where code = '"+stusearchfield.getText()+"' ";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				member = new Member();
				member.setCode(rs.getString("code"));
				member.setDept(rs.getString("dept"));
				member.setName(rs.getString("name"));
				member.setProfessor(rs.getString("dept"));
				list.add(member);
			}
			cn.close();
		  	ps.close();
		  	rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	@Override
	public void updatebutton() {
		String sql = "update student set ";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			cn.close();
		  	ps.close();
		  	rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void selectrow(String select) {
		String sql = "select * from student where code = '"+select+"' ";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				
			}
			cn.close();
		  	ps.close();
		  	rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
