package notepad;

import java.io.File;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PopHelp {
	private Stage stage;
	PopHelp(){
		this.stage=new Stage();//new stage
		VBox Help= new VBox();
		Scene scene = new Scene(Help,100, 100);

		stage.setScene(scene);
		stage.setResizable(false);
		
		
		// add the logo 
		Image a = new Image((new File("assets" + File.separator + "logoofNotepad.png")).toURI().toString());
		ImageView v= new ImageView(a);
		stage.getIcons().add(a);

	}

	
	
	
	
	public void show() {
		stage.show();
	}
	public void close() {
		stage.close();
	
	}
}
