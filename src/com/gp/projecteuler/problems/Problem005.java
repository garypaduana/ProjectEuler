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

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10
 * without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers
 * from 1 to 20?
 */
public class Problem005 {

	public static void main(String[] args) {
		long i = 20;
		boolean foundSmallest = false;
		
		while(!foundSmallest){
			
			for(int num = 1; num <= 20; num++){
				if(i % num != 0){
					break;
				}
				if(num == 20){
					System.out.println("Answer: " + i);
					foundSmallest = true;
					break;
				}
			}
			i += 20;
		}
	}

}
