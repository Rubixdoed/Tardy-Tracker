package ui.button;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ImageButton extends Button{
	
	private BufferedImage[] images;
	
	public ImageButton(int x, int y, int w, int h, String action, BufferedImage[] images) {
		super(x, y, w, h, action);
		this.images = images;
	}

	@Override
	public void render(Graphics g) {
		if( active ){
			if( mouseOver ){
				g.drawImage(images[0],x,y,null);
			} else {
				g.drawImage(images[1],x,y,null);
			}
		} else {
			g.drawImage(images[2],x,y,null);
		}
	}
	
}
