package notepad;

import java.io.PrintWriter;

public class Saver {
	public void save(PrintWriter writer, String font, double size, String color, String text) {
		writer.println("NoteSaveFileVersion1.0");
		writer.println("\tFont and Size: " + font + " " + size);
		writer.println("\tColor: " + color);
		writer.println("\tText:");
		writer.println(text);
		writer.println("EndText");
		writer.println("EndNoteSaveFile");
		writer.close();
	}
}
