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

public class Problem032 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Set<Long> pandigitalProductSet = new TreeSet<Long>();
		
		for(long i = 0; i < 10000; i++){
			List<Long> divisors = CommonMath.findProperDivisors(i);
			
			for(long divisor : divisors){
				
				if(CommonMath.isPandigital(Arrays.asList(new Long[]{i, i / divisor, divisor}), 1, 9)){
					pandigitalProductSet.add(i);
					
				}
			}
		}
		
		for(long l : pandigitalProductSet){
			System.out.println(l);
		}
		System.out.println(CommonMath.sumListOfNumber(new ArrayList<Long>(pandigitalProductSet)));
	}
}
