package system;

import gameObject.GameWorld;
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
		ObjectState state = gameWorld.getCharacter().getState();
		if (code.equals(KeyCode.ESCAPE)) {
			gameFrame.pauseGame();
			state.setStandStill();
		} else if (code.equals(KeyCode.UP)) {
			state.setGo(ObjectState.UP);	
		} else if (code.equals(KeyCode.DOWN)) {
			state.setGo(ObjectState.DOWN);
		} else if (code.equals(KeyCode.LEFT)) {
			state.setGo(ObjectState.LEFT);
		} else if (code.equals(KeyCode.RIGHT)) {
			state.setGo(ObjectState.RIGHT);
		} else if (code.equals(KeyCode.SPACE)) {
			gameWorld.getCharacter().useKnife();			
		} else if (code.equals(KeyCode.ENTER)) {
			gameWorld.getCharacter().useGun();			
		}
	}
	public void SolveReleaseKey(KeyCode code) {
		ObjectState state = gameWorld.getCharacter().getState();
		if (code.equals(KeyCode.ESCAPE)) {
//			gameFrame.pauseGame();
		} else if (code.equals(KeyCode.UP)) {
			state.isGoUp = false;
		} else if (code.equals(KeyCode.DOWN)) {
			state.isGoDown = false;
		} else if (code.equals(KeyCode.LEFT)) {
			state.isGoLeft = false;	
		} else if (code.equals(KeyCode.RIGHT)) {
			state.isGoRight = false;
		} else if (code.equals(KeyCode.SPACE)) {
			state.isUseKnife = false;				
		} else if (code.equals(KeyCode.ENTER)) {
			state.isUseGun = false;		
		}
	}
}
