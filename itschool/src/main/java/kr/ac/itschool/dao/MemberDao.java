package kr.ac.itschool.dao;

import java.util.ArrayList;

import kr.ac.itschool.entities.Member;

public interface MemberDao {
	public boolean insertRow(Member data);
	public boolean findId(String id);
	public Member selectrowone (String id);
	public ArrayList<Member> selectAll();
	public ArrayList<Member> selectFind(String find);
	public String updateRow(Member data);
	public boolean deleteRow(String id);
	}
