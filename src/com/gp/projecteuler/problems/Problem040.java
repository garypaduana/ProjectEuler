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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.gp.projecteuler.CommonMath;

/**
	An irrational decimal fraction is created by concatenating the 
	positive integers:
	
	0.123456789101112131415161718192021...
	
	It can be seen that the 12th digit of the fractional part is 1.
	
	If d(n) represents the nth digit of the fractional part, find the value
	of the following expression.
	
	d(1) * d(10) * d(100) * d(1000) * d(10000) * d(100000) * d(1000000)
 */
public class Problem040 {

	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<Integer>();
		for(int i = 1; i < 200000; i++){
			numList.add(i);
		}
		String decimal = CommonMath.concat(numList);
		
		List<Integer> positions = Arrays.asList(
				new Integer[]{1, 10, 100, 1000, 10000, 100000, 1000000});
		int product = 1;
		for(int i : positions){
			product = product * Integer.valueOf(String.valueOf(decimal.charAt(i - 1)));
			System.out.println("Position: " + i + ", value: " + 
					String.valueOf(decimal.charAt(i - 1)));
		}
		
		System.out.println("Answer: " + product);
	}

}
