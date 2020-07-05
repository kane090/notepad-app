package notepad;
import java.io.File;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class NoteApplication extends Application {
	private boolean isBold=false;

	
	
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
		Menu menu2 = new Menu("Edit");
		Menu menu1 = new Menu("Text Options");
		Menu menu3 = new Menu("Options");
		
		//add Menus to Menu bar
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
		
		//add options to edit menu
		MenuItem menuItema = new MenuItem("Cut");
		MenuItem menuItemb = new MenuItem("Copy");
		MenuItem menuItemc = new MenuItem("Paste");
		MenuItem menuItemd = new MenuItem("Select All");
		
		menu2.getItems().add(menuItema);
		menu2.getItems().add(menuItemb);
		menu2.getItems().add(menuItemc);
		menu2.getItems().add(menuItemd);
		
	
		
		
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
		MenuItem help = new MenuItem("Help");

		menu3.getItems().add(help);
		menu3.getItems().add(color);
		menu3.getItems().add(cursor);
		
		
		//set up the help pop up window
		help.setOnAction(new HelpHandler(new PopHelp()));
		

		
		
        //add the menubar to the GUI 
		
		box.getChildren().add(menuBar);
		
		//add the text thing to the vbox
		TextArea textArea = new TextArea();
		textArea.setPrefSize(500,500);
		box.getChildren().add(textArea);
		
		//italic button 
		textArea.setStyle("-fx-background-color: pink");
		//bold button
		menuI.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println(isBold);
				if(!isBold) {
			   textArea.setStyle("-fx-font-weight:bold");
			     isBold=true;
				}
				else {
					
					   textArea.setStyle("-fx-font-weight:normal");
					 isBold=false;

					
				}
			}
		});
	
		//exit button
		menuItem6.setOnAction(e -> Platform.exit());
		
		//new button 
		menuItem1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
			   textArea.setText(null);
			}
		});
		
		
		
		//cut button 
		menuItema.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
			   textArea.cut();
			}
		});
		
		//copy button
		menuItemb.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
			   textArea.copy();
			}
		});
		
		//paste button
		menuItemc.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
			   textArea.paste();
			}
		});
		
		//select all button 
		menuItemd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
			   textArea.selectAll();
			   
			}
		});
		
		Scene scene = new Scene(box,750,500); 
		
	
		
		stage.setScene(scene);
		
		// add the logo 
				Image a = new Image((new File("assets" + File.separator + "logoofNotepad.png")).toURI().toString());
				ImageView v= new ImageView(a);
				stage.getIcons().add(a);
		
		//display the notepad to user
		
		stage.show();
		
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		launch(args);
		
	}

	
}
