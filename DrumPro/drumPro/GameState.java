package drumPro;

public abstract class GameState {

	public boolean blockDraw = true;
	public boolean blockUpdate = true;
	
	abstract void Update();
	abstract void Draw();	
}
