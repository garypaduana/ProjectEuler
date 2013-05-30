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
	It was proposed by Christian Goldbach that every odd composite number can
	be written as the sum of a prime and twice a square.
	
	9 = 7 + 2*1^2
	15 = 7 + 2*2^2
	21 = 3 + 2*3^2
	25 = 7 + 2*3^2
	27 = 19 + 2*2^2
	33 = 31 + 2*1^2
	
	It turns out that the conjecture was false.
	
	What is the smallest odd composite that cannot be written as the sum of
	a prime and twice a square?
 */
public class Problem046 {

	public static void main(String[] args) {
		
		outer:
		for(long i = 2; i < 10000; i++){
			
			// Skip if not an odd composite
			if(CommonMath.isPrime(i) || i % 2 == 0){
				continue outer;
			}
			
			inner:
			for(long prime = 0; prime < i; prime++){
				if(!CommonMath.isPrime(prime)){
					continue inner;
				}
				for(long square = 0; square <= (long)Math.sqrt(i); square++){
					if(i == (prime + square * square * 2)){
						continue outer;
					}
				}
			}
			System.out.println("Answer: " + i);
			break outer;
		}
	}
}
