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
	private boolean isLight = false;
	private boolean isPastelPink = false;
	private boolean isPastelBlue = false;
	private boolean isPastelGreen = false;
	private boolean isRed = false;
	private boolean isBlue = false;
	private boolean isGreen = false;


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
		MenuItem pastelP = new MenuItem("Pastel Pink Mode");
		MenuItem pastelB = new MenuItem("Pastel Blue Mode");
		MenuItem pastelG = new MenuItem("Pastel Green Mode");
		MenuItem green = new MenuItem("Green Mode");
		MenuItem blue = new MenuItem("Blue Mode");
		MenuItem red = new MenuItem("Red Mode");
		color.getItems().add(dark);
		color.getItems().add(light);
		color.getItems().add(pastelP);
		color.getItems().add(pastelB);
		color.getItems().add(pastelG);
		color.getItems().add(green);
		color.getItems().add(blue);
		color.getItems().add(red);

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
		
		//primary colors 
		red.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (!isRed) {
					textArea.setStyle("-fx-text-fill:darkred");
					scene.getRoot().setStyle("-fx-base:red");
					isPastelPink = false;
					isPastelBlue = false;
					isPastelGreen= false;
					isDark=false;
					isLight=false;
					isGreen=false;
					isBlue=false;
					isRed=true;
				}
			}
			
		});
		blue.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (!isBlue) {
					textArea.setStyle("-fx-text-fill:darkblue");
					scene.getRoot().setStyle("-fx-base:blue");
					isPastelPink = false;
					isPastelBlue = false;
					isPastelGreen= false;
					isDark=false;
					isLight=false;
					isGreen=false;
					isBlue=true;
					isRed=false;
				}
			}
			
		});
		green.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (!isGreen) {
					textArea.setStyle("-fx-text-fill:darkgreen");
					scene.getRoot().setStyle("-fx-base:green");
					isPastelPink = false;
					isPastelBlue = false;
					isPastelGreen= false;
					isDark=false;
					isLight=false;
					isGreen=true;
					isBlue=false;
					isRed=false;
				}
			}
			
		});
		
		
		
		//pastel modes
		pastelP.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (!isPastelPink) {
					textArea.setStyle("-fx-text-fill:hotpink");
					scene.getRoot().setStyle("-fx-base:lightpink");
					isPastelPink = true;
					isPastelBlue = false;
					isPastelGreen= false;
					isDark=false;
					isLight=false;
					isGreen=false;
					isBlue=false;
					isRed=false;
				}
			}
			
		});
		pastelB.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (!isPastelBlue) {
					textArea.setStyle("-fx-text-fill:steelblue");
					scene.getRoot().setStyle("-fx-base:lightblue");
					isPastelPink = false;
					isPastelBlue = true;
					isPastelGreen= false;
					isDark=false;
					isLight=false;
					isGreen=false;
					isBlue=false;
					isRed=false;
				}
			}
			
		});
		pastelG.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (!isPastelGreen) {
					textArea.setStyle("-fx-text-fill:green");
					scene.getRoot().setStyle("-fx-base:lightgreen");
					isPastelPink = false;
					isPastelBlue = false;
					isPastelGreen= true;
					isDark=false;
					isLight=false;
					isGreen=false;
					isBlue=false;
					isRed=false;
				}
			}
			
		});
		
		
		//dark + light modes
		dark.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (!isDark) {
					textArea.setStyle("-fx-text-fill:white");
					scene.getRoot().setStyle("-fx-base:black");
					isDark = true;
					isLight=false;
					isPastelPink = false;
					isGreen=false;
					isBlue=false;
					isRed=false;
				}
			}
			
		});
		
		light.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (!isLight) {
					textArea.setStyle("-fx-text-fill:black");
					scene.getRoot().setStyle("-fx-base:white");
					isDark = false;
					isPastelPink=false;
					isLight=true;
					isGreen=false;
					isBlue=false;
					isRed=false;
					
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
