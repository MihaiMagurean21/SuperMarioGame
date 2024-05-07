import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;

public class MainMenu extends JPanel implements MouseListener{
	private ImageIcon menu;
	private ImageIcon levels;
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 731;
	
	public static final int LEVEL_WIDTH = 500;
	public static final int LEVEL_HEIGHT = 101;
	
	private int levelX = WIDTH/2 - LEVEL_WIDTH/2;
	private int levelY = MainGame.HEIGHT*3/4 + 40;
	
	private int mainX = 0;
	private int mainY = 0;
	
	private JLabel mainImage;
	private JLabel levelImage;
	
	public MainMenu() {
		this.setLayout(null);
		setBackground(Color.white);
		
		menu = ResourceLoader.load("Images/main_menu_picture.gif");
		mainImage = new JLabel();
		mainImage.setLayout(null);
		mainImage.setIcon(menu);
		mainImage.setBounds(mainX, mainY, MainMenu.WIDTH , MainMenu.HEIGHT );
		revalidate();
		repaint();
				
		levels = ResourceLoader.load("Images/levels.gif");
		levelImage = new JLabel();
		levelImage.setLayout(null);
		levelImage.setIcon(levels);
		levelImage.setBounds(levelX, levelY, LEVEL_WIDTH, LEVEL_HEIGHT);
		
		this.add(levelImage);
		this.add(mainImage);
		
		addMouseListener(this);

		this.setPreferredSize(new java.awt.Dimension(WIDTH, HEIGHT));
	}


	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if(isOnLevels(x,y)) {
			MainClass.setLevelsMenuFrame();
		}
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if(isOnLevels(x,y)) {
			MainClass.setLevelsMenuFrame();
		}
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}
	
	private boolean isOnLevels(int x, int y) {
		if(x >= levelX && x <= levelX + LEVEL_WIDTH) {
			if(y >= levelY && y <= levelY + LEVEL_HEIGHT) {
				return true;
			}
		}
		return false;
	}

	
}
