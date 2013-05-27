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

import java.util.Collections;
import java.util.List;

import com.gp.projecteuler.CommonMath;

/**
	A permutation is an ordered arrangement of objects. For example, 3124 is
	one possible permutation of the digits 1, 2, 3 and 4. If all of the
	permutations are listed numerically or alphabetically, we call it
	lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
	
	012   021   102   120   201   210
	
	What is the millionth lexicographic permutation of the digits 
	0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */
public class Problem024 {

	public static void main(String[] args) {
			
		List<String> permutationList = CommonMath.permutation("0123456789");
		Collections.sort(permutationList);
		System.out.println("Answer: " + permutationList.get(999999));
	}
}
