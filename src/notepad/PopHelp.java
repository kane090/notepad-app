package notepad;

import javafx.scene.Scene;
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
	}

	public void show() {
		stage.show();
	}
	public void close() {
		stage.close();
	
	}
}
