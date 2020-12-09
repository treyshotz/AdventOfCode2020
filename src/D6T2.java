import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class D6T2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader("D6T1.txt"));
		
		String line;
		ArrayList<Character> a = new ArrayList<>();
		int sum = 0;
		int numLines = 0;
		int total = 0;
		while ((line = bufferedReader.readLine()) != null) {
			if (line.isBlank()) {
				ArrayList<Character> ab = (ArrayList) a.stream().distinct().collect(Collectors.toList());
				for (int i = 0; i < ab.size(); i++) {
					int num = Collections.frequency(a, ab.get(i));
					if (num == numLines) total++;
				}
				a = new ArrayList<>();
				numLines = 0;
				continue;
			}
			numLines++;
			for (int i = 0; i < line.length(); i++) {
				a.add(line.charAt(i));
			}
		}
		ArrayList<Character> ab = (ArrayList) a.stream().distinct().collect(Collectors.toList());
		for (int i = 0; i < ab.size(); i++) {
			int num = Collections.frequency(a, ab.get(i));
			if (num == numLines) total++;
		}
		
		System.out.println(total);
	}
}
