import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.sql.*;

public class second extends JFrame {
 
	private JPanel contentPane;
	private final JLabel label = new JLabel("");
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JPasswordField tf5;
	private JPasswordField tf6;
	protected Object  rse;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					second frame = new second();
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
	public second() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		label.setBounds(5, 5, 424, 0);
		contentPane.add(label);
		
		JLabel lblPleaseFillYour = new JLabel("Please Fill Your Details");
		lblPleaseFillYour.setBounds(128, 16, 156, 14);
		contentPane.add(lblPleaseFillYour);
		
		tf1 = new JTextField();
		tf1.setBounds(225, 86, 187, 20);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setBounds(225, 130, 187, 20);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		tf3 = new JTextField();
		tf3.setBounds(225, 175, 187, 20);
		contentPane.add(tf3);
		tf3.setColumns(10);
		
		tf4 = new JTextField();
		tf4.setBounds(225, 223, 187, 20);
		contentPane.add(tf4);
		tf4.setColumns(10);
		JButton b1 = new JButton("Sign up");
		b1.setVisible(true);
		contentPane.add(b1);

		b1.addActionListener(new ActionListener() {
			Connection con;
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(Arrays.equals(tf5.getPassword(),tf6.getPassword()))
					{
						Class.forName("java.sql.Driver");
						 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
						PreparedStatement stmt=con.prepareStatement("insert into tblogin values(?,?,?,?,?)");
						stmt.setString(1,tf4.getText());
						stmt.setString(2,tf5.getText());
						stmt.setString(3,tf1.getText());
						stmt.setString(4,tf2.getText());
						stmt.setString(5,tf3.getText());
			int rs=stmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"Sign Up Sucessfully....");}
				else{
						JOptionPane.showMessageDialog(null,"Password don't match");
					}
				}catch(Exception e) {System.out.print(e);}
			try {
				con.close();
			}
			catch(Exception e)
			{
				
			}
			}});
		b1.setBounds(133, 430, 232, 23);
		
		JLabel lblName = new JLabel("Full Name");
		lblName.setBounds(74, 89, 86, 14);
		contentPane.add(lblName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(74, 226, 60, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPhoneNumber = new JLabel("Email Id");
		lblPhoneNumber.setBounds(74, 178, 46, 14);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(74, 274, 46, 14);
		contentPane.add(lblPassword);
		
		JLabel lblPhoneNumber_1 = new JLabel("Phone number");
		lblPhoneNumber_1.setBounds(74, 133, 86, 14);
		contentPane.add(lblPhoneNumber_1);
		
		JLabel lblConfirmPassward = new JLabel("Confirm Passward");
		lblConfirmPassward.setBounds(74, 323, 113, 14);
		contentPane.add(lblConfirmPassward);
		
		tf5 = new JPasswordField();
		tf5.setBounds(225, 271, 187, 20);
		contentPane.add(tf5);
		
		tf6 = new JPasswordField();
		tf6.setBounds(225, 320, 187, 20);
		contentPane.add(tf6);
		
	
	}
	protected static Object executeUpdate(String query) {
		return null;
	}

	public void NewScreen() {
		// TODO Auto-generated method stub
		
	}
}
