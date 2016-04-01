package user;

import java.io.Serializable;

public class OtherExamDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3005751669982248825L;
	String exam, subj, year;
	Long rank;
	Double score;
	
	void setDetails(String[] ar, Long _rank, Double _score) {
			
		exam = ar[0];
		subj = ar[1];
		year = ar[2];
		
		rank = _rank;
		score = _score;
	}
}
