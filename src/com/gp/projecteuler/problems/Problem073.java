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
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.gp.projecteuler.FileUtil;

/**
	Consider the fraction, n/d, where n and d are positive integers. If n<d 
	and HCF(n,d)=1, it is called a reduced proper fraction.
	
	If we list the set of reduced proper fractions for d <= 8 in ascending 
	order of size, we get:
	
	1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 
	2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
	
	It can be seen that there are 3 fractions between 1/3 and 1/2.
	
	How many fractions lie between 1/3 and 1/2 in the sorted set of reduced 
	proper fractions for d  12,000?
 */
public class Problem073 {

	public static void main(String[] args) throws IOException {
		
		long start = System.currentTimeMillis();
		
		List<String> primeFactors = FileUtil.getTextFromFile("./resources/primeFactors.txt");
		Set<Double> datSet = new TreeSet<Double>();
		for(String s : primeFactors){
			
			if(s.contains("12001;"))break;
			
			String[] pieces = s.split(";");
			long num = Long.valueOf(pieces[0]);
			
			for(int n = (int)((double)num * 1.0/3.0); ((double)n / (double)num) < 1.0/2.0; n++){
				
				double val = (double)n / (double)num;
				
				if(val < 1.0/2.0 && val > 1.0/3.0){
					datSet.add(val);
				}
			}
		}
		
		System.out.println("Answer: " + datSet.size());
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
	}

}
