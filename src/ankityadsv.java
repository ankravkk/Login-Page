
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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ankityadsv() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 290, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginPage = new JLabel("LOGIN PAGE");
		lblLoginPage.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblLoginPage.setBounds(58, 26, 147, 29);
		contentPane.add(lblLoginPage);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(38, 100, 48, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(38, 141, 46, 14);
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
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
					Statement stmt=con.createStatement();
					String sql="Select * from tblogin where username='"+user.getText()+"'and password='"+password.getText().toString()+"'";
				ResultSet rs=stmt.executeQuery(sql);
				if(rs.next())
					JOptionPane.showMessageDialog(null, "Login Successfully.......");
				else
					JOptionPane.showMessageDialog(null, "Incorrect password or username.......");
 con.close();
				}catch(Exception e) {System.out.print(e);}
			}
		});
		btnNewButton.setBounds(58, 179, 130, 23);
		contentPane.add(btnNewButton);
	}
}
