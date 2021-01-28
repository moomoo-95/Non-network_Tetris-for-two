package main;

import javax.swing.*;
import java.awt.*;

public class TetrisMain extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    public TetrisMain() {
    	
    	setLayout(new GridBagLayout());

        setSize(900, 800);
        
    	GridBagConstraints gbc = new GridBagConstraints();
    	gbc.fill = GridBagConstraints.BOTH;
    	
    	
        TetrisBoardGUI tetrisBoardGui  = new TetrisBoardGUI(this);
        TetrisHelpGUI tetrisHelpGui = new TetrisHelpGUI(this);
        
    	add(tetrisBoardGui, setLocation(gbc, 0.6, 1.0, 0, 0, 2, 1));
        add(tetrisHelpGui, setLocation(gbc, 0.3, 1.0, 3, 0, 1, 1));
        
        tetrisBoardGui.start();

        setResizable(false);
        setTitle("moomoo95_Single_Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public GridBagConstraints setLocation(GridBagConstraints gbc, double wx, double wy, int sx, int sy, int cx, int cy) {
    	gbc.weightx = wx;
    	gbc.weighty = wy;
    	gbc.gridx = sx;
    	gbc.gridy = sy;
    	gbc.gridwidth = cx;
    	gbc.gridheight = cy;
    	return gbc;
    }
    
    public static void main(String[] args) {
        TetrisMain tetrisGui = new TetrisMain();
        tetrisGui.setLocationRelativeTo(null);
        tetrisGui.setVisible(true);
    }
}