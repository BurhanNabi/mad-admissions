package user;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

public class PersonalController implements Initializable {
	
	Applicant applicant = new Applicant();
	File cv, sop;
	
	/**
	 * For Tab 1
	 */
	@FXML
	private TabPane mainPane;
	@FXML
	private TextField name, email, en_num, mobile, fathers_name, pin;
	@FXML
	private TextArea corr_add, perm_add;
	@FXML
	private ToggleGroup stream, gender, category, disabled, ch_of_w;
	@FXML
	private ComboBox<String> phd1, phd2, phd3, nationality;
	@FXML
	private DatePicker dob;
	@FXML
	private RadioButton stream_1, stream_2, stream_3,
					gender_1, gender_2, category_1,
					category_2, category_3,category_4,
					disabled_1, disabled_2, ch_of_w_1, ch_of_w_2;
	
	/**
	 * For Tab 2
	 */
	@FXML
	TextField 	X_b, X_per,
				XII_b, XII_per, 
				G_deg, G_dep, G_col, G_uni, G_city, G_cgpa, G_per,
				PG_deg, PG_dep, PG_col,	PG_city, PG_thesis, PG_cgpa, PG_per,
				oth_name, oth_sub, oth_score, oth_rank,
				GATE_area, GATE_marks,GATE_score, GATE_rank;
	@FXML
	Label feed_cv, feed_sop;
	@FXML
	TextArea achievements;
	@FXML
	ComboBox<String> 	X_yop, XII_yop,
						G_state, G_yog, G_CGPA_tot,
						ECE_pref1, ECE_pref2, ECE_pref3, ECE_pref4,
						PG_state,PG_yog, PG_CGPA_tot,
						oth_year,
						GATE_yog;
	@FXML
	ToggleGroup G_score, PG_score;
	@FXML
	RadioButton G_score_c, G_score_p, PG_score_c, PG_score_p;
	@FXML
	CheckBox app_ece, pg, oth, gate;
	@FXML
	AnchorPane ece_options, pg_options, oth_options, gate_options;

	
	/**
	 * Tab 4
	 */
	@FXML 
	Label feedback;
	
	// Toggle disabled on-off on click of checkboxes
	public void ece() {
		if (ece_options.isDisabled())
			ece_options.setDisable(false);
		else
			ece_options.setDisable(true);
	}

	public void pg() {
		if (pg_options.isDisabled())
			pg_options.setDisable(false);
		else
			pg_options.setDisable(true);
	}

	public void oth() {
		if (oth_options.isDisabled())
			oth_options.setDisable(false);
		else
			oth_options.setDisable(true);
	}

	public void gate() {
		if (gate_options.isDisabled())
			gate_options.setDisable(false);
		else
			gate_options.setDisable(true);
	}
	
	/**
	 * Function for toggling marking scheme
	 */
	public void G_score() {
		System.out.println("G");
		if (G_score.getSelectedToggle().getUserData().equals("C")) {
			G_per.setDisable(true);
			G_cgpa.setDisable(false);
			G_CGPA_tot.setDisable(false);
		} else {
			G_CGPA_tot.setDisable(true);
			G_cgpa.setDisable(true);
			G_per.setDisable(false);
		}
	}

	/**
	 * Function for toggling marking scheme
	 */
	public void PG_score() {
		System.out.println("PG");
		if (PG_score.getSelectedToggle().getUserData().equals("C")) {
			PG_per.setDisable(true);
			PG_cgpa.setDisable(false);
		} else {
			PG_cgpa.setDisable(true);
			PG_per.setDisable(false);
		}
	}

