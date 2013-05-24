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


public class Problem039 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int maxP = 0;
		int maxCount = 0;
		
		for(int p = 1; p <= 1000; p++){
			int count = 0;
			for(int a = 1; a < (p/2); a++){
				for(int b = (p - a); b > 0; b--){
					
					if((a * a + b * b) == ((p - a - b) * (p - a - b))){
						System.out.println("p: " + p + ", a;b;c : " + a + ";" + b + ";" + (p - a - b));
						count++;
					}
				}
			}
			
			if(count > maxCount){
				maxCount = count;
				maxP = p;
			}
		}
		
		System.out.println(maxP);
	}

}
