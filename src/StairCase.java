/**
 * 
 *
 * Your teacher has given you the task of drawing a staircase structure. Being
 * an expert programmer, you decided to make a program to draw it for you
 * instead. Given the required height, can you print a staircase as shown in the
 * example?
 *
 * Input
 * You are given an integer N depicting the height of the staircase.
 *
 * Output
 * Print a staircase of height N that consists of # symbols and spaces.
 * For example for N=6, here's a staircase of that height:
 *
 *      #
 *     ##
 *    ###
 *   ####
 *  #####
 * ######
 *
 * Note: The last line has 0 spaces before it.
 *
 * @see https://www.hackerrank.com/challenges/staircase
 *
 */
public class StairCase {

	public static void main(String[] args) {
		StairCaseSol(6);
	}

	public static void StairCaseSol(int n) {

		for (int i = 0; i <= n; i++) {
			// string to hold the staircase
			String s = "";
			if (i != 0) {
				// this appends the spaces
				for (int j = 0; j < (n - i); j++) {
					s = s + " ";
				}
				// this appends the #
				for (int j = (n - i); j < n; j++) {
					s = s + "#";
				}
				System.out.println(s);
			}
		}
	}
}