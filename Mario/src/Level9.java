
public class Level9 extends Levels{
	
	private static int tubeWidth = Tube.TUBE_WIDTH;
	private static int brickSize = Brick.BRICK_HEIGHT;
	private static int marioHeight = Mario.MARIO_HEIGHT;
	private static int marioJump = Mario.MARIO_JUMP_HEIGHT;
	private static int lineWidth = Line.LINE_WIDTH;
	private static int goombaWidth = Goomba.GOOMBA_WIDTH;
	private static int plantHeight = PiranhaPlant.PLANT_HEIGHT;
	private static int flagWidth = Flag.FLAG_WIDTH;
	
	private static int invisible1x = 850;
	private static int invisible1y = MainGame.HEIGHT - Ground.GROUND_LEVEL - marioJump + 20;
	
	private static int question1x = 850;
	private static int question1y = invisible1y - marioHeight - marioJump + 50;
	
	private static int tallground1x = Ground.WIDTH*4/3;
	private static int tallground1y =  MainGame.HEIGHT - TallGround.TALL_GROUND_LEVEL;
	
	private static int tube1x = tallground1x + TallGround.TALL_GROUND_WIDTH + 400;
	private static int tube1y = MainGame.HEIGHT - Tube.VERY_BIG_AIR_HEIGHT;
	
	private static int goombaX = tube1x + tubeWidth - goombaWidth/2 - 1;
	private static int goombaY =  tube1y - Goomba.GOOMBA_HEIGHT;
	private static int goombaBtwX1 = tube1x - goombaWidth/2;
	private static int goombaBtwX2 = tube1x + tubeWidth - goombaWidth/2;
	
	private static int tube2x = tube1x + tubeWidth + 400;
	private static int tube2y = MainGame.HEIGHT - Tube.BIG_AIR_HEIGHT;
	
	private static int plant1x = tube2x;
	private static int plant1y = tube2y + plantHeight*2/3;
	private static int plant1btwy1 = tube2y - plantHeight*2/3;
	private static int plant1btwy2 = tube2y + plantHeight*2/3;
	
	private static int islandx = tube2x + tubeWidth + 300;
	private static int islandy = tube2y - 80;
	
	private static int goomba2X = islandx + Ground.WIDTH/4 - goombaWidth/2 - 1;
	private static int goomba2Y =  islandy - Goomba.GOOMBA_HEIGHT;
	private static int goomba2BtwX1 = islandx - goombaWidth/2;
	private static int goomba2BtwX2 = islandx + Ground.WIDTH/4 - goombaWidth/2;
	
	private static int tube3x = islandx + Ground.WIDTH/4 + 500;
	private static int tube3y = MainGame.HEIGHT - Tube.BIG_AIR_HEIGHT;
	private static int tube4x = tube3x + tubeWidth;
	private static int tube4y = MainGame.HEIGHT - Tube.SMALL_AIR_HEIGHT;
	private static int tube5x = tube4x + tubeWidth;
	private static int tube5y = MainGame.HEIGHT - Tube.BIG_AIR_HEIGHT;
	
	private static int plant2x = tube3x;
	private static int plant2y = tube3y + plantHeight*2/3;
	private static int plant2btwy1 = tube3y - plantHeight*2/3;
	private static int plant2btwy2 = tube3y + plantHeight;
	
	private static int plant3x = tube5x;
	private static int plant3y = tube5y + plantHeight*2/3;
	private static int plant3btwy1 = tube5y - plantHeight*2/3;
	private static int plant3btwy2 = tube5y + plantHeight;
	
	private static int brick1x = tube5x + tubeWidth + 300;
	private static int brick1y = tube5y;
	private static int brick2x = brick1x + brickSize;
	private static int brick2y = brick1y - brickSize;
	private static int brick3x = brick2x + brickSize;
	private static int brick3y = brick2y - brickSize;
	private static int brick4x = brick3x + brickSize;
	private static int brick4y = brick3y - brickSize;
	
	private static int tube6x = brick4x + 200;
	private static int tube6y = MainGame.HEIGHT - Tube.ULTRA_BIG_AIR_HEIGHT - 250;
	private static int tube7x = tube6x;
	private static int tube7y = tube6y - Tube.ULTRA_BIG_AIR_HEIGHT;
	
	private static int brick5x = tube6x - brickSize;
	private static int brick5y = tube6y + Tube.ULTRA_BIG_AIR_HEIGHT - brickSize;
	
	private static int brick6x = tube6x;
	private static int brick6y = tube6y + Tube.ULTRA_BIG_AIR_HEIGHT;
	private static int brick7x = brick6x + brickSize;
	private static int brick7y = brick6y;
	
