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
import java.util.Set;
import java.util.TreeSet;

import com.gp.projecteuler.CommonMath;

/**
	The smallest number expressible as the sum of a prime square,
	prime cube, and prime fourth power is 28. In fact, there are exactly 
	four numbers below fifty that can be expressed in such a way:
	
	28 = 2^2 + 2^3 + 2^4
	33 = 3^2 + 2^3 + 2^4
	49 = 5^2 + 2^3 + 2^4
	47 = 2^2 + 3^3 + 2^4
	
	How many numbers below fifty million can be expressed as the sum of a 
	prime square, prime cube, and prime fourth power?
 */
public class Problem087 {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		// 7100 * 7100 = 50,410,000  (greater than 50 million in problem)
		List<Long> primes = CommonMath.findPrimesUnder(7100);
		Set<Long> products = new TreeSet<Long>();
		long upper = 50000000;

		iLoop:
		for(int i = 0; i < primes.size(); i++){
			long ipow = CommonMath.pow(primes.get(i), 2);
			if(ipow > upper){
				continue iLoop;
			}
			
			jLoop:
			for(int j = 0; j < primes.size(); j++){
				long jpow = CommonMath.pow(primes.get(j), 3);
				if(ipow + jpow > upper){
					continue jLoop;
				}
				
				kLoop:
				for(int k = 0; k < primes.size(); k++){
					long kpow = CommonMath.pow(primes.get(k), 4);
					
					long product = ipow + jpow + kpow;
					
					if(product > upper){
						continue kLoop;
					}
					products.add(product);
				}
			}
		}
		
		System.out.println("Answer: " + products.size());
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
	}
}
