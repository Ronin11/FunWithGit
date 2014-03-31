
public class physics {
	private final static double G = (6.6738480 * Math.pow(10,-11));
	
	public static double calculateGravity(body m1, body m2){
		/***** Newton's universal law of gravitation with
		    	the distance formula substituted for r^2 ****/
		double force = ((G*m1.getMass()*m2.getMass())/
				(Math.pow(m2.getposx()-m1.getposx(),2) 
						+ Math.pow(m2.getposy() - m1.getposy(), 2)));
		return force;
	}
	
	public static double calculateAcceleration(double Force, body m){
		/** Force = Mass * Acceleration **/
		double Acc = Force/m.getMass();
		return Acc;
	}

}
