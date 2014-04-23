import javax.imageio.ImageIO;
<<<<<<< HEAD
=======
import javax.swing.ImageIcon;
>>>>>>> d0faac1a8918d73e1e2e45df72a42c59471ed6c6
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
<<<<<<< HEAD
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
=======
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
<<<<<<< HEAD
import javax.swing.Timer;

import java.awt.AWTException;
=======
import javax.swing.BorderFactory;

>>>>>>> master
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
<<<<<<< HEAD
import java.awt.Rectangle;
>>>>>>> d0faac1a8918d73e1e2e45df72a42c59471ed6c6
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Iterator;
import java.util.Random;

/**
 * 
 * @author Nate Ashby
 * 
 * 	The GUI does everything that the user
 * 	sees or notices. It paints the system,
 * 	and takes the user interaction with the
 *  mouse to create new bodies, and to 
 *  change different settings.
 *
 */
=======
>>>>>>> d0faac1a8918d73e1e2e45df72a42c59471ed6c6

public class GUI {
	
	/** Set up the Frame and Menu Bar **/
    public static void createAndShowGUI() {
        JFrame f = new JFrame("Gravity");
        JMenuBar menubar = new JMenuBar();
<<<<<<< HEAD
        JMenu file;
		final JMenu edit;
		JMenu help, changeMode;
=======
        JMenu file,edit,help,changeMode;
>>>>>>> d0faac1a8918d73e1e2e45df72a42c59471ed6c6
        
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");
<<<<<<< HEAD
        changeMode = new JMenu("Load...");
=======
        changeMode = new JMenu("Change Mode...");
>>>>>>> d0faac1a8918d73e1e2e45df72a42c59471ed6c6
        
        JMenuItem changeSettings = new JMenuItem("Change Settings...");
        JMenuItem voidofSpace = new JMenuItem("Black Void");
        JMenuItem cloud = new JMenuItem("Gas Cloud");
        JMenuItem solar = new JMenuItem("Solar System");
<<<<<<< HEAD
        JMenuItem blackHole = new JMenuItem("Black Hole");
        JMenuItem saveImage = new JMenuItem("Save Screen as Image");
        JMenuItem fastForward = new JMenuItem("Speed Up Time");
        JMenuItem slowDown	= new JMenuItem("Slow Down Time");
        final JMenuItem pause = new JMenuItem("Pause");
        final JMenuItem resume = new JMenuItem("Resume");
        final JMenuItem enableReplace = new JMenuItem("Enable Replacement");
        final JMenuItem disableReplace = new JMenuItem("Disable Replacement");
=======
        JMenuItem galaxy = new JMenuItem("Galaxy");
        JMenuItem saveImage = new JMenuItem("Save Screen as Image");
        JMenuItem fastForward = new JMenuItem("Speed Up Time");
        JMenuItem slowDown	= new JMenuItem("Slow Down Time");
        JMenuItem pause = new JMenuItem("Pause");
        JMenuItem resume = new JMenuItem("Resume");
>>>>>>> d0faac1a8918d73e1e2e45df72a42c59471ed6c6
        JMenuItem howto = new JMenuItem("How To...");
        JMenuItem about = new JMenuItem("About"); 
        
        changeMode.add(voidofSpace);
        changeMode.add(cloud);
        changeMode.add(solar);
<<<<<<< HEAD
        changeMode.add(blackHole);
=======
        changeMode.add(galaxy);
>>>>>>> d0faac1a8918d73e1e2e45df72a42c59471ed6c6
        file.add(saveImage);
        file.add(changeMode);
        edit.add(changeSettings);
        edit.add(fastForward);
        edit.add(slowDown);
        edit.add(pause);
<<<<<<< HEAD
        edit.add(disableReplace);
=======
        edit.add(resume);
>>>>>>> d0faac1a8918d73e1e2e45df72a42c59471ed6c6
        help.add(howto);
        help.add(about);
        menubar.add(file);
        menubar.add(edit);
        menubar.add(help);
        f.setJMenuBar(menubar);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final MyPanel pane = new MyPanel();
        f.add(pane);
        pane.setBackground(Color.black);
        f.pack();
        f.setVisible(true);
        
        /** Load the void of space loadout **/
        voidofSpace.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					MyPanel.clear();
<<<<<<< HEAD
					MyPanel.loadVoid();
=======
>>>>>>> d0faac1a8918d73e1e2e45df72a42c59471ed6c6
			}
    	});
        
        /** Load the Gas Cloud loadout **/
        cloud.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					MyPanel.clear();
					MyPanel.loadGas();
			}
    	});
        
        /** Load the Solar System loadout **/
        solar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					MyPanel.clear();
					MyPanel.loadSolar();
			}
    	});
        
