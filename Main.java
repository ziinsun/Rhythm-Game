package dynamic_beat;

public class Main {
	
	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;
	public static final int NOTE_SPEED = 3;
	public static final int SLEEP_TIME = 10; 
	// 노트가 무한정 떨어지는것이 아니게함
	public static final int REACT_TIME = 2;
	
	public static void main(String[] args) {
		new DynamicBeat();
		
	}
}
 