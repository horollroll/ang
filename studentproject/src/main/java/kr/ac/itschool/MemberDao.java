package kr.ac.itschool;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

public interface MemberDao {
	void gohome(JFrame mainframe,JFrame serveframe);
	boolean insertbutton(Member member);
	ArrayList<Member> searchbutton();
	ArrayList<Member> search(JTextField stusearchfield);
	void updatebutton();
	void selectrow(String select);
}
