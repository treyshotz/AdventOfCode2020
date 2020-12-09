import java.io.*;
import java.util.ArrayList;

public class D1T1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader("D1T1.txt"));
		
		ArrayList<Integer> a = new ArrayList<>();
		String line;
		
		while ((line = bufferedReader.readLine()) != null) {
			a.add(Integer.parseInt(line));
		}
		for(int i = 0; i <a.size(); i++) {
			for (int j = 0; j < a.size(); j++) {
				if(a.get(i) + a.get(j) == 2020) {
					System.out.println(a.get(i)*a.get(j));
				}
			}
		}
	}
}
