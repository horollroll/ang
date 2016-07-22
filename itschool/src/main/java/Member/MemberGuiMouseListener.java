package Member;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import kr.ac.itschool.entities.Member;
import kr.ac.itschool.service.MemberDaoService;
public class MemberGuiMouseListener implements MouseListener {
	DefaultTableModel model;
	JTable table;
	JTextField id;
	JTextField password;
	JTextField name;
	JTextField postcode;
	JTextField phone1;
	JTextField phone2;
	JTextField phone3;
	JTextField address1;
	JTextField address2;
	MemberGuiMouseListener(	DefaultTableModel model, JTable table, JTextField id, JTextField password,
			JTextField name, JTextField postcode, JTextField phone1, JTextField phone2, JTextField phone3,
			JTextField address1, JTextField address2){
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
	}
	public void mouseClicked(MouseEvent e) {
		JTable target = (JTable)e.getSource();
		int row = target.getSelectedRow();
		String idd = (String)target.getValueAt(row, 0);
		MemberDaoService service = new MemberDaoService();
		Member data = service.selectrowone(idd);
		id.setText(data.getId());
		password.setText(data.getPassword());
		name.setText(data.getName());
		phone1.setText(data.getPhone1());
		phone2.setText(data.getPhone2());
		phone3.setText(data.getPhone3());
		postcode.setText(data.getPost());
		address1.setText(data.getAddr1());
		address2.setText(data.getAddr2());
	}
	
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	
}