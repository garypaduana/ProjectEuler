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

import java.math.BigInteger;

import com.gp.projecteuler.CommonMath;

/**
	There are exactly ten ways of selecting three from five, 12345:
	
	123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
	
	In combinatorics, we use the notation, 5(C(3)) = 10.
	
	In general,
	
	n(C(r)) = n! / (r!(n-r)!)
	
	where r <= n, n! = n*(n-1)...3*2*1, and 0! = 1.
	It is not until n = 23, that a value exceeds one-million: 
	23(C(10)) = 1144066.
	
	How many, not necessarily distinct, values of  n(C(r)), 
	for 1 <= n <= 100, are greater than one-million?
 */
public class Problem053 {

	public static void main(String[] args) {
		
		int millionCount = 0;
		for(int n = 1; n <= 100; n++){
			for(int r = 1; r < n; r++){
				BigInteger result = CommonMath.bigFactorial(n).divide(
										CommonMath.bigFactorial(r).multiply(
										CommonMath.bigFactorial(n-r)));
				if(result.compareTo(BigInteger.valueOf(1000000L)) >= 0){
					millionCount++;
				}
			}
		}
		System.out.println("Answer: " + millionCount);
	}
}
