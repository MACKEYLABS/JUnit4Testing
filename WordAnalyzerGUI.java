package cen3024c;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WordAnalyzerGUI {
	
	public static void main(String[] args) throws IOException {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
	
		JLabel top = new JLabel("Count the amount of words in your text file by pressing the Enter button");
		JButton btn = new JButton("Enter");
		
		panel.add(top);
		panel.add(btn);
		
			//1. create input stream and scanner		
			FileInputStream findIt = new FileInputStream("theraven.txt");
			Scanner fileInput = new Scanner(findIt);

			//2. creation of array list for String and Integer type 
			ArrayList<String> words = new ArrayList<String>();
			ArrayList<Integer> count = new ArrayList<Integer>();

			//3. Reading through file and to find the words/strings
			while (fileInput.hasNext()) {
		
				//4. Getting the word and passing to file input 
				String nextWord = fileInput.next();
		
				//5. checking if the word is in the array list with if statement
				if (words.contains(nextWord)) {
					int index = words.indexOf(nextWord);
					count.set(index,  count.get(index)+ 1);
				}
				else {
					words.add(nextWord);
					count.add(1);
				}
			}
			
			//6. closing input streams
			fileInput.close();
			findIt.close();
			
			//lambda expression for action listener
			btn.addActionListener(e -> { //Lambda expression 
			
			//7. Print out the results to file
			for (int i = 0; i < words.size(); ++i) {
				Collections.sort(count, Collections.reverseOrder());
		
				//8. creating FileWriter to write output to the file
				try(FileWriter fw = new FileWriter("theraven.txt", true);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter out = new PrintWriter(bw))
				{
					out.println();
					out.println(words.get(i) + " occurred " + count.get(i) + " times ");
				
				//9. exception handling for FileWriter	
				} catch (IOException e1) {
				}
			}});
			JOptionPane.showMessageDialog(btn, "Please Make Sure the text file you want analyzed is in the Project Directory of your IDE before proceeding!","PLEASE READ ME",JOptionPane.INFORMATION_MESSAGE);
				JFrame frame = new JFrame("Word Analyzer");
				 frame.add(panel);
				 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 frame.pack();
				 frame.setLocationRelativeTo(null);
				 frame.setVisible(true);
				}
	}
	

	
	

