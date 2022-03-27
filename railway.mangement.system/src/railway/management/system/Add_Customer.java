package railway.management.system;

import java.awt.EventQueue;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java .sql.Statement;
import javax.swing.*;

public class Add_Customer extends JFrame{ //Third Frame

    
	JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6, textfield_7;
        public Add_Customer(){
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("BOOK YOUR TICKET");
		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
            
            JLabel Railwaycode = new JLabel("RAILWAY CODE");
            Railwaycode.setFont(new Font("Tahoma", Font.PLAIN, 18));
            Railwaycode.setBounds(60, 30, 150, 25);
            add(Railwaycode);

            textField_6 = new JTextField();
            textField_6.setBounds(200, 30, 150, 25);
            add(textField_6);
            
            JLabel Source = new JLabel("SOURCE");
            Source.setFont(new Font("Tahoma", Font.PLAIN, 18));
            Source.setBounds(60, 65, 150, 25);
            add(Source);
		
            JLabel Destination = new JLabel("DESTINATION");
            Destination.setFont(new Font("Tahoma", Font.PLAIN, 18));
            Destination.setBounds(60, 100, 150, 25);
            add(Destination);
            
            String[] items1 =  {"BANGALORE", "MUMBAI", "CHENNAI", "PATNA","DELHI","HYDERABAD"};
            JComboBox comboBox = new JComboBox(items1);
            comboBox.setBounds(200, 65, 150, 22);
            add(comboBox);


            String[] items2 =  {"BANGALORE", "MUMBAI", "CHENNAI", "PATNA","DELHI","HYDERABAD"};
            JComboBox comboBox_1 = new JComboBox(items2);
            comboBox_1.setBounds(200, 100, 150, 22);
            add(comboBox_1);
			
            JLabel Date = new JLabel("DATE");
            Date.setFont(new Font("Tahoma", Font.PLAIN, 18));
            Date.setBounds(60, 135, 150, 25);
            add(Date);
            
            textField = new JTextField();
            textField.setBounds(200, 135, 150, 20);
            add(textField);
            
            JLabel Name = new JLabel("NAME");
            Name.setFont(new Font("Tahoma", Font.PLAIN, 18));
            Name.setBounds(60, 170, 150, 25);
            add(Name);
	
            textField_4 = new JTextField();
            textField_4.setBounds(200, 170, 150, 20);
            add(textField_4);
            
            JLabel Gender = new JLabel("GENDER");
            Gender.setFont(new Font("Tahoma", Font.PLAIN, 18));
            Gender.setBounds(60, 205, 150, 25);
            add(Gender);
		
            JRadioButton NewRadioButton = new JRadioButton("MALE");
            NewRadioButton.setBackground(Color.WHITE);
            NewRadioButton.setBounds(200, 205, 70, 20);
            add(NewRadioButton);
	
            JRadioButton Female = new JRadioButton("FEMALE");
            Female.setBackground(Color.WHITE);
            Female.setBounds(280, 205, 70, 20);
            add(Female);
            
            JLabel Adhar = new JLabel("AADHAR N0.");
            Adhar.setFont(new Font("Tahoma", Font.PLAIN, 18));
            Adhar.setBounds(60, 240, 150, 25);
            add(Adhar);
			
            textField_3 = new JTextField();
            textField_3.setBounds(200, 240, 150, 25);
            add(textField_3);
            
            
            JLabel Address = new JLabel("ADDRESS");
            Address.setFont(new Font("Tahoma", Font.PLAIN, 18));
            Address.setBounds(60, 275, 150, 25);
            add(Address);
			
            textField_2 = new JTextField();
            textField_2.setBounds(200, 275, 150, 25);
            add(textField_2);
            
            JLabel Phno = new JLabel("PH NO");
            Phno.setFont(new Font("Tahoma", Font.PLAIN, 18));
            Phno.setBounds(60, 310, 150, 25);
            add(Phno);
			
            textField_5 = new JTextField();
            textField_5.setBounds(200, 310, 150, 25);
            add(textField_5);
            
            /*JLabel Rclass=new JLabel("Class");
            Rclass.setFont(new Font("Tahoma", Font.PLAIN, 18));
            Rclass.setBounds(60, 350, 150, 25);
            add(Rclass);
            
            textfield_7 = new JTextField();
            textfield_7.setBounds(200, 350, 150, 25);
            add(textfield_7);*/
            
            JLabel note = new JLabel("After saving your information, GO to Payment Section to pay your Fare.");
            note.setFont(new Font("Tahoma", Font.PLAIN, 13));
            note.setForeground(Color.red);
            note.setBounds(60, 350, 500, 25);
            add(note);
            
            JButton Next = new JButton("SAVE");
            Next.setBounds(60, 400, 290, 30);
            Next.setBackground(Color.BLACK);
            Next.setForeground(Color.WHITE);
            add(Next);
            
            
            
            setVisible(true);
	
            JLabel AddPassengers = new JLabel("BOOK TICKET");
            AddPassengers.setForeground(Color.BLUE);
            AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
            AddPassengers.setBounds(420, 24, 442, 35);
            add(AddPassengers);
            
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("railway/management/system/icon/emp.png"));
            JLabel image = new JLabel(i1);
            image.setBounds(450,80,280,410);
            add(image);

            
            Next.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    String railway_code = textField_6.getText();
                    String src  = (String) comboBox.getSelectedItem();
                    String dst  = (String) comboBox_1.getSelectedItem();
                    String date = textField.getText();
                    String address =  textField_2.getText();
                    String adhar = textField_3.getText();
                    String name = textField_4.getText();
                    String phonenum = textField_5.getText();
                   
                    String gender = null;
                    
                    if(NewRadioButton.isSelected()){
                        gender = "male";
                    
                    }else if(Female.isSelected()){
                        gender = "female";
                    }
                    
                    try {
                        conn c = new conn();
                        String str2="select pnr from pnr where cusid=1";
                        ResultSet rs1=c.s.executeQuery(str2);
                        int ans=0;
                        if(rs1.next()){
                            ans=rs1.getInt("pnr");
                        }
                        int ans1=ans;
                        ans1=ans1+1;
                        String str3="update pnr set pnr="+ans1+" where cusid= 1 ";
                          c.s.executeUpdate(str3);
                          
                        String str = "INSERT INTO passenger values( "+ans+", '"+railway_code+"', '"+src+"','"+dst+"', '"+date+"', '"+name+"','"+gender+"', '"+adhar+"', '"+address+"', '"+phonenum+"')";
                        
                        c.s.executeUpdate(str);
                        String strm="insert into payment values("+ans+",'"+name+"','-','-','UNSUCCESSFUL')";
                        c.s.executeUpdate(strm);
                        JOptionPane.showMessageDialog(null,"Your PNR Number is "+ans+" . Pay Fare for Successful Ticket Booking.");
                        setVisible(false);
                    } catch (Exception e) {
                        e.printStackTrace();
        	    }
		}
            });
			
            setSize(900,600);
            setVisible(true);
            setLocation(0,0);
			
	}
        
    public static void main(String[] args){
        new Add_Customer();
    }   
}