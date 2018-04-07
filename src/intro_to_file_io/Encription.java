package intro_to_file_io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Encription implements ActionListener {
	JFrame frame = new JFrame();
	JButton button = new JButton();
	JTextArea textArea = new JTextArea();
	public static void main(String[] args) {
		 Encription e = new Encription();
		 e.frame.setLayout(null);
		 e.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 e.textArea.setBounds(10, 10, 200, 200);
		 e.button.setBounds(250, 20, 100, 30);
		 e.button.setText("Encrypt");
		 e.button.addActionListener(e);
		 e.frame.add(e.textArea);
		 e.frame.add(e.button);
		 e.frame.setVisible(true);
		 e.frame.setSize(300, 300);
	}
	String encrypt(String text) {
		String encrypted = "";
		for (int i = 0; i < text.length(); i++) {
			char c = (char)(text.charAt(i) + 1);
			encrypted += c;
		}
		return encrypted;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Unimplimted methods");
		// TODO Auto-generated method stub
		String encrypted = encrypt(textArea.getText());
		System.out.println(encrypted);
		try {
			FileWriter fw = new FileWriter("src/intro_to_file_io/encrypted.txt");
			fw.write(encrypted);
			fw.close();
			System.out.println("Through try");
		}
		catch (IOException e1) {
			System.out.println(e1);
		}
	}
}
// Copyright (c) Max Norman 2018