<<<<<<< HEAD
        /** Load the blackHole loadout **/
        blackHole.addActionListener(new ActionListener(){
=======
        /** Load the Galaxy loadout **/
        galaxy.addActionListener(new ActionListener(){
>>>>>>> d0faac1a8918d73e1e2e45df72a42c59471ed6c6
			@Override
			public void actionPerformed(ActionEvent e) {
					MyPanel.clear();
					MyPanel.loadGalaxy();
			}
    	});
        
        /** If the Save Screen as image is clicked**/
        saveImage.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						/** Write the screen to an image file. **/
						File file = new File("Gravity ScreenShot.png");
<<<<<<< HEAD
						int i = 1;
						while(file.exists()){
							file = new File("Gravity ScreenShot(" + i++ + ").png");
						}
						file.createNewFile();
=======
							if (!file.exists())
							file.createNewFile();
>>>>>>> d0faac1a8918d73e1e2e45df72a42c59471ed6c6
						BufferedImage image = new Robot().createScreenCapture(new Rectangle(pane.getLocationOnScreen().x, pane.getLocationOnScreen().y, pane.getWidth(), pane.getHeight()));
						ImageIO.write(image, "png", file);
						
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (AWTException e1) {
						e1.printStackTrace();
					}
			}
    	});
        
        /** Create a Panel to change clickSize, clickMass**/
        changeSettings.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			  MyPanel.time.stop();
			  JPanel p = new JPanel();
			  JTextField size = new JTextField(10);
			  JTextField mass = new JTextField(10);

			  p.add(new JLabel("Size: "));
			  p.add(size);
			  p.add(new JLabel("Mass: "));
			  p.add(mass);

			  JOptionPane.showConfirmDialog(null, p, "Change Creation Settings ", JOptionPane.OK_CANCEL_OPTION);
			  String buffer = size.getText();
			  if(buffer.isEmpty())
				  buffer = "1";
<<<<<<< HEAD
			  //If the user is being dumb, get after them, and resume the sim.
			  try{
				  if(0<Double.valueOf(buffer))
					  MyPanel.clickSize = Integer.valueOf(buffer);
				  buffer = mass.getText();
				  if(buffer.isEmpty())
					  buffer = "1";
				  MyPanel.clickMass = Integer.valueOf(buffer);
				  MyPanel.time.start();
			  }catch(NumberFormatException error){
				  JOptionPane.showMessageDialog(p, "Please input non-negative integers for creation settings");
				  MyPanel.time.start();
			  }
			}
=======
			  if(0<Double.valueOf(buffer))
				  MyPanel.clickSize = Integer.valueOf(buffer);
			  buffer = mass.getText();
			  if(buffer.isEmpty())
				  buffer = "1";
			  MyPanel.clickMass = Integer.valueOf(buffer);
			  MyPanel.time.start();
			}
=======
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;

