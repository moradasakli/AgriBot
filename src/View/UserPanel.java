package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Class.FieldScannerDB;
import Class.User;
import Util.DataBaseConnection;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class UserPanel extends JFrame {
	static Connection con = DataBaseConnection.getConnection();
	private int col;
	private int row;
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPanel frame = new UserPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public UserPanel() {
		setTitle("User Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 478);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JButton btnautoS = new JButton("Start auto working");
		btnautoS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TutorialDB t = new TutorialDB();
				
			t.run();
				
				
			}
		});
		btnautoS.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		btnautoS.setBounds(78, 90, 251, 74);
		contentPane.add(btnautoS);

		JButton btnmanual = new JButton("Start manual working");
		btnmanual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				User user=new User();
				try {
					user.openManualWork();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnmanual.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		btnmanual.setBounds(526, 90, 251, 74);
		contentPane.add(btnmanual);

		JButton btnscanfield = new JButton("ScanField");
		btnscanfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM user";

					// create the java statement
					Statement st = con.createStatement();

					// execute the query, and get a java resultset
					ResultSet rs = st.executeQuery(query);

					// iterate through the java resultset
					while (rs.next()) {
						String firstName = rs.getString("username");
						int dataBasecol = rs.getInt("col");
						int dataBaserow = rs.getInt("row");
						if (firstName.equals(LoginAdminUser.online)) {
							col = dataBasecol;
							row = dataBaserow;
						}

					}

					st.close();

				} catch (Exception e1) {
					System.err.println("Got an exception! ");
					System.err.println(e1.getMessage());
				}
					FieldScannerDB t = new FieldScannerDB();
					JFrame jf = new JFrame();
					jf.setTitle("Field");
					jf.setSize(col, row);
					jf.setVisible(true);
					jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					jf.add(t);
			}
		});
		btnscanfield.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		btnscanfield.setBounds(78, 233, 251, 74);
		contentPane.add(btnscanfield);

		JButton btnlogout = new JButton("Logout");
		btnlogout.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println(LoginAdminUser.online);
				dispose();
				new LoginAdminUser().setVisible(true);
			}
		});
		btnlogout.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		btnlogout.setBounds(526, 233, 251, 74);
		contentPane.add(btnlogout);
		
	}

}
