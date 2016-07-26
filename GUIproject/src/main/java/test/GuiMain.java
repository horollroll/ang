package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class GuiMain {

	public static void main(String[] args) {
		boolean confirmchk = false;
		JFrame frame = new JFrame("거래처관리");
		frame.setLocation(200,150);
		frame.setSize(new Dimension(1000, 800));
		Container contentpane = frame.getContentPane();
		JPanel panel = new JPanel();
		JPanel codepanel = new JPanel();
		JLabel codelabel = new JLabel("code");
		JTextField code = new JTextField(10);
		JButton codebutton = new JButton("중복");
		codepanel.add(code);
		codepanel.add(codebutton);
		JLabel tradenamelabel = new JLabel("상호");
		JTextField tradename = new JTextField();
		JPanel officephonepanel = new JPanel();
		JLabel officephonelabel = new JLabel("사업자no");
		
		JTextField officephone1 = new JTextField(4);
		JTextField officephone2 = new JTextField(5);
		JTextField officephone3 = new JTextField(5);
		officephonepanel.add(officephone1);
		officephonepanel.add(officephone2);
		officephonepanel.add(officephone3);
		JLabel ceolabel = new JLabel("대표자");
		JTextField ceo = new JTextField();
		JLabel postlabel = new JLabel("우편번호");
		JTextField post = new JTextField();
		JLabel addr1label = new JLabel("주소");
		JTextField addr1 = new JTextField();
		JLabel addr2label = new JLabel("");
		JTextField addr2 = new JTextField();
		JLabel businesslabel = new JLabel("업태");
		JTextField business = new JTextField();
		JLabel eventlabel = new JLabel("종목");
		JTextField event = new JTextField();
		JLabel chargenamelabel = new JLabel("담당자");
		JTextField chargename = new JTextField();
		JPanel phonepanel = new JPanel();
		JLabel phonelabel = new JLabel("전화");
		String phonenum[] = {"010","011","017","019"};
		JTextField phone1 = new JTextField(4);
		JTextField phone2 = new JTextField(5);
		JTextField phone3 = new JTextField(5);
		JComboBox<Object> box = new JComboBox<Object>(phonenum);

		phonepanel.add(box);
		phonepanel.add(phone2);
		phonepanel.add(phone3);
		
		panel.add(codelabel);
		panel.add(codepanel);
		panel.add(tradenamelabel);
		panel.add(tradename);
		panel.add(officephonelabel);
		panel.add(officephonepanel);
		panel.add(ceolabel);
		panel.add(ceo);
		panel.add(postlabel);
		panel.add(post);
		panel.add(addr1label);
		panel.add(addr1);
		panel.add(addr2label);
		panel.add(addr2);
		panel.add(businesslabel);
		panel.add(business);
		panel.add(eventlabel);
		panel.add(event);
		panel.add(chargenamelabel);
		panel.add(chargename);
		panel.add(phonelabel);
		panel.add(phonepanel);
		
		String[] colnames = {"code","상호","사업자no","전화번호"};
		DefaultTableModel tablemodel = new DefaultTableModel(colnames, 0);

		JTable table = new JTable(tablemodel);
		JScrollPane scrollpane = new JScrollPane(table);
		JTableHeader tableheader = table.getTableHeader();
		tableheader.setPreferredSize(new Dimension(100, 30));
		tableheader.setBackground(Color.LIGHT_GRAY);
		table.add(tableheader);
	
		JPanel buttonpanel = new JPanel();
		JButton insert = new JButton("입력");
		JButton update = new JButton("수정");
		JButton delete = new JButton("삭제");
		JTextField searchfield = new JTextField(9);
		JButton search= new JButton("검색");
		JButton cancel = new JButton("취소");
		buttonpanel.add(insert);
		buttonpanel.add(update);
		buttonpanel.add(delete);
		buttonpanel.add(searchfield);
		buttonpanel.add(search);
		buttonpanel.add(cancel);
		contentpane.add(buttonpanel, BorderLayout.SOUTH);
		contentpane.add(scrollpane,BorderLayout.EAST);
		panel.setLayout(new GridLayout(11,2));
		contentpane.add(panel, BorderLayout.CENTER);
		ActionListener buttonlistener = new AddActionlistener(code,tradename,officephone1,officephone2,officephone3,ceo,post,addr1,addr2,business,event,chargename,phone1,phone2,phone3,table,tablemodel,searchfield,confirmchk,box); 
		insert.addActionListener(buttonlistener);
		update.addActionListener(buttonlistener);
		delete.addActionListener(buttonlistener);
		search.addActionListener(buttonlistener);
		cancel.addActionListener(buttonlistener);
		codebutton.addActionListener(buttonlistener);
		frame.pack();
		frame.setVisible(true);
		MouseListener mouselistener = new AddMouselistener(code,tradename,officephone1,officephone2,officephone3,ceo,post,addr1,addr2,business,event,chargename,phone1,phone2,phone3,table,tablemodel,searchfield,confirmchk);
		table.addMouseListener(mouselistener);

	}


}
