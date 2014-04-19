import java.awt.Color;
import java.util.ArrayList;

/**
 * 
 * @author Nate Ashby
 * 
 * 	The physics class contains all of the different calculations
 *  that control the simulation. The GUI will call calculateChanges
 *  which will run through everything else, and modify the system
 *  to the updated one, which the GUI will then display.
 *
 */

public class physics {
	private final static double G = 6.6738489E-11; //Newton's "Big" G
	private final static double Multiplier = 10E7; //Gravity Equation Multiplier
	private static ArrayList<Body> additions = new ArrayList<Body>(),
									deletions = new ArrayList<Body>();
	
	private static double calculateGravity(Body m1, Body m2, boolean returnX){
		/***** Newton's universal law of gravitation with
		    	the distance formula substituted for r^2 ****/
		double force = ((G*m1.getMass()*m2.getMass())
						/ (StrictMath.pow((m2.getposx()-m1.getposx()),2) 
						   + StrictMath.pow((m2.getposy() - m1.getposy()), 2)));
		
		double angle = Math.atan((m2.getposy()-m1.getposy())/(m2.getposx()-m1.getposx()));
		if(returnX) //If we want the X component of the force.
			if(m2.getposx() < m1.getposx() && m2.getposy() > m1.getposy()
					|| m2.getposx() < m1.getposx() && m2.getposy() < m1.getposy())
				//Flip the force to the correct direction.
				force = force * Math.cos(angle) * -1;
			else
				force = force * Math.cos(angle);
		else //Else, we want the Y component of the force.
			if(m2.getposx() < m1.getposx() && m2.getposy() > m1.getposy()
						|| m2.getposx() < m1.getposx() && m2.getposy() < m1.getposy())
				//Flip the force to the correct direction.
				force = force * Math.sin(angle) * -1;
			else
				force = force * Math.sin(angle);
		return force;
	}
	
	private static double calculateAcceleration(double Force, Body m){
		/** Force = Mass * Acceleration **/
		if(m.getLocked())
			return 0;
		double Acc = Force/m.getMass();
		return Acc;
	}
	
	/** Change the velocity with the force calculations **/
	private static void velChanges(Body b,ArrayList <Body> system){
		double xAccel = 0;
		double yAccel = 0;
		for (Body body: system){
			if(body.getSize() > 500)
				deletions.add(body);
			if(b != body){
				
				/** Check the entire system for collisions and make
				 *  the necessary changes. This way will prevent the 
				 *  ConcurrentModificationExceptions I've been fighting **/
				Body test = crash(b,body);
				if( test != null){
					if(!body.getLocked())
						//Bodies get added to the list twice because a crashes
						//into b and b also crashes into a.
						//Added if statements to make sure that things aren't being
						//double counted.
						if(!deletions.contains(body))
							deletions.add(body);
					if(!b.getLocked())
						if(!deletions.contains(b))
							deletions.add(b);
					if(!b.getLocked() || !body.getLocked()){
						boolean add = true;
						for(int i = 0; i < additions.size(); i++){
							if(test.equals(additions.get(i)))
								add = false;
						}
						if(add)
							additions.add(test);
					}
				}
				//If there's no collision, then just do the calculations.
				else{
					xAccel += calculateAcceleration(calculateGravity(b,body,true),b);
					yAccel += calculateAcceleration(calculateGravity(b,body,false),b);
				}
				}
			}
		xAccel = Multiplier * xAccel; // Static Multipliers to
		yAccel = Multiplier * yAccel; //  make things play nicer
		b.setvelx(b.getvelx()+xAccel);
		b.setvely(b.getvely()+yAccel);
	}
	
	/** Change the position to the new position **/
	private static void posChanges(Body b){
		b.setposx(b.getposx()+b.getvelx());
		b.setposy(b.getposy()+b.getvely());
	}
	
	/** Nice little method for GUI.java to call **/
	public static void calculateChanges(ArrayList <Body> system){
		for (Body b: system) {
		velChanges(b,system);
		posChanges(b);
		}
		for(int i = 0; i < deletions.size(); i++){
			system.remove(deletions.get(i));
			if(i % 2 == 0) //Replace a body for each one that gets eaten.
				MyPanel.replace();
		}
		deletions.clear();
		//For the black hole mode, don't add any bodies.
		if(MyPanel.getMode() != MyPanel.mode.hole){
			for(int i = 0; i < additions.size(); i++){
				if(additions.get(i).getSize() < 500) // only add stuff if it's not exploding
					if(system.size() < 100)			// and limit body number to save the cpu
						system.add(additions.get(i));
			}
			additions.clear();
		}
	}
	
	/** Detect if two bodies are crashing into each other 
	 * 	If they are, then create and return the resultant
	 *  body, if they aren't, then return a null value.  **/
	private static Body crash(Body m1, Body m2){
		//Distance formula to determine if two bodies are touching
		if(StrictMath.sqrt(StrictMath.pow((m2.getposx()-m1.getposx()),2) 
						   + StrictMath.pow((m2.getposy() - m1.getposy()), 2)) 
						   		< (m1.getSize() + m2.getSize())){
			int mass,size;
			double vX,vY,pX,pY;
			Color color;
			mass = (m1.getMass()+m2.getMass());
			size = ((m1.getSize()+m2.getSize()));
			color = combineColor(m1,m2);
			//Get the resultant velocities with the inelastic collisions equation:
			//V = (M1*V1 + M2*V2)/(M1+M2)
			vX = ((m1.getvelx()*m1.getMass()+m2.getvelx()*m2.getMass())
					/(m1.getMass() + m2.getMass()));
			vY = ((m1.getvely()*m1.getMass()+m2.getvely()*m2.getMass())
					/(m1.getMass() + m2.getMass()));
			//Whichever body is bigger absorbs the other body
			if(m1.getMass() > m2.getMass()){
				pX = m1.getposx();
				pY = m1.getposy();
			}
			else{
				pX = m2.getposx();
				pY = m2.getposy();
			}
			return (new Body(mass,size,color,vX,vY,pX,pY));
		}
		else
			return null;
	}
	
	/** Mix the colors of the two bodies, and weight the colors.
	  * For Example: If a big white body hits a small red body 
	  *  the resultant body should be pinkish  **/
	private static Color combineColor(Body m1, Body m2){
		double mult;
		if(m1.getMass() > m2.getMass())
			mult = m1.getMass()/m2.getMass();
		else
			mult = m2.getMass()/m1.getMass();
		int red = (int)((m1.getColor().getRed()+m2.getColor().getRed())/2 * mult);
		int blue = (int)((m1.getColor().getBlue()+m2.getColor().getBlue())/2 * mult);
		int green = (int)((m1.getColor().getGreen()+m2.getColor().getGreen())/2 * mult);
		if(red > 255) red = 255;
		if(blue > 255) blue = 255;
		if(green > 255) green = 255;
		
		return new Color(red,blue,green);
	}
	
	
}
