package View;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AdminPanel extends JFrame {
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminPanel() {
		setTitle("Admin Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 473);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btncreate = new JButton("Create User");
		btncreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new CreateUser().setVisible(true);
			}
		});
		btncreate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btncreate.setBackground(Color.RED);
		btncreate.setBounds(82, 90, 217, 62);
		contentPane.add(btncreate);
		
		JButton btndelete = new JButton("Delete User");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new DeleteUser().setVisible(true);
			}
		});
		btndelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btndelete.setBackground(Color.RED);
		btndelete.setBounds(535, 90, 217, 62);
		contentPane.add(btndelete);
		
		JButton btnlogout = new JButton("Log out");
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginAdminUser().setVisible(true);
			}
		});
		btnlogout.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnlogout.setBackground(Color.RED);
		btnlogout.setBounds(310, 264, 217, 62);
		contentPane.add(btnlogout);
	}
}
