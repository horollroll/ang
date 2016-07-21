package kr.ac.itschool.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.Scanner;
public class WindowHelloClickListner implements  ActionListener {
	private JTextField text;
	private JLabel label;
	private JButton Button1;
	private JButton cancel;
	


	public WindowHelloClickListner(JTextField text,JTextField text2, JTextField text3, JLabel label,JLabel label2, JButton Button1,JButton Button2, JButton button3, JButton button4, JButton cancel2)
	{

		this.text = text;
		this.label = label;
		this.Button1 = Button1;
		this.cancel = Button2;



	}
		
	public void actionPerformed(ActionEvent e) {

		String gettext=e.getActionCommand();
		
		if(gettext.equals(cancel))
		{
			text.setText("");
			label.setText("Hello");
		}
		label.setText(label.getText()+text.getText());
		
	}
	
}
