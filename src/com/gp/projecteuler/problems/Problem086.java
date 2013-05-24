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
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.gp.projecteuler.FileUtil;
import com.gp.projecteuler.UniqueCollection;

public class Problem086 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		
		Map<UniqueCollection, Double> shortestIntegerPaths = new HashMap<UniqueCollection, Double>();
		
		for(int m = 1200; m <= 1200; m++){
			for(int i = 1; i <= m; i++){
				for(int j = 1; j <= m; j++){
					for(int k = 1; k <= m; k++){
						double distance = findMinimumPath(i, j, k);
						UniqueCollection uc = new UniqueCollection(i, j, k);

						if(shortestIntegerPaths.containsKey(uc)){
							if(distance < shortestIntegerPaths.get(uc)){
								shortestIntegerPaths.remove(uc);
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
		
		System.out.println(System.currentTimeMillis() - start);
	}
	
	public static double findMinimumPath(int width, int height, int depth){
		int a = width;
		int b = depth + height;
		return Math.sqrt(a * a + b * b);
	}

}
