package file;

import static java.lang.System.out;

import java.io.*;
import static java.lang.System.*;
import java.util.Date;

import tp_fichier.Filtre;

public class Main {
	public static void main(String[] args) throws IOException {
		File rep = new File(".");
	
		out.println("------------ Non filtré -------------------------");
		for (File élément :rep.listFiles()){
			out. print(élément.getName()+"\t");				
			if (élément.getName().length()<8) out.print("\t");
			if (élément.isDirectory()) out.print("<REP>");
			out.printf("\t%tc", new Date(élément.lastModified()));
			out.printf("\t%5d octets\n", élément.length());
		}
		
		out.println("-------------- Filtré ----------------------------");
		for (File élément : rep.listFiles(new Filtre('b'))) {
			out.print(élément.getName()+"\t");
			if (élément.getName().length()<8) out.print("\t");
			if (élément.isDirectory()) out.print("<REP>");
			out.printf("\t%tc", new Date(élément.lastModified()));
			out.printf("\t%5d octets\n", élément.length());
		}
		
	
	}
}
