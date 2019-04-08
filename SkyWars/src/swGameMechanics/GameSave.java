package swGameMechanics;

import java.io.Serializable;
import java.util.ArrayList;

import swShips.Spaceship;

public class GameSave implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ArrayList<ArrayList<Spaceship>> gridList;
	private static Spaceship player;
	private static String usersName;
	private static ArrayList<Spaceship> enemies;
	private static boolean gameOver;
	private static boolean usersGo;
	private static int shipsDestroyed;
	private static int goesTaken;
	private static boolean masterShipOffensive;
	private static boolean hardMode;
	
	public GameSave(ArrayList<ArrayList<Spaceship>> gridList, Spaceship player, String usersName, ArrayList<Spaceship> enemies, boolean gameOver, boolean usersGo, int shipsDestroyed, int GoesTaken, boolean masterShipOffensive, boolean hardMode) {
		setGridList(gridList);
		setPlayer(player);
		setUsersName(usersName);
		setEnemies(enemies);
		setGameOver(gameOver);
		setUsersGo(usersGo);
		setShipsDestroyed(shipsDestroyed);
		setGoesTaken(GoesTaken);
		setMasterShipOffensive(masterShipOffensive);
		setHardMode(hardMode);
	}
	
	public static String getUsersName() {
		return usersName;
	}

	public static void setUsersName(String usersName) {
		GameSave.usersName = usersName;
	}

	public static int getGoesTaken() {
		return goesTaken;
	}

	public static void setGoesTaken(int goesTaken) {
		GameSave.goesTaken = goesTaken;
	}

	public static ArrayList<ArrayList<Spaceship>> getGridList() {
		return gridList;
	}

	public static void setGridList(ArrayList<ArrayList<Spaceship>> gridList) {
		GameSave.gridList = gridList;
	}

	public static Spaceship getPlayer() {
		return player;
	}

	public static void setPlayer(Spaceship player) {
		GameSave.player = player;
	}

	public static ArrayList<Spaceship> getEnemies() {
		return enemies;
	}

	public static void setEnemies(ArrayList<Spaceship> enemies) {
		GameSave.enemies = enemies;
	}

	public static boolean isGameOver() {
		return gameOver;
	}

	public static void setGameOver(boolean gameOver) {
		GameSave.gameOver = gameOver;
	}

	public static boolean isUsersGo() {
		return usersGo;
	}

	public static void setUsersGo(boolean usersGo) {
		GameSave.usersGo = usersGo;
	}

	public static int getShipsDestroyed() {
		return shipsDestroyed;
	}

	public static void setShipsDestroyed(int shipsDestroyed) {
		GameSave.shipsDestroyed = shipsDestroyed;
	}

	public static boolean isMasterShipOffensive() {
		return masterShipOffensive;
	}

	public static void setMasterShipOffensive(boolean masterShipOffensive) {
		GameSave.masterShipOffensive = masterShipOffensive;
	}

	public static boolean isHardMode() {
		return hardMode;
	}

	public static void setHardMode(boolean hardMode) {
		GameSave.hardMode = hardMode;
	}
	
}
