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
import java.math.MathContext;

import com.gp.projecteuler.CommonMath;

public class Problem094 {

	public static final BigDecimal EPSILON = new BigDecimal("0.000000000000000000001"); 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		BigDecimal a;
		BigDecimal b;
		BigDecimal p;
		BigDecimal interim;
		BigDecimal two = new BigDecimal(2);
		
		
		for(int i = 2; i < 10000; i++){
			
			a = BigDecimal.valueOf(i + 1);
			b = BigDecimal.valueOf(i);
			p = (a.multiply(two).add(b)).divide(two);
			interim = p.multiply(p.subtract(a)
					.multiply(p.subtract(b)).multiply(p.subtract(a)));
			BigDecimal area1 = CommonMath.bigSqrt(interim);
			
			a = BigDecimal.valueOf(i - 1);
			p = (a.multiply(two).add(b)).divide(two);
			BigDecimal area2 = CommonMath.bigSqrt(p.multiply(p.subtract(a)
					.multiply(p.subtract(b)).multiply(p.subtract(a))));
			
			if(area1.remainder(BigDecimal.ONE, MathContext.DECIMAL32).compareTo(EPSILON) <= 0){
				System.out.println(a.toString() + ", " + a.toString() + ", " + b.toString() + ", " + area1.toString());
			}
			if(area2.remainder(BigDecimal.ONE, MathContext.DECIMAL32).compareTo(EPSILON) <= 0){
				System.out.println(a.toString() + ", " + a.toString() + ", " + b.toString() + ", " + area2.toString());
			}
		}
	}

}
