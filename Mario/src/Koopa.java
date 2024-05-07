import javax.swing.ImageIcon;

public class Koopa extends Monster{
	public static final int KOOPA_WIDTH = 75;
	public static final int KOOPA_HEIGHT = 86;
	
	
	private ImageIcon koopaLeftImg;
	private ImageIcon koopaRightImg;
	
	public Koopa(int xKoopa, int yKoopa, int btx1, int btx2, int bty1, int bty2, int speedx, int speedy, double dTime) {
		super(xKoopa, yKoopa, KOOPA_WIDTH, KOOPA_HEIGHT, btx1, btx2, bty1, bty2, -speedx, -speedy, false, dTime, false, false);
		koopaLeftImg = ResourceLoader.load("Images/koopa_looking_left.gif");
		koopaRightImg = ResourceLoader.load("Images/koopa_looking_right.gif");
		this.setLayout(null);
		this.setIcon(koopaLeftImg);
		this.setBounds(super.x, super.y, super.w, super.h);
	}
	
	public ImageIcon getLookingLeft() {
		return koopaLeftImg;
	}
	public ImageIcon getLookingRight() {
		return koopaRightImg;
	}
	
	public void changeIcon() {
		if(this.getIcon() == koopaLeftImg) {
			this.setIcon(koopaRightImg);
		}
		else {
			this.setIcon(koopaLeftImg);
		}
	}
}
