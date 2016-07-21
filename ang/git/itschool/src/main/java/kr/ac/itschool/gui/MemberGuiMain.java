package kr.ac.itschool.gui;
import java.awt.Container;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
public class MemberGuiMain {

	public static void main(String[] args) {
	JFrame frame = new JFrame("Hello Java Programing");
	frame.setLocation(500,400);
	frame.setPreferredSize(new Dimension(300,200));
	Container contentPane = frame.getContentPane();

	JLabel label = new JLabel("Áß¾Ó");
	contentPane.add(label);
	JButton button1 = new JButton("button1");
	JButton button2 = new JButton("button2");
	JButton button3 = new JButton("button3");
	JLabel label1 = new JLabel("lable1");
	JLabel label2 = new JLabel("lable2");
	JLabel label3 = new JLabel("lable3");
	JLabel label4 = new JLabel("lable4");
	
	JPanel panel1 = new JPanel();
	panel1.add(button1);
	panel1.add(button2);
	panel1.add(button3);
	
	JPanel panel2 = new JPanel();
	panel2.add(label1);
	panel2.add(label2);
	panel2.add(label3);
	panel2.add(label4);
	contentPane.add(panel1, BorderLayout.CENTER);
	contentPane.add(panel2, BorderLayout.SOUTH);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.pack();	 // ÇÁ·¹ÀÓÀ» ¹­´Â´Ù.
	frame.setVisible(true);   
	
	}

}