	/**
	 * Initializes all the things that need to be intialized
	 * Common functions and variables
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// Disable enrollment box
		en_num.setText(applicant.getEnrollmentId());
		en_num.setDisable(true);
		
		// Set up streams
		stream_1.setUserData("Computer Science");
		stream_2.setUserData("Electronics and Communication");
		stream_3.setUserData("Computational Biology");

		// Set Up Gender
		gender_1.setUserData("Male");
		gender_2.setUserData("Female");
		
		// Set up category
		category_1.setUserData("General");
		category_2.setUserData("SC");
		category_3.setUserData("ST");
		category_4.setUserData("OBC");
		
		//Set up disabled
		disabled_1.setUserData("Yes");
		disabled_2.setUserData("No");
		
		// Set COW/ WOW
		ch_of_w_1.setUserData("Yes");
		ch_of_w_2.setUserData("No");
		
		
		// Disable unchecked box options
		ece_options.setDisable(true);
		pg_options.setDisable(true);
		oth_options.setDisable(true);
		gate_options.setDisable(true);

		// Set user data for radio button tab 2
		G_score_c.setUserData("C");
		G_score_p.setUserData("P");
		PG_score_c.setUserData("C");
		PG_score_p.setUserData("P");

		// Disable both radio options
		G_CGPA_tot.setDisable(true);
		G_cgpa.setDisable(true);
		PG_cgpa.setDisable(true);
		G_per.setDisable(true);
		PG_per.setDisable(true);
		
		// Set Data for year drop Down
		ObservableList<String> yop = FXCollections.observableArrayList();
		yop.addAll("2003","2004","2005","2006","2007",
				"2008","2009","2010","2011","2012","2013");
		X_yop.setItems(yop);
		XII_yop.setItems(yop);
		G_yog.setItems(yop);
		PG_yog.setItems(yop);
		oth_year.setItems(yop);
		GATE_yog.setItems(yop);

		// Set Up PhD Preferences
		ObservableList<String> PhDPref = FXCollections.observableArrayList();
		PhDPref.addAll(new String[] {"Pref 1", "Pref2" , "Pref3",
				"Pref4", "Pref5"});
		phd1.setItems(PhDPref);
		phd2.setItems(PhDPref);
		phd3.setItems(PhDPref);
		
		// Set data for nationality
		ObservableList<String> nat = FXCollections.observableArrayList();
		nat.addAll("Indian", "NRI", "Others");
		nationality.setItems(nat);
		
		// Set Data for ECE Options
		ObservableList<String> subjects = FXCollections.observableArrayList();
		subjects.addAll("Advanced Signal Processing",
				"Statistical Signal Processing","Digital VLSI Design",
				"Analog CMOS Design","Digital Communications",
				"Communication Network",
				"Linear Systems", "Introduction to Robots",
				"RF Design Circuit",
				"Antennas and Propogation", "Embedded Systems");
		ECE_pref1.setItems(subjects);
		ECE_pref2.setItems(subjects);
		ECE_pref3.setItems(subjects);
		ECE_pref4.setItems(subjects);
		
		// Set data for CCPA_total
		ObservableList<String> cgpa_total = FXCollections.observableArrayList();
		cgpa_total.addAll("4", "10");
		G_CGPA_tot.setItems(cgpa_total);
		PG_CGPA_tot.setItems(cgpa_total);
		
		// Set data for state
		ObservableList<String> states = FXCollections.observableArrayList();
		states.addAll("J&K","Himachal Pradesh","Maharshtra","Uttar Pradesh",
				"Punjab", "Uttrakhand", "Delhi", "Rajasthan", "Madhya Pradesh",
				"Gujarat","Bihar","Jharkhand","West Bengal", "Chattisgarh",
				"Assam","Mizoram","Manipal","Arunachal Pradesh",
				"Sikkim","Meghalaya","Nagaland","Kerela",
				"Andra Pradesh","Hyderabad","Tamil Nadu");
		G_state.setItems(states);
		PG_state.setItems(states);
		
	}

	/**
	 * Function that will temporarily save the users incomplete information	
	 */
	public void saveInfo() {
		String n = nationality.getSelectionModel().getSelectedItem();
		if( n == null)
			System.out.println("NULL");
		else
			System.out.println(n);
	}

