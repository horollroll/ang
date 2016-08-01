package kr.ac.itschool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class proButtonlistener implements ActionListener {
	JFrame frame,proframe;
	JTextField procode,proname;
	public proButtonlistener(JFrame frame, JFrame proframe, JTextField procode, JTextField proname) {
		this.frame =frame;
		this.proframe = proframe;
		this.procode = procode;
		this.proname = proname;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String textname = e.getActionCommand();
		DaoService service = new DaoService();
		if(textname.equals("home")){
			service.gohome(frame, proframe);
		}

	}

}
