package intro_to_file_io;

import java.io.File;

public class Copyright {
	public static void main(String[] args) {
		Copyright c = new Copyright();
		c.addCopyright();
	}
	void addCopyright() {
		File file = new File("src/intro_to_file_io");
		for (int i = 0; i < file.listFiles().length; i++) {
			System.out.println(file.listFiles()[i]);
			if ((""+file.listFiles()[i]).contains(".java")) {
				System.out.println("Contains .java");
			}
		}
	}
}
