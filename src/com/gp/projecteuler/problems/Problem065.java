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

import com.gp.projecteuler.CommonMath;

/**
	There is much more to this problem, please see:
	https://projecteuler.net/problem=65
	
	Only the problem part:
	
	What is most surprising is that the important mathematical constant,
	e = [2; 1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...].
	
	The first ten terms in the sequence of convergents for e are:
	
	2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536, ...
	The sum of digits in the numerator of the 10th convergent is 1+4+5+7=17.
	
	Find the sum of digits in the numerator of the 100th convergent of the
	continued fraction for e.
 */
public class Problem065 {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		String fractionExpression = CommonMath.generateERepeatingFractionExpression(100);
		System.out.println(fractionExpression);
		String fraction = CommonMath.evaluateStandardFormRepeatingFractionExpression(fractionExpression);
		System.out.println("Fraction: " + fraction);
		long digitSum = CommonMath.sumString(fraction.split("/")[0].trim());
		System.out.println("Answer: " + digitSum);
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
	}

}
