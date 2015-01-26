package org.teipir.softeng.jdbc;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login {

	public JFrame frame;

	/**
	 * Launch the application.
	 */

    Connection connection=null;
    private JTextField textField;
    private JPasswordField passwordField_1;
    private JLabel label;
   
	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public login() throws SQLException {
		initialize();
		connection = database.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(59, 51, 81, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(59, 96, 81, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(129, 51, 89, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(129, 96, 89, 26);
		frame.getContentPane().add(passwordField_1);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="select * from admin where username=? and password=? ";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,textField.getText() );
					pst.setString(2,passwordField_1.getText() );
					
					ResultSet rs=pst.executeQuery();
					int count=0;
					while (rs.next()){
						count++;
					}
					if (count==1){
					JOptionPane.showMessageDialog(null,"login successful");
					frame.dispose();
					admin adm=new admin();
					adm.setVisible(true);
					}
					
					else{
						JOptionPane.showMessageDialog(null,"login failed");}
				}
				
					
					catch(Exception e){
						JOptionPane.showMessageDialog(null, e);
						
					}
			}
		});
		btnNewButton.setBounds(80, 145, 104, 36);
		frame.getContentPane().add(btnNewButton);
		
		label = new JLabel("");
		Image img1= new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		label.setIcon(new ImageIcon(img1));
		label.setBounds(250, 38, 158, 176);
		frame.getContentPane().add(label);
		
		
		
	
	}


	}

