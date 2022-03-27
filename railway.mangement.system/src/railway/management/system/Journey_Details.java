package railway.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Journey_Details extends JFrame{  //Forth

    JTable table;
    JLabel note,ReservationDetails,Date,Train_Name,Train_No,Source,Destination,label,label1,Dep_Time,Arrival_Time;
    JButton Show;

    public static void main(String[] args){
        new Journey_Details();
    }
    
    public Journey_Details(){
        
        setTitle("JOURNEY_DETAILS");
	getContentPane().setBackground(Color.WHITE);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	setLayout(null);
		
	Source = new JLabel("SOURCE");
	Source.setFont(new Font("Tahoma", Font.PLAIN, 19));
	Source.setBounds(60, 100, 150, 27);
	add(Source);
	
        Destination = new JLabel("DESTINATION");
	Destination.setFont(new Font("Tahoma", Font.PLAIN, 19));
	Destination.setBounds(350, 100, 150, 27);
	add(Destination);
		
	
		
	Show = new JButton("SHOW");
	Show.setBounds(680, 100, 100, 30);
	add(Show);

	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	ReservationDetails = new JLabel("---:  JOURNEY DETAILS  :---");
	ReservationDetails.setForeground(Color.BLUE);
	ReservationDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
	ReservationDetails.setBounds(280, 27, 400, 31);
	add(ReservationDetails);
		
        note=new JLabel("Note: You can check your prefered train details in 'Railway System -> Railway_Info' with the help of Train Number. ");
        note.setForeground(Color.RED);
        note.setFont(new Font("Tahoma",Font.BOLD,15));
        note.setBounds(60,150,1000,80);
        add(note);
        
	Date = new JLabel("Date");
	Date.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Date.setBounds(79, 270, 83, 20);
	add(Date);
		
	Train_Name = new JLabel("Train_Name");
	Train_Name.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Train_Name.setBounds(172, 270, 103, 20);
	add(Train_Name);
		
	Train_No = new JLabel("Train_No.");
	Train_No.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Train_No.setBounds(297, 270, 103, 20);
	add(Train_No);
		
	Source = new JLabel("Source");
	Source.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Source.setBounds(390, 270, 94, 20);
	add(Source);
		
	Destination = new JLabel("Destination");
	Destination.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Destination.setBounds(494, 270, 83, 20);
	add(Destination);
		
	Dep_Time = new JLabel("Dep_Time");
	Dep_Time.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Dep_Time.setBounds(613, 270, 94, 20);
	add(Dep_Time);
		
	Arrival_Time = new JLabel("Arrival_Time");
	Arrival_Time.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Arrival_Time.setBounds(717, 270, 94, 20);
	add(Arrival_Time);
        
	String[] items1 =  {"BANGALORE", "MUMBAI", "CHENNAI", "PATNA","DELHI","HYDERABAD"};
	JComboBox comboBox = new JComboBox(items1);
	comboBox.setBounds(150, 100, 150, 27);
	add(comboBox);
		
		
	String[] items2 =  {"BANGALORE", "MUMBAI", "CHENNAI", "PATNA","DELHI","HYDERABAD"};
	JComboBox comboBox_1 = new JComboBox(items2);
	comboBox_1.setBounds(500, 100, 150, 27);
	add(comboBox_1);
        
        table = new JTable();
	table.setBounds(38, 310, 770, 130);
	add(table);
	
		
		
	Show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		try{
                    String src  = (String) comboBox.getSelectedItem();
                    String dst  = (String) comboBox_1.getSelectedItem();
                    
                    conn c = new conn();
                    
                    String str = "select Date,Train_Name,Train_No,Source,Destination,Dep_Time,Arrival_Time from jrny_details where Source = '"+src+"' and Destination = '"+dst+"'";
                    ResultSet rs=c.s.executeQuery(str);
                    
                    if(rs.next()){
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }else{
                        JOptionPane.showMessageDialog(null,"No Trains between Source and Destination");
                        
                    }					
                    
					
		}catch(Exception e){}
            }
	});
		
	setSize(1000,600);
        setLocation(0,0);
	setVisible(true);
		
    }
}
