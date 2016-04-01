package user;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainA extends Application {
//	 private Stage primaryStage;
	
	private Parent root;
	static ObservableList<Student> Students = FXCollections.observableArrayList();
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			root = FXMLLoader.load(getClass().getResource("Filters.fxml"));
			Scene scene = new Scene(root,800,900);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Admin Panel");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
