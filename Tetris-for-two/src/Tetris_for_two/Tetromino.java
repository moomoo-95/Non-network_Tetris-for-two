package Tetris_for_two;

public abstract class Tetromino {
	protected int X;
	protected int Y;
	protected int R;
	protected int W;
	protected int H;
	protected int colorType;
	protected int numOfBlockType;
	protected int[][][] block;
	
	public Tetromino() {}
	
	public void rotate() {
		R = (R+1) % numOfBlockType;
	}
	
	public void preRotate() {
		R = (R-1+numOfBlockType) % numOfBlockType;
	}

	public void moveLeft() {
		X--;
	}
	
	public void moveRight() {
		X++;
	}
	
	public void moveDown() {
		Y++;
	}
	
    public void moveUp() {
        Y--;
    }
	
	public int getWidth() {
		return W;
	}
	
	public int getHeight() {
		return H;
	}
	
	public int getX() {
		return X;
	}
	
	public int getY() {
		return Y;
	}
	
	public int[][] getBlock() {
		return null;
	}
	
	public int getColorType() {
		return colorType;
	}
	
	public void clone(Tetromino c) {
		this.X = c.X;
		this.Y = c.Y;
		this.R = c.R;
	}
}

class ITetromino extends Tetromino{
	public ITetromino() {
		this.block = new int[][][] {
			{
				{1, 0, 0, 0},
				{1, 0, 0, 0},
				{1, 0, 0, 0},
				{1, 0, 0, 0}
			},
			{
				{1, 1, 1, 1},
				{0, 0, 0, 0},
				{0, 0, 0, 0},
				{0, 0, 0, 0}
			}
		};
		numOfBlockType = 2;
		X = 3;
		Y = 0;
		R = 0;
		W = 4;
		H = 4;
		colorType = 1;
		
	}
	
	public int[][] getBlock(){
		return block[R];
	}
}

class JTetromino extends Tetromino{
	public JTetromino() {
		this.block = new int[][][] {
			{
				{0, 1, 0},
				{0, 1, 0},
				{1, 1, 0}
			},
			{
				{1, 0, 0},
				{1, 1, 1},
				{0, 0, 0}
			},
			{
				{1, 1, 0},
				{1, 0, 0},
				{1, 0, 0}
			},
			{
				{1, 1, 1},
				{0, 0, 1},
				{0, 0, 0}
			}
		};
		numOfBlockType = 4;
		X = 4;
		Y = 0;
		R = 0;
		W = 3;
		H = 3;
		colorType = 2;
		
	}
	
	public int[][] getBlock(){
		return block[R];
	}
}

class LTetromino extends Tetromino{
	public LTetromino() {
		this.block = new int[][][] {
			{
				{1, 0, 0},
				{1, 0, 0},
				{1, 1, 0}
			},
			{
				{1, 1, 1},
				{1, 0, 0},
				{0, 0, 0}
			},
			{
				{1, 1, 0},
				{0, 1, 0},
				{0, 1, 0}
			},
			{
				{0, 0, 1},
				{1, 1, 1},
				{0, 0, 0}
			}
		};
		numOfBlockType = 4;
		X = 4;
		Y = 0;
		R = 0;
		W = 3;
		H = 3;
		colorType = 3;
		
	}
	
	public int[][] getBlock(){
		return block[R];
	}
}

class OTetromino extends Tetromino{
	public OTetromino() {
		this.block = new int[][][] {
			{
				{1, 1},
				{1, 1}
			}
		};
		numOfBlockType = 1;
		X = 4;
		Y = 0;
		R = 0;
		W = 2;
		H = 2;
		colorType = 4;
		
	}
	
	public void rotate() {
		R = 0;
	}
	
	public void prerotate() {
		R= 0;
	}
	public int[][] getBlock(){
		return block[R];
	}
}

class TTetromino extends Tetromino{
	public TTetromino() {
		this.block = new int[][][] {
			{
				{1, 1, 1},
				{0, 1, 0},
				{0, 0, 0}
			},
			{
				{0, 1, 0},
				{1, 1, 0},
				{0, 1, 0}
			},
			{
				{0, 1, 0},
				{1, 1, 1},
				{0, 0, 0}
			},
			{
				{1, 0, 0},
				{1, 1, 0},
				{1, 0, 0}
			}
		};
		numOfBlockType = 4;
		X = 4;
		Y = 0;
		R = 0;
		W = 3;
		H = 3;
		colorType = 5;
		
	}
	
	public int[][] getBlock(){
		return block[R];
	}
}

class STetromino extends Tetromino{
	public STetromino() {
		this.block = new int[][][] {
			{
				{0, 1, 1},
				{1, 1, 0},
				{0, 0, 0}
			},
			{
				{1, 0, 0},
				{1, 1, 0},
				{0, 1, 0}
			}
		};
		numOfBlockType = 2;
		X = 4;
		Y = 0;
		R = 0;
		W = 3;
		H = 3;
		colorType = 6;
		
	}
	
	public int[][] getBlock(){
		return block[R];
	}
}

class ZTetromino extends Tetromino{
	public ZTetromino() {
		this.block = new int[][][] {
			{
				{1, 1, 0},
				{0, 1, 1},
				{0, 0, 0}
			},
			{
				{0, 1, 0},
				{1, 1, 0},
				{1, 0, 0}
			}
		};
		numOfBlockType = 2;
		X = 4;
		Y = 0;
		R = 0;
		W = 3;
		H = 3;
		colorType = 7;
		
	}
	
	public int[][] getBlock(){
		return block[R];
	}
}