
public class Level10 extends Levels{
	
	private static int tubeWidth = Tube.TUBE_WIDTH;
	private static int brickSize = Brick.BRICK_HEIGHT;
	private static int marioHeight = Mario.MARIO_HEIGHT;
	private static int marioJump = Mario.MARIO_JUMP_HEIGHT;
	private static int lineWidth = Line.LINE_WIDTH;
	private static int goombaWidth = Goomba.GOOMBA_WIDTH;
	private static int goombaHeight = Goomba.GOOMBA_HEIGHT;
	private static int plantHeight = PiranhaPlant.PLANT_HEIGHT;
	private static int flagWidth = Flag.FLAG_WIDTH;
	private static int spinyHeight = Spiny.SPINY_HEIGHT;
	private static int blasterWidth = BulletBlaster.BLASTER_WIDTH;
	private static int blasterHeight = BulletBlaster.BLASTER_HEIGHT;
	private static int koopaWidth = Koopa.KOOPA_WIDTH;
	private static int spinyWidth = Spiny.SPINY_WIDTH;
	
	private static int tube1x = 1000;
	private static int tube1y = MainGame.HEIGHT - Ground.GROUND_LEVEL - Tube.SMALL_GROUND_HEIGHT;
	
	private static int brick1x = 1350;
	private static int brick1y = tube1y - marioJump + 30;
	private static int brick2x = brick1x + brickSize;
	private static int brick3x = brick2x + brickSize;
	private static int brick4x = brick3x + brickSize;
	private static int brick5x = brick4x + brickSize;
	
	private static int brick21x = brick2x;
	private static int brick2y = brick1y - marioHeight - marioJump + 50;
	private static int question1x = brick3x;
	private static int brick22x = brick4x;
	
	private static int tallground1x = Ground.WIDTH*2;
	private static int tallground1y =  MainGame.HEIGHT - TallGround.TALL_GROUND_LEVEL;
	
	private static int goomba1x = tallground1x + 100;
	private static int goomba1y = tallground1y - goombaHeight;
	
	private static int tube21x = tallground1x + TallGround.TALL_GROUND_WIDTH + 300;
	private static int tube2y = MainGame.HEIGHT - Tube.MEDIUM_AIR_HEIGHT;
	private static int tube22x = tube21x + tubeWidth;
	private static int tube23x = tube22x + tubeWidth;
	private static int tube24x = tube23x + tubeWidth;
	private static int tube25x = tube24x + tubeWidth;
	private static int tube26x = tube25x + tubeWidth;
	private static int tube27x = tube26x + tubeWidth;
	
	private static int plant1btwy1 = tube2y - plantHeight*2/3;
	private static int plant1btwy2 = tube2y + plantHeight*2/3;
	private static int plant11x = tube21x;
	private static int plant12x = tube23x;
	private static int plant13x = tube24x;
	private static int plant14x = tube26x;
	private static int plant15x = tube27x;
	
	private static int tallground2x = tube27x + tubeWidth + 300;
	private static int tallground2y =  MainGame.HEIGHT - TallGround.TALL_GROUND_LEVEL;
	private static int question2x = tallground2x + TallGround.TALL_GROUND_WIDTH/2 - brickSize/2;
	private static int question2y = tallground2y - marioHeight - marioJump + 30;
	
	private static int ground1x = tallground2x + TallGround.TALL_GROUND_WIDTH;
	private static int ground1y = MainGame.HEIGHT - Ground.GROUND_LEVEL;
	private static int tallground3x = ground1x + Ground.WIDTH;
	private static int tallground3y = tallground2y + 10;
	private static int tallground4x = tallground3x + TallGround.TALL_GROUND_WIDTH;
	private static int tallground4y = tallground3y - 120;
	private static int tallground5x = tallground4x;
	private static int tallground5y = tallground4y + TallGround.TALL_GROUND_LEVEL;
	private static int blaster1x = tallground3x - blasterWidth;
	private static int blaster1y = ground1y - blasterHeight;
	private static int blaster2x = tallground4x + 100;
	private static int blaster2y = tallground4y - blasterHeight;
	
	private static int mediumground1y = MainGame.HEIGHT - MediumGround.MEDIUM_GROUND_LEVEL;
	private static int mediumground11x = tallground5x + TallGround.TALL_GROUND_WIDTH;
	private static int mediumground12x = mediumground11x + MediumGround.MEDIUM_GROUND_WIDTH;
	private static int mediumground13x = mediumground12x + MediumGround.MEDIUM_GROUND_WIDTH;
	private static int mediumground14x = mediumground13x + MediumGround.MEDIUM_GROUND_WIDTH;
	private static int invisible1x = mediumground13x + MediumGround.MEDIUM_GROUND_WIDTH/2 - brickSize/2;
	private static int invisible1y = MainGame.HEIGHT - MediumGround.MEDIUM_GROUND_LEVEL - marioJump + 20;
	private static int question3x = invisible1x;
	private static int question3y = invisible1y - marioHeight - marioJump + 50;
	
