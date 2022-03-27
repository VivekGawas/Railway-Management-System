/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package railway.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class PNR_Enquiry extends JFrame{ //Fifth

    JTextField textField;
    JTable table,table1;

    public static void main(String[] args) {
        new PNR_Enquiry();
    }

    public PNR_Enquiry(){
	initialize();
    }

    private void initialize(){
        setTitle("PNR STATUS");
	getContentPane().setBackground(Color.WHITE);
	setSize(860,486);
	setLayout(null);
		
	JLabel Fcode = new JLabel("PNR NO");
	Fcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
	Fcode.setBounds(60, 160, 150, 26);
	add(Fcode);
		
	textField = new JTextField();
	textField.setBounds(200, 160, 150, 26);
	add(textField);
		
	JButton Show = new JButton("SHOW");
	Show.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Show.setBackground(Color.BLACK);
        Show.setForeground(Color.WHITE);
	Show.setBounds(200, 210, 150, 26);
	add(Show);
		
	JLabel Sector = new JLabel("PNR STATUS");
	Sector.setForeground(Color.BLUE);
	Sector.setFont(new Font("Tahoma", Font.PLAIN, 31));
	Sector.setBounds(51, 17, 300, 39);
	add(Sector);
		
	JLabel label = new JLabel("");
	label.setIcon(new ImageIcon(ClassLoader.getSystemResource("railway/management/system/icon/pnr1.png")));
	label.setBounds(425, 20, 300, 200);
	add(label);
        
	table = new JTable();
        table.setBackground(Color.WHITE);
	table.setBounds(23, 250, 800, 300);
        
        JScrollPane pane = new JScrollPane(table);
	pane.setBounds(23, 250, 800, 50);
        pane.setBackground(Color.WHITE);
        add(pane);
        
        table1 = new JTable();
        table1.setBackground(Color.WHITE);
	table1.setBounds(23, 320, 800, 50);
        
        JScrollPane pane1 = new JScrollPane(table1);
	pane1.setBounds(23, 320, 800, 50);
        pane1.setBackground(Color.WHITE);
        add(pane1);
        
        setVisible(true);
		
	Show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		String code1  = textField.getText();
                int code=Integer.parseInt(code1);
                try {
                    
                    conn c = new conn();
                    String str = "select PNR,Name,Card_No,Status from payment where PNR ="+code;
					
                    ResultSet rs = c.s.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));	
                    
                    String str1="select * from passenger where pnr_no="+code;
                    ResultSet rs1 = c.s.executeQuery(str1);
                    table1.setModel(DbUtils.resultSetToTableModel(rs1));
                    
                    }catch(SQLException e) {
                        e.printStackTrace();
                    }
            }
	});
		
	setSize(900,650);
        setVisible(true);
        setLocation(0,0);

    }
}

