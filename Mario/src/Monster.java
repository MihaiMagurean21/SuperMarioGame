import java.awt.Rectangle;

import javax.swing.*;

public abstract class Monster extends JLabel{
	public int x;
	public int y;
	public int w;
	public int h;
	
	private int betweenX1;
	private int betweenX2;
	private int betweenY1;
	private int betweenY2;
	
	public int speedx;
	public int speedy;
	
	private double deployTime;
	private static double allTime = 0;
	
	private int supposedY = 0;
	private static int error = 10;
	private static int marioCollisionError = 20;
	
	private boolean falling = false;
	private int fallingFromY;
	private int fallAcc = 10;
	private double t = 0;
	private double tOverlap = 0;
	
	private boolean killed = false;
	private boolean jumpingOnTopKills;
	private boolean canFall = true;
	private boolean canLateralCollision = true;
	
	public Monster(int xMonster, int yMonster, int wMonster, int hMonster, int bx1, int bx2, int by1, int by2, int xsp, int ysp, boolean j, double dTime, boolean falls, boolean collisions) {
		this.x = xMonster;
		this.y = yMonster;
		this.w = wMonster;
		this.h = hMonster;
		
		this.betweenX1 = bx1;
		this.betweenX2 = bx2;
		this.betweenY1 = by1;
		this.betweenY2 = by2;
		
		this.speedx = xsp;
		this.speedy = ysp;
		
		jumpingOnTopKills = j;
		
		this.deployTime = dTime;
		this.canFall = falls;
		this.canLateralCollision = collisions;
		this.killed = false;
	}
	
	
	public void updateMonster(Levels level) {
		tOverlap += MainGame.TIME_SPEED/1000f;
		if(this instanceof PiranhaPlant)
			return;
		if(killed)
			return;
		if(allTime < deployTime)
			return;
		if(canFall) {
			supposedY = Obstacol.yObstacolBellowMonster(level, this, error);
			if(this.y < supposedY && !falling) {
				this.t = 0;
				this.falling = true;
				this.fallingFromY = this.y;
			}
			if(this.falling) {
				fallingMethod();
			}
		}
		if(canLateralCollision) {
			if(Obstacol.isLateralCollisionMonster(level, this, error)) {
				this.speedx *= -1;
				this.changeIcon();
			}	
		}
		else {
			if(this instanceof Bullet && Obstacol.isLateralCollisionMonster(level, this, error)) {
				this.setBounds(0, 10000, this.w, this.h);
			}
		}
	}
	
	public void fallingMethod() {
		t += MainGame.TIME_SPEED/1000f;
		this.y = (int)(fallingFromY + (Mario.g * fallAcc*t * fallAcc*t)/2);
		if (this.y >= supposedY) {
			this.y = supposedY;
            falling = false;
        }
        this.setBounds(this.x, this.y, this.w, this.h);
	}
	
	public boolean checkMarioCollision(Levels level, Mario mario) {
		if(killed) return false;
		Rectangle r1 = mario.getBounds();
		Rectangle r2 = this.getBounds();
		if(isOverlapping(r1, r2, marioCollisionError) && tOverlap > 1) {
			tOverlap = 0;
			return true;
		}
		return false;
	}
	
	public boolean checkMarioOnTop(Levels level, Mario mario) {
		if(!jumpingOnTopKills && !(this instanceof Koopa)) 
			return false;
		if(((mario.isJumping() && !(mario.isAscending())) || mario.isFallingCrouched()) && tOverlap > 1) {
			Rectangle r1 = mario.getBounds();
			Rectangle r2 = this.getBounds();
			if(isOverlapTop(mario, r1, r2, error)) {
				return true;
			}
	    }
		return false;
	}
	
	public boolean isOverlapTop(Mario mario, Rectangle r1, Rectangle r2, int error) {
	    if(r1.y + r1.height + error >= r2.y && r1.y + r1.height <= r2.y + r2.height) {
	    	if(r1.x >= r2.x && r1.x + r1.width <= r2.x + r2.width) {
	    		return true;
	    	}
	    	else if(r1.x >= r2.x && r1.x + error <= r2.x + r2.width) {
	    		return true;
	    	}
	    	else if(r1.x <= r2.x && r1.x + r1.width >= r2.x + r2.width) {
	    		return true;
	    	}
	    	else if(r1.x + r1.width - error >= r2.x && r1.x + r1.width <= r2.x + r2.width) {
	    		return true;
	    	}
	    	
	    }
	    return false;
	}

	
	private static boolean isOverlapping(Rectangle r1, Rectangle r2, int error) {
		if (r1.y + r1.height - error <= r2.y || r1.y >= r2.y + r2.height - error) {
	        return false;
	    }

	    if (r1.x + r1.width - error <= r2.x || r1.x >= r2.x + r2.width - error) {
	        return false;
	    }	    
	    return true;
	}
	
	
	public static void monsterCollision(Levels level) {
		for(int i=0;i<level.nrMonsters-1;i++) {
			for(int j=i+1;j<level.nrMonsters;j++) {
				Monster m1 = level.getMonster(i);
				Monster m2 = level.getMonster(j);
				Rectangle r1 = m1.getBounds();
				Rectangle r2 = m2.getBounds();
				if(m1.isDeployed() && m2.isDeployed() && isOverlapping(r1, r2, -5)) {
					level.getMonster(i).reverseSpeedx();
					level.getMonster(i).changeIcon();
					level.getMonster(j).reverseSpeedx();
					level.getMonster(j).changeIcon();
				}
			}
		}
	}
	
	
	public void setMonsterX(int mx) {
		this.x = mx;
	}
	public void setMonsterY(int my) {
		this.y = my;
	}
	
	public int getBtwX1() {
		return betweenX1;
	}
	public int getBtwX2() {
		return betweenX2;
	}
	public int getBtwY1() {
		return betweenY1;
	}
	public int getBtwY2() {
		return betweenY2;
	}
	
	public int getSpeedx() {
		return this.speedx;
	}
	public int getSpeedy() {
		return this.speedy;
	}
	
	public void reverseSpeedx() {
		this.speedx = -this.speedx;
	}
	public void reverseSpeedy() {
		this.speedy = -this.speedy;
	}
	
	public void addBtwX1(int dist) {
		this.betweenX1 += dist;
	}
	public void addBtwX2(int dist) {
		this.betweenX2 += dist;
	}
	public void addX(int dist) {
		this.x += dist;
	}
	
	public int getHeight() {
		return this.h;
	}
	public int getWidth() {
		return this.w;
	}
	
	public double getTimeOverlap() {
		return tOverlap;
	}
	
	public boolean isAlive() {
		return !killed;
	}
	public void kill() {
		killed = true;
	}
	
	public double getAllTime() {
		return allTime;
	}
	public double getDeployTime() {
		return deployTime;
	}
	public boolean isDeployed() {
		if(allTime >= deployTime)
			return true;
		return false;
	}
	
	public static void increaseAllTime() {
		allTime += MainGame.TIME_SPEED/1000f;
	}
	public static void restartAllTime() {
		allTime = 0;
	}
	
	
	public boolean getCanFall() {
		return this.canFall;
	}
	public void setCanFall(boolean b) {
		this.canFall = b;
		this.speedy = 0;
	}
	
	public abstract ImageIcon getLookingLeft();
	public abstract ImageIcon getLookingRight();
	public abstract void changeIcon();
}
