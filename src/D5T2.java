import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class D5T2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader("D5T1.txt"));
		
		ArrayList<Integer> sums = new ArrayList<>();
		for(int i = 0; i < 128; i++) {
			for(int j = 0; j < 8; j++) {
				sums.add(i*8+j);
			}
		}
		ArrayList<Integer> calc = new ArrayList<>();
		
		String line;
		int num = 0;
		int low;
		int high;
		int highest = 0;
		while ((line = bufferedReader.readLine()) != null) {
			low = 0;
			high = 128;
			for (int i = 0; i < 7; i++) {
				if (line.charAt(i) == 'B') {
					low = ((low + high) / 2) + 1;
				} else {
					high = ((low + high) / 2);
				}
				//System.out.println("upper" + high + " lower" + low);
			}
			//System.out.println(low-1);
			num = low-1;
			
			low = 0;
			high = 7;
			for (int i = 0; i < 3; i++) {
				if (line.charAt(i+7) == 'R') {
					low = ((low + high) / 2) + 1;
				} else {
					high = ((low + high) / 2);
				}
				//System.out.println("upper" + high + " lower" + low);
				
			}
			//System.out.println(low);
			int sum = num*8+low;
			calc.add(sum);
			if(sum > highest) highest = sum;
		}
		sums.removeAll(calc);
		Collections.sort(sums);
		sums = (ArrayList) sums.stream().distinct().collect(Collectors.toList());
		System.out.println(sums);
		for(int i = 1; i < sums.size(); i++) {
			if(sums.get(i-1)+1 != i && sums.get(i+1)-1 != i) System.out.println(i);
		}
	}
}

