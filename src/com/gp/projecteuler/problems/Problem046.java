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

public class Problem046 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		outer:
		for(long i = 2; i < 10000; i++){
			if(CommonMath.isPrime(i) || i % 2 == 0){
				continue outer;
			}
			// Now working only with odd composites

			inner:
			for(long prime = 0; prime < i; prime++){
				if(!CommonMath.isPrime(prime)){
					continue inner;
				}
				for(long square = 0; square <= (long)Math.sqrt(i); square++){
					if(i == (prime + square * square * 2)){
//						System.out.println(i + " = " + prime + " + 2 * " + square + "^2");
						continue outer;
					}
				}
			}
			System.out.println("Smallest odd composite that cannot" +
					" be written as the sum of a prime and twice a square:" +
					i);
			break outer;
			
		}
	}

}
