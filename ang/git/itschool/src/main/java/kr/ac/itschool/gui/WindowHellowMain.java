package kr.ac.itschool.gui;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
public class WindowHellowMain {
static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		JFrame frame = new JFrame("Title");
		frame.setLocation(500,400);
		frame.setPreferredSize(new Dimension(200,150));
		
		Container contentpane = frame.getContentPane();
		JTextField text = new JTextField(20);
		JLabel label = new JLabel("메모장");
		JButton button1 = new JButton("버튼1");
		JButton cancel= new JButton("버튼2");

		JPanel panel1 = new JPanel();
		panel1.add(button1);
		panel1.add(cancel);
		contentpane.add(text, BorderLayout.CENTER);
		contentpane.add(label, BorderLayout.NORTH);
		contentpane.add(panel1, BorderLayout.SOUTH);
		
		
//		ActionListener listener = new WindowHelloClickListner( text,text2, text3, label, label2, Button1,Button2, button3,button4, cancel2);
//		button1.addActionListener(listener);
//		cancel.addActionListener(listener);
		frame.pack();
		frame.setVisible(true);
		
		
		
	}

}
