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

public class Problem038 {

	/**
	 * @param args
	 */
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
		System.out.println(max);
		
	}
	
	

}
