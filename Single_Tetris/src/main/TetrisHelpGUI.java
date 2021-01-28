package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class TetrisHelpGUI extends JPanel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String text = "<HTML>HELP<br>S : Start / Reset Game<br>P : Pause / Restart Game<br> ¡è¡æ¡ç¡é</HTML>";
	
    public TetrisHelpGUI(TetrisMain parent) {
    	setLayout(new GridBagLayout());


        setSize(300, 800);
        
    	setBackground(new Color(0, 0, 0));
    	GridBagConstraints gbc = new GridBagConstraints();
    	gbc.fill = GridBagConstraints.BOTH;
    	
    	JLabel help = new JLabel(text);
    	help.setOpaque(true);
    	help.setBackground(new Color(51, 51, 51));
    	help.setForeground(new Color(255, 255, 255));
    	help.setFont(new Font("Purisa", Font.ITALIC, 14));
    	
    	add(help, setLocation(gbc, 1.0, 1.0, 0, 0));
        add(new JLabel("Rank"), setLocation(gbc, 1.0, 1.0, 0, 1));
        
    }

    public GridBagConstraints setLocation(GridBagConstraints gbc, double wx, double wy, int sx, int sy) {
    	gbc.weightx = wx;
    	gbc.weighty = wy;
    	gbc.gridx = sx;
    	gbc.gridy= sy;
    	return gbc;
    }
}