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
	The first two consecutive numbers to have two distinct prime factors are:
	
	14 = 2 * 7
	15 = 3 * 5
	
	The first three consecutive numbers to have three distinct prime factors are:
	
	644 = 2² * 7 * 23
	645 = 3 * 5 * 43
	646 = 2 * 17 * 19.
	
	Find the first four consecutive integers to have four distinct prime 
	factors. What is the first of these numbers?
 */
public class Problem047 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		Set<Long> primes = new TreeSet<Long>();
		List<Long> primeList = new ArrayList<Long>();
		
		long i = 0;
		int count = 0;
		while(true){
			
			if(CommonMath.isPrime(i)){
				primes.add(i);
				primeList.add(i);
			}
			
			if(CommonMath.findDistinctPrimeFactors(i, primes, primeList).size() == 4){
				count++;
			}
			else{
				count = 0;
			}
			
			if(count == 4){
				System.out.println("Answer: " + (i - 3));
				break;
			}
			i++;
		}
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
	}
}
