import javax.swing.ImageIcon;

public class InvisibleBlock extends Obstacol{
	public static final int BLOCK_WIDTH = 50;
	public static final int BLOCK_HEIGHT = 50 ;
	
	private boolean explored = false;
	
	private ImageIcon invisibleImg;
	private ImageIcon blockImg;
	
	public InvisibleBlock(int xInvisible, int yInvisible) {
		super(xInvisible, yInvisible, BLOCK_WIDTH, BLOCK_HEIGHT);
		invisibleImg = ResourceLoader.load("Images/invisible_block.gif");
		blockImg = ResourceLoader.load("Images/empty_block.gif");
		this.setLayout(null);
		this.setIcon(invisibleImg);
		this.setBounds(super.x, super.y, super.w, super.h);
	}
	
	public boolean isExplored() {
		return explored;
	}
	public void setExplored(boolean b) {
		explored = b;
	}
	public void setEmptyBlock() {
		this.setIcon(blockImg);
		revalidate();
		repaint();
	}
}
