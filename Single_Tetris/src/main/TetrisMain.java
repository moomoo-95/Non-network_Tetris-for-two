package main;

import javax.swing.*;

import javafx.geometry.Orientation;

import java.awt.*;

public class TetrisMain extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    public TetrisMain() {
    	setLayout(new FlowLayout());

        setSize(730, 650);
        
    	GridBagConstraints gbc = new GridBagConstraints();
    	gbc.fill = GridBagConstraints.BOTH;
    	
    	
        TetrisBoardGUI tetrisBoardGui  = new TetrisBoardGUI(this);
        tetrisBoardGui.setPreferredSize(new Dimension(450, 600));
        
        TetrisHelpGUI tetrisHelpGui = new TetrisHelpGUI(this);
        tetrisHelpGui.setPreferredSize(new Dimension(250, 600));
        
        add(tetrisBoardGui);
        add(tetrisHelpGui);
        
        tetrisBoardGui.start();

        setResizable(false);
        setTitle("moomoo95_Single_Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        TetrisMain tetrisGui = new TetrisMain();
        tetrisGui.setLocationRelativeTo(null);
        tetrisGui.setVisible(true);
    }
}