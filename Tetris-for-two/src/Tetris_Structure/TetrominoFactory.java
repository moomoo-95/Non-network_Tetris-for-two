package Tetris_Structure;

public class TetrominoFactory {
	public static Tetromino create() {
		return create((int) (Math.random() * 7));
	}
	public static Tetromino create(int type) {
		switch (type) {
		case 0 :
			return new ITetromino();
		case 1 :
			return new JTetromino();
		case 2 :
			return new LTetromino();
		case 3 :
			return new TTetromino();
		case 4 :
			return new OTetromino();
		case 5 :
			return new STetromino();
		case 6 :
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
