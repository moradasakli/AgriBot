package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import Util.DataBaseConnection;

@SuppressWarnings("serial")
public class TutorialDB extends JPanel implements ActionListener, KeyListener,Runnable {
	
	Timer tm = new Timer(5, this);
	static Connection con = DataBaseConnection.getConnection();
	String str;
	int x = 0, y = 0, VelX = 0, VelY = 0;
	Queue<String> loadedq = new LinkedList<String>();
	private  Thread thread;
	public TutorialDB()  {
		tm.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		//move();
	}

	/*public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(x, y, 50, 30);
 
	}*/
	
	public void paint(Graphics g) {
	
		g.setColor(Color.RED);
		g.fillRect(x, y, 50, 30);
 
	}
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		VelX = 0;
		VelY = 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public static void main(String[] args) throws Exception {
		TutorialDB t = new TutorialDB();
		JFrame jf = new JFrame();
		jf.setTitle("Tutorial");
		jf.setSize(600, 400);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(t);
		System.out.println("ready to move");
		t.move();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void move() throws InterruptedException {
		
		PreparedStatement st;
		ResultSet rs;
		try {
			String query = "SELECT * FROM `emad`";
			st = con.prepareStatement(query);
			rs = st.executeQuery();
			while (rs.next()) {
				System.out.println();

				switch (rs.getString("move")) {
				case "up":
					System.out.println("up switch case");
					VelX = 0;
					VelY = -10;
					x += VelX;
					y += VelY;
					System.out.println("up");
					repaint();
					break;
				case "down":
					System.out.println("down switch case");
					VelX = 0;
					VelY = 10;
					x += VelX;
					y += VelY;
					repaint();
					System.out.println("down");

					break;
				case "right":
					System.out.println("right switch case");
					VelX = 10;
					VelY = 0;
					x += VelX;
					y += VelY;
					repaint();
					System.out.println("right");

					break;
				case "left":
					System.out.println("left switch case");
					VelX = -10;
					VelY = 0;
					x += VelX;
					y += VelY;
					repaint();
					System.out.println("left");

					break;
				}
				TimeUnit.SECONDS.sleep(1);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public synchronized void start() {
		
	}
	private void init() {
		TutorialDB t = new TutorialDB();
		JFrame jf = new JFrame();
		jf.setTitle("Tutorial");
		jf.setSize(600, 400);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(t);	}
	public void run() {
		
		init();
		thread = new Thread(this);
		thread.start();
		PreparedStatement st;
		ResultSet rs;
		try {
			String query = "SELECT * FROM `emad`";
			st = con.prepareStatement(query);
			rs = st.executeQuery();
			while (rs.next()) {
				System.out.println();

				switch (rs.getString("move")) {
				case "up":
					System.out.println("up switch case");
					VelX = 0;
					VelY = -10;
					x += VelX;
					y += VelY;
					System.out.println("up");
					repaint();
					break;
				case "down":
					System.out.println("down switch case");
					VelX = 0;
					VelY = 10;
					x += VelX;
					y += VelY;
					repaint();
					System.out.println("down");

					break;
				case "right":
					System.out.println("right switch case");
					VelX = 10;
					VelY = 0;
					x += VelX;
					y += VelY;
					repaint();
					System.out.println("right");

					break;
				case "left":
					System.out.println("left switch case");
					VelX = -10;
					VelY = 0;
					x += VelX;
					y += VelY;
					repaint();
					System.out.println("left");

					break;
				}
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
public synchronized void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
