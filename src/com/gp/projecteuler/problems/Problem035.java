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
import java.util.List;

import com.gp.projecteuler.CommonMath;

/**
	The number, 197, is called a circular prime because all rotations of
	the digits: 197, 971, and 719, are themselves prime.
	
	There are thirteen such primes below 100: 
	2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
	
	How many circular primes are there below one million?
 */
public class Problem035 {

	public static void main(String[] args) {
		
		List<Integer> circularPrimes = new ArrayList<Integer>();
		
		outer:
		for(int i = 0; i < 1000000; i++){
			if(!CommonMath.isPrime(i)) 
				continue outer;
			List<String> rotations = CommonMath.rotations(Integer.toString(i));
			
			for(String perm : rotations){
				if(!CommonMath.isPrime(Integer.valueOf(perm))){
					continue outer;
				}
			}
			circularPrimes.add(i);
		}
		System.out.println("Answer: " + circularPrimes.size());
	}
}
