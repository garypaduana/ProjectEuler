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
import java.util.HashSet;
import java.util.Set;

import com.gp.projecteuler.CommonMath;

/**
	The cube, 41063625 (345^3), can be permuted to produce two other cubes:
	56623104 (384^3) and 66430125 (405^3). In fact, 41063625 is the smallest
	cube which has exactly three permutations of its digits which are also cube.
	
	Find the smallest cube for which exactly five permutations of its
	digits are cube.
 */
public class Problem062 {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		Set<String> cubes = new HashSet<String>();
		
		for(BigInteger bi = new BigInteger("0");
			bi.compareTo(new BigInteger("10000")) <= 0;
			bi = bi.add(new BigInteger("1"))){
			
			cubes.add(bi.pow(3).toString());
		}
		
		
		for(BigInteger bi = new BigInteger("0");
			bi.compareTo(new BigInteger("10000")) <= 0;
			bi = bi.add(new BigInteger("1"))){
			
			int count = 0;
			String biCube = bi.pow(3).toString();
			for(String cube : cubes){
				if(CommonMath.isInSamePermutationSet(cube, biCube)){
					count++;
				}
			}
			if(count == 5){
				System.out.println("Answer: " + bi.toString() + "^3" + 
					" = " + bi.pow(3).toString());
				break;
			}
		}
		
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
	}
}
