import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class GameOver extends JPanel implements MouseListener{
	private static final int MAIN_WIDTH = 1000;
	private static final int MAIN_HEIGHT = 200;
	
	private static final int RETRY_WIDTH = 195;
	private static final int RETRY_HEIGHT = 100;
	
	private static final int MENU_WIDTH = 100;
	private static final int MENU_HEIGHT = 114;
	
	private ImageIcon gameOver;
	private JLabel mainImage;
	
	private ImageIcon retry;
	private JLabel retryImage;
	
	private ImageIcon menu;
	private JLabel menuImage;
	
	private static int mainX = MainGame.WIDTH/2 - MAIN_WIDTH/2;
	private static int mainY = 150;
	
	private static int retryX = MainGame.WIDTH/4 - RETRY_WIDTH/2;
	private static int retryY = MainGame.HEIGHT*3/5;
	
	private static int menuX = MainGame.WIDTH*3/4 - MENU_WIDTH/2;
	private static int menuY = MainGame.HEIGHT*3/5;
	
	public GameOver() {
		this.setLayout(null);
		setBackground(new Color(1, 1, 1));
		
		gameOver = ResourceLoader.load("Images/game_over.gif");
		mainImage = new JLabel();
		mainImage.setLayout(null);
		mainImage.setIcon(gameOver);
		mainImage.setBounds(mainX, mainY, MAIN_WIDTH, MAIN_HEIGHT);
		this.add(mainImage);
		
		retry = ResourceLoader.load("Images/retry.gif");
		retryImage = new JLabel();
		retryImage.setLayout(null);
		retryImage.setIcon(retry);
		retryImage.setBounds(retryX, retryY, RETRY_WIDTH, RETRY_HEIGHT);
		this.add(retryImage);
		
		menu = ResourceLoader.load("Images/main_menu_button.gif");
		menuImage = new JLabel();
		menuImage.setLayout(null);
		menuImage.setIcon(menu);
		menuImage.setBounds(menuX, menuY, MENU_WIDTH, MENU_HEIGHT);
		this.add(menuImage);
		
		this.setPreferredSize(new java.awt.Dimension(MainGame.WIDTH, MainGame.HEIGHT));
		addMouseListener(this);
	}

	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if(isOnRetry(x,y)) {
			MainClass.setNewGameFrame();
		}
		else if(isOnMenu(x,y)) {
			MainClass.setMenuFrame();
		}
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if(isOnRetry(x,y)) {
			MainClass.setNewGameFrame();
		}
		else if(isOnMenu(x,y)) {
			MainClass.setMenuFrame();
		}
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}
	
	private boolean isOnRetry(int x, int y) {
		if(x >= retryX && x <= retryX + RETRY_WIDTH) {
			if(y >= retryY && y <= retryY + RETRY_HEIGHT) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isOnMenu(int x, int y) {
		if(x >= menuX && x <= menuX + MENU_WIDTH) {
			if(y >= menuY && y <= menuY + MENU_HEIGHT) {
				return true;
			}
		}
		return false;
	}
	
}
