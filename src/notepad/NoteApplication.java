package notepad;
import java.io.File;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class NoteApplication extends Application {

	
	
	public void start(Stage stage) throws Exception {
		//name and logo set up of notepad
		stage.setTitle("Notepad");
		//logo-> DO LATER**********************
		//setting up the main scene 
		VBox box = new VBox();
		
		//menu creation
		MenuBar menuBar = new MenuBar();
		// menu-> menu item 
		Menu menu = new Menu("File");
		Menu menu1 = new Menu("Text Options");
		Menu menu3 = new Menu("Options");
		Menu menu2 = new Menu("Help");
		
		//add Menus to Menu bar
		menuBar.getMenus().add(menu);
		menuBar.getMenus().add(menu1);
		menuBar.getMenus().add(menu3);
		menuBar.getMenus().add(menu2);

		
		// add options to File menu
		MenuItem menuItem1 = new MenuItem("New");
		MenuItem menuItem2 = new MenuItem("Open");
		MenuItem menuItem3 = new MenuItem("Save");
		MenuItem menuItem4 = new MenuItem("Undo");
		MenuItem menuItem5 = new MenuItem("Redo");
		MenuItem menuItem6 = new MenuItem("Exit");
		
		menu.getItems().add(menuItem1);
		menu.getItems().add(menuItem2);
		menu.getItems().add(menuItem3);
		menu.getItems().add(menuItem4);
		menu.getItems().add(menuItem5);
		menu.getItems().add(menuItem6);
		
		// add options to txt options
		MenuItem menuI = new MenuItem("Bold");
		MenuItem menuI1 = new MenuItem("Italics");
		MenuItem menuI2 = new MenuItem("Underline");
		MenuItem menuI3 = new MenuItem("Font");
		MenuItem menuI4 = new MenuItem("Size");
		MenuItem menuI5 = new MenuItem("Colour");
		
		menu1.getItems().add(menuI);
		menu1.getItems().add(menuI1);
		menu1.getItems().add(menuI2);
		menu1.getItems().add(menuI3);
		menu1.getItems().add(menuI4);
		menu1.getItems().add(menuI5);
		
		// add options to the options 
		MenuItem color = new MenuItem("Colour Scheme");
		MenuItem cursor = new MenuItem("Change Cursor");
		
		menu3.getItems().add(color);
		menu3.getItems().add(cursor);
		
		
		//set up the help pop up window
		MenuItem help= new MenuItem("Help");
		menu2.getItems().add(help);
		menu2.setOnAction(new HelpHandler(new PopHelp()));
		

		
		
        //add the menubar to the GUI 
		
		box.getChildren().add(menuBar);
		
		//add the text thing to the vbox
		TextArea textArea = new TextArea();
		textArea.setPrefSize(500, 500);
		box.getChildren().add(textArea);
		
	
		
		Scene scene = new Scene(box,750,500); 
		
	
		
		stage.setScene(scene);
		
		
		//display the notepad to user
		
		stage.show();
		
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		launch(args);
		
	}

	
}
