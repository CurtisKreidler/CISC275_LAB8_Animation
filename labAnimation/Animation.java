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
	    BufferedImage[] pics1;
	    BufferedImage[] pics2;
	    BufferedImage[] pics3;
	    BufferedImage[] pics4;
	    BufferedImage[] pics5; //variables for the the pics array that hold the subimages
	    BufferedImage[] pics6;
	    BufferedImage[] pics7;
	    BufferedImage[] pics8;
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
	    boolean left = false;// booleans for movement in certain direction
	    BufferedImage[] orcStuff;

	    //Override this JPanel's paint method to cycle through picture array and draw images
	    public void paint(Graphics g) {
	    	picNum = (picNum + 1) % frameCount;
	    	
	    	if(up && right){
	    	g.drawImage(pics3[picNum], xloc+=xIncr, yloc-=yIncr, Color.gray, this);
	    	}
	    	
	    	if(up && left){
		    	g.drawImage(pics4[picNum], xloc-=xIncr, yloc-=yIncr, Color.gray, this);
		    	}
	    	
	    	if(down && right){
		    	g.drawImage(pics1[picNum], xloc+=xIncr, yloc+=yIncr, Color.gray, this);
		    	}
	    	
	    	 if(down && left){
		    	g.drawImage(pics2[picNum], xloc-=xIncr, yloc+=yIncr, Color.gray, this);
		    	} //these  statements determine how it the orc moves/ is drawn on screen
	    	

	    		if(xloc >= frameWidth - imgWidth){
	    		left = true;
	    		right = false;
	    		}

	    		
	    		if(xloc <= 0){
		    	right = true;
		    	left = false;
		    		}
	    		
	    		
	    		if(yloc >= frameHeight - imgHeight){
	    		up = true;
	    		down = false;
	    		}

	    		

	    		if(yloc <= 0){
	    		down = true;
	    		up = false; 
	    		}//these statements change the direction the orc travels if it steps over the frame.
					 	
				
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
	    	BufferedImage img = createImage();
	    	
	    	pics1 = new BufferedImage[10];
	    	for(int i = 0; i < frameCount; i++)
	    		pics1[i] = orcStuff[1].getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
	    
	    	pics2 = new BufferedImage[10];
	    	for(int i = 0; i < frameCount; i++)
	    		pics2[i] = orcStuff[2].getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
	    	
	    	pics3 = new BufferedImage[10];
	    	for(int i = 0; i < frameCount; i++)
	    		pics3[i] = orcStuff[3].getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
	    	
	    	pics4 = new BufferedImage[10];
	    	for(int i = 0; i < frameCount; i++)
	    		pics4[i] = orcStuff[4].getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
	    	
	    	pics5 = new BufferedImage[10];
	    	for(int i = 0; i < frameCount; i++)
	    		pics5[i] = orcStuff[5].getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
	    	
	    	pics6 = new BufferedImage[10];
	    	for(int i = 0; i < frameCount; i++)
	    		pics6[i] = orcStuff[6].getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
	    	
	    	pics7 = new BufferedImage[10];
	    	for(int i = 0; i < frameCount; i++)
	    		pics7[i] = orcStuff[7].getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
	    	
	    	pics8 = new BufferedImage[10];
	    	for(int i = 0; i < frameCount; i++)
	    		pics8[i] = orcStuff[8].getSubimage(imgWidth*i, 0, imgWidth, imgHeight); //pic1-8 cut up the pics into subpics for animating
	    	
	    	// TODO: Change this constructor so that at least eight orc animation pngs are loaded
	    }  
	    
	    //Read image from file and return
	    private BufferedImage createImage(){
	    	BufferedImage bufferedImage;
	    	orcStuff = new BufferedImage[9];
	    	try {
	    		bufferedImage = ImageIO.read(new File("orc_animation/orc_forward_southeast.png"));
	    		orcStuff[1] = ImageIO.read(new File("orc_animation/orc_forward_southeast.png"));
	    		orcStuff[2] = ImageIO.read(new File("orc_animation/orc_forward_southwest.png"));
	    		orcStuff[3] = ImageIO.read(new File("orc_animation/orc_forward_northeast.png"));
	    		orcStuff[4] = ImageIO.read(new File("orc_animation/orc_forward_northwest.png"));
	    		orcStuff[5] = ImageIO.read(new File("orc_animation/orc_forward_south.png"));
	    		orcStuff[6] = ImageIO.read(new File("orc_animation/orc_forward_east.png"));
	    		orcStuff[7] = ImageIO.read(new File("orc_animation/orc_forward_west.png"));
	    		orcStuff[8] = ImageIO.read(new File("orc_animation/orc_forward_north.png"));//reads all 8 images into an array pushed to the animation method
	    		return bufferedImage;
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    	return null;
	    	
	    	// TODO: Change this method so you can load other orc animation bitmaps
	    }
	}
