package kr.ac.itschool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class stuButtonlistener implements ActionListener {
	JFrame frame,studentframe;
	JTextField code,name,idcard,postno,addr1,addr2,age,stusearchfield;
	JComboBox professor,dept;
	DefaultTableModel model;
	JTable stutable;
	Member member = new Member();
	ArrayList<Member> list = new ArrayList<Member>();
	public stuButtonlistener(JFrame frame, JFrame studentframe, JTextField code, JTextField name, JTextField idcard,
			JTextField postno, JTextField addr1, JTextField addr2, JComboBox professor, JComboBox dept,
			JTextField age, DefaultTableModel model, JTextField stusearchfield, JTable stutable) {
		this.frame = frame;
		this.studentframe = studentframe;
		this.code = code;
		this.name = name;
		this.idcard = idcard;
		this.postno = postno;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.professor = professor;
		this.dept = dept;
		this.age = age;
		this.model = model;
		this.stusearchfield = stusearchfield;
		this.stutable = stutable;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		member.setCode(code.getText());
		member.setName(name.getText());
		member.setIdcard(idcard.getText());
		member.setPostno(postno.getText());
		member.setAddr1(addr1.getText());
		member.setAddr2(addr2.getText());
		member.setProname((String) professor.getSelectedItem());
		member.setDeptname((String) dept.getSelectedItem());
		member.setAge(age.getText());
		String textname = e.getActionCommand();
		DaoService service = new DaoService();
		member.setProfessor(service.professorcode(member.getProname()));
		member.setDept(service.deptcode(member.getDeptname()));
		if(textname.equals("home")){
			service.gohome(frame, studentframe);
		}
		if(textname.equals("입력")){
			String codetext = code.getText();
			String message = "";
			boolean codecheck = service.codechk(codetext);
			if(codecheck){
				message += "코드가 중복입니다. \n\n";
			}
			if(code.getText().equals("")||code.getText().equals(null)){
				message += "코드를 입력해주세요. \n\n";
			}
			if(!(message.equals(""))){
				JOptionPane.showMessageDialog(code, message);
				return;
			}
			boolean insertchk = service.insertbutton(member);
			if(insertchk){
				String arr[] = {"","","",""};
				arr[0] = code.getText();
				arr[1] = (String) dept.getSelectedItem();
				arr[2] = name.getText();
				arr[3] = (String) professor.getSelectedItem();
				model.addRow(arr);
				JOptionPane.showMessageDialog(code, "입력완료 !");
			}
			screenclear();
		}
		if(textname.equals("검색")){
			model.setRowCount(0);
			if(stusearchfield.getText().equals("")){
				list = service.searchbutton();
			} else {
				list = service.search(stusearchfield);
			}
			String arr[] = {"","","",""};
			for( Member list1 : list){
				arr[0] = list1.getCode();
				arr[1] = service.deptname(list1.getDept());
				arr[2] = list1.getName();
				arr[3] = service.professorname(list1.getProfessor());
				model.addRow(arr);
			}
			stusearchfield.setText("");
			screenclear();
		}
		if(textname.equals("취소")){
			screenclear();
			model.setRowCount(0);
		}
		if(textname.equals("수정")){
			if(code.getText().equals("")){
				JOptionPane.showMessageDialog(code, "항목을 선택하세요");
				return;
			}
			 boolean updatechk = service.updatebutton(member);
			 if(!(member.getCode().equals(model.getValueAt(stutable.getSelectedRow(), 0)))){
				 JOptionPane.showMessageDialog(code, "code는 바꿀수없습니다.");
				 code.setText(member.getCode());
				 return;
			 }
			 if(updatechk){
				 model.setValueAt(member.getCode(),stutable.getSelectedRow(), 0);
				 model.setValueAt(member.getDeptname(),stutable.getSelectedRow(), 1);
				 model.setValueAt(member.getName(),stutable.getSelectedRow(), 2);
				 model.setValueAt(member.getProname(),stutable.getSelectedRow(), 3);
				 JOptionPane.showMessageDialog(code, "수정완료!");
				 screenclear();
			 }
		}
		
	}
	
	void screenclear() {
		code.setText("");
		name.setText("");
		idcard.setText("");
		postno.setText("");
		addr1.setText("");
		addr2.setText("");
		age.setText("");
	}

}
