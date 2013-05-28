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
import com.gp.projecteuler.Fraction;

/**
	The fraction 49/98 is a curious fraction, as an inexperienced 
	mathematician in attempting to simplify it may incorrectly believe that
	49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

	We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

	There are exactly four non-trivial examples of this type of fraction,
	less than one in value, and containing two digits in the numerator and
	denominator.

	If the product of these four fractions is given in its lowest common terms,
	find the value of the denominator.
 */
public class Problem033 {

	public static void main(String[] args) {
		CommonMath cm = new CommonMath();
		long numeratorProduct = 1;
		long denominatorProduct = 1;
		
		for(int num = 10; num <= 98; num++){
			for(int denom = num + 1; denom <= 99; denom++){
				int ans = CommonMath.containsCommonNumber(num, denom);
				if(ans >= 1){
					int numR = Integer.valueOf(Integer.toString(num)
							.replaceAll(Integer.toString(ans), ""));
					int denomR = Integer.valueOf(Integer.toString(denom)
							.replaceAll(Integer.toString(ans), ""));
					
					if(denomR != 0){
						if(((double)num / (double)denom) == ((double)numR / (double)denomR)){
							System.out.println(ans + "   " + num + "/" +
									denom + "    " + numR + "/" + denomR);
							
							numeratorProduct *= num;
							denominatorProduct *= denom;
						}
					}					
				}
			}
		}
		
		Fraction f = new Fraction(numeratorProduct, denominatorProduct);
		Fraction reduced = cm.reducedProperFraction(f);
		
		System.out.println("Answer: " + reduced.getDenominator());
	}
}
