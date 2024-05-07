import javax.swing.ImageIcon;

public class Line extends Obstacol{
	public static final int LINE_HEIGHT = 20;
	public static final int LINE_WIDTH = 157;
	
	private ImageIcon lineImg;
	
	public Line(int xLine, int yLine) {
		super(xLine, yLine, LINE_WIDTH, LINE_HEIGHT);
		lineImg = ResourceLoader.load("Images/line.gif");
		this.setLayout(null);
		this.setIcon(lineImg);
		this.setBounds(super.x, super.y, super.w, super.h);
	}
	
	
}
