import java.awt.Rectangle;

public abstract class Levels {
	Obstacol[] obstacol;
	int nrObstacole;
	
	Mushroom[] mushroom;
	int nrMushrooms;
	
	Monster[] monster;
	int nrMonsters;
	
	public static int nrLevels = 10;
	
	private Flag flag;
	private int flagX;
	private int flagY;
	
	public Levels(int nr, int fX, int fY, int nrMonster) {
		flag = new Flag(fX, fY);
		nrObstacole = nr;
		this.flagX = fX;
		this.flagY = fY;
		obstacol = new Obstacol[nrObstacole];
		mushroom = new Mushroom[100];
		nrMushrooms = 0;
		
		nrMonsters = nrMonster;
		monster = new Monster[nrMonster];
		Monster.restartAllTime();
	}
	
	public int getNrObstacole() {
		return nrObstacole;
	}
	
	public int getNrMushrooms() {
		return nrMushrooms;
	}
	
	public int getNrMonsters() {
		return nrMonsters;
	}
	
	public void setMushroom(Mushroom m) {
		mushroom[nrMushrooms] = m;
		nrMushrooms++;
	}
	
	public Mushroom getMushroom(int i) {
		if(i<nrMushrooms) {
			return mushroom[i];
		}
		return null;
	}
	
	public Obstacol getObstacol(int i) {
		if(i < nrObstacole)
			return obstacol[i];
		return null;
	}
	
	public Monster getMonster(int i) {
		if(i < nrMonsters) {
			return monster[i];
		}
		return null;
	}
	
	public Flag getFlag() {
		return flag;
	}
	
	public void move(int dist) {
		for(int i=0;i<nrObstacole;i++) {
			Rectangle r = obstacol[i].getBounds();
			obstacol[i].setBounds(r.x + dist, r.y , r.width, r.height);
		}
		for(int i=0; i<nrMushrooms;i++) {
			Rectangle r = mushroom[i].getBounds();
			mushroom[i].setBounds(r.x + dist, r.y, r.width, r.height);
		}
		for(int i=0; i<nrMonsters;i++) {
			Rectangle r = monster[i].getBounds();
			monster[i].setBounds(r.x + dist, r.y, r.width, r.height);
			monster[i].addBtwX1(dist);
			monster[i].addBtwX2(dist);
			monster[i].addX(dist);
		}
		flagX += dist;
		flag.setBounds(flagX, flagY, Flag.FLAG_WIDTH, Flag.FLAG_HEIGHT);
	}

	public void moveMushrooms() {
		for(int i=0; i<nrMushrooms;i++) {
			Rectangle r = mushroom[i].getBounds();
			mushroom[i].setMushroomX(r.x + mushroom[i].getSpeed());
			mushroom[i].setBounds(r.x + mushroom[i].getSpeed(), r.y, r.width, r.height);
		}
	}
	
	
	public void removeMushroom(int i) {
		for(int j = i; j < nrMushrooms - 1; j++) {
			mushroom[j] = mushroom[j+1];
		}
		nrMushrooms--;
	}
	
	public void moveMonsters() {
		Monster.increaseAllTime();
		for(int i=0;i<nrMonsters;i++) {
			if(monster[i].getAllTime() < monster[i].getDeployTime())
				continue;
			Rectangle r = monster[i].getBounds();
			if(monster[i].getSpeedx() != 0) {
				if(r.x < monster[i].getBtwX1()) {
					monster[i].setMonsterX(monster[i].getBtwX1());
					monster[i].setBounds(monster[i].getBtwX1(), r.y, r.width, r.height);
					monster[i].changeIcon();
					monster[i].reverseSpeedx();
				}
				else if(r.x > monster[i].getBtwX2()) {
					monster[i].setMonsterX(monster[i].getBtwX2());
					monster[i].setBounds(monster[i].getBtwX2(), r.y, r.width, r.height);
					monster[i].changeIcon();
					monster[i].reverseSpeedx();				}
				else {
					monster[i].setMonsterX(r.x + monster[i].getSpeedx());
					monster[i].setBounds(r.x + monster[i].getSpeedx(), r.y, r.width, r.height);	
				}
			}
			
			r = monster[i].getBounds();
			if(monster[i].getSpeedy() != 0) {
				if(r.y < monster[i].getBtwY1()) {
					monster[i].setMonsterY(monster[i].getBtwY1());
					monster[i].setBounds(r.x, monster[i].getBtwY1(), r.width, r.height);
					monster[i].reverseSpeedy();				
				}
				else if(r.y > monster[i].getBtwY2()) {
					monster[i].setMonsterY(monster[i].getBtwY2());
					monster[i].setBounds(r.x, monster[i].getBtwY2(), r.width, r.height);
					monster[i].reverseSpeedy();						}
				else {
					monster[i].setMonsterY(r.y + monster[i].getSpeedy());
					monster[i].setBounds(r.x, r.y + monster[i].getSpeedy(), r.width, r.height);	
				}
			}
		}
	}
	
	public static boolean validLevel(int lvl) {
		if(lvl > 0 && lvl <= nrLevels) {
			return true;
		}
		return false;
	}
	
	public int getFlagPosition() {
		return flagX + Flag.FLAG_WIDTH/2;
	}
}
