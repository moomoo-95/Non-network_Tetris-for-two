package player;

import java.awt.event.KeyEvent;

import tetris.TetrisLog;

public class PlayerAction implements IPlayerAction {
   IPlayer player = null;

    public void onKeyEvent(int keycode) {
    	TetrisLog.d("PlayerAction.onKeyEvent() = " + keycode);

        if (player == null) {
            return;
        }

        if (player.isIdleState()) {
            if (keycode == 's' || keycode == 'S'){
            	TetrisLog.d("PlayerAction.onKeyEvent() = Start");
                player.play();
            }
            return;
        }

        if (player.isGameOverState()) {
            if (keycode == 's' || keycode == 'S'){
            	TetrisLog.d("PlayerAction.onKeyEvent() = Reset");
                player.init();
            }
            return;
        }

        if (player.isPauseState()) {
            if (keycode =='p' || keycode == 'P'){
            	TetrisLog.d("PlayerAction.onKeyEvent() = Pause");
                player.resume();
            }
            return;
        }

        if (player.isPlayState() == false) {
            return;
        }

        switch (keycode) {
            case KeyEvent.VK_LEFT:
                player.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                player.moveRight();
                break;
            case KeyEvent.VK_DOWN:
                player.moveDown();
                break;
            case KeyEvent.VK_UP:
                player.rotate();
                break;
            case KeyEvent.VK_SPACE:
                player.moveBottom();
                break;
            case 'H':
            case 'h':
                if (player.isEnableShadow()) {
                    player.disableShadow();
                } else {
                    player.enableShadow();
                }
                break;
            case 'p':
            case'P':
                player.pause();
                break;
        }
    }

    public void setPlayer(IPlayer player) {
        this.player = player;
    }

}