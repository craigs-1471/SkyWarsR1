package swInterface;

import java.awt.Color;
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
		setBackground(Color.black);
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
		setFocusPainted(false);
		Spaceship player = GameData.getPlayer();
		int currentLocation = player.getCurrentLocation();
		movePossible = PossibleMoves.isMovePossible(currentLocation, possibleMoves);
		boolean usersGo = GameData.isUsersGo();
		boolean gameOver = GameData.isGameOver();
		if(usersGo && movePossible && !gameOver) {
			GameData.goTaken();
			GameData.setUsersGo(false);
			ArrayList<ArrayList<Spaceship>> gridList = GameData.getGridList();
			ArrayList<Spaceship> enemies = GameData.getEnemies();
			gridList.get(currentLocation).remove(player);
			gridList.get(btnIndex).add(player);
			player.setCurrentLocation(btnIndex);
			GameData.setPlayer(player);
			GameData.setGridList(gridList);
			gridList = GameData.checkForEngagement(gridList, player);
			RenderButtons.mapButtonGridList(gridList);
			gridList = GameData.moveEnemies(gridList, enemies, player);
			gridList = GameData.checkForEngagement(gridList, player);
			RenderButtons.mapButtonGridList(gridList);
			gridList = GameData.randomEnemyShip(gridList);
			gridList = GameData.checkForEngagement(gridList, player);
			RenderButtons.mapButtonGridList(gridList);
			GameData.setPlayer(player);
			GameData.setGridList(gridList);
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
