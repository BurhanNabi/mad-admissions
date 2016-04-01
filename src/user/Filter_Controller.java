/**
 * 
 */
package user;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * @author Milind 2014064
 */
public class Filter_Controller implements Initializable {
	
	@FXML CheckBox gateeq;
	@FXML CheckBox gategrt;
	@FXML CheckBox gatelsr;
	@FXML CheckBox pgradeq;
	@FXML CheckBox pgradgrt;
	@FXML CheckBox pgradlsr;
	@FXML CheckBox gradeq;
	@FXML CheckBox gradgrt;
	@FXML CheckBox gradlsr;
	@FXML CheckBox Xeq;
	@FXML CheckBox Xgrt;
	@FXML CheckBox Xlsr;
	@FXML CheckBox XIIeq;
	@FXML CheckBox XIIgrt;
	@FXML CheckBox XIIlsr;
	@FXML ChoiceBox<String> category;
	@FXML ChoiceBox<String> graddept;
	@FXML ChoiceBox<String> pgraddept;
	@FXML ChoiceBox<String> graddeg;
	@FXML ChoiceBox<String> pgraddeg;
	@FXML ChoiceBox<String> gradstate;
	@FXML ChoiceBox<String> pgradstate;
	@FXML ChoiceBox<String> stream;
	@FXML ChoiceBox<String> Xboard;
	@FXML ChoiceBox<String> XIIboard;
	@FXML DatePicker datedfrom;
	@FXML DatePicker datedupto;
	@FXML DatePicker dob;
	@FXML RadioButton dobaftr;
	@FXML RadioButton dobbfr;
	@FXML RadioButton dobon;
	@FXML TextField email;
	@FXML TextField enrol_num;
	@FXML TextField gatescr;
	@FXML TextField gradper;
	@FXML TextField graduniv;
	@FXML TextField name;
	@FXML TextField pgradper;
	@FXML TextField pgraduniv;
	@FXML TextField XIIper;
	@FXML TextField Xper;
	@FXML ToggleGroup Gender;
	@FXML ToggleGroup PhyDsbl;
	@FXML Tab Tb_Bgt;
	@FXML Tab Tb_Expns;
	@FXML Tab Tb_Expns1;
	@FXML Label numonly;
	@FXML Button result;
	
	private Integer[] cpmod,actargs;
	private String[] args;
	private int argsi=0;
	
	
	ObjectInputStream oin=null;
//	FileOutputStream fileOut;
	public static ArrayList<Student> Applicants = new ArrayList<>();
	private ArrayList<String> check = new ArrayList<>();
	private Parent root;
	private Stage secondaryStage = new Stage();
	Scene prscene;
	
