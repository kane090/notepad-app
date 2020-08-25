package notepad;
import java.io.File;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NoteApplication extends Application {
	private boolean isDark = false;


	public void start(Stage stage) throws Exception {
		
		// name and logo set up of notepad
		stage.setTitle("Notepad");
		
		// setting up the main scene
		VBox box = new VBox();
		
		// menu creation
		MenuBar menuBar = new MenuBar();
		
		// menu-> menu item 
		Menu menu = new Menu("File");
		Menu menu2 = new Menu("Edit");
		Menu menu1 = new Menu("Text Options");
		Menu menu3 = new Menu("Options");
		
		// add Menus to Menu bar
		menuBar.getMenus().add(menu);
		menuBar.getMenus().add(menu2);
		menuBar.getMenus().add(menu1);
		menuBar.getMenus().add(menu3);

		
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
		
		// add options to edit menu
		MenuItem menuItema = new MenuItem("Cut");
		MenuItem menuItemb = new MenuItem("Copy");
		MenuItem menuItemc = new MenuItem("Paste");
		MenuItem menuItemd = new MenuItem("Select All");
		
		menu2.getItems().add(menuItema);
		menu2.getItems().add(menuItemb);
		menu2.getItems().add(menuItemc);
		menu2.getItems().add(menuItemd);
			
		// add options to txt options
		MenuItem menuI3 = new MenuItem("Font");
		MenuItem menuI4 = new MenuItem("Size");
		MenuItem menuI5 = new MenuItem("Colour");
		
		menu1.getItems().add(menuI3);
		menu1.getItems().add(menuI4);
		menu1.getItems().add(menuI5);
		
		// add options to the options 
		Menu color = new Menu("Colour Scheme");
		MenuItem cursor = new MenuItem("Change Cursor");
		MenuItem help = new MenuItem("Help");
		
		// color scheme options
		MenuItem dark = new MenuItem("Dark Mode");
		MenuItem light = new MenuItem("Light Mode");
		color.getItems().add(dark);
		color.getItems().add(light);

		menu3.getItems().add(help);
		menu3.getItems().add(color);
		menu3.getItems().add(cursor);
		
		//set up the help pop up window
		help.setOnAction(new HelpHandler(new PopHelp()));
		
        //add the menubar to the GUI
		box.getChildren().add(menuBar);
		
		//add the text area to the vbox
		TextArea textArea = new TextArea();
		textArea.setPrefSize(900,900);
		box.getChildren().add(textArea);
	
		//exit button
		menuItem6.setOnAction(e -> Platform.exit());
		
		//new button 
		menuItem1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
			   textArea.setText(null);
			}
		});
		
		
		//redo button
		menuItem5.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
			   textArea.redo();
			}
		});
		
		
		
		//undo button-4
		menuItem4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
			   textArea.undo();
			}
		});
		
		
		//cut button 
		menuItema.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
			   textArea.cut();
			}
		});
		
		//copy button
		menuItemb.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
			   textArea.copy();
			}
		});
		
		//paste button
		menuItemc.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
			   textArea.paste();
			}
		});
		
		//select all button 
		menuItemd.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
			   textArea.selectAll();
			   
			}
		});
		
		Scene scene = new Scene(box,750,500);
		
		//setting up color scheme buttons
		dark.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (!isDark) {
					textArea.setStyle("-fx-text-fill:white");
					scene.getRoot().setStyle("-fx-base:black");
					isDark = true;
				}
			}
			
		});
		
		light.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (isDark) {
					textArea.setStyle("-fx-text-fill:black");
					scene.getRoot().setStyle("-fx-base:white");
					isDark = false;
				}
			}
			
		});
		
		// setting the stage
		stage.setScene(scene);
		
		// adding the logo 
		Image a = new Image((new File("assets" + File.separator + "logoofNotepad.png")).toURI().toString());
		stage.getIcons().add(a);
		
		//display the notepad to user
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
