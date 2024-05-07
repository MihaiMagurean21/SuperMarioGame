import javax.swing.ImageIcon;

public class Tube extends Obstacol{
	public static final int TUBE_WIDTH = 100;
	
	public static final int SMALL_GROUND_HEIGHT = 80;
	public static final int MEDIUM_GROUND_HEIGHT = 130;
	public static final int BIG_GROUND_HEIGHT = 180;
	public static final int VERY_BIG_GROUND_HEIGHT = 230;
	public static final int SUPER_BIG_GROUND_HEIGHT = 280;
	public static final int ULTRA_BIG_GROUND_HEIGHT = 330;
	
	public static final int SMALL_AIR_HEIGHT = 180;
	public static final int MEDIUM_AIR_HEIGHT = 230;
	public static final int BIG_AIR_HEIGHT = 280;
	public static final int VERY_BIG_AIR_HEIGHT = 330;
	public static final int SUPER_BIG_AIR_HEIGHT = 380;
	public static final int ULTRA_BIG_AIR_HEIGHT = 428;
	
	private ImageIcon smallTubeGroundImg;
	private ImageIcon mediumTubeGroundImg;
	private ImageIcon bigTubeGroundImg;
	private ImageIcon veryBigTubeGroundImg;
	private ImageIcon superBigTubeGroundImg;
	private ImageIcon ultraBigTubeGroundImg;
	
	private ImageIcon smallTubeAirImg;
	private ImageIcon mediumTubeAirImg;
	private ImageIcon bigTubeAirImg;
	private ImageIcon veryBigTubeAirImg;
	private ImageIcon superBigTubeAirImg;
	private ImageIcon ultraBigTubeAirImg;
	
	public Tube(int xTube, int yTube, int size, boolean ground) {
		super(xTube, yTube, TUBE_WIDTH, 0);
		this.setLayout(null);
		
		smallTubeGroundImg = ResourceLoader.load("Images/small_tube_ground.gif");
		mediumTubeGroundImg = ResourceLoader.load("Images/medium_tube_ground.gif");
		bigTubeGroundImg = ResourceLoader.load("Images/big_tube_ground.gif");
		veryBigTubeGroundImg = ResourceLoader.load("Images/medium_tube_air.gif");
		superBigTubeGroundImg = ResourceLoader.load("Images/big_tube_air.gif");
		ultraBigTubeGroundImg = ResourceLoader.load("Images/very_big_tube_air.gif");
		
		smallTubeAirImg = ResourceLoader.load("Images/small_tube_air.gif");
		mediumTubeAirImg = ResourceLoader.load("Images/medium_tube_air.gif");
		bigTubeAirImg = ResourceLoader.load("Images/big_tube_air.gif");
		veryBigTubeAirImg = ResourceLoader.load("Images/very_big_tube_air.gif");
		superBigTubeAirImg = ResourceLoader.load("Images/super_big_tube_air.gif");
		ultraBigTubeAirImg = ResourceLoader.load("Images/ultra_big_tube_air.gif");
		
		if(ground) {
			switch(size) {
			case 1:
				super.setHeight(SMALL_GROUND_HEIGHT);
				this.setIcon(smallTubeGroundImg);
				break;
			case 2:
				super.setHeight(MEDIUM_GROUND_HEIGHT);
				this.setIcon(mediumTubeGroundImg);
				break;
			case 3:
				super.setHeight(BIG_GROUND_HEIGHT);
				this.setIcon(bigTubeGroundImg);
				break;
			case 4:
				super.setHeight(VERY_BIG_GROUND_HEIGHT);
				this.setIcon(veryBigTubeGroundImg);
				break;
			case 5:
				super.setHeight(SUPER_BIG_GROUND_HEIGHT);
				this.setIcon(superBigTubeGroundImg);
				break;
			case 6:
				super.setHeight(ULTRA_BIG_GROUND_HEIGHT);
				this.setIcon(ultraBigTubeGroundImg);
				break;
			}
		}
		else {
			switch(size) {
			case 1:
				super.setHeight(SMALL_AIR_HEIGHT);
				this.setIcon(smallTubeAirImg);
				break;
			case 2:
				super.setHeight(MEDIUM_AIR_HEIGHT);
				this.setIcon(mediumTubeAirImg);
				break;
			case 3:
				super.setHeight(BIG_AIR_HEIGHT);
				this.setIcon(bigTubeAirImg);
				break;
			case 4:
				super.setHeight(VERY_BIG_AIR_HEIGHT);
				this.setIcon(veryBigTubeAirImg);
				break;
			case 5:
				super.setHeight(SUPER_BIG_AIR_HEIGHT);
				this.setIcon(superBigTubeAirImg);
				break;
			case 6:
				super.setHeight(ULTRA_BIG_AIR_HEIGHT);
				this.setIcon(ultraBigTubeAirImg);
				break;
			}
		}
		
		this.setBounds(super.x, super.y, super.w, super.h);
	}
	
	
}
