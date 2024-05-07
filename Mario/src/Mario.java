import java.awt.*;

import java.lang.Math; 
import java.awt.event.*;
import javax.swing.*;

public class Mario extends JLabel implements KeyListener{
	
	public static final int MARIO_HEIGHT = 100;
	public static final int MARIO_WIDTH = 100;
	public static final int MARIO_CROUCH_HEIGHT = 76;
	public static final int MARIO_CROUCH_WIDTH = 85;
	
	public static final int SMALL_MARIO_HEIGHT = 75;
	public static final int SMALL_MARIO_WIDTH = 75;
	public static final int SMALL_MARIO_CROUCH_HEIGHT = 57;
	public static final int SMALL_MARIO_CROUCH_WIDTH = 64;
	
	public static int marioHeight = MARIO_HEIGHT;
	public static int marioWidth = MARIO_WIDTH;
	public static int marioCrouchHeight = MARIO_CROUCH_HEIGHT;
	public static int marioCrouchWidth = MARIO_CROUCH_WIDTH;
	
	private boolean big = true;
	
	public static final int MARIO_MAX_SPEED = 14;
	public static final int MARIO_JUMP_HEIGHT = 180;
	
	private static int marioSpeed = 0;
	private double tRun;
	private final double runAcc = 20;
	private final double instantSpeed = 5;
	
	private int x;
	private int supposedY;
	
	public int marioY;
	public int marioX;
	
	private boolean running = false;
	private boolean lookingRight = true;
	
	private boolean jumping = false;
	private boolean ascending = true;
	
	private boolean crouching = false;
	private int crouchAcc = 20;
	private int yCrouch = supposedY;
	
	private int yJump = supposedY;
	private int jumpHeight = MARIO_JUMP_HEIGHT;
	private int jumpAcc = 10;
	private int yInitCrouch = supposedY;
	
	private int jumpingFromY;
	private int fallingFromY;
	
	public static final double g = 9.8;
	private double t = 0;
	private double vitezaInit = Math.sqrt(2 * g * jumpHeight);
	
	private ImageIcon marioLookingRight;
	private ImageIcon marioLookingLeft;
	private ImageIcon marioRunningRight;
	private ImageIcon marioRunningLeft;
	private ImageIcon marioJumpingRight;
	private ImageIcon marioJumpingLeft;
	private ImageIcon marioCrouchingRight;
	private ImageIcon marioCrouchingLeft;
	
	public static int groundBelowError = 15;
	public static int groundBelowErrorCrouch = 15;
	public static int lateralCollisionError = 15;
	
	public static boolean gameOver = false;
	public static boolean levelPassed = false;
	
	
	public Mario(){
		gameOver = false;
		levelPassed = false;
		
		marioLookingRight = ResourceLoader.load("Images/Mario_standing_right.gif");
		marioLookingLeft = ResourceLoader.load("Images/Mario_standing_left.gif");
		marioRunningRight = ResourceLoader.load("Images/Mario_running_right.gif");
		marioRunningLeft = ResourceLoader.load("Images/Mario_running_left.gif");
		marioJumpingRight = ResourceLoader.load("Images/Mario_jumping_right.gif");
		marioJumpingLeft = ResourceLoader.load("Images/Mario_jumping_left.gif");
		marioCrouchingRight = ResourceLoader.load("Images/Mario_crouching_right.gif");
		marioCrouchingLeft = ResourceLoader.load("Images/Mario_crouching_left.gif");
		
		if(MainGame.getLevelNr() >= 6) {
			setMarioSize("SMALL");
		}
		else {
			marioHeight = MARIO_HEIGHT;
			marioWidth = MARIO_WIDTH;
			marioCrouchHeight = MARIO_CROUCH_HEIGHT;
			marioCrouchWidth = MARIO_CROUCH_WIDTH;
		}
		
		x = MainGame.WIDTH/2 - marioWidth/2;
		supposedY = MainGame.HEIGHT - marioHeight - Ground.GROUND_LEVEL + 5;
		yJump = supposedY;
		marioX = x;
		marioY = supposedY;
		
		this.setLayout(null);
		this.setIcon(marioLookingRight);
		setBounds(x, supposedY, marioWidth, marioHeight);

		setFocusable(true);
		requestFocus();
		addKeyListener(this);
	}
	
	
	public void marioActionPerformed(ActionEvent e) {
		if(levelPassed == false && marioY >= MainGame.HEIGHT) {
			gameOver = true;
		}
		if(marioX + marioWidth/2 >= MainGame.getLevel().getFlagPosition()) {
			levelPassed = true;
		}
		
		if(running)
			updateMarioSpeed();
		
		updateGroundLevel();

        if (jumping) {
            jump();
        }
        if(crouching) {
        	if(yInitCrouch < supposedY)
        		crouch();
        }
    }
	
	
	
