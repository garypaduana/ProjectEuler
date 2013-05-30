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
import java.util.Set;
import java.util.TreeSet;

import com.gp.projecteuler.CommonMath;

/**
	The prime 41, can be written as the sum of six consecutive primes:
	
	41 = 2 + 3 + 5 + 7 + 11 + 13
	This is the longest sum of consecutive primes that adds to a prime
	below one-hundred.
	
	The longest sum of consecutive primes below one-thousand that adds to
	a prime, contains 21 terms, and is equal to 953.
	
	Which prime, below one-million, can be written as the sum of the most
	consecutive primes?
 */
public class Problem050 {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		List<Long> primesList = new ArrayList<Long>();
		Set<Long> primes = new TreeSet<Long>();
		
		for(long i = 0; i < 1e6; i++){
			if(CommonMath.isPrime(i)){
				primes.add(i);
				primesList.add(i);
			}
		}
		
		long sum = 0;
		int maxCount = 0;
		
		long maxSum = 0;
		int count = 0;
		
		outer:
		for(int i = 0; i < primes.size(); i++){
			sum = 0;
			count = 0;
			for(int s = i; s < primes.size(); s++){
				count++;
				sum += primesList.get(s);
				if(sum > 1e6){
					continue outer;
				}
				if(primes.contains(sum)){
					if(count > maxCount){
						maxCount = count;
						maxSum = sum;
					}
				}
			}
		}
		
		
		System.out.println("count: " + maxCount + ", Answer: " + maxSum);
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
	}

}
