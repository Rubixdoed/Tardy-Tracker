package util;

import util.shape.Rectangle;
import util.shape.Point2D;

public class CollisionUtils{
	
	public static boolean pointInRectangle(double px, double py, double x, double y, double w, double h){
		return px >= x && px < x+w && py >= y && py < y+h;
	}
	
	public static boolean pointInRectangle(double x, double y, Rectangle rectangle){
		return x >= rectangle.getX() && x < rectangle.getX() + rectangle.getW() && y >= rectangle.getY() && y < rectangle.getY() + rectangle.getH();
	}
	
	public static boolean pointInRectangle(Point2D point, Rectangle rectangle){
		return point.getX() >= rectangle.getX() && point.getX() < rectangle.getX() + rectangle.getW() && point.getY() >= rectangle.getY() && point.getY() < rectangle.getY() + rectangle.getH();
	}
	
}
