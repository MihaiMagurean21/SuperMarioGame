
public class Level7 extends Levels{
	
	private static int groundWidth = Ground.WIDTH;
	private static int tubeWidth = Tube.TUBE_WIDTH;
	private static int brickSize = Brick.BRICK_HEIGHT;
	private static int marioHeight = Mario.MARIO_HEIGHT;
	private static int marioJump = Mario.MARIO_JUMP_HEIGHT;
	private static int lineWidth = Line.LINE_WIDTH;
	private static int goombaHeight = Goomba.GOOMBA_HEIGHT;
	
	
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
	
	private static int tallGround1x = Ground.WIDTH*5/2;
	private static int tallGround1y = MainGame.HEIGHT - TallGround.TALL_GROUND_LEVEL;
	
	private static int line1x = tube1x + (tallGround1x - tube1x)/4;
	private static int line1y = brick1y;
	
	private static int line2x = tallGround1x - (tallGround1x - tube1x)/4 - lineWidth + tubeWidth;
	private static int line2y = line1y;
	
	private static int ground1x = tallGround1x + TallGround.TALL_GROUND_WIDTH + 300;
	private static int ground1y = MainGame.HEIGHT - Ground.GROUND_LEVEL;
	
	private static int tallGround2x = ground1x + groundWidth*2/3;
	private static int tallGround2y = MainGame.HEIGHT - TallGround.TALL_GROUND_LEVEL;
	
	private static int goombaX = tallGround1x - Goomba.GOOMBA_WIDTH - 5;
	private static int goombaY =  MainGame.HEIGHT - Ground.GROUND_LEVEL - Goomba.GOOMBA_HEIGHT;
	private static int goombaBtwX1 = tube1x;
	private static int goombaBtwX2 = tallGround1x;
	
	private static int goomba2x = tallGround2x + TallGround.TALL_GROUND_WIDTH;
	private static int goomba2y = -goombaHeight;
	private static int goomba2BtwX1 = -200;
	private static int goomba2BtwX2 = goomba2x + 100;
	private static double goomba2deptime = 0;
	
	private static int tube2x = tallGround2x + TallGround.TALL_GROUND_WIDTH + 400;
	private static int tube2y = MainGame.HEIGHT - Tube.BIG_AIR_HEIGHT;
	
	private static int tube3x = tube2x + tubeWidth + 400;
	private static int tube3y = MainGame.HEIGHT - Tube.ULTRA_BIG_AIR_HEIGHT;
	
	
	private static int flagX = tube3x;
	private static int flagY = tube3y - Flag.FLAG_HEIGHT + 1;
	
	public Level7() {
		super(15, flagX, flagY, 101); 
		obstacol[0] = new Ground(0*Ground.WIDTH, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH, Ground.GROUND_LEVEL );
		obstacol[1] = new Ground(1*Ground.WIDTH, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH, Ground.GROUND_LEVEL );
		obstacol[2] = new Tube(tube1x, tube1y, 1, true);
		obstacol[3] = new Brick(brick1x, brick1y);
		obstacol[4] = new Brick(brick2x, brick2y);
		obstacol[5] = new Brick(brick3x, brick3y);
		obstacol[6] = new QuestionBlock(question1x, question1y);
		obstacol[7] = new Ground(2*Ground.WIDTH, MainGame.HEIGHT - Ground.GROUND_LEVEL, tallGround1x - 2*Ground.WIDTH, Ground.GROUND_LEVEL );
		obstacol[8] = new TallGround(tallGround1x, tallGround1y, TallGround.TALL_GROUND_WIDTH, TallGround.TALL_GROUND_LEVEL);
		obstacol[9] = new Line(line1x, line1y);
		obstacol[10] = new Line(line2x, line2y);
		obstacol[11] = new Ground(ground1x, ground1y, Ground.WIDTH*2/3, Ground.GROUND_LEVEL );
		obstacol[12] = new TallGround(tallGround2x, tallGround2y, TallGround.TALL_GROUND_WIDTH, TallGround.TALL_GROUND_LEVEL);
		obstacol[13] =  new Tube(tube2x, tube2y, 3, false);
		obstacol[14] = new Tube(tube3x, tube3y, 6, false);
		
		
		monster[0] = new Goomba(goombaX, goombaY, goombaBtwX1, goombaBtwX2, 0);
		goomba2deptime = 0;
		for(int i=1;i<=100;i++) {
			monster[i] = new Goomba(goomba2x, goomba2y, goomba2BtwX1, goomba2BtwX2, goomba2deptime);
			goomba2deptime += 3;
		}
	}
}
