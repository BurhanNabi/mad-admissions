package user;

import java.io.Serializable;

public class PhDPreferences implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6659624218986601454L;
	String stream, phd_pref_1, phd_pref_2, phd_pref_3;
	
	void setDetails( String[] ar) {
		stream = ar[0];
		phd_pref_1 = ar[1];
		phd_pref_2 = ar[2];
		phd_pref_3 = ar[3];
	}
}
