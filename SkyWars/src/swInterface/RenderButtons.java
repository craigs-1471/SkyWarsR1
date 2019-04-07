package swInterface;

import java.util.ArrayList;

import swShips.BattleCruiser;
import swShips.BattleShooter;
import swShips.BattleStar;
import swShips.MasterShip;
import swShips.Spaceship;

public class RenderButtons {
	
	
	
	public static void mapButtonGridList(ArrayList<ArrayList<Spaceship>> gridList) {
		GameButton btnGameButton0 = MainApp.getBtnGameButton0();
		GameButton btnGameButton1 = MainApp.getBtnGameButton1();
		GameButton btnGameButton2 = MainApp.getBtnGameButton2();
		GameButton btnGameButton3 = MainApp.getBtnGameButton3();
		GameButton btnGameButton4 = MainApp.getBtnGameButton4();
		GameButton btnGameButton5 = MainApp.getBtnGameButton5();
		GameButton btnGameButton6 = MainApp.getBtnGameButton6();
		GameButton btnGameButton7 = MainApp.getBtnGameButton7();
		GameButton btnGameButton8 = MainApp.getBtnGameButton8();
		GameButton btnGameButton9 = MainApp.getBtnGameButton9();
		GameButton btnGameButton10 = MainApp.getBtnGameButton10();
		GameButton btnGameButton11 = MainApp.getBtnGameButton11();
		GameButton btnGameButton12 = MainApp.getBtnGameButton12();
		GameButton btnGameButton13 = MainApp.getBtnGameButton13();
		GameButton btnGameButton14 = MainApp.getBtnGameButton14();
		GameButton btnGameButton15 = MainApp.getBtnGameButton15();
		
		if(!gridList.get(0).isEmpty()) {
			if(checkForInstanceOfPlayer(gridList.get(0))) {
				btnGameButton0.setBackgroundMasterShip();
			}
			else if(checkForInstanceOfBattleStar(gridList.get(0))) {
				btnGameButton0.setBackgroundBattleStar();
			}
			else if(checkForInstanceOfBattleCruiser(gridList.get(0))) {
				btnGameButton0.setBackgroundBattleCruiser();
			}	
			else if(checkForInstanceOfBattleShooter(gridList.get(0))) {
				btnGameButton0.setBackgroundBattleShooter();
			}	
		}
		else {
			btnGameButton0.setBackgroundNull();
		}
		if(!gridList.get(1).isEmpty()) {
			if(checkForInstanceOfPlayer(gridList.get(1))) {
				btnGameButton1.setBackgroundMasterShip();
			}
			else if(checkForInstanceOfBattleStar(gridList.get(1))) {
				btnGameButton1.setBackgroundBattleStar();
			}
			else if(checkForInstanceOfBattleCruiser(gridList.get(1))) {
				btnGameButton1.setBackgroundBattleCruiser();
			}	
			else if(checkForInstanceOfBattleShooter(gridList.get(1))) {
				btnGameButton1.setBackgroundBattleShooter();
			}	
		}
		else {
			btnGameButton1.setBackgroundNull();
		}
		if(!gridList.get(2).isEmpty()) {
			if(checkForInstanceOfPlayer(gridList.get(2))) {
				btnGameButton2.setBackgroundMasterShip();
			}
			else if(checkForInstanceOfBattleStar(gridList.get(2))) {
				btnGameButton2.setBackgroundBattleStar();
			}
			else if(checkForInstanceOfBattleCruiser(gridList.get(2))) {
				btnGameButton2.setBackgroundBattleCruiser();
			}	
			else if(checkForInstanceOfBattleShooter(gridList.get(2))) {
				btnGameButton2.setBackgroundBattleShooter();
			}	
		}
		else {
			btnGameButton2.setBackgroundNull();
		}
		if(!gridList.get(3).isEmpty()) {
			if(checkForInstanceOfPlayer(gridList.get(3))) {
				btnGameButton3.setBackgroundMasterShip();
			}
			else if(checkForInstanceOfBattleStar(gridList.get(3))) {
				btnGameButton3.setBackgroundBattleStar();
			}
			else if(checkForInstanceOfBattleCruiser(gridList.get(3))) {
				btnGameButton3.setBackgroundBattleCruiser();
			}	
			else if(checkForInstanceOfBattleShooter(gridList.get(3))) {
				btnGameButton3.setBackgroundBattleShooter();
			}	
		}
		else {
			btnGameButton3.setBackgroundNull();
		}
		if(!gridList.get(4).isEmpty()) {
			if(checkForInstanceOfPlayer(gridList.get(4))) {
				btnGameButton4.setBackgroundMasterShip();
			}
			else if(checkForInstanceOfBattleStar(gridList.get(4))) {
				btnGameButton4.setBackgroundBattleStar();
			}
			else if(checkForInstanceOfBattleCruiser(gridList.get(4))) {
				btnGameButton4.setBackgroundBattleCruiser();
			}	
			else if(checkForInstanceOfBattleShooter(gridList.get(4))) {
				btnGameButton4.setBackgroundBattleShooter();
			}	
		}
		else {
			btnGameButton4.setBackgroundNull();
		}
		if(!gridList.get(5).isEmpty()) {
			if(checkForInstanceOfPlayer(gridList.get(5))) {
				btnGameButton5.setBackgroundMasterShip();
			}
			else if(checkForInstanceOfBattleStar(gridList.get(5))) {
				btnGameButton5.setBackgroundBattleStar();
			}
			else if(checkForInstanceOfBattleCruiser(gridList.get(5))) {
				btnGameButton5.setBackgroundBattleCruiser();
			}	
			else if(checkForInstanceOfBattleShooter(gridList.get(5))) {
				btnGameButton5.setBackgroundBattleShooter();
			}	
		}
		else {
			btnGameButton5.setBackgroundNull();
		}
		if(!gridList.get(6).isEmpty()) {
			if(checkForInstanceOfPlayer(gridList.get(6))) {
				btnGameButton6.setBackgroundMasterShip();
			}
			else if(checkForInstanceOfBattleStar(gridList.get(6))) {
				btnGameButton6.setBackgroundBattleStar();
			}
			else if(checkForInstanceOfBattleCruiser(gridList.get(6))) {
				btnGameButton6.setBackgroundBattleCruiser();
			}	
			else if(checkForInstanceOfBattleShooter(gridList.get(6))) {
				btnGameButton6.setBackgroundBattleShooter();
			}	
		}
		else {
			btnGameButton6.setBackgroundNull();
		}
		if(!gridList.get(7).isEmpty()) {
			if(checkForInstanceOfPlayer(gridList.get(7))) {
				btnGameButton7.setBackgroundMasterShip();
			}
			else if(checkForInstanceOfBattleStar(gridList.get(7))) {
				btnGameButton7.setBackgroundBattleStar();
			}
			else if(checkForInstanceOfBattleCruiser(gridList.get(7))) {
				btnGameButton7.setBackgroundBattleCruiser();
			}	
			else if(checkForInstanceOfBattleShooter(gridList.get(7))) {
				btnGameButton7.setBackgroundBattleShooter();
			}	
		}
		else {
			btnGameButton7.setBackgroundNull();
		}
		if(!gridList.get(8).isEmpty()) {
			if(checkForInstanceOfPlayer(gridList.get(8))) {
				btnGameButton8.setBackgroundMasterShip();
			}
			else if(checkForInstanceOfBattleStar(gridList.get(8))) {
				btnGameButton8.setBackgroundBattleStar();
			}
			else if(checkForInstanceOfBattleCruiser(gridList.get(8))) {
				btnGameButton8.setBackgroundBattleCruiser();
			}	
			else if(checkForInstanceOfBattleShooter(gridList.get(8))) {
				btnGameButton8.setBackgroundBattleShooter();
			}	
		}
		else {
			btnGameButton8.setBackgroundNull();
		}
		if(!gridList.get(9).isEmpty()) {
			if(checkForInstanceOfPlayer(gridList.get(9))) {
				btnGameButton9.setBackgroundMasterShip();
			}
			else if(checkForInstanceOfBattleStar(gridList.get(9))) {
				btnGameButton9.setBackgroundBattleStar();
			}
			else if(checkForInstanceOfBattleCruiser(gridList.get(9))) {
				btnGameButton9.setBackgroundBattleCruiser();
			}	
			else if(checkForInstanceOfBattleShooter(gridList.get(9))) {
				btnGameButton9.setBackgroundBattleShooter();
			}	
		}
		else {
			btnGameButton9.setBackgroundNull();
		}
		if(!gridList.get(10).isEmpty()) {
			if(checkForInstanceOfPlayer(gridList.get(10))) {
				btnGameButton10.setBackgroundMasterShip();
			}
			else if(checkForInstanceOfBattleStar(gridList.get(10))) {
				btnGameButton10.setBackgroundBattleStar();
			}
			else if(checkForInstanceOfBattleCruiser(gridList.get(10))) {
				btnGameButton10.setBackgroundBattleCruiser();
			}	
			else if(checkForInstanceOfBattleShooter(gridList.get(10))) {
				btnGameButton10.setBackgroundBattleShooter();
			}	
		}
		else {
			btnGameButton10.setBackgroundNull();
		}
		if(!gridList.get(11).isEmpty()) {
			if(checkForInstanceOfPlayer(gridList.get(11))) {
				btnGameButton11.setBackgroundMasterShip();
			}
			else if(checkForInstanceOfBattleStar(gridList.get(11))) {
				btnGameButton11.setBackgroundBattleStar();
			}
			else if(checkForInstanceOfBattleCruiser(gridList.get(11))) {
				btnGameButton11.setBackgroundBattleCruiser();
			}	
			else if(checkForInstanceOfBattleShooter(gridList.get(11))) {
				btnGameButton11.setBackgroundBattleShooter();
			}	
		}
		else {
			btnGameButton11.setBackgroundNull();
		}
		if(!gridList.get(12).isEmpty()) {
			if(checkForInstanceOfPlayer(gridList.get(12))) {
				btnGameButton12.setBackgroundMasterShip();
			}
			else if(checkForInstanceOfBattleStar(gridList.get(12))) {
				btnGameButton12.setBackgroundBattleStar();
			}
			else if(checkForInstanceOfBattleCruiser(gridList.get(12))) {
				btnGameButton12.setBackgroundBattleCruiser();
			}	
			else if(checkForInstanceOfBattleShooter(gridList.get(12))) {
				btnGameButton12.setBackgroundBattleShooter();
			}	
		}
		else {
			btnGameButton12.setBackgroundNull();
		}
		if(!gridList.get(13).isEmpty()) {
			if(checkForInstanceOfPlayer(gridList.get(13))) {
				btnGameButton13.setBackgroundMasterShip();
			}
			else if(checkForInstanceOfBattleStar(gridList.get(13))) {
				btnGameButton13.setBackgroundBattleStar();
			}
			else if(checkForInstanceOfBattleCruiser(gridList.get(13))) {
				btnGameButton13.setBackgroundBattleCruiser();
			}	
			else if(checkForInstanceOfBattleShooter(gridList.get(13))) {
				btnGameButton13.setBackgroundBattleShooter();
			}	
		}
		else {
			btnGameButton13.setBackgroundNull();
		}
		if(!gridList.get(14).isEmpty()) {
			if(checkForInstanceOfPlayer(gridList.get(14))) {
				btnGameButton14.setBackgroundMasterShip();
			}
			else if(checkForInstanceOfBattleStar(gridList.get(14))) {
				btnGameButton14.setBackgroundBattleStar();
			}
			else if(checkForInstanceOfBattleCruiser(gridList.get(14))) {
				btnGameButton14.setBackgroundBattleCruiser();
			}	
			else if(checkForInstanceOfBattleShooter(gridList.get(14))) {
				btnGameButton14.setBackgroundBattleShooter();
			}	
		}
		else {
			btnGameButton14.setBackgroundNull();
		}
		if(!gridList.get(15).isEmpty()) {
			if(checkForInstanceOfPlayer(gridList.get(15))) {
				btnGameButton15.setBackgroundMasterShip();
			}
			else if(checkForInstanceOfBattleStar(gridList.get(15))) {
				btnGameButton15.setBackgroundBattleStar();
			}
			else if(checkForInstanceOfBattleCruiser(gridList.get(15))) {
				btnGameButton15.setBackgroundBattleCruiser();
			}	
			else if(checkForInstanceOfBattleShooter(gridList.get(15))) {
				btnGameButton15.setBackgroundBattleShooter();
			}	
		}
		else {
			btnGameButton15.setBackgroundNull();
		}
	}
	
