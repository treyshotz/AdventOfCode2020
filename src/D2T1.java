import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class D2T1 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader("D2T1.txt"));
		
		String line;
		int valid = 0;
		while ((line = bufferedReader.readLine()) != null) {
			int a = line.indexOf("-");
			int lower = Integer.parseInt(line.substring(0, a));
			int upper  = Integer.parseInt(line.substring(a+1, line.indexOf(" ")));
			String text = line.substring(line.indexOf(":")+1);
			char c = line.charAt(line.indexOf(":")-1);
			int count = 0;
			for(int i = 0; i <text.length(); i++) {
				if(text.charAt(i) == c) {
					count++;
				}
			}
			if(count >= lower && count <= upper) valid++;
		}
		System.out.println(valid);
	}
}
