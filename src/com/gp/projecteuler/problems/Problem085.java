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
import java.util.Map;
import java.util.TreeMap;

import com.gp.projecteuler.FileUtil;

/**
	By counting carefully it can be seen that a rectangular grid measuring
	3 by 2 contains eighteen rectangles:
	
		(image available at: https://projecteuler.net/problem=85)
		
	Although there exists no rectangular grid that contains exactly two 
	million rectangles, find the area of the grid with the nearest solution.
 */
public class Problem085 {

	public static void main(String[] args) throws IOException {
		int maxXSize = 130;
		int maxYSize = 130;
		int smallestDifference = Integer.MAX_VALUE;
		
		// Changes the size of the outer rectangle
		for(int xSize = 1; xSize <= maxXSize; xSize++){
			for(int ySize = 1; ySize <= maxYSize; ySize++){
				int rectangleSum = 0;
				
				// Changes the start point
				for(int xPos = 1; xPos <= xSize; xPos++){
					for(int yPos = 1; yPos <= ySize; yPos++){
					
						// Counts rectangles in this specific area 
						for(int x = xPos; x <= xSize; x++){
							for(int y = yPos; y <= ySize; y++){
								rectangleSum++;
							}
						}
					}
				}
				
				int difference = Math.abs(2000000 - (rectangleSum));
				
				if(difference < smallestDifference){
					smallestDifference = difference;
					System.out.println("Size (best answer so far): " +
						(xSize * ySize)	+ ", difference: " + smallestDifference);
				}
			}
		}
	}
}
