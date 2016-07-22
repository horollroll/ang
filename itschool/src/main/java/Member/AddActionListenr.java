package Member;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import kr.ac.itschool.entities.Member;
import kr.ac.itschool.service.MemberDaoService;
public class AddActionListenr implements ActionListener {
	MemberDaoService service = new MemberDaoService();
	boolean confirmchk;
	DefaultTableModel model;
	JTable table;
	JTextField id,password,phone1,phone2,phone3;
	JTextField name,postcode,address1,address2,find;
	JFrame frame;
	
	public AddActionListenr(boolean confirmchk,JFrame frame,DefaultTableModel model,JTable table, JTextField id, JTextField password, JTextField name, JTextField postcode,JTextField phone1,
			JTextField phone2,JTextField phone3,JTextField address1, JTextField address2, JTextField find) {
	this.confirmchk = confirmchk;
	this.model = model;
	this.table = table;
	this.id = id;
	this.password = password;
	this.name = name;
	this.postcode = postcode;    
	this.address1 = address1;
	this.address2 = address2;
	this.phone1 = phone1;
	this.phone2 = phone2;
	this.phone3 = phone3;
	this.frame = frame;
	this.find = find;
	}
	
	public void actionPerformed(ActionEvent e) {
		String btntxt = e.getActionCommand();
		Member data = new Member();
		data.setId(id.getText());
		data.setName(name.getText());
		data.setPassword(password.getText());
		data.setPhone1(phone1.getText());
		data.setPhone2(phone2.getText());
		data.setPhone3(phone3.getText());
		data.setPost(postcode.getText());
		data.setAddr1(address1.getText());
		data.setAddr2(address2.getText());
		if(btntxt.equals("중복검사")){
			if(id.getText().equals("")){
				JOptionPane.showMessageDialog(id, "id를 입력하세요");
				return;
			}
			boolean findid = idConfirmChk();
			if(findid)
				return;
		}
		if (btntxt.equals("update")){
			if(id.getText().equals("")){
				JOptionPane.showMessageDialog(id, "검색후 수정항목을 입력하세요.");
				return;
			}
		}
		switch(btntxt){
			case "insert" : insertMember(data); break;
			case "update" :updateMember(data); break;
			case "delete" : deleteMember(data); break;
			case "search" : searchMember(find.getText()); break;
			case "cancel" : cancelMember(); break;
		}

	}
	void insertMember(Member data){
		String message ="";
		if(!confirmchk){
			message += "ID중복체크확인\n";
		}
		if(id.getText().equals("") || id.getText() == null){
			message += "ID를입력하세요! \n";
			confirmchk = false;
		}
		if(name.getText().equals("") || name.getText() == null){
			message += "이름을확인하세요! \n";	
		}
		if(!message.equals("")){
			
			JOptionPane.showMessageDialog(id, message);
			return;
		}
		boolean sucess = service.insertRow(data);
		if(sucess){
			JOptionPane.showMessageDialog(id, "저장되었습니다");
		}else{
			JOptionPane.showMessageDialog(id, "저장실패");
		}
		Object row[]={"","","","","",""};
		row[0] = data.getId();
		row[1] = data.getPassword().toString();
		row[2] = data.getName().toString();
		row[3] = data.getPhone1()+"-"+data.getPhone2()+"-"+data.getPhone3();
		row[4] = data.getPost().toString();
		row[5] = data.getAddr1().toString()+data.getAddr2().toString();
		model.addRow(row);
		screenClear();
	}
	void screenClear(){
		id.setText("");
		password.setText("");
		name.setText("");
		phone1.setText("");
		phone2.setText("");
		phone3.setText("");
		postcode.setText("");
		address1.setText("");
		address2.setText("");
		confirmchk = false;
	}
	void updateMember(Member data){	
			String result = service.updateRow(data);
			String cn = (String) model.getValueAt(table.getSelectedRow(),0);
			if(!cn.equals(id.getText())){
				JOptionPane.showMessageDialog(id, "ID는 수정할수 없습니다. \n");
				id.setText(cn);
				return;
			} 
			if(result.equals("")){
					table.getSelectionModel();
					JOptionPane.showMessageDialog(id, "저장되었습니다.");
					model.setValueAt(data.getId(), table.getSelectedRow(), 0);
					model.setValueAt(data.getPassword(), table.getSelectedRow(), 1);
					model.setValueAt(data.getName(), table.getSelectedRow(), 2);
					String phone = data.getPhone1()+"-"+data.getPhone2()+"-"+data.getPhone3();
					model.setValueAt(phone, table.getSelectedRow(), 3);
					model.setValueAt(data.getPost(), table.getSelectedRow(), 4);
					String addr = data.getAddr1()+data.getAddr2();
					model.setValueAt(addr, table.getSelectedRow(), 5);
					screenClear();
			} else {
				JOptionPane.showMessageDialog(id, "수정되지않았습니다. \n"+result);
			}
				
			
	}
	void deleteMember(Member data){
	
	}
	void searchMember(String find){
		model.setRowCount(0);
		ArrayList<Member> list =null;
		if(find.equals(""))
		list = service.selectAll();
		else
		list = service.selectFind(find);
		
		Object row[] = {"","","","","",""};
		for(Member list1 : list){
			row[0] = list1.getId();
			row[1] = list1.getPassword();
			row[2] = list1.getName();
			row[3] = list1.getPhone1()+"-"+list1.getPhone2()+"-"+list1.getPhone3(); 
			row[4] = list1.getPost();
			row[5] = list1.getAddr1()+list1.getAddr2();
			model.addRow(row);
		}
	}
	void cancelMember(){
		model.setRowCount(0);
		screenClear();
	}
	boolean idConfirmChk(){
		service = new MemberDaoService();
		boolean findid = service.findId(id.getText());
		if(findid){   
		JOptionPane.showMessageDialog(id, "ID중복입니다");
		id.setText("");
		confirmchk = false;

		}else{			
			JOptionPane.showMessageDialog(id, "사용가능한아이디");
		confirmchk = true;
		
		}
		return confirmchk;
	}
}