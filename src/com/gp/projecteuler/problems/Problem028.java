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

/**
	Starting with the number 1 and moving to the right in a clockwise
	direction a 5 by 5 spiral is formed as follows:
	
	(21)  22   23   24  (25)
	 20   (7)   8   (9)  10
	 19    6   (1)   2   11
	 18   (5)   4   (3)  12
	(17)  16   15   14  (13)
	
	It can be verified that the sum of the numbers on the diagonals is 101.
	
	What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral
	formed in the same way?
 */
public class Problem028 {

	public static void main(String[] args) {
		
		int referenceDistanceUntilNext = 1;
		int currentDistanceUntilNext = 1;
		int countAtCurrentDistance = 0;
		
		List<Integer> diagonalList = new ArrayList<Integer>();
		diagonalList.add(1);
		
		// Create a state machine and traverse the spiral
		for(int i = 2; i <= (1001 * 1001); i++){
			if(currentDistanceUntilNext > 0){
				currentDistanceUntilNext--;
			}
			else{
				diagonalList.add(i);
				countAtCurrentDistance++;
				
				// 4 means all 4 corners have been encountered
				// and a revolution around the spiral occurred
				if(countAtCurrentDistance == 4){
					countAtCurrentDistance = 0;
					// The distance between diagonal numbers grows
					// by 2 each revolution around the spiral
					referenceDistanceUntilNext += 2;
				}
				currentDistanceUntilNext = referenceDistanceUntilNext;
			}
		}
		int sum = 0;
		for(int i : diagonalList){
			sum += i;
		}
		System.out.println("Answer: " + sum);
	}	
}
