import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class D2T2 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader("D2T1.txt"));
		
		String line;
		int valid = 0;
		while ((line = bufferedReader.readLine()) != null) {
			int a = line.indexOf("-");
			int first = Integer.parseInt(line.substring(0, a))+1;
			int second  = Integer.parseInt(line.substring(a+1, line.indexOf(" ")))+1;
			String text = line.substring(line.indexOf(":"));
			char c = line.charAt(line.indexOf(":")-1);
			if(text.charAt(first) == c && (text.charAt(second) != c)) {
				valid++;
			} else if(text.charAt(second) == c && (text.charAt(first) != c)) {
				valid++;
			}
		}
		System.out.println(valid);
	}
}
