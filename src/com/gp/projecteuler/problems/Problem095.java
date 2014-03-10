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

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.gp.projecteuler.CommonMath;

/**
	The proper divisors of a number are all the divisors excluding the number 
	itself. For example, the proper divisors of 28 are 1, 2, 4, 7, and 14. 
	As the sum of these divisors is equal to 28, we call it a perfect number.

	Interestingly the sum of the proper divisors of 220 is 284 and the sum of 
	the proper divisors of 284 is 220, forming a chain of two numbers. For 
	this reason, 220 and 284 are called an amicable pair.

	Perhaps less well known are longer chains. For example, starting with 
	12496, we form a chain of five numbers:

	12496 -> 14288 -> 15472 -> 14536 -> 14264 -> ( 12496  ...)

	Since this chain returns to its starting point, it is called an 
	amicable chain.

	Find the smallest member of the longest amicable chain with no element 
	exceeding one million.
 */
public class Problem095 {

	private Map<Long, Long> nextMap = new TreeMap<Long, Long>();
	
	private class Result{
		public Result(boolean cyclic, long chainLength, long smallestElement){
			this.cyclic = cyclic;
			this.chainLength = chainLength;
			this.smallestElement = smallestElement;
		}
		public boolean cyclic;
		public long chainLength;
		public long smallestElement;
	}
	
	public static void main(String[] args) {
		Problem095 p = new Problem095();
		
		long start = System.currentTimeMillis();
		long longest = 0;
		long smallestElement = Long.MAX_VALUE;
		
		for(long i = 0; i <= 1000000; i++){
			Result r = p.analyze(i);
			if(r.cyclic){
				if(r.chainLength >= longest){
					longest = r.chainLength;
					smallestElement = r.smallestElement;
				}
			}
		}
		System.out.println("Answer: " + smallestElement);
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
	}
	
	private Result analyze(long start){
		long next = next(start);
		Set<Long> visited = new TreeSet<Long>();
		boolean cyclic = false;
		long smallestElement = Long.MAX_VALUE;
		while(true){
			visited.add(next);
			if(next < smallestElement){
				smallestElement = next;
			}
			next = next(next);
			if(next > 1e6){
				break;
			}
			if(visited.contains(next)){
				// this number does not cycle, but some other number does
				break;
			}
			if(next == start){
				cyclic = true;
				break;
			}
		}
		
		return new Result(cyclic, visited.size(), smallestElement);		
	}
		
	private long next(long current){
		if(!nextMap.containsKey(current)){
			nextMap.put(current, nextInChain(current));
		}
		return nextMap.get(current);
	}
	
	private static long nextInChain(long n){
		return CommonMath.sumListOfLong(CommonMath.findProperDivisors(n));
	}
}
