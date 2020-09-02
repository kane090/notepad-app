package notepad;

import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

public class NoteFileParser {
	private TextArea textArea;
	private String ans = "";
	static NoteApplication noteApplication = new NoteApplication();

	private Pattern pFileStart = Pattern.compile("^NoteSaveFileVersion1.0$");
	private Pattern pFileEnd = Pattern.compile("^EndNoteSaveFile$");
	
	private Pattern pFontandSize = Pattern.compile("\tFont and Size: (System|Agency FB|Arial|Bell MT|Book Antiqua|Comic Sans MS|Franklin Gothic Book|High Tower Text|Gill Sans MT|Papyrus|Tahoma|Verdana|MV Boli|Palatino Linotype) ([1-9]|[1-5][0-9]|60)\\.0");

	private Pattern pColor = Pattern.compile("\tColor: (|(-fx-text-fill:(white|darkred|darkblue|darkgreen|hotpink|pink|purple|steelblue|gold|silver|red|blue|green|yellow|orange|brown|grey|black)))");
	
	private Pattern pText = Pattern.compile("\tText:");
	private Pattern pEndText = Pattern.compile("^EndText$");

	public boolean parse(BufferedReader inputStream, TextArea textArea) {
		this.textArea = textArea;
		Font font = null;
		
		try {	
			int state=0; Matcher m; String l;
			
			while ((l = inputStream.readLine()) != null) {
				switch (state) {
					case 0:
						m=pFileStart.matcher(l);
						if(m.matches()) {
							state = 1;
							break;
						}
						System.out.println("Expected Start of Note Save File");
						return false;
					case 1:
						m=pFontandSize.matcher(l);
						if(m.matches()) {
							state = 2;
							font = new Font(m.group(1), Integer.parseInt(m.group(2)));
							this.textArea.setFont(font);
							break;
						}
						System.out.println("Expected Font and Size");
						return false;
					case 2:
						m=pColor.matcher(l);
						if(m.matches()) {
							state = 3;
							if (m.group(2) != "") {
								this.textArea.setStyle(m.group(2));
							}
							break;
						}
						System.out.println("Expected Color");
						return false;
					case 3:
						m=pText.matcher(l);
						if(m.matches()) {
							state = 4;
							break;
						}
						System.out.println("Expected Text");
						return false;
					case 4:
						m=pEndText.matcher(l);
						if(m.matches()) {
							state = 5;
							ans = ans.substring(0, ans.length() - 1);
							break;
						}
						ans += l + "\n";
						break;
					case 5:
						m=pFileEnd.matcher(l);
						if(m.matches()) {
							state = 6;
							this.textArea.setText(ans);
							break;
						}
						System.out.println("Expected End of Note Save File");
						return false;
					case 6:
						if (l != null) {
							this.textArea.clear();
							System.out.println("Did not expect more content");
							return false;
						}
				}
			}
		}  catch (Exception e) {}
		return true;
	}
}
