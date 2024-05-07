import javax.swing.ImageIcon;

public class Bullet extends Monster{
	public static final int BULLET_WIDTH = 78;
	public static final int BULLET_HEIGHT = 52 ;
	
	public static final int SPEED = 4;
	
	private ImageIcon bulletLeftImg;
	private ImageIcon bulletRightImg;
	
	public Bullet(int xBullet, int yBullet, double dTime) {
		super(xBullet, yBullet, BULLET_WIDTH, BULLET_HEIGHT, -100000, 100000, yBullet, yBullet, -SPEED, 0, true, dTime, false, false);
		bulletLeftImg = ResourceLoader.load("Images/bullet_looking_left.gif");
		bulletRightImg = ResourceLoader.load("Images/bullet_looking_right.gif");
		this.setLayout(null);
		this.setIcon(bulletLeftImg);
		this.setBounds(super.x, super.y, super.w, super.h);
	}
	
	public ImageIcon getLookingLeft() {
		return bulletLeftImg;
	}
	public ImageIcon getLookingRight() {
		return bulletRightImg;
	}
	
	public void changeIcon() {
		if(this.getIcon() == bulletLeftImg) {
			this.setIcon(bulletRightImg);
		}
		else {
			this.setIcon(bulletLeftImg);
		}
	}
}
