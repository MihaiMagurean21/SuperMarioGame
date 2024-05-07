import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LevelPassed extends JPanel implements MouseListener{

	public static final int WIDTH = 1300;
	public static final int HEIGHT = 731;
	
	private static final int MARIO_WIDTH = 200;
	private static final int MARIO_HEIGHT = 348;
	
	private static final int BACK_WIDTH = 150;
	private static final int BACK_HEIGHT = 112;
	
	private static final int MENU_WIDTH = 248;
	private static final int MENU_HEIGHT = 112;
	
	private static final int NEXT_WIDTH = 155;
	private static final int NEXT_HEIGHT = 112;
	
	
	private ImageIcon mario;
	private JLabel marioImage;
	
	private ImageIcon menu;
	private JLabel menuImage;
	
	private ImageIcon back;
	private JLabel backImage;
	
	private ImageIcon next;
	private JLabel nextImage;
	
	
	private static int mariox = LevelPassed.WIDTH/2 - LevelPassed.MARIO_WIDTH/2;
	private static int marioy = LevelPassed.HEIGHT/8;
	
	private static int backx = LevelPassed.WIDTH*1/6 - LevelPassed.BACK_WIDTH/2;
	private static int backy = LevelPassed.HEIGHT*3/4;
	
	private static int menux = LevelPassed.WIDTH/2 - LevelPassed.MENU_WIDTH/2;
	private static int menuy = LevelPassed.HEIGHT*3/4;
	
	private static int nextx = LevelPassed.WIDTH*5/6 - LevelPassed.NEXT_WIDTH/2;
	private static int nexty = LevelPassed.HEIGHT*3/4;
	
	private int lvl;
	
	
	
	public LevelPassed(int lvl) {
		this.setLayout(null);
		
		this.lvl = lvl;
		
		mario = ResourceLoader.load("Images/next_level_mario.gif");
		marioImage = new JLabel();
		marioImage.setLayout(null);
		marioImage.setIcon(mario);
		marioImage.setBounds(mariox, marioy, MARIO_WIDTH, MARIO_HEIGHT);
		this.add(marioImage);
		
		back = ResourceLoader.load("Images/next_level_back.gif");
		backImage = new JLabel();
		backImage.setLayout(null);
		backImage.setIcon(back);
		backImage.setBounds(backx, backy, BACK_WIDTH, BACK_HEIGHT);
		this.add(backImage);
		
		menu = ResourceLoader.load("Images/next_level_menu.gif");
		menuImage = new JLabel();
		menuImage.setLayout(null);
		menuImage.setIcon(menu);
		menuImage.setBounds(menux, menuy, MENU_WIDTH, MENU_HEIGHT);
		this.add(menuImage);
		
		next = ResourceLoader.load("Images/next_level_next.gif");
		nextImage = new JLabel();
		nextImage.setLayout(null);
		nextImage.setIcon(next);
		nextImage.setBounds(nextx, nexty, NEXT_WIDTH, NEXT_HEIGHT);
		this.add(nextImage);
		
		setBackground(new Color(1, 191, 253));
		
		this.setPreferredSize(new java.awt.Dimension(WIDTH, HEIGHT));
		addMouseListener(this);
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if(isOnBack(x,y)) {
			MainClass.setGameFrame(lvl);
		}
		else if(isOnMenu(x,y)) {
			MainClass.setMenuFrame();
		}
		else if(isOnNext(x,y)) {
			MainClass.setGameFrame(lvl + 1);
		}
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}
	
	private boolean isOnBack(int x, int y) {
		if(x >= backx && x <= backx + BACK_WIDTH) {
			if(y >= backy && y <= backy + BACK_HEIGHT) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isOnMenu(int x, int y) {
		if(x >= menux && x <= menux + MENU_WIDTH) {
			if(y >= menuy && y <= menuy + MENU_HEIGHT) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isOnNext(int x, int y) {
		if(x >= nextx && x <= nextx + NEXT_WIDTH) {
			if(y >= nexty && y <= nexty + NEXT_HEIGHT) {
				return true;
			}
		}
		return false;
	}

}
