package player;

import tetris.ITetris;

import java.awt.*;

public interface IPlayerDraw {
    public void onDraw(Graphics g, int startX, int startY, int blockwidth, int blockHeight);
    public void setTetris(ITetris tetris);
}