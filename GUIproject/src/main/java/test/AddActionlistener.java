package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AddActionlistener implements ActionListener {
	JTextField  code,tradename,officephone1,officephone2,officephone3,ceo,searchfield;
	JTextField post,addr1,addr2,business,event,chargename,phone1,phone2,phone3;
	JTable table;
	DefaultTableModel tablemodel;
	boolean confirmchk;
	JComboBox<Object> box;
	Member member = new Member();
	DaoService service = new DaoService();
	public AddActionlistener(JTextField code, JTextField tradename, JTextField officephone1, JTextField officephone2,
			JTextField officephone3, JTextField ceo, JTextField post, JTextField addr1, JTextField addr2,
			JTextField business, JTextField event, JTextField chargename, JTextField phone1, JTextField phone2,
			JTextField phone3, JTable table, DefaultTableModel tablemodel, JTextField searchfield, boolean confirmchk, JComboBox<Object> box) {
		this.code =code;
		this.tradename =tradename;
		this.officephone1 =officephone1;
		this.officephone2 =officephone2;
		this.officephone3 =officephone3;
		this.ceo =ceo;
		this.post =post;
		this.addr1 =addr1;
		this.addr2 =addr2;
		this.business =business;
		this.event =event;
		this.chargename =chargename;
		this.phone1 =phone1;
		this.phone2 =phone2;
		this.phone3 =phone3;
		this.table = table;
		this.tablemodel = tablemodel;
		this.searchfield = searchfield;
		this.confirmchk = confirmchk;
		this.box = box;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String textname = e.getActionCommand();
		member.setCode(code.getText());
		member.setTradename(tradename.getText());
		member.setOfficephone1(officephone1.getText());
		member.setOfficephone2(officephone2.getText());
		member.setOfficephone3(officephone3.getText());
		member.setCeo(ceo.getText());
		member.setPost(post.getText());
		member.setAddr1(addr1.getText());
		member.setAddr2(addr2.getText());
		member.setBusiness(business.getText());
		member.setEvent(event.getText());
		member.setChargename(chargename.getText());
		member.setBox((String) box.getSelectedItem());
		member.setPhone2(phone2.getText());
		member.setPhone3(phone3.getText());
		
		
		if(textname.equals("입력")){
			String message =null;
			if(code.getText().equals("")||code.getText().equals(null))
				message += "CODE를 입력해주세요 \n";
			if(tradename.getText().equals("")||tradename.getText().equals(null))
				message += "상호명을 입력해주세요 \n";
			if(!confirmchk)
				message += "중복검사를 눌러주세요 \n";
			System.out.println(message);
			if(message == null){
				JOptionPane.showMessageDialog(code, "입력완료 \n");
			} else {
				JOptionPane.showMessageDialog(code, "입력실패 \n\n"+message);
					return;
			}
			boolean insert = service.insertpack(member);
		   Object row[]={"","","",""};
		   row[0] = code.getText();
		   row[1] = tradename.getText();
		   row[2] = officephone1.getText()+"-"+officephone2.getText()+"-"+officephone3.getText();
		   row[3] = box.getSelectedItem()+"-"+phone2.getText()+"-"+phone3.getText();
			if (insert){
				tablemodel.addRow(row);
			}
			Screenclear();
		}
		if(textname.equals("검색")){
			tablemodel.setRowCount(0);
			String searchchk = searchfield.getText();
			ArrayList<Member> list = new ArrayList<Member>();
			if(searchchk.equals("")){
				 list = service.searchall();
			} else {
				 list = service.search(searchchk);
			}
			Object arr[] ={"","","",""};
			for (Member list1 : list){
				
			arr[0] = list1.getCode();
			arr[1] = list1.getTradename();
			arr[2] = list1.getOfficephone1() +"-"+ list1.getOfficephone2() +"-"+ list1.getOfficephone3();
			arr[3] = list1.getBox() +"-"+ list1.getPhone2() +"-"+ list1.getPhone3();
			tablemodel.addRow(arr);
			}
		}
		if(textname.equals("중복")){
			confirmchk = true;
			if(code.getText().equals("")){
				JOptionPane.showMessageDialog(code, "CODE를 입력해주세요 \n");
				return;
			}
			confirmchk();
		
		}
		if(textname.equals("수정")){
			boolean updatechk= service.updatepack(member);
			if(updatechk){
			JOptionPane.showMessageDialog(code, "수정되었습니다");
			table.setValueAt(code.getText(), table.getSelectedRow(), 0);
			table.setValueAt(tradename.getText(), table.getSelectedRow(), 1);
			table.setValueAt(officephone1.getText()+"-"+officephone2.getText()+"-"+officephone3.getText(), table.getSelectedRow(), 2);
			table.setValueAt(box.getSelectedItem()+"-"+phone2.getText()+"-"+phone3.getText(), table.getSelectedRow(), 3);
			}
		}
		if(textname.equals("취소")){
			tablemodel.setRowCount(0);
			Screenclear();
		}
		
	}
	
	void Screenclear(){
		
		code.setText("");
		tradename.setText("");
		officephone1.setText("");
		officephone2.setText("");
		officephone3.setText("");
		ceo.setText("");
		post.setText("");
		addr1.setText("");
		addr2.setText("");
		business.setText("");
		event.setText("");
		chargename.setText("");
		phone2.setText("");
		phone3.setText("");
		searchfield.setText("");
		confirmchk = false;
	}
	void confirmchk(){
		String codename = code.getText();
		boolean codechk = service.codechk(codename);
		
		if(codechk){
			JOptionPane.showMessageDialog(code, "CODE중복입니다 \n");
			code.setText("");
		} else {
			JOptionPane.showMessageDialog(code, "사용가능한 CODE입니다 \n");
		}
	}
	
	
}

	


