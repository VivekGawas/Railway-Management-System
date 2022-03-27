/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package railway.management.system;

/**
 *
 * @author HP
 */


import java.awt.*;
import javax.swing.*;



public class Help extends JFrame{

    public static void main(String[] args) {
        new Help().setVisible(true);
    }
    
    public Help() {

        super("Help");
//        setBackground(Color.CYAN);
        initialize();
//        setBackground(Color.CYAN);
    }

    
    private void initialize() {
//	setBackground(Color.CYAN);
        setForeground(Color.CYAN);
        setLayout(null); 
 
        
//        JFrame f=new JFrame("Help Desk");
//        f.setSize(2000,2000);
//        f.setLocationRelativeTo(null);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setVisible(true);
//        JPanel p=new JPanel();
//        p.setLayout(new FlowLayout());
        

        JLabel NewLabel = new JLabel("");
	NewLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource("railway/management/system/icon/railman5.jpg")));
	NewLabel.setBounds(100, 0, 1035, 656); 
	add(NewLabel);
        
        
        
//        setBackground(Color.CYAN);
        setSize(1950,1090);
        setLocation(0,0);
	setVisible(true);
    }
}

