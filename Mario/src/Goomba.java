import javax.swing.ImageIcon;

public class Goomba extends Monster{
	public static final int GOOMBA_WIDTH = 50;
	public static final int GOOMBA_HEIGHT = 56 ;
	
	public static final int SPEED = 5;
	
	private ImageIcon goombaLeftImg;
	private ImageIcon goombaRightImg;
	
	public Goomba(int xGoomba, int yGoomba, int btx1, int btx2, double dTime) {
		super(xGoomba, yGoomba, GOOMBA_WIDTH, GOOMBA_HEIGHT, btx1, btx2, yGoomba, yGoomba, -SPEED, 0, true, dTime, true, true);
		goombaLeftImg = ResourceLoader.load("Images/goomba_looking_left.gif");
		goombaRightImg = ResourceLoader.load("Images/goomba_looking_right.gif");
		this.setLayout(null);
		this.setIcon(goombaLeftImg);
		this.setBounds(super.x, super.y, super.w, super.h);
	}
	
	public ImageIcon getLookingLeft() {
		return goombaLeftImg;
	}
	public ImageIcon getLookingRight() {
		return goombaRightImg;
	}
	
	public void changeIcon() {
		if(this.getIcon() == goombaLeftImg) {
			this.setIcon(goombaRightImg);
		}
		else {
			this.setIcon(goombaLeftImg);
		}
	}
}
