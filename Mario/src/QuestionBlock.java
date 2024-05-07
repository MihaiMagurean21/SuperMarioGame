import javax.swing.ImageIcon;

public class QuestionBlock extends Obstacol{
	public static final int QUESTION_HEIGHT = 50;
	public static final int QUESTION_WIDTH = 50;
	
	private boolean explored = false;
	
	private ImageIcon questionImg;
	private ImageIcon blockImg;
	
	public QuestionBlock(int xQuestion, int yQuestion) {
		super(xQuestion, yQuestion, QUESTION_WIDTH, QUESTION_HEIGHT);
		questionImg = ResourceLoader.load("Images/question_block.gif");
		blockImg = ResourceLoader.load("Images/empty_block.gif");
		this.setLayout(null);
		this.setIcon(questionImg);
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
