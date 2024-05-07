import javax.swing.ImageIcon;

public class BulletBlaster extends Obstacol{
	public static final int BLASTER_WIDTH = 101;
	public static final int BLASTER_HEIGHT = 100 ;
	
	private ImageIcon blasterImg;
	
	public BulletBlaster(int xBlaster, int yBlaster) {
		super(xBlaster, yBlaster, BLASTER_WIDTH, BLASTER_HEIGHT);
		blasterImg = ResourceLoader.load("Images/blaster.gif");
		this.setLayout(null);
		this.setIcon(blasterImg);
		this.setBounds(super.x, super.y, super.w, super.h);
	}
	
	
}
