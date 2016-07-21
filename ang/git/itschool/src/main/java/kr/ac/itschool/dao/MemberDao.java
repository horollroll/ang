package kr.ac.itschool.dao;

import java.util.ArrayList;

import kr.ac.itschool.entities.Member;

public interface MemberDao {
	public boolean insertRow(Member data);
	public boolean findId(String id);
	public Member selectOnerow(String id);
	public ArrayList<Member> selectAll();
	public ArrayList<Member> selectFind(String find);
	}