package main;

// Frame Imports
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

// Render Imports
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;

import state.StateManager;

/**
 * @author Zachary Stroud
 * @version 1.0
 */
public class Core extends Canvas{
	public static final long serialVersionUID = 1L;
	
	public static int WIDTH,HEIGHT;
	public static int FPS;
	public static boolean running;
	
	public static boolean DEBUG;
	private double FPS_TIMER;
	private int FPS_COUNT,FPS_DISPLAY;
	
	private long lastUpdate;
	
	private BufferedImage frame;
	private Graphics g;
	
	private StateManager sm;
	
	public Core(int w, int h, int fps){
		WIDTH = w;
		HEIGHT = h;
		FPS = fps;
	}
	
	public void start(){
		init();
		run();
	}
	
	public static void stop(){
		running = false;
		// exit code
	}
	
	public void init(){
		frame = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		g = frame.getGraphics();
		
		sm = new StateManager();
	}
	
	public void run(){
		long startTime,updateTime;
		int FPS = 1000/Core.FPS;
		
		lastUpdate = System.nanoTime();
		running = true;
		while(running){
			startTime = System.nanoTime();
			
			update();
			render();
			draw();
			
			updateTime = (System.nanoTime() - startTime)/1000000;
			if(FPS - updateTime > 0){
				try{
					Thread.sleep(FPS - updateTime);
				} catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void update(){
		double time = (System.nanoTime() - lastUpdate)/1000000.0;
		lastUpdate = System.nanoTime();
		
		sm.update(1.0); // default value
		
		if(DEBUG){
			FPS_TIMER += time;
			if(FPS_TIMER >= 1000){
				FPS_TIMER %= 1000;
				FPS_DISPLAY = FPS_COUNT;
				FPS_COUNT = 0;
				System.out.println("FPS: " + FPS_DISPLAY);
			}
		}
	}
	
	public void render(){
		sm.render(g);
	}
	
	public void draw(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(2);
			return;
		}
		
		Graphics dg = bs.getDrawGraphics();
		dg.drawImage(frame,0,0,null);
		dg.dispose();
		
		bs.show();
	}
	
	public void keyPress(char c){
		sm.keyPress(c);
	}
	public void mouseClick(){
		sm.mouseClick();
	}
	public void mouseScroll(int dir){
		sm.mouseScroll(dir);
	}
	
	public static void main(String[] args){
		// args format: <int:width> <int:height> <int:fps>
		
		int w,h,fps;
		if(args.length >= 2){
			w = Integer.parseInt(args[0]);
			h = Integer.parseInt(args[1]);
		} else {
			w = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
			h = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
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
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setResizable(false);
		f.setUndecorated( args.length < 2 );
		
		f.add(core);
		f.pack();
		
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		core.start();
	}
	
}
