package user;

import java.io.Serializable;

public class SchoolDetails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -734872820567430980L;
	String 	X_b,  X_yop, XII_b,  XII_yop;
	Double X_p, XII_p;
	
	public void setDetails( String ar[], Double xp, Double xiip) {
		X_b = ar[0];
		X_yop = ar[1];
		XII_b = ar[2];
		XII_yop = ar[3];
		X_p = xp;
		XII_p = xiip; 
	}
}
