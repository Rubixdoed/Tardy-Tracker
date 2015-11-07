package ui.button;

import input.Inputs;
import util.CollisionUtils;

public abstract class Button{
	
	protected int x,y;
	protected int w,h;
	protected String action;
	
	protected boolean mouseOver,active;
	
	public Button(int x, int y, int w, int h, String action){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.action = action;
	}
	
	public void setActive(boolean active){
		this.active = active;
	}
	public void toggleActive(){
		active = !active;
	}
	
	public void update(){
		mouseOver = CollisionUtils.pointInRectangle(Inputs.xMouse,Inputs.yMouse,x,y,w,h);
	}
	
	public abstract void render(java.awt.Graphics g);
	
	public boolean isMouseOver(){
		return mouseOver && active;
	}
	public boolean isActive(){
		return active;
	}
	
	public String getAction(){
		return action;
	}
	
}
