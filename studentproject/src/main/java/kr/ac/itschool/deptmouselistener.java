package kr.ac.itschool;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class deptmouselistener implements MouseListener{
	JFrame frame,deptframe ;
	JTextField deptcode,deptname,deptsearchfield;
	JTable depttable;
	DefaultTableModel deptmodel; 
	DaoService service = new DaoService();
	public deptmouselistener(JFrame frame, JFrame deptframe, JTextField deptcode, JTextField deptname, JTable depttable,
			DefaultTableModel deptmodel, JTextField deptsearchfield) {
		this.frame = frame;
		this.deptframe = deptframe;
		this.deptcode = deptcode;
		this.deptname = deptname;
		this.deptsearchfield = deptsearchfield;
		this.depttable = depttable;
		this.deptmodel = deptmodel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(depttable.getSelectedRow() == -1){
			JOptionPane.showMessageDialog(deptcode, "항목을 선택하세요");
			return;
		}
		 String select = (String) deptmodel.getValueAt(depttable.getSelectedRow(), 0);
		 Member member = service.deptselectrow(select);
		deptcode.setText(member.getDeptcode());
		deptname.setText(member.getDeptname());

		if(e.getButton() == 3){
			int result = JOptionPane.showConfirmDialog(deptcode, "삭제하겠습니까","경고",JOptionPane.YES_NO_OPTION);
			if(result == 0){
			 String cod = (String) deptmodel.getValueAt(depttable.getSelectedRow(), 0);
			 boolean find = service.deptfind(cod);
			 if(find){
				 JOptionPane.showMessageDialog(deptcode, "자식레코드가 있어 삭제할수없습니다.");
				 return;
			 }
			 service.deptdeleterow(cod);
			 JOptionPane.showMessageDialog(deptcode, "삭제완료");
			 deptmodel.removeRow(depttable.getSelectedRow());
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
