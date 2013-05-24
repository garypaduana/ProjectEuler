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

public class Problem065 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		
		String fractionExpression = CommonMath.generateERepeatingFractionExpression(100);
		System.out.println(fractionExpression);
		String fraction = CommonMath.evaluateStandardFormRepeatingFractionExpression(fractionExpression);
		System.out.println(fraction);
		long digitSum = CommonMath.sumString(fraction.split("/")[0].trim());
		System.out.println("Sum: " + digitSum);
		System.out.println("Duration: " + (System.currentTimeMillis() - start) + " ms");
	}

}
