package notepad;

import java.io.File;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PopHelp {
	private Stage stage;
	PopHelp() {
		this.stage = new Stage(); //new stage
		VBox Help = new VBox();
		Scene scene = new Scene(Help,500,125);
		stage.setResizable(false);
		stage.setTitle("Help");
		//txtoptionsq
		 Label changeSize= new Label("	                     What Are Text Options?");
		 changeSize.setFont( Font.font("Verdana", FontWeight.BOLD,15));
		 changeSize.setPrefSize(500, 30);
		 Help.getChildren().add(changeSize);
		 
		 
		 //TEXT OPTIONS
		 Label tO= new Label(" Text Options offer a variety of ways to customize how  you want to format your \n text. There are 13 unique fonts and 18 font colors to choose from!");
		 tO.setFont( Font.font("Verdana", FontWeight.NORMAL,12));
		 changeSize.setPrefSize(500, 30);
		 Help.getChildren().add(tO);
		 
		 //optionsq
		 Label op= new Label("	                          What Are Options?");
		 op.setFont( Font.font("Verdana", FontWeight.BOLD,15));
		 op.setPrefSize(500, 30);
		 Help.getChildren().add(op);
		 
		 //options 
		 Label opti= new Label(" Options allows the user to choose from 8 colour schemes and  5 unique cursors.");
		 opti.setFont( Font.font("Verdana", FontWeight.NORMAL,12));
		 opti.setPrefSize(500, 30);
		 Help.getChildren().add(opti);
		 
		stage.setScene(scene);
		stage.setResizable(false);
		
		
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
