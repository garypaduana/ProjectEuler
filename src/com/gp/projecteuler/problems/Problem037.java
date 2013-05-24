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

public class Problem037 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int sum = 0;
		outer:
		for(int i = 11; i < 1000000; i++){
			
			if(!CommonMath.isPrime(i)){
				continue;
			}
			
			String iStr = Integer.toString(i);
			// truncate right
			while(iStr.length() > 1){
				iStr = iStr.substring(0, iStr.length() - 1);
				if(!CommonMath.isPrime(Integer.valueOf(iStr))){
					continue outer;
				}
			}
			
			iStr = Integer.toString(i);
			// truncate left
			while(iStr.length() > 1){
				iStr = iStr.substring(1, iStr.length());
				if(!CommonMath.isPrime(Integer.valueOf(iStr))){
					continue outer;
				}
			}
			
			System.out.println(i);
			sum += i;
		}
		
		System.out.println("Sum: " + sum);
	}

}
