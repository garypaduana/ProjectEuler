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
	The decimal number, 585 = 1001001001(base2) (binary), is palindromic
	in both bases.
	
	Find the sum of all numbers, less than one million, which are
	palindromic in base 10 and base 2.
	
	(Please note that the palindromic number, in either base, may not
	include leading zeros.)
 */
public class Problem036 {

	public static void main(String[] args) {
		
		int sum = 0;
		for(int i = 0; i < 1000000; i++){
			if(CommonMath.isPalindrome(Integer.toBinaryString(i)) && 
					CommonMath.isPalindrome(Integer.toString(i))){
				sum += i;
			}
		}
		System.out.println("Answer: " + sum);
	}

}
