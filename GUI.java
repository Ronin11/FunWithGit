import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class GUI {

    public static void createAndShowGUI() {
        JFrame f = new JFrame("Gravity");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.add(new MyPanel());
        f.pack();
        f.setVisible(true);
        
    } 
}

class MyPanel extends JPanel {

	ArrayList <Body> system = new ArrayList<Body>();
    public MyPanel() {
    	add(new Body(1000,20,Color.yellow,0,0,100,100));
        add(new Body(10,5,Color.black,1,0,200,200));
        
        ActionListener updateClockAction = new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    	    	repaint();
    	    	physics.calculateChanges(system);
    		    }	
    		};
        	Timer time = new Timer(100, updateClockAction);
        	time.start();
    }
    
   public void add(Body b){system.add(b);}
    

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
   
}