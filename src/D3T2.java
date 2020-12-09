import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class D3T2 {
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
		
		index = 0;
		int count2 = 0;
		bufferedReader = new BufferedReader(new FileReader("D3T1.txt"));
		while ((line = bufferedReader.readLine()) != null) {
			if(line.charAt(index) == '#') count2++;
			index += 1;
			index = index % 31;
		}
		
		index = 0;
		int count3 = 0;
		bufferedReader = new BufferedReader(new FileReader("D3T1.txt"));
		while ((line = bufferedReader.readLine()) != null) {
			if(line.charAt(index) == '#') count3++;
			index += 5;
			index = index % 31;
		}
		
		int count4 = 0;
		index = 0;
		bufferedReader = new BufferedReader(new FileReader("D3T1.txt"));
		while ((line = bufferedReader.readLine()) != null) {
			if(line.charAt(index) == '#') count4++;
			index += 7;
			index = index % 31;
		}
		
		index = 0;
		int count5 = 0;
		int loopCounter = 0;
		bufferedReader = new BufferedReader(new FileReader("D3T1.txt"));
		while ((line = bufferedReader.readLine()) != null) {
			loopCounter++;
			if(loopCounter % 2 == 0) {
				continue;
			}
			if(line.charAt(index) == '#') count5++;
			index += 1;
			index = index % 31;
		}
		System.out.println(count + " " + count2 + " " + count3 + " " + count4 + " " + count5);
		long a = (long) count*count2*count3*count4*count5;
		System.out.println(a);
	}
}
