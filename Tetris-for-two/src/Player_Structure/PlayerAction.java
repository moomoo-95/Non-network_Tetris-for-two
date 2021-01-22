package Player_Structure;

import java.awt.event.KeyEvent;

import Tetris_Structure.TetrisLog;

public class PlayerAction implements ItfacePlayerAction {
	ItfacePlayer player = null;
	
	public void onKeyEvent(int k) {
		TetrisLog.d("Player Press key :" + k);
		
		if (player ==null) {
			return;
		}
		
		if (player.isIdleState()) {
            if (k == 's' || k == 'S'){
                System.out.println("Start!");
                player.play();
            }
            return;
        }

        if (player.isGameOverState()) {
            if (k == 's' || k == 'S'){
                player.init();
            }
            return;
        }

        if (player.isPauseState()) {
            if (k =='p' || k == 'P'){
                player.resume();
            }
            return;
        }

        if (player.isPlayState() == false) {
            return;
        }
		
        switch (k) {
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
	

    public void setPlayer(ItfacePlayer player) {
        this.player = player;
    }
}