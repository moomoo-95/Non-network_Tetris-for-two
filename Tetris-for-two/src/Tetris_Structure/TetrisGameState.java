package Tetris_Structure;

public abstract class TetrisGameState {
	protected ItfaceTetris tetris;
	
	public TetrisGameState() {}
	
	public void init() {}
	public void moveLeft() {}
	public void moveRight() {}
	public void moveDown() {}
	public void rotate() {}
	public void moveBottom() {}
	
	public void fixCurrentBlock() {}
	public void updateBlock() {}
	
	public boolean gameOver() {
		return false;
	}
	
	public void updateBoard() {}
	
    public Tetromino getCurrentTetromino() {
    	return null;
    }
    public Tetromino getNextTetromino() {
    	return null;
    }
    public Tetromino getShadowTetromino() {
    	return null;
    }
    
    public void update() {
    	TetrisLog.d("TetrisGameState.update()");
    	if (tetris != null) {
    		tetris.getObserver().update();
    	}
    }
    
    public boolean isIdleState() {
    	return false;
    }
    public boolean isGameOverState() {
    	return false;
    }
    public boolean isPlayState() {
    	return false;
    }
    public boolean isPauseState() {
    	return false;
    }
}

class TetrisIdleState extends TetrisGameState {
	public TetrisIdleState(Tetris tetris) {
		TetrisLog.d("TetrisIdleState()");
		this.tetris = tetris;
	}
	
	public boolean isIdleState() {
		return true;
	}
}

class TetrisPlayState extends TetrisGameState {
	private Tetromino currentTetromino;
	private Tetromino nextTetromino;
	private Tetromino shadowTetromino;
	private TetrisBoard tetrisBoard;
	private int additionalPoint = 1;
	
	TetrisPlayState(Tetris tetris, TetrisBoard board) {
		this.tetris = tetris;
		this.tetrisBoard = board;
		currentTetromino = TetrominoFactory.create();
		nextTetromino = TetrominoFactory.create();
		shadowTetromino = TetrominoFactory.create();
	}
	
	public void init() {
        this.tetrisBoard.init();
        currentTetromino = TetrominoFactory.create();
        nextTetromino = TetrominoFactory.create();
        shadowTetromino = TetrominoFactory.clone(currentTetromino);
        additionalPoint = 1;
    }

    public void moveLeft() {
       TetrisLog.d("TetrisPlayState.moveLeft()");
        currentTetromino.moveLeft();
        if (tetrisBoard.isAcceptable(currentTetromino) == false) {
            currentTetromino.moveRight();
            TetrisLog.d("TetrisPlayState.moveLeft() Not Accept");
        }
    }

    public void moveRight() {
        TetrisLog.d("TetrisPlayState.moveRight()");
        currentTetromino.moveRight();
        if (tetrisBoard.isAcceptable(currentTetromino) == false) {
            currentTetromino.moveLeft();
            TetrisLog.d("TetrisPlayState.moveRight() Not Accept");
        }
    }

    public void moveDown() {
        TetrisLog.d("TetrisPlayState.moveDown()");
        currentTetromino.moveDown();
        if (tetrisBoard.isAcceptable(currentTetromino)) {
            TetrisLog.d("Accept");
        } else {
            currentTetromino.moveUp();
            TetrisLog.d("Can not move down");
            fixCurrentBlock();
            updateBoard();
            updateBlock();
        }
    }


    public void moveBottom() {
        TetrisLog.d("TetrisPlayState.moveBottom()");
        while(tetrisBoard.isAcceptable(currentTetromino)) {
            currentTetromino.moveDown();
        }
        if (tetrisBoard.isAcceptable(currentTetromino)) {
            return;
        }
        currentTetromino.moveUp();
    }
    

    public void rotate() {
        TetrisLog.d("TetrisPlayState.rotate()");
        currentTetromino.rotate();
        if (tetrisBoard.isAcceptable(currentTetromino) == false) {
            currentTetromino.preRotate();
            TetrisLog.d("TetrisPlayState.rotate() Not Accept");
        }
    }
    
    public void fixCurrentBlock() {
        tetrisBoard.addTetrominos(currentTetromino);
    }

    public void updateBlock() {
        currentTetromino = nextTetromino;
        shadowTetromino = TetrominoFactory.clone(currentTetromino);
        nextTetromino = TetrominoFactory.create();
    }

    public boolean gameOver() {
        TetrisLog.d("Check Game over");
        return !tetrisBoard.isAcceptable(currentTetromino);
    }

    public void updateBoard() {
        int removedLine = tetrisBoard.arrange();
        int point = calculatorScore(removedLine);
        tetris.addSore(point);
    }

    private int calculatorScore(int removedLineCount) {
        if (removedLineCount == 0) {
            additionalPoint = 1;
            return 0;
        }

        int lineScore = 22;
        if (removedLineCount >= 4) {
            removedLineCount = 4;
            lineScore = 888;
        } else {
            lineScore *= removedLineCount;
        }
        if (additionalPoint > 10000) {
            additionalPoint = 10000;
        }
        additionalPoint <<= removedLineCount;
        TetrisLog.d("calculatorScore : " + additionalPoint + " : " + removedLineCount);
        return  (removedLineCount * 10 * additionalPoint + lineScore);
    }

    public Tetromino getCurrentTetrominos() {
        return currentTetromino;
    }

    public Tetromino getNextTetrominos() {
        return nextTetromino;
    }

    public Tetromino getShadowTetrominos() {
        moveShadowBottom();
        return shadowTetromino;
    }

    public void moveShadowBottom() {
        TetrisLog.d("TetrisPlayState.moveShadowBottom()");

        shadowTetromino.clone(currentTetromino);

        while(tetrisBoard.isAcceptable(shadowTetromino)) {
            shadowTetromino.moveDown();
        }
        if (tetrisBoard.isAcceptable(shadowTetromino)) {
            return;
        }
        shadowTetromino.moveUp();
    }

    public boolean isPlayState() {
        return true;
    }

}

class TetrisPauseState extends TetrisGameState {
	public TetrisPauseState(Tetris tetris) {
		TetrisLog.d("TetrisPauseState()");
		this.tetris = tetris;
	}
	
	public boolean isPauseState() {
		return true;
	}
}

class TetrisGameOverState extends TetrisGameState {
	public TetrisGameOverState(Tetris tetris) {
		TetrisLog.d("TetrisGameOverState()");
		this.tetris = tetris;
	}
	
	public boolean isGameOverState() {
		return true;
	}
}