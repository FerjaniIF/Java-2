package tp2_fichier;

import java.io.*;
public class TestCopy {
	public static void main(String[] args) throws IOException {
		File inputFile = new File("D:\\fichiers\\in.txt");
		File outputFile = new File("D:\\fichiers\\out.txt");
		FileReader in = new FileReader(inputFile);
		FileWriter out = new FileWriter(outputFile);
		int c;
		while ((c = in.read()) != -1) {
			out. write(c);
		}
		in. close();
		out.close();
	
	}
}