	private static int tube31x = mediumground14x + MediumGround.MEDIUM_GROUND_WIDTH + 400;
	private static int tube31y = MainGame.HEIGHT - Tube.MEDIUM_AIR_HEIGHT;
	private static int tube32x = tube31x + tubeWidth;
	private static int tube32y = MainGame.HEIGHT - Tube.VERY_BIG_AIR_HEIGHT;
	
	private static int koopa1x = tube32x + tubeWidth + 300;
	private static int koopa1y = MainGame.HEIGHT - Koopa.KOOPA_HEIGHT - 50;
	private static int koopa1btwy1 = MainGame.HEIGHT - Tube.ULTRA_BIG_AIR_HEIGHT;
	private static int koopa1btwy2 = koopa1y;
	private static int koopa2x = koopa1x + koopaWidth + 300;
	private static int koopa3x = koopa2x + koopaWidth + 300;
	
	private static int ground2x = koopa3x + koopaWidth + 300;
	private static int ground2y = ground1y;
	private static int question4x = ground2x + Ground.WIDTH/2 - brickSize/2;
	private static int question4y = ground2y - marioHeight - marioJump + 10;
	
	private static int ground3x = ground2x + Ground.WIDTH;
	private static int ground3y = ground1y;
	private static int tube41x = ground3x - tubeWidth;
	private static int tube41y = ground3y - Tube.SMALL_GROUND_HEIGHT;
	private static int tube42x = ground3x + Ground.WIDTH - tubeWidth;
	private static int tube42y = ground3y - Tube.SUPER_BIG_GROUND_HEIGHT;
	private static int invisible2y = invisible1y;
	private static int invisible21x = (tube42x + (tube41x + tubeWidth))/2 - brickSize/2;
	private static int invisible22x = invisible21x - brickSize;
	private static int invisible23x = invisible21x + brickSize;
	
	private static int spiny11x = tube42x - spinyWidth - 10;
	private static int spiny12x = tube41x + tubeWidth + 10;
	private static int spiny1y = ground3y - spinyHeight;
	private static int spiny1btwx1 = tube41x;
	private static int spiny1btwx2 = tube42x;
	
	private static int koopa4x = tube42x + tubeWidth + 1100;
	private static int koopa4y = MainGame.HEIGHT - Tube.BIG_AIR_HEIGHT;
	private static int koopa4btwx1 = tube42x + tubeWidth + 100;
	private static int koopa4btwx2 = koopa4btwx1 + 1000;
	
	private static int ground4x = koopa4btwx2 + 100;
	private static int ground4y = ground1y;
	
	
	private static int flagX = ground4x + Ground.WIDTH/4 - flagWidth/2;
	private static int flagY = MainGame.HEIGHT - Ground.GROUND_LEVEL - Flag.FLAG_HEIGHT + 1;
	
