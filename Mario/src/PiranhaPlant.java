import javax.swing.ImageIcon;

public class PiranhaPlant extends Monster{
	public static final int PLANT_HEIGHT = 109;
	public static final int PLANT_WIDTH = 100;
	
	public static final int SPEED = 2;
	
	private ImageIcon plantImg;
	
	public PiranhaPlant(int xPlant, int yPlant, int bty1, int bty2, double dTime) {
		super(xPlant, yPlant, PLANT_WIDTH, PLANT_HEIGHT, xPlant, xPlant, bty1, bty2, 0, -SPEED, false, dTime, false, false);
		plantImg = ResourceLoader.load("Images/piranha_plant.gif");
		this.setLayout(null);
		this.setIcon(plantImg);
		this.setBounds(super.x, super.y, super.w, super.h);
	}

	public ImageIcon getLookingLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	public ImageIcon getLookingRight() {
		// TODO Auto-generated method stub
		return null;
	}

	public void changeIcon() {
		// TODO Auto-generated method stub
		
	}
	
	
}
