import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Brick extends Obstacol{
	public static final int BRICK_WIDTH = 50;
	public static final int BRICK_HEIGHT = 50 ;
	
	private ImageIcon brickImg;
	
	public Brick(int xBrick, int yBrick) {
		super(xBrick, yBrick, BRICK_WIDTH, BRICK_HEIGHT);
		brickImg = ResourceLoader.load("Images/brick.gif");
		this.setLayout(null);
		this.setIcon(brickImg);
		this.setBounds(super.x, super.y, super.w, super.h);
	}
	
	
}
