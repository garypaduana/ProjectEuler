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

public class Problem045 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Long> pentagonal = new ArrayList<Long>();
		List<Long> hexagonal = new ArrayList<Long>();
		
		List<Long> union = new ArrayList<Long>();
		
		long i = 0;
		while(union.size() <= 3){
			long hex = i * (2 * i - 1);
			hexagonal.add(hex);
			
			long pent = i * (3 * i - 1) / 2;
			pentagonal.add(pent);
			
			long tri = i * (i + 1) / 2;

			if(pentagonal.contains(tri) && hexagonal.contains(tri)){
				union.add(tri);
				System.out.println(tri);
			}
			i++;
		}
	}
}