public class GUI {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
>>>>>>> master
>>>>>>> d0faac1a8918d73e1e2e45df72a42c59471ed6c6
        });
        
        /** Make the updateClockAction run more frequently **/
        fastForward.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					MyPanel.time.setDelay(MyPanel.time.getDelay() / 4);
			}
    	});
        
        /** Make the updateClockAction run less frequently **/
        slowDown.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MyPanel.time.setDelay(MyPanel.time.getDelay() * 4);
			}
    	});
        
        /** Stop the timer, and pause the simulation **/
        pause.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MyPanel.time.stop();
<<<<<<< HEAD
		        //Switch the pause and resume options depending
		        //on the state of the panel
		        edit.add(resume);
		        edit.remove(pause);
=======
>>>>>>> d0faac1a8918d73e1e2e45df72a42c59471ed6c6
			}
    	});
        
        /** Start the timer and resume the simulation **/
        resume.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MyPanel.time.start();
<<<<<<< HEAD
				edit.add(pause);
		        edit.remove(resume);
			}
    	});
        
        /** Disable the infinite body replacement **/
        disableReplace.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MyPanel.setReplace(false);
				edit.remove(disableReplace);
		        edit.add(enableReplace);
			}
    	});
        
        /** Enable the infinite body replacement **/
        enableReplace.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MyPanel.setReplace(true);
				edit.add(disableReplace);
		        edit.remove(enableReplace);
=======
>>>>>>> d0faac1a8918d73e1e2e45df72a42c59471ed6c6
			}
    	});
        
        /** Display the Instructions **/
        howto.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//Pause the Sim
				MyPanel.time.stop();
				
				 //Create All of the Instruction Panels
				  JPanel p1 = new JPanel();
				  String settings = "Change Settings:<br><br>"+
						    "To change the settings of each created Body go to: <br>" +
						    "Edit -> Change Settings... <br> and set the desired mass and size." +
							"The speed and position of each body is determined by where your"+
						    " mouse moves when you click, and places the body where your mouse is when you release.";
				  p1.add(new JLabel("<html><body><p style='width: 250px;'>"+ settings + "</body></html>"));
<<<<<<< HEAD
				  
=======
>>>>>>> d0faac1a8918d73e1e2e45df72a42c59471ed6c6
				  JPanel p2 = new JPanel();
				  String Fun = "Have Fun!:<br><br>"+
						    "Have fun experimenting with gravity!";
				  p2.add(new JLabel("<html><body><p style='width: 250px;'>"+ Fun + "</body></html>"));
				  
<<<<<<< HEAD
				  JPanel p3 = new JPanel();
				  String Help = "Not Moving?:<br><br>"+
						    "Click the speed up option a few times," + 
						  "sometimes things are just moving slow!";
				  p3.add(new JLabel("<html><body><p style='width: 250px;'>"+ Help + "</body></html>"));
				  
				  //And add them to a tabbed pane to make it pretty
				  JTabbedPane tPane = new JTabbedPane();
				  tPane.addTab("Help", p3);
				  tPane.addTab("Settings",p1);
				  tPane.addTab("Fun", p2);

				  JOptionPane.showConfirmDialog(null, tPane, "Help: How to ", JOptionPane.OK_CANCEL_OPTION);
=======
				  //And add them to a tabbed pane to make it pretty
				  JTabbedPane tPane = new JTabbedPane();
				  tPane.addTab("Fun", p2);
				  tPane.addTab("Settings",p1);

				  JOptionPane.showConfirmDialog(null, tPane, "Change Creation Settings ", JOptionPane.OK_CANCEL_OPTION);
>>>>>>> d0faac1a8918d73e1e2e45df72a42c59471ed6c6
				  
				  //Then resume the Sim
				  MyPanel.time.start();
			}
        });
        
        /** Open the about JOptionPane and talk about 
               how great I am                         **/
        about.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String output = "Gravity is the coolest dang physics simulator that "+
					    "you ever did see. If you need instructions, refer " +
					    "to the help menu." +
						"<br><br>Program Deity: Nate Ashby	A01383689";
				JOptionPane.showMessageDialog(pane,
						"<html><body><p style='width: 250px;'>"+ output + "</body></html>",
					    "About",
					    JOptionPane.INFORMATION_MESSAGE);
			}
    	});
    } 
}


