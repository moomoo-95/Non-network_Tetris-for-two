package tetris;

public class TetrominosFactory {

    public static Tetromino create() {
       return create ((int) (Math.random() * 7)+1);
    }

    public static Tetromino create(int type) {
        switch(type) {
                case 1:
                    return new TetrominosO();
                case 2:
                    return new TetrominoI();
                case 3:
                    return new TetrominoL();
                case 4:
                    return new TetrominoJ();
                case 5:
                    return new TetrominoT();
                case 6:
                    return new TetrominoS();
                case 7:
                    return new TetrominoZ();
                default:
                    TetrisLog.e("Tetrominos Create Error! Never come to here!");
                    return new TetrominoI();
        }
    }

    public static Tetromino clone(Tetromino t) {
        Tetromino block = create(t.getType());
        block.clone(t);
        return block;
    }

    private TetrominosFactory() {}
}