import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
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

public class GUI {
	
	/** Set up the Frame and Menu Bar **/
    public static void createAndShowGUI() {
        JFrame f = new JFrame("Gravity");
        JMenuBar menubar = new JMenuBar();
        JMenu file,edit,help,changeMode;
        
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");
        changeMode = new JMenu("Change Mode...");
        
        JMenuItem changeSettings = new JMenuItem("Change Settings...");
        JMenuItem voidofSpace = new JMenuItem("Black Void");
        JMenuItem cloud = new JMenuItem("Gas Cloud");
        JMenuItem solar = new JMenuItem("Solar System");
        JMenuItem galaxy = new JMenuItem("Galaxy");
        JMenuItem saveImage = new JMenuItem("Save Screen as Image");
        JMenuItem fastForward = new JMenuItem("Speed Up Time");
        JMenuItem slowDown	= new JMenuItem("Slow Down Time");
        JMenuItem pause = new JMenuItem("Pause");
        JMenuItem resume = new JMenuItem("Resume");
        JMenuItem howto = new JMenuItem("How To...");
        JMenuItem about = new JMenuItem("About"); 
        
        changeMode.add(voidofSpace);
        changeMode.add(cloud);
        changeMode.add(solar);
        changeMode.add(galaxy);
        file.add(saveImage);
        file.add(changeMode);
        edit.add(changeSettings);
        edit.add(fastForward);
        edit.add(slowDown);
        edit.add(pause);
        edit.add(resume);
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
        
        /** Load the Galaxy loadout **/
        galaxy.addActionListener(new ActionListener(){
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
							if (!file.exists())
							file.createNewFile();
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
			  if(0<Double.valueOf(buffer))
				  MyPanel.clickSize = Integer.valueOf(buffer);
			  buffer = mass.getText();
			  if(buffer.isEmpty())
				  buffer = "1";
			  MyPanel.clickMass = Integer.valueOf(buffer);
			  MyPanel.time.start();
			}
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
			}
    	});
        
        /** Start the timer and resume the simulation **/
        resume.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MyPanel.time.start();
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
				  JPanel p2 = new JPanel();
				  String Fun = "Have Fun!:<br><br>"+
						    "Have fun experimenting with gravity!";
				  p2.add(new JLabel("<html><body><p style='width: 250px;'>"+ Fun + "</body></html>"));
				  
				  //And add them to a tabbed pane to make it pretty
				  JTabbedPane tPane = new JTabbedPane();
				  tPane.addTab("Fun", p2);
				  tPane.addTab("Settings",p1);

				  JOptionPane.showConfirmDialog(null, tPane, "Change Creation Settings ", JOptionPane.OK_CANCEL_OPTION);
				  
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
	public static double clickVelX = 0, clickVelY = 0, calcX, calcY;
	public static long calcT;
	public static Color clickColor = Color.white;
	public static Timer time;
	private static int timerInt = 50;
	static ArrayList <Body> system = new ArrayList<Body>();
    public MyPanel() {
    	addMouseListener(this);
    	add(new Body(10000,20,Color.yellow,0,0,300,300));
        add(new Body(10,5,Color.white,2,0,200,200));
        //add(new Body(10,5,Color.red,-1,0,400,400));
        
        
        /** Add a Timer to run everything in specific intervals, that 
         * can be changed 
         */
        ActionListener updateClockAction = new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    	    	repaint();
    	    	physics.calculateChanges(system);
    		    }	
    		};
        	time = new Timer(timerInt, updateClockAction);
        	time.start();
        	
  
    }
    
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

    public Dimension getPreferredSize() {
        return new Dimension(600,600);
    }
    
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
            g2.setColor(b.getColor());
            g2.draw(object);
            g2.fill(object);
        }
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
		/** Create a body with the specific settings and speeds calculated from the mouse **/
		clickVelX = (calcX - e.getX())/(calcT - e.getWhen()) * timerInt / 5;
		clickVelY = (calcY - e.getY())/(calcT - e.getWhen()) * timerInt / 5;
		add(new Body(clickMass,clickSize,clickColor,clickVelX,clickVelY,e.getX()+clickSize/2,e.getY()+clickSize/2));
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}  
   
}