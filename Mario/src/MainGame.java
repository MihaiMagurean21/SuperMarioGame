import java.awt.*;

import java.lang.Math; 
import java.awt.event.*;
import javax.swing.*;

public class MainGame extends JPanel implements ActionListener, MouseListener{
	Mario mario_label;
	
	public static Level1 lvl1;
	public static Level2 lvl2;
	public static Level3 lvl3;
	public static Level4 lvl4;
	public static Level5 lvl5;
	public static Level6 lvl6;
	public static Level7 lvl7;
	public static Level8 lvl8;
	public static Level9 lvl9;
	public static Level10 lvl10;
	
	Timer time;
	public static final int TIME_SPEED = 25;
	
	public static final int WIDTH = 1300;
	public static final int HEIGHT = WIDTH / 16 * 9;
	
	private static int level;
	
	private boolean msgExists = false;
	
	private static boolean createMushroom = false;
	private static Rectangle sourceBox;
	
	
	
	public MainGame(){
		this.setLayout(null);
		
		mario_label = new Mario();
		this.add(mario_label);
		
		switch(level) {
		case 1:
			lvl1 = new Level1();
			for(int i=0; i<lvl1.getNrObstacole();i++) {
				this.add(lvl1.getObstacol(i));
			}
			this.add(lvl1.getFlag());
			break;
		case 2:
			lvl2 = new Level2();
			for(int i=0;i<lvl2.getNrObstacole();i++) {
				this.add(lvl2.getObstacol(i));
			}
			this.add(lvl2.getFlag());
			break;
		case 3:
			lvl3 = new Level3();
			for(int i=0;i<lvl3.getNrObstacole();i++) {
				this.add(lvl3.getObstacol(i));
			}
			this.add(lvl3.getFlag());
			break;
		case 4:
			lvl4 = new Level4();
			for(int i=0;i<lvl4.getNrObstacole();i++) {
				this.add(lvl4.getObstacol(i));
			}
			this.add(lvl4.getFlag());
			break;
		case 5:
			lvl5 = new Level5();
			for(int i=0;i<lvl5.getNrObstacole();i++) {
				this.add(lvl5.getObstacol(i));
			}
			this.add(lvl5.getFlag());
			break;
		case 6:
			lvl6 = new Level6();
			for(int i=0;i<lvl6.getNrObstacole();i++) {
				this.add(lvl6.getObstacol(i));
			}
			this.add(lvl6.getFlag());
			break;
		case 7:
			lvl7 = new Level7();
			for(int i=0;i<lvl7.getNrObstacole();i++) {
				this.add(lvl7.getObstacol(i));
			}
			for(int i=0;i<lvl7.getNrMonsters();i++) {
				this.add(lvl7.getMonster(i));
			}
			this.add(lvl7.getFlag());
			break;
		case 8:
			lvl8 = new Level8();
			for(int i=0;i<lvl8.getNrObstacole();i++) {
				this.add(lvl8.getObstacol(i));
			}
			for(int i=0;i<lvl8.getNrMonsters();i++) {
				this.add(lvl8.getMonster(i));
			}
			this.add(lvl8.getFlag());
			break;
		case 9:
			lvl9 = new Level9();
			for(int i=0;i<lvl9.getNrObstacole();i++) {
				this.add(lvl9.getObstacol(i));
			}
			for(int i=0;i<lvl9.getNrMonsters();i++) {
				this.add(lvl9.getMonster(i));
			}
			this.add(lvl9.getFlag());
			break;
		case 10:
			lvl10 = new Level10();
			for(int i=0;i<lvl10.getNrObstacole();i++) {
				this.add(lvl10.getObstacol(i));
			}
			for(int i=0;i<lvl10.getNrMonsters();i++) {
				this.add(lvl10.getMonster(i));
			}
			this.add(lvl10.getFlag());
			break;
		}
		
		setBackground(new Color(1, 191, 253));
		
		time = new Timer(TIME_SPEED, this);
		time.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(Mario.gameOver) {
			MainClass.setGameOverFrame();
			time.stop();
		}
		if(Mario.levelPassed) {
			levelPassedAction();
		}
		
		mario_label.marioActionPerformed(e);
		if(mario_label.isRunning()) {
			getLevel().move(-mario_label.getMarioSpeed());
		}
		
		int headCol = Obstacol.yHeadCollision(getLevel(), mario_label, Mario.groundBelowErrorCrouch, Mario.groundBelowError);
		int lateralCol = Obstacol.xLateralCollision(getLevel(), mario_label, 0, Mario.lateralCollisionError);
		if(mario_label.isJumping() && mario_label.isAscending() && headCol >= 0) {
			mario_label.headCollision(headCol);
		}
		else if(lateralCol >= 0) {
			Obstacol.xLateralCollision(getLevel(), mario_label, 0, Mario.lateralCollisionError);
			int fixing = mario_label.lateralCollision(lateralCol);
			getLevel().move(fixing);	
		}
		
		allMushroomActions();
		allMonsterActions();
		
    }
	