	/**
	 * Actions that need to be performed when the user clicks the submit button
	 */
	public void onSubmit() throws ClassNotFoundException, FileNotFoundException, IOException {

		boolean pers = personalGetAndValidate();
		if(pers == false )
			feedback.setText("Please Check Your Personal Details \n");
		
		boolean school = schoolingGetAndValidate();
		if(school == false )
			feedback.setText(feedback.getText() + 
					"Please Check Your Schooling Details \n");
		
		boolean graduation = graduationGetAndValidate();
		if(graduation == false )
			feedback.setText(feedback.getText() + 
					"Please Check Your Graduation Details \n");
		
		if(app_ece.isSelected()) {
			boolean ece = eceGetAndValidate();
			applicant.ece = true;
			if(ece == false )
				feedback.setText(feedback.getText() + 
						"Please Check Your Optional ECE Details \n");
		}
		if(pg.isSelected()) {
			boolean pg = PGGetAndValidate();
			applicant.PG = true;
			if(pg == false )
				feedback.setText(feedback.getText() + 
						"Please Check Your Optional PG Details \n");
			
		}if( oth.isSelected()) {
			boolean oth = otherGetAndValidate();
			applicant.other = true;
			if(oth == false)
			feedback.setText(feedback.getText() + 
					"Please Check Your Optional Other Examination Details \n");
		}if( gate.isSelected()) {
			boolean gate = GATEGetAndValidate();
			applicant.GATE = true;
			if( gate == false)
			feedback.setText(feedback.getText() + 
					"Please Check Your Optional GATE Examination Details \n");
		}
		
		boolean aCVSOP = achievementsGetAndValidate();
		if( aCVSOP == false)
			feedback.setText(feedback.getText() + 
					"Please Check Your Achievments , CV and SOP \n");
		
		boolean PHDprefs = PhDPrefsGetAndValidate();
		if(PHDprefs == false)
		feedback.setText(feedback.getText() + 
				"Please Check Your PhD Preferences \n");
		
		if(feedback.getText().length() == 0) {
			feedback.setText("Succesfull Submit");
			File ApplicantFolder = new File("DATA/Applicants/");
			if(ApplicantFolder.exists()) {
				ObjectOutputStream oos = new ObjectOutputStream(
						new FileOutputStream(new File
								("DATA/Applicants/"+applicant.getEnrollmentId() )
								)
						);
				oos.writeObject(applicant);
				TextFileCreator.create(applicant);
				oos.close();				
			}
			else {
				ApplicantFolder.mkdirs();
				ObjectOutputStream oos = new ObjectOutputStream(
						new FileOutputStream(new File
								("DATA/Applicants/"+applicant.getEnrollmentId() )
								)
						);
				oos.writeObject(applicant);
				oos.close();
			}			
//			ObjectInputStream oin = new ObjectInputStream(
//					new FileInputStream("/home/burhan/Desktop/app.ser"));
//			Applicant prev = (Applicant) oin.readObject();
//			
//			System.out.println("My Name is :" +prev.getPersonalDetails().name);
//			oin.close();
//			
			applicant.setTimeOfSubmit();

			// Saving CV and SOP in different directories
			// File newCV = new File("CV/"+applicant.getEnrollmentId());
			File CVFolder = new File("DATA/CV/");
			File SOPFolder = new File("DATA/SOP/");
			if(CVFolder.exists()){
				cv.renameTo(new File("DATA/CV/"+applicant.getEnrollmentId()));
				sop.renameTo(new File("DATA/SOP/"+applicant.getEnrollmentId()));
			}
			else {
				CVFolder.mkdirs();
				SOPFolder.mkdirs();
				cv.renameTo(new File("DATA/CV/"+applicant.getEnrollmentId()));
				sop.renameTo(new File("DATA/SOP/"+applicant.getEnrollmentId()));
			}
		}
		
		
		
	}
	
	/**
	 * Gets the respective fields that the user entered and validates them	
	 */
	private boolean PhDPrefsGetAndValidate() {
		boolean isValid = false;
		
		if(stream.getSelectedToggle() == null ||
				phd1.getValue()== null ||
				phd2.getValue()== null ||
				phd3.getValue()== null ) return false;
		
		String[] ar = {
				stream.getSelectedToggle().getUserData().toString(),
				phd1.getValue(),phd2.getValue(),phd3.getValue()
		};

		isValid = Validator.validateTextFields( ar );
		
		if( isValid) 
			applicant.setPhDPrefDetails(ar);
		
		return isValid;
	}

	/**
	 * Gets the respective fields that the user entered and validates them	
	 */
	private boolean achievementsGetAndValidate() {
		boolean isValid = false;
		
		if( cv == null || sop == null) 
			return false;
		
		isValid = Validator.validateTextFields(new String[] 
				{achievements.getText()});
		if( isValid) 
			applicant.setAchievementDetails(new String[] 
					{achievements.getText()}, cv, sop);
		return isValid;
	}

