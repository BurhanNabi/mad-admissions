/**
 * 
 */
package user;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * @author Milind 2014064
 */


public class List_Controller implements Initializable{
	
	@FXML private Button back;
	@FXML private TableView<Student> Tbl_Rcds;
	@FXML private TableColumn<Student, SimpleStringProperty> TblClm_Name;
	@FXML private TableColumn<Student, SimpleStringProperty> TblClm_Enum;
	@FXML private TableColumn<List_Controller, Button> TblClm_Link;

	private Parent root;
	private Stage primaryStage = new Stage();
	
	
	public void back(){
		MainA.Students.clear();
		Stage stage = (Stage) back.getScene().getWindow();
		
		try {
			root = FXMLLoader.load(getClass().getResource("Filters.fxml"));
			Scene prscene = new Scene(root,800,900);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Admin Panel");
			primaryStage.setScene(prscene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		stage.close();
	}
	
	
	
	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		TblClm_Name.setCellValueFactory(
		    new PropertyValueFactory<>("Name")
		);
		TblClm_Enum.setCellValueFactory(
		    new PropertyValueFactory<>("EnrollmentNumber")
		);
		TblClm_Link.setCellValueFactory(
			    new PropertyValueFactory<>("DataFile")
			);
		
		Tbl_Rcds.setItems(MainA.Students);
		
		// TODO Auto-generated method stub
		
	}

}
