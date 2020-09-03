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
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	public TextArea textArea = new TextArea();

	public void start(Stage stage) throws Exception {
		
		// name of notepad app
		stage.setTitle("#Note");
		
		// setting up the main scene
		VBox box = new VBox();
		
		// menubar creation
		MenuBar menuBar = new MenuBar();
		
		// menubar menus 
		Menu menu = new Menu("File");
		Menu menu2 = new Menu("Edit");
		Menu menu1 = new Menu("Text Options");
		Menu menu3 = new Menu("Options");
		
		// add Menus to Menu bar
		menuBar.getMenus().addAll(menu, menu2, menu1, menu3);
		
		// add options to File menu
		MenuItem menuItem1 = new MenuItem("New");
		MenuItem menuItem2 = new MenuItem("Open");
		MenuItem menuItem3 = new MenuItem("Save");
		MenuItem menuItem4 = new MenuItem("Undo");
		MenuItem menuItem5 = new MenuItem("Redo");
		MenuItem menuItem6 = new MenuItem("Exit");
		
		menu.getItems().addAll(menuItem1, menuItem2, menuItem3, menuItem4, menuItem5, menuItem6);

		// add options to edit menu
		MenuItem menuItema = new MenuItem("Cut");
		MenuItem menuItemb = new MenuItem("Copy");
		MenuItem menuItemc = new MenuItem("Paste");
		MenuItem menuItemd = new MenuItem("Select All");
		
		menu2.getItems().addAll(menuItema, menuItemb, menuItemc, menuItemd);
			
		// add options to text options
		Menu menuI3 = new Menu("Font");
		MenuItem menuI4 = new MenuItem("Size");
		Menu menuI5 = new Menu("Colour");
		
		menu1.getItems().addAll(menuI3, menuI4, menuI5);
	
		
		// add options to the options 
		Menu color = new Menu("Colour Scheme");
		Menu cursor = new Menu("Change Cursor");
		MenuItem help = new MenuItem("Help");
		
		// adding color options to color submenu
		MenuItem White= new MenuItem("White");
		MenuItem Black= new MenuItem("Black");
		MenuItem DarkRed= new MenuItem("Dark Red");
		MenuItem DarkBlue= new MenuItem("Dark Blue");
		MenuItem DarkGreen= new MenuItem("Dark Green");
		MenuItem HotPink= new MenuItem("Hot Pink");
		MenuItem Pink= new MenuItem("Pink");
		MenuItem Purple= new MenuItem("Purple");
		MenuItem SteelBlue= new MenuItem("Steel Blue");
		MenuItem Gold= new MenuItem("Gold");
		MenuItem Silver= new MenuItem("Silver");
		MenuItem Red= new MenuItem("Red");
		MenuItem Blue= new MenuItem("Blue");
		MenuItem Green= new MenuItem("Green");
		MenuItem Yellow= new MenuItem("Yellow");
		MenuItem Orange= new MenuItem("Orange");
		MenuItem Brown= new MenuItem("Brown");
		MenuItem Grey= new MenuItem("Grey");
		
		menuI5.getItems().addAll(White, Black, DarkRed, DarkBlue, DarkGreen, HotPink, Pink, Purple, SteelBlue, Gold, Silver, Red, Blue, Green, Yellow, Orange, Brown, Grey);
		
		// adding the color spoilers
		//DarkBlue
		ImageView DB =new ImageView (new Image((new File("assets" + File.separator + "darkblue.png")).toURI().toString()));
		DB.setFitHeight(10);
		DB.setFitWidth(10);
		DarkBlue.setGraphic(DB);
		//Black
		ImageView black =new ImageView (new Image((new File("assets" + File.separator + "black.png")).toURI().toString()));
		black.setFitHeight(10);
		black.setFitWidth(10);
		Black.setGraphic(black);
		//DarkRed
		ImageView DR =new ImageView (new Image((new File("assets" + File.separator + "darkred.png")).toURI().toString()));
		DR.setFitHeight(10);
		DR.setFitWidth(10);
		DarkRed.setGraphic(DR);
		//DarkGreen
		ImageView DG =new ImageView (new Image((new File("assets" + File.separator + "gd.png")).toURI().toString()));
		DG.setFitHeight(10);
		DG.setFitWidth(10);
		DarkGreen.setGraphic(DG);
		//HotPink
		ImageView hp =new ImageView (new Image((new File("assets" + File.separator + "hotpink.png")).toURI().toString()));
		hp.setFitHeight(10);
		hp.setFitWidth(10);
		HotPink.setGraphic(hp);
		//Pink
		ImageView p =new ImageView (new Image((new File("assets" + File.separator + "pink.png")).toURI().toString()));
		p.setFitHeight(10);
		p.setFitWidth(10);
		Pink.setGraphic(p);
		//Purple
		ImageView pp =new ImageView (new Image((new File("assets" + File.separator + "purple.png")).toURI().toString()));
		pp.setFitHeight(10);
		pp.setFitWidth(10);
		Purple.setGraphic(pp);
		//SteelBlue
		ImageView sb =new ImageView (new Image((new File("assets" + File.separator + "sb.png")).toURI().toString()));
		sb.setFitHeight(10);
		sb.setFitWidth(10);
		SteelBlue.setGraphic(sb);
		//Gold
		ImageView gold =new ImageView (new Image((new File("assets" + File.separator + "gold.png")).toURI().toString()));
		gold.setFitHeight(10);
		gold.setFitWidth(10);
		Gold.setGraphic(gold);
		//Silver
		ImageView silver =new ImageView (new Image((new File("assets" + File.separator + "silver.png")).toURI().toString()));
		silver.setFitHeight(10);
		silver.setFitWidth(10);
		Silver.setGraphic(silver);
		//Red
		ImageView rd =new ImageView (new Image((new File("assets" + File.separator + "red.png")).toURI().toString()));
		rd.setFitHeight(10);
		rd.setFitWidth(10);
		Red.setGraphic(rd);
		//Blue
		ImageView ble =new ImageView (new Image((new File("assets" + File.separator + "blue.png")).toURI().toString()));
		ble.setFitHeight(10);
		ble.setFitWidth(10);
		Blue.setGraphic(ble);
		//Green
		ImageView gr =new ImageView (new Image((new File("assets" + File.separator + "green.png")).toURI().toString()));
		gr.setFitHeight(10);
		gr.setFitWidth(10);
		Green.setGraphic(gr);
		//Yellow
		ImageView y =new ImageView (new Image((new File("assets" + File.separator + "yellow.png")).toURI().toString()));
		y.setFitHeight(10);
		y.setFitWidth(10);
		Yellow.setGraphic(y);
		//Orange
		ImageView or =new ImageView (new Image((new File("assets" + File.separator + "orange.png")).toURI().toString()));
		or.setFitHeight(10);
		or.setFitWidth(10);
		Orange.setGraphic(or);
		//Brown
		ImageView br =new ImageView (new Image((new File("assets" + File.separator + "brown.png")).toURI().toString()));
		br.setFitHeight(10);
		br.setFitWidth(10);
		Brown.setGraphic(br);
		//Grey
		ImageView gy =new ImageView (new Image((new File("assets" + File.separator + "grey.png")).toURI().toString()));
		gy.setFitHeight(10);
		gy.setFitWidth(10);
		Grey.setGraphic(gy);

		
		
		// Cursor Options
		MenuItem cursor1 = new MenuItem("EXID Lightstick");
		MenuItem cursor2 = new MenuItem("Ice Cream");
		MenuItem cursor3 = new MenuItem("Dark Mouse");
		MenuItem cursor4 = new MenuItem("Light Mouse");
		MenuItem cursor5 = new MenuItem("Batman Logo");
		
		cursor.getItems().addAll(cursor1, cursor2, cursor3, cursor4, cursor5);
		
		
		// color scheme options 
		MenuItem dark = new MenuItem("Dark Mode");
		MenuItem light = new MenuItem("Light Mode");
		MenuItem pastelP = new MenuItem("Pastel Pink Mode");
		MenuItem pastelB = new MenuItem("Pastel Blue Mode");
		MenuItem pastelG = new MenuItem("Pastel Green Mode");
		MenuItem green = new MenuItem("Green Mode");
		MenuItem blue = new MenuItem("Blue Mode");
		MenuItem red = new MenuItem("Red Mode");
		
		color.getItems().addAll(dark, light, pastelP, pastelB, pastelG, green, blue, red);

		menu3.getItems().addAll(help, color, cursor);
		
		// font options
		MenuItem agencyfb = new MenuItem("Agency FB");
		MenuItem arial = new MenuItem("Arial");
		MenuItem bellmt = new MenuItem("Bell MT");
		MenuItem bookantiqua = new MenuItem("Book Antiqua");
		MenuItem comicsansms = new MenuItem("Comic Sans MS");
		MenuItem def = new MenuItem("Default");
		MenuItem franklingothicbook = new MenuItem("Franklin Gothic Book");
		MenuItem hightowertext = new MenuItem("High Tower Text");
		MenuItem gillsansmt = new MenuItem("Gill Sans MT");
		MenuItem papyrus = new MenuItem("Papyrus");
		MenuItem tahoma = new MenuItem("Tahoma");
		MenuItem verdana = new MenuItem("Verdana");
		MenuItem mvboli = new MenuItem("MV Boli");
		MenuItem palatinolinotype = new MenuItem("Palatino Linotype");
		
		menuI3.getItems().addAll(agencyfb, arial, bellmt, bookantiqua, comicsansms, def, franklingothicbook, hightowertext, gillsansmt, papyrus, tahoma, verdana, mvboli, palatinolinotype);
		
		//set up the help pop up window
		help.setOnAction(new HelpHandler(new PopHelp()));
		
        //add the menubar to the GUI
		box.getChildren().add(menuBar);
		
		//add the text area to the vbox
		textArea.setPrefSize(900,900);
		
		//adding textarea to GUI
		box.getChildren().add(textArea);
		
		//setting up size changing pop-up
		PopSize popSize = new PopSize(textArea);
		menuI4.setOnAction(new SizeHandler(popSize));
		
		//exit button
		menuItem6.setOnAction(e -> Platform.exit());
				
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
					NoteFileParser parser = new NoteFileParser();
					parser.parse(bufferedReader, textArea, popSize);
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
		
		//undo button
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
				Font font = new Font("Agency FB", textArea.getFont().getSize());
				textArea.setFont(font);
			}
		});
		
		arial.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Font font = new Font("Arial", textArea.getFont().getSize());
				textArea.setFont(font);
			}
		});
		
		bellmt.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Font font = new Font("Bell MT", textArea.getFont().getSize());
				textArea.setFont(font);
			}
		});
		
		bookantiqua.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Font font = new Font("Book Antiqua", textArea.getFont().getSize());
				textArea.setFont(font);
			}
		});
		
		comicsansms.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Font font = new Font("Comic Sans MS", textArea.getFont().getSize());
				textArea.setFont(font);
			}
		});
		
		def.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Font font = new Font("System", textArea.getFont().getSize());
				textArea.setFont(font);

			}
		});
		
		franklingothicbook.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Font font = new Font("Franklin Gothic Book", textArea.getFont().getSize());
				textArea.setFont(font);
			}
		});
		
		hightowertext.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Font font = new Font("High Tower Text", textArea.getFont().getSize());
				textArea.setFont(font);
			}
		});
		
		gillsansmt.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Font font = new Font("Gill Sans MT", textArea.getFont().getSize());
				textArea.setFont(font);
			}
		});
		
		papyrus.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Font font = new Font("Papyrus", textArea.getFont().getSize());
				textArea.setFont(font);
			}
		});
		
		tahoma.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Font font = new Font("Tahoma", textArea.getFont().getSize());
				textArea.setFont(font);

			}
		});
		
		verdana.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Font font = new Font("Verdana", textArea.getFont().getSize());
				textArea.setFont(font);
			}
		});
		
		mvboli.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Font font = new Font("MV Boli", textArea.getFont().getSize());
				textArea.setFont(font);
			}
		});
		
		palatinolinotype.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Font font = new Font("Palatino Linotype", textArea.getFont().getSize());
				textArea.setFont(font);
			}
		});
		
		Scene scene = new Scene(box,750,500);
		
		//new button 
		menuItem1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				textArea.clear();
				Font font = new Font("System", 12.0);
				textArea.setFont(font);
				textArea.setStyle("");
				scene.getRoot().setStyle("");
				if (!isLight) {
					isPastelPink = false;
					isPastelBlue = false;
					isPastelGreen= false;
					isDark=false;
					isLight=true;
					isGreen=false;
					isBlue=false;
					isRed=false;
				}
				popSize.updateText("12.0");
			}
		});
		
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
		
		
		//pastel colors
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
					isPastelBlue = false;
					isPastelGreen= false;
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
					textArea.setStyle("");
					scene.getRoot().setStyle("");
					isDark = false;
					isPastelBlue = false;
					isPastelGreen= false;
					isPastelPink=false;
					isLight=true;
					isGreen=false;
					isBlue=false;
					isRed=false;
				}
			}
		});
		
		
		//add the cursor icons 
		cursor1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Image image = new Image((new File("assets" + File.separator + "free.png")).toURI().toString()); //pass in the image path
				scene.setCursor(new ImageCursor(image));
				textArea.setId("TA");
				textArea.getScene().lookup("#TA .content").setCursor(new ImageCursor(image)); //setting cursor throughout TextArea
			}
		});
		
		cursor2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Image image1 = new Image((new File("assets" + File.separator + "ice.png")).toURI().toString()); //pass in the image path
				scene.setCursor(new ImageCursor(image1));
				textArea.setId("TA");
				textArea.getScene().lookup("#TA .content").setCursor(new ImageCursor(image1)); //setting cursor throughout TextArea
			}
		});
		
		cursor3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Image image2 = new Image((new File("assets" + File.separator + "today.png")).toURI().toString()); //pass in the image path
				scene.setCursor(new ImageCursor(image2));
				textArea.setId("TA");
				textArea.getScene().lookup("#TA .content").setCursor(new ImageCursor(image2)); //setting cursor throughout TextArea
			}
		});
		
		cursor4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Image image3 = new Image((new File("assets" + File.separator + "last.png")).toURI().toString()); //pass in the image path
				scene.setCursor(new ImageCursor(image3));
				textArea.setId("TA");
				textArea.getScene().lookup("#TA .content").setCursor(new ImageCursor(image3)); //setting cursor throughout TextArea
			}
		});
		
		cursor5.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Image image4 = new Image((new File("assets" + File.separator + "prev.png")).toURI().toString()); //pass in the image path
				scene.setCursor(new ImageCursor(image4));
				textArea.setId("TA");
				textArea.getScene().lookup("#TA .content").setCursor(new ImageCursor(image4)); //setting cursor throughout TextArea
			}
		});
		
		
		//change color of text
		//white
		White.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				textArea.setStyle("-fx-text-fill:white");
			}
		});	
		
		//black
		Black.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				textArea.setStyle("");
			}
		});	
		
		//dark red
		DarkRed.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				textArea.setStyle("-fx-text-fill:darkred");
			}
		});	
		
		//dark blue
		DarkBlue.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				textArea.setStyle("-fx-text-fill:darkblue");
			}
		});	
		
		//dark green
		DarkGreen.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				textArea.setStyle("-fx-text-fill:darkgreen");
			}
		});	
		
		//hot pink
		HotPink.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				textArea.setStyle("-fx-text-fill:hotpink");
			}
		});	
		
		//pink
		Pink.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				textArea.setStyle("-fx-text-fill:pink");
			}
		});	
		
		//purple
		Purple.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				textArea.setStyle("-fx-text-fill:purple");
			}
		});	
		
		//steel blue
		SteelBlue.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				textArea.setStyle("-fx-text-fill:steelblue");
			}
		});	
		
		//gold
		Gold.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				textArea.setStyle("-fx-text-fill:gold");
			}
		});	
		
		//silver
		Silver.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				textArea.setStyle("-fx-text-fill:silver");
			}
		});	
		
		//red
		Red.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				textArea.setStyle("-fx-text-fill:red");	
			}
		});	
		
		//blue
		Blue.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				textArea.setStyle("-fx-text-fill:blue");
			}
		});	
		
		//green
		Green.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				textArea.setStyle("-fx-text-fill:green");
			}
		});	
		
		//yellow
		Yellow.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				textArea.setStyle("-fx-text-fill:yellow");	
			}
		});	
		
		//orange
		Orange.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				textArea.setStyle("-fx-text-fill:orange");	
			}
		});	
		
		//brown
		Brown.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				textArea.setStyle("-fx-text-fill:brown");
			}
		});	
		
		//grey
		Grey.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				textArea.setStyle("-fx-text-fill:grey");
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
