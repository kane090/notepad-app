package notepad;

import java.io.File;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PopSize {
	private Stage stage;
	private double size;
	TextField tf;
	
	public PopSize(double size) {
		this.size = size;
		this.stage = new Stage(); //new stage
		
		VBox Size = new VBox();
		Scene scene = new Scene(Size,250,50);
		Size.setPadding(new Insets(5,0,0,0));

		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Font Size");
		
		//title of box
		Label changeSize= new Label("	       Change Font Size");
		changeSize.setFont( Font.font("Arial", FontWeight.NORMAL,15));
		changeSize.setPrefSize(250, 10);
		Size.getChildren().add(changeSize);
		
		//add buttons and label/text area
		HBox s= new HBox(5);
		Button increase= new Button();
		Button decrease= new Button();
		tf = new TextField(String.valueOf(this.size));
		tf.setEditable(false);
		
		//add images to buttons 
		Image up = new Image((new File("assets" + File.separator + "LogoMakr_860yq5.png")).toURI().toString());
		Image down = new Image((new File("assets" + File.separator + "LogoMakr_9Twd2T.png")).toURI().toString());
		
		//size them
		ImageView upB=new ImageView(up);
		ImageView downB=new ImageView(down);
		upB.setFitHeight(20);
		upB.setFitWidth(20);
		downB.setFitHeight(20);
		downB.setFitWidth(20);
		
		//set button graphics
		increase.setGraphic(upB);
		decrease.setGraphic(downB);
		increase.setStyle("-fx-background-color: transparent");
		decrease.setStyle("-fx-background-color: transparent");
	
		//set size
		tf.setPrefColumnCount(2);
		
		s.setPadding(new Insets(0,0,0,70));
		increase.setOnAction(new increaseHandler(tf));
		decrease.setOnAction(new decreaseHandler(tf));
	
		s.getChildren().add(increase);
		s.getChildren().add(tf);
		s.getChildren().add(decrease);

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
