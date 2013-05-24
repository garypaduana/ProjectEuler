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

public class Problem044 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Integer> pentNums = new ArrayList<Integer>();
				
		for(int i = 1; i < 6000; i++){
			pentNums.add(i * (3 * i - 1) / 2);
		}

		for(int distance = 1; distance < pentNums.size(); distance++){
			for(int i = 1; i < pentNums.size(); i++){
				// look "distance" forward and back
				if(i + distance > pentNums.size() - 1){
					continue;
				}
				if(pentNums.contains(pentNums.get(i) + pentNums.get(i + distance))){
					if(pentNums.contains(Math.abs(pentNums.get(i) - pentNums.get(i + distance)))){
						System.out.println("position difference: " + distance + ", " + pentNums.get(i) + " - " + pentNums.get(i + distance) + " = " + (pentNums.get(i) - pentNums.get(i + distance)));
					}
				}
			}
		}
	}

}
