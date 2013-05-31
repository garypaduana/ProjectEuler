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

import java.io.IOException;
import java.util.List;

import com.gp.projecteuler.CommonMath;
import com.gp.projecteuler.FileUtil;

/**
	Find the maximum total from top to bottom in triangle.txt (right click 
	and 'Save Link/Target As...'), a 15K text file containing a triangle 
	with one-hundred rows.
	
	NOTE: This is a much more difficult version of Problem 18. It is not 
	possible to try every route to solve this problem, as there are 2^99 
	altogether! If you could check one trillion (1012) routes every second 
	it would take over twenty billion years to check them all. There is an 
	efficient algorithm to solve it. ;o)
 */
public class Problem067 {

	public static void main(String[] args) throws IOException {
		
		List<String> lines = FileUtil.getTextFromFile("./resources/Problem067.txt");
		
		System.out.println("Answer: " + 
				CommonMath.maximumDistanceThroughTriangle(lines));
	}
}