	private void levelPassedAction() {
		if(!msgExists) {
			this.add(new ClickToContinue());
			revalidate();
			repaint();
			addMouseListener(this);
			msgExists = true;
		}
	}
	
	private void createMushroomAction() {
		Mushroom mushroom = new Mushroom(sourceBox.x, sourceBox.y - Brick.BRICK_HEIGHT);
		if(getLevel() != null) {
			getLevel().setMushroom(mushroom);	
		}
		this.add(mushroom);
		createMushroom = false;
		revalidate();
		repaint();
	}

	private void allMushroomActions() {
		if(createMushroom) {
			createMushroomAction();
		}
		
		if(getLevel() != null) {
			getLevel().moveMushrooms();			
		}
		
		for(int i=0;i<Mushroom.nrMushrooms;i++) {
			if(getLevel() != null) {
				if(getLevel().getMushroom(i) != null) {
					getLevel().getMushroom(i).updateMushroom(getLevel());
					if(getLevel().getMushroom(i).checkMarioCollision(getLevel(), mario_label)) {
						this.remove(getLevel().getMushroom(i));
						getLevel().removeMushroom(i);
						revalidate();
						repaint();
					}	
				}	
			}
		}
	}
	
	public void allMonsterActions() {
		Levels level_temp = getLevel();
		if(level_temp == null) return;
		
		level_temp.moveMonsters();
		Monster.monsterCollision(level_temp);
		
		for(int i=0;i<level_temp.getNrMonsters();i++) {
			Monster monster_temp = level_temp.getMonster(i);
			if(monster_temp == null) return; 
			
			monster_temp.updateMonster(getLevel());
			
			if(monster_temp.isDeployed() && monster_temp.checkMarioOnTop(getLevel(), mario_label)) {
				if(monster_temp instanceof Koopa && !(monster_temp.getCanFall())) {
					monster_temp.setCanFall(true);
					if(!(mario_label.isCrouching())) {
						mario_label.setJump();		
					}
				}else {
					this.remove(monster_temp);
					monster_temp.setBounds(0,10000, 100, 100);
					monster_temp.kill();
					if(!(mario_label.isCrouching())) {
						mario_label.setJump();		
					}
					revalidate();
					repaint();
				}
			}
			else if(monster_temp.isAlive() && monster_temp.checkMarioCollision(level_temp, mario_label)) {
				if(mario_label.isBig()) {
					mario_label.setMarioSize("SMALL");
				}
				else {
					mario_label.setGameOver();
				}
			}
		}
	}
	
	public static int getLevelNr() {
		return level;
	}
	
    public static Levels getLevel() {
    	switch(level) {
		case 1:
			return lvl1;
		case 2:
			return lvl2;
		case 3:
			return lvl3;
		case 4:
			return lvl4;
		case 5:
			return lvl5;
		case 6:
			return lvl6;
		case 7:
			return lvl7;
		case 8:
			return lvl8;
		case 9:
			return lvl9;
		case 10:
			return lvl10;
		}
    	return null;
    }
    
    public static void setLevel(int level) {
    	MainGame.level = level;
    }

	public void mouseClicked(MouseEvent e) {
		if(Mario.levelPassed) {
			time.stop();
			if(level < Levels.nrLevels) {
				MainClass.setLevelPassedFrame(level);	
			}
			else {
				MainClass.setGameFinnishedFrame();
			}
		}
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}
	public void mouseEntered(MouseEvent e) {
		
	}
	public void mouseExited(MouseEvent e) {
		
	}

	public static void setCreateMushroom(boolean b, Rectangle r) {
		createMushroom = b;
		sourceBox = r;
	}
	
	
	
}