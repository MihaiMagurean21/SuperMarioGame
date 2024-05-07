import javax.swing.ImageIcon;

public class Spiny extends Monster{
	public static final int SPINY_WIDTH = 52;
	public static final int SPINY_HEIGHT = 50 ;
	
	public static final int SPEED = 3;
	
	private ImageIcon spinyLeftImg;
	private ImageIcon spinyRightImg;
	
	public Spiny(int xSpiny, int ySpiny, int btx1, int btx2, double dTime) {
		super(xSpiny, ySpiny, SPINY_WIDTH, SPINY_HEIGHT, btx1, btx2, ySpiny, ySpiny, -SPEED, 0, false, dTime, true, true);
		spinyLeftImg = ResourceLoader.load("Images/spiny_looking_left.gif");
		spinyRightImg = ResourceLoader.load("Images/spiny_looking_right.gif");
		this.setLayout(null);
		this.setIcon(spinyLeftImg);
		this.setBounds(super.x, super.y, super.w, super.h);
	}
	
	public ImageIcon getLookingLeft() {
		return spinyLeftImg;
	}
	public ImageIcon getLookingRight() {
		return spinyRightImg;
	}
	
	public void changeIcon() {
		if(this.getIcon() == spinyLeftImg) {
			this.setIcon(spinyRightImg);
		}
		else {
			this.setIcon(spinyLeftImg);
		}
	}
}
