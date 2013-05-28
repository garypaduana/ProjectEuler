/*
    Project Euler Solutions
    Copyright (C) 2012-2013, Gary Paduana, gary.paduana@gmail.com
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.gp.projecteuler.problems;

import java.util.ArrayList;
import java.util.List;

import com.gp.projecteuler.CommonMath;

/**
	Surprisingly there are only three numbers that can be written as the sum
	of fourth powers of their digits:
	
	1634 = 1^4 + 6^4 + 3^4 + 4^4
	8208 = 8^4 + 2^4 + 0^4 + 8^4
	9474 = 9^4 + 4^4 + 7^4 + 4^4
	As 1 = 1^4 is not a sum it is not included.
	
	The sum of these numbers is 1634 + 8208 + 9474 = 19316.
	
	Find the sum of all the numbers that can be written as the sum of fifth
	powers of their digits.
 */
public class Problem030 {

	public static void main(String[] args) {
		
		List<Integer> special = new ArrayList<Integer>();
		
		/* Determine what the max range should be.
		 * For a 5 digit number, 5 * 9 ^ 5 = 295245, which is valid
		 * For a 6 digit number, 6 * 9 ^ 5 = 354294, which is valid
		 * For a 7 digit number, 7 * 9 ^ 5 = 413343, which is not valid
		 * 		since the 7 digit number will surely be greater than the sum
		 * 		of the digits to the 5th power.
		 */
		for(int i = 0; i < 354294; i++){
			String str = Integer.toString(i);
			char[] digits = str.toCharArray();
			long sum = 0;
			for(char c : digits){
				sum += Math.pow(Integer.valueOf(String.valueOf(c)), 5);
			}
			
			if(sum == i && i != 1){
				special.add(i);
			}
		}
		
		System.out.println("Answer: " + CommonMath.sumListOfNumber(special));
	}
}
