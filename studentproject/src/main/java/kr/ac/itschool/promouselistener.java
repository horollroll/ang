package kr.ac.itschool;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class promouselistener implements MouseListener {
	JFrame frame,proframe;
	JTextField procode,proname,prosearchfield;
	JTable protable;
	DefaultTableModel promodel;
	DaoService service = new DaoService();
	public promouselistener(JFrame frame, JFrame proframe, JTextField procode, JTextField proname, JTable protable, DefaultTableModel promodel, JTextField prosearchfield) {
		this.frame =frame;
		this.proframe = proframe;
		this.procode = procode;
		this.proname = proname;
		this.protable = protable;
		this.promodel = promodel;
		this.prosearchfield = prosearchfield;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(protable.getSelectedRow() == -1){
			JOptionPane.showMessageDialog(procode, "항목을 선택하세요");
			return;
		}
		 String select = (String) promodel.getValueAt(protable.getSelectedRow(), 0);
		 Member member = service.proselectrow(select);
		procode.setText(member.getProcode());
		proname.setText(member.getProname());

		if(e.getButton() == 3){
			int result = JOptionPane.showConfirmDialog(procode, "삭제하겠습니까","경고",JOptionPane.YES_NO_OPTION);
			if(result == 0){
			 String cod = (String) promodel.getValueAt(protable.getSelectedRow(), 0);
			 boolean find = service.profind(cod);
			 if(find){
				 JOptionPane.showMessageDialog(procode, "자식레코드가 있어 삭제할수없습니다.");
				 return;
			 }
			 service.prodeleterow(cod);
			 JOptionPane.showMessageDialog(procode, "삭제완료");
			 promodel.removeRow(protable.getSelectedRow());
			}
		}
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
