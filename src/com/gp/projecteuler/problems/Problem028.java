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

public class Problem028 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int distanceUntilNext = 1;
		int currentDistance = 1;
		int countAtCurrentDistance = 0;
		
		List<Integer> diagonalList = new ArrayList<Integer>();
		diagonalList.add(1);
		
		for(int i = 2; i <= (1001 * 1001); i++){
			if(currentDistance > 0){
				currentDistance--;
			}
			else{
				diagonalList.add(i);
				countAtCurrentDistance++;
				
				if(countAtCurrentDistance == 4){
					countAtCurrentDistance = 0;
					distanceUntilNext += 2;
				}
				currentDistance = distanceUntilNext;
			}
		}
		int sum = 0;
		for(int i : diagonalList){
			sum += i;
		}
		System.out.println(sum);
	}	
}
