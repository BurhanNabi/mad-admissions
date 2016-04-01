/**
 * 
 */
package user;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * @author Milind 2014064
 */

public class Student {
	SimpleStringProperty Name;
	SimpleStringProperty EnrollmentNumber;
	@FXML Button DataFile = new Button("View Details");
	
	private Double[] arg1 = new Double[5];
	private LocalDate[] arg2 = new LocalDate[2];
	private String[] arg = new String[17];

	public Student(Applicant ap)
	{
		
		arg[0] = ap.getEnrollmentId();
		DataFile.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
            	File file = new File("DATA/Text Files/" + arg[0]+".txt");
            	try {
					Desktop.getDesktop().open(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
//		System.out.println("--------" + arg[0]);
		EnrollmentNumber = new SimpleStringProperty(arg[0]);
		arg[1] = ap.getPersonalDetails().email;
		arg[2] = ap.getPersonalDetails().name;
		Name = new SimpleStringProperty(arg[2]);
		arg[3] = ap.getPersonalDetails().category;
		arg[4] = ap.getPersonalDetails().gender;
		arg[5] = ap.getPersonalDetails().disabled;
		arg[6] = ap.getPhDPreferences().stream;
		
		if (ap.getGraduationDetails().cgpa) {
			if (ap.getGraduationDetails().cgpa_total.equals("4")) {
				
				arg1[2] = ap.getGraduationDetails().G_grades * 2.5;
				
			} else {
				arg1[2] = ap.getGraduationDetails().G_grades * 9.5;
			}
		} else {
			arg1[2] = ap.getGraduationDetails().G_grades;
		}
		arg[7] = ap.getGraduationDetails().G_deg;
		arg[11] = ap.getGraduationDetails().G_dep;
		arg[13] = ap.getGraduationDetails().G_state;
		arg[15] = ap.getGraduationDetails().G_uni;
		arg[9] = ap.getSchoolDetails().X_b;
		arg[10] = ap.getSchoolDetails().XII_b;
//		System.out.println(ap.enrollmentNumber);
		if(ap.getPGDetails() == null){
//			System.out.println("aaaaa");
			arg[8] = "";
			arg[14] = "";
			arg[12] = "";
			arg1[3] = 0.0;
		}
		else{
			arg[8] = ap.getPGDetails().PG_deg;
			arg[12] = ap.getPGDetails().PG_dep;
			arg[14] = ap.getPGDetails().PG_state;
			if (ap.getPGDetails().cgpa) {
				if (ap.getPGDetails().cgpa_total.equals("4")) {
					
					arg1[2] = ap.getPGDetails().PG_grades * 2.5;
					
				} else {
					arg1[2] = ap.getPGDetails().PG_grades * 9.5;
				}
			} else {
				arg1[2] = ap.getPGDetails().PG_grades;
			}
		}
//		arg[16] = ap.getPGDetails().PG_uni;
		arg1[0] = ap.getSchoolDetails().X_p;
		arg1[1] = ap.getSchoolDetails().XII_p;

		if(ap.getGATEDetails() == null)
			arg1[4] = 0.0;
		else{
			arg1[4] = ap.getGATEDetails().marks_out_of_100;
		}
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM/dd/yyyy");
		arg2[0] = LocalDate.parse(ap.getPersonalDetails().dob);
//		System.out.println(ap.getTimeOfSubmit());
		arg2[1] = ap.getTimeOfSubmit();
	}
	


	public String getarg(int i)
	{
		return arg[i];
	}
	public Double getarg1(int i){
		return arg1[i-17];
	}
	public LocalDate getarg2(int i){
		return arg2[i];
	}
	public String getName()
	{
		return Name.get();
	}

	public String getEnrollmentNumber()
	{
		return EnrollmentNumber.get();
	}
	public Button getDataFile()
	{
		return DataFile;
	}
}
