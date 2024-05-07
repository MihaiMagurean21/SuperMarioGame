import java.awt.Rectangle;

import javax.swing.JLabel;

public abstract class Obstacol extends JLabel{
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	
	public Obstacol(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public void setHeight(int height) {
		this.h = height;
	}
	
	public static int yObstacolBelow(Levels level, Mario mario, int error_crouch, int error_no_crouch) {
		int nrObstacole = level.getNrObstacole();
		int min = MainGame.HEIGHT + Mario.marioHeight;
		
		int marioHeight;
		int marioWidth;
		int error;
		
		if(mario.isCrouching()) {
			marioHeight = Mario.marioCrouchHeight;
			marioWidth = Mario.marioCrouchWidth;
			error = error_crouch;
		}
		else {
			marioHeight = Mario.marioHeight;
			marioWidth = Mario.marioWidth;
			error = error_no_crouch;
		}
		
		for(int i=0;i<nrObstacole;i++)
		{
			if(!(level.getObstacol(i) instanceof InvisibleBlock  && !( ( (InvisibleBlock)level.getObstacol(i) ).isExplored() )  ) ) {
				Rectangle r = level.getObstacol(i).getBounds();
				if(r.y >= mario.marioY + marioHeight - 5){
					
					if(mario.marioX >= r.x && mario.marioX + marioWidth <= r.x + r.width) {
						if(r.y < min)
							min = r.y;
					}
					else if(mario.marioX >= r.x && mario.marioX + error <= r.x + r.width) {
						if(r.y < min)
							min = r.y;
					}
					else if(mario.marioX <= r.x && mario.marioX + marioWidth >= r.x + r.width) {
						if(r.y < min)
							min = r.y;
					}
					else if(mario.marioX + marioWidth - error >= r.x && mario.marioX + marioWidth <= r.x + r.width) {
						if(r.y < min)
							min = r.y;
					}
				}
			}
		}
		int rez = min - marioHeight + 5;
		return rez;
	}
	
	public static int xLateralCollision(Levels level, Mario mario, int error_crouch, int error_no_crouch) {
		int nrObstacole = level.getNrObstacole();
		
		int collision = -1;
		int distanceFromObject = 1;
		
		int marioHeight;
		int marioWidth;
		int error;
		if(mario.isCrouching()) {
			marioHeight = Mario.marioCrouchHeight;
			marioWidth = Mario.marioCrouchWidth;
			error = error_crouch;
		}
		else {
			marioHeight = Mario.marioHeight;
			marioWidth = Mario.marioWidth;
			error = error_no_crouch;
		}
		
		for(int i=0;i<nrObstacole;i++) {
			if(!(level.getObstacol(i) instanceof Line || (level.getObstacol(i) instanceof InvisibleBlock && !( ( (InvisibleBlock)level.getObstacol(i) ).isExplored() ) ) ) ) {
				Rectangle r = level.getObstacol(i).getBounds();
				
				if(r.y <= mario.marioY && r.y + r.height >= mario.marioY + marioHeight) {
					if(mario.marioX >= r.x && mario.marioX <= r.x + r.width - error) {
						collision = r.x + r.width - error + distanceFromObject;
					}
					else if(mario.marioX + marioWidth - error >= r.x && mario.marioX + marioWidth <= r.x + r.width) {
						collision = r.x - marioWidth + error - distanceFromObject;
					}
				}
				else if(r.y >= mario.marioY && r.y + r.height <= mario.marioY + marioHeight) {
					if(mario.marioX >= r.x && mario.marioX <= r.x + r.width - error) {
						collision = r.x + r.width - error + distanceFromObject;
					}
					else if(mario.marioX + marioWidth - error >= r.x && mario.marioX + marioWidth <= r.x + r.width) {
						collision = r.x - marioWidth + error - distanceFromObject;
					}
				}
				else if(r.y >= mario.marioY && r.y + 5 < mario.marioY + marioHeight) {
					if(mario.marioX >= r.x && mario.marioX <= r.x + r.width - error) {
						collision = r.x + r.width - error + distanceFromObject;
					}
					else if(mario.marioX + marioWidth - error >= r.x && mario.marioX + marioWidth <= r.x + r.width) {
						collision = r.x - marioWidth + error - distanceFromObject;
					}
				}
				else if(r.y + r.height >= mario.marioY && r.y + r.height <= mario.marioY + marioHeight) {
					if(mario.marioX >= r.x && mario.marioX <= r.x + r.width - error) {
						collision = r.x + r.width - error + distanceFromObject;
					}
					else if(mario.marioX + marioWidth - error >= r.x && mario.marioX + marioWidth <= r.x + r.width) {
						collision = r.x - marioWidth + error - distanceFromObject;
					}
				}
			}
		}
		return collision;
	}

	public static int yHeadCollision(Levels level, Mario mario, int error_crouch, int error_no_crouch) {
		int nrObstacole = level.getNrObstacole();
		
		int collision = -1;
		int distanceFromObject = 1;
		
		int marioHeight;
		int marioWidth;
		int error;
		if(mario.isCrouching()) {
			marioHeight = Mario.marioCrouchHeight;
			marioWidth = Mario.marioCrouchWidth;
			error = error_crouch;
		}
		else {
			marioHeight = Mario.marioHeight;
			marioWidth = Mario.marioWidth;
			error = error_no_crouch;
		}
		if(!(mario.isJumping() && mario.isAscending())) {
			return collision;
		}
		
		int yAux = mario.getLastJumpPositionAscending();
		
		for(int i=0;i<nrObstacole;i++) {
			if(level.getObstacol(i) instanceof Brick || level.getObstacol(i) instanceof Ground || level.getObstacol(i) instanceof QuestionBlock || level.getObstacol(i) instanceof InvisibleBlock) {
				Rectangle r = level.getObstacol(i).getBounds();
				
				if(mario.marioY >= r.y + r.height - (yAux - mario.marioY) && mario.marioY <= r.y + r.height ){
					
					if(mario.marioX >= r.x && mario.marioX + marioWidth <= r.x + r.width) {
						collision = r.y + r.height + distanceFromObject;
						checkMushroom(level, r, i);
						checkInvisibleBlock(mario, level, r, i);
					}
					else if(mario.marioX >= r.x && mario.marioX + error <= r.x + r.width) {
						collision = r.y + r.height + distanceFromObject;
						checkMushroom(level, r, i);
						checkInvisibleBlock(mario, level, r, i);
					}
					else if(mario.marioX <= r.x && mario.marioX + marioWidth >= r.x + r.width) {
						collision = r.y + r.height + distanceFromObject;
						checkMushroom(level, r, i);
						checkInvisibleBlock(mario, level, r, i);
					}
					else if(mario.marioX + marioWidth - error >= r.x && mario.marioX + marioWidth <= r.x + r.width) {
						collision = r.y + r.height + distanceFromObject;
						checkMushroom(level, r, i);
						checkInvisibleBlock(mario, level, r, i);					}
				}
			}
		}
		
		return collision;
	}
	
	

	private static void checkMushroom(Levels level, Rectangle r, int i) {
		if(level.getObstacol(i) instanceof QuestionBlock && !(((QuestionBlock)level.getObstacol(i)).isExplored())) {
			((QuestionBlock)level.getObstacol(i)).setExplored(true);
			((QuestionBlock)level.getObstacol(i)).setEmptyBlock();
			MainGame.setCreateMushroom(true, r);
		}
	}
	
	private static void checkInvisibleBlock(Mario mario, Levels level, Rectangle r, int i) {
		if(mario.isJumping() && mario.isAscending()) {
			if(level.getObstacol(i) instanceof InvisibleBlock && !(((InvisibleBlock)level.getObstacol(i)).isExplored())) {
				((InvisibleBlock)level.getObstacol(i)).setExplored(true);
				((InvisibleBlock)level.getObstacol(i)).setEmptyBlock();
			}
		}
	}

	public static int yObstacolBellowMushroom(Levels level, Mushroom mushroom, int error) {
		int nrObstacole = level.getNrObstacole();
		int min = MainGame.HEIGHT + Mushroom.MUSHROOM_HEIGHT;
		
		int mushroomHeight = Mushroom.MUSHROOM_HEIGHT;
		int mushroomWidth = Mushroom.MUSHROOM_WIDTH;
		
		for(int i=0;i<nrObstacole;i++)
		{
			//if(!(level.getObstacol(i) instanceof Flag)) {
				Rectangle r = level.getObstacol(i).getBounds();
				if(r.y >= mushroom.yMushroom + mushroomHeight - 5){
					
					if(mushroom.xMushroom >= r.x && mushroom.xMushroom + mushroomWidth <= r.x + r.width) {
						if(r.y < min)
							min = r.y;
					}
					else if(mushroom.xMushroom >= r.x && mushroom.xMushroom + error <= r.x + r.width) {
						if(r.y < min)
							min = r.y;
					}
					else if(mushroom.xMushroom <= r.x && mushroom.xMushroom + mushroomWidth >= r.x + r.width) {
						if(r.y < min)
							min = r.y;
					}
					else if(mushroom.xMushroom + mushroomWidth - error >= r.x && mushroom.xMushroom + mushroomWidth <= r.x + r.width) {
						if(r.y < min)
							min = r.y;
					}
				}
			//}
		}
		int rez = min - mushroomHeight + 5;
		return rez;
	}

	public static boolean isLateralCollisionMushroom(Levels level, Mushroom mushroom, int error) {
		int nrObstacole = level.getNrObstacole();
		
		int mushroomHeight = Mushroom.MUSHROOM_HEIGHT;
		int mushroomWidth = Mushroom.MUSHROOM_WIDTH;
		
		for(int i=0;i<nrObstacole;i++) {
			if(!(level.getObstacol(i) instanceof Line)) {
				Rectangle r = level.getObstacol(i).getBounds();
				if(level.getObstacol(i) instanceof Tube) {
					error -= 10;
				}
				if(r.y <= mushroom.yMushroom && r.y + r.height >= mushroom.yMushroom + mushroomHeight) {
					if(mushroom.xMushroom >= r.x && mushroom.xMushroom <= r.x + r.width - error) {
						return true;
					}
					else if(mushroom.xMushroom + mushroomWidth - error >= r.x && mushroom.xMushroom + mushroomWidth <= r.x + r.width) {
						return true;					}
				}
				else if(r.y >= mushroom.yMushroom && r.y + r.height <= mushroom.yMushroom + mushroomHeight) {
					if(mushroom.xMushroom >= r.x && mushroom.xMushroom <= r.x + r.width - error) {
						return true;					}
					else if(mushroom.xMushroom + mushroomWidth - error >= r.x && mushroom.xMushroom + mushroomWidth <= r.x + r.width) {
						return true;					}
				}
				else if(r.y >= mushroom.yMushroom && r.y + 5 < mushroom.yMushroom + mushroomHeight) {
					if(mushroom.xMushroom >= r.x && mushroom.xMushroom <= r.x + r.width - error) {
						return true;					}
					else if(mushroom.xMushroom + mushroomWidth - error >= r.x && mushroom.xMushroom + mushroomWidth <= r.x + r.width) {
						return true;					}
				}
				else if(r.y + r.height >= mushroom.yMushroom && r.y + r.height <= mushroom.yMushroom + mushroomHeight) {
					if(mushroom.xMushroom >= r.x && mushroom.xMushroom <= r.x + r.width - error) {
						return true;					}
					else if(mushroom.xMushroom + mushroomWidth - error >= r.x && mushroom.xMushroom + mushroomWidth <= r.x + r.width) {
						return true;					}
				}
				if(level.getObstacol(i) instanceof Tube) {
					error += 10;
				}
			}
		}
		return false;
	}

	
	
	public static int yObstacolBellowMonster(Levels level, Monster monster, int error) {
		int nrObstacole = level.getNrObstacole();
		int min = MainGame.HEIGHT + monster.getHeight() + 100;
		
		int monsterHeight = monster.getHeight();
		int monsterWidth = monster.getWidth();
		
		for(int i=0;i<nrObstacole;i++)
		{
			//if(!(level.getObstacol(i) instanceof Flag)) {
				Rectangle r = level.getObstacol(i).getBounds();
				if(r.y >= monster.y + monsterHeight - 5){
					
					if(monster.x >= r.x && monster.x + monsterWidth <= r.x + r.width) {
						if(r.y < min)
							min = r.y;
					}
					else if(monster.x >= r.x && monster.x + error <= r.x + r.width) {
						if(r.y < min)
							min = r.y;
					}
					else if(monster.x <= r.x && monster.x + monsterWidth >= r.x + r.width) {
						if(r.y < min)
							min = r.y;
					}
					else if(monster.x + monsterWidth - error >= r.x && monster.x + monsterWidth <= r.x + r.width) {
						if(r.y < min)
							min = r.y;
					}
				}
			//}
		}
		int rez = min - monsterHeight + 5;
		return rez;
	}

	public static boolean isLateralCollisionMonster(Levels level, Monster monster, int error) {
		int nrObstacole = level.getNrObstacole();
		
		int mushroomHeight = monster.getHeight();
		int mushroomWidth = monster.getWidth();
		
		for(int i=0;i<nrObstacole;i++) {
			if(!(level.getObstacol(i) instanceof Line)) {
				Rectangle r = level.getObstacol(i).getBounds();
				if(level.getObstacol(i) instanceof Tube) {
					error -= 10;
				}
				if(monster instanceof Bullet && level.getObstacol(i) instanceof BulletBlaster) {
					return false;
				}
				if(r.y <= monster.y && r.y + r.height >= monster.y + mushroomHeight) {
					if(monster.x >= r.x && monster.x <= r.x + r.width - error) {
						return true;
					}
					else if(monster.x + mushroomWidth - error >= r.x && monster.x + mushroomWidth <= r.x + r.width) {
						return true;					}
				}
				else if(r.y >= monster.y && r.y + r.height <= monster.y + mushroomHeight) {
					if(monster.x >= r.x && monster.x <= r.x + r.width - error) {
						return true;					}
					else if(monster.x + mushroomWidth - error >= r.x && monster.x + mushroomWidth <= r.x + r.width) {
						return true;					}
				}
				else if(r.y >= monster.y && r.y + 5 < monster.y + mushroomHeight) {
					if(monster.x >= r.x && monster.x <= r.x + r.width - error) {
						return true;					}
					else if(monster.x + mushroomWidth - error >= r.x && monster.x + mushroomWidth <= r.x + r.width) {
						return true;					}
				}
				else if(r.y + r.height >= monster.y && r.y + r.height <= monster.y + mushroomHeight) {
					if(monster.x >= r.x && monster.x <= r.x + r.width - error) {
						return true;					}
					else if(monster.x + mushroomWidth - error >= r.x && monster.x + mushroomWidth <= r.x + r.width) {
						return true;					}
				}
				if(level.getObstacol(i) instanceof Tube) {
					error += 10;
				}
			}
		}
		return false;
	}


}
