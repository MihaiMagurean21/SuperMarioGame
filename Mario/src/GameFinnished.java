import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameFinnished extends JPanel implements MouseListener{

	public static final int WIDTH = 1300;
	public static final int HEIGHT = 731;
	
	private static final int MARIO_WIDTH = 250;
	private static final int MARIO_HEIGHT = 349;
	
	private static final int MENU_WIDTH = 248;
	private static final int MENU_HEIGHT = 112;
	
	private static final int COMPLETED_WIDTH = 300;
	private static final int COMPLETED_HEIGHT = 58;
	
	private ImageIcon mario;
	private JLabel marioImage;
	
	private ImageIcon menu;
	private JLabel menuImage;
	
	private ImageIcon completed;
	private JLabel completedImage;
	
	private static int mariox = GameFinnished.WIDTH/2 - GameFinnished.MARIO_WIDTH/2;
	private static int marioy = GameFinnished.HEIGHT/8;
	
	private static int menux = GameFinnished.WIDTH/2 - GameFinnished.MENU_WIDTH/2;
	private static int menuy = GameFinnished.HEIGHT*3/4;
	
	private static int completedx = GameFinnished.WIDTH/2 - GameFinnished.COMPLETED_WIDTH/2;
	private static int completedy = GameFinnished.HEIGHT*3/4 - 100;
	
	
	public GameFinnished() {
		this.setLayout(null);
		setBackground(new Color(1, 191, 253));
		
		mario = ResourceLoader.load("Images/game_finnished_mario.gif");
		marioImage = new JLabel();
		marioImage.setLayout(null);
		marioImage.setIcon(mario);
		marioImage.setBounds(mariox, marioy, MARIO_WIDTH, MARIO_HEIGHT);
		this.add(marioImage);
		
		menu = ResourceLoader.load("Images/next_level_menu.gif");
		menuImage = new JLabel();
		menuImage.setLayout(null);
		menuImage.setIcon(menu);
		menuImage.setBounds(menux, menuy, MENU_WIDTH, MENU_HEIGHT);
		this.add(menuImage);
		
		completed = ResourceLoader.load("Images/game_completed.gif");
		completedImage = new JLabel();
		completedImage.setLayout(null);
		completedImage.setIcon(completed);
		completedImage.setBounds(completedx, completedy, COMPLETED_WIDTH, COMPLETED_HEIGHT);
		this.add(completedImage);
		
		this.setPreferredSize(new java.awt.Dimension(WIDTH, HEIGHT));
		addMouseListener(this);
	}
	
	
	public void mouseClicked(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if(isOnMenu(x,y)) {
			MainClass.setMenuFrame();
		}
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	private boolean isOnMenu(int x, int y) {
		if(x >= menux && x <= menux + MENU_WIDTH) {
			if(y >= menuy && y <= menuy + MENU_HEIGHT) {
				return true;
			}
		}
		return false;
	}
}
