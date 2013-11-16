package drumPro;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFile {
	
	public static int numberOfLines = 0;
	private String path;

	public static int getNumLines() {
		return numberOfLines;
	}

	public ReadFile(String file_path) {
		path = file_path;
	}
	
	//readLines method determines # of lines in textfile
	int readLines() throws IOException {
		
		FileReader file_to_read = new FileReader(path);
		BufferedReader bf = new BufferedReader(file_to_read);
		
		String aLine;
		
		while ((aLine = bf.readLine()) != null) {
			numberOfLines++;
		}
		bf.close();
		
		return numberOfLines;
	}
	
	// OpenFile method, goes through n number of lines (# determined by readLines()
	// and reads each line of the file.
	public String[] OpenFile() throws IOException {
		
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
	
		numberOfLines = readLines();
		String[] lineAry = new String[numberOfLines];
		
		for (int i = 0; i<numberOfLines; i++) {
			lineAry[i] = (textReader.readLine());
		}
		
		textReader.close();
		return lineAry;
	}
	
}
