package user;

import java.io.Serializable;

public class PGDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5302309491149443997L;
	Boolean cgpa;
	String cgpa_total;
	String 	PG_deg, PG_dep, PG_col, PG_thesis, PG_city,
			PG_state, PG_yog;
	Double  PG_grades;
	
	void setDetails(String[] ar, Boolean _cgpa, Double marks,String total) {
		PG_deg = ar[0];
		PG_dep = ar[1];
		PG_col = ar[2];
		PG_thesis = ar[3];
		PG_city = ar[4];
		PG_state = ar[5];
		PG_yog = ar[6];
		cgpa = _cgpa;
		
		if(cgpa)
			cgpa_total = total;
		PG_grades = marks;
	}
}
