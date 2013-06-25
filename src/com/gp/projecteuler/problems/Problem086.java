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
				
		int count = 0;
		int mAtAnswer = 0;
		
		outer:
		for(int m = 1; m <= 100; m++){
			
						
						if(minimumIsIntegral(i, j, k)){
							count++;
						}
					}
				}
			}
			
			System.out.println(m + ", " + count);
			
			if(count > 1000000){
				mAtAnswer = m;
				break outer;
			}
		}
		
		System.out.println("Answer: " + mAtAnswer);
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
	}
	
	public static double findDistance(int m, int l){
		return Math.sqrt(m * m + (l+m)*(l+m));
	}
	
	public static boolean minimumIsIntegral(int a, int b, int c){
		double one = Math.sqrt(a*a + (b+c)*(b+c));
		double two = Math.sqrt((a+c)*(a+c) + b*b);
		double three = Math.sqrt(a*a+b*b) + c;
		
		double minimum = minimum(one, two, three);
		
		return Math.floor(minimum) == minimum;
	}
	
	public static double minimum(double... args){
		double minimum = Double.MAX_VALUE;
		for(double d : args){
			if(d < minimum){
				minimum = d;
			}
		}
		return minimum;
	}

}
