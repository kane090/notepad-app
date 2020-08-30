package notepad;

import java.io.File;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PopSize {
	private Stage stage;
	PopSize() {     
		this.stage = new Stage(); //new stage
		VBox Size = new VBox();
		Scene scene = new Scene(Size,250,50);
		Size.setPadding(new Insets(5,0,0,0));

		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Alter Font Size");
		
		//title of box
		 Label changeSize= new Label("	        Change Font Size");
		 changeSize.setFont( Font.font("Arial", FontWeight.NORMAL,15));
		 changeSize.setPrefSize(250, 10);
		Size.getChildren().add(changeSize);
		
		//add buttons and label/ text area
		HBox s= new HBox(5);
		Button increase= new Button("inc");
		Button decrease= new Button("dec");
		TextField currentSize= new TextField("12.0");
		currentSize.setEditable(false);
		
		//set  size
		//increase.setPrefWidth(90);
		//decrease.setPrefWidth(90);
		//currentSize.setPrefWidth(70);
		currentSize.setPrefColumnCount(2);
		
		s.setPadding(new Insets(0,0,0,70));
		//currentSize.setPadding(new Insets(0,0,5,0));
		increase.setOnAction(new increaseHandler(currentSize));
		decrease.setOnAction(new decreaseHandler(currentSize));

		 






		
	
		
		s.getChildren().add(increase);
		s.getChildren().add(currentSize);
		s.getChildren().add(decrease);
		//s.setPadding(new Insets(0,0,0,5));
		
		//add to the main layout
		Size.getChildren().add(s);


		
		
		// adding the logo 
		Image a = new Image((new File("assets" + File.separator + "logoofNotepad.png")).toURI().toString());
		stage.getIcons().add(a);
	}

	public void show() {
		stage.show();
	}
	
	public void close() {
		stage.close();
	}

}
