package swShips;

import java.util.ArrayList;

public class BattleStar extends Spaceship {
	
	public BattleStar() {
		setCurrentLocation(0);
	}
	
	public BattleStar(ArrayList<Spaceship> enemies) {
		setCurrentLocation(0);
		enemies.add(this);
	}
	
}