	@FXML
	public void OnSubmit(){
		initArrays();
		cmp();
		Stage stage = (Stage) result.getScene().getWindow();
		try {
			root = FXMLLoader.load(getClass().getResource("List.fxml"));
			prscene = new Scene(root,600,700);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			secondaryStage.setTitle("Admin Panel");
			secondaryStage.setScene(prscene);
			secondaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	    stage.hide();
//		sysSystem.out.println(Applicants));
	}
	
	public void initArrays(){
		cpmod = new Integer[6];
		argsi = 0;
		int i = 0;
		args = new String[28];
		actargs = new Integer[28];
		
		if (gateeq.isSelected() == true)
			cpmod[5] += 1;
		if (gategrt.isSelected() == true)
			cpmod[5] += 2;
		if (gatelsr.isSelected() == true)
			cpmod[5] += 4;
		if (gradeq.isSelected() == true)
			cpmod[4] += 1;
		if (gradgrt.isSelected() == true)
			cpmod[4] += 2;
		if (gradlsr.isSelected() == true)
			cpmod[4] += 4;
		if (pgradeq.isSelected() == true)
			cpmod[3] += 1;
		if (pgradgrt.isSelected() == true)
			cpmod[3] += 2;
		if (pgradlsr.isSelected() == true)
			cpmod[3] += 4;
		if (XIIeq.isSelected() == true)
			cpmod[2] += 1;
		if (XIIgrt.isSelected() == true)
			cpmod[2] += 2;
		if (XIIlsr.isSelected() == true)
			cpmod[2] += 4;
		if (Xeq.isSelected() == true)
			cpmod[1] += 1;
		if (Xgrt.isSelected() == true)
			cpmod[1] += 2;
		if (Xlsr.isSelected() == true)
			cpmod[1] += 4;
		if (dobaftr.isSelected() == true)
			cpmod[0] += 1;
		if (dobbfr.isSelected() == true)
			cpmod[0] += 2;
		if (dobon.isSelected() == true)
			cpmod[0] += 4;
		
		if(enrol_num.getText().equals("")==false){
			args[i] = enrol_num.getText();
			actargs[argsi++] = i;
		}i++;
		if(email.getText().equals("")==false){
			args[i] = email.getText();
			actargs[argsi++] = i;
		}i++;
		if(name.getText().equals("")==false){
			args[i] = name.getText();
			actargs[argsi++] = i;
		}i++;
		if(category.getValue().equals("All")==false){
			args[i] = category.getValue();
			actargs[argsi++] = i;
		}i++;
		int k;
		try{
//			Gender.getSelectedToggle();
			args[i] = ((RadioButton)Gender.getSelectedToggle()).getText();
			k = 1;
		}
		catch(NullPointerException e){
			k = 0;
		}
		if(k == 1){
//			args[i] = ((RadioButton)Gender.getSelectedToggle()).getText();
			actargs[argsi++] = i;
//			System.out.println("asdasd");
		}i++;
		
		try{
			args[i] = ((RadioButton)PhyDsbl.getSelectedToggle()).getText();
			k = 1;
		}
		catch(NullPointerException e){
			k = 0;
		}
		if(k == 1){
			actargs[argsi++] = i;
		}i++;
		if(stream.getValue().equals("All")==false){
			args[i] = stream.getValue();
			actargs[argsi++] = i;
		}i++;
		if(graddeg.getValue().equals("All")==false){
			args[i] = graddeg.getValue();
			actargs[argsi++] = i;
		}i++;
		if(pgraddeg.getValue().equals("All")==false){
			args[i] = pgraddeg.getValue();
			actargs[argsi++] = i;
		}i++;
		if(Xboard.getValue().equals("All")==false){
			args[i] = Xboard.getValue();
			actargs[argsi++] = i;
		}i++;
		if(XIIboard.getValue().equals("All")==false){
			args[i] = XIIboard.getValue();
			actargs[argsi++] = i;
		}i++;
		if(graddept.getValue().equals("All")==false){
			args[i] = graddept.getValue();
			actargs[argsi++] = i;
		}i++;
		if(pgraddept.getValue().equals("All")==false){
			args[i] = pgraddept.getValue();
			actargs[argsi++] = i;
		}i++;
		if(gradstate.getValue().equals("All")==false){
			args[i] = gradstate.getValue();
			actargs[argsi++] = i;
		}i++;
		if(pgradstate.getValue().equals("All")==false){
			args[i] = pgradstate.getValue();
			actargs[argsi++] = i;
		}i++;
		if(graduniv.getText().equals("")==false){
			args[i] = graduniv.getText();
			actargs[argsi++] = i;
		}i++;
		if(pgraduniv.getText().equals("")==false){
			args[i] = pgraduniv.getText();
			actargs[argsi++] = i;
		}i++;
		if(Xper.getText().equals("")==false){
			args[i] = Xper.getText();
			actargs[argsi++] = i;
		}i++;
		if(XIIper.getText().equals("")==false){
			args[i] = XIIper.getText();
			actargs[argsi++] = i;
		}i++;
		if(gradper.getText().equals("")==false){
			args[i] = gradper.getText();
			actargs[argsi++] = i;
		}i++;
		if(pgradper.getText().equals("")==false){
			args[i] = pgradper.getText();
			actargs[argsi++] = i;
		}i++;
		if(gatescr.getText().equals("")==false){
			args[i] = gatescr.getText();
			actargs[argsi++] = i;
		}i++;
		try{
			if(dob.getValue().equals(null)==false){}
			k = 1;
		}
		catch(NullPointerException e){
			k = 0;
		}
		if(k == 1){
			actargs[argsi++] = i;
		}i++;
		try{
			if(datedfrom.getValue().equals(null)==false){}
			k = 1;
		}
		catch(NullPointerException e){
			k = 0;
		}
		if(k == 1){
			actargs[argsi++] = i;
		}i++;
		try{
			if(datedupto.getValue().equals(null)==false){}
			k = 1;
		}
		catch(NullPointerException e){
			k = 0;
		}
		if(k == 1){
			actargs[argsi++] = i;
		}i++;
//		if(dob.getValue().equals(null)==false){
//			actargs[argsi++] = i;
//		}i++;
//		if(datedfrom.getValue().equals(null)==false){
//			actargs[argsi++] = i;
//		}i++;
//		if(datedupto.getValue().equals(null)==false){
//			actargs[argsi++] = i;
//		}i++;
		
//		System.out.println(dob.getValue());
//
	}
//
//	int gp=0,pgp=0,xp=0,xiip=0,gsc=0,db=0;
	@FXML
	public void gradper(){
		if(gradeq.isSelected()==true || gradlsr.isSelected()==true || gradgrt.isSelected()==true)
			gradper.setDisable(false);
		else{
			gradper.setDisable(true);
			gradper.setText("");
		}
	}
	public void pgradper(){
		if(pgradeq.isSelected()==true || pgradlsr.isSelected()==true || pgradgrt.isSelected()==true)
			pgradper.setDisable(false);
		else{
			pgradper.setDisable(true);
			pgradper.setText("");
		}
	}
	public void xper(){
		if(Xeq.isSelected()==true || Xlsr.isSelected()==true || Xgrt.isSelected()==true)	
			Xper.setDisable(false);
		else{
			Xper.setDisable(true);
			Xper.setText("");
		}
	}
	public void xiiper(){
		if(XIIeq.isSelected()==true || XIIlsr.isSelected()==true || XIIgrt.isSelected()==true)
			XIIper.setDisable(false);
		else{
			XIIper.setDisable(true);
			XIIper.setText("");
		}
	}
	public void gatescr(){
		if(gateeq.isSelected()==true || gatelsr.isSelected()==true || gategrt.isSelected()==true)
			gatescr.setDisable(false);
		else{
			gatescr.setDisable(true);
			gatescr.setText("");
		}
	}
	public void dob(){
		if(dobaftr.isSelected()==true || dobon.isSelected()==true || dobbfr.isSelected()==true)
			dob.setDisable(false);
		else{
			dob.setValue(null);
			dob.setDisable(true);
		}
//		System.out.println("11");
	}
	public void per(ActionEvent e){
		if(Validator.hasOnlyDigits(((TextField)e.getSource()).getText()) == false){
			((TextField)e.getSource()).setText("");	
			numonly.setVisible(true);
		}
		else{
			if(Double.valueOf(((TextField)e.getSource()).getText()) < 0){
				((TextField)e.getSource()).setText("0");
			}
			else if(Double.valueOf(((TextField)e.getSource()).getText()) > 100){
				((TextField)e.getSource()).setText("100");
			}
			numonly.setVisible(false);
		}
			
	}
	@FXML
	public void dateselect1(){
		if(datedfrom.getValue().compareTo(LocalDate.now()) > 0)
			datedfrom.setValue(LocalDate.now());
		if(datedupto.getValue() != null){
			if(datedfrom.getValue().compareTo(datedupto.getValue()) > 0)
				datedupto.setValue(datedfrom.getValue());
			
		}
	}
	@FXML
	public void dateselect2(){
		if(datedupto.getValue().compareTo(LocalDate.now()) > 0)
			datedupto.setValue(LocalDate.now());
		if(datedfrom.getValue() != null){
			if(datedupto.getValue().compareTo(datedfrom.getValue()) < 0)
				datedfrom.setValue(datedupto.getValue());
			
		}
	}
	public Scene getScene(){
		return numonly.getScene();
	}
	public void cmp(){
		for(Student x : Applicants){
			int i;
			for(i = 0;i<argsi;i++){
				
				if(actargs[i]>=17 && actargs[i]<=21)
				{
					if(cpmod[actargs[i] - 16] == 1){
						if(Double.valueOf(args[actargs[i]]) != x.getarg1(actargs[i]))
							break;
					}
					else if(cpmod[actargs[i] - 16] == 2){
						if(Double.valueOf(args[actargs[i]]) <= x.getarg1(actargs[i]))
							break;
					}
					else if(cpmod[actargs[i] - 16] == 4){
						if(Double.valueOf(args[actargs[i]]) >= x.getarg1(actargs[i]))
							break;
					}
					else if(cpmod[actargs[i] - 16] == 3){
						if(Double.valueOf(args[actargs[i]]) < x.getarg1(actargs[i]))
							break;
					}
					else if(cpmod[actargs[i] - 16] == 5){
						if(Double.valueOf(args[actargs[i]]) > x.getarg1(actargs[i]))
							break;
					}
					else if(cpmod[actargs[i] - 16] == 6){
						if(Double.valueOf(args[actargs[i]]) == x.getarg1(actargs[i]))
							break;
					}
				}
				else if(actargs[i] == 22){
					if(cpmod[0] == 1){
						if(dob.getValue().isAfter(x.getarg2(0))==true || dob.getValue().isEqual(x.getarg2(i))==true)
							break;
					}
					else if(cpmod[actargs[i] - 22] == 2){
						if(dob.getValue().isBefore(x.getarg2(0))==true || dob.getValue().isEqual(x.getarg2(i))==true)
							break;
					}
					else if(cpmod[actargs[i] - 22] == 3){
						if(dob.getValue().isEqual(x.getarg2(0))== true)
							break;
					}
					else if(cpmod[actargs[i] - 22] == 4){
						if(dob.getValue().isEqual(x.getarg2(0))==false)
							break;
					}
					else if(cpmod[actargs[i] - 22] == 5){
						if(dob.getValue().isAfter(x.getarg2(0))==true)
							break;
					}
					else if(cpmod[actargs[i] - 22] == 6){
						if(dob.getValue().isBefore(x.getarg2(0))==true)
							break;
					}
				}
				else if(actargs[i] == 23){
					if(datedfrom.getValue().isAfter(x.getarg2(1)))
						break;
				}
				else if(actargs[i] == 24){
					if(datedupto.getValue().isBefore(x.getarg2(1)))
						break;
				}	
				else if(args[actargs[i]].equalsIgnoreCase(x.getarg(actargs[i]))== false)
					break;
			}
			if (i == argsi){
				
				MainA.Students.add(x);
				
//				System.out.println(x.getarg(0));
				
			}
			
		}
	}
	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#ini1tialize(java.net.URL, java.util.ResourceBundle)
	 */
	/**
	 * @param location
	 * @param resources
	 * 
	 */
	@Override
	public void initialize (URL location, ResourceBundle resources) {
		
		Applicants.clear();
		pgraddeg.getItems().addAll("All");
		category.getItems().addAll("All","General","OBC","SC","ST");
		graddept.getItems().addAll("All");
		pgraddept.getItems().addAll("All");
		graddeg.getItems().addAll("All");
		gradstate.getItems().addAll("All","J&K","Himachal Pradesh","Maharshtra","Uttar Pradesh",
				"Punjab", "Uttrakhand", "Delhi", "Rajasthan", "Madhya Pradesh",
				"Gujarat","Bihar","Jharkhand","West Bengal", "Chattisgarh",
				"Assam","Mizoram","Manipal","Arunachal Pradesh",
				"Sikkim","Meghalaya","Nagaland","Kerela",
				"Andra Pradesh","Hyderabad","Tamil Nadu");
		pgradstate.getItems().addAll("All","J&K","Himachal Pradesh","Maharshtra","Uttar Pradesh",
				"Punjab", "Uttrakhand", "Delhi", "Rajasthan", "Madhya Pradesh",
				"Gujarat","Bihar","Jharkhand","West Bengal", "Chattisgarh",
				"Assam","Mizoram","Manipal","Arunachal Pradesh",
				"Sikkim","Meghalaya","Nagaland","Kerela",
				"Andra Pradesh","Hyderabad","Tamil Nadu");
		stream.getItems().addAll("All","Computer Science","Electronics and Communication","Computational Biology");
		Xboard.getItems().addAll("All");
		XIIboard.getItems().addAll("All");
		pgraddeg.setValue("All");
		category.setValue("All");
		graddept.setValue("All");
		pgraddept.setValue("All");
		graddeg.setValue("All");
		gradstate.setValue("All");
		pgradstate.setValue("All");
		stream.setValue("All");
		Xboard.setValue("All");
		XIIboard.setValue("All");
		check.clear();
		ObjectInputStream oin = null;
		File ApplicantFolder = new File("DATA/Applicants");
		if(ApplicantFolder.exists()) {
		try {
			for(String x:ApplicantFolder.list()){
//				System.out.println(x);
			oin = new ObjectInputStream(new FileInputStream("DATA/Applicants/"+x));
			Applicant prev = (Applicant) oin.readObject();
			TextFileCreator.create(prev);
			if (prev.getPGDetails() == null){}
			else{
				if(check.contains(prev.getPGDetails().PG_deg.toUpperCase()) == true)
						pgraddeg.getItems().addAll(prev.getPGDetails().PG_deg.toUpperCase());
				if(check.contains(prev.getPGDetails().PG_dep.toUpperCase()) == true)
					pgraddept.getItems().addAll(prev.getPGDetails().PG_dep.toUpperCase());
				check.add(prev.getPGDetails().PG_deg.toUpperCase());
				check.add(prev.getPGDetails().PG_dep.toUpperCase());}
			if(check.contains(prev.getGraduationDetails().G_deg.toUpperCase()) == true)
				graddeg.getItems().addAll(prev.getGraduationDetails().G_deg.toUpperCase());
			if(check.contains(prev.getSchoolDetails().X_b.toUpperCase()) == true)	
				Xboard.getItems().addAll(prev.getSchoolDetails().X_b.toUpperCase());
			if(check.contains(prev.getSchoolDetails().XII_b.toUpperCase()) == true)
				XIIboard.getItems().addAll(prev.getSchoolDetails().XII_b.toUpperCase());
			if(check.contains(prev.getGraduationDetails().G_dep.toUpperCase()) == true)
				graddept.getItems().addAll(prev.getGraduationDetails().G_dep.toUpperCase());
			
			check.add(prev.getGraduationDetails().G_deg.toUpperCase());
			check.add(prev.getSchoolDetails().X_b.toUpperCase());
			check.add(prev.getSchoolDetails().XII_b.toUpperCase());
			check.add(prev.getGraduationDetails().G_dep.toUpperCase());
			Applicants.add(new Student(prev));
			}
			oin.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
	}
	
}
/*
if(actargs[i] == 0){
	if(enrol_num.equals(Applicant.getenrol_num)==false)
		break;
}
else if(actargs[i] == 0){
	
}
else if(actargs[i] == 0){
	
}
else if(actargs[i] == 0){
	
}
else if(actargs[i] == 0){
	
}
else if(actargs[i] == 0){
	
}
else if(actargs[i] == 0){
	
}
else if(actargs[i] == 0){
	
}
else if(actargs[i] == 0){
	
}
else if(actargs[i] == 0){
	
}
else if(actargs[i] == 0){
	
}
else if(actargs[i] == 0){
	
}
else if(actargs[i] == 0){
	
}
else if(actargs[i] == 0){
	
}
else if(actargs[i] == 0){
	
}
else if(actargs[i] == 0){
	
}
else if(actargs[i] == 0){
	
}
else if(actargs[i] == 0){
	
}
else if(actargs[i] == 0){
	
}
else if(actargs[i] == 0){
	
}
else if(actargs[i] == 0){
	
}
else if(actargs[i] == 0){
	
}
else if(actargs[i] == 0){
	
}
else if(actargs[i] == 0){
	
}
else if(actargs[i] == 0){
	
}*/