package intro_to_file_io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Copyright {
	public static void main(String[] args){
		Copyright c = new Copyright();
		try {
			c.addCopyright();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void addCopyright() throws IOException {
		File file = new File("src/intro_to_file_io");
		for (int i = 0; i < file.listFiles().length; i++) {
			System.out.println(file.listFiles()[i]);
			if ((""+file.listFiles()[i]).contains(".java")) {
				System.out.println("Contains .java");
				FileWriter fw = new FileWriter(file.listFiles()[i], true);
				fw.append("// Copyright (c) Max Norman 2018");
				fw.close();
			}
		}
	}
}
// Copyright (c) Max Norman 2018