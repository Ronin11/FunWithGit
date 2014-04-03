import java.util.ArrayList;


public class physics {
	private final static double G = 6.6738489E-11; //Newton's "Big" G
	private final static double Multiplier = 10E9; //Gravity Equation Multiplier
	
	private static double calculateGravity(Body m1, Body m2, boolean returnX){
		/***** Newton's universal law of gravitation with
		    	the distance formula substituted for r^2 ****/
		double force = ((G*m1.getMass()*m2.getMass())/
				(Math.pow(m2.getposx()-m1.getposx(),2) 
						+ Math.pow(m2.getposy() - m1.getposy(), 2)));
		double angle = StrictMath.atan((m1.getposy()-m2.getposy())/(m1.getposx()-m2.getposx()));
		System.out.println(angle*180);
		if(returnX)
			force = StrictMath.cos(angle) * force;
		else
			force = StrictMath.sin(angle) * force;
		return force;
	}
	
	private static double calculateAcceleration(double Force, Body m){
		/** Force = Mass * Acceleration **/
		double Acc = Force/m.getMass();
		return Acc;
	}
	
	/** Change the velocity with the force calculations**/
	private static void velChanges(Body b,ArrayList <Body> system){
		double xAccel = 0;
		double yAccel = 0;
		for (Body body: system){
			if(b != body){
				xAccel += calculateAcceleration(calculateGravity(b,body,true),b);
				yAccel += calculateAcceleration(calculateGravity(b,body,false),b);
			}
		}
		xAccel *= Multiplier; // Static Multipliers to
		yAccel *= Multiplier; //  make things play nicer
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
	}

}
