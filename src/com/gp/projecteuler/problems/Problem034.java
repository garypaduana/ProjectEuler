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

import com.gp.projecteuler.CommonMath;

/**
	145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
	
	Find the sum of all numbers which are equal to the sum of the factorial
	of their digits.
	
	Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */
public class Problem034 {

	public static void main(String[] args) {

		long totalSum = 0;
		// TODO: Find a more appropriate upper limit to this loop
		outer:
		for(int i = 0; i < 100000; i++){
			++i;
			String numStr = Long.toString(i);
			long sum = 0;
			for(int j = 0; j < numStr.length(); j++){
				sum += CommonMath.factorial(Integer.valueOf(numStr.substring(j, j + 1)));
				if(sum > i){
					continue outer;
				}
			}
			if(sum == i && sum != 1 && sum != 2){
				System.out.println("Matches condition: " + i);
				totalSum += i;
			}
		}
		
		System.out.println("Answer: " + totalSum);
	}
}
