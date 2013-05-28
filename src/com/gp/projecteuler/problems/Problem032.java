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
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.gp.projecteuler.CommonMath;

/**
	We shall say that an n-digit number is pandigital if it makes use of all
	the digits 1 to n exactly once; for example, the 5-digit number, 15234,
	is 1 through 5 pandigital.
	
	The product 7254 is unusual, as the identity, 39 * 186 = 7254, containing
	multiplicand, multiplier, and product is 1 through 9 pandigital.
	
	Find the sum of all products whose multiplicand/multiplier/product 
	identity can be written as a 1 through 9 pandigital.
	
	HINT: Some products can be obtained in more than one way so be sure to 
	only include it once in your sum.
 */
public class Problem032 {

	public static void main(String[] args) {
		
		Set<Long> pandigitalProductSet = new TreeSet<Long>();
		
		for(long i = 0; i < 10000; i++){
			List<Long> divisors = CommonMath.findProperDivisors(i);
			
			for(long divisor : divisors){
				
				if(CommonMath.isPandigital(Arrays.asList(
					new Long[]{i, i / divisor, divisor}), 1, 9)){
					pandigitalProductSet.add(i);
					
				}
			}
		}
		
		System.out.println("Answer: " + CommonMath.sumListOfNumber(
			new ArrayList<Long>(pandigitalProductSet)));
	}
}
