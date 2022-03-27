package railway.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Cancel extends JFrame { //Sixth
    
    private JTextField textField,textField_1,textField_2,textField_3,textField_4;

    public static void main(String[] args) {
        new Cancel();
    }
    
    public Cancel() {
        initialize();
    }
    
    private void initialize() {
        setTitle("CANCELLATION");
	getContentPane().setBackground(Color.WHITE);
	setBounds(100, 100, 801, 472);
	setLayout(null);
		
	JLabel Cancellation = new JLabel("CANCELLATION");
	Cancellation.setFont(new Font("Tahoma", Font.PLAIN, 31));
        Cancellation.setForeground(Color.BLUE);
	Cancellation.setBounds(185, 24, 259, 38);
	add(Cancellation);
		
	
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("railway/management/system/icon/cancel.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(470, 100, 250, 250);
	add(NewLabel);
		
	JLabel PassengerNo = new JLabel("PASSENGER NO");
	PassengerNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
	PassengerNo.setBounds(60, 100, 132, 26);
	add(PassengerNo);
		
	JLabel Name = new JLabel("Name");
	Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
	Name.setBounds(60, 150, 150, 27);
	add(Name);
		
	JLabel CancellationDate = new JLabel("CANCELLATION DATE");
	CancellationDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
	CancellationDate.setBounds(60, 200, 180, 27);
	add(CancellationDate);
		
	JLabel Reason = new JLabel("Reason");
	Reason.setFont(new Font("Tahoma", Font.PLAIN, 17));
	Reason.setBounds(60, 250, 150, 27);
	add(Reason);
		
	JLabel Flightcode = new JLabel("RAILWAY_CODE");
	Flightcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
	Flightcode.setBounds(60, 300, 150, 27);
	add(Flightcode);
		
	JButton Cancel = new JButton("CANCEL TICKET");
	Cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
	Cancel.setBounds(250, 350, 150, 30);
	add(Cancel);
		
	textField = new JTextField();
	textField.setBounds(250, 100, 150, 27);
	add(textField);
	
        textField_1 = new JTextField();
	textField_1.setBounds(250, 150, 150, 27);
	add(textField_1);
		
	textField_2 = new JTextField();
	textField_2.setBounds(250, 200, 150, 27);
	add(textField_2);
	
        textField_3 = new JTextField();
	textField_3.setBounds(250, 250, 150, 27);
	add(textField_3);
		
	textField_4 = new JTextField();
	textField_4.setBounds(250, 300, 150, 27);
	add(textField_4);
	
        Cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		
                String pnr = textField.getText();
		String name = textField_1.getText();
		String date = textField_2.getText();
		String reason = textField_3.getText();
		String code = textField_4.getText();
					
					
		try{	
                    conn c = new conn();
                    String str = "INSERT INTO cancel values('"+pnr+"', '"+name+"', '"+date+"','"+reason+"', '"+code+"')";
		
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"SUCCESS. YOu will receive your Amount after our Procedure.");
                    setVisible(false);
						
		}catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
			
	setSize(860,500);
	setVisible(true);
        setLocation(0,0);
    }
}
