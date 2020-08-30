package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Util.DataBaseConnection;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginAdminUser extends JFrame {

	private static final long serialVersionUID = 1L;
	static Connection con = DataBaseConnection.getConnection();
	private JPanel contentPane;
	private JTextField fieldadminname;
	private JTextField fieldadminpass;
	private JTextField fieldusername;
	private JTextField fielduserpass;
	static String online;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdminUser frame = new LoginAdminUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setOnline(String s) {
		LoginAdminUser.online = s;

	}

	public static String getOnline() {
		return online;
	}
	
	public LoginAdminUser() {
		setType(Type.UTILITY);
		setTitle("Login Panel");
		setBackground(Color.RED);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 548);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(51, 204, 153));
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBounds(105, 41, 186, 68);
		contentPane.add(lblNewLabel);

		JLabel lblUserLogin = new JLabel("User Login");
		lblUserLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserLogin.setForeground(Color.YELLOW);
		lblUserLogin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUserLogin.setBackground(new Color(51, 204, 153));
		lblUserLogin.setBounds(563, 41, 186, 68);
		contentPane.add(lblUserLogin);

		JLabel lblAdminName = new JLabel("Admin Name");
		lblAdminName.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminName.setForeground(Color.BLUE);
		lblAdminName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAdminName.setBackground(new Color(51, 204, 153));
		lblAdminName.setBounds(10, 131, 186, 68);
		contentPane.add(lblAdminName);

		JLabel lblAdminPass = new JLabel("Admin Pass");
		lblAdminPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminPass.setForeground(Color.BLUE);
		lblAdminPass.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAdminPass.setBackground(new Color(51, 204, 153));
		lblAdminPass.setBounds(10, 269, 186, 68);
		contentPane.add(lblAdminPass);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setForeground(Color.BLUE);
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUserName.setBackground(new Color(51, 204, 153));
		lblUserName.setBounds(450, 131, 186, 68);
		contentPane.add(lblUserName);

		JLabel lblUserPass = new JLabel("User Pass");
		lblUserPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserPass.setForeground(Color.BLUE);
		lblUserPass.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUserPass.setBackground(new Color(51, 204, 153));
		lblUserPass.setBounds(450, 269, 186, 68);
		contentPane.add(lblUserPass);

		fieldadminname = new JTextField();
		fieldadminname.setBounds(105, 198, 124, 36);
		contentPane.add(fieldadminname);
		fieldadminname.setColumns(10);

		fieldadminpass = new JTextField();
		fieldadminpass.setColumns(10);
		fieldadminpass.setBounds(105, 337, 124, 36);
		contentPane.add(fieldadminpass);

		fieldusername = new JTextField();
		fieldusername.setColumns(10);
		fieldusername.setBounds(537, 198, 124, 36);
		contentPane.add(fieldusername);

		fielduserpass = new JTextField();
		fielduserpass.setColumns(10);
		fielduserpass.setBounds(537, 337, 124, 36);
		contentPane.add(fielduserpass);

		Icon icon4 = new ImageIcon("Pics/adminlogin.jpg");
		JButton btnadminlogin = new JButton(icon4);
	
		btnadminlogin.setBounds(140, 415, 89, 51);
		contentPane.add(btnadminlogin);

		Icon icon5 = new ImageIcon("Pics/user.png");
		JButton btnuserlogin = new JButton(icon5);
		btnuserlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement st;
				ResultSet rs;

				String name = fieldusername.getText();
				String password = fielduserpass.getText();
				
				String query = "SELECT * FROM `user` WHERE `username` = ? AND `password` = ?";
				try {
					st = con.prepareStatement(query);

					st.setString(1, name);
					st.setString(2, password);

					rs = st.executeQuery();

					if (rs.next()) {
						dispose();
						setOnline(fieldusername.getText());
						new UserPanel().setVisible(true);

					} else {
						JOptionPane.showMessageDialog(null, "Incorrect username or password", "Failed",
								JOptionPane.ERROR_MESSAGE);
						fieldusername.setText(null);
						fielduserpass.setText(null);
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnuserlogin.setBounds(768, 325, 89, 51);
		contentPane.add(btnuserlogin);

		JButton btnexit = new JButton("Exit");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		btnexit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnexit.setBounds(839, 11, 89, 23);
		contentPane.add(btnexit);
		btnadminlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement st;
				ResultSet rs;

				String name = fieldadminname.getText();
				String password = fieldadminpass.getText();
			
				String query = "SELECT * FROM `admins` WHERE `name` = ? AND `password` = ?";
				try {
					st = con.prepareStatement(query);

					st.setString(1, name);
					st.setString(2, password);

					rs = st.executeQuery();

					if (rs.next()) {
						online = fieldusername.getText();
						dispose();
						new AdminPanel().setVisible(true);

					} else {
						JOptionPane.showMessageDialog(null, "Incorrect username or password", "Failed",
								JOptionPane.ERROR_MESSAGE);
						fieldadminname.setText(null);
						fieldadminpass.setText(null);

					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
}
