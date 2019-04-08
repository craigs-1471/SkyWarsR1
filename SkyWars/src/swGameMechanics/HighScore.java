package swGameMechanics;

import java.io.Serializable;

public class HighScore implements Serializable, Comparable<HighScore> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String usersName;
	private static int shipsDestroyed;
	private static int goesTaken;
	
	public HighScore(String usersName, int shipsDestroyed, int goesTaken) {
		setUsersName(usersName);
		setShipsDestroyed(shipsDestroyed);
		setGoesTaken(goesTaken);
	}
	
	@Override
	public int compareTo(HighScore o) {
		if(this.)
	}
	
	public String toString() {
		String output = "Name: " + getUsersName() + ", Ships Destroyed: " + getShipsDestroyed() + ", Goes Taken: " + getGoesTaken();
		return output;
	}

	public static String getUsersName() {
		return usersName;
	}

	public static void setUsersName(String usersName) {
		HighScore.usersName = usersName;
	}

	public static int getShipsDestroyed() {
		return shipsDestroyed;
	}

	public static void setShipsDestroyed(int shipsDestroyed) {
		HighScore.shipsDestroyed = shipsDestroyed;
	}

	public static int getGoesTaken() {
		return goesTaken;
	}

	public static void setGoesTaken(int goesTaken) {
		HighScore.goesTaken = goesTaken;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
