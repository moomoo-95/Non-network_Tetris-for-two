package Tetris_for_two;

public class TetrisBoard {
	private int width;
	private int height;
	private ItfaceTetris tetris;
	private int[][] board;
	
	public TetrisBoard(int width, int height, Tetris tetris) {
		this.width = width;
		this.height = height;
		this.tetris = tetris;
		
		board = new int[this.height][this.width];
		init();
	}
	
    public void init() {
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                board[i][j] = 0;
            }
        }
     }

     public int getWidth() {
         return this.width;
     }

     public int getHeight() {
         return this.height;
     }

     public int[][] getBoard() {
         return this.board;
     }

     public boolean isAcceptable(Tetromino tetromino) {
         int[][] block = tetromino.getBlock();
         int w = tetromino.getWidth();
         int h = tetromino.getHeight();
         int x = tetromino.getX();
         int y = tetromino.getY();

         TetrisLog.d("W : " + w + " H : " + h + " X : " + x + " Y : " + y);

         for (int i = 0; i < h; i++) {
             for (int j = 0; j < w; j++) {
                 if (block[i][j] != Tetris.empty) {
                     if (x < 0 || (x+j) > (width-1) || (y+i) > (height-1) || y < 0) {
                         return false;
                     }
                     if (board[y+i][x+j] != Tetris.empty) {
                         return false;
                     }
                 }
             }
         }

         return true;
     }
}
