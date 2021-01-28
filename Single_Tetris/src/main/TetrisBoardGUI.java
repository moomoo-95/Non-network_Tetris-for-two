package main;

import player.*;
import tetris.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class TetrisBoardGUI extends JPanel implements ITetrisObserver {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final int BOARD_WIDTH = 15;
    final int BOARD_HEIGHT = 20;

    IPlayer player;
    IPlayerDraw playerDraw;
    IPlayerAction playerAction;


    private Image screenBuffer = null;
    private Graphics graphicsBuffer = null;


    public TetrisBoardGUI(TetrisMain parent) {
        playerDraw = new PlayerDraw();
        playerAction = new PlayerAction();
        player = new Player(this, playerDraw, playerAction);

        setSize(600, 800);
        setFocusable(true);
        addKeyListener(new TetrisKeyAdapter());
    }

    public void update() {
        TetrisLog.d("TetrisBoardGUI.update()");
        repaint();
    }
    private int blockWidth() { return (int) getSize().getWidth() / BOARD_WIDTH; }
    private int blockHeight() { return (int) getSize().getHeight() / BOARD_HEIGHT; }


    public void start()
    {
        player.init();
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        Dimension size = getSize();

        int width = (int)size.getWidth();
        int height = (int)size.getHeight();

        if (screenBuffer == null) {
            screenBuffer = createImage(width, height);
        }

        graphicsBuffer = screenBuffer.getGraphics();
        graphicsBuffer.setColor(new Color(0, 0, 0));
        graphicsBuffer.fillRect(0, 0, width, height);

        int boardY = (int) size.getHeight() - BOARD_HEIGHT * blockHeight();
        int boardX = (int) (size.getWidth() - BOARD_WIDTH * blockWidth())/2;

        player.onDraw(graphicsBuffer, boardX, boardY, blockWidth(), blockHeight());

        g.drawImage(screenBuffer, 0, 0, null);

        screenBuffer = null;
    }

    class TetrisKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            player.onPressKey(keycode);
        }
    }
}