package kr.ac.itschool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class depButtonlistener implements ActionListener {
	JFrame frame,deptframe;
	JTextField deptcode,deptname,deptsearchfield;
	JTable depttable;
	DefaultTableModel deptmodel;
	Member member = new Member();
	ArrayList<Member> list = new ArrayList<Member>();
	public depButtonlistener(JFrame frame, JFrame deptframe, JTextField deptcode, JTextField deptname, JTable depttable, DefaultTableModel deptmodel, JTextField deptsearchfield) {
		this.frame =frame;
		this.deptframe = deptframe;
		this.deptcode = deptcode;
		this.deptname = deptname;
		this.depttable = depttable;
		this.deptmodel = deptmodel;
		this.deptsearchfield = deptsearchfield;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		member.setDeptcode(deptcode.getText());
		member.setDeptname(deptname.getText());
		String textname = e.getActionCommand();
		DaoService service = new DaoService();
		if(textname.equals("home")){
			service.gohome(frame, deptframe);
		}
		if(textname.equals("입력")){
			String codetext = deptcode.getText();
			boolean codecheck = service.deptcodechk(codetext);
			String message = "";
			if(codecheck){
				message += "코드가 중복입니다. \n\n";
			}
			if(deptcode.getText().equals("")||deptcode.getText().equals(null)){
				message += "코드를 입력해주세요. \n\n";
			}
			if(!(message.equals(""))){
				JOptionPane.showMessageDialog(deptcode, message);
				return;
			}
			boolean insertchk = service.deptinsertbutton(member);
			if(insertchk){
				String arr[] = {"",""};
				arr[0] = deptcode.getText();
				arr[1] = deptname.getText();
				deptmodel.addRow(arr);
				JOptionPane.showMessageDialog(deptcode, "입력완료 !");
			}
			screenclear();
		}
		if(textname.equals("검색")){
			deptmodel.setRowCount(0);
			if(deptsearchfield.getText().equals("")){
				list = service.deptsearchbutton();
			} else {
				list = service.deptsearch(deptsearchfield);
			}
			String arr[] = {"",""};
			for( Member list1 : list){
				arr[0] = list1.getDeptcode();
				arr[1] = list1.getDeptname();
				deptmodel.addRow(arr);
			}
			deptsearchfield.setText("");
			screenclear();
		}
		if(textname.equals("취소")){
			screenclear();
			deptmodel.setRowCount(0);
		}
		if(textname.equals("수정")){
			if(deptcode.getText().equals("")){
				JOptionPane.showMessageDialog(deptcode, "항목을 선택하세요");
				return;
			}
			 boolean updatechk = service.deptupdatebutton(member);
			 if(!(member.getDeptcode().equals(deptmodel.getValueAt(depttable.getSelectedRow(), 0)))){
				 JOptionPane.showMessageDialog(deptcode, "code는 바꿀수없습니다.");
				 deptcode.setText(member.getDeptcode());
				 return;
			 }
			 if(updatechk){
				 deptmodel.setValueAt(member.getDeptcode(),depttable.getSelectedRow(), 0);
				 deptmodel.setValueAt(member.getDeptname(),depttable.getSelectedRow(), 1);
				 JOptionPane.showMessageDialog(deptcode, "수정완료!");
				 screenclear();
			 }
		}
	}
	void screenclear() {
		deptcode.setText("");
		deptname.setText("");
	
	}
}
