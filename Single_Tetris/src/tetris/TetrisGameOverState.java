package tetris;

import java.util.*;

public class TetrisGameOverState extends TetrisGameState {
	public int stateNum = 4;

    public TetrisGameOverState(Tetris tetris) {
        this.tetris = tetris;
    }

    public boolean isGameOverState() {
        return true;
    }
}