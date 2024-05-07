;
public class Level8 extends Levels {
	
	private static int groundWidth = Ground.WIDTH;
	private static int tubeWidth = Tube.TUBE_WIDTH;
	private static int marioHeight = Mario.MARIO_HEIGHT;
	private static int marioJump = Mario.MARIO_JUMP_HEIGHT;
	private static int plantHeight = PiranhaPlant.PLANT_HEIGHT;
	
	private static int question1x = 850;
	private static int question1y = MainGame.HEIGHT - Ground.GROUND_LEVEL - marioHeight - marioJump + 50;
	
	private static int tallground1x = Ground.WIDTH*4/3;
	private static int tallground1y =  MainGame.HEIGHT - TallGround.TALL_GROUND_LEVEL;
	
	private static int ground1x = tallground1x + TallGround.TALL_GROUND_WIDTH;
	private static int ground1y =  MainGame.HEIGHT - Ground.GROUND_LEVEL;
	
	private static int tallground2x = ground1x + 600;
	private static int tallground2y =  MainGame.HEIGHT - TallGround.TALL_GROUND_LEVEL;
	
	private static int tallground3x = tallground2x + TallGround.TALL_GROUND_WIDTH;
	private static int tallground3y =  MainGame.HEIGHT - TallGround.TALL_GROUND_LEVEL;
	
	private static int tallground4x = tallground3x + TallGround.TALL_GROUND_WIDTH;
	private static int tallground4y =  MainGame.HEIGHT - TallGround.TALL_GROUND_LEVEL;
	
	private static int tallground5x = tallground4x + TallGround.TALL_GROUND_WIDTH;
	private static int tallground5y =  MainGame.HEIGHT - TallGround.TALL_GROUND_LEVEL;
	
	private static int tallground6x = tallground5x + TallGround.TALL_GROUND_WIDTH;
	private static int tallground6y =  MainGame.HEIGHT - TallGround.TALL_GROUND_LEVEL;
	
	private static int tube1x = tallground3x;
	private static int tube1y = MainGame.HEIGHT - TallGround.TALL_GROUND_LEVEL - Tube.SMALL_GROUND_HEIGHT + 30;
	
	private static int tube2x = (tube1x + tallground6x + TallGround.TALL_GROUND_WIDTH - tubeWidth)/2;
	private static int tube2y = tube1y;
	
	private static int tube3x = tallground6x + TallGround.TALL_GROUND_WIDTH - tubeWidth;
	private static int tube3y = tube1y;
	
	
	private static int plant1x = tube1x;
	private static int plant1y = tube1y + plantHeight*2/3;
	private static int plant1btwy1 = tube1y - plantHeight*2/3;
	private static int plant1btwy2 = tube1y + plantHeight*2/3;
	
	private static int plant2x = tube2x;
	private static int plant3x = tube3x;
	
	private static int goomba1X = tallground2x - Goomba.GOOMBA_WIDTH - 5;
	private static int goomba1Y =  MainGame.HEIGHT - Ground.GROUND_LEVEL - Goomba.GOOMBA_HEIGHT;
	private static int goomba1BtwX1 = 0;
	private static int goomba1BtwX2 = tallground2x;
	
	private static int goomba2X = goomba1X - Goomba.GOOMBA_WIDTH - 100;
	private static int goomba3X = goomba2X - Goomba.GOOMBA_WIDTH - 50;
	private static int goomba4X = goomba3X - Goomba.GOOMBA_WIDTH - 120;
	
	private static int flagX = tube3x + 750 + groundWidth/2;
	private static int flagY = MainGame.HEIGHT - Ground.GROUND_LEVEL - Flag.FLAG_HEIGHT + 1;
	
	public Level8() {
		super(14, flagX, flagY, 7);
		obstacol[0] = new Ground(0*Ground.WIDTH, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH, Ground.GROUND_LEVEL );
		obstacol[1] = new Ground(1*Ground.WIDTH, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH/3, Ground.GROUND_LEVEL );
		obstacol[2] = new TallGround(tallground1x, tallground1y, TallGround.TALL_GROUND_WIDTH , TallGround.TALL_GROUND_LEVEL);
		obstacol[3] = new QuestionBlock(question1x, question1y);
		obstacol[4] = new Ground(ground1x, ground1y, 600, Ground.GROUND_LEVEL );
		obstacol[5] = new TallGround(tallground2x, tallground2y, TallGround.TALL_GROUND_WIDTH , TallGround.TALL_GROUND_LEVEL);
		obstacol[6] = new TallGround(tallground3x, tallground3y, TallGround.TALL_GROUND_WIDTH , TallGround.TALL_GROUND_LEVEL);
		obstacol[7] = new TallGround(tallground4x, tallground4y, TallGround.TALL_GROUND_WIDTH , TallGround.TALL_GROUND_LEVEL);
		obstacol[8] = new TallGround(tallground5x, tallground5y, TallGround.TALL_GROUND_WIDTH , TallGround.TALL_GROUND_LEVEL);
		obstacol[9] = new TallGround(tallground6x, tallground6y, TallGround.TALL_GROUND_WIDTH , TallGround.TALL_GROUND_LEVEL);
		obstacol[10] = new Tube(tube1x, tube1y, 1, true);
		obstacol[11] = new Tube(tube2x, tube2y, 1, true);
		obstacol[12] = new Tube(tube3x, tube3y, 1, true);
		obstacol[13] = new Ground(tube3x + 750, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH*3/4, Ground.GROUND_LEVEL);
		
		
		monster[0] = new PiranhaPlant(plant1x, plant1y, plant1btwy1, plant1btwy2, 0);
		monster[1] = new PiranhaPlant(plant2x, plant1y, plant1btwy1, plant1btwy2, 0.5);
		monster[2] = new PiranhaPlant(plant3x, plant1y, plant1btwy1, plant1btwy2, 1);
		monster[3] = new Goomba(goomba1X, goomba1Y, goomba1BtwX1, goomba1BtwX2, 0);
		monster[4] = new Goomba(goomba2X, goomba1Y, goomba1BtwX1, goomba1BtwX2, 0);
		monster[5] = new Goomba(goomba3X, goomba1Y, goomba1BtwX1, goomba1BtwX2, 0);
		monster[6] = new Goomba(goomba4X, goomba1Y, goomba1BtwX1, goomba1BtwX2, 0);
	}
}
