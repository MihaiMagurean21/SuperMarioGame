;
public class Level5 extends Levels {
	
	private static int tubeWidth = Tube.TUBE_WIDTH;
	private static int brickSize = Brick.BRICK_WIDTH;
	private static int lineWidth = Line.LINE_WIDTH;
	private static int lineHeight = Line.LINE_HEIGHT;
	private static int groundWidth = Ground.WIDTH;
	
	private static int tube1x = groundWidth*3/2;
	private static int tube1y = MainGame.HEIGHT - Ground.GROUND_LEVEL - Tube.VERY_BIG_AIR_HEIGHT;
	
	private static int line1x = tube1x - lineWidth;
	private static int line1y = MainGame.HEIGHT - Ground.GROUND_LEVEL - 130;
	
	private static int line2x = line1x;
	private static int line2y = line1y - 130;
	private static int line21x = line1x - lineWidth;
	private static int line21y = line2y;
	
	private static int line3x = 2*groundWidth + 250;
	private static int line3y = line1y;
	private static int line4x = line3x + lineWidth;
	private static int line4y = line1y;
	
	private static int tube2x = line4x + 500;
	private static int tube2y = MainGame.HEIGHT - Tube.SUPER_BIG_AIR_HEIGHT;
	
	private static int mediumGround1x = tube2x + 600;
	private static int mediumGround1y = MainGame.HEIGHT - MediumGround.MEDIUM_GROUND_LEVEL;
	
	private static int line5x = mediumGround1x + MediumGround.MEDIUM_GROUND_WIDTH;
	private static int line5y = mediumGround1y;
	private static int line6x = line5x + lineWidth;
	private static int line6y = mediumGround1y;
	private static int line7x = line6x + lineWidth;
	private static int line7y = mediumGround1y;
	private static int line8x = line7x + lineWidth;
	private static int line8y = mediumGround1y;

	private static int mediumGround2x = line8x + lineWidth;
	private static int mediumGround2y = MainGame.HEIGHT - MediumGround.MEDIUM_GROUND_LEVEL;
	
	private static int mediumGround3x = mediumGround2x + MediumGround.MEDIUM_GROUND_WIDTH + 500;
	private static int mediumGround3y = MainGame.HEIGHT - MediumGround.MEDIUM_GROUND_LEVEL;
	private static int mediumGround4x = mediumGround3x + MediumGround.MEDIUM_GROUND_WIDTH;
	private static int mediumGround4y = MainGame.HEIGHT - MediumGround.MEDIUM_GROUND_LEVEL;
	
	private static int brick1x = mediumGround4x + TallGround.TALL_GROUND_WIDTH - brickSize;
	private static int brick1y = mediumGround4y - brickSize;
	private static int brick2x = brick1x - brickSize;
	private static int brick2y = brick1y;
	private static int brick3x = brick2x - brickSize;
	private static int brick3y = brick1y;
	private static int brick4x = brick3x - brickSize;
	private static int brick4y = brick1y;
	private static int brick5x = brick4x - brickSize;
	private static int brick5y = brick1y;
	
	private static int brick21x = brick1x;
	private static int brick21y = brick1y - brickSize;
	private static int brick22x = brick2x;
	private static int brick22y = brick21y;
	private static int brick23x = brick3x;
	private static int brick23y = brick21y;
	private static int brick24x = brick4x;
	private static int brick24y = brick21y;
	
	private static int brick31x = brick21x;
	private static int brick31y = brick21y - brickSize;
	private static int brick32x = brick22x;
	private static int brick32y = brick31y;
	private static int brick33x = brick23x;
	private static int brick33y = brick31y;
	
	private static int brick41x = brick31x;
	private static int brick41y = brick31y - brickSize;
	private static int brick42x = brick32x;
	private static int brick42y = brick41y;
	
	private static int brick51x = brick41x;
	private static int brick51y = brick41y - brickSize;
	
	private static int ground1x = brick1x + brickSize + 650;
	private static int ground1y = MainGame.HEIGHT - Ground.GROUND_LEVEL;
	private static int ground1w = Flag.FLAG_WIDTH;
	
	
	private static int flagX = ground1x;
	private static int flagY = MainGame.HEIGHT - Ground.GROUND_LEVEL - Flag.FLAG_HEIGHT + 1;
	
	public Level5() {
		super(33, flagX, flagY, 0);
		obstacol[0] = new Ground(0*Ground.WIDTH, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH, Ground.GROUND_LEVEL );
		obstacol[1] = new Ground(1*Ground.WIDTH, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH, Ground.GROUND_LEVEL );
		obstacol[2] = new Tube(tube1x, tube1y, 4, false);
		obstacol[3] = new Line(line1x, line1y);
		obstacol[4] = new Line(line2x, line2y);
		obstacol[5] = new Line(line3x, line3y);
		obstacol[6] = new Line(line4x, line4y);
		obstacol[7] = new Tube(tube2x, tube2y, 5, false);
		obstacol[8] = new MediumGround(mediumGround1x, mediumGround1y, MediumGround.MEDIUM_GROUND_WIDTH, MediumGround.MEDIUM_GROUND_LEVEL);
		obstacol[9] = new Line(line5x, line5y);
		obstacol[10] = new Line(line6x, line6y);
		obstacol[11] = new Line(line7x, line7y);
		obstacol[12] = new Line(line8x, line8y);
		obstacol[13] = new MediumGround(mediumGround2x, mediumGround2y, MediumGround.MEDIUM_GROUND_WIDTH, MediumGround.MEDIUM_GROUND_LEVEL);
		obstacol[14] = new MediumGround(mediumGround3x, mediumGround3y, MediumGround.MEDIUM_GROUND_WIDTH, MediumGround.MEDIUM_GROUND_LEVEL);
		obstacol[15] = new MediumGround(mediumGround4x, mediumGround4y, MediumGround.MEDIUM_GROUND_WIDTH, MediumGround.MEDIUM_GROUND_LEVEL);
		obstacol[16] = new Brick(brick1x, brick1y);
		obstacol[17] = new Brick(brick2x, brick2y);
		obstacol[18] = new Brick(brick3x, brick3y);
		obstacol[19] = new Brick(brick4x, brick4y);
		obstacol[20] = new Brick(brick5x, brick5y);
		obstacol[21] = new Brick(brick21x, brick21y);
		obstacol[22] = new Brick(brick22x, brick22y);
		obstacol[23] = new Brick(brick23x, brick23y);
		obstacol[24] = new Brick(brick24x, brick24y);
		obstacol[25] = new Brick(brick31x, brick31y);
		obstacol[26] = new Brick(brick32x, brick32y);
		obstacol[27] = new Brick(brick33x, brick33y);
		obstacol[28] = new Brick(brick41x, brick41y);
		obstacol[29] = new Brick(brick42x, brick42y);
		obstacol[30] = new Brick(brick51x, brick51y);
		obstacol[31] = new Ground(ground1x, ground1y, ground1w, Ground.GROUND_LEVEL);
		obstacol[32] = new Line(line21x, line21y);
		
	}
}
