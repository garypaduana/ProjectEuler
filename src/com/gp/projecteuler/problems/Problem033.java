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

import com.gp.projecteuler.CommonMath;

public class Problem033 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for(int num = 10; num <= 98; num++){
			for(int denom = num + 1; denom <= 99; denom++){
				int ans = CommonMath.containsCommonNumber(num, denom);
				if(ans >= 1){
					int numR = Integer.valueOf(Integer.toString(num).replaceAll(Integer.toString(ans), ""));
					int denomR = Integer.valueOf(Integer.toString(denom).replaceAll(Integer.toString(ans), ""));
					
					if(denomR != 0){
						if(((double)num / (double)denom) == ((double)numR / (double)denomR)){
							System.out.println(ans + "   " + num + "/" + denom + "    " + numR + "/" + denomR);
						}
					}					
				}
			}
		}
	}
}
