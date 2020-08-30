package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Class.Admin;
import Class.Field;
import Class.User;
import Util.DataBaseConnection;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CreateUser extends JFrame {
	static Connection con = DataBaseConnection.getConnection();
	private JPanel contentPane;
	private JTextField fieldid;
	private JTextField fieldusername;
	private JTextField fieldpassword;
	private JTextField fieldcol;
	private JTextField fieldrow;
	Statement stmt = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateUser frame = new CreateUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CreateUser() {
		setTitle("Admin Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 978, 478);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("David", Font.BOLD, 33));
		lblNewLabel.setBounds(24, 37, 102, 36);
		contentPane.add(lblNewLabel);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(Color.DARK_GRAY);
		lblUserName.setFont(new Font("David", Font.BOLD, 33));
		lblUserName.setBounds(24, 153, 169, 36);
		contentPane.add(lblUserName);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.DARK_GRAY);
		lblPassword.setFont(new Font("David", Font.BOLD, 33));
		lblPassword.setBounds(24, 262, 137, 36);
		contentPane.add(lblPassword);

		JLabel lblFieldInfo = new JLabel("Field Information");
		lblFieldInfo.setForeground(Color.DARK_GRAY);
		lblFieldInfo.setFont(new Font("David", Font.BOLD, 33));
		lblFieldInfo.setBounds(433, 50, 260, 36);
		contentPane.add(lblFieldInfo);

		JLabel lblcol = new JLabel("col");
		lblcol.setForeground(Color.DARK_GRAY);
		lblcol.setFont(new Font("David", Font.BOLD, 33));
		lblcol.setBounds(392, 123, 102, 36);
		contentPane.add(lblcol);

		JLabel lblrow = new JLabel("row");
		lblrow.setForeground(Color.DARK_GRAY);
		lblrow.setFont(new Font("David", Font.BOLD, 33));
		lblrow.setBounds(677, 123, 102, 36);
		contentPane.add(lblrow);

		fieldid = new JTextField();
		fieldid.setBounds(44, 71, 137, 45);
		contentPane.add(fieldid);
		fieldid.setColumns(10);

		fieldusername = new JTextField();
		fieldusername.setColumns(10);
		fieldusername.setBounds(44, 200, 137, 45);
		contentPane.add(fieldusername);

		fieldpassword = new JTextField();
		fieldpassword.setColumns(10);
		fieldpassword.setBounds(44, 305, 137, 45);
		contentPane.add(fieldpassword);

		fieldcol = new JTextField();
		fieldcol.setColumns(10);
		fieldcol.setBounds(358, 170, 137, 45);
		contentPane.add(fieldcol);

		fieldrow = new JTextField();
		fieldrow.setColumns(10);
		fieldrow.setBounds(642, 165, 137, 45);
		contentPane.add(fieldrow);

		JButton btncreate = new JButton("Create");
		btncreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Field field = new Field(Integer.parseInt(fieldcol.getText()), Integer.parseInt(fieldrow.getText()));
					User user = new User(Integer.parseInt(fieldid.getText()), fieldusername.getText(),
							fieldpassword.getText(), field);
					Admin admin = new Admin();
					admin.createUser(user);
					fieldid.setText(null);
					fieldusername.setText(null);
					fieldpassword.setText(null);
					fieldrow.setText(null);
					fieldcol.setText(null);

				} catch (Exception e1) {
					System.out.println(e1);
				}

			}
		});
		btncreate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btncreate.setBounds(642, 360, 102, 81);
		contentPane.add(btncreate);

		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				dispose();
				new AdminPanel().setVisible(true);
			}
		});
		btnback.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnback.setBounds(816, 360, 102, 81);
		contentPane.add(btnback);
	}
}
