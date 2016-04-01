package user;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class TextFileCreator {
	
	public static void create(Applicant a) throws FileNotFoundException {
		File TEXTdir = new File("DATA/Text Files/");
		if(!TEXTdir.exists()) {
			TEXTdir.mkdirs();
		}else {
			PrintStream txt = new PrintStream("DATA/Text Files/" + a.getEnrollmentId()+".txt");
			
			txt.println("Submitted On: "+ a.getTimeOfSubmit());
			txt.println("Enrollment ID: "+ a.getEnrollmentId());
			txt.println("Name: "+ a.getPersonalDetails().name);
			txt.println("Email: "+ a.getPersonalDetails().email);
			txt.println("Correspondance Address: "+ a.getPersonalDetails().add_corr);
			txt.println("Permanent Address: "+ a.getPersonalDetails().add_perm);
			txt.println("DOB: "+ a.getPersonalDetails().dob);
			txt.println("Father's Name: "+ a.getPersonalDetails().father);
			txt.println("Gender: "+ a.getPersonalDetails().gender);
			txt.println("Is Disabled: "+ a.getPersonalDetails().disabled);
			txt.println("Is a Child/Widow or army personnel: "+ a.getPersonalDetails().ch_of_war);

			txt.println("Xth Board: " + a.getSchoolDetails().X_b );
			txt.println("Xth Percentage: " + a.getSchoolDetails().X_p );
			txt.println("Xth Year Of Passing: " + a.getSchoolDetails().X_yop );
			txt.println("XIIth Board: " + a.getSchoolDetails().XII_b );
			txt.println("XIIth Percentage: " + a.getSchoolDetails().XII_p );
			txt.println("XIIth Year Of Passing: " + a.getSchoolDetails().XII_yop);
			
			
			txt.println("Graduation Degree " + a.getGraduationDetails().G_deg);
			txt.println("Graduation Department " + a.getGraduationDetails().G_dep);
			txt.println("Graduation College" + a.getGraduationDetails().G_col);
			txt.println("Graduation University" + a.getGraduationDetails().G_uni);
			txt.println("Graduation City " + a.getGraduationDetails().G_city);
			txt.println("Graduation State " + a.getGraduationDetails().G_state);
			txt.println("Graduation Year Of Grad. " + a.getGraduationDetails().G_yog);
			txt.println("Graduation CGPA system " + a.getGraduationDetails().cgpa);
			txt.println("Graduation Marks " + a.getGraduationDetails().G_grades);
			
			txt.close();
		}
	}
	
}
