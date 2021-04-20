package system;

import javafx.event.EventType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import menu.GameFrame;

public class EventDistributor {
	public GameFrame gameFrame = null;
	private GameWorld gameWorld = null;
	public EventDistributor() {}
	public EventDistributor(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
		gameWorld = gameFrame.getGameWorld();
	}
	public void solve(MouseEvent e) {
		// todo
	}
	public void solve(KeyEvent e) {
		EventType<KeyEvent> type = e.getEventType();
		if (type.equals(KeyEvent.KEY_PRESSED)) {
			SolvePressKey(e.getCode());
		} else if (type.equals(KeyEvent.KEY_RELEASED)) {
			SolveReleaseKey(e.getCode());
		} else {
			// do nothing
		}
	}
	public void SolvePressKey(KeyCode code) {
		if (code.equals(KeyCode.ESCAPE)) {
			gameFrame.pauseGame();
		} else if (code.equals(KeyCode.UP)) {
//			GameWorld.character.state.isGoUp = true;
		} else if (code.equals(KeyCode.DOWN)) {
//			GameWorld.character.state.isGoDown = true;
		} else if (code.equals(KeyCode.LEFT)) {
//			GameWorld.character.state.isGoLeft = true;			
		} else if (code.equals(KeyCode.RIGHT)) {
//			GameWorld.character.state.isGoRight = true;			
		} else if (code.equals(KeyCode.SPACE)) {
//			GameWorld.character.state.isUseKnife = true;			
		} else if (code.equals(KeyCode.ENTER)) {
//			GameWorld.character.state.isUseGun = true;			
		}
	}
	public void SolveReleaseKey(KeyCode code) {
		if (code.equals(KeyCode.ESCAPE)) {
//			gameFrame.pauseGame();
		} else if (code.equals(KeyCode.UP)) {
//			GameWorld.character.state.isGoUp = false;	
		} else if (code.equals(KeyCode.DOWN)) {
//			GameWorld.character.state.isGoDown = false;	
		} else if (code.equals(KeyCode.LEFT)) {
//			GameWorld.character.state.isGoLeft = false;				
		} else if (code.equals(KeyCode.RIGHT)) {
//			GameWorld.character.state.isGoRight = false;				
		} else if (code.equals(KeyCode.SPACE)) {
//			GameWorld.character.state.isUseKnife = false;				
		} else if (code.equals(KeyCode.ENTER)) {
//			GameWorld.character.state.isUseGun = false;				
		}
	}
}
