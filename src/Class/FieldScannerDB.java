package Class;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import Util.DataBaseConnection;

public class FieldScannerDB extends JPanel implements ActionListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Timer tm = new Timer(5, this);
	int x = 0, y = 0, VelX = 0, VelY = 0;
	static Connection con = DataBaseConnection.getConnection();
	Statement statement;
	
	
	
	
	public FieldScannerDB() {
		tm.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(x, y, 50, 30);
	}

	public void actionPerformed(ActionEvent e) {
		if (x < 0) {
			VelX = 0;
			x = 0;
		}

		if (x > 530) {
			VelX = 0;
			x = 530;
		}
		if (y < 0) {
			VelY = 0;
			y = 0;
		}
		if (y > 330) {
			VelY = 0;
			y = 330;
		}
		x = x + VelX;
		y = y + VelY;
		repaint();
	}

	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
	
			if (c == KeyEvent.VK_LEFT) {
				VelX = -1;
				VelY = 0;
				try {
					System.out.println(View.LoginAdminUser.getOnline());
					/*Statement st=con.createStatement();
					st.executeUpdate("insert into "+View.LoginAdminUser.getOnline()+"VALUES('UP')");*/
					String sql = "insert into "+View.LoginAdminUser.getOnline()+"(`MOVE`) values(?)";
					//הכנת הצהרה להכנסת נתונים
					PreparedStatement ps = con.prepareStatement(sql);
					//שליחת פרמטרים לשאילתה
					ps.setString(1, "left");
					int x = ps.executeUpdate();
					if(x > 0) {
						System.out.println("left is added");					
					} else {
						System.out.println("left is not added");					
					}
					
					}catch(Exception e1) {
						e1.getMessage();
					}
			}
			if (c == KeyEvent.VK_UP) {
				VelX = 0;
				VelY = -1;
				try {
				System.out.println("up yes");
				System.out.println(View.LoginAdminUser.getOnline());
				/*Statement st=con.createStatement();
				st.executeUpdate("insert into "+View.LoginAdminUser.getOnline()+"VALUES('UP')");*/
				String sql = "insert into "+View.LoginAdminUser.getOnline()+"(`MOVE`) values(?)";
				//הכנת הצהרה להכנסת נתונים
				PreparedStatement ps = con.prepareStatement(sql);
				//שליחת פרמטרים לשאילתה
				ps.setString(1, "up");
				int x = ps.executeUpdate();
				if(x > 0) {
					System.out.println("up is added");					
				} else {
					System.out.println("up is not added");					
				}
				
				}catch(Exception e1) {
					e1.getMessage();
				}
			
			}
			if (c == KeyEvent.VK_RIGHT) {
				VelX = 1;
				VelY = 0;
				try {
					System.out.println(View.LoginAdminUser.getOnline());
					/*Statement st=con.createStatement();
					st.executeUpdate("insert into "+View.LoginAdminUser.getOnline()+"VALUES('UP')");*/
					String sql = "insert into "+View.LoginAdminUser.getOnline()+"(`MOVE`) values(?)";
					//הכנת הצהרה להכנסת נתונים
					PreparedStatement ps = con.prepareStatement(sql);
					//שליחת פרמטרים לשאילתה
					ps.setString(1, "right");
					int x = ps.executeUpdate();
					if(x > 0) {
						System.out.println("right is added");					
					} else {
						System.out.println("right is not added");					
					}
					
					}catch(Exception e1) {
						e1.getMessage();
					}
			}
			if (c == KeyEvent.VK_DOWN) {
				VelX = 0;
				VelY = 1;
				try {
					System.out.println(View.LoginAdminUser.getOnline());
					/*Statement st=con.createStatement();
					st.executeUpdate("insert into "+View.LoginAdminUser.getOnline()+"VALUES('UP')");*/
					String sql = "insert into "+View.LoginAdminUser.getOnline()+"(`MOVE`) values(?)";
					//הכנת הצהרה להכנסת נתונים
					PreparedStatement ps = con.prepareStatement(sql);
					//שליחת פרמטרים לשאילתה
					ps.setString(1, "down");
					int x = ps.executeUpdate();
					if(x > 0) {
						System.out.println("down is added");					
					} else {
						System.out.println("down is not added");					
					}
					
					}catch(Exception e1) {
						e1.getMessage();
					}
			}

			if (c == KeyEvent.VK_ENTER) {

				JComponent comp = (JComponent) e.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
			}
		}

	


	public void keyTyped(KeyEvent e) {
	}

	public static void main(String[] args) {
		ManualWork t = new ManualWork();
		JFrame jf = new JFrame();
		jf.setTitle("Tutorial");
		jf.setSize(600, 400);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(t);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		VelX = 0;
		VelY = 0;
	}

}
