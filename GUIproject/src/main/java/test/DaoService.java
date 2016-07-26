package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class DaoService implements MemberDao{
	Member member = new Member();
	DBConnectionManager db = new DBConnectionManager();
	Connection cn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public boolean insertpack(Member member)  {
		StringBuilder sb = new StringBuilder();
			boolean insertchk = false;
			sb.append("insert into customer (code,tradename,officephone1,officephone2,officephone3,ceo,post,");
			sb.append("addr1,addr2,business,event,chargename,phone1,phone2,phone3) values( ");
			sb.append(" '"+member.getCode()+"','"+member.getTradename()+"','"+member.getOfficephone1()+"','"+member.getOfficephone2()+"',");
			sb.append(" '"+member.getOfficephone3()+"','"+member.getCeo()+"','"+member.getPost()+"','"+member.getAddr1()+"','"+member.getAddr2()+"',");
			sb.append(" '"+member.getBusiness()+"','"+member.getEvent()+"','"+member.getChargename()+"','"+member.getBox()+"','"+member.getPhone2()+"',");
			sb.append(" '"+member.getPhone3()+"') ");
		try {

			insertchk = true;
			String sql = sb.toString();
				cn = db.getConnection();
				ps = cn.prepareStatement(sql);
				ps.execute();
				cn.close();
				ps.close();
				rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return insertchk;
	}

	@Override
	public ArrayList<Member> searchall() {
		
		ArrayList<Member> list = new ArrayList<Member>();
		String sql = "select * from customer ";
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				member = new Member();
				member.setCode(rs.getString("code"));
				member.setTradename(rs.getString("tradename"));
				member.setOfficephone1(rs.getString("officephone1"));
				member.setOfficephone2(rs.getString("officephone2"));
				member.setOfficephone3(rs.getString("officephone3"));
				member.setBox(rs.getString("phone1"));
				member.setPhone2(rs.getString("phone2"));
				member.setPhone3(rs.getString("phone3"));
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

	public ArrayList<Member> search(String searchchk) {
		
		ArrayList<Member> list = new ArrayList<Member>();
		String sql = "select * from customer where code = '"+searchchk+"' or tradename = '"+searchchk+"' ";
		
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				member = new Member();
				member.setCode(rs.getString("code"));
				member.setTradename(rs.getString("tradename"));
				member.setOfficephone1(rs.getString("officephone1"));
				member.setOfficephone2(rs.getString("officephone2"));
				member.setOfficephone3(rs.getString("officephone3"));
				member.setBox(rs.getString("phone1"));
				member.setPhone2(rs.getString("phone2"));
				member.setPhone3(rs.getString("phone3"));
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
	public boolean codechk(String codename) {
		String sql = "select code from customer where code = '"+codename+"' ";
		boolean codechk = false;
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				codechk = true;
			}
			cn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return codechk;
		
	}

	@Override
	public Member mouseclicked(Object selectrow) {
		
		String sql = "select * from customer where code = '"+selectrow+"' ";
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
			member.setCode(rs.getString("code"));
			member.setTradename(rs.getString("tradename"));
			member.setOfficephone1(rs.getString("officephone1"));
			member.setOfficephone2(rs.getString("officephone2"));
			member.setOfficephone3(rs.getString("officephone3"));
			member.setCeo(rs.getString("ceo"));
			member.setPost(rs.getString("post"));
			member.setAddr1(rs.getString("addr1"));
			member.setAddr2(rs.getString("addr2"));
			member.setBusiness(rs.getString("business"));
			member.setEvent(rs.getString("event"));
			member.setChargename(rs.getString("chargename"));
			member.setBox(rs.getString("phone1"));
			member.setPhone2(rs.getString("phone2"));
			member.setPhone3(rs.getString("phone3"));
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
	public boolean updatepack(Member member) {
		StringBuilder sb = new StringBuilder();
		boolean updatechk = false;
		sb.append("update customer set tradename = '"+member.getTradename()+"',");
		sb.append( " officephone1='"+member.getOfficephone1()+"', officephone2 = '"+member.getOfficephone2()+"',");
		sb.append(" officephone3='"+member.getOfficephone3()+"', ceo = '"+member.getCeo()+"', post = '"+member.getPost()+"',");
		sb.append(" addr1='"+member.getAddr1()+"', addr2 = '"+member.getAddr2()+"', business = '"+member.getBusiness()+"',");
		sb.append(" event='"+member.getEvent()+"', chargename = '"+member.getChargename()+"', phone1 = '"+member.getBox()+"',");
		sb.append(" phone2='"+member.getPhone2()+"', phone3 = '"+member.getPhone3()+"' where code = '"+member.getCode()+"' ");
		String sql = sb.toString();
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			ps.execute();
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
	public void removerow(Object selectrow) {
		String sql = "delete from customer where code = '"+selectrow+"' ";
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			ps.execute();
			cn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
	

