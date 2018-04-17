import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Todo implements ActionListener {
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	JButton add = new JButton();
	JButton remove = new JButton();
	JButton save = new JButton();
	JButton load = new JButton();
	ArrayList<String> todoList = new ArrayList<>();
	public static void main(String[] args) {
		Todo td = new Todo();
		td.panel.add(td.add);
		td.panel.add(td.remove);
		td.panel.add(td.save);
		td.panel.add(td.load);
		td.add.addActionListener(td);
		td.remove.addActionListener(td);
		td.save.addActionListener(td);
		td.load.addActionListener(td);
		td.add.setText("Add");
		td.remove.setText("Remove");
		td.save.setText("Save");
		td.load.setText("Load");
		td.frame.add(td.panel);
		td.frame.setVisible(true);
		td.frame.setSize(200, 100);
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/todo.txt"));
			String line = br.readLine();
			while (line != null) {
				td.todoList.add(line);
				System.out.println(line);
				line = br.readLine();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, td.todoList);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == add) {
			System.out.println("Add");
			String item = JOptionPane.showInputDialog("Enter thing todo:");
			todoList.add(item);
		}
		else if (e.getSource() == remove) {
			System.out.println("Remove");
			String item = JOptionPane.showInputDialog("Enter thing to remove:");
			boolean found = false;
			String item3 = "";
			for (String item2: todoList) {
				System.out.println(item2);
				if (item2.equals(item)) {
					found = true;
					item3 = item2;
				}
			}
			if (found) {
				System.out.println("found");
				todoList.remove(item3);
				System.out.println(todoList);
			}
		}
		else if (e.getSource() == save) {
			System.out.println("Save");
			if (todoList.isEmpty()) {
				try {
					FileWriter fw = new FileWriter("src/todo.txt");
					fw.write("");
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				try {
					FileWriter fw = new FileWriter("src/todo.txt");
					fw.write("");
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (String item: todoList) {
					try {
						FileWriter fw = new FileWriter("src/todo.txt", true);
						System.out.println("Made file writer");
						System.out.println(item + "\n");
						fw.write(item + "\n");
						fw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Something went wrong");
					}
				}
			}
		}
		else if (e.getSource() == load) {
			System.out.println("Load");
			for (String item: todoList) {
				try {
					BufferedReader br = new BufferedReader(new FileReader("src/todo.txt"));
					String line = br.readLine();
					while (line != null) {
						todoList.add(line);
						line = br.readLine();
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}
