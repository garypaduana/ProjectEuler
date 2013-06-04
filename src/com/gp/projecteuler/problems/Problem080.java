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

import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeSet;

import com.gp.projecteuler.CommonMath;

/**
	It is well known that if the square root of a natural number is not an 
	integer, then it is irrational. The decimal expansion of such square 
	roots is infinite without any repeating pattern at all.
	
	The square root of two is 1.41421356237309504880..., and the digital 
	sum of the first one hundred decimal digits is 475.
	
	For the first one hundred natural numbers, find the total of the 
	digital sums of the first one hundred decimal digits for all the 
	irrational square roots.
 */
public class Problem080 {

	public static void main(String[] args) {
		Set<Integer> squares = new TreeSet<Integer>();
		for(int i = 1; i <= 10; i++){
			squares.add(i*i);
		}
		
		long sum = 0;
		for(int i = 1; i <= 100; i++){
			if(squares.contains(i)) continue;
			BigDecimal bd = BigDecimal.valueOf(i);
			sum += CommonMath.sumString((CommonMath.bigSqrt(bd)).toString()
					.replace(".", "").substring(0, 100));
		}
		
		System.out.println("Answer: " + sum);
	}

}
