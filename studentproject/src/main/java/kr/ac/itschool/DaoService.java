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
				member.setProfessor(rs.getString("professor"));
				list.add(member);
			}
			cn.close();
		  	ps.close();
		  	rs.close();
		} catch (Exception e) {
			System.out.println("서치에러 :"+e.getMessage());
		}
		return list;
	}

	@Override
	public ArrayList<Member> search(JTextField stusearchfield) {
		ArrayList<Member> list = new ArrayList<Member>();
		String sql = "select * from student where code = '"+stusearchfield.getText()+"'or name ='"+stusearchfield.getText()+"' ";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				member = new Member();
				member.setCode(rs.getString("code"));
				member.setDept(rs.getString("dept"));
				member.setName(rs.getString("name"));
				member.setProfessor(rs.getString("professor"));
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
	public boolean updatebutton(Member member) {
		boolean updatechk = false;
		StringBuffer sb = new StringBuffer();
		sb.append("update student set  name = '"+member.getName()+"',idcard = '"+member.getIdcard()+"',postno = '"+member.getPostno()+"',");
		sb.append("addr1 ='"+member.getAddr1()+"', addr2 = '"+member.getAddr2()+"',professor = '"+member.getProfessor()+"',");
		sb.append("dept ='"+member.getDept()+"', age = '"+member.getAge()+"' where code = '"+member.getCode()+"' ");
		String sql = sb.toString();
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			updatechk = true;
			cn.close();
		  	ps.close();
		  	rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return updatechk;
	}

	@Override
	public Member selectrow(String select) {
		String sql = "select * from student where code = '"+select+"' ";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				member.setCode(rs.getString("code"));
				member.setName(rs.getString("name"));
				member.setIdcard(rs.getString("idcard"));
				member.setPostno(rs.getString("postno"));
				member.setAddr1(rs.getString("addr1"));
				member.setAddr2(rs.getString("addr2"));
				member.setProfessor(rs.getString("professor"));
				member.setDept(rs.getString("dept"));
				member.setAge(rs.getString("age"));
				
			}
			cn.close();
		  	ps.close();
		  	rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return member;
		
	}

	@Override
	public boolean deleterow(String cod) {
		boolean deletechk = false;
		String sql = "delete from student where code = '"+cod+"' ";
		try {
			
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			deletechk = true;
			cn.close();
		  	ps.close();
		  	rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return deletechk;
	}

	@Override
	public boolean codechk(String codetext) {
		boolean codecheck = false;
		String sql = "select * from student where code = '"+codetext+"' ";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				codecheck = true;
			}
			cn.close();
		  	ps.close();
		  	rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return codecheck;
	}

	@Override
	public boolean deptinsertbutton(Member member) {
		StringBuffer sb = new StringBuffer();
		sb.append("insert into dept (code,name) values('"+member.getDeptcode()+"','"+member.getDeptname()+"') ");
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
	public boolean deptcodechk(String codetext) {
		boolean codecheck = false;
		String sql = "select * from dept where code = '"+codetext+"' ";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				codecheck = true;
			}
			cn.close();
		  	ps.close();
		  	rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return codecheck;
	}

	@Override
	public ArrayList<Member> deptsearchbutton() {
		ArrayList<Member> list = new ArrayList<Member>();
		String sql = "select * from dept";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				member = new Member();
				member.setDeptcode(rs.getString("code"));
				member.setDeptname(rs.getString("name"));
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
	public ArrayList<Member> deptsearch(JTextField deptsearchfield) {
		ArrayList<Member> list = new ArrayList<Member>();
		String sql = "select * from dept where code = '"+deptsearchfield.getText()+"' or name ='"+deptsearchfield.getText()+"' ";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				member = new Member();
				member.setDeptcode(rs.getString("code"));
				member.setDeptname(rs.getString("name"));
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
	public boolean deptupdatebutton(Member member) {
		boolean updatechk = false;
		StringBuffer sb = new StringBuffer();
		sb.append("update dept set  name = '"+member.getDeptname()+"' where code = '"+member.getDeptcode()+"' ");
		String sql = sb.toString();
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			updatechk = true;
			cn.close();
		  	ps.close();
		  	rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return updatechk;
	}

	@Override
	public Member deptselectrow(String select) {
		String sql = "select * from dept where code = '"+select+"' ";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				member.setDeptcode(rs.getString("code"));
				member.setDeptname(rs.getString("name"));	
			}
			cn.close();
		  	ps.close();
		  	rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return member;
	}

	@Override
	public boolean deptdeleterow(String cod) {
		boolean deletechk = false;
		String sql = "delete from dept where code = '"+cod+"' ";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			deletechk = true;
			cn.close();
		  	ps.close();
		  	rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return deletechk;
	}
	@Override
	public boolean proinsertbutton(Member member) {
		StringBuffer sb = new StringBuffer();
		sb.append("insert into professor (code,name) values('"+member.getProcode()+"','"+member.getProname()+"') ");
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
	public boolean procodechk(String codetext) {
		boolean codecheck = false;
		String sql = "select * from professor where code = '"+codetext+"' ";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				codecheck = true;
			}
			cn.close();
		  	ps.close();
		  	rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return codecheck;
	}

	@Override
	public ArrayList<Member> prosearchbutton() {
		ArrayList<Member> list = new ArrayList<Member>();
		String sql = "select * from professor";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				member = new Member();
				member.setProcode(rs.getString("code"));
				member.setProname(rs.getString("name"));
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
	public ArrayList<Member> prosearch(JTextField prosearchfield) {
		ArrayList<Member> list = new ArrayList<Member>();
		String sql = "select * from professor where code = '"+prosearchfield.getText()+"' or name = '"+prosearchfield.getText()+"' ";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				member = new Member();
				member.setProcode(rs.getString("code"));
				member.setProname(rs.getString("name"));
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
	public boolean proupdatebutton(Member member) {
		boolean updatechk = false;
		StringBuffer sb = new StringBuffer();
		sb.append("update professor set  name = '"+member.getProname()+"' where code = '"+member.getProcode()+"' ");
		String sql = sb.toString();
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			updatechk = true;
			cn.close();
		  	ps.close();
		  	rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return updatechk;
	}

	@Override
	public Member proselectrow(String select) {
		String sql = "select * from professor where code = '"+select+"' ";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				member.setProcode(rs.getString("code"));
				member.setProname(rs.getString("name"));	
			}
			cn.close();
		  	ps.close();
		  	rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return member;
	}

	@Override
	public boolean prodeleterow(String cod) {
		boolean deletechk = false;
		String sql = "delete from professor where code = '"+cod+"' ";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			deletechk = true;
			cn.close();
		  	ps.close();
		  	rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return deletechk;
	}

	@Override
	public String professorcode(String procode) {
		String result = null;
		String sql = "select * from professor where name = '"+procode+"' ";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				result = rs.getString("code");
			}
			cn.close();
		  	ps.close();
		  	rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return result;
		
	}

	@Override
	public String deptname(String deptcode) {
		String result = null;
		String sql = "select * from dept where code = '"+deptcode+"' ";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
			result = rs.getString("name");
			}
			cn.close();
		  	ps.close();
		  	rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
		
	}
	@Override
	public String professorname(String procode) {
		String result = null;
		String sql = "select * from professor where code = '"+procode+"' ";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				result = rs.getString("name");
			}
			cn.close();
		  	ps.close();
		  	rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return result;
		
	}
	@Override
	public String deptcode(String deptcode) {
		String result = null;
		String sql = "select * from dept where name = '"+deptcode+"' ";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
			result = rs.getString("code");
			}
			cn.close();
		  	ps.close();
		  	rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
		
	}
	
	@Override
	public ArrayList<String> procombobox(String[] combobox) {
		ArrayList<String>list =  new ArrayList<String>();
		for(int i=0; i<combobox.length; i++){
			
		String sql = "select * from professor where code = '"+combobox[i]+"' ";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(rs.getString("name"));
			}
			cn.close();
		  	ps.close();
		  	rs.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		}
		return list;
		
		
	}

	@Override
	public ArrayList<String> deptcombobox(String[] combobox) {
		ArrayList<String>list =  new ArrayList<String>();
		for(int i=0; i<combobox.length; i++){
		String sql = "select * from dept where code = '"+combobox[i]+"' ";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				
				list.add(rs.getString("name"));
			}
			cn.close();
		  	ps.close();
		  	rs.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		}

		return list;
		
		
	}

	@Override
	public boolean deptfind(String code) {
		boolean find = false;
		String sql = "select * from student s,dept d,professor p where s.dept=d.code and s.professor=p.code and s.dept = '"+code+"' ";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				find = true;
			}
			cn.close();
		  	ps.close();
		  	rs.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return find;
	}

	@Override
	public boolean profind(String code) {
		boolean find = false;
		String sql = "select * from student s,dept d,professor p,register r where s.dept=d.code and s.professor=p.code and r.studentcode=s.code and r.professor='"+code+"'or s.professor ='"+code+"' ";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				find = true;
			}
			cn.close();
		  	ps.close();
		  	rs.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return find;
	}

	@Override
	public boolean studentfind(String code) {
		boolean find = false;
		String sql = "select * from student s,register r where s.code=r.studentcode and r.studentcode ='"+code+"' ";
		try {
			cn =db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				find = true;
			}
			cn.close();
		  	ps.close();
		  	rs.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return find;
	}
	
}
