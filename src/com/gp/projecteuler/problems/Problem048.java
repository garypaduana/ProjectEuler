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

import java.math.BigDecimal;

/**
	The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
	
	Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000
 */
public class Problem048 {

	public static void main(String[] args) {
		
		BigDecimal sum = new BigDecimal("0");
		long start = System.currentTimeMillis();
		for(BigDecimal bd = new BigDecimal("1");
			bd.compareTo(new BigDecimal("1000")) <= 0;
			bd = bd.add(new BigDecimal("1"))){
			
			sum = sum.add(bd.pow(bd.intValue()));
			
		}
		System.out.println("Answer: " + sum.toString().substring(
			sum.toString().length()	- 10, sum.toString().length()));
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
	}
}
