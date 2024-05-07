import javax.swing.*;

public class MainClass {
	private static JFrame menuFrame;
	private static JFrame gameFrame;
	private static JFrame gameOverFrame;
	private static JFrame levelsMenuFrame;
	private static JFrame levelPassedFrame;
	private static JFrame gameFinnishedFrame;
	
	public static void main(String[] args){
		menuFrame = new JFrame("Menu");
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setSize(MainMenu.WIDTH, MainMenu.HEIGHT);
		
		MainMenu menuPane = new MainMenu();
		menuFrame.setContentPane(menuPane);
		
		menuFrame.setVisible(true);
	 }
	
	public static void setGameFrame(int level) {
		gameFrame = new JFrame("Mario");
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(MainGame.WIDTH, MainGame.HEIGHT);
		
		MainGame.setLevel(level);
		MainGame gamePane = new MainGame();
		gameFrame.setContentPane(gamePane);
		
		gameFrame.setVisible(true);
		
		try {
			levelsMenuFrame.setVisible(false);
			levelsMenuFrame.dispose();
		}
		catch(Exception e) {
			
		}
		try {
			levelPassedFrame.setVisible(false);
			levelPassedFrame.dispose();
		}
		catch(Exception e) {
			
		}
	}
	
	public static void setNewGameFrame() {
		gameFrame = new JFrame("Mario");
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(MainGame.WIDTH, MainGame.HEIGHT);
		
		MainGame gamePane = new MainGame();
		gameFrame.setContentPane(gamePane);
		
		gameFrame.setVisible(true);
		
		gameOverFrame.setVisible(false);
		gameOverFrame.dispose();
	}
	
	public static void setGameOverFrame() {
		gameOverFrame = new JFrame("Game Over");
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(MainGame.WIDTH, MainGame.HEIGHT);
		
		GameOver gameOverPane = new GameOver();
		gameOverFrame.setContentPane(gameOverPane);
		
		gameOverFrame.setVisible(true);
		gameOverFrame.setSize(MainGame.WIDTH, MainGame.HEIGHT);
		
		gameFrame.setVisible(false);
		gameFrame.dispose();
	}
	
	public static void setMenuFrame() {
		menuFrame = new JFrame("Menu");
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setSize(MainMenu.WIDTH, MainMenu.HEIGHT);
		
		MainMenu menuPane = new MainMenu();
		menuFrame.setContentPane(menuPane);
		
		menuFrame.setVisible(true);
		
		try {
			gameOverFrame.setVisible(false);
			gameOverFrame.dispose();
		}
		catch(Exception e) {
			
		}
		try {
			levelPassedFrame.setVisible(false);
			levelPassedFrame.dispose();
		}
		catch(Exception e) {
			
		}
		try {
			gameFinnishedFrame.setVisible(false);
			gameFinnishedFrame.dispose();
		}
		catch(Exception e) {
			
		}
	}
	
	public static void setLevelsMenuFrame() {
		levelsMenuFrame = new JFrame("Levels");
		levelsMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		levelsMenuFrame.setSize(MainGame.WIDTH, MainGame.HEIGHT);
		
		LevelsMenu levelsPane = new LevelsMenu();
		levelsMenuFrame.setContentPane(levelsPane);
		
		levelsMenuFrame.setVisible(true);
		
		menuFrame.setVisible(false);
		menuFrame.dispose();
	}
	
	public static void setLevelPassedFrame(int lvl) {
		levelPassedFrame = new JFrame("LevelPassed");
		levelPassedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		levelPassedFrame.setSize(MainGame.WIDTH, MainGame.HEIGHT);
		
		LevelPassed levelPassedPane = new LevelPassed(lvl);
		levelPassedFrame.setContentPane(levelPassedPane);
		
		levelPassedFrame.setVisible(true);
		
		gameFrame.setVisible(false);
		gameFrame.dispose();
	}
	
	public static void setGameFinnishedFrame() {
		gameFinnishedFrame = new JFrame("GameFinnished");
		gameFinnishedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFinnishedFrame.setSize(MainGame.WIDTH, MainGame.HEIGHT);
		
		GameFinnished gameFinnishedPane = new GameFinnished();
		gameFinnishedFrame.setContentPane(gameFinnishedPane);
		
		gameFinnishedFrame.setVisible(true);
		
		gameFrame.setVisible(false);
		gameFrame.dispose();
	}
	
	public static JFrame getFrame() {
        return menuFrame;
    }
}
