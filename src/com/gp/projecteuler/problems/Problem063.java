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
	The 5-digit number, 16807=7^5, is also a fifth power. Similarly, 
	the 9-digit number, 134217728=8^9, is a ninth power.
	
	How many n-digit positive integers exist which are also an nth power?
 */
public class Problem063 {

	public static void main(String[] args) {
		
		int count = 0;
		long start = System.currentTimeMillis();
		for(int i = 1; i < 100; i++){
			BigInteger bi = new BigInteger(Integer.toString(i));
			
			for(int pow = 0; pow < 30; pow++){
				String biPow = bi.pow(pow).toString();
				if(pow == biPow.length()){
					count++;
					System.out.println(i + "^" + pow + " = " + biPow + "    ("
						+ biPow.length() + ")");
				}
			}
			
		}
		System.out.println("Answer: " + count);
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
	}

}
