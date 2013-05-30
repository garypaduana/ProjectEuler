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
	It is possible to show that the square root of two can be expressed as
	an infinite continued fraction.
	
	sqrt(2) = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...
	
	By expanding this for the first four iterations, we get:
	
	1 + 1/2 = 3/2 = 1.5
	1 + 1/(2 + 1/2) = 7/5 = 1.4
	1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
	1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...
	
	The next three expansions are 99/70, 239/169, and 577/408, but the
	eighth expansion, 1393/985, is the first example where the number of
	digits in the numerator exceeds the number of digits in the denominator.
	
	In the first one-thousand expansions, how many fractions contain a
	numerator with more digits than denominator?
 */
public class Problem057 {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		int numLonger = 0;
		for(int i = 1; i <= 1000; i++){
			String sum = CommonMath.evaluateStandardFormRepeatingFractionExpression(
				CommonMath.generateSquareRootOfTwoRepeatingFractionExpression(i));
			String[] frac = sum.split("/");
			
			if(frac[0].trim().length() > frac[1].trim().length()){
				numLonger++;
			}
		}
		
		System.out.println("Answer: " + numLonger);	
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
	}
}
