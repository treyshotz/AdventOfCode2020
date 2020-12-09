import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4T2 {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader("D4T1.txt"));
		
		ArrayList<Integer> notTrue = new ArrayList<>();
		ArrayList<Integer> passCounte = new ArrayList<>();
		String line;
		int count = 0;
		int lineCounter = 0;
		int globalCount = 0;
		int passCounter = 0;
		while ((line = bufferedReader.readLine()) != null) {
			lineCounter++;
			if (line.isBlank()) {
				passCounter++;
				if (count == 7) {
					globalCount++;
				} else {
					notTrue.add(lineCounter);
					passCounte.add(passCounter);
				}
				count = 0;
				continue;
			}
			if (findByr(line)) count++;
			if (findHgt(line)) count++;
			if (findIyr(line)) count++;
			if (findEyr(line)) count++;
			if (findHcl(line)) count++;
			if (findEcl(line)) count++;
			if (findPid(line)) count++;
		}
		if (count == 7) {
			globalCount++;
		} else {
			notTrue.add(lineCounter);
		}
		System.out.println(globalCount);
		//System.out.println(notTrue.toString());
		System.out.println(passCounte.toString());
	}
	
	static boolean findByr(String line) {
		int min = 1920;
		int max = 2002;
		int index = line.indexOf("byr");
		if (index == -1) return false;
		String a = line.substring(index);
		StringTokenizer st = new StringTokenizer(a);
		a = st.nextToken();
		String clean = a.replaceAll("\\D+", "");
		//int age = Integer.parseInt(line.substring(index + 4, index + 8).strip());
		int age = Integer.parseInt(clean);
		if (age >= min && age <= max) {
			return true;
		}
		return false;
	}
	
	static boolean findHgt(String line) {
		int cmMin = 150;
		int cmMax = 193;
		int inMin = 59;
		int inMax = 76;
		int index = line.indexOf("hgt");
		if (index == -1) return false;
		String a = line.substring(index);
		boolean inBool = false;
		boolean cmBool = false;
		StringTokenizer st = new StringTokenizer(a);
		a = st.nextToken();
		if (a.contains("in")) {
			inBool = true;
		} else if (a.contains("cm")) {
			cmBool = true;
		}
		String clean = a.replaceAll("\\D+", "");
		int i = Integer.parseInt(clean);
		if (inBool && i >= inMin && i <= inMax) return true;
		else if (cmBool && i >= cmMin && i <= cmMax) return true;
		return false;
	}
	
	static boolean findIyr(String line) {
		int max = 2020;
		int min = 2010;
		int index = line.indexOf("iyr");
		if (index == -1) return false;
		String a = line.substring(index);
		StringTokenizer st = new StringTokenizer(a);
		a = st.nextToken();
		String clean = a.replaceAll("\\D+", "");
		int i = Integer.parseInt(clean);
		if (i >= min && i <= max) return true;
		return false;
	}
	
	
	static boolean findEyr(String line) {
		int max = 2030;
		int min = 2020;
		int index = line.indexOf("eyr");
		if (index == -1) return false;
		String a = line.substring(index);
		StringTokenizer st = new StringTokenizer(a);
		a = st.nextToken();
		String clean = a.replaceAll("\\D+", "");
		int i = Integer.parseInt(clean);
		if (i >= min && i <= max) return true;
		return false;
	}
	
	static boolean findHcl(String line) {
		int index = line.indexOf("hcl");
		if (index == -1) return false;
		String a = line.substring(index);
		StringTokenizer st = new StringTokenizer(a);
		a = st.nextToken();
		a = a.substring(a.indexOf(":")+1);
		boolean hash = a.contains("#");
		boolean valid = true;
		for(int i = 1; i < a.length(); i++) {
			int c = a.charAt(i);
			if(!((c >= 48 && c <= 57 ) || (c >= 97 && c <= 102))) valid = false;
		}
		if(hash && valid) {
			return true;
		}
		return false;
	}
	
	static boolean findEcl(String line) {
		String amb = "amb";
		String blu = "blu";
		String brn = "brn";
		String gry = "gry";
		String grn = "grn";
		String hzl = "hzl";
		String oth = "oth";
		int index = line.indexOf("ecl");
		if (index == -1) return false;
		String a = line.substring(index);
		StringTokenizer st = new StringTokenizer(a);
		a = st.nextToken();
		ArrayList<String> arr = new ArrayList<>(Arrays.asList(amb, blu, brn, gry, grn, hzl, oth));
		for (String r : arr) {
			if (a.contains(r)) {
				return true;
			}
		}
		return false;
	}
	
	static boolean findPid(String line) {
		int index = line.indexOf("pid");
		if (index == -1) return false;
		String a = line.substring(index);
		StringTokenizer st = new StringTokenizer(a);
		a = st.nextToken();
		String clean = a.replaceAll("\\D+", "");
		if (clean.length() == 9) {
			return true;
		}
		return false;
	}
}