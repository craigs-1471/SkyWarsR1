package swShips;

import java.util.ArrayList;

public class BattleShooter extends Spaceship {
	
	public BattleShooter() {
		setCurrentLocation(0);
	}
	
	public BattleShooter(ArrayList<Spaceship> enemies) {
		setCurrentLocation(0);
		enemies.add(this);
	}
}
