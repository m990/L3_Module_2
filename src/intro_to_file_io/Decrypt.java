package intro_to_file_io;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Decrypt implements ActionListener {
	JFrame frame = new JFrame();
	JButton button = new JButton();
	JTextArea textArea = new JTextArea();
	JLabel label = new JLabel();
	String labelText;
	public static void main(String[] args) {
		Decrypt e = new Decrypt();
		 e.frame.setLayout(null);
		 e.button.setBounds(0, 0, 100, 30);
		 e.label.setBounds(10, 0, 100, 70);
		 e.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 e.button.setText("Decrypt");
		 e.button.addActionListener(e);
		 e.frame.add(e.label);
		 e.label.setText(e.labelText);
		 e.frame.add(e.button);
		 e.frame.setVisible(true);
		 e.frame.setSize(100, 100);
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
		String line = "";
		String fileName = "";
		// TODO Auto-generated method stub
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			fileName = jfc.getSelectedFile().getAbsolutePath();
			System.out.println(fileName);
		}
		try {
			labelText = "";
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			line = br.readLine();
			while (line != null) {
				System.out.println(line);
				String decryptedText = decrypt(""+line);
				labelText += decryptedText;
				label.setText(decryptedText);
				System.out.println(decryptedText);
				line = br.readLine();
			}
		}
		catch (FileNotFoundException e2) {
			System.out.println("can't find file");
		}
		catch (IOException e1) {
			System.out.println("e1");
		}
	}
}
