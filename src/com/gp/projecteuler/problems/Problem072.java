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

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.gp.projecteuler.CommonMath;
import com.gp.projecteuler.FileUtil;

/**
	Consider the fraction, n/d, where n and d are positive integers. If n < d 
	and HCF(n,d)=1, it is called a reduced proper fraction.
	
	If we list the set of reduced proper fractions for d <= 8 in ascending order
	of size, we get:
	
	1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 
	5/7, 3/4, 4/5, 5/6, 6/7, 7/8
	
	It can be seen that there are 21 elements in this set.
	
	How many elements would be contained in the set of reduced proper 
	fractions for d <= 1,000,000?
 */
public class Problem072 {

	public static void main(String[] args) throws IOException {
		
		long start = System.currentTimeMillis();
		
		List<String> primeFactors = FileUtil.getTextFromFile(
			"./resources/primeFactors.txt");
		long count = 0;
		for(String s : primeFactors){
			
			String[] pieces = s.split(";");
			long num = Long.valueOf(pieces[0]);
			List<Long> factors = CommonMath.convertList(
				Arrays.asList(pieces[1].split(",")));
			count += CommonMath.eulerTotient(num, factors);
		}
		System.out.println("Answer: " + count);
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
	}
}
