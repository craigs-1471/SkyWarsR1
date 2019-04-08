package swGameMechanics;

import java.io.Serializable;
import java.util.ArrayList;

public class HighScores implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<HighScore> highScores;
	
	public HighScores(HighScore currentGame) {
		highScores = new ArrayList<HighScore>();
		highScores.add(currentGame);
		setHighScores(highScores);
	}

	public ArrayList<HighScore> getHighScores() {
		return highScores;
	}

	public void setHighScores(ArrayList<HighScore> highScores) {
		this.highScores = highScores;
	}
	
}
