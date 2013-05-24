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

/**
 * n! means n  (n  1)  ...  3  2  1
	
	For example, 10! = 10  9  ...  3  2  1 = 3628800,
	and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
	
	Find the sum of the digits in the number 100!
 * @author asus
 *
 */
public class Problem020 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger bi = BigInteger.valueOf(1L);
		
		for(int i = 100; i > 0; i--){
			bi = bi.multiply(BigInteger.valueOf(i));
		}
		
		int total = 0;
		for(char c : bi.toString().toCharArray()){
			total += Integer.valueOf(String.valueOf(c));
		}
		
		System.out.println(total);
	}

}