	/**
	 * Gets the respective fields that the user entered and validates them	
	 */
	private boolean GATEGetAndValidate() {

		boolean isValid = false;
		
		if(GATE_yog.getValue() == null) return false;
		
		double marks=0 , rank=0, score=0;
		if( Validator.hasOnlyDigits(GATE_rank.getText()))
			rank = Validator.extractNum(GATE_rank.getText());
		else return false;
		if( Validator.hasOnlyDigits(GATE_marks.getText()))
			rank = Validator.extractNum(GATE_marks.getText());
		else return false;
		if( Validator.hasOnlyDigits(GATE_score.getText()))
			rank = Validator.extractNum(GATE_score.getText());
		else return false;
		
		String[] ar = {
				GATE_area.getText(),GATE_yog.getValue()
		};
		
		isValid = Validator.validateTextFields(ar);
		if( isValid ) 
			applicant.setGATEDetails(ar, (long)rank, marks, score);
		return isValid;
	}

	/**
	 * Gets the respective fields that the user entered and validates them	
	 */
	private boolean otherGetAndValidate() {

		boolean isValid = false;
		
		if( oth_year.getValue() == null)return false;
		String[] ar = {
				oth_name.getText(), oth_sub.getText(),
				oth_year.getValue()
				};
		
		double rank=0, score=0;
		if( Validator.hasOnlyDigits(oth_rank.getText()))
			rank = Validator.extractNum(oth_rank.getText());
		else return false;

		if( Validator.hasOnlyDigits(oth_score.getText()))
			score = Validator.extractNum(oth_score.getText());
		else return false;
		
		isValid = Validator.validateTextFields(ar);
		if( isValid)
			applicant.setOtherDetails(ar, (long) rank, score);
		return isValid;
	}

	/**
	 * Gets the respective fields that the user entered and validates them	
	 */
	private boolean PGGetAndValidate() {
		boolean isValid = false;

		if( PG_state.getValue() == null || PG_yog.getValue() == null )
			return false;
		if(PG_score.getSelectedToggle() == null)
			return false;
		boolean cgpa = false;
		String marks, total= "";
		double _marks = 0;
		if(PG_score.getSelectedToggle().getUserData().equals("P"))
			marks = PG_per.getText();
		else {
			cgpa  = true;
			marks = PG_cgpa.getText();
			if(PG_CGPA_tot.getValue() == null)return false;
			else total = PG_CGPA_tot.getValue();
		}
		String[] ar = {PG_deg.getText(), PG_dep.getText(),
				PG_col.getText(), PG_thesis.getText(), PG_city.getText(),
				PG_state.getValue(), PG_yog.getValue(), marks};
		if( Validator.hasOnlyDigits(marks))
			_marks = Validator.extractNum(marks);
		else return false;
		if( _marks == 0.0)return false;

		isValid = Validator.validateTextFields(ar);
		if( isValid)
			applicant.setPGPrefDetails(ar, cgpa, _marks, total);
		
		return isValid;
	}

	/**
	 * Gets the respective fields that the user entered and validates them	
	 */
	private boolean eceGetAndValidate() {
		//		String pref1, pref2, pref3, pref4;
		
		boolean isValid=false;
		int nullCount = 0;
		if(ECE_pref1.getValue()==null )nullCount++;
		if(ECE_pref2.getValue()==null )nullCount++;
		if(ECE_pref3.getValue()==null )nullCount++;
		if(ECE_pref4.getValue()==null )nullCount++;
		
		if( pg.isSelected() && nullCount > 1)
			return false;
		if( !pg.isSelected() && nullCount > 0 )return false;

		String[] ar = { ECE_pref1.getValue(),ECE_pref2.getValue(),
				ECE_pref3.getValue(), ECE_pref4.getValue()};
		
		isValid = Validator.validateTextFields(ar);
		if(isValid)
			applicant.setECEPrefDetails(ar);

		return isValid;
	}

