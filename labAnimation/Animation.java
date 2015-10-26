	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.image.BufferedImage;
	import java.io.File;
	import java.io.IOException;
	import javax.imageio.ImageIO;
	import javax.swing.JFrame;
	import javax.swing.JPanel;

	public class Animation extends JPanel {

	    final int frameCount = 10;
	    int picNum = 0;
	    BufferedImage[] pics;
	    BufferedImage[] kyle;
	    int xloc = 0;
	    int yloc = 0;
	    final int xIncr = 8;
	    final int yIncr = 2;
	    final static int frameWidth = 500;
	    final static int frameHeight = 300;
	    final static int imgWidth = 165;
	    final static int imgHeight = 165;
	    boolean up = false;
	    boolean down = true;
	    boolean right = true;
	    boolean left = false;
	    boolean changeDirection = false;

	    //Override this JPanel's paint method to cycle through picture array and draw images
	    public void paint(Graphics g) {
	    	picNum = (picNum + 1) % frameCount;
	    	
	    	if(up && right){
	    	g.drawImage(pics[picNum], xloc+=xIncr, yloc-=yIncr, Color.gray, this);
	    	}
	    	
	    	if(up && left){
		    	g.drawImage(pics[picNum], xloc-=xIncr, yloc-=yIncr, Color.gray, this);
		    	}
	    	
	    	if(down && right){
		    	g.drawImage(pics[picNum], xloc+=xIncr, yloc+=yIncr, Color.gray, this);
		    	}
	    	
	    	if(down && left){
		    	g.drawImage(pics[picNum], xloc-=xIncr, yloc+=yIncr, Color.gray, this);
		    	}
	    	

	    		if(xloc >= frameWidth - imgWidth){
	    		left = true;
	    		right = false;
	    		changeDirection = true;	
			}

	    		
	    		if(xloc <= 0 - 20){
		    	right = true;
		    	left = false;
		    	changeDirection = true;
			}
	    		
	    		
	    		if(yloc >= frameHeight - imgHeight){
	    		up = true;
	    		down = false;
	    		changeDirection = true;
			}

	    		
			//20 are used to adjust where the picture bounces from
	    		if(yloc <= 0 - 20){
	    		down = true;
	    		up = false; 
	    		changeDirection = true;
			}
					 	
				
		// TODO: Keep the orc from walking off-screen, turn around when bouncing off walls.
			//Be sure that animation picture direction matches what is happening on screen.
		
	}
	    //Make frame, loop on repaint and wait
	    public static void main(String[] args) {
	    	JFrame frame = new JFrame();
    
		frame.getContentPane().add(new Animation());
	    	frame.setBackground(Color.gray);
	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	frame.setSize(frameWidth, frameHeight);
	    	frame.setVisible(true);

		for(int i = 0; i < 1000; i++){
	    		frame.repaint();
	    		try {
	    			Thread.sleep(50);
	    		} catch (InterruptedException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    }

	    //Constructor: get image, segment and store in array
	    public Animation(){
		System.out.print("-flag");
		BufferedImage img = createImage();	
		pics = new BufferedImage[10];
		for(int i = 0; i < frameCount; i++)
	    		pics[i] = img.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
	    	
	    	// TODO: Change this constructor so that at least eight orc animation pngs are loaded
	    }  
	    
	    //Read image from file and return
	    private BufferedImage createImage(){
	    	BufferedImage bufferedImage;
		kyle = new BufferedImage[5];
	
	    	try {
	    	for(int i= 1;i < 5; i++){
			bufferedImage = ImageIO.read(new File("orc_animation/"+ i +".png"));
			kyle[i] = bufferedImage;
	}    	
		if (up && left){
 			System.out.print("-flag");
			return kyle[2];}
		if (down && right){
			 System.out.print("-flag");
			return kyle[1];}
		if (up && right){
			 System.out.print("-flag");
			return kyle[3];}
		if (down && left){
			 System.out.print("-flag");
			return kyle[4];}
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    	return null;
	   	
             
            
            
	
	    	// TODO: Change this method so you can load other orc animation bitmaps
	    }
	}
