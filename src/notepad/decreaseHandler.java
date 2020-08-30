package notepad;

import ObserverObservable.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class decreaseHandler extends Observable implements EventHandler<ActionEvent> {
	private TextField tf;
	static NoteApplication note= new NoteApplication();
	private int font=12;


	public decreaseHandler(TextField currentSize) {
		this.tf=currentSize;
	}
	public void notifyObservers() {
		note.update(this);
		
	}
	public int getFont() {
		return this.font;
	}

	@Override
	public void handle(ActionEvent arg0) {
		Button dec = (Button)(arg0.getSource());
		String num= (String) tf.getText().subSequence(0, tf.getText().length()-2);
		int newN= Integer.valueOf(num);
		if (newN>=2) {
			newN-=1;
			tf.setText((int)newN+".0");
			font=newN;
			this.notifyObservers();

			
		}


	}

}
