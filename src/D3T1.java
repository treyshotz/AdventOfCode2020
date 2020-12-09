import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class D3T1 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader("D3T1.txt"));
		
		String line;
		int index = 0;
		int count = 0;
		while ((line = bufferedReader.readLine()) != null) {
			if(line.charAt(index) == '#') count++;
			index += 3;
			index = index % 31;
		}
		System.out.println(count);
	}
}
