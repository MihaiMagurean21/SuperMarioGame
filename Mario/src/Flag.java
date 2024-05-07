import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Flag extends JLabel{
	public static final int FLAG_HEIGHT = 256;
	public static final int FLAG_WIDTH = 100;
	
	private ImageIcon flagImg;
	
	public Flag(int xGround, int yGround) {
		flagImg = ResourceLoader.load("Images/flag.gif");
		this.setLayout(null);
		this.setIcon(flagImg);
		this.setBounds(xGround, yGround, FLAG_HEIGHT, FLAG_WIDTH);
	}
}
