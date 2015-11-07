import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ImageLoader{
	
	public BufferedImage loadResource(String path){
		BufferedImage img = null;
		try{
			img = ImageIO.read( getClass().getResourceAsStream(path) );
		}catch(Exception e){
			e.printStackTrace();
		}
		return img;
	}
	
	public BufferedImage[] loadResourceArray(String path, int width){
		BufferedImage source = loadResource(path);
		
		int across = source.getWidth()/width;
		BufferedImage[] imgs = new BufferedImage[across];
		for(int i = 0; i < across; i++){
			imgs[i] = source.subimage(i*width,0,width,parent.getHeight());
		}
		return imgs;
	}
	
	public BufferedImage[] loadResourceArray2D(String path, int width, int height){
		BufferedImage source = loadResource(path);
		
		int across = source.getWidth()/width;
		int down = source.getHeight()/height;
		BufferedImage[] imgs = new BufferedImage[across*down];
		for(int i = 0; i < down; i++){
			for(int j = 0; j < across; j++){
				imgs[j + i*across] = parent.subimage(j*width, i*height, width, height);
			}
		}
		return imgs;
	}
	
}