	public static void resetGrid() {
		GameButton btnGameButton0 = MainApp.getBtnGameButton0();
		GameButton btnGameButton1 = MainApp.getBtnGameButton1();
		GameButton btnGameButton2 = MainApp.getBtnGameButton2();
		GameButton btnGameButton3 = MainApp.getBtnGameButton3();
		GameButton btnGameButton4 = MainApp.getBtnGameButton4();
		GameButton btnGameButton5 = MainApp.getBtnGameButton5();
		GameButton btnGameButton6 = MainApp.getBtnGameButton6();
		GameButton btnGameButton7 = MainApp.getBtnGameButton7();
		GameButton btnGameButton8 = MainApp.getBtnGameButton8();
		GameButton btnGameButton9 = MainApp.getBtnGameButton9();
		GameButton btnGameButton10 = MainApp.getBtnGameButton10();
		GameButton btnGameButton11 = MainApp.getBtnGameButton11();
		GameButton btnGameButton12 = MainApp.getBtnGameButton12();
		GameButton btnGameButton13 = MainApp.getBtnGameButton13();
		GameButton btnGameButton14 = MainApp.getBtnGameButton14();
		GameButton btnGameButton15 = MainApp.getBtnGameButton15();
		
		btnGameButton0.setBackgroundNull();
		btnGameButton1.setBackgroundNull();
		btnGameButton2.setBackgroundNull();
		btnGameButton3.setBackgroundNull();
		btnGameButton4.setBackgroundNull();
		btnGameButton5.setBackgroundNull();
		btnGameButton6.setBackgroundNull();
		btnGameButton7.setBackgroundNull();
		btnGameButton8.setBackgroundNull();
		btnGameButton9.setBackgroundNull();
		btnGameButton10.setBackgroundNull();
		btnGameButton11.setBackgroundNull();
		btnGameButton12.setBackgroundNull();
		btnGameButton13.setBackgroundNull();
		btnGameButton14.setBackgroundNull();
		btnGameButton15.setBackgroundNull();
	}
	
	public static boolean checkForInstanceOfPlayer(ArrayList<Spaceship> list) {
		 for (Spaceship s : list) {
		        if (s instanceof MasterShip) {
		            return true;
		        }
		    }
		    return false;
	}
	
	public static boolean checkForInstanceOfBattleStar(ArrayList<Spaceship> list) {
		 for (Spaceship s : list) {
		        if (s instanceof BattleStar) {
		            return true;
		        }
		    }
		    return false;
	}
	public static boolean checkForInstanceOfBattleShooter(ArrayList<Spaceship> list) {
		 for (Spaceship s : list) {
		        if (s instanceof BattleShooter) {
		            return true;
		        }
		    }
		    return false;
	}
	public static boolean checkForInstanceOfBattleCruiser(ArrayList<Spaceship> list) {
		 for (Spaceship s : list) {
		        if (s instanceof BattleCruiser) {
		            return true;
		        }
		    }
		    return false;
	}
	
}
