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

import java.math.BigInteger;

import com.gp.projecteuler.CommonMath;

public class Problem056 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long maxDigitalSum = 0;
		for(int a = 0; a < 100; a++){
			for(int b = 0; b < 100; b++){
				
				BigInteger product = BigInteger.valueOf(a).pow(b);
				
				long sum = CommonMath.sumString(product.toString());
				
				if(sum > maxDigitalSum){
					maxDigitalSum = sum;
				}
			}
		}
		
		System.out.println(maxDigitalSum);
		System.out.println(System.currentTimeMillis() - start);
	}
	
	

}
