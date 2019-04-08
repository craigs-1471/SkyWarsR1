package swGameMechanics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import swAudio.Music;
import swAudio.MusicPlayer;
import swInterface.MainApp;
import swInterface.RenderButtons;
import swShips.BattleCruiser;
import swShips.BattleShooter;
import swShips.BattleStar;
import swShips.MasterShip;
import swShips.Spaceship;

public class GameData {
	
	private static final int GRID_LENGTH = 16;
	private static ArrayList<ArrayList<Spaceship>> gridList;
	private static Spaceship player;
	private static ArrayList<Spaceship> enemies;
	private static boolean gameOver;
	private static boolean usersGo;
	private static int shipsDestroyed;
	private static int goesTaken;
	private static boolean masterShipOffensive;
	private static boolean hardMode;
	private static String usersName;
	
	public static void playGame() {
		//Music musicPlayer = new Music();
		//musicPlayer.playMusic("ImperialMarch.wav");
		usersName = JOptionPane.showInputDialog("Enter your name", "Player 1");
		gridList = new ArrayList<ArrayList<Spaceship>>(GRID_LENGTH);
		gridList = GridList.setGridList(gridList);
		player = new MasterShip();
		gridList = GridList.initialPlayerListLocation(player, gridList, GRID_LENGTH);
		enemies = new ArrayList<Spaceship>();
		gameOver = false;
		usersGo = true;
		masterShipOffensive = false;
		hardMode = false;
		JRadioButton rdbtnDefensive = MainApp.getRdbtnDefensive();
		rdbtnDefensive.setSelected(!isMasterShipOffensive());
		JRadioButton rdbtnOffensive = MainApp.getRdbtnOffensive();
		rdbtnOffensive.setSelected(isMasterShipOffensive());
		JRadioButton rdbtnEasyMode = MainApp.getRdbtnEasyMode();
		rdbtnEasyMode.setSelected(!isHardMode());
		JRadioButton rdbtnHardMode = MainApp.getRdbtnHardMode();
		rdbtnHardMode.setSelected(isHardMode());
		shipsDestroyed = 0;
		goesTaken = 0;
		RenderButtons.mapButtonGridList(gridList);
	}
	
	public static void saveGame() {
		GameSave save = new GameSave(gridList, player, usersName, enemies, gameOver, usersGo, shipsDestroyed, goesTaken, masterShipOffensive, hardMode);
		String fileName = "data.bin";
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
			os.writeObject(save);
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done writing file");
	}
	
	public static void loadGame() {
		String fileName = "data.bin";
		GameSave save = null;
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
			save = (GameSave) is.readObject();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Load complete");
		loadGameData(save);
	}
	
	public static void saveInitialHighScore() {
		HighScore currentGame = new HighScore(usersName, shipsDestroyed, goesTaken);
		String fileName = "highScores.bin";
		HighScores highScores = new HighScores(currentGame);
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
			os.writeObject(highScores);
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done writing file");
	}
	
	public static void saveHighScore() {
		HighScore currentGame = new HighScore(usersName, shipsDestroyed, goesTaken);
		String fileName = "highScores.bin";
		HighScores highScores = loadHighScores();
		highScores.getHighScores().add(currentGame);
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
			os.writeObject(highScores);
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done writing file");
	}
	
	public static HighScores loadHighScores() {
		String fileName = "highScores.bin";
		HighScores highScores = null;
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
			highScores = (HighScores) is.readObject();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Load complete");
		return highScores;
	}
	
