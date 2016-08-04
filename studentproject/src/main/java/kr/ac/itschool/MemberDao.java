package kr.ac.itschool;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

public interface MemberDao {
	void gohome(JFrame mainframe,JFrame serveframe);
	String professorcode(String procode);
	String deptcode(String deptcode);
	boolean insertbutton(Member member);
	ArrayList<Member> searchbutton();
	ArrayList<Member> search(JTextField stusearchfield);
	boolean updatebutton(Member member);
	Member selectrow(String select);
	boolean deleterow(String cod);
	boolean codechk(String codetext);
	boolean deptinsertbutton(Member member);
	boolean deptcodechk(String codetext);
	ArrayList<Member> deptsearchbutton();
	ArrayList<Member> deptsearch(JTextField deptsearchfield);
	boolean deptupdatebutton(Member member);
	Member deptselectrow(String select);
	boolean deptdeleterow(String cod);
	boolean proinsertbutton(Member member);
	boolean procodechk(String codetext);
	ArrayList<Member> prosearchbutton();
	ArrayList<Member> prosearch(JTextField deptsearchfield);
	boolean proupdatebutton(Member member);
	Member proselectrow(String select);
	boolean prodeleterow(String cod);
	ArrayList<String> procombobox(String[] combobox);
	ArrayList<String> deptcombobox(String[] combobox);
	String deptname(String deptcode);
	String professorname(String procode);
	boolean deptfind(String code);
	boolean profind(String code);
	boolean studentfind(String code);
}
