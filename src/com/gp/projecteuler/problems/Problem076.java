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
	It is possible to write five as a sum in exactly six different ways:
	
	4 + 1
	3 + 2
	3 + 1 + 1
	2 + 2 + 1
	2 + 1 + 1 + 1
	1 + 1 + 1 + 1 + 1
	
	How many different ways can one hundred be written as a sum of at least 
	two positive integers?
 */
public class Problem076 {

	public static void main(String[] args) {
		CommonMath cm = new CommonMath();
		System.out.println("Answer: " +	(cm.partitionsFinite(100).longValue() - 1));
	}
}