class MyPanel extends JPanel implements MouseListener{
	public static int clickSize = 5, clickMass = 10;
<<<<<<< HEAD
	private static double clickVelX = 0, clickVelY = 0, calcX, calcY;
	private static long calcT;
	private static Color clickColor = Color.white;
	public static Timer time;
	public enum mode {start,thevoid,cloud,solar,hole};
	private static mode gameMode;
	private static int timerInt = 50;
	private static boolean title = true,replacement = true;
	static ArrayList <Body> system = new ArrayList<Body>();
    public MyPanel() {
    	addMouseListener(this);
    	gameMode = mode.start;
    	add(new Body(10000,40,Color.yellow,0,0,300,300));
        add(new Body(10,10,Color.CYAN,.6,0,300,175));
=======
	public static double clickVelX = 0, clickVelY = 0, calcX, calcY;
	public static long calcT;
	public static Color clickColor = Color.white;
	public static Timer time;
	private static int timerInt = 50;
	static ArrayList <Body> system = new ArrayList<Body>();
    public MyPanel() {
    	addMouseListener(this);
    	add(new Body(1000,20,Color.yellow,0,0,300,300));
        add(new Body(1,5,Color.white,.6,0,300,175));
        //add(new Body(10,5,Color.red,-1,0,400,400));
>>>>>>> d0faac1a8918d73e1e2e45df72a42c59471ed6c6
        
        
        /** Add a Timer to run everything in specific intervals, that 
         * can be changed 
         */
        ActionListener updateClockAction = new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    	    	repaint();
    	    	physics.calculateChanges(system);
<<<<<<< HEAD
    	    	
    	    	/** If any of the bodies are incredibly far away with no hope of 
    	    	 * returning to the screen, then delete them for memory cleanup. 
    	    	 * And add a random body that might interact with the bodies on the screen. **/
    	    	boolean removedABody = false;
    	    	
    	    	//Use an iterator to prevent ConcurrentModificationExceptions
    	    	Iterator<Body> iter = system.iterator();
    	    	while (iter.hasNext()) {
    	    		Body b = iter.next();
    	    		if(b.getposx() > 1500 || b.getposx() < -900 
    	    				|| b.getposy() > 1500 || b.getposy() < -900){
    	    			iter.remove();
    	    			removedABody = true;
    	    			}
    	    		}
    	    	if(removedABody){
    	    		replace();
    	    		}
=======
>>>>>>> d0faac1a8918d73e1e2e45df72a42c59471ed6c6
    		    }	
    		};
        	time = new Timer(timerInt, updateClockAction);
        	time.start();
        	
  
    }
