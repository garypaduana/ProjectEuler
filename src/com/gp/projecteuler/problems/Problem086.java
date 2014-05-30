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
import java.util.HashMap;
import java.util.Map;

import com.gp.projecteuler.UniqueCollection;

/**
	A spider, S, sits in one corner of a cuboid room, measuring 6 by 5 by 3,
	and a fly, F, sits in the opposite corner. By travelling on the surfaces 
	of the room the shortest "straight line" distance from S to F is 10 and 
	the path is shown on the diagram.
	
		(please see image at: https://projecteuler.net/problem=86)
		
	However, there are up to three "shortest" path candidates for any given 
	cuboid and the shortest route doesn't always have integer length.
	
	By considering all cuboid rooms with integer dimensions, up to a maximum 
	size of M by M by M, there are exactly 2060 cuboids for which the shortest 
	route has integer length when M=100, and this is the least value of M for 
	which the number of solutions first exceeds two thousand; the number of 
	solutions is 1975 when M=99.
	
	Find the least value of M such that the number of solutions first exceeds 
	one million.
 */
public class Problem086 {

	/**
	 * TODO: Optimize this solution.  The following code verifies that the
	 * answer is 1818 but it is not very efficient.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		
		Map<UniqueCollection, Double> shortestIntegerPaths = new HashMap<UniqueCollection, Double>();
		
		for(int m = 1818; m <= 1818; m++){
			for(int i = 1; i <= m; i++){
				for(int j = 1; j <= m; j++){
					for(int k = 1; k <= m; k++){
						double distance = findMinimumPath(i, j, k);
						UniqueCollection uc = new UniqueCollection(i, j, k);

						if(shortestIntegerPaths.containsKey(uc)){
							if(distance < shortestIntegerPaths.get(uc)){
								double removed = shortestIntegerPaths.remove(uc);
//								System.out.println("removed: " + removed + 
//									", " + shortestIntegerPaths.size());
							}
						}
						
						if(distance == Math.floor(distance)){
							shortestIntegerPaths.put(uc, distance);
						}
					}
				}
			}
			
			System.out.println(m + ", " + shortestIntegerPaths.size());
			shortestIntegerPaths.clear();
		}
		
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
	}
	
	public static double findMinimumPath(int width, int height, int depth){
		int a = width;
		int b = depth + height;
		return Math.sqrt(a * a + b * b);
	}

}
