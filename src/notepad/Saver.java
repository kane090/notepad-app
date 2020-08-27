package notepad;

import java.io.PrintWriter;

public class Saver {
	public void save(PrintWriter writer, String font, double size, String color, String text) {
		writer.println("Note Save File Version 1.0");
		writer.println("\tFont: " + font);
		writer.println("\tSize: " + size);
		writer.println("\tColor: " + color);
		writer.println("\tText: ");
		writer.println(text);
		writer.println("End");
		writer.close();
	}
}
