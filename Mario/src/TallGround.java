import javax.swing.ImageIcon;

public class TallGround extends Obstacol{
	public static final int TALL_GROUND_LEVEL = 230;
	public static final int TALL_GROUND_WIDTH = 267;
	
	private ImageIcon tallGroundImg;
	
	public TallGround(int xGround, int yGround, int w, int h) {
		super(xGround, yGround, w, h);
		tallGroundImg = ResourceLoader.load("Images/tall_ground.gif");
		this.setLayout(null);
		this.setIcon(tallGroundImg);
		this.setBounds(super.x, super.y, super.w, super.h);
	}
	
}
