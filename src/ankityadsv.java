
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.Resultset;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;

public class ankityadsv extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField password;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ankityadsv frame = new ankityadsv();
					frame.setVisible(true);
				} catch (Exception e)     {
					e.printStackTrace();
				}
			}
		});
	}

	public ankityadsv() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 282, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginPage = new JLabel("LOGIN PAGE");
		lblLoginPage.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblLoginPage.setBounds(58, 26, 147, 29);
		contentPane.add(lblLoginPage);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 100, 76, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 141, 74, 14);
		contentPane.add(lblPassword);
		
		user = new JTextField();
		user.setBounds(119, 97, 86, 20);
		contentPane.add(user);
		user.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(119, 138, 86, 20);
		contentPane.add(password);
		Connection con;
		Statement stmt;
		try {
			Class.forName("java.sql.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			 stmt=con.createStatement();
		}catch(Exception e) {
			
		}
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con=null;
				Statement stmt=null;
				try {
				String sql="Select * from tblogin where username='"+user.getText()+"'and password='"+password.getText().toString()+"'";
				
				ResultSet rs=stmt.executeQuery(sql);
				if(rs.next())
					JOptionPane.showMessageDialog(null, "Login Successfully.......");
				else
					JOptionPane.showMessageDialog(null, "Incorrect password or username.......");

				}catch(Exception e) {System.out.print(e);}
			}
		});
		btnNewButton.setBounds(10, 201, 111, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewUser = new JLabel("New User?");
		lblNewUser.setBounds(149, 186, 64, 14);
		contentPane.add(lblNewUser);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {second s= new second();
				s.setVisible(true);
				     
				//	String sql="insert into tblogin values ('"+user.getText()+"','"+password.getText()+"')";
			//	String sql="Select * from tblogin where username='"+user.getText()+"'and password='"+password.getText().toString()+"'";
			//int rs=stmt.executeUpdate(sql);
			//	if(rs>0)
				//	JOptionPane.showMessageDialog(null, "SignUP Successfully.......");
				//else
					//JOptionPane.showMessageDialog(null, "Incorrect password or username.......");

				}catch(Exception e) {System.out.print(e);}
			}
			
		});
		btnNewButton_1.setBounds(149, 201, 95, 23);
		contentPane.add(btnNewButton_1);
	}
};
