package kr.ac.itschool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class AddButton implements ActionListener {
	JFrame frame,studentframe,deptframe,proframe ;
	public AddButton(JFrame frame, JFrame studentframe, JFrame deptframe, JFrame proframe) {
		this.frame = frame;
		this.studentframe = studentframe;
		this.deptframe = deptframe;
		this.proframe = proframe;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String textname = e.getActionCommand();
		if(textname.equals("학과등록")){
			frame.setVisible(false);
			deptframe.setVisible(true);
			return;
		}
		if(textname.equals("교수등록")){
			frame.setVisible(false);
			proframe.setVisible(true);
			return;
		}
		if(textname.equals("학생등록")){
			frame.setVisible(false);
			studentframe.setVisible(true);
			return;
		}
	}

}
