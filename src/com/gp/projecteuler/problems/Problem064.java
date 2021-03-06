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

import com.gp.projecteuler.CommonMath;
import com.gp.projecteuler.FileUtil;

/**
	This problem has a very long description, please see
	https://projecteuler.net/problem=64
 */
public class Problem064 {

	public static void main(String[] args) throws IOException {
		
		long start = System.currentTimeMillis();
		Set<Integer> squares = new TreeSet<Integer>();
		for(int i = 0; i < 100; i++){
			squares.add(i*i);
		}
		
		StringBuilder sb = new StringBuilder();
		int oddPeriod = 0;
		for(int i = 2; i <= 10000; i++){
			if(squares.contains(i)) continue;
			
			List<Integer> fracs = CommonMath.findExtendedContinuedFractionPattern(i);
			if(fracs.contains(0)){
				System.out.println(i + " contains 0!!");
			}
			double percent = ((double)oddPeriod / (double)i);
				sb.append(String.valueOf(i + ", " + fracs.toString() + 
						",                    " + oddPeriod + ", " + percent +
						", estimate: " + (10000 * percent) + "\r\n"));
				
				if(i % 100 == 0){
					FileUtil.writeTextToFile("./resources/Problem064.txt", 
						sb.toString(), true);
					sb.delete(0, sb.length());
				}
			if((fracs.size() + 1) % 2 != 0){
				oddPeriod++;
			}
		}
		
		System.out.println("Answer: " + oddPeriod);
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
	}

}