	public Level10() {
		super(44, flagX, flagY, 54);
		obstacol[0] = new Ground(0*Ground.WIDTH, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH, Ground.GROUND_LEVEL );
		obstacol[1] = new Ground(1*Ground.WIDTH, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH, Ground.GROUND_LEVEL );
		obstacol[2] = new TallGround(tallground1x, tallground1y, TallGround.TALL_GROUND_WIDTH , TallGround.TALL_GROUND_LEVEL);
		
		obstacol[3] = new Tube(tube1x, tube1y, 1, true);
		
		obstacol[4] = new Brick(brick1x, brick1y);
		obstacol[5] = new Brick(brick2x, brick1y);
		obstacol[6] = new Brick(brick3x, brick1y);
		obstacol[7] = new Brick(brick4x, brick1y);
		obstacol[8] = new Brick(brick5x, brick1y);
		
		obstacol[9] = new Brick(brick21x, brick2y);
		obstacol[10] = new QuestionBlock(question1x, brick2y);
		obstacol[11] = new Brick(brick22x, brick2y);
	
		obstacol[12] = new Tube(tube21x, tube2y, 2, false);
		obstacol[13] = new Tube(tube22x, tube2y, 2, false);
		obstacol[14] = new Tube(tube23x, tube2y, 2, false);
		obstacol[15] = new Tube(tube24x, tube2y, 2, false);
		obstacol[16] = new Tube(tube25x, tube2y, 2, false);
		obstacol[17] = new Tube(tube26x, tube2y, 2, false);
		obstacol[18] = new Tube(tube27x, tube2y, 2, false);
		
		obstacol[19] = new TallGround(tallground2x, tallground2y, TallGround.TALL_GROUND_WIDTH , TallGround.TALL_GROUND_LEVEL);
		obstacol[20] = new QuestionBlock(question2x, question2y);
		
		obstacol[21] = new Ground(ground1x, ground1y, Ground.WIDTH, Ground.GROUND_LEVEL);
		obstacol[22] = new TallGround(tallground3x, tallground3y, TallGround.TALL_GROUND_WIDTH , TallGround.TALL_GROUND_LEVEL);
		obstacol[23] = new TallGround(tallground4x, tallground4y, TallGround.TALL_GROUND_WIDTH , TallGround.TALL_GROUND_LEVEL);
		obstacol[24] = new TallGround(tallground5x, tallground5y, TallGround.TALL_GROUND_WIDTH , TallGround.TALL_GROUND_LEVEL);
		obstacol[25] = new BulletBlaster(blaster1x, blaster1y);
		obstacol[26] = new BulletBlaster(blaster2x, blaster2y);
		
		obstacol[27] = new MediumGround(mediumground11x, mediumground1y, MediumGround.MEDIUM_GROUND_WIDTH, MediumGround.MEDIUM_GROUND_LEVEL);
		obstacol[28] = new MediumGround(mediumground12x, mediumground1y, MediumGround.MEDIUM_GROUND_WIDTH, MediumGround.MEDIUM_GROUND_LEVEL);
		obstacol[29] = new MediumGround(mediumground13x, mediumground1y, MediumGround.MEDIUM_GROUND_WIDTH, MediumGround.MEDIUM_GROUND_LEVEL);
		obstacol[30] = new MediumGround(mediumground14x, mediumground1y, MediumGround.MEDIUM_GROUND_WIDTH, MediumGround.MEDIUM_GROUND_LEVEL);
		obstacol[31] = new InvisibleBlock(invisible1x, invisible1y);
		obstacol[32] = new QuestionBlock(question3x, question3y);
		
		obstacol[33] = new Tube(tube31x, tube31y, 2, false);
		obstacol[34] = new Tube(tube32x, tube32y, 4, false);
		
		obstacol[35] = new Ground(ground2x, ground2y, Ground.WIDTH, Ground.GROUND_LEVEL);
		obstacol[36] = new Ground(ground3x, ground3y, Ground.WIDTH, Ground.GROUND_LEVEL);
		obstacol[37] = new QuestionBlock(question4x, question4y);
		obstacol[38] = new Tube(tube41x, tube41y, 1, true);
		obstacol[39] = new Tube(tube42x, tube42y, 5, true);
		obstacol[40] = new InvisibleBlock(invisible21x, invisible2y);
		obstacol[41] = new InvisibleBlock(invisible22x, invisible2y);
		obstacol[42] = new InvisibleBlock(invisible23x, invisible2y);
		
		obstacol[43] = new Ground(ground4x, ground4y, Ground.WIDTH/2, Ground.GROUND_LEVEL);
		
		
		
		monster[0] = new Goomba(goomba1x, goomba1y, 0, goomba1x, 0);
		monster[1] = new PiranhaPlant(plant11x, plant1btwy1, plant1btwy1, plant1btwy2, 2.521);
		monster[2] = new PiranhaPlant(plant12x, plant1btwy1, plant1btwy1, plant1btwy2, 0.164);
		monster[3] = new PiranhaPlant(plant13x, plant1btwy1, plant1btwy1, plant1btwy2, 3.135);
		monster[4] = new PiranhaPlant(plant14x, plant1btwy1, plant1btwy1, plant1btwy2, 0.972);
		monster[5] = new PiranhaPlant(plant15x, plant1btwy1, plant1btwy1, plant1btwy2, 1.378);
		
		int depTime = 9;
		for(int i = 6; i <= 26; i++) {
			monster[i] = new Bullet(blaster1x, blaster1y, depTime);
			depTime += 5;
		}
		depTime = 10;
		for(int i = 27; i <= 47; i++) {
			monster[i] = new Bullet(blaster2x, blaster2y, depTime);
			depTime += 5;
		}
		
		monster[48] = new Koopa(koopa1x, koopa1y, koopa1x, koopa1x, koopa1btwy1, koopa1btwy2, 0, 4, 0);
		monster[49] = new Koopa(koopa2x, koopa1y, koopa2x, koopa2x, koopa1btwy1, koopa1btwy2, 0, 4, 1);
		monster[50] = new Koopa(koopa3x, koopa1y, koopa3x, koopa3x, koopa1btwy1, koopa1btwy2, 0, 4, 2);
		
		monster[51] = new Spiny(spiny11x, spiny1y, spiny1btwx1, spiny1btwx2, 0);
		monster[52] = new Spiny(spiny12x, spiny1y, spiny1btwx1, spiny1btwx2, 0);
		
		monster[53] = new Koopa(koopa4x, koopa4y, koopa4btwx1, koopa4btwx2, koopa4y, koopa4y, 4, 0, 0);
	}
}
