// Frame Imports
import java.awt.Canvas;
import java.awt.JFrame;

/**
 * @author Zachary Stroud
 * @version 1.0
 */
public class Core extends Canvas{
	public static final long serialVersionUID = 1L;
	
	public static int WIDTH,HEIGHT;
	public static int FPS;
	
	public Core(int w, int h, int fps){
		WIDTH = w;
		HEIGHT = h;
		FPS = fps;
	}
	
	public void start(){
		
	}
	
	public void init(){
		
	}
	
	public static void main(String[] args){
		// Args format: <int:width> <int:height>
		
		int w,h,fps;
		if(args.length >= 2){
			w = Integer.parseInt(args[0]);
			h = Integer.parseInt(args[1]);
		} else {
			w = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
			h = (int)java.awt.ToolKit.getDefaultToolkit().getScreenSize().getHeight();
		}
		
		if(args.length >= 3){
			fps = Integer.parseInt(args[2]);
		} else {
			fps = 60;
		}
		Core core = new Core(w,h,fps);
		
		Dimension frameSize = new Dimension(w,h);
		core.setMinimumSize(frameSize);
		core.setPreferredSize(frameSize);
		core.setMaximumSize(frameSize);
		
		JFrame f = new JFrame();
		f.setDefaultCloseOperation();
		
		f.setResizable(false);
		f.setUndecorated( args.length < 2 );
		
		f.add(core);
		f.pack();
		
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		core.start();
	}
	
}
