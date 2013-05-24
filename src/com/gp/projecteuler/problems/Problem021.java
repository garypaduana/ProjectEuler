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

public class Problem021 {

	/**
	 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
		If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair and each of a and b are called amicable numbers.
		
		For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. 
		The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
		
		Evaluate the sum of all the amicable numbers under 10000.
	 */
	public static void main(String[] args) {

		List<Long> pairList = new ArrayList<Long>();
		
		for(long i = 2; i < 10000; i++){
			
			long factorSum = CommonMath.sumListOfNumber(CommonMath.findProperDivisors(i));
			
			long pairSum = CommonMath.sumListOfNumber(CommonMath.findProperDivisors(factorSum));
			
			
			if(i == pairSum && i != factorSum){
				System.out.println("i: " + i + ", factorSum: " + factorSum + ", pairSum: " + pairSum + ", proper divisors: " + CommonMath.findProperDivisors(i));
				pairList.add(i);
			}
		}
		
		System.out.println(CommonMath.sumListOfNumber(pairList));
	}
	
}
