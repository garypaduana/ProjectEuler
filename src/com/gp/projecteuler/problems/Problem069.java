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

import java.util.Set;
import java.util.TreeSet;

import com.gp.projecteuler.CommonMath;

/**
	Euler's Totient function, phi(n) [sometimes called the phi function], 
	is used to determine the number of numbers less than n which are 
	relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8, are all 
	less than nine and relatively prime to nine, phi(9)=6.
	
	n	Relatively Prime	phi(n)	n/phi(n)
	2	1					1		2
	3	1,2					2		1.5
	4	1,3					2		2
	5	1,2,3,4				4		1.25
	6	1,5					2		3
	7	1,2,3,4,5,6			6		1.1666...
	8	1,3,5,7				4		2
	9	1,2,4,5,7,8			6		1.5
	10	1,3,7,9				4		2.5
	It can be seen that n=6 produces a maximum n/phi(n) for n <= 10.
	
	Find the value of n <= 1,000,000 for which n/phi(n) is a maximum.
 */
public class Problem069 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		double maxNPhiN = 0;
		long nAtMax = 0;
		
		Set<Long> primes = new TreeSet<Long>();
		for(long i = 0; i < 1000000; i++){
			if(CommonMath.isPrime(i)){
				primes.add(i);
			}
		}
		
		for(long n = 2; n < 1000000; n++){
			double nPhiN = ((double)n / (double)
				CommonMath.eulerTotientPrimeFactorizationCached(n, primes));

			if(nPhiN > maxNPhiN){
				maxNPhiN = nPhiN;
				nAtMax = n;
			}
		}
				
		System.out.println("Max n*phi(n): " + maxNPhiN + " at (Answer): " + nAtMax);
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
	}
}
