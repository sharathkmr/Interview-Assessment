import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LongEnodedString {
	
	/*
	 Sample Inputs

	 2110#(2)
	 
	 23#(2)24#25#26#23#(3)
	 
	 1(2)23(3)
	 
	 2110#(2)
	 
	 */

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
        int[] res;
        String _s;
        try {
            _s = in.nextLine();
        } catch (Exception e) {
            _s = null;
        }
        
        res = frequency(_s);
        System.out.println(Arrays.toString(res));
        in.close();
    }
	
	static int[] frequency(String s) {
		String[] split = s.split("");
		System.out.println(Arrays.toString(split));
		// to hold the count of the alphabets
		//	int[0] = a, int[1] = b,......, int[25] = z
		int[] alphas = new int[26];
		
		for (int i = 0; i < split.length; i++) {
			// if i+2 position has # then it takes the two digits before #
			// and increments in the alphas at that index
			if(i < split.length -2 && split[i+2].equals("#")) {
				// if the consecutive occurrences is present after the 2digit encoded alpha letter
				// and in alpha that position has 0, then it increments the count
				// otherwise it skips the increment as the consecutive occurrences needs to be added
				if(i < split.length -3 && split[i+3].equals("(")) {
					System.out.println("alpha "+split[i]+split[i+1]+" split[i+3] = (");
					if(alphas[Integer.parseInt(split[i]+split[i+1])-1] == 0) {
						alphas[Integer.parseInt(split[i]+split[i+1])-1]++;
					}
				} else {
					System.out.println("alpha "+split[i]+split[i+1]);
					alphas[Integer.parseInt(split[i]+split[i+1])-1]++;
				}
				
			// if consecutive occurrences is found and the alpha value at that number is 1
			// it simply replaces the consecutive occurences value otherwise
			// if its value is greater than 1 it adds the consecutive occurrences as we assume that
			// there are two consecutive occurrences of the same alphabet in single input
			} else if(split[i].equals("(")) {
				if(i >= 3 && split[i-1].equals("#")) {
					System.out.println("alpha "+split[i-3]+split[i-2]);
					System.out.println(alphas[Integer.parseInt(split[i-3]+split[i-2])-1]);
					// if consecutive occurrences is found and the alpha value at that number is 1
					// it simply replaces the consecutive occurences value otherwise
					if(alphas[Integer.parseInt(split[i-3]+split[i-2])-1] == 1) {
						System.out.println(alphas[Integer.parseInt(split[i-3]+split[i-2])-1]+" "+Integer.parseInt(split[i+1]) );
                        alphas[Integer.parseInt(split[i-3]+split[i-2])-1] = Integer.parseInt(split[i+1]);
                        System.out.println("replaced count: "+alphas[Integer.parseInt(split[i-3]+split[i-2])-1]);
                    // if the alpha value at that number is greater than 1 it adds the consecutive occurrences as we assume that
            		// there are two consecutive occurrences of the same alphabet in single input
					}else if(alphas[Integer.parseInt(split[i-3]+split[i-2])-1] > 1){
						System.out.println(alphas[Integer.parseInt(split[i-3]+split[i-2])-1]+" "+Integer.parseInt(split[i+1]) );
                        
						alphas[Integer.parseInt(split[i-3]+split[i-2])-1]+= Integer.parseInt(split[i+1]);
					}
					// and on other scenarios it simply replaces the alpha count value at that index
					else {
						alphas[Integer.parseInt(split[i-3]+split[i-2])-1] = Integer.parseInt(split[i+1]);
					}
				// in single digit encode it doesn't have a # after it, its just a single digit
				// so if we find a single digit consecutive occurrences we just replace
				// the alpha at that number
				} else {
					System.out.println("alpha "+split[i-1]);
					alphas[Integer.parseInt(split[i-1])-1] = Integer.parseInt(split[i+1]);
				}
				System.out.println("count "+split[i+1]);
				System.out.println();
			}
			// in single digit encode it doesn't have a # after it, its just a single digit
			// so we simply increment the alpha at that index and we ignore if we iterate through
			// #, (, ) symbols in iteration
			else {
				// ignoring #, (, ) symbols in iteration
				if(split[i].equals("#") || 
						(i<split.length-1) && split[i+1].equals("#") ||
						split[i].equals(")") || 
						(i > 1 && split[i-1].equals("(")) || 
						(i< split.length-1 && split[i+1].equals(")"))) {
				// getting the single digit occurrences and incrementing the alpha value
				// at that index
				} else {
					System.out.println("alpha "+split[i]);
					alphas[Integer.parseInt(split[i])-1]++;
				}
				
			}
		}
		System.out.println(Arrays.toString(alphas));
        return alphas;

    }

}
