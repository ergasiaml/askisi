package org.teipir.softeng.jdbc;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;


public class admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	Connection conn=null;
	private JButton btnSave;
	private JLabel lblNewLabel;
	private JLabel lblName;
	private JLabel lblSurname;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JTextPane textPane;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JButton button_11;
	
	/**
	 * Create the frame.
	 */
	public admin() {
		conn=database.dbConnector();
		getContentPane().setLayout(null);
		
		JLabel lblBnbnbmnmnn = new JLabel("bnbnbmn,mn,n");
		lblBnbnbmnmnn.setBounds(128, 52, 193, 130);
		getContentPane().add(lblBnbnbmnmnn);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton loadtable = new JButton("\u03A0\u0391\u03A1\u0391\u039B\u0399\u0391");
		loadtable.setFont(new Font("Tahoma", Font.BOLD, 11));
		loadtable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					String query="select id,name,info,image from paralia";
					java.sql.PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
	
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception a) {
					a.printStackTrace();
				}
			
			}
		});
		loadtable.setBounds(191, 26, 89, 31);
		contentPane.add(loadtable);
		
		btnSave = new JButton("save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="insert into paralia (id,name,info) values (?,?,?)";
					java.sql.PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,textField.getText());
					pst.setString(2,textField_1.getText());
					pst.setString(3,textPane.getText());
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"data saved");
					
					pst.close();
					
				} catch (Exception a) {
					a.printStackTrace();
				}
			
				
			}
		});
		btnSave.setBounds(191, 114, 89, 31);
		contentPane.add(btnSave);
		
		lblNewLabel = new JLabel("id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 91, 37, 23);
		contentPane.add(lblNewLabel);
		
		lblName = new JLabel("name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(10, 134, 37, 23);
		contentPane.add(lblName);
		
		lblSurname = new JLabel("info");
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setBounds(105, 189, 37, 23);
		contentPane.add(lblSurname);
		
		textField = new JTextField();
		textField.setBounds(56, 93, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(56, 136, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query="delete from paralia where id=?";
					java.sql.PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,textField.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"data delete");
					
					pst.close();
					
				} catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(191, 72, 89, 31);
		contentPane.add(btnDelete);
		
		table = new JTable();
		table.setBounds(364, 223, 386, 215);
		contentPane.add(table);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query="update paralia set id='"+textField.getText()+"' ,name='"+textField_1.getText()+"' ,info='"+textPane.getText()+"'where id='"+textField.getText()+"' ";
					java.sql.PreparedStatement pst=conn.prepareStatement(query);
				
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"data updated");
					
					pst.close();
					
				} catch (Exception a) {
					a.printStackTrace();
				}
			
			}
		});
		btnUpdate.setBounds(191, 156, 89, 31);
		contentPane.add(btnUpdate);
		
		button = new JButton("\u03A0\u0391\u03A1\u039A\u0391");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select id,name,info,image from parka";
					java.sql.PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
	
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBounds(290, 26, 89, 31);
		contentPane.add(button);
		
		button_1 = new JButton("\u039C\u0395\u03A4\u03A1\u039F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select id,name,info,image from metro";
					java.sql.PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
	
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.setBounds(389, 26, 89, 31);
		contentPane.add(button_1);
		
		button_2 = new JButton("\u039C\u039F\u03A5\u03A3\u0395\u0399\u0391");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select id,name,info,image from museio";
					java.sql.PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
	
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_2.setBounds(488, 26, 89, 31);
		contentPane.add(button_2);
		
		textPane = new JTextPane();
		textPane.setBounds(10, 223, 270, 215);
		contentPane.add(textPane);
		
		button_3 = new JButton("delete");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="delete from parka where id=?";
					java.sql.PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,textField.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"data delete");
					
					pst.close();
					
				} catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_3.setBounds(290, 72, 89, 31);
		contentPane.add(button_3);
		
		button_4 = new JButton("save");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="insert into parka (id,name,info) values (?,?,?)";
					java.sql.PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,textField.getText());
					pst.setString(2,textField_1.getText());
					pst.setString(3,textPane.getText());
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"data saved");
					
					pst.close();
					
				} catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
		button_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_4.setBounds(290, 114, 89, 31);
		contentPane.add(button_4);
		
		button_5 = new JButton("update");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="update parka set id='"+textField.getText()+"' ,name='"+textField_1.getText()+"' ,info='"+textPane.getText()+"'where id='"+textField.getText()+"' ";
					java.sql.PreparedStatement pst=conn.prepareStatement(query);
				
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"data updated");
					
					pst.close();
					
				} catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
		button_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_5.setBounds(290, 156, 89, 31);
		contentPane.add(button_5);
		
		button_6 = new JButton("delete");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="delete from metro where id=?";
					java.sql.PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,textField.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"data delete");
					
					pst.close();
					
				} catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
		button_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_6.setBounds(389, 72, 89, 31);
		contentPane.add(button_6);
		
		button_7 = new JButton("save");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="insert into metro (id,name,info) values (?,?,?)";
					java.sql.PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,textField.getText());
					pst.setString(2,textField_1.getText());
					pst.setString(3,textPane.getText());
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"data saved");
					
					pst.close();
					
				} catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
		button_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_7.setBounds(389, 114, 89, 31);
		contentPane.add(button_7);
		
		button_8 = new JButton("update");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="update metro set id='"+textField.getText()+"' ,name='"+textField_1.getText()+"' ,info='"+textPane.getText()+"'where id='"+textField.getText()+"' ";
					java.sql.PreparedStatement pst=conn.prepareStatement(query);
				
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"data updated");
					
					pst.close();
					
				} catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
		button_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_8.setBounds(389, 156, 89, 31);
		contentPane.add(button_8);
		
		button_9 = new JButton("delete");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="delete from museio where id=?";
					java.sql.PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,textField.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"data delete");
					
					pst.close();
					
				} catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
		button_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_9.setBounds(488, 72, 89, 31);
		contentPane.add(button_9);
		
		button_10 = new JButton("save");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="insert into museio (id,name,info) values (?,?,?)";
					java.sql.PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,textField.getText());
					pst.setString(2,textField_1.getText());
					pst.setString(3,textPane.getText());
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"data saved");
					
					pst.close();
					
				} catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
		button_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_10.setBounds(488, 114, 89, 31);
		contentPane.add(button_10);
		
		button_11 = new JButton("update");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="update museio set id='"+textField.getText()+"' ,name='"+textField_1.getText()+"' ,info='"+textPane.getText()+"'where id='"+textField.getText()+"' ";
					java.sql.PreparedStatement pst=conn.prepareStatement(query);
				
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"data updated");
					
					pst.close();
					
				} catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
		button_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_11.setBounds(488, 156, 89, 31);
		contentPane.add(button_11);
		
		
		
		
	
	}
}
