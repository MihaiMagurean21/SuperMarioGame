import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LevelsMenu extends JPanel implements MouseListener, MouseWheelListener {
	private ImageIcon imageTitle;
	private JLabel levelTitle;
	
	private static final int WIDTH = 422;
	private static final int HEIGHT = 85;
	
	private static final int TITLE_WIDTH = 500;
	private static final int TITLE_HEIGHT = 101;
	
	private static int nrLevels = 10;
	
	private int titleX = MainGame.WIDTH/2 - TITLE_WIDTH/2;
	private int titleY = 30;
	
	private int levelX = MainGame.WIDTH/2 - WIDTH/2;
	
	private int level1Y = 140;
	private int level2Y = 234;
	private int level3Y = 328;
	private int level4Y = 422;
	private int level5Y = 516;
	private int level6Y = 610;
	private int level7Y = 704;
	private int level8Y = 798;
	private int level9Y = 892;
	private int level10Y = 986;
	
	private ImageIcon image1;
	private ImageIcon image2;
	private ImageIcon image3;
	private ImageIcon image4;
	private ImageIcon image5;
	private ImageIcon image6;
	private ImageIcon image7;
	private ImageIcon image8;
	private ImageIcon image9;
	private ImageIcon image10;
	
	private JLabel level1;
	private JLabel level2;
	private JLabel level3;
	private JLabel level4;
	private JLabel level5;
	private JLabel level6;
	private JLabel level7;
	private JLabel level8;
	private JLabel level9;
	private JLabel level10;
	
	private int scrollDist = 30;
	

	public LevelsMenu() {
		this.setLayout(null);
		setBackground(Color.white);
		
		imageTitle = ResourceLoader.load("Images/levels.gif");
		levelTitle = new JLabel();
		levelTitle.setLayout(null);
		levelTitle.setIcon(imageTitle);
		levelTitle.setBounds(titleX, titleY, TITLE_WIDTH, TITLE_HEIGHT);
		this.add(levelTitle);
		
		image1 = ResourceLoader.load("Images/level1.gif");
		level1 = new JLabel();
		level1.setLayout(null);
		level1.setIcon(image1);
		level1.setBounds(levelX, level1Y, WIDTH, HEIGHT);
		this.add(level1);
		
		image2 = ResourceLoader.load("Images/level2.gif");
		level2 = new JLabel();
		level2.setLayout(null);
		level2.setIcon(image2);
		level2.setBounds(levelX, level2Y, WIDTH, HEIGHT);
		this.add(level2);
		
		image3 = ResourceLoader.load("Images/level3.gif");
		level3 = new JLabel();
		level3.setLayout(null);
		level3.setIcon(image3);
		level3.setBounds(levelX, level3Y, WIDTH, HEIGHT);
		this.add(level3);
		
		image4 = ResourceLoader.load("Images/level4.gif");
		level4 = new JLabel();
		level4.setLayout(null);
		level4.setIcon(image4);
		level4.setBounds(levelX, level4Y, WIDTH, HEIGHT);
		this.add(level4);
		
		image5 = ResourceLoader.load("Images/level5.gif");
		level5 = new JLabel();
		level5.setLayout(null);
		level5.setIcon(image5);
		level5.setBounds(levelX, level5Y, WIDTH, HEIGHT);
		this.add(level5);
		
		image6 = ResourceLoader.load("Images/level6.gif");
		level6 = new JLabel();
		level6.setLayout(null);
		level6.setIcon(image6);
		level6.setBounds(levelX, level6Y, WIDTH, HEIGHT);
		this.add(level6);
		
		image7 = ResourceLoader.load("Images/level7.gif");
		level7 = new JLabel();
		level7.setLayout(null);
		level7.setIcon(image7);
		level7.setBounds(levelX, level7Y, WIDTH, HEIGHT);
		this.add(level7);
		
		image8 = ResourceLoader.load("Images/level8.gif");
		level8 = new JLabel();
		level8.setLayout(null);
		level8.setIcon(image8);
		level8.setBounds(levelX, level8Y, WIDTH, HEIGHT);
		this.add(level8);
		
		image9 = ResourceLoader.load("Images/level9.gif");
		level9 = new JLabel();
		level9.setLayout(null);
		level9.setIcon(image9);
		level9.setBounds(levelX, level9Y, WIDTH, HEIGHT);
		this.add(level9);
		
		image10 = ResourceLoader.load("Images/level10.gif");
		level10 = new JLabel();
		level10.setLayout(null);
		level10.setIcon(image10);
		level10.setBounds(levelX, level10Y, WIDTH, HEIGHT);
		this.add(level10);
		
		revalidate();
		repaint();
		addMouseListener(this);
		addMouseWheelListener(this);
	}
	

	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int lvl = isOnLevel(x,y);
		if(Levels.validLevel(lvl)) {
			MainClass.setGameFrame(lvl);
		}
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int lvl = isOnLevel(x,y);
		if(Levels.validLevel(lvl)) {
			MainClass.setGameFrame(lvl);
		}
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}


	public void mouseWheelMoved(MouseWheelEvent e) {
		int rotation = e.getWheelRotation();
		//scroll down
		if(rotation > 0) {
			Rectangle r = getButtonPosition(Levels.nrLevels);
			if(r.y >= MainMenu.HEIGHT - HEIGHT - 30 - scrollDist) {
				moveLevels(-scrollDist);	
			}
		}
		//scroll up
		else {
			if(titleY <= 30 - scrollDist) {
				moveLevels(scrollDist);	
			}
		}
	}
	
	private int isOnLevel(int x, int y) {
		for(int i=1;i<=nrLevels;i++) {
			Rectangle r = getButtonPosition(i);
			if(x >= r.x && x <= r.x + r.width) {
				if(y >= r.y && y <= r.y + r.height) {
					return i;
				}
			}
		}
		return -1;
	}
	
	private JLabel getLevel(int level) {
		switch(level) {
		case 1:
			return level1;
		case 2:
			return level2;
		case 3:
			return level3;
		case 4:
			return level4;
		case 5:
			return level5;
		case 6:
			return level6;
		case 7:
			return level7;
		case 8:
			return level8;
		case 9:
			return level9;
		case 10:
			return level10;
		}
		return null;
	}
	
	private Rectangle getButtonPosition(int level) {
		Rectangle r = new Rectangle();
		r.x = levelX;
		r.width = WIDTH;
		r.height = HEIGHT;
		switch(level) {
		case 1:
			r.y = level1Y;
			break;
		case 2:
			r.y = level2Y;
			break;
		case 3:
			r.y = level3Y;
			break;
		case 4:
			r.y = level4Y;
			break;
		case 5:
			r.y = level5Y;
			break;
		case 6:
			r.y = level6Y;
			break;
		case 7:
			r.y = level7Y;
			break;
		case 8:
			r.y = level8Y;
			break;
		case 9:
			r.y = level9Y;
			break;
		case 10:
			r.y = level10Y;
			break;
		}
		return r;
	}

	private void setButtonPosition(int level, Rectangle r) {
		switch(level) {
		case 1:
			level1Y = r.y;
			break;
		case 2:
			level2Y = r.y;
			break;
		case 3:
			level3Y = r.y;
			break;
		case 4:
			level4Y = r.y;
			break;
		case 5:
			level5Y = r.y;
			break;
		case 6:
			level6Y = r.y;
			break;
		case 7:
			level7Y = r.y;
			break;
		case 8:
			level8Y = r.y;
			break;
		case 9:
			level9Y = r.y;
			break;
		case 10:
			level10Y = r.y;
			break;
		}
	}
	
	private void moveLevels(int dist) {
		titleY += dist;
		levelTitle.setBounds(titleX, titleY, TITLE_WIDTH, TITLE_HEIGHT);
		for(int i=1;i<=nrLevels;i++) {
			Rectangle r = getButtonPosition(i);
			r.y += dist;
			setButtonPosition(i,r);
			getLevel(i).setBounds(r.x, r.y, r.width, r.height);	
		}
	}
}
