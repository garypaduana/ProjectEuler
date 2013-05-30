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
	It can be seen that the number, 125874, and its double, 251748, contain
	exactly the same digits, but in a different order.
	
	Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x,
	contain the same digits.
 */
public class Problem052 {

	public static void main(String[] args) {
		int i = 0;
		outer:
		while(true){
			i++;
			for(int factor = 1; factor <= 6; factor++){
				if(!CommonMath.isInSamePermutationSet(
						Integer.toString(i), String.valueOf(factor * i))){
					continue outer;
				}
			}
			
			System.out.println("Answer: " + i);
			break;
		}
	}
}
