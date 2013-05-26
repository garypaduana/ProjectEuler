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
 * Starting in the top left corner of a 2x2 grid, there are 6 routes 
 * (without backtracking) to the bottom right corner.
 * How many routes are there through a 20x20 grid?
 */
public class Problem015 {

	public static void main(String[] args) throws Exception {
		
		System.out.println("Answer: " + CommonMath.findRowInPascalsTriangle(40).get(20));
	}
}
