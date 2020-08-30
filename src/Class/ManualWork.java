package Class;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class ManualWork extends JPanel implements ActionListener,KeyListener {
	Timer tm= new Timer(5,this);
	int x=0,y=0,VelX=0,VelY=0;
	Graphics g1;
	String COLORR;
	public ManualWork() {
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
		if(x<0) {
			VelX=0;
			x=0;
		}
		
		if(x> 530) {
			VelX=0;
			x=530;
		}
		if(y<0) {
			VelY=0;
			y=0;
		}
		if(y>330) {
			VelY=0;
			y=330;
		}
		x=x+VelX;
		y=y+VelY;
		repaint();
	}
	
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		
		if(c==KeyEvent.VK_LEFT) {
			VelX=-1;
			VelY=0;
		}
		if(c==KeyEvent.VK_UP) {
			VelX=0 ;
			VelY=-1;
			
		}
		if(c==KeyEvent.VK_RIGHT) {
			VelX=1;
			VelY=0;
			
		}
		if(c==KeyEvent.VK_DOWN) {
			VelX=0;
			VelY=1;
		}
		if(c==KeyEvent.VK_ENTER)
		{	
			

		}

		if(c==KeyEvent.VK_ESCAPE) {
			 JComponent comp = (JComponent) e.getSource();
			  Window win = SwingUtilities.getWindowAncestor(comp);
			  win.dispose();
		}
		
	}
	
	public void keyTyped(KeyEvent e) {}
	
	
	public static void main(String[] args) {
		ManualWork t=new ManualWork();
		JFrame jf=new JFrame();
		jf.setTitle("Tutorial");
		jf.setSize(600, 400);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(t);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		VelX=0;
		VelY=0;	
	}

}
