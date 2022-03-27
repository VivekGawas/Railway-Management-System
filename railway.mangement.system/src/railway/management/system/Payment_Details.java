package railway.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Payment_Details extends JFrame{ //Fifth

    JTextField textField,textField1,textField2;
    JTable table;
    JLabel Sector;
    JLabel FlightCode, Capacity, Classcode, Classname, label;

    public static void main(String[] args) {
        new Payment_Details();
    }

    public Payment_Details(){
	initialize();
    }

    private void initialize(){
        setTitle("PAYMENT_DETAILS");
	getContentPane().setBackground(Color.WHITE);
	setSize(860,486);
	setLayout(null);
		
	JLabel Fcode = new JLabel("PNR NO");
	Fcode.setFont(new Font("Tahoma", Font.PLAIN, 20));
	Fcode.setBounds(60, 90, 150, 30);
	add(Fcode);
		
	textField = new JTextField();
	textField.setBounds(200, 90, 150, 30);
	add(textField);
        
        JLabel Amount = new JLabel("Amount");
	Amount.setFont(new Font("Tahoma", Font.PLAIN, 20));
	Amount.setBounds(60, 130, 150, 30);
	add(Amount);
		
	textField1 = new JTextField();
	textField1.setBounds(200, 130, 150, 30);
	add(textField1);
        
        JLabel pin = new JLabel("PIN");
	pin.setFont(new Font("Tahoma", Font.PLAIN, 20));
	pin.setBounds(60, 170, 150, 30);
	add(pin);
		
	textField2 = new JTextField();
	textField2.setBounds(200, 170, 150, 30);
	add(textField2);
		
	JButton Show = new JButton("PAY");
	Show.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Show.setBackground(Color.BLACK);
        Show.setForeground(Color.WHITE);
	Show.setBounds(60, 260, 290, 26);
	add(Show);
		
	Sector = new JLabel("PAYMENT SECTION");
	Sector.setForeground(Color.BLUE);
	Sector.setFont(new Font("Tahoma", Font.PLAIN, 31));
	Sector.setBounds(51, 17, 300, 39);
	add(Sector);
		
	label = new JLabel("");
	label.setIcon(new ImageIcon(ClassLoader.getSystemResource("railway/management/system/icon/payment.png")));
	label.setBounds(425, 15, 400, 272);
	add(label);
	
        setVisible(true);
		
	Show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		
                try {
                    String pnr  = textField.getText();
                    String amount=textField1.getText();
                    String pin=textField2.getText();
                    
                    conn c = new conn();
                    
                    String str3="update payment set Card_No='"+amount+"', Pin='"+pin+"',Status='SUCCESSFUL' where PNR="+pnr;
                    JOptionPane.showMessageDialog(null,"Your payment was Successful. Enjoy your Journey");
                    c.s.executeUpdate(str3);
					
		}catch(SQLException e) {
                    JOptionPane.showMessageDialog(null,"Your Credentials are Wrong.");
                }
            }
	});
		
	setSize(860,490);
        setLocation(0,0);
	setVisible(true);

    }
}
