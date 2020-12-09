import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class D4T1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader("D4T1.txt"));
		
		String byr = "byr";
		String iyr = "iyr";
		String eyr = "eyr";
		String hgt = "hgt";
		String hcl = "hcl";
		String ecl = "ecl";
		String pid = "pid";
		//String cid = "cid";
		ArrayList<String> a = new ArrayList<>(Arrays.asList(byr, iyr, eyr, hgt, hcl, ecl, pid));
		String line;
		int count = 0;
		int resultCounter = 0;
		while ((line = bufferedReader.readLine()) != null) {
			if(line.isBlank()) {
				if(count==7) {
					resultCounter++;
				}
				a = new ArrayList<>(Arrays.asList(byr, iyr, eyr, hgt, hcl, ecl, pid));
				count = 0;
				continue;
			}
			for(int i = 0; i < a.size(); i++) {
				if(line.contains(a.get(i))) {
					count++;
				}
			}
		}
		System.out.println(resultCounter);
	}
	
}
