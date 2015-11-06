public abstract class State{
	
	protected GameStateManager gsm;
	public State(GameStateManager gsm){
		this.gsm = gsm;
	}
	
	public abstract void init(String[] args);
	public abstract void update(double time);
	public abstract void render(java.awt.Graphics g);
	
	public abstract void keyPress(char c);
	public abstract void mouseClick();
	public abstract void mouseScroll(int dir);
	
}
