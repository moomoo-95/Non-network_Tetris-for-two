package Tetris_Structure;

public class TetrominoFactory {
	public static Tetromino create() {
		return create((int) (Math.random() * 7)+1);
	}
	public static Tetromino create(int type) {
		switch (type) {
		case 1 :
			return new ITetromino();
		case 2 :
			return new JTetromino();
		case 3 :
			return new LTetromino();
		case 4 :
			return new TTetromino();
		case 5 :
			return new OTetromino();
		case 6 :
			return new STetromino();
		case 7 :
			return new ZTetromino();
		default :
			TetrisLog.e("Tetromino Create Error");
			return new ZTetromino();
		}
	}
	
	public static Tetromino clone(Tetromino c) {
		Tetromino block = create(c.getColorType());
		block.clone(c);
		return block;
	}
	
	private TetrominoFactory() {}
}
