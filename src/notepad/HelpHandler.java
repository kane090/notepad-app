package notepad;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HelpHandler implements EventHandler<ActionEvent> {
	private PopHelp help;

	public HelpHandler(PopHelp popHelp) {
		this.help = popHelp;
	}

	public void handle(ActionEvent event) {
		help.show();
	}

}
