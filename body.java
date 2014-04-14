import java.awt.Color;
/**
 * 
 * @author Ronin
 * 
 * 	The body class is a simple object used in the Gravity program.
 *  All bodies will have the six variables associated with them to
 *  run the simulation. Eventually the color variable will be 
 *  determined by the density of the body.
 *
 */

<<<<<<< HEAD
public class Body {
	public Body(){
=======
public class body {
	public body(){
>>>>>>> master
		mass = 100;
		size = 1;
		velX = 0;
		velY = 0;
		posX = 0;
		posY = 0;
		color = Color.white;
	}
	
	public Body(int mass, int size, Color color, double velX, double velY, double posX, double posY){
		this.mass = mass;
		this.size = size;
		this.color = color;
		this.velX = velX;
		this.velY = velY;
		this.posX = posX;
		this.posY = posY;
		
	}
	//Getters
	public int getMass(){return mass;}
	public int getSize(){return size;}
	public double getvelx(){return velX;}
	public double getvely(){return velY;}
	public double getposx(){return posX+velX;}
	public double getposy(){return posY+velY;}
	public Color getColor(){return color;}
	//Setters
	public void setMass(int m){mass = m;}
	public void setSize(int s){size = s;}
	public void setvelx(double v){velX = v;}
	public void setvely(double v){velY = v;}
	public void setposx(double p){posX = p;}
	public void setposy(double p){posY = p;}
	public void setColor(Color c){color = c;}
	
	//Member Variables
	private Color color;
	private int mass;
	private int size;
	private double velX;
	private double velY;
	private double posX;
	private double posY;

}
