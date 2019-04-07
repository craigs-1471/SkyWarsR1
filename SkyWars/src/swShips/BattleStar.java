package swShips;

import java.io.Serializable;
import java.util.ArrayList;

public class BattleStar extends Spaceship implements Serializable {
	
	public BattleStar() {
		setCurrentLocation(0);
		setShipType("Battle Star");
	}
	
	public BattleStar(ArrayList<Spaceship> enemies) {
		setCurrentLocation(0);
		enemies.add(this);
		setShipType("Battle Star");
	}
}
