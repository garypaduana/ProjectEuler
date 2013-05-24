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

public class Problem034 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		outer:
		for(int i = 0; i < 100000; i++){
			++i;
			String numStr = Long.toString(i);
			long sum = 0;
			for(int j = 0; j < numStr.length(); j++){
				sum += CommonMath.factorial(Integer.valueOf(numStr.substring(j, j + 1)));
				if(sum > i){
					continue outer;
				}
			}
			if(sum == i){
				System.out.println("FOUND: " + i);
			}
		}
	}
}