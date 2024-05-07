
public class Level3 extends Levels{
	
	private static int tubeWidth = Tube.TUBE_WIDTH;
	
	private static int tube1x = Ground.WIDTH ;
	private static int tube1y = MainGame.HEIGHT - Ground.GROUND_LEVEL - Tube.SMALL_GROUND_HEIGHT;
	
	private static int tube2x = tube1x + tubeWidth + 350;
	private static int tube2y = MainGame.HEIGHT - Ground.GROUND_LEVEL - Tube.BIG_GROUND_HEIGHT;
	
	private static int tube3x = 2*Ground.WIDTH - tubeWidth;
	private static int tube3y =  MainGame.HEIGHT - Ground.GROUND_LEVEL - Tube.BIG_GROUND_HEIGHT;
	
	private static int tallGround1x = 2*Ground.WIDTH;
	private static int tallGround1y = MainGame.HEIGHT - TallGround.TALL_GROUND_LEVEL;
	
	private static int tallGround2x = tallGround1x + TallGround.TALL_GROUND_WIDTH;
	private static int tallGround2y = MainGame.HEIGHT - TallGround.TALL_GROUND_LEVEL;
	
	private static int mediumGround1x = tallGround2x + TallGround.TALL_GROUND_WIDTH;
	private static int mediumGround1y = MainGame.HEIGHT - MediumGround.MEDIUM_GROUND_LEVEL;
	
	private static int mediumGround2x = mediumGround1x + MediumGround.MEDIUM_GROUND_WIDTH;
	private static int mediumGround2y = MainGame.HEIGHT - MediumGround.MEDIUM_GROUND_LEVEL;
	
	private static int tube4x = mediumGround2x + MediumGround.MEDIUM_GROUND_WIDTH + 300;
	private static int tube4y = MainGame.HEIGHT - Tube.MEDIUM_AIR_HEIGHT;
	
	private static int tube5x = tube4x + tubeWidth + 300;
	private static int tube5y = MainGame.HEIGHT - Tube.BIG_AIR_HEIGHT;
	
	private static int tube6x = tube5x + tubeWidth + 300;
	private static int tube6y = MainGame.HEIGHT - Tube.VERY_BIG_AIR_HEIGHT;
	
	private static int tube7x = tube6x + tubeWidth + 300;
	private static int tube7y = MainGame.HEIGHT - Tube.SUPER_BIG_AIR_HEIGHT;
	
	private static int tube8x = tube7x + tubeWidth + 300;
	private static int tube8y = MainGame.HEIGHT - Tube.ULTRA_BIG_AIR_HEIGHT;
	
	private static int finalGroundx = tube8x + tubeWidth + 800;
	private static int finalGroundy = MainGame.HEIGHT - Ground.GROUND_LEVEL;
	
	private static int flagX  = finalGroundx + Ground.WIDTH*3/4;
	private static int flagY  = MainGame.HEIGHT - Ground.GROUND_LEVEL - Flag.FLAG_HEIGHT;
	
	
	public Level3() {
		super(15,flagX, flagY, 0);
		obstacol[0] = new Ground(0*Ground.WIDTH, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH, Ground.GROUND_LEVEL );
		obstacol[1] = new Ground(1*Ground.WIDTH, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH, Ground.GROUND_LEVEL );
		obstacol[2] = new Tube(tube1x, tube1y, 1, true);
		obstacol[3] = new Tube(tube2x, tube2y, 3, true);
		obstacol[4] = new Tube(tube3x, tube3y, 3, true);
		obstacol[5] = new TallGround(tallGround1x, tallGround1y, TallGround.TALL_GROUND_WIDTH, TallGround.TALL_GROUND_LEVEL);
		obstacol[6] = new TallGround(tallGround2x, tallGround2y, TallGround.TALL_GROUND_WIDTH, TallGround.TALL_GROUND_LEVEL);
		obstacol[7] = new MediumGround(mediumGround1x, mediumGround1y, MediumGround.MEDIUM_GROUND_WIDTH, MediumGround.MEDIUM_GROUND_LEVEL);
		obstacol[8] = new MediumGround(mediumGround2x, mediumGround2y, MediumGround.MEDIUM_GROUND_WIDTH, MediumGround.MEDIUM_GROUND_LEVEL);
		obstacol[9] = new Tube(tube4x, tube4y, 2, false);
		obstacol[10] = new Tube(tube5x, tube5y, 3, false);
		obstacol[11] = new Tube(tube6x, tube6y, 4, false);
		obstacol[12] = new Tube(tube7x, tube7y, 5, false);
		obstacol[13] = new Tube(tube8x, tube8y, 6, false);
		obstacol[14] = new Ground(finalGroundx, finalGroundy, Ground.WIDTH, Ground.GROUND_LEVEL);
	
	
	}

}
