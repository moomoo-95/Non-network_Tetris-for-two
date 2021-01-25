package tetris;

public class TetrisIdleState extends TetrisGameState {
	public int stateNum = 1;

    public TetrisIdleState(Tetris tetris) {
        TetrisLog.d("TetrisIdleState()");
        this.tetris = tetris;
    }
    public boolean isIdleState() {
       return true;
    }
}