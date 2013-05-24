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

public class Problem030 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Integer> special = new ArrayList<Integer>();
		
		for(int i = 0; i < 10000000; i++){
			String str = Integer.toString(i);
			char[] digits = str.toCharArray();
			long sum = 0;
			for(char c : digits){
				sum += Math.pow(Integer.valueOf(String.valueOf(c)), 5);
			}
			
			if(sum == i && i != 1){
				special.add(i);
			}
		}
		
		System.out.println(CommonMath.sumListOfNumber(special));
	}
}
