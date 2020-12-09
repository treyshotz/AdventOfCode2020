import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class D6T1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader("D6T1.txt"));
		
		String line;
		ArrayList<Character> a = new ArrayList<>();
		int sum = 0;
		while ((line = bufferedReader.readLine()) != null) {
			if (line.isBlank()) {
				a = (ArrayList) a.stream().distinct().collect(Collectors.toList());
				sum += a.size();
				a = new ArrayList<>();
				continue;
			}
			for (int i = 0; i < line.length(); i++) {
				a.add(line.charAt(i));
			}
		}
		a = (ArrayList) a.stream().distinct().collect(Collectors.toList());
		sum += a.size();
		System.out.println(sum);
	}
}
