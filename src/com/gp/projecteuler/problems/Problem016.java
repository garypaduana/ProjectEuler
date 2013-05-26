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
	2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
	What is the sum of the digits of the number 2^1000?
 */
public class Problem016 {

	public static void main(String[] args) {
		
		BigDecimal bd = new BigDecimal(1);
		
		for(int i = 0; i < 1000; i++){
			bd = bd.multiply(new BigDecimal(2));
		}
		
		int sum = 0;
		for(char c : bd.toString().toCharArray()){
			sum += Integer.valueOf(String.valueOf(c));
		}
		
		System.out.println("Answer: " + sum);
	}

}
