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

public class Problem016 {

	/**
	 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
	 * What is the sum of the digits of the number 2^1000?
	 * 
	 * 
	 * 2^1 = 2
	 * 2^2 = 4
	 * 2^3 = 8
	 * 2^4 = 16 .. 7
	 * 2^5 = 32 .. 5
	 * 2^6 = 64 .. 10
	 * 2^7 = 128 .. 11
	 * 2^8 = 256 .. 13
	 * 2^9 = 512 .. 8
	 * 2^10 = 1024 .. 7
	 * 2^11 = 2048 .. 14
	 * 2^12 = 4096 .. 19
	 * 2^13 = 8192 .. 20
	 * 2^14 = 16384 .. 22
	 * 2^15 = 32768 .. 26
	 */
	public static void main(String[] args) {
		
		BigDecimal bd = new BigDecimal(1);
		
		for(int i = 0; i < 1000; i++){
			bd = bd.multiply(new BigDecimal(2));
			System.out.println(bd.toString());
		}
		
		int sum = 0;
		for(char c : bd.toString().toCharArray()){
			sum += Integer.valueOf(String.valueOf(c));
		}
		
		System.out.println(sum);
	}

}
