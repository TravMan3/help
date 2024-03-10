package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class SetExerciseApplication {
	
	static Set<String> pokerHands = new HashSet<>();

	public static void main(String[] args) throws IOException {
		
		extracted();
		
		
		// remove ACE HIGH and QUEEN HIGH
		pokerHands.remove("ACE HIGH");
		pokerHands.remove("QUEEN HIGH");
		System.out.println("____________________");
		printToConsole();
		// Update PAIR to DEUCES
		if (pokerHands.contains("PAIR")) {
			pokerHands.remove("PAIR");
			pokerHands.add("DEUCES");
		}
		System.out.println("___________________");
		printToConsole();
		
	}

	private static void extracted() throws FileNotFoundException, IOException {
		FileInputStream fileInput = new FileInputStream("PokerHands.csv");
		InputStreamReader read = new InputStreamReader(fileInput);
		BufferedReader fileRead = new BufferedReader(read);
		fileRead.readLine();
		String line;
		while((line = fileRead.readLine()) != null) {
			String[]spot = line.split(",");
			pokerHands.add(spot[1]);
			System.out.println(spot[1]);
		}
		fileRead.close();
	}
	
	public static void printToConsole() {
		for (String poke :pokerHands) {
			System.out.println(poke);
			}
	}
	
}
