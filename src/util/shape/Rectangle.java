package util.shape;

public class Rectangle {
	
	private double x,y;
	private double w,h;
	
	public Rectangle(double x, double y, double w, double h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public double getX(){return x;}
	public void setX(double x){this.x = x;}
	
	public double getY(){return y;}
	public void setY(double y){this.y = y;}
	
	public double getW(){return w;}
	public void setW(double w){this.w = w;}
	
	public double getH(){return h;}
	public void setH(double h){this.h = h;}
	
}
