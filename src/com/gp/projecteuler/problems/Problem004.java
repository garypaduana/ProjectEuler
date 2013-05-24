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

public class Problem004 {

	/**
	 * A palindromic number reads the same both ways. The largest palindrome made from
	 * the product of two 2-digit numbers is 9009 = 91 99.
	 * Find the largest palindrome made from the product of two 3-digit numbers.
	 */
	public static void main(String[] args) {
		int largest = 0;
		for(int i = 100; i < 1000; i++){
			for(int j = 100; j < 1000; j++){
				if(isPalindrome(i * j)){
					if(largest < (i * j)){
						largest = i * j;
					}
				}
			}
		}
		
		System.out.println(largest);

	}
	
	public static boolean isPalindrome(long num){
		String forward = Long.toString(num);
		String reverse = reverse(forward);
		return forward.equals(reverse);
	}
	
	public static String reverse(String forward){
		char[] chars = forward.toCharArray();
		char[] reverseChars = new char[chars.length];
		
		for(int i = 0; i < forward.length(); i++){
			reverseChars[forward.length() - 1 - i] = chars[i];
		}
		return new String(reverseChars);
	}

}
