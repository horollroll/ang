package test;

import java.util.ArrayList;

public interface MemberDao{


	boolean insertpack(Member member);
	ArrayList<Member> searchall();
	ArrayList<Member> search(String searchchk);
	boolean codechk(String codename);
	Member mouseclicked(Object selectrow);
	boolean updatepack(Member member);
	void removerow(Object selectrow);
}
