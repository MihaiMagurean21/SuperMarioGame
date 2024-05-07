
public class Level1 extends Levels{
	private static int gap1 = 150;
	private static int gap2 = 220;
	private static int gap3 = 340;
	private static int gap4 = 450;
	private static int gap5 = 580;
	
	private static int flagX = 5*Ground.WIDTH + gap1 + gap2 + gap3 + gap4 + gap5 + Ground.WIDTH*3/4;
	private static int flagY = MainGame.HEIGHT - Ground.GROUND_LEVEL - Flag.FLAG_HEIGHT + 1;
	
	public Level1() {
		super(6, flagX, flagY, 0); 
		obstacol[0] = new Ground(0*Ground.WIDTH, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH, Ground.GROUND_LEVEL );
		obstacol[1] = new Ground(1*Ground.WIDTH + gap1, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH, Ground.GROUND_LEVEL );
		obstacol[2] = new Ground(2*Ground.WIDTH + gap1 + gap2, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH, Ground.GROUND_LEVEL );
		obstacol[3] = new Ground(3*Ground.WIDTH + gap1 + gap2 + gap3, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH, Ground.GROUND_LEVEL );
		obstacol[4] = new Ground(4*Ground.WIDTH + gap1 + gap2 + gap3 + gap4, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH, Ground.GROUND_LEVEL );
		obstacol[5] = new Ground(5*Ground.WIDTH + gap1 + gap2 + gap3 + gap4 + gap5, MainGame.HEIGHT - Ground.GROUND_LEVEL, Ground.WIDTH, Ground.GROUND_LEVEL );
		
		
		//obstacol[6] = new Ground(Ground.WIDTH*2/3, MainGame.HEIGHT - Ground.GROUND_LEVEL - Mario.MARIO_JUMP_HEIGHT - Mario.MARIO_HEIGHT + 50, Ground.WIDTH/4, Ground.GROUND_LEVEL/3);
	}
}
