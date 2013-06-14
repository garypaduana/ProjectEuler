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
	The number 145 is well known for the property that the sum of the 
	factorial of its digits is equal to 145:
	
	1! + 4! + 5! = 1 + 24 + 120 = 145
	
	Perhaps less well known is 169, in that it produces the longest chain 
	of numbers that link back to 169; it turns out that there are only 
	three such loops that exist:
	
	169 -> 363601 -> 1454 -> 169
	871 -> 45361 -> 871
	872 -> 45362 -> 872
	
	It is not difficult to prove that EVERY starting number will eventually 
	get stuck in a loop. For example,
	
	69 -> 363600 -> 1454 -> 169 -> 363601 (-> 1454)
	78 -> 45360 -> 871 -> 45361 (-> 871)
	540 -> 145 (-> 145)
	
	Starting with 69 produces a chain of five non-repeating terms, but the 
	longest non-repeating chain with a starting number below one million 
	is sixty terms.
	
	How many chains, with a starting number below one million, contain 
	exactly sixty non-repeating terms?
 */
public class Problem074 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		int sixtyCount = 0;
		List<Long> chain = new ArrayList<Long>();
		long num = 0;
		for(long i = 0; i < 1000000; i++){
			num = i;
			while(!chain.contains(num)){
				chain.add(num);
				num = CommonMath.factorialSumOfDigits(num);
			}
			
			if(chain.size() == 60){
				sixtyCount++;
			}
			chain.clear();
		}
		
		System.out.println("Answer: " + sixtyCount);
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
	}
}
