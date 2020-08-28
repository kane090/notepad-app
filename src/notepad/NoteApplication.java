package notepad;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

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
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
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
		Menu menuI3 = new Menu("Font");
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
		
		// font options
		MenuItem agencyfb = new MenuItem("Agency FB");
		MenuItem arial = new MenuItem("Arial");
		MenuItem bellmt = new MenuItem("Bell MT");
		MenuItem bookantiqua = new MenuItem("Book Antiqua");
		MenuItem comicsansms = new MenuItem("Comic Sans MS");
		MenuItem franklingothicbook = new MenuItem("Franklin Gothic Book");
		MenuItem hightowertext = new MenuItem("High Tower Text");
		MenuItem gillsansmt = new MenuItem("Gill Sans MT");
		MenuItem papyrus = new MenuItem("Papyrus");
		MenuItem tahoma = new MenuItem("Tahoma");
		MenuItem verdana = new MenuItem("Verdana");
		MenuItem mvboli = new MenuItem("MV Boli");
		MenuItem palatinolinotype = new MenuItem("Palatino Linotype");
		menuI3.getItems().add(agencyfb);
		menuI3.getItems().add(arial);
		menuI3.getItems().add(bellmt);
		menuI3.getItems().add(bookantiqua);
		menuI3.getItems().add(comicsansms);
		menuI3.getItems().add(franklingothicbook);
		menuI3.getItems().add(hightowertext);
		menuI3.getItems().add(gillsansmt);
		menuI3.getItems().add(papyrus);
		menuI3.getItems().add(tahoma);
		menuI3.getItems().add(verdana);
		menuI3.getItems().add(mvboli);
		menuI3.getItems().add(palatinolinotype);
		
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
		
		//open button
		menuItem2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				FileChooser fc = new FileChooser();
				File file = fc.showOpenDialog(stage);
				
				if (file != null) {
					System.out.println("Opening: " + file.getName() + "." + "\n");
					BufferedReader bufferedReader = null;
					try {
						bufferedReader = new BufferedReader(new FileReader(file));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		//save button
		menuItem3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				FileChooser fc = new FileChooser();
				File file = fc.showSaveDialog(stage);

				if (file != null) {
					System.out.println("Saving: " + file.getName() + "." + "\n");
					PrintWriter writer = null;
					Saver save = null;
					try {
						writer = new PrintWriter(file);
						save = new Saver();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					save.save(writer, textArea.getFont().getFamily(), textArea.getFont().getSize(), textArea.getStyle(), textArea.getText());
				}
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
		
		// font buttons
		agencyfb.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println(Font.getFamilies());
//				Font font = new Font("Agency FB", 12);
//				textArea.setFont(font);
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
