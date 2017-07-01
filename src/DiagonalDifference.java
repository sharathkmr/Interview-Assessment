/*
Given a square matrix of size *N × N*, calculate the absolute difference between the sums of its diagonals.

**Input Format**

The first line contains a single integer, *N*. The next *N* lines denote the matrix's rows, with each line 
containing *N* space-separated integers describing the columns.

**Output Format**

Print the absolute difference between the two sums of the matrix's diagonals as a single integer.

**Sample Input**

	3
	11 2 4
	4 5 6
	10 8 -12

**Sample Output**

15

**Explanation**

The primary diagonal is:

	11
		5
			-12

Sum across the primary diagonal: 11 + 5 - 12 = 4

The secondary diagonal is:
	
			4
		5
	10

Sum across the secondary diagonal: 4 + 5 + 10 = 19

Difference: |4 - 19| = 15
 
https://www.hackerrank.com/challenges/diagonal-difference

*/


import java.util.Scanner;

public class DiagonalDifference {
	
	public static void main(String[] args) {
		// to scan the input and store it in a matrix
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        
        System.out.println(difference(a,n));
        
        in.close();
	}
	
	public static int difference(int a[][], int n) {
		// primary diagonal sum
		int dif1=0;
		// secondary diagonal sum
		int dif2=0;
		// final result
		int res=0;
		// variable used to iterate the secondary
		// diagonal elements
		int x=0;
		int z=(n-1);
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				// to count sum of primary diagonal elements
				if(i==j) {
					dif1=dif1+a[i][j];
				}
			}
			// sum of secondary diagonal elements
			dif2=dif2+a[x][z];
			x++;
			z--;
		}
		
		// to find the difference of the diagonal sums
		if(dif1>dif2) {
			res=dif1-dif2;
		}else if(dif1<dif2) {
			res=dif2-dif1;
		}
		return res;
	}

}
