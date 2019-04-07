package swShips;

import java.io.Serializable;
import java.util.ArrayList;

public class BattleShooter extends Spaceship implements Serializable {
	
	public BattleShooter() {
		setCurrentLocation(0);
		setShipType("Battle Shooter");
	}
	
	public BattleShooter(ArrayList<Spaceship> enemies) {
		setCurrentLocation(0);
		enemies.add(this);
		setShipType("Battle Shooter");
	}
}
