import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SmoothArray {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int input[] = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
	//	System.out.println(Arrays.toString(input));
		sc.close();
		int count = 1;
		for (int i = 0; i < input.length; i++) {
			if(i < input.length-1 && (input[i] - input[i+1]) <= 1) {
			//	System.out.println(input[i]+" "+input[i+1]+" i "+i);
				count++;
			}
		}
		if(count == n) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}
