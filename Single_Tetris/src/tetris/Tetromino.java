package tetris;

public abstract class Tetromino {
    protected int x;
    protected int y;
    protected int r;
    protected int w;
    protected int h;
    protected int type;
    protected int numOfBlockType;
    protected int[][][] block;


    public Tetromino() {
    }

    public void rotate() {
        r = (r+1) % numOfBlockType;
    }

    public void preRotate() {
        r = (r-1+numOfBlockType) % numOfBlockType;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }


    public void moveDown() {
        y++;
    }

    public void moveUp() {
        y--;
    }

    public int[][] getBlock() {
        return null;
    }

    public int getWidth() {
        return w;
    }

    public int getHeight() {
        return h;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getType() { return type; }

    public void clone(Tetromino t) {
        this.x = t.x;
        this.y = t.y;
        this.r = t.r;
    }
}

class TetrominosO extends Tetromino {

    public TetrominosO() {
        this.block = new int[][][]{
                {
                        {1, 1},
                        {1, 1}
                },
        };
        numOfBlockType = 1;
        x = 4;
        y = 0;
        r = 0;
        w = 2;
        h = 2;
        type = 1;
    }

    public void rotate() {
        r = 0;
    }
    public int[][] getBlock() {
        return block[r];
    }
}

class TetrominoI extends Tetromino {

    public TetrominoI() {
        this.block = new int[][][]{
                {
                        {1, 0, 0, 0},
                        {1, 0, 0, 0},
                        {1, 0, 0, 0},
                        {1, 0, 0, 0},
                },
                {
                        {1, 1, 1, 1},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                }
        };
        numOfBlockType = 2;
        x = 4;
        y = 0;
        r = 0;
        w = 4;
        h = 4;
        type = 2;
    }

    public int[][] getBlock() {
        return block[r];
    }
}

class TetrominoL extends Tetromino {

    public TetrominoL() {
        this.block = new int[][][]{
                {
                        {1, 0, 0},
                        {1, 0, 0},
                        {1, 1, 0},
                },
                {
                        {1, 1, 1},
                        {1, 0, 0},
                        {0, 0, 0},
                },
                {
                        {1, 1, 0},
                        {0, 1, 0},
                        {0, 1, 0},
                },
                {
                        {0, 0, 1},
                        {1, 1, 1},
                        {0, 0, 0},
                }
        };
        numOfBlockType = 4;
        x = 4;
        y = 0;
        r = 0;
        w = 3;
        h = 3;
        type = 3;
    }

    public int[][] getBlock() {
        return block[r];
    }

}

class TetrominoJ extends Tetromino {

    public TetrominoJ() {
        this.block = new int[][][]{
                {
                        {0, 1, 0},
                        {0, 1, 0},
                        {1, 1, 0},
                },
                {
                        {1, 0, 0},
                        {1, 1, 1},
                        {0, 0, 0},
                },
                {
                        {1, 1, 0},
                        {1, 0, 0},
                        {1, 0, 0},
                },
                {
                        {1, 1, 1},
                        {0, 0, 1},
                        {0, 0, 0},
                }
        };
        numOfBlockType = 4;
        x = 4;
        y = 0;
        r = 0;
        w = 3;
        h = 3;
        type = 4;
    }

    public int[][] getBlock() {
        return block[r];
    }
}

class TetrominoT extends Tetromino {

    public TetrominoT() {
        this.block = new int[][][]{
                {
                        {1, 0, 0},
                        {1, 1, 0},
                        {1, 0, 0},
                },
                {
                        {1, 1, 1},
                        {0, 1, 0},
                        {0, 0, 0},
                },
                {
                        {0, 1, 0},
                        {1, 1, 0},
                        {0, 1, 0},
                },
                {
                        {0, 1, 0},
                        {1, 1, 1},
                        {0, 0, 0},
                }
        };
        numOfBlockType = 4;
        x = 4;
        y = 0;
        r = 0;
        w = 3;
        h = 3;
        type = 5;
    }

    public int[][] getBlock() {
        return block[r];
    }
}

class TetrominoS extends Tetromino {

    public TetrominoS() {
        this.block = new int[][][]{
                {
                        {0, 1, 1},
                        {1, 1, 0},
                        {0, 0, 0},
                },
                {
                        {1, 0, 0},
                        {1, 1, 0},
                        {0, 1, 0},
                },
        };
        numOfBlockType = 2;
        x = 4;
        y = 0;
        r = 0;
        w = 3;
        h = 3;
        type = 6;
    }

    public int[][] getBlock() {
        return block[r];
    }
}

class TetrominoZ extends Tetromino {

    public TetrominoZ() {
        this.block = new int[][][]{
                {
                        {1, 1, 0},
                        {0, 1, 1},
                        {0, 0, 0},
                },
                {
                        {0, 1, 0},
                        {1, 1, 0},
                        {1, 0, 0},
                },
        };
        numOfBlockType = 2;
        x = 4;
        y = 0;
        r = 0;
        w = 3;
        h = 3;
        type = 7;
    }

    public int[][] getBlock() {
        return block[r];
    }
}