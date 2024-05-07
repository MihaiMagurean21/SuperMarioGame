
public class Level4 extends Levels{

	private static int tubeWidth = Tube.TUBE_WIDTH;
	private static int brickSize = Brick.BRICK_WIDTH;
	
	private static int tube1x = Ground.WIDTH ;
	private static int tube1y = MainGame.HEIGHT - Ground.GROUND_LEVEL - Tube.SMALL_GROUND_HEIGHT;
	
	private static int brick1x = tube1x + tubeWidth + 350;
	private static int brick1y = MainGame.HEIGHT - Ground.GROUND_LEVEL - Mario.MARIO_HEIGHT - Mario.MARIO_JUMP_HEIGHT*2/3;
	private static int brick2x = brick1x + brickSize;
	private static int brick2y = brick1y;
	private static int brick3x = brick2x + brickSize;
	private static int brick3y = brick2y;
	
	private static int brick4x = brick3x + brickSize + 430;
	private static int brick4y = brick2y - 100;
	private static int brick5x = brick4x + brickSize;
	private static int brick5y = brick4y;
	private static int brick6x = brick5x + brickSize;
	private static int brick6y = brick4y;
	
	private static int tube2x = brick6x + 650;
	private static int tube2y = MainGame.HEIGHT - Ground.GROUND_LEVEL - Tube.ULTRA_BIG_GROUND_HEIGHT;
	
	private static int ground1x = 3*Ground.WIDTH + 600;
	
	private static int tallGround1x = ground1x + Ground.WIDTH;
	private static int tallGround1y = MainGame.HEIGHT - TallGround.TALL_GROUND_LEVEL;
	
	private static int ground2x = tallGround1x + TallGround.TALL_GROUND_WIDTH;
	private static int ground2y =  MainGame.HEIGHT - Ground.GROUND_LEVEL;
	private static int ground2w = 4*brickSize;
	
	private static int tallGround2x = ground2x + ground2w;
	private static int tallGround2y = MainGame.HEIGHT - TallGround.TALL_GROUND_LEVEL;
	
	private static int brick7x = tallGround1x + TallGround.TALL_GROUND_WIDTH;
	private static int brick7y = tallGround2y;
	private static int brick8x = brick7x + brickSize;
	private static int brick8y = brick7y;
	private static int brick9x = brick8x + brickSize;
	private static int brick9y = brick7y;
	private static int brick10x = brick9x + brickSize;
	private static int brick10y = brick7y;
	
	private static int ground3x = tallGround2x + TallGround.TALL_GROUND_WIDTH + 650;
	private static int ground3y =  MainGame.HEIGHT - Ground.GROUND_LEVEL;
	private static int ground3w = 300;
	
	
	private static int flagX = ground3x + 150;
	private static int flagY = MainGame.HEIGHT - Ground.GROUND_LEVEL - Flag.FLAG_HEIGHT;
	
	
	public Level4() {
		super(20, flagX, flagY, 0);
		obstacol[0] = new Ground(0*Ground.WIDTH, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH, Ground.GROUND_LEVEL );
		obstacol[1] = new Ground(1*Ground.WIDTH, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH, Ground.GROUND_LEVEL );
		obstacol[2] = new Tube(tube1x, tube1y, 1, true);
		obstacol[3] = new Brick(brick1x, brick1y);
		obstacol[4] = new Brick(brick2x, brick2y);
		obstacol[5] = new Brick(brick3x, brick3y);
		obstacol[6] = new Brick(brick4x, brick4y);
		obstacol[7] = new Brick(brick5x, brick5y);
		obstacol[8] = new Brick(brick6x, brick6y);
		obstacol[9] = new Ground(2*Ground.WIDTH, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH - 100, Ground.GROUND_LEVEL );
		obstacol[10] = new Ground(ground1x, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH, Ground.GROUND_LEVEL );
		obstacol[11] = new Tube(tube2x, tube2y, 6, true);
		obstacol[12] = new TallGround(tallGround1x, tallGround1y, TallGround.TALL_GROUND_WIDTH, TallGround.TALL_GROUND_LEVEL);
		obstacol[13] = new Ground(ground2x, ground2y, ground2w, Ground.GROUND_LEVEL);
		obstacol[14] = new TallGround(tallGround2x, tallGround2y, TallGround.TALL_GROUND_WIDTH, TallGround.TALL_GROUND_LEVEL);
		obstacol[15] = new Brick(brick7x, brick7y);
		obstacol[16] = new Brick(brick8x, brick8y);
		obstacol[17] = new Brick(brick9x, brick9y);
		obstacol[18] = new Brick(brick10x, brick10y);
		obstacol[19] = new Ground(ground3x, ground3y, ground3w, Ground.GROUND_LEVEL);
		
	}
}
