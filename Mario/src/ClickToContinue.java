import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ClickToContinue extends JLabel{
	
	private ImageIcon msgImage;
	
	public static final int msgWidth = 250;
	public static final int msgHeight = 38;
	
	public ClickToContinue() {
		msgImage = ResourceLoader.load("Images/click_to_continue.gif");
		this.setLayout(null);
		this.setIcon(msgImage);
		this.setBounds(MainGame.WIDTH/2 - msgWidth/2, 100, msgWidth, msgHeight);

	}
}
