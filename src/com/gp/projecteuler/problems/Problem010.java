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

import java.util.List;

import com.gp.projecteuler.CommonMath;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 */
public class Problem010 {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		List<Long> primes = CommonMath.findPrimesUnder(2000000);
		long sum = 0;
		
		for(long prime : primes){
			sum += prime;
		}
		
		System.out.println("Answer: " + sum);
		System.out.println("Duration: " + (System.currentTimeMillis() - start) + " ms");
	}

}
