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

import java.util.ArrayList;
import java.util.List;

import com.gp.projecteuler.CommonMath;

public class Problem058 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int distanceUntilNext = 1;
		int currentDistance = 1;
		int countAtCurrentDistance = 0;
		
		List<Long> diagonalList = new ArrayList<Long>();
		diagonalList.add(1L);
		int passes = 1;
		int primeCount = 0;
		outer:
		for(long i = 2; i <= 10000000000L; i++){
			if(currentDistance > 0){
				currentDistance--;
			}
			else{
				diagonalList.add(i);
				countAtCurrentDistance++;
				
				if(countAtCurrentDistance == 4){
					countAtCurrentDistance = 0;
					distanceUntilNext += 2;
					passes++;
					for(int j = diagonalList.size() - 4; j < diagonalList.size(); j++){
						if(CommonMath.isPrime(diagonalList.get(j))){
							primeCount++;
						}
					}
					
					if(passes % 100 == 0){
						System.out.println("iteration: " + i + ", sideLength: " + (distanceUntilNext));
						System.out.println(primeCount + " / " + diagonalList.size() + " = " + ((double)primeCount / (double)diagonalList.size()));
					}
					
					if(((double)primeCount / (double)diagonalList.size()) < 0.1){
						System.out.println("iteration: " + i + ", sideLength: " + (distanceUntilNext));
						System.out.println(primeCount + " / " + diagonalList.size() + " = " + ((double)primeCount / (double)diagonalList.size()));
						break outer;
					}
					
				}
				currentDistance = distanceUntilNext;
			}
			
			
		}
		
		System.out.println(System.currentTimeMillis() - start);
	}

}
