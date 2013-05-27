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
import java.util.ArrayList;
import java.util.List;

/**
	The Fibonacci sequence is defined by the recurrence relation:
	
	Fn = Fn1 + Fn2, where F1 = 1 and F2 = 1.
	Hence the first 12 terms will be:
	
	F1 = 1
	F2 = 1
	F3 = 2
	F4 = 3
	F5 = 5
	F6 = 8
	F7 = 13
	F8 = 21
	F9 = 34
	F10 = 55
	F11 = 89
	F12 = 144
	The 12th term, F12, is the first term to contain three digits.
	
	What is the first term in the Fibonacci sequence to contain 1000 digits?
 */
public class Problem025 {

	public static void main(String[] args) {
		List<BigInteger> fibList = new ArrayList<BigInteger>();
		
		fibList.add(BigInteger.valueOf(1));
		
		boolean found = false;
		int i = 0;
		while(!found){
			if(i > 0){
				fibList.add(fibList.get(i).add(fibList.get(i - 1)));
				if(fibList.get(i+1).toString().length() >= 1000){
					// i+2 because fib counting starts at 1, not 0, and we
					// want the element that was just added
					System.out.println("Answer: " + (i + 2));
					break;
				}
			}
			else{
				fibList.add(BigInteger.valueOf(1));
			}
			
			i++;
		}
	}
}
