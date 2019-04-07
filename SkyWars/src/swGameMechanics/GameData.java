package swGameMechanics;

import java.util.ArrayList;
import java.util.Random;

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
	
	public static void playGame() {
		gridList = new ArrayList<ArrayList<Spaceship>>(GRID_LENGTH);
		gridList = GridList.setGridList(gridList);
		player = new MasterShip();
		gridList = GridList.initialPlayerListLocation(player, gridList, GRID_LENGTH);
		enemies = new ArrayList<Spaceship>();
		gameOver = false;
		usersGo = true;
		RenderButtons.mapButtonGridList(gridList);
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
	
	public static ArrayList<ArrayList<Spaceship>> checkForEngagement(ArrayList<ArrayList<Spaceship>> gridList, Spaceship player) {
		int playerLocation = player.getCurrentLocation();
		ArrayList<Spaceship> list = gridList.get(playerLocation);
		if(list.size() == 2) {
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i) != player) {
					list.get(i).setDestroyed(true);
					list.remove(i);
				}
			}
		}
		else if(list.size() > 2) {
			player.setDestroyed(true);
			list.remove(player);
			RenderButtons.resetGrid();
		}
		gridList.set(playerLocation, list);
		setGridList(gridList);
		return gridList;
	}
	
	//**********************Getters and Setters*********************************************
	
	public static ArrayList<ArrayList<Spaceship>> getGridList() {
		return gridList;
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
