import java.util.Scanner;

public class StringSorting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		char[] split = s.toCharArray();
		for (int i = 0; i < split.length; i++) {
			for (int j = 0; j < split.length; j++) {
				if(i == j) {
					continue;
				}
				// sorting in descending order by comparing ASCII value 
				if( split[i] >  split[j]) {
					char temp = split[i];
					split[i] = split[j];
					split[j] = temp;
				}
			}
		}
		s = null;
		for (char c : split) {
			if(s == null) {
				s = Character.toString(c);
			} else {
				s = s+c;
			}
			
		}
		System.out.println(s);
	}

}
