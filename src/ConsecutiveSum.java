
import java.util.Scanner;

public class ConsecutiveSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int res;
		long _num;
		_num = Long.parseLong(in.nextLine().trim());
		in.close();
		res = consecutive(_num);
		System.out.println(res);

	}

	// passes more test cases in hackerrank - 8
	// and 9 - 13 have performance issues
	static int consecutive(long num) {
		int way = 0;
		int sum = 0;

		for (int j = 1; j <= num / 2; j++) {
			inner: for (int i = j; i <= num / 2; i++) {
				if (i == j) {
					sum = i + i + 1;
					i = i + 1;
				} else { sum = sum + i; }

				if (sum > num) {
					sum = 0;
					break inner;
				}
				if (sum == num) {
					way = way + 1;
					sum = 0;
					break inner;
				}
			}
		}
		return way;
	}
}
