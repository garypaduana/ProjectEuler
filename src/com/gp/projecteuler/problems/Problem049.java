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

import java.util.List;

import com.gp.projecteuler.CommonMath;

public class Problem049 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for(int i = 1000; i <= 9999; i++){
			if(!CommonMath.isPrime(i) || !CommonMath.isPrime(i + 3330) ||
				!CommonMath.isPrime(i + 2 * 3330)){
				continue;
			}
			
			List<String> perms = CommonMath.permutation(Integer.toString(i));
			if(perms.contains(Integer.toString(i + 3330)) &&
				perms.contains(Integer.toString(i + 2 * 3330))){
				System.out.println(i + "" + (i + 3330) + "" + (i + 2 * 3330));
			}
			
		}
	}

}
