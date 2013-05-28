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
	Take the number 192 and multiply it by each of 1, 2, and 3:
	
	192 * 1 = 192
	192 * 2 = 384
	192 * 3 = 576
	
	By concatenating each product we get the 1 to 9 pandigital, 192384576.
	We will call 192384576 the concatenated product of 192 and (1,2,3)
	
	The same can be achieved by starting with 9 and multiplying by 
	1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the 
	concatenated product of 9 and (1,2,3,4,5).
	
	What is the largest 1 to 9 pandigital 9-digit number that can be formed 
	as the concatenated product of an integer with (1,2, ... , n) where n > 1?
 */
public class Problem038 {

	public static void main(String[] args) {
		
		int max = 0;
		for(int num = 1; num < 10000; num++){
			
			for(int i = 0; i <= 9; i++){
				List<Integer> productList = new ArrayList<Integer>();
				for(int n = 1; n <= i; n++){
					productList.add(num * n);
				}
				
				if(CommonMath.isPandigital(productList, 1, 9)){
					if(Integer.valueOf(CommonMath.concat(productList)) > max){
						max = Integer.valueOf(CommonMath.concat(productList));
					}
				}
			}
		}
		System.out.println("Answer: " + max);
	}
}
