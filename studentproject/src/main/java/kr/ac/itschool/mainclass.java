package kr.ac.itschool;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class mainclass {

	public static void main(String[] args) {
		JFrame frame = new JFrame("메인");
		frame.setPreferredSize(new Dimension(300, 400));
		frame.setLocation(600,250);
		Container contentpane = frame.getContentPane();
		JPanel mainpanel = new JPanel();
		mainpanel.setBackground(Color.LIGHT_GRAY);
		JLabel main = new JLabel("Main");
		main.setHorizontalAlignment(SwingConstants.CENTER);
		JButton deptbutton = new JButton("학과등록");
		JButton professbutton = new JButton("교수등록");
		JButton studentbutton = new JButton("학생등록");
		mainpanel.add(main);
		mainpanel.add(deptbutton);
		mainpanel.add(professbutton);
		mainpanel.add(studentbutton);
		GridLayout maingrid = new GridLayout(4, 1);
		mainpanel.setLayout(maingrid);
		contentpane.add(mainpanel, BorderLayout.CENTER);
		
		JFrame studentframe = new JFrame("학생");
		studentframe.setPreferredSize(new Dimension(800, 400));
		studentframe.setLocation(400, 250);
		Container stucontentpane = studentframe.getContentPane();
		JPanel studentpanel = new JPanel();
		JLabel codelabel = new JLabel("학번");
		JTextField code = new JTextField();
		JLabel namelabel = new JLabel("이름");
		JTextField name = new JTextField();
		JLabel idcardlabel = new JLabel("카드번호");
		JTextField idcard = new JTextField();
		JLabel postnolabel = new JLabel("우편번호");
		JTextField postno = new JTextField();
		JLabel addr1label = new JLabel("주소");
		JTextField addr1 = new JTextField();
		JLabel addr2label = new JLabel();
		JTextField addr2 = new JTextField();
		JLabel professorlabel = new JLabel("지도교수");
		String professorboxarr[] = { "3001" , "3002" , "3003"} ;
		JComboBox professor = new JComboBox(professorboxarr);
		JLabel deptlabel = new JLabel("학과");
		String deptboxarr[] = { "10001","10002","10003"};
		JComboBox dept = new JComboBox(deptboxarr);
		JLabel agelabel = new JLabel("나이");
		JTextField age = new JTextField();
		studentpanel.add(codelabel);
		studentpanel.add(code);
		studentpanel.add(namelabel);
		studentpanel.add(name);
		studentpanel.add(idcardlabel);
		studentpanel.add(idcard);
		studentpanel.add(postnolabel);
		studentpanel.add(postno);
		studentpanel.add(addr1label);
		studentpanel.add(addr1);
		studentpanel.add(addr2label);
		studentpanel.add(addr2);
		studentpanel.add(professorlabel);
		studentpanel.add(professor);
		studentpanel.add(deptlabel);
		studentpanel.add(dept);
		studentpanel.add(agelabel);
		studentpanel.add(age);
		GridLayout studentgrid = new GridLayout(9, 2);
		studentpanel.setLayout(studentgrid);
		stucontentpane.add(studentpanel, BorderLayout.CENTER);
		
		String stucode[] = {"학번","학과","이름","지도교수"};
		DefaultTableModel model = new DefaultTableModel(stucode, 0);
		JTable stutable = new JTable(model);
		JScrollPane studenttable = new JScrollPane(stutable);
		stucontentpane.add(studenttable,BorderLayout.EAST);
		
		JPanel stubutton = new JPanel();
		JButton stuinsert = new JButton("입력");
		JButton stuupdate = new JButton("수정");
		JButton studelete = new JButton("삭제");
		JTextField stusearchfield = new JTextField(6);
		JButton stusearch = new JButton("검색");
		JButton stucancel = new JButton("취소");
		JButton stuhome = new JButton("home");
		stubutton.add(stuinsert);
		stubutton.add(stuupdate);
		stubutton.add(studelete);
		stubutton.add(stusearchfield);
		stubutton.add(stusearch);
		stubutton.add(stucancel);
		stubutton.add(stuhome);
		stucontentpane.add(stubutton,BorderLayout.SOUTH);
		
		JFrame deptframe = new JFrame("학과");
		deptframe.setPreferredSize(new Dimension(800, 200));
		deptframe.setLocation(400, 250);
		Container deptcontentpane = deptframe.getContentPane();
		JPanel deptpanel = new JPanel();
		JLabel deptcodelabel = new JLabel("코드");
		JTextField deptcode = new JTextField(2);
		JLabel deptnamelabel = new JLabel("학과명");
		JTextField deptname = new JTextField(2);
		deptpanel.add(deptcodelabel);
		deptpanel.add(deptcode);
		deptpanel.add(deptnamelabel);
		deptpanel.add(deptname);
	
		GridLayout deptgrid = new GridLayout(2, 2);
		deptpanel.setLayout(deptgrid);
		deptcontentpane.add(deptpanel, BorderLayout.CENTER);
		
		String deptarr[] = {"코드","학과명"};
		DefaultTableModel deptmodel = new DefaultTableModel(deptarr, 0);
		JTable depttable = new JTable(deptmodel);
		JScrollPane deptscroll = new JScrollPane(depttable);
		deptcontentpane.add(deptscroll,BorderLayout.EAST);
		
		JPanel debutton = new JPanel();
		JButton deptinsert = new JButton("입력");
		JButton deptupdate = new JButton("수정");
		JButton deptdelete = new JButton("삭제");
		JTextField deptsearchfield = new JTextField(6);
		JButton deptsearch = new JButton("검색");
		JButton deptcancel = new JButton("취소");
		JButton depthome = new JButton("home");
		debutton.add(deptinsert);
		debutton.add(deptupdate);
		debutton.add(deptdelete);
		debutton.add(deptsearchfield);
		debutton.add(deptsearch);
		debutton.add(deptcancel);
		debutton.add(depthome);
		deptcontentpane.add(debutton,BorderLayout.SOUTH);
		
		JFrame proframe = new JFrame("교수");
		proframe.setPreferredSize(new Dimension(800, 200));
		proframe.setLocation(400, 250);
		Container procontentpane = proframe.getContentPane();
		JPanel propanel = new JPanel();
		JLabel procodelabel = new JLabel("코드");
		JTextField procode = new JTextField(2);
		JLabel pronamelabel = new JLabel("성명");
		JTextField proname = new JTextField(2);
		propanel.add(procodelabel);
		propanel.add(procode);
		propanel.add(pronamelabel);
		propanel.add(proname);
	
		GridLayout progrid = new GridLayout(2, 2);
		propanel.setLayout(progrid);
		procontentpane.add(propanel, BorderLayout.CENTER);
		
		String proarr[] = {"코드","성명"};
		DefaultTableModel promodel = new DefaultTableModel(proarr, 0);
		JTable protable = new JTable(promodel);
		JScrollPane proscroll = new JScrollPane(protable);
		procontentpane.add(proscroll,BorderLayout.EAST);
		
		JPanel probutton = new JPanel();
		JButton proinsert = new JButton("입력");
		JButton proupdate = new JButton("수정");
		JButton prodelete = new JButton("삭제");
		JTextField prosearchfield = new JTextField(6);
		JButton prosearch = new JButton("검색");
		JButton procancel = new JButton("취소");
		JButton prohome = new JButton("home");
		probutton.add(proinsert);
		probutton.add(proupdate);
		probutton.add(prodelete);
		probutton.add(prosearchfield);
		probutton.add(prosearch);
		probutton.add(procancel);
		probutton.add(prohome);
		procontentpane.add(probutton,BorderLayout.SOUTH);
		
		ActionListener framelistener = new AddButton(frame,studentframe,deptframe,proframe);
		deptbutton.addActionListener(framelistener);
		professbutton.addActionListener(framelistener);
		studentbutton.addActionListener(framelistener);
		
		ActionListener stubuttonlistener = new stuButtonlistener(frame,studentframe,code,name,idcard,postno,addr1,addr2,professor,dept,age,model,stusearchfield);
		stuinsert.addActionListener(stubuttonlistener);
		stuupdate.addActionListener(stubuttonlistener);
		studelete.addActionListener(stubuttonlistener);
		stusearch.addActionListener(stubuttonlistener);
		stucancel.addActionListener(stubuttonlistener);
		stuhome.addActionListener(stubuttonlistener);
		
		ActionListener depbuttonlistener = new depButtonlistener(frame,deptframe,deptcode,deptname);
		deptinsert.addActionListener(depbuttonlistener);
		deptupdate.addActionListener(depbuttonlistener);
		deptdelete.addActionListener(depbuttonlistener);
		deptsearch.addActionListener(depbuttonlistener);
		deptcancel.addActionListener(depbuttonlistener);
		depthome.addActionListener(depbuttonlistener);
		
		ActionListener probuttonlistener = new proButtonlistener(frame,proframe,procode,proname);
		proinsert.addActionListener(probuttonlistener);
		proupdate.addActionListener(probuttonlistener);
		prodelete.addActionListener(probuttonlistener);
		prosearch.addActionListener(probuttonlistener);
		procancel.addActionListener(probuttonlistener);
		prohome.addActionListener(probuttonlistener);
		
		MouseListener mouselistener = new mouselistener(frame,studentframe,code,name,idcard,postno,addr1,addr2,professor,dept,age,model,stusearchfield,stutable);
		stutable.addMouseListener(mouselistener);
		
		frame.pack();
		frame.setVisible(true);
		studentframe.pack();
		studentframe.setVisible(false);
		deptframe.pack();
		deptframe.setVisible(false);
		proframe.pack();
		proframe.setVisible(false);
		
		
	}

}
