;
public class Level6 extends Levels {
	
	private static int groundWidth = Ground.WIDTH;
	private static int brickSize = Brick.BRICK_HEIGHT;
	private static int marioHeight = Mario.MARIO_HEIGHT;
	private static int marioJump = Mario.MARIO_JUMP_HEIGHT;
	private static int lineWidth = Line.LINE_WIDTH;
	private static int flagWidth = Flag.FLAG_WIDTH;
	
	private static int brick1x = groundWidth;
	private static int brick1y = MainGame.HEIGHT - Ground.GROUND_LEVEL - Mario.MARIO_JUMP_HEIGHT + 25;
	private static int brick2x = brick1x + brickSize;
	private static int brick2y = brick1y;
	private static int brick3x = brick2x + brickSize;
	private static int brick3y = brick1y;
	
	private static int question1x = brick2x;
	private static int question1y = brick1y - marioHeight - marioJump + 10;
	
	private static int tube1x = brick1x + 400;
	private static int tube1y = MainGame.HEIGHT - Ground.GROUND_LEVEL - Tube.SMALL_GROUND_HEIGHT;
	
	private static int line1x = 2*Ground.WIDTH;
	private static int line1y = MainGame.HEIGHT - Ground.GROUND_LEVEL - 130;
	
	private static int line2x = line1x + 300;
	private static int line2y = line1y + 100;
	
	private static int line3x = line2x + 100;
	private static int line3y = line1y - 100;
	
	private static int line4x = line2x + 400;
	private static int line4y = line1y + 30;
	
	private static int line5x = line3x + 650;
	private static int line5y = line3y - 80;
	
	private static int flagX = line5x + lineWidth/2 - flagWidth/2;
	private static int flagY = line5y - Flag.FLAG_HEIGHT + 1;
	
	public Level6() {
		super(12, flagX, flagY, 0);
		obstacol[0] = new Ground(0*Ground.WIDTH, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH, Ground.GROUND_LEVEL );
		obstacol[1] = new Ground(1*Ground.WIDTH, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH/2, Ground.GROUND_LEVEL );
		obstacol[2] = new Tube(tube1x, tube1y, 1, true);
		obstacol[3] = new Brick(brick1x, brick1y);
		obstacol[4] = new Brick(brick2x, brick2y);
		obstacol[5] = new Brick(brick3x, brick3y);
		obstacol[6] = new QuestionBlock(question1x, question1y);
		obstacol[7] = new Line(line1x, line1y);
		obstacol[8] = new Line(line2x, line2y);
		obstacol[9] = new Line(line3x, line3y);
		obstacol[10] = new Line(line4x, line4y);
		obstacol[11] = new Line(line5x, line5y);
		
		//obstacol[12] = new QuestionBlock(question1x - questionWidth, question1y);
		
		
		
	}
}
