import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		}
		else if (e.getSource() == save) {
			System.out.println("Save");
		}
		else if (e.getSource() == load) {
			System.out.println("Load");
		}
	}
}
