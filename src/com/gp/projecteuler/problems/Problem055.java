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

/**
	If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.
	
	Not all numbers produce palindromes so quickly. For example,
	
	349 + 943 = 1292,
	1292 + 2921 = 4213
	4213 + 3124 = 7337
	
	That is, 349 took three iterations to arrive at a palindrome.
	
	Although no one has proved it yet, it is thought that some numbers, 
	like 196, never produce a palindrome. A number that never forms a
	palindrome through the reverse and add process is called a Lychrel
	number. Due to the theoretical nature of these numbers, and for the
	purpose of this problem, we shall assume that a number is Lychrel
	until proven otherwise. In addition you are given that for every
	number below ten-thousand, it will either (i) become a palindrome
	in less than fifty iterations, or, (ii) no one, with all the computing
	power that exists, has managed so far to map it to a palindrome.
	In fact, 10677 is the first number to be shown to require over fifty
	iterations before producing a palindrome: 4668731596684224866951378664 
	(53 iterations, 28-digits).
	
	Surprisingly, there are palindromic numbers that are themselves Lychrel
	numbers; the first example is 4994.
	
	How many Lychrel numbers are there below ten-thousand?
	
	NOTE: Wording was modified slightly on 24 April 2007 to emphasise the
	theoretical nature of Lychrel numbers.
 */
public class Problem055 {

	public static void main(String[] args) {
		
		int lychrelCount = 0;
		outer:
		for(int i = 1; i < 10000; i++){
			BigInteger num = new BigInteger(Integer.toString(
				Integer.valueOf(CommonMath.reverse(Integer.toString(i))) + i));
			
			for(int attempt = 0; attempt <= 50; attempt++){
				if(CommonMath.isPalindrome(num.toString())){
					continue outer;
				}
				num = new BigInteger(CommonMath.reverse(num.toString())).add(num);
			}
			
			lychrelCount++;
		}
		System.out.println("Answer: " + lychrelCount);
	}

}
