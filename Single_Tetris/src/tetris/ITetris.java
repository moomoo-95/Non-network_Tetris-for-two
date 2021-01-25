package tetris;

public interface ITetris {
    public void init();
    public void moveLeft();
    public void moveRight();
    public void moveDown();
    public void rotate();
    public void moveBottom();
    
    public void play();
    public void pause();
    public void resume();
    
    public int getWidth();
    public int getHeight();

    public void register(ITetrisObserver observer);

    public int[][] getBoard();

    public int getScore();

    public int getLevel();
    public int getSpeed();
    
    public ITetrisObserver getObserver();

    public Tetromino getCurrentBlock();
    public Tetromino getNextBlock();
    public Tetromino getShadowBlock();

    public int addSore(int score);

    public boolean isIdleState();
    public boolean isGameOverState();
    public boolean isPlayState();
    public boolean isPauseState();

    public boolean isEnableShadow();
    public void enableShadow();
    public void disableShadow();
}