	public void jump() {					//regleaza inaltimea unei sarituri
		t += MainGame.TIME_SPEED/1000f;
		
		if (ascending) {
			yJump = (int)(jumpingFromY - vitezaInit * jumpAcc*t + (g * jumpAcc*t * jumpAcc*t)/2);
		}
        else {
        	yJump = (int)(fallingFromY + (g * jumpAcc*t * jumpAcc*t)/2);
        }

        if (ascending && yJump <= jumpingFromY - jumpHeight) {
            yJump = jumpingFromY - jumpHeight;
            ascending = false;
            t = 0;
        }
        if (!ascending && yJump >= supposedY) {
            yJump = supposedY;
            jumping = false;
            ascending = true;
            updateMarioIcon();
        }
        marioY = yJump;
        this.setBounds(x, yJump, marioWidth, marioHeight);
	}
	
	public void crouch() {
		t += MainGame.TIME_SPEED/1000f;
		yCrouch = (int)(yInitCrouch + (g * crouchAcc*t * crouchAcc*t)/2);
		if(yCrouch >= supposedY ) {
			yCrouch = supposedY ;
		}
		marioY = yCrouch;
		this.setBounds(x + (marioWidth - marioCrouchWidth)/2, yCrouch, marioCrouchWidth, marioCrouchHeight);
	}
	
    private void updateMarioIcon() {				//regleaza starea caracterului dupa aterizare
    	this.setBounds(x, supposedY, marioWidth, marioHeight);
    	marioY = supposedY;
        if (lookingRight) {
        	if (running) this.setIcon(marioRunningRight);
        	else this.setIcon(marioLookingRight);
        } else {
            if (running) this.setIcon(marioRunningLeft);
            else this.setIcon(marioLookingLeft);
        }
    }        
    
    private void updateMarioIconSizeBig() {				
    	this.setBounds(marioX, supposedY, marioWidth, marioHeight);
    	marioY = supposedY;
        if (lookingRight) {
        	if(!crouching) {
        		if (running) this.setIcon(marioRunningRight);
        		else this.setIcon(marioLookingRight);
        	}
        	else {
        		this.setIcon(marioCrouchingRight);
        	}
        } else {
        	if(!crouching) {
        		if (running) this.setIcon(marioRunningLeft);
        		else this.setIcon(marioLookingLeft);	
        	}
        	else {
        		this.setIcon(marioCrouchingLeft);
        	}
        }
    }        
    

    private void updateMarioSpeed() {
    	tRun += MainGame.TIME_SPEED/1000f;
    	marioSpeed = (int)(instantSpeed + runAcc * tRun);
    	if(marioSpeed >= MARIO_MAX_SPEED) {
    		marioSpeed = MARIO_MAX_SPEED;
    	}
    }

    private void updateGroundLevel() {
    	int temp = 0;
    	try {
    		temp = Obstacol.yObstacolBelow(MainGame.getLevel(), this, groundBelowErrorCrouch, groundBelowError);
    		supposedY = temp;
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}

		if(!crouching && !jumping && marioY < supposedY) {
			jumping = true;
			ascending = false;
			fallingFromY = marioY;
			t = 0;
			if(lookingRight)
				this.setIcon(marioJumpingRight);
			else
				this.setIcon(marioJumpingLeft);
		}
    }
	
    public int lateralCollision(int col) {
    	int fixing = 0;
    	running = false;
    	if(jumping) {
    		tRun = 0;
    	}
    	if(!crouching)
    		fixing = marioX - col;
    	return fixing;
    }
    
    public void headCollision(int col) {
    	jumping = true;
    	ascending = false;
    	fallingFromY = col;
    	t = 0.03;
    }
    
    
    
	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		boolean wasLookingRight;

