
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ankityadsv extends JFrame {
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField password;
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
		lblLoginPage.setBounds(60, 25, 147, 29);
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
			JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
		
			Connection con;
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("java.sql.Driver");
					 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
					PreparedStatement stmt=con.prepareStatement("Select * from tblogin where username= ? and password = ? ");
					//String sql=;
				//	PreparedStatement stmt=Connectivity.connectiondb(sql);
					stmt.setString(1,user.getText());
					stmt.setString(2,password.getText());
					ResultSet rs=stmt.executeQuery();
				if(rs.next())
					JOptionPane.showMessageDialog(null, "Login Successfully.......");
				else
					JOptionPane.showMessageDialog(null, "Incorrect Password or Username.......");
				}catch(Exception e) {System.out.print(e);}
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 201, 111, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewUser = new JLabel("New User?");
		lblNewUser.setBounds(149, 184, 64, 14);
		contentPane.add(lblNewUser);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		second sc=new second();
		sc.setVisible(true);
			}
		});
		btnSignUp.setBounds(124, 201, 89, 23);
		contentPane.add(btnSignUp);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(34, 267, 46, 14);
		contentPane.add(lblNewLabel);
		
	}
}