<<<<<<< HEAD
    
   public static void add(Body b){system.add(b);}
   public static void clear(){system.clear();}
   public static void remove(Body b){system.remove(b);}
   public static mode getMode(){return gameMode;}
   public static void setReplace(boolean b){replacement = b;}
   public static void replace(){
	   if(replacement){
		   switch(gameMode){
		   case start:
			   add(randomBody(10,10,1));
			   break;
		   case thevoid:
			   add(randomBody(10,10,1));
			   break;
		   case cloud:
			   add(randomBody(1,1,.05));
			   break;
		   case solar:
			   add(randomBody(10,10,1));
			   break;
		   case hole:
			   add(randomBody(25,25,5));
			   break;
	   }
		}
   }
   
   /**Load the void layout **/
   public static void loadVoid(){
	   gameMode = mode.thevoid;
   }
   
   /** Load the Gas Cloud loudout **/
   public static void loadGas(){
	   /** Randomly create the gas cloud, max body size is 1 
	    * and max body mass is 1 and max speed is .05**/
	   gameMode = mode.cloud;
	   for(int i = 0; i < 75; i++){
	   system.add(randomBody(1,1,.05));
	   }
   }
   
   /** Load the Solar system loadout **/
   public static void loadSolar(){
	   gameMode = mode.solar;
   	Body Sun = new Body((int)(10000),20,Color.yellow,0,0,300,300);
   	Sun.setLocked(true);
   	Body Mercury = new Body((int)(5),2, Color.gray,1.1,0,300,255);
   	Body Venus = new Body((int)(9),2, Color.orange,-.7,0,300,375);
   	Body Earth = new Body((int)(10),2, Color.blue,.4,0,300,155);
   	Body Mars = new Body((int)(6),2, Color.red,-.3,0,300,555);
   	system.add(Sun);
   	system.add(Mercury);
   	system.add(Venus);
   	system.add(Earth);
   	system.add(Mars);
   }
   
   /** Load the Galaxy loadout **/
   public static void loadGalaxy(){
	   gameMode = mode.hole;
	   	/** Make a massive ass black body **/
	   	Body hole = new Body((int)(1000000),5,Color.black,0,0,300,300);
	   	hole.setLocked(true);
	   	system.add(hole);
		   /** Randomly create the gas cloud, max body size is 5 and max body mass is 5 and max speed is 5**/
		   for(int i = 0; i < 75; i++){
			   system.add(randomBody(5,5,0));
		   }
   }
   
   /** Create a random body in or close to being inside the screen. **/
   private static Body randomBody(int maxsize, int maxmass, double maxspeed){
	   Random rand = new Random();
	   	   int size = rand.nextInt(maxsize);
	   	   int mass = rand.nextInt(maxmass);
		   double vx = rand.nextDouble()*maxspeed*2-maxspeed;
		   double vy = rand.nextDouble()*maxspeed*2-maxspeed;
		   int px = rand.nextInt(600);
		   int py = rand.nextInt(600);
		   int r = rand.nextInt(255);
		   int g = rand.nextInt(255);
		   int b = rand.nextInt(255);
		   if(size < 1)
			   size = 1;
		   if(mass < 1)
			   mass = 1;
		   Body randB = new Body(mass,size,new Color(r, g, b),vx,vy,px,py);
		   return randB;
	   
   }
   
   /** Set the size for the window when it opens **/
=======
<<<<<<< HEAD
    
   public void add(Body b){system.add(b);}
   public static void clear(){system.clear();}
   public static void loadGas(){
	   system.add(new Body(10,5,Color.white,0,0,200,200));
   }
   public static void loadSolar(){
	   system.add(new Body(10,5,Color.yellow,0,0,200,200));
   }
   public static void loadGalaxy(){
	   system.add(new Body(10,5,Color.blue,0,0,200,200));
   }

>>>>>>> d0faac1a8918d73e1e2e45df72a42c59471ed6c6
    public Dimension getPreferredSize() {
        return new Dimension(600,600);
    }
    
<<<<<<< HEAD
    /** Paint the new JPanel for the user to see **/
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Body b: system) {
            Ellipse2D object = new Ellipse2D.Double();
            object.setFrameFromCenter(
                b.getposx(),
                b.getposy(),
                b.getposx() - b.getSize()/2,
                b.getposy() - b.getSize()/2);
=======
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (Body b: system) {
            Ellipse2D object = new Ellipse2D.Double();
            object.setFrameFromCenter(
                b.getposx() - b.getSize(),
                b.getposy() - b.getSize(),
                b.getposx(),
                b.getposy());
>>>>>>> d0faac1a8918d73e1e2e45df72a42c59471ed6c6
            g2.setColor(b.getColor());
            g2.draw(object);
            g2.fill(object);
        }
<<<<<<< HEAD
        //Create the opening screen text.
        if(title)
        	doDrawing(g);
    }
    
    /** Create the opening screen for the user **/
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh =
            new RenderingHints(RenderingHints.KEY_ANTIALIASING, 
            RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING,
               RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
        g2d.setFont(new Font("Forte", Font.PLAIN, 40));
        g2d.drawString("Gravity", 230, 245);
        g2d.setFont(new Font("Forte", Font.PLAIN, 20));
        g2d.drawString("Click anywhere to play", 195, 390);
=======
>>>>>>> d0faac1a8918d73e1e2e45df72a42c59471ed6c6
    }

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		/** Get the position and time of the first mouse press to determine body speed **/
		calcX = e.getX();
		calcY = e.getY();
		calcT = e.getWhen();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
