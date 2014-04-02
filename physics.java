import java.util.ArrayList;


public class physics {
	private final static double G = (6.6738480 * Math.pow(10,-11));
	
	private static double calculateGravity(Body m1, Body m2){
		/***** Newton's universal law of gravitation with
		    	the distance formula substituted for r^2 ****/
		double force = ((G*m1.getMass()*m2.getMass())/
				(Math.pow(m2.getposx()-m1.getposx(),2) 
						+ Math.pow(m2.getposy() - m1.getposy(), 2)));
		return force;
	}
	
	private static double calculateAcceleration(double Force, Body m){
		/** Force = Mass * Acceleration **/
		double Acc = Force/m.getMass();
		return Acc;
	}
	
	/** Change the velocity with the force calculations**/
	private static void velChanges(Body b){
		
	}
	
	/** Change the position to the new position **/
	private static void posChanges(Body b){
		b.setposx(b.getposx()+b.getvelx());
		b.setposy(b.getposy()+b.getvely());
	}
	
	public static void calculateChanges(ArrayList <Body> system){
		for (Body b: system) {
		posChanges(b);
		}
	}

}
