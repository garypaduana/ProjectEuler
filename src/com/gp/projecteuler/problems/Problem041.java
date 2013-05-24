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

import java.util.Arrays;

import com.gp.projecteuler.CommonMath;

public class Problem041 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int largest = 1;
		for(int i = 0; i < 999999999; i++){
			if(CommonMath.isPrime(i)){
				for(int high = 1; high <= Integer.toString(i).length(); high++){
					if(CommonMath.isPandigital(Arrays.asList(new Integer[]{i}), 1, high)){
						System.out.println(i);
						largest = i;
					}
				}
			}
		}
		System.out.println(largest);
	}

}
