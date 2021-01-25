package tetris;

import java.util.*;

public class TetrisPauseState extends TetrisGameState {

	public int stateNum = 3;
    /**
     * Default constructor
     */
    public TetrisPauseState(Tetris tetris) {
        this.tetris = tetris;
    }

    public boolean isPauseState() { return true; }
}