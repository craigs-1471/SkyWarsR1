package swGameMechanics;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

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
		System.out.println("******************Random Enemy Ship?********************************");
		int possibleEnemy = 3; // i.e. one in three chance of spawning enemy
		Random numGenerator = new Random();
		int randNumber = numGenerator.nextInt(possibleEnemy);
		if(randNumber == 0)
			gridList = spawnEnemyShip(gridList);
		return gridList;
	}
	
	public static ArrayList<ArrayList<Spaceship>> spawnEnemyShip(ArrayList<ArrayList<Spaceship>> gridList) {
		System.out.println("***********************Spawn Enemy Ship*********************************");
		int typesOfShip = 3; 
		Random numGenerator = new Random();
		int randNumber = numGenerator.nextInt(typesOfShip);
		if(randNumber == 0) {
			gridList.get(0).add(new BattleStar(enemies));
			System.out.println("BattleStar spawned");
		}
		else if(randNumber == 1) {
			gridList.get(0).add(new BattleCruiser(enemies));
			System.out.println("BattleCruiser spawned");
		}
		else if(randNumber == 2) {
			gridList.get(0).add(new BattleShooter(enemies));
			System.out.println("BattleShooter spawned");
		}
		System.out.println("**End spawn enemy ship**");
		return gridList;
	}
	
	public static ArrayList<ArrayList<Spaceship>> moveEnemies(ArrayList<ArrayList<Spaceship>> gridList, ArrayList<Spaceship> enemies) {
		System.out.println("*******************Move Enemies****************************");
		Spaceship enemy;
		int currentLocation, numberOfMoves, newLocation, randNumber;
		Random numGenerator = new Random();
		for(int i = 0; i < enemies.size(); i++) {
			System.out.println("***Enemy loop " + i + "***");
			enemy = enemies.get(i);
			currentLocation = enemy.getCurrentLocation();
			System.out.println("Enemy " + i + " current location " + currentLocation);
			ArrayList<Integer> possibleMoves = PossibleMoves.getPossibleMoves(currentLocation);
			numberOfMoves = possibleMoves.size();
			randNumber = numGenerator.nextInt(numberOfMoves);
			newLocation = possibleMoves.get(randNumber);
			enemy.setCurrentLocation(newLocation);
			System.out.println("Enemy " + i + " new location " + enemy.getCurrentLocation());
			System.out.println("list size at current location pre-remove " + gridList.get(currentLocation).size());
			gridList.get(currentLocation).remove(enemy);
			System.out.println("list size at current location post-remove " + gridList.get(currentLocation).size());
			System.out.println("list size at new location pre-add " + gridList.get(newLocation).size());
			gridList.get(newLocation).add(enemy);
			System.out.println("list size at new location post-add " + gridList.get(newLocation).size());
		}
		setGridList(gridList);
		setEnemies(enemies);
		System.out.println("**End move enemies**");
		return gridList;
	}
	
	public static ArrayList<ArrayList<Spaceship>> checkForEngagement(ArrayList<ArrayList<Spaceship>> gridList, Spaceship player) {
		//System.out.println("******************Check for Engagement**********************************");
		int playerLocation = player.getCurrentLocation();
		String output = "You have destroyed a ";
		Spaceship enemy;
		//System.out.println("Player current location " + playerLocation);
		ArrayList<Spaceship> list = gridList.get(playerLocation);
		ArrayList<Spaceship> enemies = getEnemies();
		if(list.size() == 2) {
			//System.out.println("Size = 2 if entered");
			for(int i = 0; i < list.size(); i++) {
				enemy = list.get(i);
				//System.out.println("loop " + i + " started");
				if(enemy != player) {
					//System.out.println("Not player if started");
					enemy.setDestroyed(true);
					//System.out.println("List size before removal " + list.size());
					list.remove(enemy);
					enemies.remove(enemy);
					output += enemy.getShipType();
					JOptionPane.showMessageDialog(null, output, "Enemy Ship Destroyed", JOptionPane.INFORMATION_MESSAGE);
					//System.out.println("List size after removal " + list.size());
				}
			}
		}
		else if(list.size() > 2) {
			//System.out.println("Size > 2 if started");
			player.setDestroyed(true);
			//System.out.println("list size pre-player removal " + list.size());
			list.remove(player);
			//System.out.println("list size post-player removal " + list.size());
			RenderButtons.resetGrid();
			//System.out.println("Buttons reset");
		}
		gridList.set(playerLocation, list);
		System.out.println("List added to grid list");
		setGridList(gridList);
		setEnemies(enemies);
		System.out.println("GridList set");
		System.out.println("***End check for engagement***");
		return gridList;
	}
	
	public static void resetGame() {
		
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
