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

/**
	Starting with 1 and spiralling anticlockwise in the following way,
	a square spiral with side length 7 is formed.
	
	37 36 35 34 33 32 31
	38 17 16 15 14 13 30
	39 18  5  4  3 12 29
	40 19  6  1  2 11 28
	41 20  7  8  9 10 27
	42 21 22 23 24 25 26
	43 44 45 46 47 48 49
	
	It is interesting to note that the odd squares lie along the bottom
	right diagonal, but what is more interesting is that 8 out of the 13
	numbers lying along both diagonals are prime; that is, a ratio of
	8/13 ~ 62%.
	
	If one complete new layer is wrapped around the spiral above, a square
	spiral with side length 9 will be formed. If this process is continued,
	what is the side length of the square spiral for which the ratio of
	primes along both diagonals first falls below 10%?
 */
public class Problem058 {

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
						System.out.println("iteration: " + i + ", sideLength: "
							+ (distanceUntilNext));
						System.out.println(primeCount + " / " + 
							diagonalList.size() + " = " + 
							((double)primeCount / (double)diagonalList.size()));
					}
					
					if(((double)primeCount / (double)diagonalList.size()) < 0.1){
						System.out.println("iteration: " + i + ", sideLength: " 
							+ (distanceUntilNext));
						System.out.println(primeCount + " / " + 
							diagonalList.size() + " = " + 
							((double)primeCount / (double)diagonalList.size()));
						
						System.out.println("\r\nAnswer: " + distanceUntilNext);
						break outer;
					}
					
				}
				currentDistance = distanceUntilNext;
			}
		}
		
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
	}

}
