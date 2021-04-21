package system;

import gameObject.MainCharacter;
import gameObject.ObjectState;
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
		ObjectState state = gameWorld.getCharacter().state;
		if (code.equals(KeyCode.ESCAPE)) {
			gameFrame.pauseGame();
		} else if (code.equals(KeyCode.UP)) {
			state.direct = ObjectState.UP;
			state.isGoUp = true;
			if (state.isGoDown) state.isGoDown = false;			
			if (state.isGoLeft || state.isGoRight) state.isGoCross = true;			
		} else if (code.equals(KeyCode.DOWN)) {
			state.direct = ObjectState.DOWN;
			state.isGoDown = true;
			if (state.isGoUp) state.isGoUp = false;			
			if (state.isGoLeft || state.isGoRight) state.isGoCross = true;
		} else if (code.equals(KeyCode.LEFT)) {
			state.direct = ObjectState.LEFT;
			state.isGoLeft = true;
			if (state.isGoRight) state.isGoRight = false;			
			if (state.isGoUp || state.isGoDown) state.isGoCross = true;
		} else if (code.equals(KeyCode.RIGHT)) {
			state.direct = ObjectState.RIGHT;
			state.isGoRight = true;
			if (state.isGoLeft) state.isGoLeft = false;			
			if (state.isGoUp || state.isGoDown) state.isGoCross = true;
		} else if (code.equals(KeyCode.SPACE)) {
			gameWorld.getCharacter().state.isUseKnife = true;			
		} else if (code.equals(KeyCode.ENTER)) {
			gameWorld.getCharacter().state.isUseGun = true;			
		}
	}
	public void SolveReleaseKey(KeyCode code) {
		ObjectState state = gameWorld.getCharacter().state;
		if (code.equals(KeyCode.ESCAPE)) {
//			gameFrame.pauseGame();
		} else if (code.equals(KeyCode.UP)) {
			state.isGoUp = false;
			state.isGoCross = false;
		} else if (code.equals(KeyCode.DOWN)) {
			state.isGoDown = false;
			state.isGoCross = false;
		} else if (code.equals(KeyCode.LEFT)) {
			state.isGoLeft = false;	
			state.isGoCross = false;
		} else if (code.equals(KeyCode.RIGHT)) {
			state.isGoRight = false;
			state.isGoCross = false;
		} else if (code.equals(KeyCode.SPACE)) {
			state.isUseKnife = false;				
		} else if (code.equals(KeyCode.ENTER)) {
			state.isUseGun = false;		
		}
	}
}
