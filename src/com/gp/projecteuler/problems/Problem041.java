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

import java.util.Arrays;

import com.gp.projecteuler.CommonMath;

/**
	We shall say that an n-digit number is pandigital if it makes use of
	all the digits 1 to n exactly once. For example, 2143 is a 4-digit
	pandigital and is also prime.
	
	What is the largest n-digit pandigital prime that exists?
 */
public class Problem041 {

	public static void main(String[] args) {
		
		int largest = 1;
		for(int i = 0; i < 7654321; i++){
			if(CommonMath.isPrime(i)){
				for(int high = 1; high <= Integer.toString(i).length(); high++){
					if(CommonMath.isPandigital(Arrays.asList(new Integer[]{i}), 1, high)){
						largest = i;
					}
				}
			}
		}
		System.out.println("Answer: " + largest);
	}

}
