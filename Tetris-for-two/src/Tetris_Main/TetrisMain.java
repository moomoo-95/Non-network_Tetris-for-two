package Tetris_Main;

import java.awt.*;
import javax.swing.*;

public class TetrisMain extends JFrame {
	JLabel statusbar;
	
	public TetrisMain() {
		statusbar = new JLabel("Main Press S to play game");
		statusbar.setFont(new Font(statusbar.getFont().getFontName(), Font.ITALIC, 18));
		add(statusbar, BorderLayout.SOUTH);
		TetrisBoardGUI tetrisboardgui = new TetrisBoardGUI(this);
		add(tetrisboardgui);

        tetrisboardgui.start();

        setSize(390, 630);
        setTitle("moomoo95_Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
    public JLabel getStatusBar() {
        return statusbar;
    }

    public static void main(String[] args) {
        TetrisMain tetrisgui = new TetrisMain();
        tetrisgui.setLocationRelativeTo(null);
        tetrisgui.setVisible(true);
    }
}