<<<<<<< HEAD
		//Display the title, until the first click
		if(title)
			title = false;
		else{
		/** Create a body with the specific settings and speeds calculated from the mouse **/
		clickVelX = (calcX - e.getX())/(calcT - e.getWhen()) * 5;// * timerInt / 5;
		clickVelY = (calcY - e.getY())/(calcT - e.getWhen()) * 5;// * timerInt / 5;
		add(new Body(clickMass,clickSize,clickColor,clickVelX,clickVelY,e.getX()+clickSize/2,e.getY()+clickSize/2));
		}
=======
		/** Create a body with the specific settings and speeds calculated from the mouse **/
		clickVelX = (calcX - e.getX())/(calcT - e.getWhen()) * timerInt / 5;
		clickVelY = (calcY - e.getY())/(calcT - e.getWhen()) * timerInt / 5;
		add(new Body(clickMass,clickSize,clickColor,clickVelX,clickVelY,e.getX()+clickSize/2,e.getY()+clickSize/2));
		
>>>>>>> d0faac1a8918d73e1e2e45df72a42c59471ed6c6
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}  
   
<<<<<<< HEAD
=======
=======

    private static void createAndShowGUI() {
        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.add(new MyPanel());
        f.pack();
        f.setVisible(true);
        
    } 
}

class MyPanel extends JPanel {

    private int squareX = 50;
    private int squareY = 50;
    private int squareW = 20;
    private int squareH = 20;

    public MyPanel() {

        setBorder(BorderFactory.createLineBorder(Color.black));

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                moveSquare(e.getX(),e.getY());
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                moveSquare(e.getX(),e.getY());
            }
        });
        
    }
    
    private void moveSquare(int x, int y) {
        int OFFSET = 1;
        if ((squareX!=x) || (squareY!=y)) {
            repaint(squareX,squareY,squareW+OFFSET,squareH+OFFSET);
            squareX=x;
            squareY=y;
            repaint(squareX,squareY,squareW+OFFSET,squareH+OFFSET);
        } 
    }
    

    public Dimension getPreferredSize() {
        return new Dimension(250,200);
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);      
        body sun = new body(1000,20,Color.yellow,0,0,100,100);
        body planet = new body(10,5,Color.black,5,0,50,50);
        Graphics2D g2d = (Graphics2D)g;
        Graphics2D gnew = (Graphics2D)g;
        // Assume x, y, and diameter are instance variables.
        Ellipse2D.Double circle = new Ellipse2D.Double(sun.getposx(),sun.getposy(),sun.getSize(),sun.getSize());
        g2d.setColor(sun.getColor());
        g2d.fill(circle);
        Ellipse2D.Double circle2 = new Ellipse2D.Double(planet.getposx(),planet.getposy(),planet.getSize(),planet.getSize());
        gnew.setColor(planet.getColor());
        gnew.fill(circle2);
        
        //g.drawString("This is my custom Panel!",10,20);
        //g.setColor(Color.RED);
        //g.fillRect(squareX,squareY,squareW,squareH);
        //g.setColor(Color.BLACK);
        //g.drawRect(squareX,squareY,squareW,squareH);
    }  
>>>>>>> master
>>>>>>> d0faac1a8918d73e1e2e45df72a42c59471ed6c6
}