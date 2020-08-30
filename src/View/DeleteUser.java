package View;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Class.Admin;
import Util.DataBaseConnection;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DeleteUser extends JFrame {

	static Connection con = DataBaseConnection.getConnection();
	private JPanel contentPane;
	private JTextField fieldid;
	private JTextField fieldname;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteUser frame = new DeleteUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public DeleteUser() {
		setTitle("Admin Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 488);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Enter user ID and user NAME");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(43, 51, 855, 74);
		contentPane.add(lblNewLabel);
		
		fieldid = new JTextField();
		fieldid.setBounds(152, 172, 96, 64);
		contentPane.add(fieldid);
		fieldid.setColumns(10);
		
		JButton btndelete = new JButton("Delete");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin admin = new Admin();
				try {
					admin.removeUser(Integer.parseInt(fieldid.getText()),fieldname.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				 fieldid.setText(null);
			        fieldname.setText(null);
			       

			}
		});
		btndelete.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		btndelete.setBounds(163, 277, 146, 83);
		contentPane.add(btndelete);
		
		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ggg");
				dispose();
				new AdminPanel().setVisible(true);
			}
		});
		btnback.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		btnback.setBounds(622, 277, 146, 83);
		contentPane.add(btnback);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		lblId.setBounds(166, 101, 82, 74);
		contentPane.add(lblId);
		
		fieldname = new JTextField();
		fieldname.setColumns(10);
		fieldname.setBounds(464, 172, 175, 64);
		contentPane.add(fieldname);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		lblName.setBounds(464, 101, 201, 74);
		contentPane.add(lblName);
	}
}
