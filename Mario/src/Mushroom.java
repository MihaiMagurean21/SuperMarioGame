import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Mushroom extends JLabel{
	public static final int MUSHROOM_HEIGHT = 50;
	public static final int MUSHROOM_WIDTH = 50;
	
	public int xMushroom;
	public int yMushroom;
	private int wMushroom;
	private int hMushroom;
	
	private int supposedY = 0;
	private int error = 15;
	
	private int speed = 5;
	private boolean falling = false;
	private int fallingFromY;
	private int fallAcc = 10;
	private double t = 0;
	
	public static int nrMushrooms = 0;
	
	private ImageIcon mushroomImg;
	
	public Mushroom(int xMushroom, int yMushroom) {
		this.xMushroom = xMushroom;
		this.yMushroom = yMushroom;
		this.wMushroom = MUSHROOM_WIDTH;
		this.hMushroom = MUSHROOM_HEIGHT;
		mushroomImg = ResourceLoader.load("Images/good_mushroom.gif");
		this.setLayout(null);
		this.setIcon(mushroomImg);
		this.setBounds(this.xMushroom, this.yMushroom, this.wMushroom, this.hMushroom);
		
		Random r = new Random();
		int rand = r.nextInt();
		if(rand%2 == 0) {
			speed *= -1;
		}
		nrMushrooms++;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void updateMushroom(Levels level) {
		supposedY = Obstacol.yObstacolBellowMushroom(level, this, error);
		if(yMushroom < supposedY && !falling) {
			this.t = 0;
			this.falling = true;
			this.fallingFromY = yMushroom;
		}
		if(this.falling) {
			fallingMethod();
		}
		if(Obstacol.isLateralCollisionMushroom(level, this, error)) {
			this.speed *= -1;
		}
	}
	
	public void fallingMethod() {
		t += MainGame.TIME_SPEED/1000f;
		yMushroom = (int)(fallingFromY + (Mario.g * fallAcc*t * fallAcc*t)/2);
		if (yMushroom >= supposedY) {
			yMushroom = supposedY;
            falling = false;
        }
        this.setBounds(xMushroom, yMushroom, MUSHROOM_WIDTH, MUSHROOM_HEIGHT);
	}
	
	public void setMushroomX(int m) {
		this.xMushroom = m;
	}
	
	public boolean checkMarioCollision(Levels level, Mario mario) {
		Rectangle r1 = mario.getBounds();
		Rectangle r2 = this.getBounds();
		if(isOverlapping(r1, r2)) {
			mario.setMarioSize("BIG");
			this.setBounds(r2.x, r2.y + 1000, r2.width, r2.height);
			revalidate();
			repaint();
			return true;
		}
		return false;
	}
	
	public boolean isOverlapping(Rectangle r1, Rectangle r2) {
	    if (r1.y + r1.height < r2.y || r1.y > r2.y + r2.height) {
	        return false;
	    }
	    if (r1.x + r1.width < r2.x || r1.x > r2.x + r2.width) {
	        return false;
	    }
	    return true;
	}

	public static void setNrMushroom(int nr) {
		nrMushrooms = nr;
	}
	
}
