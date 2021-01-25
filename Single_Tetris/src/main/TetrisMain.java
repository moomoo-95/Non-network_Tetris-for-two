package main;

import javax.swing.*;
import java.awt.*;

public class TetrisMain extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel statusbar;

    public TetrisMain() {
        statusbar = new JLabel("Main Press S to play game");
        statusbar.setFont(new Font(statusbar.getFont().getFontName(), Font.PLAIN, 18));
        add(statusbar, BorderLayout.SOUTH);
        TetrisBoardGUI tetrisBoardGui  = new TetrisBoardGUI(this);
        add(tetrisBoardGui);

        tetrisBoardGui.start();

        setSize(390, 630);
        setTitle("moomoo95_Single_Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JLabel getStatusBar() {
        return statusbar;
    }

    public static void main(String[] args) {
        TetrisMain tetrisGui = new TetrisMain();
        tetrisGui.setLocationRelativeTo(null);
        tetrisGui.setVisible(true);
    }
}