	    switch (keyCode) {
	    //UP-------------------------------------------------UP
	        case KeyEvent.VK_UP:
	        	int aux = 0;
	        	if(crouching)
        			aux = marioHeight - marioCrouchHeight;
	        	crouching = false;
	        	if(!jumping) {
	        		if(lookingRight) {
	        			this.setIcon(marioJumpingRight);
	        		}
	        		else {
	        			this.setIcon(marioJumpingLeft);
	        		}
	        		jumping = true;
	        		t = 0;        		
	        		jumpingFromY = supposedY - aux;
	        		marioY = jumpingFromY;
	        		fallingFromY = jumpingFromY - jumpHeight;
	        	}
	            break;
	            
	     //DOWN-------------------------------------------------DOWN
	        case KeyEvent.VK_DOWN:
	        	if(!crouching) {
	        		crouching = true;
	        		running = false;
	        		t = 0;
	        		if(marioY == supposedY) {
	        			t = 10;
	        		}
	        		yInitCrouch = marioY;	
	        		this.setBounds(x + (marioWidth - marioCrouchWidth)/2, yInitCrouch + marioHeight - marioCrouchHeight, marioCrouchWidth, marioCrouchHeight);
	        		if(lookingRight) {
	        			this.setIcon(marioCrouchingRight);
	        		}
	        		else {
	        			this.setIcon(marioCrouchingLeft);
	        		}
	        		jumping = false;
	        		ascending = true;
	        	}
	            break;
	            
	     //LEFT-------------------------------------------------LEFT
	        case KeyEvent.VK_LEFT:
	        	wasLookingRight = lookingRight;
	        	lookingRight=false;
	        	if(!crouching) {
	        		if(!running || (running && wasLookingRight)) {
	        			running=true;
	        			tRun = 0;
	        		}
	        		if(!jumping)
	        			this.setIcon(marioRunningLeft);
	        		else
	        			this.setIcon(marioJumpingLeft);
	        		break;
	        	}
	        	else {
	        		this.setIcon(marioCrouchingLeft);
	        	}
	        	break;
	            
	     //RIGHT-------------------------------------------------RIGHT    
	        case KeyEvent.VK_RIGHT:
	        	wasLookingRight = lookingRight;
	        	lookingRight=true;
	        	if(!crouching) {
	        		if(!running || (running && !wasLookingRight)) {
	        			running=true;
	        			tRun = 0;
	        		}
	        		if(!jumping)
	        			this.setIcon(marioRunningRight);
	        		else
	        			this.setIcon(marioJumpingRight);
	        		break;     		
	        	}
	        	else {
	        		this.setIcon(marioCrouchingRight);
	        	}
	    }
	}
	
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();

	    switch (keyCode) {
	  //UP-------------------------------------------------UP
	        case KeyEvent.VK_UP:
	            
	            break;
	            
	  //DOWN-------------------------------------------------DOWN  
	        case KeyEvent.VK_DOWN:
	        	if(crouching) {
	        		supposedY = supposedY + marioCrouchHeight - marioHeight;
	        		crouching = false;
	        		
	        		int col = Obstacol.yHeadCollision(MainGame.getLevel(), this, Mario.groundBelowErrorCrouch, Mario.groundBelowError);
	        		if(col >= 0) {
	        			headCollision(col);
	        		}
	        		
	        		if(marioY < supposedY) {
	        			jumping = true;
	        			ascending = false;
	        			fallingFromY = marioY;
	        			if(lookingRight) {
		        			this.setIcon(marioJumpingRight);
		        		}
		        		else {
		        			this.setIcon(marioJumpingLeft);
		        		}
	        		}
	        		else {
	        			if(!jumping)
	        				updateMarioIcon();
	        		}
	        	}
	        	break;
	            
	  //LEFT-------------------------------------------------LEFT
	        case KeyEvent.VK_LEFT:
	        	if(running && lookingRight) {
	        		if(crouching) {
	        			running = false;
	        		}
	        	}
	        	else {
	        		running = false;
	        		if(!crouching) {
	        			if(!jumping)
	        				this.setIcon(marioLookingLeft);
	        		}
	        		else {
	        			this.setIcon(marioCrouchingLeft);
	        		}
	        	}
	            break;
	            
	  //RIGHT-------------------------------------------------RIGHT
	        case KeyEvent.VK_RIGHT:
	        	if(running && !lookingRight) {
	        		//nothing happens
	        	}
	        	else {
	        		running=false;
	        		if(!crouching) {
	        			if(!jumping)
	        				this.setIcon(marioLookingRight);
	        		}
	        		else {
	        			this.setIcon(marioCrouchingRight);
	        		}
	        	}
	            break;
	    }
	}

	public boolean isRunning() {
		return running;
	}
	public boolean isLookingRight() {
		return lookingRight;
	}
	public boolean isCrouching() {
		return crouching;
	}
	public boolean isFallingCrouched() {
		if(crouching && marioY < supposedY)
			return true;
		return false;
	}
	public boolean isJumping() {
		return jumping;
	}
	public boolean isAscending() {
		return ascending;
	}
	public double getT() {
		return t;
	}
	public int getMarioSpeed() {
		if(lookingRight)
			return marioSpeed;
		else
			return -marioSpeed;
	}
	
	
	public void setMarioSize(String s) {
		switch(s) {
		case "BIG" :
			big = true;
			
			marioHeight = MARIO_HEIGHT;
			marioWidth = MARIO_WIDTH;
			marioCrouchHeight = MARIO_CROUCH_HEIGHT;
			marioCrouchWidth = MARIO_CROUCH_WIDTH;
			
			marioLookingRight = ResourceLoader.load("Images/Mario_standing_right.gif");
			marioLookingLeft = ResourceLoader.load("Images/Mario_standing_left.gif");
			marioRunningRight = ResourceLoader.load("Images/Mario_running_right.gif");
			marioRunningLeft = ResourceLoader.load("Images/Mario_running_left.gif");
			marioJumpingRight = ResourceLoader.load("Images/Mario_jumping_right.gif");
			marioJumpingLeft = ResourceLoader.load("Images/Mario_jumping_left.gif");
			marioCrouchingRight = ResourceLoader.load("Images/Mario_crouching_right.gif");
			marioCrouchingLeft = ResourceLoader.load("Images/Mario_crouching_left.gif");
			
			groundBelowError = 15;
			groundBelowErrorCrouch = 15;
			lateralCollisionError = 15;
			
			//marioX = MainGame.WIDTH/2 - marioWidth/2;
			//this.setBounds(marioX, marioY, marioWidth, marioHeight);
			
			if(!jumping) {
				if(marioY <= supposedY) {
					marioY -= 50;
					supposedY = Obstacol.yObstacolBelow(MainGame.getLevel(), this, groundBelowErrorCrouch, groundBelowError);
					marioY = supposedY;
					updateMarioIconSizeBig();
				}
			}
			else {
				if(lookingRight)
					this.setIcon(marioJumpingRight);
				else
					this.setIcon(marioJumpingLeft);
			}
			revalidate();
			repaint();
			
			break;
		case "SMALL" :
			big = false;
			
			marioHeight = SMALL_MARIO_HEIGHT;
			marioWidth = SMALL_MARIO_WIDTH;
			marioCrouchHeight = SMALL_MARIO_CROUCH_HEIGHT;
			marioCrouchWidth = SMALL_MARIO_CROUCH_WIDTH;
			
			marioLookingRight = ResourceLoader.load("Images/Small_Mario_standing_right.gif");
			marioLookingLeft = ResourceLoader.load("Images/Small_Mario_standing_left.gif");
			marioRunningRight = ResourceLoader.load("Images/Small_Mario_running_right.gif");
			marioRunningLeft = ResourceLoader.load("Images/Small_Mario_running_left.gif");
			marioJumpingRight = ResourceLoader.load("Images/Small_Mario_jumping_right.gif");
			marioJumpingLeft = ResourceLoader.load("Images/Small_Mario_jumping_left.gif");
			marioCrouchingRight = ResourceLoader.load("Images/Small_Mario_crouching_right.gif");
			marioCrouchingLeft = ResourceLoader.load("Images/Small_Mario_crouching_left.gif");
			
			groundBelowError = 11;
			groundBelowErrorCrouch = 11;
			lateralCollisionError = 11;
			
			//marioX = MainGame.WIDTH/2 - marioWidth/2;
			//this.setBounds(marioX, marioY, marioWidth, marioHeight);
			
			if(jumping) {
				if(lookingRight)
					this.setIcon(marioJumpingRight);
				else
					this.setIcon(marioJumpingLeft);
			}
			else if(crouching) {
				if(lookingRight)
					this.setIcon(marioCrouchingRight);
				else
					this.setIcon(marioCrouchingLeft);
			}
			
			revalidate();
			repaint();
			
			break;
		}
	}
	
	public boolean isBig() {
		return big;
	}
	
	public void setGameOver() {
		gameOver = true;
	}
	public void setJump() {
		jumping = true;
		ascending = true;
		t = 0;
		jumpingFromY = marioY;
		fallingFromY = jumpingFromY - jumpHeight;
	}
	
	public int getLastJumpPositionAscending() {
		if(isJumping() && isAscending()) {
			double taux = t - MainGame.TIME_SPEED/1000f;
			yJump = (int)(jumpingFromY - vitezaInit * jumpAcc*taux + (g * jumpAcc*taux * jumpAcc*taux)/2);
			return yJump;
		}
		return marioY;
	}
}








