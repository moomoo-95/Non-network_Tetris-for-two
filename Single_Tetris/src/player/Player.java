package player;

import main.TetrisBoardGUI;
import tetris.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player implements IPlayer, ActionListener {
    final int BOARD_WIDTH = 10;
    final int BOARD_HEIGHT = 20;

    ITetris tetris;
    TetrisBoardGUI board;
    IPlayerDraw playerDraw;
    IPlayerAction playerAction;
    Timer tetrisTimer;

    private int gameSpeed = 0;

    public Player(TetrisBoardGUI board, IPlayerDraw playerDraw, IPlayerAction playerAction) {
        this.board = board;

        this.tetris = new Tetris(BOARD_WIDTH, BOARD_HEIGHT);
        this.tetris.register(this.board);
        this.tetris.init();

        this.playerDraw = playerDraw;
        this.playerDraw.setTetris(this.tetris);

        this.playerAction = playerAction;
        this.playerAction.setPlayer(this);

        this.tetrisTimer = new Timer(0, this);
    }

    public void onDraw(Graphics g, int startX, int startY, int blockWidth, int blockHeight) {
        playerDraw.onDraw(g, startX, startY, blockWidth, blockHeight);
    }

    public void onPressKey(int k) {
        playerAction.onKeyEvent(k);
    }

    public void init() {
        tetris.init();
    }

    public void moveLeft() {
        tetris.moveLeft();
    }

    public void moveRight() {
        tetris.moveRight();
    }

    public void moveDown() {
        tetris.moveDown();
    }

    public void rotate() {
        tetris.rotate();
    }

    public void moveBottom() {
        tetris.moveBottom();
        tetris.moveDown();
    }

    public void play() {
        tetris.play();
        tetrisTimer.start();
    }

    public void pause() {
        tetris.pause();
        tetrisTimer.stop();
    }

    public void resume() {
        tetris.resume();
        tetrisTimer.start();
    }

    public boolean isIdleState() {
        return tetris.isIdleState();
    }

    public boolean isGameOverState() {
        return tetris.isGameOverState();
    }

    public boolean isPlayState() {
        return tetris.isPlayState();
    }

    public boolean isPauseState() {
        return tetris.isPauseState();
    }

    public boolean isEnableShadow() { return tetris.isEnableShadow(); }
    public void enableShadow() { tetris.enableShadow(); }
    public void disableShadow() { tetris.disableShadow(); }

    public void actionPerformed(ActionEvent e) {
    	TetrisLog.d("Player.actionPerformed()");
        if (tetris == null ) {
            return;
        }
        if (tetris.isPlayState()) {
            tetris.moveDown();
            gameSpeed = 500 - (tetris.getScore() / 100);
            if(gameSpeed < 1) { gameSpeed = 1; }
            tetrisTimer.setDelay(gameSpeed);
        } else if (tetris.isGameOverState()) {
            tetrisTimer.stop();
        }
    }
}