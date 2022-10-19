package tests;

import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class NEWWordAnalyzerGUI {

	static Map<String, Integer> count(Scanner scanner) {
	    Map<String, Integer> words = new LinkedHashMap<>();
	    while (scanner.hasNext()) {
	        words.merge(scanner.next(), 1, Integer::sum);
	    }
	    return words;
	}

	public static <T> void main(String[] args) throws IOException {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));

		JLabel top = new JLabel("Count the amount of words in your text file by pressing the Enter button");
		JButton btn = new JButton("Enter");
		
		panel.add(top);
		panel.add(btn);
		
		try (Scanner scanner = new Scanner(new File("theraven.txt")).useDelimiter("\\W+")) {
	        Map<String, Integer> map = null;
			try {
				map = count(scanner);
			} catch (Exception e) {
				e.printStackTrace();
			}
					
			try(FileWriter fw = new FileWriter("theraven.txt", true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter out = new PrintWriter(bw)) {
				
				map.entrySet().stream().sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
				.forEach(k -> out.println(k.getKey() + ": " + k.getValue()));
			}
			}		

	JOptionPane.showMessageDialog(btn, "Please Make Sure the text file you want analyzed is in the Project Directory of your IDE before proceeding!","PLEASE READ ME",JOptionPane.INFORMATION_MESSAGE);
	JFrame frame = new JFrame("Word Analyzer");
	 frame.add(panel);
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 frame.pack();
	 frame.setLocationRelativeTo(null);
	 frame.setVisible(true);
	}
	}

	


	


