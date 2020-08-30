package notepad;

import ObserverObservable.Observable;
import ObserverObservable.Observer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class increaseHandler extends Observable implements EventHandler<ActionEvent> {
	private TextField tf;
	static NoteApplication note= new NoteApplication();
	private int f=12;


	public increaseHandler(TextField currentSize) {
		this.tf=currentSize;
	}
	public void notifyObservers() {
		note.update(this);
		
	}
	public int getFont() {
		return this.f;
	}

	

	@Override
	public void handle(ActionEvent arg0) {
		
		
		String num= (String) tf.getText().subSequence(0, tf.getText().length()-2);
		int font= Integer.valueOf(num);
		if (font>=1 && font<60) {
			font+=1;
			tf.setText((int)font+".0");
			f=font;
			this.notifyObservers();
			
		}

		
		
	}

}
