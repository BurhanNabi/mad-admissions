package user;

import java.io.Serializable;

public class PersonalDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4554817090410503261L;

	String 	name, email, add_corr, add_perm, father,
			gender, category, disabled,dob,ch_of_war, nationality;
	
	Long mobile, pin;
	
	void setDetails(String[] ar, Long _mob, Long _pin) {
		name = ar[0];
		email = ar[1];
		add_corr = ar[2];
		add_perm = ar[3];
		father = ar[4];
		gender = ar[5];
		category = ar[6];
		disabled = ar[7];
		dob = ar[8];
		ch_of_war = ar[9];
		nationality = ar[10];
		mobile = _mob;
		pin = _pin;
	}
}
