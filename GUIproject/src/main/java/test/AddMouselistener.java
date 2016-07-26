package test;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AddMouselistener implements MouseListener {
	JTextField  code,tradename,officephone1,officephone2,officephone3,ceo,searchfield;
	JTextField post,addr1,addr2,business,event,chargename,phone1,phone2,phone3;
	JTable table;
	DefaultTableModel tablemodel;
	boolean confirmchk;
	DaoService service = new DaoService();
	public AddMouselistener(JTextField code, JTextField tradename, JTextField officephone1, JTextField officephone2,
			JTextField officephone3, JTextField ceo, JTextField post, JTextField addr1, JTextField addr2,
			JTextField business, JTextField event, JTextField chargename, JTextField phone1, JTextField phone2,
			JTextField phone3, JTable table, DefaultTableModel tablemodel, JTextField searchfield, boolean confirmchk) {
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
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getButton());
		if(e.getButton() == -1){
			JOptionPane.showMessageDialog(code, "항목을 선택하세요!");
		}
		Object selectrow = tablemodel.getValueAt(table.getSelectedRow(), 0);
		if(e.getButton() == 3){
			int result = JOptionPane.showConfirmDialog(code,"정말 지우시겠습니까?","경고",JOptionPane.YES_NO_OPTION
					,JOptionPane.WARNING_MESSAGE);
			if(result == 0){
				service.removerow(selectrow);
				tablemodel.removeRow(table.getSelectedRow());
				
			} else {
				return;
			}
			
		}
		 Member member = service.mouseclicked(selectrow);
		 code.setText((member.getCode()));
		 tradename.setText((member.getTradename()));
		 officephone1.setText((member.getOfficephone1()));
		 officephone2.setText((member.getOfficephone2()));
		 officephone3.setText((member.getOfficephone3()));
		 ceo.setText((member.getCeo()));
		 post.setText((member.getPost()));
		 addr1.setText((member.getAddr1()));
		 addr2.setText((member.getAddr2()));
		 business.setText((member.getBusiness()));
		 event.setText((member.getEvent()));
		 chargename.setText((member.getChargename()));
		 phone1.setText((member.getPhone1()));
		 phone2.setText((member.getPhone2()));
		 phone3.setText((member.getPhone3()));
		}

	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}

}
