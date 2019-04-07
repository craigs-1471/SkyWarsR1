package swGameMechanics;

import java.util.ArrayList;
import java.util.Random;

import swShips.Spaceship;

public class GridList {
	
	public static ArrayList<ArrayList<Spaceship>> setGridList(ArrayList<ArrayList<Spaceship>> gridList) {
		ArrayList<Spaceship> button0List = new ArrayList<Spaceship>();
		ArrayList<Spaceship> button1List = new ArrayList<Spaceship>();
		ArrayList<Spaceship> button2List = new ArrayList<Spaceship>();
		ArrayList<Spaceship> button3List = new ArrayList<Spaceship>();
		ArrayList<Spaceship> button4List = new ArrayList<Spaceship>();
		ArrayList<Spaceship> button5List = new ArrayList<Spaceship>();
		ArrayList<Spaceship> button6List = new ArrayList<Spaceship>();
		ArrayList<Spaceship> button7List = new ArrayList<Spaceship>();
		ArrayList<Spaceship> button8List = new ArrayList<Spaceship>();
		ArrayList<Spaceship> button9List = new ArrayList<Spaceship>();
		ArrayList<Spaceship> button10List = new ArrayList<Spaceship>();
		ArrayList<Spaceship> button11List = new ArrayList<Spaceship>();
		ArrayList<Spaceship> button12List = new ArrayList<Spaceship>();
		ArrayList<Spaceship> button13List = new ArrayList<Spaceship>();
		ArrayList<Spaceship> button14List = new ArrayList<Spaceship>();
		ArrayList<Spaceship> button15List = new ArrayList<Spaceship>();
		
		gridList.add(button0List);
		gridList.add(button1List);
		gridList.add(button2List);
		gridList.add(button3List);
		gridList.add(button4List);
		gridList.add(button5List);
		gridList.add(button6List);
		gridList.add(button7List);
		gridList.add(button8List);
		gridList.add(button9List);
		gridList.add(button10List);
		gridList.add(button11List);
		gridList.add(button12List);
		gridList.add(button13List);
		gridList.add(button14List);
		gridList.add(button15List);
		return gridList;
	}
	
	public static ArrayList<ArrayList<Spaceship>> initialPlayerListLocation(Spaceship player, ArrayList<ArrayList<Spaceship>> gridList, int gridLength) {
		Random numGenerator = new Random();
		int randLocation = numGenerator.nextInt(gridLength);
		gridList.get(randLocation).add(player);
		player.setCurrentLocation(randLocation);
		return gridList;
	}
	
}
