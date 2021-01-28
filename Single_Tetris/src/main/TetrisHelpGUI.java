package main;

import java.awt.*;
import javax.swing.*;

public class TetrisHelpGUI extends JPanel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String text = "<HTML>HELP<br> S : Start / Reset Game<br> P : Pause / Restart Game<br> ก่ : Rotation"
			+ "<br> กๆ : Right<br> ก็ : Left<br> ก้ : Down<br> Space Bar : Pull Down</HTML>";
	
    public TetrisHelpGUI(TetrisMain parent) {
    	setLayout(new FlowLayout());

        setSize(300, 800);
        
    	setBackground(new Color(0, 0, 0));
    	GridBagConstraints gbc = new GridBagConstraints();
    	gbc.fill = GridBagConstraints.BOTH;
    	
    	JLabel help = new JLabel(text);
    	help.setOpaque(true);
    	help.setBackground(new Color(51, 51, 51));
    	help.setForeground(new Color(255, 255, 255));
    	help.setFont(new Font("Purisa", Font.ITALIC, 14));
    	help.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
    	help.setPreferredSize(new Dimension(240, 200));
    	
    	add(help);
        add(new JLabel("Rank Layout"));
        
    }
}