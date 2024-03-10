package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapExerciseApplication {

	public static void main(String[] args) throws IOException {
		Map<String, Integer> pokerHands = new HashMap<>();
	
		readFile(pokerHands);
		
		System.out.println(pokerHands);
	}

	private static void readFile(Map<String, Integer> pokerHands) throws FileNotFoundException, IOException {
		FileInputStream fileInput = new FileInputStream("PokerHands.csv");
		InputStreamReader read = new InputStreamReader(fileInput);
		BufferedReader fileRead = new BufferedReader(read);
		fileRead.readLine();
		String line;
		Integer i = 0;
		while ((line = fileRead.readLine()) != null) {
			String[] spot = line.split(",");
			if (spot[1].equals("FLUSH")) {
			pokerHands.put(spot[0], i++);
		}
		}
		fileRead.close();
	}
	
	
}
