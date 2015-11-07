package ui.button;

// List Imports
import java.util.ArrayList;
import java.util.List;

public class ButtonManager{
	
	private List<Button> buttons;
	
	public ButtonManager(){
		buttons = new ArrayList<Button>();
	}
	
	public void addButton(Button b){
		buttons.add(b);
	}
	
	public void update(){
		for(int i = 0; i < buttons.size(); i++){
			buttons.get(i).update();
		}
	}
	
	public void render(java.awt.Graphics g){
		for(int i = 0; i < buttons.size(); i++){
			buttons.get(i).render(g);
		}
	}
	
	public String tryClick(){
		for(int i = buttons.size()-1; i >= 0; i--){
			if( buttons.get(i).isMouseOver() ){
				return buttons.get(i).getAction();
			}
		}
		return null;
	}
	
}
