package Member;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class MemberGuiMain {
	public static void main(String[] args) {
		boolean confirmchk =false;
		JFrame frame = new JFrame("실행");
		frame.setPreferredSize(new Dimension(1000,500));
		Container contentPane = frame.getContentPane();
		Font font = new Font("굴림체",Font.TYPE1_FONT,20);
		String colNames[]= {"id","비밀번호","이름","전화번호","우편번호","주소"};		
		
		Font font15 = new Font("고딕체",Font.TYPE1_FONT,15);
		DefaultTableModel model = new DefaultTableModel(colNames,0);
		
		JTable table = new JTable(model);
		JTableHeader header = table.getTableHeader();
		header.setPreferredSize(new Dimension(100,30));
		header.setBackground(Color.lightGray);
		
		table.setFont(font15);
		table.setRowHeight(30);
		contentPane.add(new JScrollPane(table), BorderLayout.EAST);
		contentPane.add(new JScrollPane(table),BorderLayout.CENTER);
		JPanel panel = new JPanel();
		JButton button;
		
		JTextField find = new JTextField(9);
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(7,2));
		String arr[] = {"insert","update","delete","search","cancel"};
		
		contentPane.add(panel,BorderLayout.SOUTH);
		JLabel idlabel = new JLabel("ID");
		JButton idbutton = new JButton("중복검사");
		idlabel.setHorizontalAlignment(JLabel.CENTER);
		JTextField id = new JTextField(10);
		id.setHorizontalAlignment(id.CENTER);
		JPanel panel2 = new JPanel();
		panel2.add(id);
		panel2.add(idbutton);
		JLabel passwordlabel = new JLabel("passwd");
		passwordlabel.setHorizontalAlignment(JLabel.CENTER);
		JTextField password = new JTextField();
		JLabel namelabel = new JLabel("이름");
		JTextField name = new JTextField(10);
		namelabel.setHorizontalAlignment(name.CENTER);
		JLabel phonelabel = new JLabel("전화번호");
		phonelabel.setHorizontalAlignment(JLabel.CENTER);
		JLabel postlabel = new JLabel("우편번호");
		JTextField postcode = new JTextField(5);
		postlabel.setHorizontalAlignment(postlabel.CENTER);
		JPanel phonepanel = new JPanel();
		
		JTextField phone1 = new JTextField(3);
		JLabel label1 = new JLabel("-");
		JTextField phone2 = new JTextField(4);
		JLabel label2 = new JLabel("-");
		JTextField phone3 = new JTextField(4);
		
		phonepanel.add(phone1);
		phonepanel.add(label1);
		phonepanel.add(phone2);
		phonepanel.add(label2);
		phonepanel.add(phone3);
		JLabel addresslabel = new JLabel("주소");
		JLabel addresslabel2 = new JLabel(" ");
		addresslabel.setHorizontalAlignment(addresslabel.CENTER);
		JTextField address1 = new JTextField(6);
		JTextField address2= new JTextField(6);
				
		panel1.add(idlabel);
		panel1.add(panel2);
		panel1.add(passwordlabel);
		panel1.add(password);	
		panel1.add(namelabel);
		panel1.add(name); 	
		panel1.add(phonelabel);
		panel1.add(phonepanel);
		panel1.add(postlabel);
		panel1.add(postcode); 
		panel1.add(addresslabel);
		panel1.add(address1);
		panel1.add(addresslabel2);
		panel1.add(address2);	

		contentPane.add(panel1,BorderLayout.EAST);
		ActionListener listener = new AddActionListenr(confirmchk,frame,model,table,id,password,name,postcode,phone1,phone2,phone3,address1,address2,find);
		for(int i=0; i<arr.length;i++){
			button = new JButton(arr[i]);
			panel.add(button);
		button.addActionListener(listener);
		if(i==2)
			panel.add(find);
			
		}
		MouseListener mouse = new MemberGuiMouseListener(model,table,id,password,name,postcode,phone1,phone2,phone3,address1,address2);
		table.addMouseListener(mouse);	
		idbutton.addActionListener(listener);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