	private static int brick8x = brick1x;
	private static int brick8y = brick1y + brickSize;
	private static int brick9x = brick1x;
	private static int brick9y = brick8y + brickSize;
	private static int brick10x = brick1x;
	private static int brick10y = brick9y + brickSize;
	private static int brick11x = brick1x;
	private static int brick11y = brick10y + brickSize;
	
	private static int ground1x = brick1x + brickSize;
	private static int ground1y = brick11y;
	private static int ground1w = tube6x - brick1x - brickSize + tubeWidth + lineWidth + tubeWidth;
	
	private static int tube8x = ground1x + ground1w - tubeWidth;
	private static int tube8y = ground1y - Tube.ULTRA_BIG_GROUND_HEIGHT;
	
	private static int line1x = tube6x + tubeWidth;
	private static int line1y = brick6y + brickSize/2;
	private static int line2x = line1x;
	private static int line2y = line1y - 130;
	
	private static int goomba3X = tube8x - goombaWidth - 5;
	private static int goomba3Y =  ground1y - Goomba.GOOMBA_HEIGHT;
	private static int goomba3BtwX1 = brick1x;
	private static int goomba3BtwX2 = tube8x;
	
	private static int tube9x = tube8x + tubeWidth + 550;
	private static int tube9y = MainGame.HEIGHT - Tube.SMALL_GROUND_HEIGHT;
	
	
	private static int flagX = tube9x + tubeWidth/2 - flagWidth/2;
	private static int flagY = tube9y - Flag.FLAG_HEIGHT + 1;
	
	public Level9() {
		super(29, flagX, flagY, 7);
		obstacol[0] = new Ground(0*Ground.WIDTH, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH, Ground.GROUND_LEVEL );
		obstacol[1] = new Ground(1*Ground.WIDTH, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH/3, Ground.GROUND_LEVEL );
		obstacol[2] = new TallGround(tallground1x, tallground1y, TallGround.TALL_GROUND_WIDTH , TallGround.TALL_GROUND_LEVEL);
		obstacol[3] = new QuestionBlock(question1x, question1y);
		obstacol[4] = new InvisibleBlock(invisible1x, invisible1y);
		obstacol[5] = new Tube(tube1x, tube1y, 4, false);
		obstacol[6] = new Tube(tube2x, tube2y, 3, false);
		obstacol[7] = new Ground(islandx, islandy, Ground.WIDTH/4, Ground.GROUND_LEVEL/3);
		obstacol[8] = new Tube(tube3x, tube3y, 3, false);
		obstacol[9] = new Tube(tube4x, tube4y, 1, false);
		obstacol[10] = new Tube(tube5x, tube5y, 3, false);
		obstacol[11] = new Brick(brick1x, brick1y);
		obstacol[12] = new Brick(brick2x, brick2y);
		obstacol[13] = new Brick(brick3x, brick3y);
		obstacol[14] = new Brick(brick4x, brick4y);
		obstacol[15] = new Tube(tube6x, tube6y, 6, false);
		obstacol[16] = new Tube(tube7x, tube7y, 6, false);
		obstacol[17] = new Brick(brick5x, brick5y);
		obstacol[18] = new Brick(brick6x, brick6y);
		obstacol[19] = new Brick(brick7x, brick7y);
		obstacol[20] = new Brick(brick8x, brick8y);
		obstacol[21] = new Brick(brick9x, brick9y);
		obstacol[22] = new Brick(brick10x, brick10y);
		obstacol[23] = new Brick(brick11x, brick11y);
		obstacol[24] = new Ground(ground1x, ground1y, ground1w, Ground.GROUND_LEVEL);
		obstacol[25] = new Tube(tube8x, tube8y, 6, true);
		obstacol[26] = new Line(line1x, line1y);
		obstacol[27] = new Line(line2x, line2y);
		obstacol[28] = new Tube(tube9x, tube9y, 1, true);
		
		monster[0] = new Goomba(goombaX, goombaY, goombaBtwX1, goombaBtwX2, 0);
		monster[1] = new PiranhaPlant(plant1x, plant1y, plant1btwy1, plant1btwy2, 0);
		monster[2] = new Goomba(goomba2X, goomba2Y, goomba2BtwX1, goomba2BtwX2, 0);
		monster[3] = new Goomba(goomba2X, goomba2Y, goomba2BtwX1, goomba2BtwX2, 1.5);
		monster[4] = new PiranhaPlant(plant2x, plant2y, plant2btwy1, plant2btwy2, 0);
		monster[5] = new PiranhaPlant(plant3x, plant3y, plant3btwy1, plant3btwy2, 0);
		monster[6] = new Goomba(goomba3X, goomba3Y, goomba3BtwX1, goomba3BtwX2, 0);
	}
}