	/**
	 * Gets the respective fields that the user entered and validates them	
	 */
	private boolean graduationGetAndValidate() {
	//		boolean cgpa;
	//		String cgpa_total;
	//		String 	G_deg, G_dep, G_col, G_uni, G_city, G_state, G_yog, G_grades;
		
		boolean isValid = false;
		if( G_state.getValue() == null || G_yog.getValue() == null )
			return false;
		if(G_score.getSelectedToggle() == null)
			return false;
		
		boolean cgpa = false;
		String marks, total="";
		double _marks= 0;
		
		if(G_score.getSelectedToggle().getUserData().equals("P"))
			marks = G_per.getText();
		else {
			System.out.println("NOT HERE");
			cgpa  = true;
			marks = G_cgpa.getText();
			if(G_CGPA_tot.getValue() == null)return false;
			else total = G_CGPA_tot.getValue();
		}
		
		String[] ar = {
				G_deg.getText(), G_dep.getText(),
				G_col.getText(), G_uni.getText(), G_city.getText(),
				G_state.getValue(), G_yog.getValue(), marks
			};
		
		System.out.println("Marks:"+ _marks);

		if( Validator.hasOnlyDigits(marks))
			_marks = Validator.extractNum(marks);
		else return false;

		System.out.println("Marks:"+ _marks);
		
		if( _marks == 0.0)return false;
		
		isValid = Validator.validateTextFields(ar);
		if(isValid) 
			applicant.setGraduationDetails(ar, cgpa, _marks, total);
		

		return isValid;
	}

	/**
	 * Gets the respective fields that the user entered and validates them	
	 */
	private boolean schoolingGetAndValidate() {

		boolean isValid = false;

		if(X_yop.getValue() == null ||
				XII_yop.getValue()==null)
			return false;
		double _xp, _xiip;
		if( !Validator.hasOnlyDigits(X_per.getText()) || 
				!Validator.hasOnlyDigits(XII_per.getText()))
			return false;
		_xp = Validator.extractNum(X_per.getText());
		_xiip = Validator.extractNum(XII_per.getText());

		if(_xp==0 ||_xiip==0)
		return false;

		String[] ar = {
			X_b.getText(), X_yop.getValue(), XII_b.getText(), XII_yop.getValue()
		};
		
		isValid = Validator.validateTextFields(ar);
		if( isValid )
			applicant.setSchoolDetails(ar, _xp, _xiip);
		return isValid;
	}

	/**
	 * Gets the respective fields that the user entered and validates them	
	 */
	public boolean personalGetAndValidate() {
		boolean isValid = false;
		 
		if( gender.getSelectedToggle()==null ||
				category.getSelectedToggle() == null ||
				disabled.getSelectedToggle() == null ||
				dob.getValue() == null ||
				ch_of_w.getSelectedToggle() == null ||
				nationality.getValue() == null) return false;
		
		if( !Validator.validateDate(dob.getValue()))return false;

		
		String[] ar = { name.getText(), email.getText(),corr_add.getText(), 
				perm_add.getText(),fathers_name.getText(),
				gender.getSelectedToggle().getUserData().toString(),
				category.getSelectedToggle().getUserData().toString(),
				disabled.getSelectedToggle().getUserData().toString(),
				dob.getValue().toString(),
				ch_of_w.getSelectedToggle().getUserData().toString(),
				nationality.getValue(),
			};
		
		long _pin = 0, _mobile = 0;
		if(Validator.hasOnlyDigits(mobile.getText()))
			_mobile = (long) Validator.extractNum(mobile.getText());
		if(Validator.hasOnlyDigits(mobile.getText()))
			_pin = (long) Validator.extractNum(pin.getText());
		
		System.out.println(_pin + " " + _mobile );
		
		isValid = Validator.validateTextFields(ar);
		
		if( isValid && _pin!=0 && _mobile!=0) isValid = true;
		else isValid = false;
		if(isValid) 
			applicant.setPersonalDetails(ar, _mobile, _pin);
		return isValid;
	}

	@FXML
	Button upload_cv, upload_sop;
	/**
	 * Upload Handlers
	 * @param Event ent : The event that causes this function call
	 */
	public void upload(Event ent) {
		FileChooser chooser = new FileChooser();
		if(ent.getSource().equals(upload_cv)) {
			chooser.setTitle("Upload CV");
			cv = chooser.showOpenDialog(null);
			if(cv!=null)
				feed_cv.setText(cv.getName());
		}
		else{
			chooser.setTitle("Upload SOP");
			sop = chooser.showOpenDialog(null);
			if(sop!=null)
				feed_sop.setText(sop.getName());			
		}
	}
}
