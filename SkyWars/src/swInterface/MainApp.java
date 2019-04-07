package swInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import swGameMechanics.GameData;
import swGameMechanics.PossibleMoves;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class MainApp {

	private JFrame frame;
	private static GameButton btnGameButton0;
	private static GameButton btnGameButton1;
	private static GameButton btnGameButton2;
	private static GameButton btnGameButton3;
	private static GameButton btnGameButton4;
	private static GameButton btnGameButton5;
	private static GameButton btnGameButton6;
	private static GameButton btnGameButton7;
	private static GameButton btnGameButton8;
	private static GameButton btnGameButton9;
	private static GameButton btnGameButton10;
	private static GameButton btnGameButton11;
	private static GameButton btnGameButton12;
	private static GameButton btnGameButton13;
	private static GameButton btnGameButton14;
	private static GameButton btnGameButton15;
	private static JButton btnNewGame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 689, 552);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pnlButtonPanel = new JPanel();
		pnlButtonPanel.setBounds(12, 13, 647, 375);
		frame.getContentPane().add(pnlButtonPanel);
		pnlButtonPanel.setLayout(new GridLayout(4, 4, 0, 0));
		
		btnGameButton0 = new GameButton(0, PossibleMoves.getBtn0Moves());
		pnlButtonPanel.add(btnGameButton0);
		
		btnGameButton1 = new GameButton(1, PossibleMoves.getBtn1Moves());
		pnlButtonPanel.add(btnGameButton1);
		
		btnGameButton2 = new GameButton(2, PossibleMoves.getBtn2Moves());
		pnlButtonPanel.add(btnGameButton2);
		
		btnGameButton3 = new GameButton(3, PossibleMoves.getBtn3Moves());
		pnlButtonPanel.add(btnGameButton3);
		
		btnGameButton4 = new GameButton(4, PossibleMoves.getBtn4Moves());
		pnlButtonPanel.add(btnGameButton4);
		
		btnGameButton5 = new GameButton(5, PossibleMoves.getBtn5Moves());
		pnlButtonPanel.add(btnGameButton5);
		
		btnGameButton6 = new GameButton(6, PossibleMoves.getBtn6Moves());
		pnlButtonPanel.add(btnGameButton6);
		
		btnGameButton7 = new GameButton(7, PossibleMoves.getBtn7Moves());
		pnlButtonPanel.add(btnGameButton7);
		
		btnGameButton8 = new GameButton(8, PossibleMoves.getBtn8Moves());
		pnlButtonPanel.add(btnGameButton8);
		
		btnGameButton9 = new GameButton(9, PossibleMoves.getBtn9Moves());
		pnlButtonPanel.add(btnGameButton9);
		
		btnGameButton10 = new GameButton(10, PossibleMoves.getBtn10Moves());
		pnlButtonPanel.add(btnGameButton10);
		
		btnGameButton11 = new GameButton(11, PossibleMoves.getBtn11Moves());
		pnlButtonPanel.add(btnGameButton11);
		
		btnGameButton12 = new GameButton(12, PossibleMoves.getBtn12Moves());
		pnlButtonPanel.add(btnGameButton12);
		
		btnGameButton13 = new GameButton(13, PossibleMoves.getBtn13Moves());
		pnlButtonPanel.add(btnGameButton13);
		
		btnGameButton14 = new GameButton(14, PossibleMoves.getBtn14Moves());
		pnlButtonPanel.add(btnGameButton14);
		
		btnGameButton15 = new GameButton(15, PossibleMoves.getBtn15Moves());
		pnlButtonPanel.add(btnGameButton15);
		
		JPanel pnlOptionsPanel = new JPanel();
		pnlOptionsPanel.setBounds(12, 401, 647, 91);
		frame.getContentPane().add(pnlOptionsPanel);
		pnlOptionsPanel.setLayout(null);
		
		btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameData.playGame();
			}
		});
		btnNewGame.setBounds(12, 13, 97, 25);
		pnlOptionsPanel.add(btnNewGame);
		
		JLabel lblMasterShipMode = new JLabel("Master Ship Mode:");
		lblMasterShipMode.setBounds(416, 13, 112, 16);
		pnlOptionsPanel.add(lblMasterShipMode);
		
		JButton btnSaveGame = new JButton("Save Game");
		btnSaveGame.setBounds(12, 53, 97, 25);
		pnlOptionsPanel.add(btnSaveGame);
		
		JButton button = new JButton("Save Game");
		button.setBounds(122, 13, 97, 25);
		pnlOptionsPanel.add(button);
		
		JRadioButton rdbtnOffensive = new JRadioButton("Offensive");
		rdbtnOffensive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameData.setMasterShipOffensive(true);
				System.out.println(GameData.isMasterShipOffensive());
			}
		});
		buttonGroup.add(rdbtnOffensive);
		rdbtnOffensive.setBounds(416, 31, 127, 25);
		pnlOptionsPanel.add(rdbtnOffensive);
		
		JRadioButton rdbtnDefensive = new JRadioButton("Defensive");
		rdbtnDefensive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameData.setMasterShipOffensive(false);
				System.out.println(GameData.isMasterShipOffensive());
			}
		});
		rdbtnDefensive.setSelected(true);
		buttonGroup.add(rdbtnDefensive);
		rdbtnDefensive.setBounds(416, 53, 127, 25);
		pnlOptionsPanel.add(rdbtnDefensive);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public static GameButton getBtnGameButton0() {
		return btnGameButton0;
	}

	public static void setBtnGameButton0(GameButton btnGameButton0) {
		MainApp.btnGameButton0 = btnGameButton0;
	}

	public static GameButton getBtnGameButton1() {
		return btnGameButton1;
	}

	public static void setBtnGameButton1(GameButton btnGameButton1) {
		MainApp.btnGameButton1 = btnGameButton1;
	}

	public static GameButton getBtnGameButton2() {
		return btnGameButton2;
	}

	public static void setBtnGameButton2(GameButton btnGameButton2) {
		MainApp.btnGameButton2 = btnGameButton2;
	}

	public static GameButton getBtnGameButton3() {
		return btnGameButton3;
	}

	public static void setBtnGameButton3(GameButton btnGameButton3) {
		MainApp.btnGameButton3 = btnGameButton3;
	}

	public static GameButton getBtnGameButton4() {
		return btnGameButton4;
	}

	public static void setBtnGameButton4(GameButton btnGameButton4) {
		MainApp.btnGameButton4 = btnGameButton4;
	}

	public static GameButton getBtnGameButton5() {
		return btnGameButton5;
	}

	public static void setBtnGameButton5(GameButton btnGameButton5) {
		MainApp.btnGameButton5 = btnGameButton5;
	}

	public static GameButton getBtnGameButton6() {
		return btnGameButton6;
	}

	public static void setBtnGameButton6(GameButton btnGameButton6) {
		MainApp.btnGameButton6 = btnGameButton6;
	}

	public static GameButton getBtnGameButton7() {
		return btnGameButton7;
	}

	public static void setBtnGameButton7(GameButton btnGameButton7) {
		MainApp.btnGameButton7 = btnGameButton7;
	}

	public static GameButton getBtnGameButton8() {
		return btnGameButton8;
	}

	public static void setBtnGameButton8(GameButton btnGameButton8) {
		MainApp.btnGameButton8 = btnGameButton8;
	}

	public static GameButton getBtnGameButton9() {
		return btnGameButton9;
	}

	public static void setBtnGameButton9(GameButton btnGameButton9) {
		MainApp.btnGameButton9 = btnGameButton9;
	}

	public static GameButton getBtnGameButton10() {
		return btnGameButton10;
	}

	public static void setBtnGameButton10(GameButton btnGameButton10) {
		MainApp.btnGameButton10 = btnGameButton10;
	}

	public static GameButton getBtnGameButton11() {
		return btnGameButton11;
	}

	public static void setBtnGameButton11(GameButton btnGameButton11) {
		MainApp.btnGameButton11 = btnGameButton11;
	}

	public static GameButton getBtnGameButton12() {
		return btnGameButton12;
	}

	public static void setBtnGameButton12(GameButton btnGameButton12) {
		MainApp.btnGameButton12 = btnGameButton12;
	}

	public static GameButton getBtnGameButton13() {
		return btnGameButton13;
	}

	public static void setBtnGameButton13(GameButton btnGameButton13) {
		MainApp.btnGameButton13 = btnGameButton13;
	}

	public static GameButton getBtnGameButton14() {
		return btnGameButton14;
	}

	public static void setBtnGameButton14(GameButton btnGameButton14) {
		MainApp.btnGameButton14 = btnGameButton14;
	}

	public static GameButton getBtnGameButton15() {
		return btnGameButton15;
	}

	public static void setBtnGameButton15(GameButton btnGameButton15) {
		MainApp.btnGameButton15 = btnGameButton15;
	}

	public static JButton getBtnNewGame() {
		return btnNewGame;
	}

	public static void setBtnNewGame(JButton btnNewGame) {
		MainApp.btnNewGame = btnNewGame;
	}
}
