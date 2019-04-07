package swShips;

import java.util.ArrayList;

public class BattleCruiser extends Spaceship {
	
	public BattleCruiser() {
		setCurrentLocation(0);
	}
	
	public BattleCruiser(ArrayList<Spaceship> enemies) {
		setCurrentLocation(0);
		enemies.add(this);
	}
	
}
