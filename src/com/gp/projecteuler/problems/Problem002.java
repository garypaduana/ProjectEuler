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

public class Problem002 {

	/**
	 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. 
	 * By starting with 1 and 2, the first 10 terms will be:
	 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
	 * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
	 * find the sum of the even-valued terms.
	 * 
	 * @author gary.paduana
	 */
	public static void main(String[] args) {
		int limit = 4000000;
		int sum = 2;
		List<Integer> fibList = new ArrayList<Integer>();
		fibList.add(1);
		fibList.add(2);
		
		while(true){
			int value = fibList.get(fibList.size() - 1) + fibList.get(fibList.size() - 2);
			if(value <= limit){
				fibList.add(value);
				if(value % 2 == 0){
					sum += value;
				}
			}
			else{
				break;
			}
		}
		System.out.println(sum);
	}
}