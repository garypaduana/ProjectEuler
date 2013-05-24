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

import java.util.Collections;
import java.util.List;

import com.gp.projecteuler.CommonMath;

public class Problem003 {

	/**
	 * The prime factors of 13195 are 5, 7, 13 and 29.
	 * What is the largest prime factor of the number 600851475143 ?
	 */
	public static void main(String[] args) {
		
		long num = 600851475143L;
		long largestPrime = 0;
		
		List<Long> factorList = CommonMath.findFactors(num);
		Collections.sort(factorList);
		System.out.println(factorList);
		for(long factor : factorList){
			if(CommonMath.isPrime(factor)){
				System.out.println("is Prime: " + factor);
				largestPrime = factor;
			}
		}
		
		System.out.println(largestPrime);
	}
	
	

}
