package kr.ac.itschool;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class mouselistener implements MouseListener {
	JFrame frame,studentframe;
	JTextField code,name,idcard,postno,addr1,addr2,age,stusearchfield;
	JComboBox professor,dept;
	DefaultTableModel model;
	JTable stutable;
	DaoService service = new DaoService();
	public mouselistener(JFrame frame, JFrame studentframe, JTextField code, JTextField name, JTextField idcard,
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
	public void mouseClicked(MouseEvent e) {
		
		 String select = (String) model.getValueAt(stutable.getSelectedRow(), 0);
		service.selectrow(select);
		
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
