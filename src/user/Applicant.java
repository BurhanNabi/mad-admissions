package user;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.time.LocalDate;
import java.util.Scanner;

public class Applicant implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1397244545222403037L;

	String enrollmentNumber = generateEnrollmentId();
	LocalDate timeOfSubmit;
		
	PersonalDetails personalDetails = new PersonalDetails();
	PhDPreferences phDPreferences = new PhDPreferences();
	SchoolDetails schoolDetails = new SchoolDetails();
	GraduationDetails graduationDetails = new GraduationDetails();
	
	ECEPreferences ecePreferences = new ECEPreferences();
	PGDetails pgdetails = new PGDetails();
	OtherExamDetails otherExamDetails = new OtherExamDetails();
	GateExamDetails gateExamDetails = new GateExamDetails();
	
	AchievementsCVSOP achievementsCVSOP = new AchievementsCVSOP();
	
	Boolean ece = new Boolean(false), PG = new Boolean(false), 
			other= new Boolean(false), GATE= new Boolean(false);

	public static String generateEnrollmentId() {
		String year = ((Integer)LocalDate.now().getYear()).toString();
		Integer id = 0;
		File file =null;
		file = new File("src/user/id.txt");
		if(!file.exists()) {
			file.mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Scanner in;
		
		try {
			in = new Scanner(file);
			if(in.hasNextLine()) {
				id = in.nextInt();
			}
			in.close();
			Writer fw = new FileWriter(file);
			fw.write((++id).toString());
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		String enroll = year + "00" +id.toString();
		return enroll;	
	}
	
	public String getEnrollmentId() {
		return enrollmentNumber;
	}
	
	public void setTimeOfSubmit() {
		timeOfSubmit = LocalDate.now();
	}
	
	public LocalDate getTimeOfSubmit() {
		return timeOfSubmit;
	}
	public void setPersonalDetails( String[] ar, Long mob, Long pin) {
		personalDetails.setDetails(ar, mob, pin);
	}

	public void setSchoolDetails(String[] ar, Double xp, Double xiip) {
		schoolDetails.setDetails(ar, xp, xiip);
	}

	public void setGraduationDetails(String ar[],Boolean _cgpa,
			Double _grades, String total){
		graduationDetails.setDetails(ar, _cgpa, _grades, total);
	}
	
	public void setECEPrefDetails( String ar[]) {
		ecePreferences.setDetails(ar);
		ece = true;
	}
	
	public void setPGPrefDetails(String ar[],Boolean _cgpa,
			Double _grades, String total) {
		pgdetails.setDetails(ar, _cgpa, _grades, total);
		PG = true;
	}
	
	public void setOtherDetails(String[] ar, Long rank, Double score) {
		otherExamDetails.setDetails(ar, rank, score);
		other = true;
	}
	
	public void setGATEDetails(String[] ar, Long rank, Double marks, Double score) {
		gateExamDetails.setDetails(ar, rank, marks, score);
		GATE = true;
	}
	
	public void setAchievementDetails(String[] ar, File cv, File sop) {
		achievementsCVSOP.setDetails(ar, cv, sop);
	}

	public void setPhDPrefDetails(String[] ar) {
		phDPreferences.setDetails(ar);
	}
	
	
	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}
	public PhDPreferences getPhDPreferences() {
		return phDPreferences;
	}
	public SchoolDetails getSchoolDetails() {
		return schoolDetails;
	}
	public GraduationDetails getGraduationDetails() {
		return graduationDetails;
	}
	public ECEPreferences getECEPreferences() {
		if(ece)
			return ecePreferences;
		return null;
	}
	public PGDetails getPGDetails() {
		if(PG)
			return pgdetails;
		return null;
	}
	public OtherExamDetails getOtherExamDetails() {
		if(other)
			return otherExamDetails;
		return null;
	}
	public GateExamDetails getGATEDetails() {
		if(GATE)
			return gateExamDetails;
		return null;
	}
	
	public AchievementsCVSOP getAchievementsCVSOP() {
		return achievementsCVSOP;
	}
}
