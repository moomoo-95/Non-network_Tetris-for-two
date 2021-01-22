package Player_Structure;

import java.awt.Graphics;

import Tetris_Structure.ItfaceTetris;;

public interface ItfacePlayerDraw {
    public void onDraw(Graphics g, int startX, int startY, int blockwidth, int blockHeight);
    public void setTetris(ItfaceTetris tetris);
}