	public static void showHighScores() {
		HighScores highScores = loadHighScores();
		String output = "";
		for(HighScore score : highScores.getHighScores()) {
			output += score.toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, output, "High Scores", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void loadGameData(GameSave save) {
		//gridList = GridList.copyGridList(save.getGridList());
		setGridList(save.getGridList());
		setPlayer(save.getPlayer());
		setUsersName(save.getUsersName());
		setEnemies(save.getEnemies());
		setGameOver(save.isGameOver());
		setUsersGo(save.isUsersGo());
		setShipsDestroyed(save.getShipsDestroyed());
		setGoesTaken(save.getGoesTaken());
		setMasterShipOffensive(save.isMasterShipOffensive());
		setHardMode(save.isHardMode());
		RenderButtons.mapButtonGridList(gridList);
		JRadioButton rdbtnDefensive = MainApp.getRdbtnDefensive();
		rdbtnDefensive.setSelected(isMasterShipOffensive());
		JRadioButton rdbtnOffensive = MainApp.getRdbtnOffensive();
		rdbtnOffensive.setSelected(isMasterShipOffensive());
		JRadioButton rdbtnEasyMode = MainApp.getRdbtnEasyMode();
		rdbtnEasyMode.setSelected(isHardMode());
		JRadioButton rdbtnHardMode = MainApp.getRdbtnHardMode();
		rdbtnHardMode.setSelected(isHardMode());
	}
	
	public static ArrayList<ArrayList<Spaceship>> randomEnemyShip(ArrayList<ArrayList<Spaceship>> gridList) {
		int possibleEnemy = 3; // i.e. one in three chance of spawning enemy
		Random numGenerator = new Random();
		int randNumber = numGenerator.nextInt(possibleEnemy);
		if(randNumber == 0)
			gridList = spawnEnemyShip(gridList);
		return gridList;
	}
	
	public static ArrayList<ArrayList<Spaceship>> spawnEnemyShip(ArrayList<ArrayList<Spaceship>> gridList) {
		int typesOfShip = 3; 
		Random numGenerator = new Random();
		int randNumber = numGenerator.nextInt(typesOfShip);
		if(randNumber == 0) {
			gridList.get(0).add(new BattleStar(enemies));
		}
		else if(randNumber == 1) {
			gridList.get(0).add(new BattleCruiser(enemies));
		}
		else if(randNumber == 2) {
			gridList.get(0).add(new BattleShooter(enemies));
		}
		return gridList;
	}
	
	public static ArrayList<ArrayList<Spaceship>> moveEnemies(ArrayList<ArrayList<Spaceship>> gridList, ArrayList<Spaceship> enemies, Spaceship player) {
		Spaceship enemy;
		int currentLocation, numberOfMoves, newLocation, randNumber, playerLocation;
		playerLocation = player.getCurrentLocation();
		Random numGenerator = new Random();
		for(int i = 0; i < enemies.size(); i++) {
			enemy = enemies.get(i);
			currentLocation = enemy.getCurrentLocation();
			ArrayList<Integer> possibleMoves = PossibleMoves.getPossibleMoves(currentLocation);
			if(isHardMode()) {
				if(possibleMoves.contains(playerLocation)) {
					enemy.setCurrentLocation(playerLocation);
					gridList.get(currentLocation).remove(enemy);
					gridList.get(playerLocation).add(enemy);
				}
				else {
					numberOfMoves = possibleMoves.size();
					randNumber = numGenerator.nextInt(numberOfMoves);
					newLocation = possibleMoves.get(randNumber);
					enemy.setCurrentLocation(newLocation);
					gridList.get(currentLocation).remove(enemy);
					gridList.get(newLocation).add(enemy);
				}
			}
			else {
				numberOfMoves = possibleMoves.size();
				randNumber = numGenerator.nextInt(numberOfMoves);
				newLocation = possibleMoves.get(randNumber);
				enemy.setCurrentLocation(newLocation);
				gridList.get(currentLocation).remove(enemy);
				gridList.get(newLocation).add(enemy);
			}
		}
		setGridList(gridList);
		setEnemies(enemies);
		return gridList;
	}
	
	public static ArrayList<ArrayList<Spaceship>> checkForEngagement(ArrayList<ArrayList<Spaceship>> gridList, Spaceship player) {
		int playerLocation = player.getCurrentLocation();
		int shipsRequiredToDestroyPlayer;
		if(isMasterShipOffensive()) {
			shipsRequiredToDestroyPlayer = 3;
		}
		else {
			shipsRequiredToDestroyPlayer = 2;
		}
		String output = "You have destroyed a ";
		Spaceship enemy;
		ArrayList<Spaceship> list = gridList.get(playerLocation);
		ArrayList<Spaceship> enemies = getEnemies();
		if(list.size() == shipsRequiredToDestroyPlayer) {
			for(int i = 0; i < list.size(); i++) {
				enemy = list.get(i);
				if(enemy != player) {
					enemy.setDestroyed(true);
					shipDestroyed();
					list.remove(enemy);
					enemies.remove(enemy);
					output += enemy.getShipType();
					JOptionPane.showMessageDialog(null, output, "Enemy Ship Destroyed", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			gridList.set(playerLocation, list);
			setGridList(gridList);
			setEnemies(enemies);
			return gridList;
		}
		else if(list.size() > shipsRequiredToDestroyPlayer) {
			player.setDestroyed(true);
			//list.remove(player);
			output = "Game Over";
			saveHighScore();
			JOptionPane.showMessageDialog(null, output, "You Lose " + usersName + "!", JOptionPane.INFORMATION_MESSAGE);
			RenderButtons.resetGrid();
			resetGame();
		}
		return gridList;
	}
	
	public static void resetGame() {
		for(int i = 0; i < gridList.size(); i++) {
			gridList.get(i).clear();
		}
		player = null;
		enemies.clear();
		setGameOver(true);
		setUsersGo(false);
		setShipsDestroyed(0);
		setMasterShipOffensive(false);
		setHardMode(false);
	}
	
	public static void goTaken() {
		goesTaken++;
	}
	
	public static void shipDestroyed() {
		shipsDestroyed++;
	}
	
	//**********************Getters and Setters*********************************************
	
	public static ArrayList<ArrayList<Spaceship>> getGridList() {
		return gridList;
	}

	public static int getGoesTaken() {
		return goesTaken;
	}

	public static void setGoesTaken(int goesTaken) {
		GameData.goesTaken = goesTaken;
	}

	public static String getUsersName() {
		return usersName;
	}

	public static void setUsersName(String usersName) {
		GameData.usersName = usersName;
	}

	public static boolean isHardMode() {
		return hardMode;
	}

	public static void setHardMode(boolean hardMode) {
		GameData.hardMode = hardMode;
	}

	public static int getShipsDestroyed() {
		return shipsDestroyed;
	}

	public static void setShipsDestroyed(int shipsDestroyed) {
		GameData.shipsDestroyed = shipsDestroyed;
	}

	public static boolean isMasterShipOffensive() {
		return masterShipOffensive;
	}

	public static void setMasterShipOffensive(boolean masterShipOffensive) {
		GameData.masterShipOffensive = masterShipOffensive;
	}

	public static void setGridList(ArrayList<ArrayList<Spaceship>> gridList) {
		GameData.gridList = gridList;
	}

	public static Spaceship getPlayer() {
		return player;
	}

	public static void setPlayer(Spaceship player) {
		GameData.player = player;
	}

	public static ArrayList<Spaceship> getEnemies() {
		return enemies;
	}

	public static void setEnemies(ArrayList<Spaceship> enemies) {
		GameData.enemies = enemies;
	}

	public static boolean isGameOver() {
		return gameOver;
	}

	public static void setGameOver(boolean gameOver) {
		GameData.gameOver = gameOver;
	}

	public static boolean isUsersGo() {
		return usersGo;
	}

	public static void setUsersGo(boolean usersGo) {
		GameData.usersGo = usersGo;
	}

	public static int getGridLength() {
		return GRID_LENGTH;
	}
	
	
	
}
