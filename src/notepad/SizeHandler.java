package notepad;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SizeHandler implements EventHandler<ActionEvent> {
	private PopSize size;

	public SizeHandler(PopSize popSize) {
		this.size=popSize;
	}

	public void handle(ActionEvent event) {
		size.show();
	}
}
