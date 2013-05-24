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

public class Problem069 {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		double maxNPhiN = 0;
		long iAtMax = 0;
		
		Set<Long> primes = new TreeSet<Long>();
		for(long i = 0; i < 1000000; i++){
			if(CommonMath.isPrime(i)){
				primes.add(i);
			}
		}
		
		for(long i = 0; i < 1000000; i+=210){
			//System.out.println(i + ", " + CommonMath.eulerTotientPrimeFactorization(i));
			double nPhiN = ((double)i / (double)CommonMath.eulerTotientPrimeFactorizationCached(i, primes));
			//System.out.println(i + "," + nPhiN);
			if(nPhiN > maxNPhiN){
				maxNPhiN = nPhiN;
				iAtMax = i;
			}
		}
				
		System.out.println(maxNPhiN + " at " + iAtMax);
		System.out.println(System.currentTimeMillis() - start);
	}
}
