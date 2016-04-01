package user;

import java.io.Serializable;

public class GraduationDetails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9032289098127550394L;
	Boolean cgpa;
	String cgpa_total;
	String 	G_deg, G_dep, G_col, G_uni, G_city, G_state, G_yog;
	Double G_grades;
	
	
	public void setDetails(String ar[], Boolean _cgpa, Double _grades, String _total ) {
		G_deg = ar[0];
		G_dep = ar[1];
		G_col = ar[2]; 
		G_uni = ar[3];
		G_city = ar[4];
		G_state = ar[5];
		G_yog = ar[6];
		cgpa = _cgpa;
		if(cgpa)
			cgpa_total = _total;
		G_grades = _grades;
	}
}
