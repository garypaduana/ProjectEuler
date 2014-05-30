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
	A perfect number is a number for which the sum of its proper divisors is
	exactly equal to the number. For example, the sum of the proper divisors of
	28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
	
	A number n is called deficient if the sum of its proper divisors is less than
	n and it is called abundant if this sum exceeds n.
	
	As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
	number that can be written as the sum of two abundant numbers is 24. By 
	mathematical analysis, it can be shown that all integers greater than 28123
	can be written as the sum of two abundant numbers. However, this upper limit
	cannot be reduced any further by analysis even though it is known that the
	greatest number that cannot be expressed as the sum of two abundant
	numbers is less than this limit.
	
	Find the sum of all the positive integers which cannot be written as the sum
	of two abundant numbers.
 */
public class Problem023 {

	public static void main(String[] args) {
		for(int i = 0; i < 100; i++){
			doTheThing();
		}
	}
	
	public static void doTheThing(){
		long start = System.nanoTime();
		List<Integer> abundantIntegers = CommonMath.findAbundantIntegers(28123);
		
		Set<Integer> sumsOfAbundantIntegers = CommonMath.findSumsOfAbundantNumbers(abundantIntegers);
		
		long sum = 0;
		for(int i = 0; i <= 28123; i++){
			if(!sumsOfAbundantIntegers.contains(i)){
				sum += i;
			}
		}
		
		System.out.println("Answer: " + sum + ", Duration: " + (System.nanoTime() - start) / 1e9);
	}
}
