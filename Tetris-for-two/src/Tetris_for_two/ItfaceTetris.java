package Tetris_for_two;

public interface ItfaceTetris {
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
	
	public void register(ItfaceTetrisObserver observer);

    public int[][] getBoard();

    public int getScore();

    public ItfaceTetrisObserver getObserver();

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

interface ItfaceTetrisObserver{
	public void update();
}

class Tetris implements ItfaceTetris {
	public static final int empty = 0;
	
	private int score;
	private int level;
	private int speed;
	private boolean isEnableShadow = true;

	private TetrisIdleState idleState;
	private TetrisPlayState playState;
	private TetrisPauseState pauseState;
	private TetrisGameOverState gameOverState;
	
	private TetrisBoard board;
	private TetrisGameState gameState;
	
	private ItfaceTetrisObserver observer;
	
	public Tetris(int width, int height) {
		TetrisLog.d("Create new Tetris [ " + height + " , " + width);
		
		board = new TetrisBoard(width, height, this);
		
		idleState = new TetrisIdleState(this);
		playState = new TetrisPlayState(this, this.board);
		pauseState = new TetrisPauseState(this);
		gameOverState = new TetrisGameOverState(this);
	}
	
	public void init() {
		TetrisLog.d("Tetris.Init()");
		score = 0;
		level = 1;
		gameState = idleState;
		board.init();
		gameState.update();
	}
	
	public void play() {
        TetrisLog.d("Tetris.play()");
        score = 0;
        level = 1;
        setState(playState);
        gameState.init();
        gameState.update();
    }

    public void pause() {
        TetrisLog.d("Tetris.pause()");
        setState(pauseState);
        gameState.update();
    }

    public void resume() {
        TetrisLog.d("Tetris.resume()");
        setState(playState);
        gameState.update();
    }

    public void moveLeft() {
        gameState.moveLeft();
        gameState.update();
    }

    public void moveRight() {
        gameState.moveRight();
        gameState.update();
    }

    public void moveDown() {
        if (gameState.gameOver()) {
            setState(gameOverState);
        } else {
            gameState.moveDown();
        }
        gameState.update();
    }

    public void rotate() {
        gameState.rotate();
        gameState.update();
    }

    public void moveBottom() {
        gameState.moveBottom();
        gameState.update();
    }

    public void setState(TetrisGameState state) {
        this.gameState = state;
    }
    
    public ItfaceTetrisObserver getObserver() {
        return this.observer;
    }

    public int getWidth() {
        return board.getWidth();
    }
    public int getHeight() {
        return board.getHeight();
    }
    public int getScore() { return this.score; }
    public int addSore(int score) { return this.score += score; }
    public int[][] getBoard() {
        return board.getBoard();
    }
    public Tetromino getCurrentBlock() { return gameState.getCurrentTetromino(); }
    public Tetromino getNextBlock() { return gameState.getNextTetromino(); }
    public Tetromino getShadowBlock() { return gameState.getShadowTetromino(); }

    public boolean isEnableShadow(){ return this.isEnableShadow; }
    public void enableShadow() {
        this.isEnableShadow = true;
        gameState.update();
    }
    public void disableShadow() {
        this.isEnableShadow = false;
        gameState.update();
    }

    public void register(ItfaceTetrisObserver observer) {
        TetrisLog.d("Registered view!");
        this.observer = observer;
    }

    public boolean isIdleState() { return gameState.isIdleState(); }
    public boolean isGameOverState() { return gameState.isGameOverState(); }
    public boolean isPlayState() { return gameState.isPlayState(); }
    public boolean isPauseState() { return gameState.isPauseState(); }
}