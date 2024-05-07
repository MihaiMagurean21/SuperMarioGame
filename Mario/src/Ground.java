import javax.swing.ImageIcon;

public class Ground extends Obstacol{
	public static final int GROUND_LEVEL = 100;
	public static final int WIDTH = 1000;
	
	private ImageIcon groundImg;
	
	public Ground(int xGround, int yGround, int w, int h) {
		super(xGround, yGround, w, h);
		groundImg = ResourceLoader.load("Images/Ground.gif");
		this.setLayout(null);
		this.setIcon(groundImg);
		this.setBounds(super.x, super.y, super.w, super.h);
	}
	
	
}
