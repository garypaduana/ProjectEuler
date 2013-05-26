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
	The following iterative sequence is defined for the set of positive integers:

	n -> n/2 (n is even)
	n -> 3n + 1 (n is odd)
	
	Using the rule above and starting with 13, we generate the following sequence:
	
	13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
	It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
	Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
	
	Which starting number, under one million, produces the longest chain?
	
	NOTE: Once the chain starts the terms are allowed to go above one million.
*/
public class Problem014 {
	
	public static void main(String[] args) {
		long largestChain = 0;
		long largestStart = 0;
	
		for(long i = 1; i < 1000000; i++){
			long size = 0;
			long next = i;
			while((next = CommonMath.findNextInCollatzSequence(next)) != 1){
				size++;
			}
			
			if(size > largestChain){
				largestChain = size;
				largestStart = i;
			}
		}
		System.out.println("largest chain: " + largestChain + ", start value (Answer): " + largestStart);
	}
}
