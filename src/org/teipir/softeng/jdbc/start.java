package org.teipir.softeng.jdbc;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import java.awt.Label;


public class start extends JFrame {

	private JPanel contentPane;
	public JTextPane textPane;
	public JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					start frame = new start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn=null;
	private JTable table_1;
	private JScrollPane scrollPane;
	private JTextPane textPane_1;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	
	/**
	 * Create the frame.
	 */

	
	public start() {
		conn=database.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 564);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdmin = new JButton("admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				login window = null;
				try {
					window = new login();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				window.frame.setVisible(true);
			}
		});
		btnAdmin.setBounds(10, 491, 89, 23);
		contentPane.add(btnAdmin);
		
		JLabel label = new JLabel("");
		Image img1= new ImageIcon(this.getClass().getResource("/start.png")).getImage();
		label.setIcon(new ImageIcon(img1));
		label.setBounds(329, 35, 171, 154);
		contentPane.add(label);
		
		JButton loadtable = new JButton("\u03A0\u0391\u03A1\u0391\u039B\u0399\u0395\u03A3");
		loadtable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					String query="select name from paralia";
					java.sql.PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
	
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception a) {
					a.printStackTrace();
				}
			
			}
		});
		loadtable.setBounds(62, 35, 137, 40);
		contentPane.add(loadtable);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 275, 137, 180);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int row=table_1.getSelectedRow();
					String name_=(table_1.getModel().getValueAt(row,0)).toString();
					String query="select info,image from paralia where name='"+name_+"'";
					java.sql.PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					while (rs.next()){
					textPane_1.setText(rs.getString("info"));	
					
					} 
					
				pst.close();
				
			}
				catch (Exception a) {
					a.printStackTrace();
				}
			
			try {
				int row=table_1.getSelectedRow();
				String name_=(table_1.getModel().getValueAt(row,0)).toString();
				String query="select info from parka where name='"+name_+"'";
				java.sql.PreparedStatement pst=conn.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				while (rs.next()){
				textPane_1.setText(rs.getString("info"));	
				} 
				
			pst.close();
			
		}
			catch (Exception a) {
				a.printStackTrace();
			}
		
			try {
				int row=table_1.getSelectedRow();
				String name_=(table_1.getModel().getValueAt(row,0)).toString();
				String query="select info from metro where name='"+name_+"'";
				java.sql.PreparedStatement pst=conn.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				while (rs.next()){
				textPane_1.setText(rs.getString("info"));	
				} 
				
			pst.close();
			
		}
			catch (Exception a) {
				a.printStackTrace();
			}
		
			try {
				int row=table_1.getSelectedRow();
				String name_=(table_1.getModel().getValueAt(row,0)).toString();
				String query="select info from museio where name='"+name_+"'";
				java.sql.PreparedStatement pst=conn.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				while (rs.next()){
				textPane_1.setText(rs.getString("info"));	
				} 
				
			pst.close();
			
		}
			catch (Exception a) {
				a.printStackTrace();
			}
		}
		});
		scrollPane.setViewportView(table_1);
		
		textPane_1 = new JTextPane();
		textPane_1.setBounds(268, 241, 333, 273);
		contentPane.add(textPane_1);
		
		button = new JButton("\u03A0\u0391\u03A1\u039A\u0391");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
					try {
						String query="select name from parka";
						java.sql.PreparedStatement pst=conn.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
		
						table_1.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception a) {
						a.printStackTrace();
					}
				
				}
			
			});
		button.setBounds(62, 86, 137, 40);
		contentPane.add(button);
		
		button_1 = new JButton("\u039C\u0395\u03A4\u03A1\u039F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
					
					try {
						String query="select name from metro";
						java.sql.PreparedStatement pst=conn.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						
		
						table_1.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception a) {
						a.printStackTrace();
					}
				
				}
			
		});
		button_1.setBounds(62, 137, 137, 40);
		contentPane.add(button_1);
		
		button_2 = new JButton("\u039C\u039F\u03A5\u03A3\u0395\u0399\u0391");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select name from museio";
					java.sql.PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
	
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception a) {
					a.printStackTrace();
				}
			
			}
			
		});
		button_2.setBounds(62, 190, 137, 40);
		contentPane.add(button_2);
		
	
		
	
		

		
	}
}
