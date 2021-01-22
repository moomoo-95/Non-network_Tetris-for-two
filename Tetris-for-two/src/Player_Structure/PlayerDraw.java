package Player_Structure;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import Tetris_Structure.*;

public class PlayerDraw implements ItfacePlayerDraw {
	ItfaceTetris tetris;
	
	public void setTetris (ItfaceTetris tetris) {
		this.tetris = tetris;
	}
	
	public void onDraw(Graphics g, int startX, int startY, int blockWidth, int blockHeight) {
        int i = 0, j = 0;

        int[][] board = tetris.getBoard();

        for (i = 0; i < tetris.getWidth(); i++) {
            for (j = 0; j < tetris.getHeight(); j++) {
                drawRectangle(g, startX + i * blockWidth,
                        startY + j * blockHeight, board[j][i], blockWidth, blockHeight);
            }
        }

        if (tetris.isPlayState()) {
            TetrisLog.d("PlayerDraw.onDraw()");

            if (tetris.isEnableShadow()) {
                Tetromino shadowBlock = tetris.getShadowBlock();
                drawShadowBlock(g, shadowBlock, startX, startY, blockWidth, blockHeight);
            }

            Tetromino currentBlock = tetris.getCurrentBlock();
            drawBlock(g, currentBlock, startX, startY, blockWidth, blockHeight);

            Tetromino nextblock = tetris.getNextBlock();
            int nextBlockX = startX + blockWidth * (tetris.getWidth()-1);
            int nextBlockY = startY + blockHeight * 4;

            drawBlock(g, nextblock, nextBlockX, nextBlockY, blockWidth/2, blockHeight/2);
        }

        int scorePointX =  startX + blockWidth * (tetris.getWidth()+1);
        int scorePointY =  startY + blockHeight * 8;
        g.setColor(Color.CYAN);
        g.setFont(new Font("Purisa", Font.PLAIN, 14));
        g.drawString(String.valueOf(tetris.getScore()), scorePointX, scorePointY);
    }


    private void drawBlock(Graphics g, Tetromino block, int startX, int startY, int blockWidth, int blockHeight) {
        int i = 0, j = 0;
        int[][] ablock = block.getBlock();
        int sw = block.getWidth();
        int sh = block.getHeight();
        int sx = block.getX();
        int sy = block.getY();
        int sType = block.getColorType();

        for (i = 0; i < sw; i++) {
            for (j = 0; j < sh; j++) {
                if (ablock[j][i] != Tetris.empty) {
                    drawRectangle(g, startX + (sx + i) * blockWidth,
                            startY + (sy + j) * blockHeight, sType, blockWidth, blockHeight);
                }
            }
        }
    }

    private void drawShadowBlock(Graphics g, Tetromino block, int startX, int startY, int blockWidth, int blockHeight) {
        int i = 0, j = 0;
        int[][] ablock = block.getBlock();
        int sw = block.getWidth();
        int sh = block.getHeight();
        int sx = block.getX();
        int sy = block.getY();
        int sType = block.getColorType();

        for (i = 0; i < sw; i++) {
            for (j = 0; j < sh; j++) {
                if (ablock[j][i] != Tetris.empty) {
                    drawShadowRectangle(g, startX + (sx + i) * blockWidth,
                            startY + (sy + j) * blockHeight, sType, blockWidth, blockHeight);
                }
            }
        }
    }

    private void drawRectangle(Graphics g, int x, int y, int type, int blockWidth, int blockHeight)
    {
        Color colors[] = { new Color(90, 90, 90), new Color(204, 102, 102),
                new Color(102, 204, 102), new Color(102, 102, 204),
                new Color(204, 204, 102), new Color(204, 102, 204),
                new Color(102, 204, 204), new Color(218, 170, 0)
        };

        Color color = colors[type];

        g.setColor(color);
        g.fillRect(x + 1, y + 1, blockWidth - 2, blockHeight - 2);

        g.setColor(color.brighter());
        g.drawLine(x, y + blockHeight - 1, x, y);
        g.drawLine(x, y, x + blockWidth - 1, y);

        g.setColor(color.darker());
        g.drawLine(x + 1, y + blockHeight - 1,
                x + blockWidth - 1, y + blockHeight - 1);
        g.drawLine(x + blockWidth - 1, y + blockHeight - 1,
                x + blockWidth - 1, y + 1);
    }

    private void drawShadowRectangle(Graphics g, int x, int y, int type, int blockWidth, int blockHeight)
    {
        Color colors[] = { new Color(90, 90, 90), new Color(204, 102, 102),
                new Color(102, 204, 102), new Color(102, 102, 204),
                new Color(204, 204, 102), new Color(204, 102, 204),
                new Color(102, 204, 204), new Color(218, 170, 0)
        };

        Color color = colors[type];

        g.setColor(color);
        //g.fillRect(x + 1, y + 1, blockWidth - 2, blockHeight - 2);

        g.setColor(color.brighter());
        g.drawLine(x, y + blockHeight - 1, x, y);
        g.drawLine(x, y, x + blockWidth - 1, y);

        //g.setColor(color.darker());
        g.drawLine(x + 1, y + blockHeight - 1,
                x + blockWidth - 1, y + blockHeight - 1);
        g.drawLine(x + blockWidth - 1, y + blockHeight - 1,
                x + blockWidth - 1, y + 1);
    }
}