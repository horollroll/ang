package kr.ac.itschool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class depButtonlistener implements ActionListener {
	JFrame frame,deptframe;
	JTextField deptcode,deptname;
	public depButtonlistener(JFrame frame, JFrame deptframe, JTextField deptcode, JTextField deptname) {
		this.frame =frame;
		this.deptframe = deptframe;
		this.deptcode = deptcode;
		this.deptname = deptname;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String textname = e.getActionCommand();
		DaoService service = new DaoService();
		if(textname.equals("home")){
			service.gohome(frame, deptframe);
		}
	}

}
