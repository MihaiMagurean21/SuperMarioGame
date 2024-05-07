import javax.swing.ImageIcon;

public class MediumGround extends Obstacol{
	public static final int MEDIUM_GROUND_LEVEL = 165;
	public static final int MEDIUM_GROUND_WIDTH = 267;
	
	private ImageIcon mediumGroundImg;
	
	public MediumGround(int xGround, int yGround, int w, int h) {
		super(xGround, yGround, w, h);
		mediumGroundImg = ResourceLoader.load("Images/medium_ground.gif");
		this.setLayout(null);
		this.setIcon(mediumGroundImg);
		this.setBounds(super.x, super.y, super.w, super.h);
	}
	
}
