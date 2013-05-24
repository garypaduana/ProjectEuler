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

public class Problem071 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Set<Fraction> fractionSet = new HashSet<Fraction>();
		
		CommonMath cm = new CommonMath();
		
		for(int d = 1; d <= 1000000; d++){
			
			for(int n = (int)((double)d * 0.428571); ((double)n / (double)d) < 0.4285714285715; n++){
				if(((double)n / (double)d) < 0.42){
					continue;
				}
				fractionSet.add(cm.reducedProperFraction(new Fraction(n, d)));
			}
		}
		
		List<Fraction> fracList = new ArrayList<Fraction>(fractionSet);
		Collections.sort(fracList);
		System.out.println(fracList.get(fracList.size() - 1));
		System.out.println(fracList.get(fracList.size() - 2));
		
		System.out.println((System.currentTimeMillis() - start) + " ms");
	}
	
	
}
