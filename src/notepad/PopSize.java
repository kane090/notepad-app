package notepad;

import java.io.File;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PopSize {
	private Stage stage;
	private TextField tf;
	
	public PopSize(TextArea textArea) {
		this.stage = new Stage(); //new stage
		
		VBox Size = new VBox();
		Scene scene = new Scene(Size,250,50);
		Size.setPadding(new Insets(5,0,0,0));

		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Font Size");
		
		//title of box
		Label changeSize = new Label("	       Change Font Size");
		changeSize.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
		changeSize.setPrefSize(250, 10);
		Size.getChildren().add(changeSize);
		
		//add buttons and label/text area
		HBox s = new HBox(5);
		Button enter = new Button("Enter");
		tf = new TextField(String.valueOf(textArea.getFont().getSize()));
	
		//set size
		tf.setPrefColumnCount(3);
		
		s.setPadding(new Insets(0,0,0,70));
		
		//adding button and textfield to pop-up
		s.getChildren().addAll(tf, enter);

		//add to the main layout
		Size.getChildren().add(s);
		
		enter.setOnAction(new EnterEventHandler(tf, textArea));

		// adding the logo 
		Image a = new Image((new File("assets" + File.separator + "logoofNotepad.png")).toURI().toString());
		stage.getIcons().add(a);
	}
	
	public void updateText(String number) {
		tf.setText(number);
	}

	public void show() {
		stage.show();
	}
	
	public void close() {
		stage.close();
	}
}
