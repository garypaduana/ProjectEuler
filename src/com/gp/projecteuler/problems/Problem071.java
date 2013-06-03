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
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gp.projecteuler.CommonMath;
import com.gp.projecteuler.Fraction;

/**
	Consider the fraction, n/d, where n and d are positive integers. If n<d
	and HCF(n,d)=1, it is called a reduced proper fraction.
	
	If we list the set of reduced proper fractions for d <= 8 in ascending 
	order of size, we get:
	
	1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8,
	2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
	
	It can be seen that 2/5 is the fraction immediately to the left of 3/7.
	
	By listing the set of reduced proper fractions for d  1,000,000 in 
	ascending order of size, find the numerator of the fraction immediately 
	to the left of 3/7.
 */
public class Problem071 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Set<Fraction> fractionSet = new HashSet<Fraction>();
		
		CommonMath cm = new CommonMath();
		
		for(int d = 1; d <= 1000000; d++){
			
			for(int n = (int)((double)d * 0.428571); ((double)n / (double)d) < 0.4285714285715; n++){
				
				fractionSet.add(cm.reducedProperFraction(new Fraction(n, d)));
			}
		}
		
		List<Fraction> fracList = new ArrayList<Fraction>(fractionSet);
		Collections.sort(fracList);
		System.out.println(fracList.get(fracList.size() - 1));
		System.out.println(fracList.get(fracList.size() - 2));
		System.out.println("Answer: " + fracList.get(fracList.size() - 2).toString().split(" ")[0]);
		
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
	}
	
	
}
