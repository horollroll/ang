package kr.ac.itschool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class proButtonlistener implements ActionListener {
	JFrame frame,proframe;
	JTextField procode,proname,prosearchfield;
	JTable protable;
	DefaultTableModel promodel;
	Member member = new Member();
	ArrayList<Member> list = new ArrayList<Member>();
	public proButtonlistener(JFrame frame, JFrame proframe, JTextField procode, JTextField proname, JTable protable, DefaultTableModel promodel, JTextField prosearchfield) {
		this.frame =frame;
		this.proframe = proframe;
		this.procode = procode;
		this.proname = proname;
		this.protable = protable;
		this.promodel = promodel;
		this.prosearchfield = prosearchfield;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		member.setProcode(procode.getText());
		member.setProname(proname.getText());
		String textname = e.getActionCommand();
		DaoService service = new DaoService();
		if(textname.equals("home")){
			service.gohome(frame, proframe);
		}
		if(textname.equals("입력")){
			String codetext = procode.getText();
			boolean codecheck = service.procodechk(codetext);
			String message = "";
			if(codecheck){
				message += "코드가 중복입니다. \n\n";
			}
			if(procode.getText().equals("")||procode.getText().equals(null)){
				message += "코드를 입력해주세요. \n\n";
			}
			if(!(message.equals(""))){
				JOptionPane.showMessageDialog(procode, message);
				return;
			}
			boolean insertchk = service.proinsertbutton(member);
			if(insertchk){
				String arr[] = {"",""};
				arr[0] = procode.getText();
				arr[1] = proname.getText();
				promodel.addRow(arr);
				JOptionPane.showMessageDialog(procode, "입력완료 !");
			}
			screenclear();
		}
		if(textname.equals("검색")){
			promodel.setRowCount(0);
			if(prosearchfield.getText().equals("")){
				list = service.prosearchbutton();
			} else {
				list = service.prosearch(prosearchfield);
			}
			String arr[] = {"",""};
			for( Member list1 : list){
				arr[0] = list1.getProcode();
				arr[1] = list1.getProname();
				promodel.addRow(arr);
			}
			prosearchfield.setText("");
			screenclear();
		}
		if(textname.equals("취소")){
			screenclear();
			promodel.setRowCount(0);
		}
		if(textname.equals("수정")){
			if(procode.getText().equals("")){
				JOptionPane.showMessageDialog(procode, "항목을 선택하세요");
				return;
			}
			 boolean updatechk = service.proupdatebutton(member);
			 if(!(member.getProcode().equals(promodel.getValueAt(protable.getSelectedRow(), 0)))){
				 JOptionPane.showMessageDialog(procode, "code는 바꿀수없습니다.");
				 procode.setText(member.getProcode());
				 return;
			 }
			 if(updatechk){
				 promodel.setValueAt(member.getProcode(),protable.getSelectedRow(), 0);
				 promodel.setValueAt(member.getProname(),protable.getSelectedRow(), 1);
				 JOptionPane.showMessageDialog(procode, "수정완료!");
				 screenclear();
			 }
		}
	}
	void screenclear() {
		procode.setText("");
		proname.setText("");
	
	}}
