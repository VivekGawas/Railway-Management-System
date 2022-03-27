package railway.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//import javafx.scene.text.FontWeight;


public class Mainframe extends JFrame{

    public static void main(String[] args) {
        new Mainframe().setVisible(true);
    }
    
    public Mainframe() {
        super("RAILWAY RESERVATION MANAGEMENT SYSTEM");
        initialize();
    }

    
    private void initialize() {
        setForeground(Color.CYAN);
        setLayout(null); 

        JLabel NewLabel = new JLabel("");
	NewLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource("railway/management/system/icon/railman2.png")));
	NewLabel.setBounds(2, 0, 1277, 667); 
	add(NewLabel); 
        
        JLabel RailwayManagementSystem = new JLabel("INDIAN RAILWAY WELCOMES YOU");
	RailwayManagementSystem.setForeground(Color.WHITE);
        RailwayManagementSystem.setFont(new Font("Calibri", Font.PLAIN, 36));
	RailwayManagementSystem.setBounds(300, 75, 1000, 36);
	NewLabel.add(RailwayManagementSystem);
		
        JLabel dash = new JLabel("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
	dash.setForeground(Color.WHITE);
        dash.setFont(new Font("Calibri", Font.BOLD, 20));
	dash.setBounds(300, 115, 1000, 25);
	NewLabel.add(dash);
		
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
        Color c=new Color(32,42,68);
	menuBar.setBackground(c);	
        JMenu RailwaySystem = new JMenu("RAILWAY SYSTEM");
        RailwaySystem.setForeground(Color.WHITE);
	menuBar.add(RailwaySystem);
	
        JMenuItem PassengerDetails = new JMenuItem("JOURNEY_DETAILS");
	RailwaySystem.add(PassengerDetails);
        
        JMenuItem RailDetails = new JMenuItem("RAILWAY_INFO");
	RailwaySystem.add(RailDetails);
        JButton button1=new JButton("BOOK TICKET");
        button1.setOpaque(true);
        button1.setContentAreaFilled(false);
        button1.setBorderPainted(false);
        button1.setFocusable(false);
        button1.setForeground(Color.WHITE);
        menuBar.add(button1);
		
        JButton button2=new JButton("PAYMENT");
        button2.setOpaque(true);
        button2.setContentAreaFilled(false);
        button2.setBorderPainted(false);
        button2.setFocusable(false);
        button2.setForeground(Color.WHITE);
        menuBar.add(button2);
        
        JButton button3=new JButton("CANCELLATION");
        button3.setOpaque(true);
        button3.setContentAreaFilled(false);
        button3.setBorderPainted(false);
        button3.setFocusable(false);
        button3.setForeground(Color.WHITE);
        menuBar.add(button3);
        
        JButton button4=new JButton("PNR ENQUIRY");
        button4.setOpaque(true);
        button4.setContentAreaFilled(false);
        button4.setBorderPainted(false);
        button4.setFocusable(false);
        button4.setForeground(Color.WHITE);
        menuBar.add(button4);
	
        JButton Help=new JButton("HELP");
        Help.setOpaque(true);
        Help.setContentAreaFilled(false);
        Help.setBorderPainted(false);
        Help.setFocusable(false);
        Help.setForeground(Color.WHITE);
        menuBar.add(Help);
        
	RailDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Railway_Info();
            }
	});
	button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Add_Customer();
		} catch (Exception e) {
                    e.printStackTrace();
		} 
            }
	});
		
        PassengerDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Journey_Details();
                } catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
		
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Payment_Details();
		} catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
		
        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Cancel();
            }
	});
        
        button4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new PNR_Enquiry();
            }
	});
        
        Help.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Help();
            }
	});
//        setBackground(Color.CYAN);
        setSize(1950,1090);
        setLocation(0,0);
	setVisible(true);
    }
}
