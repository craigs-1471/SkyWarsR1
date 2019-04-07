package swInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import swGameMechanics.GameData;
import swGameMechanics.PossibleMoves;
import swShips.Spaceship;

public class GameButton extends JButton implements ActionListener {
	
	private ImageIcon masterShip, battleStar, battleCruiser, battleShooter;
	private int btnIndex;
	private ArrayList<Integer> possibleMoves;
	private boolean movePossible;
	
	public GameButton(int index, ArrayList<Integer> moves) {
		masterShip = new ImageIcon(this.getClass().getResource("/swResources/masterShip100.png"));
		battleStar = new ImageIcon(this.getClass().getResource("/swResources/battleStar100.png"));
		battleShooter = new ImageIcon(this.getClass().getResource("/swResources/battleShooter100.png"));
		battleCruiser = new ImageIcon(this.getClass().getResource("/swResources/battleCruiser100.png"));
		setBtnIndex(index);
		setPossibleMoves(moves);
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("******************Button Clicked***************************");
		Spaceship player = GameData.getPlayer();
		int currentLocation = player.getCurrentLocation();
		System.out.println("GB 1. Current Location " + currentLocation);
		movePossible = PossibleMoves.isMovePossible(currentLocation, possibleMoves);
		boolean usersGo = GameData.isUsersGo();
		boolean gameOver = GameData.isGameOver();
		if(usersGo && movePossible && !gameOver) {
			GameData.setUsersGo(false);
			ArrayList<ArrayList<Spaceship>> gridList = GameData.getGridList();
			ArrayList<Spaceship> enemies = GameData.getEnemies();
			System.out.println("GB 2. Total enemy size " + enemies.size());
			System.out.println("GB 3. Currernt location-list size pre-change " + gridList.get(currentLocation).size());
			gridList.get(currentLocation).remove(player);
			System.out.println("GB 4. Currernt location-list size post-change " + gridList.get(currentLocation).size());
			System.out.println("GB 5. New location-list size pre-change " + gridList.get(btnIndex).size());
			gridList.get(btnIndex).add(player);
			System.out.println("GB 6. New location-list size post-change " + gridList.get(btnIndex).size());
			player.setCurrentLocation(btnIndex);
			System.out.println("GB 7. Player Change location " + player.getCurrentLocation());
			GameData.setPlayer(player);
			GameData.setGridList(gridList);
			gridList = GameData.checkForEngagement(gridList, player);
			System.out.println("GB 8. Post check for engagement 1");
			RenderButtons.mapButtonGridList(gridList);
			System.out.println("GB 9. Post Buttons rendered 1");
			gridList = GameData.moveEnemies(gridList, enemies);
			System.out.println("GB 10. post move enemies");
			gridList = GameData.checkForEngagement(gridList, player);
			System.out.println("GB 11. Post check for engagement 2");
			RenderButtons.mapButtonGridList(gridList);
			System.out.println("GB 12. Post buttons rendered 2");
			gridList = GameData.randomEnemyShip(gridList);
			System.out.println("GB 13. Post random ship");
			gridList = GameData.checkForEngagement(gridList, player);
			System.out.println("GB 14. Post check for engagement 3");
			RenderButtons.mapButtonGridList(gridList);
			System.out.println("GB 15. Post buttons rendered 3");
			GameData.setPlayer(player);
			GameData.setGridList(gridList);
			System.out.println("GB 16. Ste gridList and player");
			GameData.setUsersGo(true);
		}
		
	}
	
	//**********************Getters and Setters*********************************************
	
	public void setBackgroundMasterShip() {
		setIcon(masterShip);
	}
	public void setBackgroundBattleStar() {
		setIcon(battleStar);
	}
	public void setBackgroundBattleCruiser() {
		setIcon(battleCruiser);
	}
	public void setBackgroundBattleShooter() {
		setIcon(battleShooter);
	}
	public void setBackgroundNull() {
		setIcon(null);
	}
	public ImageIcon getMasterShip() {
		return masterShip;
	}

	public void setMasterShip(ImageIcon masterShip) {
		this.masterShip = masterShip;
	}

	public ImageIcon getBattleStar() {
		return battleStar;
	}

	public void setBattleStar(ImageIcon battleStar) {
		this.battleStar = battleStar;
	}

	public ImageIcon getBattleCruiser() {
		return battleCruiser;
	}

	public void setBattleCruiser(ImageIcon battleCruiser) {
		this.battleCruiser = battleCruiser;
	}

	public ImageIcon getBattleShooter() {
		return battleShooter;
	}

	public void setBattleShooter(ImageIcon battleShooter) {
		this.battleShooter = battleShooter;
	}

	public int getBtnIndex() {
		return btnIndex;
	}

	public void setBtnIndex(int btnIndex) {
		this.btnIndex = btnIndex;
	}

	public ArrayList<Integer> getPossibleMoves() {
		return possibleMoves;
	}

	public void setPossibleMoves(ArrayList<Integer> possibleMoves) {
		this.possibleMoves = possibleMoves;
	}

	public boolean isMovePossible() {
		return movePossible;
	}

	public void setMovePossible(boolean movePossible) {
		this.movePossible = movePossible;
	}
}
