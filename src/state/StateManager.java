package state;

// List Imports
import java.util.List;
import java.util.ArrayList;

/**
 * @author Zachary Stroud
 * @version 1.0
 */
public class StateManager{
	
	private List<State> states;
	private int current;
	
	public static final int STATE_MAINMENUSTATE = 0;
	
	public StateManager(){
		states = new ArrayList<State>();
		
		states.add(new MainMenuState(this));
		
		setState(0,new String[]{});
	}
	
	public void update(double time){
		states.get(current).update(time);
	}
	
	public void render(java.awt.Graphics g){
		states.get(current).render(g);
	}
	
	public void keyPress(char c){
		states.get(current).keyPress(c);
	}
	
	public void mouseClick(){
		states.get(current).mouseClick();
	}
	
	public void mouseScroll(int dir){
		states.get(current).mouseScroll(dir);
	}
	
	
	public void setState(int state){
		if(state >= 0 && state < states.size()){
			current = state;
		}
	}
	public void setState(int state, String[] args){
		if(state >= 0 && state < states.size()){
			current = state;
			states.get(current).init(args);
		}
	}
	
	public void nextState(){
		current += 1;
		current %= states.size();
	}
	public void nextState(String[] args){
		current += 1;
		current %= states.size();
		states.get(current).init(args);
	}
	
	public void prevState(){
		current += states.size() - 1;
		current %= states.size();
	}
	public void prevState(String[] args){
		current += states.size() - 1;
		current %= states.size();
		states.get(current).init(args);
	}
	
}
