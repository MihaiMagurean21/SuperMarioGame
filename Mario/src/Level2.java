;
public class Level2 extends Levels {
	private static int flagX = 3*Ground.WIDTH + MediumGround.MEDIUM_GROUND_WIDTH + MediumGround.MEDIUM_GROUND_WIDTH + TallGround.TALL_GROUND_WIDTH + Ground.WIDTH/2 + Ground.WIDTH/4 + MediumGround.MEDIUM_GROUND_WIDTH*2/3;
	private static int flagY = MainGame.HEIGHT - MediumGround.MEDIUM_GROUND_LEVEL - Flag.FLAG_HEIGHT + 1;
	
	public Level2() {
		super(8, flagX, flagY, 0);
		obstacol[0] = new Ground(0*Ground.WIDTH, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH, Ground.GROUND_LEVEL );
		obstacol[1] = new TallGround(1*Ground.WIDTH, MainGame.HEIGHT - TallGround.TALL_GROUND_LEVEL , TallGround.TALL_GROUND_WIDTH , TallGround.TALL_GROUND_LEVEL);
		obstacol[2] = new MediumGround(2*Ground.WIDTH, MainGame.HEIGHT - MediumGround.MEDIUM_GROUND_LEVEL, MediumGround.MEDIUM_GROUND_WIDTH, MediumGround.MEDIUM_GROUND_LEVEL);
		obstacol[3] = new Ground(2*Ground.WIDTH + MediumGround.MEDIUM_GROUND_WIDTH, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH, Ground.GROUND_LEVEL );
		obstacol[4] = new MediumGround(3*Ground.WIDTH + MediumGround.MEDIUM_GROUND_WIDTH, MainGame.HEIGHT - MediumGround.MEDIUM_GROUND_LEVEL, MediumGround.MEDIUM_GROUND_WIDTH, MediumGround.MEDIUM_GROUND_LEVEL);
		obstacol[5] = new TallGround(3*Ground.WIDTH + MediumGround.MEDIUM_GROUND_WIDTH + MediumGround.MEDIUM_GROUND_WIDTH, MainGame.HEIGHT - TallGround.TALL_GROUND_LEVEL , TallGround.TALL_GROUND_WIDTH , TallGround.TALL_GROUND_LEVEL);
		obstacol[6] = new Ground(3*Ground.WIDTH + MediumGround.MEDIUM_GROUND_WIDTH + MediumGround.MEDIUM_GROUND_WIDTH + TallGround.TALL_GROUND_WIDTH, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH/4, Ground.GROUND_LEVEL );
		obstacol[7] = new MediumGround(3*Ground.WIDTH + MediumGround.MEDIUM_GROUND_WIDTH + MediumGround.MEDIUM_GROUND_WIDTH + TallGround.TALL_GROUND_WIDTH + Ground.WIDTH/4 + Ground.WIDTH/2, MainGame.HEIGHT - MediumGround.MEDIUM_GROUND_LEVEL, MediumGround.MEDIUM_GROUND_WIDTH, MediumGround.MEDIUM_GROUND_LEVEL);
		
		
		//obstacol[2] = new Ground(Ground.WIDTH - Ground.WIDTH/4, MainGame.HEIGHT - Ground.GROUND_LEVEL-180, Ground.WIDTH/4, Ground.GROUND_LEVEL/4);
	}
}
