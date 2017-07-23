package com.hackerrank.july1217.movieratings;

import java.io.IOException;
import java.util.Scanner;

public class MovieRatings {
	
	/*
sample ip/op

5
9
-1
-3
4
5

17

sample ip/op

5
-1
-2
-3
-4
-5

-6
	  
	 */

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
        int res;
        
        int _ratings_size = 0;
        _ratings_size = Integer.parseInt(in.nextLine().trim());
        int[] _ratings = new int[_ratings_size];
        int _ratings_item;
        for(int _ratings_i = 0; _ratings_i < _ratings_size; _ratings_i++) {
            _ratings_item = Integer.parseInt(in.nextLine().trim());
            _ratings[_ratings_i] = _ratings_item;
        }
        
        res = maximizeRatings(_ratings);
        System.out.println(res);
        in.close();
	}
	
	static int maximizeRatings(int[] ratings) {
		int sum = 0;
		int neg = 0;
		int min = 0;
		int rem = 0;
		for (int i = 0; i < ratings.length; i++) {
			if(ratings[i] < 0) { neg++; }
			if(min > ratings[i]) {
				min = ratings[i];
			}
		}
		
		boolean skiped = false;
		for (int i = 0; i < ratings.length; i++) {
			if(min == ratings[i]) {
				ratings[i] = 0;
				rem = 1;
			}
		}
		for (int i = 0; i < ratings.length; i++) {
			if(skiped == false && ratings[i] < 0 && (rem != 1 || neg > 2)) {
				System.out.println("Skipped: "+i+" "+ratings[i]);
				skiped = true;
			} else {
				skiped = false;
				System.out.println("i: "+i+" sum "+sum+" + "+ratings[i]);
				sum = sum + ratings[i];
			}
		}
		System.out.println(neg+" "+min);
		return sum;
    }

}
