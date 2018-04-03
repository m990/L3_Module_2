package intro_to_file_io;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Decrypt implements ActionListener {
	JFrame frame = new JFrame();
	JButton button = new JButton();
	JTextArea textArea = new JTextArea();
	public static void main(String[] args) {
		Decrypt e = new Decrypt();
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
	String decrypt(String text) {
		String encrypted = "";
		for (int i = 0; i < text.length(); i++) {
			char c = (char)(text.charAt(i) - 1);
			encrypted += c;
		}
		return encrypted;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String encrypted = decrypt(textArea.getText());
		System.out.println(encrypted);
		try {
			/*
			 * Do the actual file reading here. Everything else is pretty much done
			 */
		}
		catch (IOException e1) {
			System.out.println(e1);
		}
	}
}
