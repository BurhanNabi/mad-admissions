package user;

import java.io.File;
import java.io.Serializable;

public class AchievementsCVSOP implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2986112802551031873L;
	String achievements;
	File CV, SOP;
	
	void setDetails(String[] ar, File _cv, File _sop) {
		achievements = ar[0];
		CV = _cv;
		SOP = _sop;
	}
}
