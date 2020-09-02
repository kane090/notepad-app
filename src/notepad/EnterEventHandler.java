package notepad;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class EnterEventHandler implements EventHandler<ActionEvent> {
	private TextField tf;
	private TextArea ta;
	
	public EnterEventHandler(TextField tf, TextArea ta) {
		this.tf = tf;
		this.ta = ta;
	}

	public void handle(ActionEvent event) {
        try {
        	double size = Double.parseDouble(this.tf.getText());
            if (size >= 1.0 && size <= 60.0) {
            	Font font = new Font(ta.getFont().getFamily(), size);
            	ta.setFont(font);
            }
            else {
            	System.out.println("Please enter a value between 1.0 and 60.0 inclusive.");
            }
        }
        catch (NumberFormatException nfe) {
        	System.out.println("Not a number! Please enter a value between 1.0 and 60.0 inclusive.");
        }
	}
}
