package player;

import tetris.ITetris;
import tetris.Tetris;
import tetris.TetrisLog;
import tetris.Tetromino;

import java.awt.*;

public class PlayerDraw implements IPlayerDraw {
    ITetris tetris;

    public void setTetris(ITetris tetris) {
        this.tetris = tetris;
    }

    public void onDraw(Graphics g, int startX, int startY, int blockWidth, int blockHeight) {
        // Draw board
        int i = 0, j = 0;

        int[][] board = tetris.getBoard();

        for (i = 0; i < tetris.getWidth(); i++) {
            for (j = 0; j < tetris.getHeight(); j++) {
                drawRectangle(g, startX + i * blockWidth,
                        startY + j * blockHeight, board[j][i], blockWidth, blockHeight);
            }
        }

        if (tetris.isPlayState()) {
        	TetrisLog.d("PlayerDraw.onDraw() = DrawBlock");

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

        int scorePointX =  startX + blockWidth * tetris.getWidth() + 5;
        int scorePointY =  startY + blockHeight * 8;
        g.setColor(new Color(255, 255, 255));
        g.setFont(new Font("Purisa", Font.PLAIN, 14));
        g.drawString("Score : " + String.valueOf(tetris.getScore()), scorePointX, scorePointY);
        g.drawString("Level : " + String.valueOf(tetris.getLevel()), scorePointX, scorePointY + 20);
        g.drawString("Speed : " + String.valueOf(tetris.getLevel()), scorePointX, scorePointY + 40);
    }


    private void drawBlock(Graphics g, Tetromino block, int startX, int startY, int blockWidth, int blockHeight) {
        int i = 0, j = 0;
        int[][] ablock = block.getBlock();
        int sw = block.getWidth();
        int sh = block.getHeight();
        int sx = block.getX();
        int sy = block.getY();
        int sType = block.getType();

        for (i = 0; i < sw; i++) {
            for (j = 0; j < sh; j++) {
                if (ablock[j][i] != Tetris.EMPTY) {
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
        int sType = block.getType();

        for (i = 0; i < sw; i++) {
            for (j = 0; j < sh; j++) {
                if (ablock[j][i] != Tetris.EMPTY) {
                    drawShadowRectangle(g, startX + (sx + i) * blockWidth,
                            startY + (sy + j) * blockHeight, sType, blockWidth, blockHeight);
                }
            }
        }
    }

    private void drawRectangle(Graphics g, int x, int y, int type, int blockWidth, int blockHeight)
    {
        Color colors[] = { new Color(102, 102, 102), new Color(255, 102, 0),
                new Color(255, 255, 51), new Color(0, 204, 51),
                new Color(0, 51, 204), new Color(0, 0, 102),
                new Color(102, 0, 102), new Color(204, 0, 0)
        };
        // GRAY 666666 , ORANGE FF6600 , YELLOW FFFF33 , GREEN 00CC33 , BLUE 0033CC, INDIGO 000066
        // PUPLE 660066, RED CC0000
        
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
        Color colors[] = { new Color(102, 102, 102), new Color(255, 102, 0),
                new Color(255, 255, 51), new Color(0, 204, 51),
                new Color(0, 51, 204), new Color(0, 0, 102),
                new Color(102, 0, 102), new Color(204, 0, 0)
        };
        // GRAY 666666 , ORANGE FF6600 , YELLOW FFFF33 , GREEN 00CC33 , BLUE 0033CC, INDIGO 000066
        // PUPLE 660066, RED CC0000

        Color color = colors[type];

        g.setColor(color);
//        g.fillRect(x + 1, y + 1, blockWidth - 2, blockHeight - 2);

        g.setColor(color.brighter());
        g.drawLine(x, y + blockHeight - 1, x, y);
        g.drawLine(x, y, x + blockWidth - 1, y);

//        g.setColor(color.darker());
        g.drawLine(x + 1, y + blockHeight - 1,
                x + blockWidth - 1, y + blockHeight - 1);
        g.drawLine(x + blockWidth - 1, y + blockHeight - 1,
                x + blockWidth - 1, y + 1);
    }

}